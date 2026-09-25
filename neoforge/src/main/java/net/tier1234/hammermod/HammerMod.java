package net.tier1234.hammermod;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.hammermod.registries.ModCreativeTabs;
import net.tier1234.hammermod.registries.ModEnchantmentEffects;
import net.tier1234.hammermod.registries.ModItems;

@Mod(Constants.MOD_ID)
public class HammerMod {

    public HammerMod(IEventBus eventBus) {
        ModCreativeTabs.init();
        ModItems.init();
        eventBus.register(this);
        ModEnchantmentEffects.register(eventBus);
        Config.init();

    }

    @SubscribeEvent
    public void registryEvent(RegisterEvent event) {
        ObjectRegistries.createAll(Constants.MOD_ID, event.getRegistry());
    }
}