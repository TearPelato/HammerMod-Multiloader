package net.tier1234.hammermod.datagen;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.tier1234.hammermod.Constants;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {

        event.createProvider(CommonRecipeProvider.Runner::new);
        event.createProvider(CommonBlockTagGen::new);
        event.createProvider(CommonItemTagProvider::new);
        event.createProvider(ModDatapackProvider::new);

    }
}