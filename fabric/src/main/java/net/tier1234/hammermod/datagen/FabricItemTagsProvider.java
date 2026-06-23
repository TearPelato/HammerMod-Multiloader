package net.tier1234.hammermod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.tier1234.hammermod.registries.ModItems;
import net.tier1234.hammermod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class FabricItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public FabricItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        this.tag(ModTags.Items.COPPER_REPAIRABLE)
                .add(Items.COPPER_INGOT.builtInRegistryHolder().key());

        this.tag(ModTags.Items.AMETHYST_REPAIRABLE)
                .add(Items.AMETHYST_SHARD.builtInRegistryHolder().key());

        this.tag(ModTags.Items.HAMMERS)
                .add(ModItems.STONE_HAMMER.get().builtInRegistryHolder().key(), ModItems.COPPER_HAMMER.get().builtInRegistryHolder().key(), ModItems.IRON_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.GOLD_HAMMER.get().builtInRegistryHolder().key(), ModItems.DIAMOND_HAMMER.get().builtInRegistryHolder().key(), ModItems.NETHERITE_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.AMETHYST_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_STONE_HAMMER.get().builtInRegistryHolder().key(), ModItems.TINY_COPPER_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.TINY_IRON_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_GOLD_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_DIAMOND_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_NETHERITE_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.TINY_AMETHYST_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_STONE_HAMMER.get().builtInRegistryHolder().key(), ModItems.GIANT_COPPER_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.GIANT_IRON_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_GOLD_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_DIAMOND_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_NETHERITE_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.GIANT_AMETHYST_HAMMER.get().builtInRegistryHolder().key());
        this.tag(ItemTags.MINING_ENCHANTABLE)
                .add(ModItems.STONE_HAMMER.get().builtInRegistryHolder().key(), ModItems.COPPER_HAMMER.get().builtInRegistryHolder().key(), ModItems.IRON_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.GOLD_HAMMER.get().builtInRegistryHolder().key(), ModItems.DIAMOND_HAMMER.get().builtInRegistryHolder().key(), ModItems.NETHERITE_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.AMETHYST_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_STONE_HAMMER.get().builtInRegistryHolder().key(), ModItems.TINY_COPPER_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.TINY_IRON_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_GOLD_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_DIAMOND_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_NETHERITE_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.TINY_AMETHYST_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_STONE_HAMMER.get().builtInRegistryHolder().key(), ModItems.GIANT_COPPER_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.GIANT_IRON_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_GOLD_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_DIAMOND_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_NETHERITE_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.GIANT_AMETHYST_HAMMER.get().builtInRegistryHolder().key());

        this.tag(ItemTags.MINING_LOOT_ENCHANTABLE)
                .add(ModItems.STONE_HAMMER.get().builtInRegistryHolder().key(), ModItems.COPPER_HAMMER.get().builtInRegistryHolder().key(), ModItems.IRON_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.GOLD_HAMMER.get().builtInRegistryHolder().key(), ModItems.DIAMOND_HAMMER.get().builtInRegistryHolder().key(), ModItems.NETHERITE_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.AMETHYST_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_STONE_HAMMER.get().builtInRegistryHolder().key(), ModItems.TINY_COPPER_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.TINY_IRON_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_GOLD_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_DIAMOND_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_NETHERITE_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.TINY_AMETHYST_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_STONE_HAMMER.get().builtInRegistryHolder().key(), ModItems.GIANT_COPPER_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.GIANT_IRON_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_GOLD_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_DIAMOND_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_NETHERITE_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.GIANT_AMETHYST_HAMMER.get().builtInRegistryHolder().key());

        this.tag(ModTags.Items.HAMMER_CAN_BE_ENCHANTED)
                .add(ModItems.STONE_HAMMER.get().builtInRegistryHolder().key(), ModItems.COPPER_HAMMER.get().builtInRegistryHolder().key(), ModItems.IRON_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.GOLD_HAMMER.get().builtInRegistryHolder().key(), ModItems.DIAMOND_HAMMER.get().builtInRegistryHolder().key(), ModItems.NETHERITE_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.AMETHYST_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_STONE_HAMMER.get().builtInRegistryHolder().key(), ModItems.TINY_COPPER_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.TINY_IRON_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_GOLD_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_DIAMOND_HAMMER.get().builtInRegistryHolder().key(),ModItems.TINY_NETHERITE_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.TINY_AMETHYST_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_STONE_HAMMER.get().builtInRegistryHolder().key(), ModItems.GIANT_COPPER_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.GIANT_IRON_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_GOLD_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_DIAMOND_HAMMER.get().builtInRegistryHolder().key(),ModItems.GIANT_NETHERITE_HAMMER.get().builtInRegistryHolder().key(),
                        ModItems.GIANT_AMETHYST_HAMMER.get().builtInRegistryHolder().key());

    }
}
