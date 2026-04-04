package net.tier1234.hammermod;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.tier1234.hammermod.registries.ModEnchantmentEffects;

@Mod(Constants.MOD_ID)
public class HammerMod {

    public HammerMod(IEventBus eventBus) {
        eventBus.register(this);
        ModEnchantmentEffects.register(eventBus);

    }

    @SubscribeEvent
    public void registryEvent(RegisterEvent event) {

    }
}