package net.tier1234.hammermod;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.tier1234.hammermod.client.render.Hammer2x2OverlayRenderer;
import net.tier1234.hammermod.client.render.Hammer5x5OverlayRenderer;
import net.tier1234.hammermod.client.render.HammerOverlayRenderer;

@Mod(value = Constants.MOD_ID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class HammerModClient {
    public HammerModClient(ModContainer container) {

    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {
        HammerOverlayRenderer.register();
        Hammer2x2OverlayRenderer.register();
        Hammer5x5OverlayRenderer.register();

    }
}