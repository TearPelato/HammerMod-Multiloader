package net.tier1234.hammermod.platform;

import com.mrcrayfish.framework.Registration;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public CreativeModeTab.Builder getCreativeTabBuilder() {
        return FabricCreativeModeTab.builder();
    }

    @Override
    public void setupCreativeTabDisplayItems(CreativeModeTab.Builder builder)
    {
        builder.displayItems((params, output) -> {
            Registration.get(Registries.BLOCK).stream().filter(entry -> entry.getId().getNamespace().equals(Constants.MOD_ID)).forEach(entry -> {
                output.accept((ItemLike) entry.get());
            });
            Registration.get(Registries.ITEM).stream().filter(entry -> entry.getId().getNamespace().equals(Constants.MOD_ID)).forEach(entry -> {
                output.accept((ItemLike) entry.get());
            });
        });
    }

    @Override
    public void damageItemAutoSmelt(ItemStack tool, Player player) {
        tool.hurtAndBreak(1, player, player.getUsedItemHand() == InteractionHand.MAIN_HAND
                ? EquipmentSlot.MAINHAND
                : EquipmentSlot.OFFHAND);
    }
}
