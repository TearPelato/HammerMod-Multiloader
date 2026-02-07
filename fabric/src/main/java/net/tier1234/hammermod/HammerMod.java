package net.tier1234.hammermod;

import net.fabricmc.api.ModInitializer;
import net.tier1234.hammermod.enchantment.ModEnchantmentEffects;
import net.tier1234.hammermod.event.FabricModEvents;

public class HammerMod implements ModInitializer {

    @Override
    public void onInitialize() {
        FabricModEvents.init();
        ModEnchantmentEffects.init();
    }
}
