package net.tier1234.hammermod.event;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LevelEvent;
import net.minecraft.world.level.block.state.BlockState;
import net.tier1234.hammermod.Config;
import net.tier1234.hammermod.enchantment.custom.AutoSmeltEnchantmentEffect;
import net.tier1234.hammermod.enchantment.custom.DiggingEnchantmentEffect;
import net.tier1234.hammermod.enchantment.custom.ExcavatorEnchantmentEffect;
import net.tier1234.hammermod.item.custom.HammerItem;
import net.tier1234.hammermod.item.custom.HammerItem2x2;
import net.tier1234.hammermod.item.custom.HammerItem5x5;
import net.tier1234.hammermod.registries.ModEnchantments;

import java.util.*;

public class FabricModEvents {
    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    public static void init() {
        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {
            if (!(player instanceof ServerPlayer serverPlayer)) return true;
            if (world.isClientSide()) return true;

            ItemStack mainHandItem = player.getMainHandItem();

            // ============ HAMMER ITEMS ============
            if (mainHandItem.getItem() instanceof HammerItem hammer) {
                if (HARVESTED_BLOCKS.contains(pos)) return true;

                for (BlockPos targetPos : HammerItem.getBlocksToBeDestroyed(1, pos, serverPlayer)) {
                    if (targetPos.equals(pos)) continue;

                    BlockState targetState = world.getBlockState(targetPos);
                    if (!hammer.isCorrectToolForDrops(mainHandItem, targetState)) continue;

                    HARVESTED_BLOCKS.add(targetPos);
                    serverPlayer.gameMode.destroyBlock(targetPos);
                    HARVESTED_BLOCKS.remove(targetPos);
                }
            }

            if (mainHandItem.getItem() instanceof HammerItem2x2 hammer2x2) {
                if (HARVESTED_BLOCKS.contains(pos)) return true;

                for (BlockPos targetPos : HammerItem2x2.getBlocksToBeDestroyed(pos, serverPlayer)) {
                    if (targetPos.equals(pos)) continue;

                    BlockState targetState = world.getBlockState(targetPos);
                    if (!hammer2x2.isCorrectToolForDrops(mainHandItem, targetState)) continue;

                    HARVESTED_BLOCKS.add(targetPos);
                    serverPlayer.gameMode.destroyBlock(targetPos);
                    HARVESTED_BLOCKS.remove(targetPos);
                }
            }

            if (mainHandItem.getItem() instanceof HammerItem5x5 hammer5x5) {
                if (HARVESTED_BLOCKS.contains(pos)) return true;

                for (BlockPos targetPos : HammerItem5x5.getBlocksToBeDestroyed(pos, serverPlayer)) {
                    if (targetPos.equals(pos)) continue;

                    BlockState targetState = world.getBlockState(targetPos);
                    if (targetState.isAir()) continue;
                    if (!hammer5x5.isCorrectToolForDrops(mainHandItem, targetState)) continue;

                    HARVESTED_BLOCKS.add(targetPos);
                    serverPlayer.gameMode.destroyBlock(targetPos);
                    HARVESTED_BLOCKS.remove(targetPos);
                }
            }

            // ============ VEINMINER ENCHANTMENT - GESTITO DIRETTAMENTE ============
            var veinMinerHolder = world.registryAccess()
                    .registryOrThrow(Registries.ENCHANTMENT)
                    .getHolder(ModEnchantments.VEINMINER)
                    .orElse(null);

            if (veinMinerHolder != null) {
                int level = EnchantmentHelper.getItemEnchantmentLevel(veinMinerHolder, mainHandItem);
                if (level > 0 && !HARVESTED_BLOCKS.contains(pos)) {
                    BlockState targetState = world.getBlockState(pos);
                    Block targetBlock = targetState.getBlock();

                    if (!targetState.isAir() && targetState.getDestroySpeed(world, pos) >= 0) {
                        int maxBlocks = Config.CLIENT.veinminerRange.get();

                        Queue<BlockPos> queue = new ArrayDeque<>();
                        Set<BlockPos> visited = new HashSet<>();

                        queue.add(pos);
                        visited.add(pos);

                        int broken = 0;

                        while (!queue.isEmpty() && broken < maxBlocks) {
                            BlockPos current = queue.poll();
                            BlockState currentState = world.getBlockState(current);

                            if (currentState.getBlock() != targetBlock) continue;

                            if (!current.equals(pos)) {
                                HARVESTED_BLOCKS.add(current);
                                serverPlayer.gameMode.destroyBlock(current);
                                HARVESTED_BLOCKS.remove(current);
                                broken++;
                            }

                            for (Direction dir : Direction.values()) {
                                BlockPos next = current.relative(dir);
                                if (visited.contains(next)) continue;

                                BlockState nextState = world.getBlockState(next);
                                if (nextState.getBlock() == targetBlock) {
                                    visited.add(next);
                                    queue.add(next);
                                }
                            }
                        }
                    }
                }
            }

            // ============ DIGGING ENCHANTMENT ============
            var diggingHolder = world.registryAccess()
                    .registryOrThrow(Registries.ENCHANTMENT)
                    .getHolder(ModEnchantments.DIGGING)
                    .orElse(null);

            if (diggingHolder != null) {
                int level = EnchantmentHelper.getItemEnchantmentLevel(diggingHolder, mainHandItem);
                if (level > 0) {
                    new DiggingEnchantmentEffect()
                            .apply((ServerLevel) world, level, null, serverPlayer, pos.getCenter());
                }
            }

            // ============ EXCAVATOR ENCHANTMENT ============
            var excavatorHolder = world.registryAccess()
                    .registryOrThrow(Registries.ENCHANTMENT)
                    .getHolder(ModEnchantments.EXCAVATOR)
                    .orElse(null);

            if (excavatorHolder != null) {
                int level = EnchantmentHelper.getItemEnchantmentLevel(excavatorHolder, mainHandItem);
                if (level > 0) {
                    new ExcavatorEnchantmentEffect()
                            .apply((ServerLevel) world, level, null, serverPlayer, pos.getCenter());
                }
            }

            // ============ AUTOSMELT ENCHANTMENT ============
            var autosmeltHolder = world.registryAccess()
                    .registryOrThrow(Registries.ENCHANTMENT)
                    .getHolder(ModEnchantments.AUTOSMELT)
                    .orElse(null);

            if (autosmeltHolder != null) {
                int level = EnchantmentHelper.getItemEnchantmentLevel(autosmeltHolder, mainHandItem);
                if (level > 0) {
                    BlockState currentState = world.getBlockState(pos);

                    if (!currentState.isAir() && currentState.getDestroySpeed(world, pos) >= 0) {
                        List<ItemStack> drops = Block.getDrops(
                                currentState,
                                (ServerLevel) world,
                                pos,
                                blockEntity,
                                serverPlayer,
                                mainHandItem
                        );

                        if (!drops.isEmpty()) {
                            List<ItemStack> finalDrops = new ArrayList<>();
                            AutoSmeltEnchantmentEffect autosmeltEffect = new AutoSmeltEnchantmentEffect();

                            for (ItemStack drop : drops) {
                                ItemStack smelted = autosmeltEffect.trySmeltBlock(
                                        (ServerLevel) world,
                                        currentState,
                                        mainHandItem,
                                        blockEntity,
                                        player
                                );
                                if (!smelted.isEmpty()) {
                                    finalDrops.add(smelted);
                                }
                            }

                            if (!finalDrops.isEmpty()) {
                                world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                                world.levelEvent(LevelEvent.PARTICLES_DESTROY_BLOCK, pos, Block.getId(currentState));

                                for (ItemStack toDrop : finalDrops) {
                                    Block.popResource((ServerLevel) world, pos, toDrop);
                                }

                                return false;
                            }
                        }
                    }
                }
            }

            return true;
        });
    }
}