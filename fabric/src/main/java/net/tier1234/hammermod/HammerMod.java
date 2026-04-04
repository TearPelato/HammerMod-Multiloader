package net.tier1234.hammermod;

import com.mrcrayfish.framework.FrameworkSetup;
import net.fabricmc.api.ModInitializer;
import net.tier1234.hammermod.event.FabricModEvents;
import net.tier1234.hammermod.registries.ModEnchantmentEffects;

public class HammerMod implements ModInitializer {

    @Override
    public void onInitialize() {
        FrameworkSetup.run();
        FabricModEvents.init();
        ModEnchantmentEffects.register();
    }
}
