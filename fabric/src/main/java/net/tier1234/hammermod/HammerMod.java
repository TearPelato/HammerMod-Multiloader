package net.tier1234.hammermod;

import net.fabricmc.api.ModInitializer;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.hammermod.event.FabricModEvents;
import net.tier1234.hammermod.registries.ModCreativeTabs;
import net.tier1234.hammermod.registries.ModEnchantmentEffects;
import net.tier1234.hammermod.registries.ModItems;

public class HammerMod implements ModInitializer {

    @Override
    public void onInitialize() {
        ModCreativeTabs.init();
        ModItems.init();
        ObjectRegistries.createAll(Constants.MOD_ID);
        FabricModEvents.init();
        ModEnchantmentEffects.register();
        Config.init();
    }
}
