package net.tier1234.hammermod.platform.services;

import net.minecraft.world.item.CreativeModeTab;

public interface IPlatformHelper {


    String getPlatformName();

    boolean isModLoaded(String modId);

    boolean isDevelopmentEnvironment();

    default String getEnvironmentName() {

        return isDevelopmentEnvironment() ? "development" : "production";
    }

    CreativeModeTab.Builder getCreativeTabBuilder();

}