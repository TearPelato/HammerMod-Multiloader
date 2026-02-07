package net.tier1234.hammermod.event;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.state.BlockState;
import net.tier1234.hammermod.enchantment.ModEnchantments;
import net.tier1234.hammermod.enchantment.custom.DiggingEnchantmentEffect;
import net.tier1234.hammermod.enchantment.custom.ExcavatorEnchantmentEffect;
import net.tier1234.hammermod.enchantment.custom.VeinMinerEnchantmentEffect;
import net.tier1234.hammermod.item.custom.HammerItem;
import net.tier1234.hammermod.item.custom.HammerItem2x2;
import net.tier1234.hammermod.item.custom.HammerItem5x5;

import java.util.HashSet;
import java.util.Set;

public class FabricModEvents {

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    public static void init() {

        PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {

            if (!(player instanceof ServerPlayer serverPlayer)) return true;
            if (world.isClientSide()) return true;

            ItemStack mainHandItem = player.getMainHandItem();

            /* =======================
               HAMMER 3x3
               ======================= */
            if (mainHandItem.getItem() instanceof HammerItem hammer) {

                if (HARVESTED_BLOCKS.contains(pos)) return true;

                for (BlockPos targetPos :
                        HammerItem.getBlocksToBeDestroyed(1, pos, serverPlayer)) {

                    if (targetPos.equals(pos)) continue;

                    BlockState targetState = world.getBlockState(targetPos);
                    if (!hammer.isCorrectToolForDrops(mainHandItem, targetState)) continue;

                    HARVESTED_BLOCKS.add(targetPos);
                    serverPlayer.gameMode.destroyBlock(targetPos);
                    HARVESTED_BLOCKS.remove(targetPos);
                }
            }

            /* =======================
               HAMMER 2x2
               ======================= */
            if (mainHandItem.getItem() instanceof HammerItem2x2 hammer2x2) {

                if (HARVESTED_BLOCKS.contains(pos)) return true;

                for (BlockPos targetPos :
                        HammerItem2x2.getBlocksToBeDestroyed(pos, serverPlayer)) {

                    if (targetPos.equals(pos)) continue;

                    BlockState targetState = world.getBlockState(targetPos);
                    if (!hammer2x2.isCorrectToolForDrops(mainHandItem, targetState)) continue;

                    HARVESTED_BLOCKS.add(targetPos);
                    serverPlayer.gameMode.destroyBlock(targetPos);
                    HARVESTED_BLOCKS.remove(targetPos);
                }
            }

            /* =======================
               HAMMER 5x5
               ======================= */
            if (mainHandItem.getItem() instanceof HammerItem5x5 hammer5x5) {

                if (HARVESTED_BLOCKS.contains(pos)) return true;

                for (BlockPos targetPos :
                        HammerItem5x5.getBlocksToBeDestroyed(pos, serverPlayer)) {

                    if (targetPos.equals(pos)) continue;

                    BlockState targetState = world.getBlockState(targetPos);
                    if (targetState.isAir()) continue;
                    if (!hammer5x5.isCorrectToolForDrops(mainHandItem, targetState)) continue;

                    HARVESTED_BLOCKS.add(targetPos);
                    serverPlayer.gameMode.destroyBlock(targetPos);
                    HARVESTED_BLOCKS.remove(targetPos);
                }
            }

            /* =======================
               DIGGING ENCHANT
               ======================= */
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

            /* =======================
               EXCAVATOR ENCHANT
               ======================= */
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

            /* =======================
               VEIN MINER ENCHANT
               ======================= */
            var veinMinerHolder = world.registryAccess()
                    .registryOrThrow(Registries.ENCHANTMENT)
                    .getHolder(ModEnchantments.VEINMINER)
                    .orElse(null);

            if (veinMinerHolder != null) {
                int level = EnchantmentHelper.getItemEnchantmentLevel(veinMinerHolder, mainHandItem);
                if (level > 0) {
                    new VeinMinerEnchantmentEffect()
                            .apply((ServerLevel) world, level, null, serverPlayer, pos.getCenter());
                }
            }

            return true;
        });
    }
}
