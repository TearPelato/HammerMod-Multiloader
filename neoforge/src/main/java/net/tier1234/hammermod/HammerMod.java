package net.tier1234.hammermod;


import net.minecraft.core.registries.BuiltInRegistries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.tier1234.hammermod.registries.ModItems;

@Mod(Constants.MOD_ID)
public class HammerMod {

    public HammerMod(IEventBus eventBus) {

        Constants.LOG.info("Hello NeoForge world!");
        CommonClass.init();

    }

    @SubscribeEvent
    public void registryEvent(RegisterEvent event) {
    event.register(BuiltInRegistries.ITEM.key(), helper -> ModItems.register());

    }
}