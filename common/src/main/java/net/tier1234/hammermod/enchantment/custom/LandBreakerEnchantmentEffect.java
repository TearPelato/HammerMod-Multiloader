package net.tier1234.hammermod.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.tier1234.hammermod.item.custom.HammerItem;
import net.tier1234.hammermod.item.custom.HammerItem2x2;
import net.tier1234.hammermod.item.custom.HammerItem5x5;

import java.util.List;

public class LandBreakerEnchantmentEffect implements EnchantmentEntityEffect {

    public static final MapCodec<LandBreakerEnchantmentEffect> CODEC =
            MapCodec.unit(LandBreakerEnchantmentEffect::new);
    @Override
    public void apply(ServerLevel serverLevel,
                      int enchantmentLevel,
                      EnchantedItemInUse enchantedItemInUse,
                      Entity entity,
                      Vec3 vec3) {

        if (!(entity instanceof ServerPlayer player)) return;

        BlockPos startPos = BlockPos.containing(vec3);
        BlockState startState = serverLevel.getBlockState(startPos);

        if (startState.isAir()) return;
        if (!isLandBlock(startState)) return;

        ItemStack tool = player.getMainHandItem();
        if (!(tool.getItem() instanceof HammerItem ||
                tool.getItem() instanceof HammerItem2x2 ||
                tool.getItem() instanceof HammerItem5x5)) return;

        // Recupera l'area già calcolata dall'hammer corrispondente
        List<BlockPos> area = getHammerArea(tool, startPos, player);

        for (BlockPos pos : area) {
            if (pos.equals(startPos)) continue;

            BlockState state = serverLevel.getBlockState(pos);
            if (state.isAir()) continue;
            if (!isLandBlock(state)) continue; // rompe solo blocchi "terra" nell'area

            serverLevel.destroyBlock(pos, true, player);
        }
    }

    private static boolean isLandBlock(BlockState state) {
        return state.is(BlockTags.DIRT)
                || state.is(BlockTags.SAND)
                || state.is(BlockTags.SNIFFER_EGG_HATCH_BOOST)
                || state.is(Blocks.GRAVEL)
                || state.is(Blocks.CLAY)
                || state.is(Blocks.MUD)
                || state.is(Blocks.MUDDY_MANGROVE_ROOTS)
                || state.is(Blocks.GRASS_BLOCK)
                || state.is(Blocks.PODZOL)
                || state.is(Blocks.MYCELIUM)
                || state.is(Blocks.FARMLAND)
                || state.is(Blocks.DIRT_PATH)
                || state.is(BlockTags.LEAVES)
                || state.is(BlockTags.LOGS);
    }

    private static List<BlockPos> getHammerArea(ItemStack tool, BlockPos pos, ServerPlayer player) {
        if (tool.getItem() instanceof HammerItem) {
            return HammerItem.getBlocksToBeDestroyed(1, pos, player);
        } else if (tool.getItem() instanceof HammerItem2x2) {
            return HammerItem2x2.getBlocksToBeDestroyed(pos, player);
        } else if (tool.getItem() instanceof HammerItem5x5) {
            return HammerItem5x5.getBlocksToBeDestroyed(pos, player);
        }
        return List.of();
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec() {
        return CODEC;
    }
}