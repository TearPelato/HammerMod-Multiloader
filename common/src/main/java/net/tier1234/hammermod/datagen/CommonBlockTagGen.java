package net.tier1234.hammermod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.tier1234.hammermod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class CommonBlockTagGen extends IntrinsicHolderTagsProvider<Block> {

    public CommonBlockTagGen(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture)
    {
        super(output, Registries.BLOCK, completableFuture, block -> block.builtInRegistryHolder().key());
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
