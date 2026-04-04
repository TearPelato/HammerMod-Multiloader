package net.tier1234.hammermod.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tier1234.hammermod.Constants;


public class ModTags {

    public static class Blocks {
        public static final TagKey<Block> NEEDS_AMETHYST_TOOL = createTag("needs_amethyst_tool");
        public static final TagKey<Block> NEEDS_COPPER_TOOL = createTag("needs_copper_tool");
        public static final TagKey<Block> INCORRECT_FOR_AMETHYST_TOOL = createTag("incorrect_for_amethyst_tool");
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = createTag("incorrect_for_copper_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK,
                    Identifier.fromNamespaceAndPath(Constants.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> AMETHYST_REPAIRABLE = createTag("amethyst_repairable");
        public static final TagKey<Item> COPPER_REPAIRABLE = createTag("copper_repairable");

        public static final TagKey<Item> HAMMERS = createTag("hammers");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM,
                    Identifier.fromNamespaceAndPath(Constants.MOD_ID, name));
        }
    }
}