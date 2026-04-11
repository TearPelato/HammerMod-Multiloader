package net.tier1234.hammermod.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.enchantment.custom.*;
import net.tier1234.hammermod.item.custom.HammerItem;
import net.tier1234.hammermod.item.custom.HammerItem2x2;
import net.tier1234.hammermod.item.custom.HammerItem5x5;
import net.tier1234.hammermod.registries.ModEnchantments;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class NeoForgeModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    // Done with the help of https://github.com/CoFH/CoFHCore/blob/1.19.x/src/main/java/cofh/core/event/AreaEffectEvents.java
    // Don't be a jerk License
    @SubscribeEvent
    public static void onHammerUsage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if(mainHandItem.getItem() instanceof HammerItem hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();
            if(HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            for(BlockPos pos : HammerItem.getBlocksToBeDestroyed(1, initialBlockPos, serverPlayer)) {
                if(pos == initialBlockPos || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }
    @SubscribeEvent
    public static void onHammer2x2Usage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        // Check if player is using a HammerItem and is a ServerPlayer
        if (mainHandItem.getItem() instanceof HammerItem2x2 hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();

            // Prevent re-processing the same block
            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            // Get 2x2 block area based on the face the player hit
            for (BlockPos pos : HammerItem2x2.getBlocksToBeDestroyed(initialBlockPos, serverPlayer)) {
                // Skip the original block (already broken) or blocks the hammer can't harvest
                if (pos.equals(initialBlockPos) || !hammer.isCorrectToolForDrops(mainHandItem, event.getLevel().getBlockState(pos))) {
                    continue;
                }

                // Prevent recursive event triggering
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }
    @SubscribeEvent
    public static void onHammer5x5Usage(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        ItemStack mainHandItem = player.getMainHandItem();

        if (mainHandItem.getItem() instanceof HammerItem5x5 hammer && player instanceof ServerPlayer serverPlayer) {
            BlockPos initialBlockPos = event.getPos();

            if (HARVESTED_BLOCKS.contains(initialBlockPos)) {
                return;
            }

            // Use range 2 for a 5x5 area
            for (BlockPos pos : HammerItem5x5.getBlocksToBeDestroyed(initialBlockPos, serverPlayer)) {
                // Skip the original block (already being broken by the event)
                if (pos.equals(initialBlockPos)) {
                    continue;
                }

                // Skip if not correct tool or block cannot be broken
                BlockState state = event.getLevel().getBlockState(pos);
                if (!hammer.isCorrectToolForDrops(mainHandItem, state) || state.isAir()) {
                    continue;
                }

                // Prevent recursion
                HARVESTED_BLOCKS.add(pos);
                serverPlayer.gameMode.destroyBlock(pos);
                HARVESTED_BLOCKS.remove(pos);
            }
        }
    }

    @SubscribeEvent
    public static void onBlockBreakDigging(BlockEvent.BreakEvent event) {
        if (!(event.getPlayer() instanceof ServerPlayer player)) return;

        Level level = player.level();
        if (level.isClientSide()) return;

        ItemStack tool = player.getMainHandItem();
        Registry<Enchantment> enchantmentRegistry = level.registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT);
        Holder<Enchantment> enchantmentHolder = enchantmentRegistry.getOrThrow(ModEnchantments.DIGGING);


        if (enchantmentHolder == null) return;

        int enchantLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantmentHolder, tool);
        if (enchantLevel <= 0) return;

        BlockPos pos = event.getPos();
        DiggingEnchantmentEffect effect = new DiggingEnchantmentEffect();
        effect.apply((ServerLevel) level, enchantLevel, null, player, pos.getCenter());
    }

    @SubscribeEvent
    public static void onBlockBreakExcavator(BlockEvent.BreakEvent event) {
        if (!(event.getPlayer() instanceof ServerPlayer player)) return;

        Level level = player.level();
        if (level.isClientSide()) return;

        ItemStack tool = player.getMainHandItem();
        Registry<Enchantment> enchantmentRegistry = level.registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT);
        Holder<Enchantment> enchantmentHolder = enchantmentRegistry.getOrThrow(ModEnchantments.EXCAVATOR);


        if (enchantmentHolder == null) return;

        int enchantLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantmentHolder, tool);
        if (enchantLevel <= 0) return;

        BlockPos pos = event.getPos();
        ExcavatorEnchantmentEffect effect = new ExcavatorEnchantmentEffect();
        effect.apply((ServerLevel) level, enchantLevel, null, player, pos.getCenter());
    }


    @SubscribeEvent
    public static void onBlockBreakVeinMiner(BlockEvent.BreakEvent event) {
        if (!(event.getPlayer() instanceof ServerPlayer player)) return;

        Level level = player.level();
        if (level.isClientSide()) return;

        ItemStack tool = player.getMainHandItem();

        Registry<Enchantment> enchantmentRegistry = level.registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT);
        Holder<Enchantment> enchantmentHolder = enchantmentRegistry.getOrThrow(ModEnchantments.VEINMINER);


        if (enchantmentHolder == null) return;

        int enchantLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantmentHolder, tool);
        if (enchantLevel <= 0) return;

        BlockPos pos = event.getPos();

        // Applica l'effetto
        VeinMinerEnchantmentEffect effect = new VeinMinerEnchantmentEffect();
        effect.apply((ServerLevel) level, enchantLevel, null, player, pos.getCenter());
    }

    @SubscribeEvent
    public static void onBlockBreakAutoSmelt(BlockEvent.BreakEvent event) {
        Player player = event.getPlayer();
        if (player == null || player.level().isClientSide()) return;

        ServerPlayer serverPlayer = (ServerPlayer) player;
        ServerLevel level = (ServerLevel) event.getLevel();

        ItemStack tool = serverPlayer.getMainHandItem();

        Registry<Enchantment> enchantmentRegistry = level.registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT);
        Holder<Enchantment> enchantHolder = enchantmentRegistry.getOrThrow(ModEnchantments.AUTOSMELT);


        if (enchantHolder == null) return;

        int level2 = EnchantmentHelper.getTagEnchantmentLevel(enchantHolder, tool);
        if (level2 <= 0) return;


        BlockPos pos = event.getPos();
        BlockState state = event.getState();

        if (state.isAir() || state.getDestroySpeed(level, pos) < 0) return;


        BlockEntity blockEntity = level.getBlockEntity(pos);

        List<ItemStack> drops = Block.getDrops(
                state,
                level,
                pos,
                blockEntity,
                serverPlayer,
                tool
        );

        if (drops.isEmpty()) return;

        List<ItemStack> finalDrops = new ArrayList<>();

        AutoSmeltEnchantmentEffect autosmeltEffect = new AutoSmeltEnchantmentEffect();

        for (ItemStack drop : drops) {
            ItemStack smelted = autosmeltEffect.trySmeltBlock(level, state, tool, blockEntity, player);
            if (!smelted.isEmpty()) {
                finalDrops.add(smelted);
            }
        }

        for (ItemStack toDrop : finalDrops) {
            Block.popResource(level, pos, toDrop);
        }

        level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
        level.levelEvent(LevelEvent.PARTICLES_DESTROY_BLOCK, pos, Block.getId(state));

    }
    @SubscribeEvent
    public static void onBlockBreakLandBreaker(BlockEvent.BreakEvent event) {
        if (!(event.getPlayer() instanceof ServerPlayer player)) return;

        Level level = player.level();
        if (level.isClientSide()) return;

        ItemStack tool = player.getMainHandItem();
        if (!(tool.getItem() instanceof HammerItem) &&
                !(tool.getItem() instanceof HammerItem2x2) &&
                !(tool.getItem() instanceof HammerItem5x5)) return;

        Registry<Enchantment> enchantmentRegistry = level.registryAccess()
                .lookupOrThrow(Registries.ENCHANTMENT);
        Holder<Enchantment> enchantmentHolder = enchantmentRegistry.getOrThrow(ModEnchantments.LAND_BREAKER);

        if (enchantmentHolder == null) return;

        int enchantLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantmentHolder, tool);
        if (enchantLevel <= 0) return;

        BlockPos pos = event.getPos();
        LandBreakerEnchantmentEffect effect = new LandBreakerEnchantmentEffect();
        effect.apply((ServerLevel) level, enchantLevel, null, player, pos.getCenter());
    }

}
