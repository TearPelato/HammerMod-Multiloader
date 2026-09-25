package net.tier1234.hammermod.registries;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.item.custom.HammerItem;
import net.tier1234.hammermod.item.custom.HammerItem2x2;
import net.tier1234.hammermod.item.custom.HammerItem5x5;
import net.tier1234.hammermod.item.custom.HammerTemplateItem;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;

public class ModItems {

    /**
     *Hammers Registries:
     * Using CraftCoreLIB {@link ObjectRegistries} to registry everything on multiloader
     * */
//Base Hammers Registries
    public static final ObjectRegistries<HammerItem> STONE_HAMMER = ObjectRegistries.registerItem(Constants.id("stone_hammer"),
        ()-> new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.STONE, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem> COPPER_HAMMER = ObjectRegistries.registerItem(Constants.id("copper_hammer"),
            ()-> new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem> IRON_HAMMER = ObjectRegistries.registerItem(Constants.id("iron_hammer"),
            ()-> new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.IRON, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem> GOLD_HAMMER = ObjectRegistries.registerItem(Constants.id("gold_hammer"),
            ()-> new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.GOLD, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem> DIAMOND_HAMMER = ObjectRegistries.registerItem(Constants.id("diamond_hammer"),
            ()-> new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem> NETHERITE_HAMMER = ObjectRegistries.registerItem(Constants.id("netherite_hammer"),
            ()-> new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem> AMETHYST_HAMMER = ObjectRegistries.registerItem(Constants.id("amethyst_hammer"),
            ()-> new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.AMETHYST, 7F, -3.5f))));

//Tiny Hammers registries
public static final ObjectRegistries<HammerItem2x2> TINY_STONE_HAMMER = ObjectRegistries.registerItem(Constants.id("tiny_stone_hammer"),
        ()-> new HammerItem2x2(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.STONE, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem2x2> TINY_COPPER_HAMMER = ObjectRegistries.registerItem(Constants.id("tiny_copper_hammer"),
            ()-> new HammerItem2x2(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem2x2> TINY_IRON_HAMMER = ObjectRegistries.registerItem(Constants.id("tiny_iron_hammer"),
            ()-> new HammerItem2x2(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.IRON, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem2x2> TINY_GOLD_HAMMER = ObjectRegistries.registerItem(Constants.id("tiny_gold_hammer"),
            ()-> new HammerItem2x2(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.GOLD, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem2x2> TINY_DIAMOND_HAMMER = ObjectRegistries.registerItem(Constants.id("tiny_diamond_hammer"),
            ()-> new HammerItem2x2(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem2x2> TINY_NETHERITE_HAMMER = ObjectRegistries.registerItem(Constants.id("tiny_netherite_hammer"),
            ()-> new HammerItem2x2(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem2x2> TINY_AMETHYST_HAMMER = ObjectRegistries.registerItem(Constants.id("tiny_amethyst_hammer"),
            ()-> new HammerItem2x2(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.AMETHYST, 7F, -3.5f))));

//Giant Hammers Registries
    public static final ObjectRegistries<HammerItem5x5> GIANT_STONE_HAMMER = ObjectRegistries.registerItem(Constants.id("giant_stone_hammer"),
            ()-> new HammerItem5x5(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.STONE, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem5x5> GIANT_COPPER_HAMMER = ObjectRegistries.registerItem(Constants.id("giant_copper_hammer"),
            ()-> new HammerItem5x5(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem5x5> GIANT_IRON_HAMMER = ObjectRegistries.registerItem(Constants.id("giant_iron_hammer"),
            ()-> new HammerItem5x5(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.IRON, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem5x5> GIANT_GOLD_HAMMER = ObjectRegistries.registerItem(Constants.id("giant_gold_hammer"),
            ()-> new HammerItem5x5(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.GOLD, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem5x5> GIANT_DIAMOND_HAMMER = ObjectRegistries.registerItem(Constants.id("giant_diamond_hammer"),
            ()-> new HammerItem5x5(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem5x5> GIANT_NETHERITE_HAMMER = ObjectRegistries.registerItem(Constants.id("giant_netherite_hammer"),
            ()-> new HammerItem5x5(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 7F, -3.5f))));

    public static final ObjectRegistries<HammerItem5x5> GIANT_AMETHYST_HAMMER = ObjectRegistries.registerItem(Constants.id("giant_amethyst_hammer"),
            ()-> new HammerItem5x5(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.AMETHYST, 7F, -3.5f))));



    //Template Registry
    public static final ObjectRegistries<HammerTemplateItem> HAMEMR_SMITHING_TEMPLATE = ObjectRegistries.registerItem(Constants.id("hammer_smithing_template"),
        ()->  HammerTemplateItem.createhammerUpgradeTemplate());


//Simple Items Registries
    //Heads
    public static final ObjectRegistries<Item> STONE_HEAD = ObjectRegistries.registerItem(Constants.id("stone_head"),
        ()-> new Item(new Item.Properties()));
    public static final ObjectRegistries<Item> COPPER_HEAD = ObjectRegistries.registerItem(Constants.id("copper_head"),
            ()-> new Item(new Item.Properties()));
    public static final ObjectRegistries<Item> IRON_HEAD = ObjectRegistries.registerItem(Constants.id("iron_head"),
            ()-> new Item(new Item.Properties()));
    public static final ObjectRegistries<Item> GOLD_HEAD = ObjectRegistries.registerItem(Constants.id("gold_head"),
            ()-> new Item(new Item.Properties()));
    public static final ObjectRegistries<Item> DIAMOND_HEAD = ObjectRegistries.registerItem(Constants.id("diamond_head"),
            ()-> new Item(new Item.Properties()));
    public static final ObjectRegistries<Item> NETHERITE_HEAD = ObjectRegistries.registerItem(Constants.id("netherite_head"),
            ()-> new Item(new Item.Properties()));
    public static final ObjectRegistries<Item> AMETHYST_HEAD = ObjectRegistries.registerItem(Constants.id("amethyst_head"),
            ()-> new Item(new Item.Properties()));

    //Giant Heads
    public static final ObjectRegistries<Item> GIANT_STONE_HEAD = ObjectRegistries.registerItem(Constants.id("giant_stone_head"),
            ()-> new Item(new Item.Properties()));
    public static final ObjectRegistries<Item> GIANT_COPPER_HEAD = ObjectRegistries.registerItem(Constants.id("giant_copper_head"),
            ()-> new Item(new Item.Properties()));
    public static final ObjectRegistries<Item> GIANT_IRON_HEAD = ObjectRegistries.registerItem(Constants.id("giant_iron_head"),
            ()-> new Item(new Item.Properties()));
    public static final ObjectRegistries<Item> GIANT_GOLD_HEAD = ObjectRegistries.registerItem(Constants.id("giant_gold_head"),
            ()-> new Item(new Item.Properties()));
    public static final ObjectRegistries<Item> GIANT_DIAMOND_HEAD = ObjectRegistries.registerItem(Constants.id("giant_diamond_head"),
            ()-> new Item(new Item.Properties()));
    public static final ObjectRegistries<Item> GIANT_NETHERITE_HEAD = ObjectRegistries.registerItem(Constants.id("giant_netherite_head"),
            ()-> new Item(new Item.Properties()));
    public static final ObjectRegistries<Item> GIANT_AMETHYST_HEAD = ObjectRegistries.registerItem(Constants.id("giant_amethyst_head"),
            ()-> new Item(new Item.Properties()));

    public static final ObjectRegistries<Item> TINY_STICK = ObjectRegistries.registerItem(Constants.id("tiny_stick"),
            ()-> new Item(new Item.Properties()));

    public static void init() {}

}