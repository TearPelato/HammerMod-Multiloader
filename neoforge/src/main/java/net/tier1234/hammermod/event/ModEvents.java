package net.tier1234.hammermod.event;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.BlockEvent;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.enchantment.ModEnchantments;
import net.tier1234.hammermod.enchantment.custom.DiggingEnchantmentEffect;
import net.tier1234.hammermod.enchantment.custom.ExcavatorEnchantmentEffect;
import net.tier1234.hammermod.enchantment.custom.VeinMinerEnchantmentEffect;
import net.tier1234.hammermod.item.custom.HammerItem;
import net.tier1234.hammermod.item.custom.HammerItem2x2;
import net.tier1234.hammermod.item.custom.HammerItem5x5;

import java.util.HashSet;
import java.util.Set;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class ModEvents {
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
        if (level.isClientSide) return;

        ItemStack tool = player.getMainHandItem();
        var enchantmentHolder = level.registryAccess()
                .registryOrThrow(Registries.ENCHANTMENT)
                .getHolder(ModEnchantments.DIGGING)
                .orElse(null);

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
        if (level.isClientSide) return;

        ItemStack tool = player.getMainHandItem();
        var enchantmentHolder = level.registryAccess()
                .registryOrThrow(Registries.ENCHANTMENT)
                .getHolder(ModEnchantments.EXCAVATOR)
                .orElse(null);

        if (enchantmentHolder == null) return;

        int enchantLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantmentHolder, tool);
        if (enchantLevel <= 0) return;

        BlockPos pos = event.getPos();
        ExcavatorEnchantmentEffect effect = new ExcavatorEnchantmentEffect();
        effect.apply((ServerLevel) level, enchantLevel, null, player, pos.getCenter());
    }

    // TODO  @SubscribeEvent
//    public static void onBlockBreakAutoSmelt(BlockEvent.BreakEvent event) {
//        if (!(event.getPlayer() instanceof ServerPlayer player)) return;
//        Level level = player.level();
//        if (level.isClientSide) return;
//        ItemStack tool = player.getMainHandItem();
//        var enchantmentHolder = level.registryAccess()
//                .registryOrThrow(Registries.ENCHANTMENT)
//                .getHolder(ModEnchantments.AUTO_SMELT)
//                .orElse(null);
//        if (enchantmentHolder == null) return;
//        int enchantLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantmentHolder, tool);
//        if (enchantLevel <= 0) return
//        BlockPos pos = event.getPos();
//        AutoSmeltEnchantmentEffect effect = new AutoSmeltEnchantmentEffect();
//        effect.apply((ServerLevel) level, enchantLevel, null, player, pos.getCenter());
//    }


    @SubscribeEvent
    public static void onBlockBreakVeinMiner(BlockEvent.BreakEvent event) {
        if (!(event.getPlayer() instanceof ServerPlayer player)) return;

        Level level = player.level();
        if (level.isClientSide) return;

        ItemStack tool = player.getMainHandItem();

        // Recupera il riferimento all'enchantment registrato
        var enchantmentHolder = level.registryAccess()
                .registryOrThrow(Registries.ENCHANTMENT)
                .getHolder(ModEnchantments.VEINMINER)
                .orElse(null);

        if (enchantmentHolder == null) return;

        int enchantLevel = EnchantmentHelper.getItemEnchantmentLevel(enchantmentHolder, tool);
        if (enchantLevel <= 0) return;

        BlockPos pos = event.getPos();

        // Applica l'effetto
        VeinMinerEnchantmentEffect effect = new VeinMinerEnchantmentEffect();
        effect.apply((ServerLevel) level, enchantLevel, null, player, pos.getCenter());
    }

}
