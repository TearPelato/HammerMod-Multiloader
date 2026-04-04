package net.tier1234.hammermod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.registries.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeOutput){
        List<ItemLike> HAMMER_RECIPE_ITEMS = List.of(Items.STICK, Items.DIAMOND,Items.GOLD_INGOT,Items.IRON_INGOT,Items.NETHERITE_INGOT,Items.COBBLESTONE,
                Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE);


//Hammers
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_HAMMER.get())
                .pattern("###")
                .pattern("#C#")
                .pattern(" C ")
                .define('C', Items.STICK.asItem())
                .define('#', Items.COBBLESTONE.asItem())
                .unlockedBy("has_iron", has(Items.COBBLESTONE))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_HAMMER.get())
                .pattern("###")
                .pattern("#C#")
                .pattern(" C ")
                .define('C', Items.STICK.asItem())
                .define('#', Items.COPPER_INGOT.asItem())
                .unlockedBy("has_iron", has(Items.COPPER_INGOT))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLD_HAMMER.get())
                .pattern("###")
                .pattern("#C#")
                .pattern(" C ")
                .define('C', Items.STICK.asItem())
                .define('#', Items.GOLD_INGOT.asItem())
                .unlockedBy("has_iron", has(Items.GOLD_INGOT))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_HAMMER.get())
                .pattern("###")
                .pattern("#C#")
                .pattern(" C ")
                .define('C', Items.STICK.asItem())
                .define('#', Items.DIAMOND.asItem())
                .unlockedBy("has_iron", has(Items.DIAMOND))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AMETHYST_HAMMER.get())
                .pattern("###")
                .pattern("#C#")
                .pattern(" C ")
                .define('C', Items.STICK.asItem())
                .define('#', Items.AMETHYST_SHARD.asItem())
                .unlockedBy("has_iron", has(Items.AMETHYST_SHARD))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_HAMMER.get())
                .pattern("###")
                .pattern("#C#")
                .pattern(" C ")
                .define('C', Items.STICK.asItem())
                .define('#', Items.IRON_INGOT.asItem())
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .unlockedBy("has_stick", has(Items.STICK))
                .save(recipeOutput);


        //Netherite Hammers

        netheriteSmithing(recipeOutput,ModItems.DIAMOND_HAMMER.get(), RecipeCategory.TOOLS, ModItems.NETHERITE_HAMMER.get());
        netheriteSmithing(recipeOutput,ModItems.TINY_DIAMOND_HAMMER.get(), RecipeCategory.TOOLS, ModItems.TINY_NETHERITE_HAMMER.get());
        netheriteSmithing(recipeOutput,ModItems.GIANT_DIAMOND_HAMMER.get(), RecipeCategory.TOOLS, ModItems.GIANT_NETHERITE_HAMMER.get());

        netheriteSmithing(recipeOutput, ModItems.GIANT_DIAMOND_HEAD.get(), RecipeCategory.TOOLS, ModItems.GIANT_NETHERITE_HEAD.get());

        //Template
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HAMEMR_SMITHING_TEMPLATE.get(), 2)
                .pattern("#X#")
                .pattern("#C#")
                .pattern("###")
                .define('C', ModItems.DIAMOND_HEAD.get().asItem())
                .define('#', Items.DIAMOND.asItem())
                .define('X', ModItems.HAMEMR_SMITHING_TEMPLATE.get().asItem())
                .unlockedBy("has_diamond", has(Items.DIAMOND))
                .unlockedBy("has_diamond_HEAD.get()", has(ModItems.DIAMOND_HEAD.get()))
                .unlockedBy("has_hammer_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput);

        //Heads

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STONE_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.COBBLESTONE.asItem())
                .define('C', Items.IRON_INGOT.asItem())
                .unlockedBy("has_cobblestone", has(Items.COBBLESTONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.IRON_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.IRON_INGOT.asItem())
                .define('C', Items.IRON_NUGGET.asItem())
                .unlockedBy("has_cobblestone", has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GOLD_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.GOLD_INGOT.asItem())
                .define('C', Items.GOLD_NUGGET.asItem())
                .unlockedBy("has_cobblestone", has(Items.GOLD_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DIAMOND_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.DIAMOND.asItem())
                .define('C', Items.IRON_INGOT.asItem())
                .unlockedBy("has_cobblestone", has(Items.DIAMOND))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.AMETHYST_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.AMETHYST_SHARD.asItem())
                .define('C', Items.IRON_INGOT.asItem())
                .unlockedBy("has_cobblestone", has(Items.AMETHYST_SHARD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.COPPER_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.COPPER_INGOT.asItem())
                .define('C', Items.IRON_NUGGET.asItem())
                .unlockedBy("has_cobblestone", has(Items.COPPER_INGOT))
                .save(recipeOutput);



        //Giant Heads
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GIANT_STONE_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.COBBLESTONE.asItem())
                .define('C', Items.STONE_BRICKS.asItem())
                .unlockedBy("has_cobblestone", has(Items.COBBLESTONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GIANT_IRON_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.IRON_BLOCK.asItem())
                .define('C', Items.IRON_INGOT.asItem())
                .unlockedBy("has_cobblestone", has(Items.IRON_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GIANT_GOLD_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.GOLD_BLOCK.asItem())
                .define('C', Items.GOLD_INGOT.asItem())
                .unlockedBy("has_cobblestone", has(Items.GOLD_INGOT))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GIANT_DIAMOND_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.DIAMOND_BLOCK.asItem())
                .define('C', Items.DIAMOND.asItem())
                .unlockedBy("has_cobblestone", has(Items.DIAMOND))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GIANT_AMETHYST_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.AMETHYST_BLOCK.asItem())
                .define('C', Items.AMETHYST_SHARD.asItem())
                .unlockedBy("has_cobblestone", has(Items.AMETHYST_SHARD))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GIANT_COPPER_HEAD.get())
                .pattern("###")
                .pattern("#C#")
                .define('#', Items.COPPER_BLOCK.asItem())
                .define('C', Items.COPPER_INGOT.asItem())
                .unlockedBy("has_cobblestone", has(Items.COPPER_INGOT))
                .save(recipeOutput);


        //Giant Hammers
        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GIANT_NETHERITE_HEAD.get()),
                        Ingredient.of(Items.STICK),
                        RecipeCategory.TOOLS,
                        ModItems.GIANT_NETHERITE_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput, String.valueOf(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "giant_netherite_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GIANT_DIAMOND_HEAD.get()),
                        Ingredient.of(Items.STICK),
                        RecipeCategory.TOOLS,
                        ModItems.GIANT_DIAMOND_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput, String.valueOf(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "giant_diamond_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GIANT_IRON_HEAD.get()),
                        Ingredient.of(Items.STICK),
                        RecipeCategory.TOOLS,
                        ModItems.GIANT_IRON_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput, String.valueOf(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "giant_iron_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GIANT_GOLD_HEAD.get()),
                        Ingredient.of(Items.STICK),
                        RecipeCategory.TOOLS,
                        ModItems.GIANT_GOLD_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput, String.valueOf(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "giant_gold_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GIANT_COPPER_HEAD.get()),
                        Ingredient.of(Items.STICK),
                        RecipeCategory.TOOLS,
                        ModItems.GIANT_COPPER_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput, String.valueOf(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "giant_copper_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GIANT_AMETHYST_HEAD.get()),
                        Ingredient.of(Items.STICK),
                        RecipeCategory.TOOLS,
                        ModItems.GIANT_AMETHYST_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput, String.valueOf(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "giant_amethyst_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GIANT_STONE_HEAD.get()),
                        Ingredient.of(Items.STICK),
                        RecipeCategory.TOOLS,
                        ModItems.GIANT_STONE_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput, String.valueOf(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "giant_stone_hammer")));


//Tiny Hammers

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.NETHERITE_HEAD.get()),
                        Ingredient.of(ModItems.TINY_STICK.get()),
                        RecipeCategory.TOOLS,
                        ModItems.TINY_NETHERITE_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput, String.valueOf(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "tiny_netherite_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.DIAMOND_HEAD.get()),
                        Ingredient.of(ModItems.TINY_STICK.get()),
                        RecipeCategory.TOOLS,
                        ModItems.TINY_DIAMOND_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput, String.valueOf(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "tiny_diamond_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.IRON_HEAD.get()),
                        Ingredient.of(ModItems.TINY_STICK.get()),
                        RecipeCategory.TOOLS,
                        ModItems.TINY_IRON_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput, String.valueOf(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "tiny_iron_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.GOLD_HEAD.get()),
                        Ingredient.of(ModItems.TINY_STICK.get()),
                        RecipeCategory.TOOLS,
                        ModItems.TINY_GOLD_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput, String.valueOf(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "tiny_gold_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.COPPER_HEAD.get()),
                        Ingredient.of(ModItems.TINY_STICK.get()),
                        RecipeCategory.TOOLS,
                        ModItems.TINY_COPPER_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput, String.valueOf(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "tiny_copper_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.AMETHYST_HEAD.get()),
                        Ingredient.of(ModItems.TINY_STICK.get()),
                        RecipeCategory.TOOLS,
                        ModItems.TINY_AMETHYST_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput, String.valueOf(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "tiny_amethyst_hammer")));

        SmithingTransformRecipeBuilder.smithing(
                        Ingredient.of(ModItems.HAMEMR_SMITHING_TEMPLATE.get()),
                        Ingredient.of(ModItems.STONE_HEAD.get()),
                        Ingredient.of(ModItems.TINY_STICK.get()),
                        RecipeCategory.TOOLS,
                        ModItems.TINY_STONE_HAMMER.get()
                )
                .unlocks("has_custom_template", has(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                .save(recipeOutput, String.valueOf(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "tiny_stone_hammer")));























    }





    public static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Constants.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}