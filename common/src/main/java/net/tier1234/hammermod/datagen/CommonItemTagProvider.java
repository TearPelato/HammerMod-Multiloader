package net.tier1234.hammermod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.tier1234.hammermod.registries.ModItems;
import net.tier1234.hammermod.util.ModTags;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public class CommonItemTagProvider extends IntrinsicHolderTagsProvider<Item> {
    public CommonItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture)
    {
        super(output, Registries.ITEM, completableFuture, block -> block.builtInRegistryHolder().key());
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        this.tag(ModTags.Items.COPPER_REPAIRABLE)
                .add(Items.COPPER_INGOT);

        this.tag(ModTags.Items.AMETHYST_REPAIRABLE)
                .add(Items.AMETHYST_SHARD);

        this.tag(ModTags.Items.HAMMERS)
                .add(ModItems.STONE_HAMMER.get(), ModItems.COPPER_HAMMER.get(), ModItems.IRON_HAMMER.get(),
                        ModItems.GOLD_HAMMER.get(), ModItems.DIAMOND_HAMMER.get(), ModItems.NETHERITE_HAMMER.get(),
                        ModItems.AMETHYST_HAMMER.get());
    }
}
