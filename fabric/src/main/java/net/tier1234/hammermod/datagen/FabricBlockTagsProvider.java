package net.tier1234.hammermod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import net.tier1234.hammermod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class FabricBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public FabricBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {

        getOrCreateRawBuilder(BlockTags.NEEDS_IRON_TOOL);
        getOrCreateRawBuilder(BlockTags.NEEDS_STONE_TOOL);
        getOrCreateRawBuilder(BlockTags.INCORRECT_FOR_IRON_TOOL);
        getOrCreateRawBuilder(BlockTags.INCORRECT_FOR_STONE_TOOL);

        getOrCreateRawBuilder(ModTags.Blocks.NEEDS_COPPER_TOOL)
                .addTag(BlockTags.NEEDS_IRON_TOOL.location());

        getOrCreateRawBuilder(ModTags.Blocks.NEEDS_AMETHYST_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL.location());

        getOrCreateRawBuilder(ModTags.Blocks.INCORRECT_FOR_COPPER_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL.location())
                .addTag(ModTags.Blocks.NEEDS_COPPER_TOOL.location());

        getOrCreateRawBuilder(ModTags.Blocks.INCORRECT_FOR_AMETHYST_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL.location())
                .addTag(ModTags.Blocks.NEEDS_AMETHYST_TOOL.location());
    }
}
