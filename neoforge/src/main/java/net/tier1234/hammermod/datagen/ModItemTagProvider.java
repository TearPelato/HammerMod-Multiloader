package net.tier1234.hammermod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.registries.ModItems;
import net.tier1234.hammermod.util.ModTags;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, Constants.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Items.COPPER_REPAIRABLE)
                .add(Items.COPPER_INGOT.asItem());
        this.tag(ModTags.Items.AMETHYST_REPAIRABLE)
                .add(Items.AMETHYST_SHARD.asItem());

        this.tag(ModTags.Items.HAMMERS)
                .add(ModItems.STONE_HAMMER.get())
                .add(ModItems.COPPER_HAMMER.get())
                .add(ModItems.IRON_HAMMER.get())
                .add(ModItems.GOLD_HAMMER.get())
                .add(ModItems.DIAMOND_HAMMER.get())
                .add(ModItems.NETHERITE_HAMMER.get())
                .add(ModItems.AMETHYST_HAMMER.get())

                .add(ModItems.TINY_STONE_HAMMER.get())
                .add(ModItems.TINY_COPPER_HAMMER.get())
                .add(ModItems.TINY_GOLD_HAMMER.get())
                .add(ModItems.TINY_DIAMOND_HAMMER.get())
                .add(ModItems.TINY_NETHERITE_HAMMER.get())
                .add(ModItems.TINY_IRON_HAMMER.get())
                .add(ModItems.TINY_AMETHYST_HAMMER.get())

                .add(ModItems.GIANT_STONE_HAMMER.get())
                .add(ModItems.GIANT_COPPER_HAMMER.get())
                .add(ModItems.GIANT_IRON_HAMMER.get())
                .add(ModItems.GIANT_GOLD_HAMMER.get())
                .add(ModItems.GIANT_DIAMOND_HAMMER.get())
                .add(ModItems.GIANT_NETHERITE_HAMMER.get())
                .add(ModItems.GIANT_AMETHYST_HAMMER.get());

    }
}