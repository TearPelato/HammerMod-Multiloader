package net.tier1234.hammermod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.tier1234.hammermod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL);
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL);
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL);
        getOrCreateTagBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_COPPER_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_AMETHYST_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .addTag(ModTags.Blocks.NEEDS_COPPER_TOOL);

        getOrCreateTagBuilder(ModTags.Blocks.INCORRECT_FOR_AMETHYST_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .addTag(ModTags.Blocks.NEEDS_AMETHYST_TOOL);
    }
}