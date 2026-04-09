package net.tier1234.hammermod;

import net.fabricmc.api.ClientModInitializer;
import net.tier1234.hammermod.client.render.Hammer2x2OverlayRenderer;
import net.tier1234.hammermod.client.render.Hammer5x5OverlayRenderer;
import net.tier1234.hammermod.client.render.HammerOverlayRenderer;

public class HammerModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Hammer2x2OverlayRenderer.register();
        HammerOverlayRenderer.register();
        Hammer5x5OverlayRenderer.register();

    }
}
