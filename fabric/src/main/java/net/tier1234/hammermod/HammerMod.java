package net.tier1234.hammermod;

import net.fabricmc.api.ModInitializer;
import net.tier1234.hammermod.registries.ModItems;

public class HammerMod implements ModInitializer {
    
    @Override
    public void onInitialize() {

        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();
        ModItems.register();
    }
}
