package net.tier1234.hammermod.platform.services;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public interface IPlatformHelper {


    String getPlatformName();

    boolean isModLoaded(String modId);

    boolean isDevelopmentEnvironment();

    default String getEnvironmentName() {

        return isDevelopmentEnvironment() ? "development" : "production";
    }

    CreativeModeTab.Builder getCreativeTabBuilder();
    void setupCreativeTabDisplayItems(CreativeModeTab.Builder builder);
    void damageItemAutoSmelt(ItemStack tool, Player player);
}