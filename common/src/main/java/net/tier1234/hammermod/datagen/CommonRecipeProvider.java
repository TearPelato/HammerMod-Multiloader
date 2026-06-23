package net.tier1234.hammermod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.registries.ModItems;

import java.util.concurrent.CompletableFuture;

public class CommonRecipeProvider extends RecipeProvider {

    protected CommonRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    public void buildRecipes() {


//Hammers
        this.shaped(RecipeCategory.MISC, ModItems.STONE_HAMMER.get())
                .pattern("###")
                .pattern("#C#")
                .pattern(" C ")
                .define('C', Items.STICK.asItem())
                .define('#', Items.COBBLESTONE.asItem())
                .unlockedBy("has_iron", has(Items.COBBLESTONE))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.COPPER_HAMMER.get())
                .pattern("###")
                .pattern("#C#")
                .pattern(" C ")
                .define('C', Items.STICK.asItem())
                .define('#', Items.COPPER_INGOT.asItem())
                .unlockedBy("has_iron", has(Items.COPPER_INGOT))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.GOLD_HAMMER.get())
                .pattern("###")
                .pattern("#C#")
                .pattern(" C ")
                .define('C', Items.STICK.asItem())
                .define('#', Items.GOLD_INGOT.asItem())
                .unlockedBy("has_iron", has(Items.GOLD_INGOT))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.DIAMOND_HAMMER.get())
                .pattern("###")
                .pattern("#C#")
                .pattern(" C ")
                .define('C', Items.STICK.asItem())
                .define('#', Items.DIAMOND.asItem())
                .unlockedBy("has_iron", has(Items.DIAMOND))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.AMETHYST_HAMMER.get())
                .pattern("###")
                .pattern("#C#")
                .pattern(" C ")
                .define('C', Items.STICK.asItem())
                .define('#', Items.AMETHYST_SHARD.asItem())
                .unlockedBy("has_iron", has(Items.AMETHYST_SHARD))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.IRON_HAMMER.get())
                .pattern("###")
                .pattern("#C#")
                .pattern(" C ")
                .define('C', Items.STICK.asItem())
                .define('#', Items.IRON_INGOT.asItem())
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(this.output);


        //Netherite Hammers
        //this.netheriteSmithing(ModItems.DIAMOND_HAMMER.get(), RecipeCategory.TOOLS, ModItems.NETHERITE_HAMMER.get());

        this.netheriteSmithing(ModItems.DIAMOND_HAMMER.get(), RecipeCategory.TOOLS, ModItems.NETHERITE_HAMMER.get());
        this.netheriteSmithing(ModItems.TINY_DIAMOND_HAMMER.get(), RecipeCategory.TOOLS, ModItems.TINY_NETHERITE_HAMMER.get());
        this.netheriteSmithing(ModItems.GIANT_DIAMOND_HAMMER.get(), RecipeCategory.TOOLS, ModItems.GIANT_NETHERITE_HAMMER.get());

        this.netheriteSmithing(ModItems.GIANT_DIAMOND_HEAD.get(), RecipeCategory.TOOLS, ModItems.GIANT_NETHERITE_HEAD.get());

        //Template
        this.shaped(RecipeCategory.MISC, ModItems.HAMEMR_SMITHING_TEMPLATE.get(), 2)
                .pattern("#X#")
                .pattern("#C#")
                .pattern("###")
                .define('C', ModItems.DIAMOND_HEAD.get().asItem())
                .define('#', Items.DIAMOND.asItem())
                .define('X', ModItems.HAMEMR_SMITHING_TEMPLATE.get().asItem())
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .unlockedBy("has_diamond_HEAD.get()", has(ModItems.DIAMOND_HEAD.get()))
                .unlockedBy("has_hammer_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output);

        //Heads

        this.shaped(RecipeCategory.MISC, ModItems.STONE_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.COBBLESTONE.asItem())
                .define('C', Items.IRON_INGOT.asItem())
                .unlockedBy("has_cobblestone", has(Items.COBBLESTONE))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.IRON_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.IRON_INGOT.asItem())
                .define('C', Items.IRON_NUGGET.asItem())
                .unlockedBy("has_cobblestone", has(Items.IRON_INGOT))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.GOLD_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.GOLD_INGOT.asItem())
                .define('C', Items.GOLD_NUGGET.asItem())
                .unlockedBy("has_cobblestone", has(Items.GOLD_INGOT))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.DIAMOND_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.DIAMOND.asItem())
                .define('C', Items.IRON_INGOT.asItem())
                .unlockedBy("has_cobblestone", has(Items.DIAMOND))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.AMETHYST_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.AMETHYST_SHARD.asItem())
                .define('C', Items.IRON_INGOT.asItem())
                .unlockedBy("has_cobblestone", has(Items.AMETHYST_SHARD))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.COPPER_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.COPPER_INGOT.asItem())
                .define('C', Items.IRON_NUGGET.asItem())
                .unlockedBy("has_cobblestone", has(Items.COPPER_INGOT))
                .save(this.output);



        //Giant Heads
        this.shaped(RecipeCategory.MISC, ModItems.GIANT_STONE_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.COBBLESTONE.asItem())
                .define('C', Items.STONE_BRICKS.asItem())
                .unlockedBy("has_cobblestone", has(Items.COBBLESTONE))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.GIANT_IRON_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.IRON_BLOCK.asItem())
                .define('C', Items.IRON_INGOT.asItem())
                .unlockedBy("has_cobblestone", has(Items.IRON_INGOT))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.GIANT_GOLD_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.GOLD_BLOCK.asItem())
                .define('C', Items.GOLD_INGOT.asItem())
                .unlockedBy("has_cobblestone", has(Items.GOLD_INGOT))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.GIANT_DIAMOND_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.DIAMOND_BLOCK.asItem())
                .define('C', Items.DIAMOND.asItem())
                .unlockedBy("has_cobblestone", has(Items.DIAMOND))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.GIANT_AMETHYST_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.AMETHYST_BLOCK.asItem())
                .define('C', Items.AMETHYST_SHARD.asItem())
                .unlockedBy("has_cobblestone", has(Items.AMETHYST_SHARD))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.GIANT_COPPER_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Blocks.COPPER_BLOCK.asList().get(0))
                .define('C', Items.COPPER_INGOT.asItem())
                .unlockedBy("has_cobblestone", has(Items.COPPER_INGOT))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.TINY_STICK.get())
                .pattern(" A ")
                .pattern(" B ")
                .define('A', Items.STICK.asItem())
                .define('B', Items.IRON_NUGGET.asItem())
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_iron_nugget", has(Items.IRON_NUGGET))
                .save(this.output);

        this.shaped(RecipeCategory.MISC, ModItems.MAGNET.get())
                .pattern("AA ")
                .pattern("BB ")
                .define('A', Items.IRON_INGOT.asItem())
                .define('B', Items.REDSTONE.asItem())
                .unlockedBy("has_iron_ingot", has(Items.IRON_NUGGET))
                .unlockedBy("has_redstone", has(Items.REDSTONE))
                .save(this.output);


        //Giant Hammers
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GIANT_NETHERITE_HEAD.get()),
                        Ingredient.of(Items.STICK),
                        RecipeCategory.TOOLS,
                        ModItems.GIANT_NETHERITE_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output, String.valueOf(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "giant_netherite_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GIANT_DIAMOND_HEAD.get()),
                        Ingredient.of(Items.STICK),
                        RecipeCategory.TOOLS,
                        ModItems.GIANT_DIAMOND_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output, String.valueOf(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "giant_diamond_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GIANT_IRON_HEAD.get()),
                        Ingredient.of(Items.STICK),
                        RecipeCategory.TOOLS,
                        ModItems.GIANT_IRON_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output, String.valueOf(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "giant_iron_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GIANT_GOLD_HEAD.get()),
                        Ingredient.of(Items.STICK),
                        RecipeCategory.TOOLS,
                        ModItems.GIANT_GOLD_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output, String.valueOf(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "giant_gold_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GIANT_COPPER_HEAD.get()),
                        Ingredient.of(Items.STICK),
                        RecipeCategory.TOOLS,
                        ModItems.GIANT_COPPER_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output, String.valueOf(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "giant_copper_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GIANT_AMETHYST_HEAD.get()),
                        Ingredient.of(Items.STICK),
                        RecipeCategory.TOOLS,
                        ModItems.GIANT_AMETHYST_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output, String.valueOf(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "giant_amethyst_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GIANT_STONE_HEAD.get()),
                        Ingredient.of(Items.STICK),
                        RecipeCategory.TOOLS,
                        ModItems.GIANT_STONE_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output, String.valueOf(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "giant_stone_hammer")));


//Tiny Hammers

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.NETHERITE_HEAD.get()),
                        Ingredient.of(ModItems.TINY_STICK.get()),
                        RecipeCategory.TOOLS,
                        ModItems.TINY_NETHERITE_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output, String.valueOf(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "tiny_netherite_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.DIAMOND_HEAD.get()),
                        Ingredient.of(ModItems.TINY_STICK.get()),
                        RecipeCategory.TOOLS,
                        ModItems.TINY_DIAMOND_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output, String.valueOf(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "tiny_diamond_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.IRON_HEAD.get()),
                        Ingredient.of(ModItems.TINY_STICK.get()),
                        RecipeCategory.TOOLS,
                        ModItems.TINY_IRON_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output, String.valueOf(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "tiny_iron_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GOLD_HEAD.get()),
                        Ingredient.of(ModItems.TINY_STICK.get()),
                        RecipeCategory.TOOLS,
                        ModItems.TINY_GOLD_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output, String.valueOf(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "tiny_gold_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.COPPER_HEAD.get()),
                        Ingredient.of(ModItems.TINY_STICK.get()),
                        RecipeCategory.TOOLS,
                        ModItems.TINY_COPPER_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output, String.valueOf(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "tiny_copper_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.AMETHYST_HEAD.get()),
                        Ingredient.of(ModItems.TINY_STICK.get()),
                        RecipeCategory.TOOLS,
                        ModItems.TINY_AMETHYST_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output, String.valueOf(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "tiny_amethyst_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.STONE_HEAD.get()),
                        Ingredient.of(ModItems.TINY_STICK.get()),
                        RecipeCategory.TOOLS,
                        ModItems.TINY_STONE_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(this.output, String.valueOf(Identifier.fromNamespaceAndPath(Constants.MOD_ID, "tiny_stone_hammer")));


    }


    public static class Runner extends RecipeProvider.Runner
    {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
        {
            super(output, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output)
        {
            return new CommonRecipeProvider(provider, output);
        }

        @Override
        public String getName()
        {
            return "Mod Recipes";
        }
    }
}
