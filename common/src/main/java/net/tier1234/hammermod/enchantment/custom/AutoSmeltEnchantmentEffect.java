package net.tier1234.hammermod.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.tier1234.hammermod.enchantment.custom.helper.AutoSmeltHelper;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AutoSmeltEnchantmentEffect implements EnchantmentEntityEffect {
    public static final MapCodec<AutoSmeltEnchantmentEffect> CODEC =
            MapCodec.unit(AutoSmeltEnchantmentEffect::new);

    @Override
    public void apply(
            ServerLevel level,
            int enchantmentLevel,
            EnchantedItemInUse itemInUse,
            Entity entity,
            Vec3 origin
    ) {
        if (enchantmentLevel <= 0 || level.isClientSide()) return;

        if (!(entity instanceof Player player)) return;

        ItemStack tool = itemInUse.itemStack();

        Registry<Enchantment> enchantmentRegistry = level.registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT);
        Holder<Enchantment> silkTouchHolder = enchantmentRegistry.getOrThrow(Enchantments.SILK_TOUCH);

        if (EnchantmentHelper.getItemEnchantmentLevel(silkTouchHolder, tool) > 0) {
            return;
        }

        BlockPos pos = BlockPos.containing(origin);
        BlockState state = level.getBlockState(pos);
        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (state.isAir() || state.getDestroySpeed(level, pos) < 0) {
            return;
        }

        List<ItemStack> possibleDrops = Block.getDrops(
                state,
                level,
                pos,
                blockEntity,
                player,
                tool
        );

        if (possibleDrops.isEmpty()) {
            return;
        }

        List<ItemStack> finalDrops = new ArrayList<>();
        for (ItemStack drop : possibleDrops) {
            ItemStack smelted = trySmeltBlock(level, state, tool, blockEntity, player);
            finalDrops.add(smelted.isEmpty() ? drop.copy() : smelted);
        }

        for (ItemStack toDrop : finalDrops) {
            if (!toDrop.isEmpty()) {
                Block.popResource(level, pos, toDrop);
            }
        }

        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        level.levelEvent(LevelEvent.PARTICLES_DESTROY_BLOCK, pos, Block.getId(state));

        AutoSmeltHelper.damageItem(tool, player);
    }

    public ItemStack trySmeltBlock(ServerLevel level, BlockState state, ItemStack tool,
                                   @Nullable BlockEntity blockEntity, Player player) {
        SingleRecipeInput recipeInput = new SingleRecipeInput(state.getBlock().asItem().getDefaultInstance());

        var recipeOpt = level.recipeAccess()
                .getRecipeFor(RecipeType.SMELTING, recipeInput, level);

        if (recipeOpt.isPresent()) {
            var recipe = recipeOpt.get().value();

            ItemStack smeltResult = recipe.assemble(recipeInput);

            Item itemOfBlock = state.getBlock().asItem();
            List<ItemStack> normalDrops = Block.getDrops(state, level, BlockPos.containing(0,0,0), blockEntity, player, tool);

            int dropCount = normalDrops.stream()
                    .filter(d -> d.is(itemOfBlock))
                    .mapToInt(ItemStack::getCount)
                    .sum();

            if (dropCount > 0) {
                smeltResult.setCount(smeltResult.getCount() * dropCount);
            }

            return smeltResult;
        }

        return ItemStack.EMPTY;
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}