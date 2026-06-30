package net.tier1234.hammermod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.registries.ModItems;
import net.tier1234.hammermod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class CommonItemTagProvider extends TagsProvider<Item> {
    public CommonItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture)
    {
        super(output, Registries.ITEM, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        this.tag(ModTags.Items.COPPER_REPAIRABLE)
                .add(Constants.getItemKey(Items.COPPER_INGOT));

        this.tag(ModTags.Items.AMETHYST_REPAIRABLE)
                .add(Constants.getItemKey(Items.AMETHYST_SHARD));

        this.tag(ModTags.Items.HAMMERS)
                .add(Constants.getItemKey(ModItems.STONE_HAMMER.get()), Constants.getItemKey(ModItems.COPPER_HAMMER.get()), Constants.getItemKey(ModItems.IRON_HAMMER.get()),
                        Constants.getItemKey(ModItems.GOLD_HAMMER.get()), Constants.getItemKey(ModItems.DIAMOND_HAMMER.get()), Constants.getItemKey(ModItems.NETHERITE_HAMMER.get()),
                        Constants.getItemKey(ModItems.AMETHYST_HAMMER.get()),Constants.getItemKey(ModItems.TINY_STONE_HAMMER.get()), Constants.getItemKey(ModItems.TINY_COPPER_HAMMER.get()),
                        Constants.getItemKey(ModItems.TINY_IRON_HAMMER.get()),Constants.getItemKey(ModItems.TINY_GOLD_HAMMER.get()),Constants.getItemKey(ModItems.TINY_DIAMOND_HAMMER.get()),Constants.getItemKey(ModItems.TINY_NETHERITE_HAMMER.get()),
                        Constants.getItemKey(ModItems.TINY_AMETHYST_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_STONE_HAMMER.get()), Constants.getItemKey(ModItems.GIANT_COPPER_HAMMER.get()),
                        Constants.getItemKey(ModItems.GIANT_IRON_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_GOLD_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_DIAMOND_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_NETHERITE_HAMMER.get()),
                        Constants.getItemKey(ModItems.GIANT_AMETHYST_HAMMER.get()));
        this.tag(ItemTags.MINING_ENCHANTABLE)
                .add(Constants.getItemKey(ModItems.STONE_HAMMER.get()), Constants.getItemKey(ModItems.COPPER_HAMMER.get()), Constants.getItemKey(ModItems.IRON_HAMMER.get()),
                        Constants.getItemKey(ModItems.GOLD_HAMMER.get()), Constants.getItemKey(ModItems.DIAMOND_HAMMER.get()), Constants.getItemKey(ModItems.NETHERITE_HAMMER.get()),
                        Constants.getItemKey(ModItems.AMETHYST_HAMMER.get()),Constants.getItemKey(ModItems.TINY_STONE_HAMMER.get()), Constants.getItemKey(ModItems.TINY_COPPER_HAMMER.get()),
                        Constants.getItemKey(ModItems.TINY_IRON_HAMMER.get()),Constants.getItemKey(ModItems.TINY_GOLD_HAMMER.get()),Constants.getItemKey(ModItems.TINY_DIAMOND_HAMMER.get()),Constants.getItemKey(ModItems.TINY_NETHERITE_HAMMER.get()),
                        Constants.getItemKey(ModItems.TINY_AMETHYST_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_STONE_HAMMER.get()), Constants.getItemKey(ModItems.GIANT_COPPER_HAMMER.get()),
                        Constants.getItemKey(ModItems.GIANT_IRON_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_GOLD_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_DIAMOND_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_NETHERITE_HAMMER.get()),
                        Constants.getItemKey(ModItems.GIANT_AMETHYST_HAMMER.get()));

        this.tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(Constants.getItemKey(ModItems.STONE_HAMMER.get()), Constants.getItemKey(ModItems.COPPER_HAMMER.get()), Constants.getItemKey(ModItems.IRON_HAMMER.get()),
                Constants.getItemKey(ModItems.GOLD_HAMMER.get()), Constants.getItemKey(ModItems.DIAMOND_HAMMER.get()), Constants.getItemKey(ModItems.NETHERITE_HAMMER.get()),
                Constants.getItemKey(ModItems.AMETHYST_HAMMER.get()),Constants.getItemKey(ModItems.TINY_STONE_HAMMER.get()), Constants.getItemKey(ModItems.TINY_COPPER_HAMMER.get()),
                Constants.getItemKey(ModItems.TINY_IRON_HAMMER.get()),Constants.getItemKey(ModItems.TINY_GOLD_HAMMER.get()),Constants.getItemKey(ModItems.TINY_DIAMOND_HAMMER.get()),Constants.getItemKey(ModItems.TINY_NETHERITE_HAMMER.get()),
                Constants.getItemKey(ModItems.TINY_AMETHYST_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_STONE_HAMMER.get()), Constants.getItemKey(ModItems.GIANT_COPPER_HAMMER.get()),
                Constants.getItemKey(ModItems.GIANT_IRON_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_GOLD_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_DIAMOND_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_NETHERITE_HAMMER.get()),
                Constants.getItemKey(ModItems.GIANT_AMETHYST_HAMMER.get()));

        this.tag(ModTags.Items.HAMMER_CAN_BE_ENCHANTED)
                .add(Constants.getItemKey(ModItems.STONE_HAMMER.get()), Constants.getItemKey(ModItems.COPPER_HAMMER.get()), Constants.getItemKey(ModItems.IRON_HAMMER.get()),
                        Constants.getItemKey(ModItems.GOLD_HAMMER.get()), Constants.getItemKey(ModItems.DIAMOND_HAMMER.get()), Constants.getItemKey(ModItems.NETHERITE_HAMMER.get()),
                        Constants.getItemKey(ModItems.AMETHYST_HAMMER.get()),Constants.getItemKey(ModItems.TINY_STONE_HAMMER.get()), Constants.getItemKey(ModItems.TINY_COPPER_HAMMER.get()),
                        Constants.getItemKey(ModItems.TINY_IRON_HAMMER.get()),Constants.getItemKey(ModItems.TINY_GOLD_HAMMER.get()),Constants.getItemKey(ModItems.TINY_DIAMOND_HAMMER.get()),Constants.getItemKey(ModItems.TINY_NETHERITE_HAMMER.get()),
                        Constants.getItemKey(ModItems.TINY_AMETHYST_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_STONE_HAMMER.get()), Constants.getItemKey(ModItems.GIANT_COPPER_HAMMER.get()),
                        Constants.getItemKey(ModItems.GIANT_IRON_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_GOLD_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_DIAMOND_HAMMER.get()),Constants.getItemKey(ModItems.GIANT_NETHERITE_HAMMER.get()),
                        Constants.getItemKey(ModItems.GIANT_AMETHYST_HAMMER.get()));
    }
}
