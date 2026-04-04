package net.tier1234.hammermod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.tier1234.hammermod.registries.ModItems;
import net.tier1234.hammermod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        getOrCreateTagBuilder(ModTags.Items.COPPER_REPAIRABLE)
                .add(Items.COPPER_INGOT);

        getOrCreateTagBuilder(ModTags.Items.AMETHYST_REPAIRABLE)
                .add(Items.AMETHYST_SHARD);

        getOrCreateTagBuilder(ModTags.Items.HAMMERS)
                .add(ModItems.STONE_HAMMER.get(), ModItems.COPPER_HAMMER.get(), ModItems.IRON_HAMMER.get(),
                        ModItems.GOLD_HAMMER.get(), ModItems.DIAMOND_HAMMER.get(), ModItems.NETHERITE_HAMMER.get(),
                        ModItems.AMETHYST_HAMMER.get());

               /* .add(ModItems.TINY_STONE_HAMMER.get(), ModItems.TINY_COPPER_HAMMER.get(),)

                .add(ModItems.GIANT_STONE_HAMMER.get(), ModItems.GIANT_COPPER_HAMMER.get(), );*/
    }
}