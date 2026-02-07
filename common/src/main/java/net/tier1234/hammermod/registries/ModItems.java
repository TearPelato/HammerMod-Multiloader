package net.tier1234.hammermod.registries;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.item.ModToolTiers;
import net.tier1234.hammermod.item.custom.HammerItem;
import net.tier1234.hammermod.item.custom.HammerItem2x2;
import net.tier1234.hammermod.item.custom.HammerItem5x5;
import net.tier1234.hammermod.item.custom.HammerTemplateItem;

@RegistryContainer
public class ModItems {

    /**
     *Hammers Registries:
     * Using Framework {@link RegistryEntry} to registry everything on multiloade
     * */
//Base Hammers Registries
    public static final RegistryEntry<HammerItem> STONE_HAMMER = RegistryEntry.item(Constants.id("stone_hammer"),
        ()-> new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.STONE, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem> COPPER_HAMMER = RegistryEntry.item(Constants.id("copper_hammer"),
            ()-> new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem> IRON_HAMMER = RegistryEntry.item(Constants.id("iron_hammer"),
            ()-> new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.IRON, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem> GOLD_HAMMER = RegistryEntry.item(Constants.id("gold_hammer"),
            ()-> new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.GOLD, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem> DIAMOND_HAMMER = RegistryEntry.item(Constants.id("diamond_hammer"),
            ()-> new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem> NETHERITE_HAMMER = RegistryEntry.item(Constants.id("netherite_hammer"),
            ()-> new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem> AMETHYST_HAMMER = RegistryEntry.item(Constants.id("amethyst_hammer"),
            ()-> new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.AMETHYST, 7F, -3.5f))));

//Tiny Hammers registries
public static final RegistryEntry<HammerItem2x2> TINY_STONE_HAMMER = RegistryEntry.item(Constants.id("tiny_stone_hammer"),
        ()-> new HammerItem2x2(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.STONE, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem2x2> TINY_COPPER_HAMMER = RegistryEntry.item(Constants.id("tiny_copper_hammer"),
            ()-> new HammerItem2x2(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem2x2> TINY_IRON_HAMMER = RegistryEntry.item(Constants.id("tiny_iron_hammer"),
            ()-> new HammerItem2x2(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.IRON, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem2x2> TINY_GOLD_HAMMER = RegistryEntry.item(Constants.id("tiny_gold_hammer"),
            ()-> new HammerItem2x2(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.GOLD, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem2x2> TINY_DIAMOND_HAMMER = RegistryEntry.item(Constants.id("tiny_diamond_hammer"),
            ()-> new HammerItem2x2(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem2x2> TINY_NETHERITE_HAMMER = RegistryEntry.item(Constants.id("tiny_netherite_hammer"),
            ()-> new HammerItem2x2(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem2x2> TINY_AMETHYST_HAMMER = RegistryEntry.item(Constants.id("tiny_amethyst_hammer"),
            ()-> new HammerItem2x2(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.AMETHYST, 7F, -3.5f))));

//Giant Hammers Registries
    public static final RegistryEntry<HammerItem5x5> GIANT_STONE_HAMMER = RegistryEntry.item(Constants.id("giant_stone_hammer"),
            ()-> new HammerItem5x5(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.STONE, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem5x5> GIANT_COPPER_HAMMER = RegistryEntry.item(Constants.id("giant_copper_hammer"),
            ()-> new HammerItem5x5(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.COPPER, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem5x5> GIANT_IRON_HAMMER = RegistryEntry.item(Constants.id("giant_iron_hammer"),
            ()-> new HammerItem5x5(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.IRON, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem5x5> GIANT_GOLD_HAMMER = RegistryEntry.item(Constants.id("giant_gold_hammer"),
            ()-> new HammerItem5x5(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.GOLD, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem5x5> GIANT_DIAMOND_HAMMER = RegistryEntry.item(Constants.id("giant_diamond_hammer"),
            ()-> new HammerItem5x5(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem5x5> GIANT_NETHERITE_HAMMER = RegistryEntry.item(Constants.id("giant_netherite_hammer"),
            ()-> new HammerItem5x5(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.NETHERITE, 7F, -3.5f))));

    public static final RegistryEntry<HammerItem5x5> GIANT_AMETHYST_HAMMER = RegistryEntry.item(Constants.id("giant_amethyst_hammer"),
            ()-> new HammerItem5x5(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.AMETHYST, 7F, -3.5f))));



    //Template Registry
    public static final RegistryEntry<HammerTemplateItem> HAMEMR_SMITHING_TEMPLATE = RegistryEntry.item(Constants.id("hammer_smithing_template"),
        ()->  HammerTemplateItem.createhammerUpgradeTemplate());


//Simple Items Registries
    //Heads
    public static final RegistryEntry<Item> STONE_HEAD = RegistryEntry.item(Constants.id("stone_head"),
        ()-> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> COPPER_HEAD = RegistryEntry.item(Constants.id("copper_head"),
            ()-> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> IRON_HEAD = RegistryEntry.item(Constants.id("iron_head"),
            ()-> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> GOLD_HEAD = RegistryEntry.item(Constants.id("gold_head"),
            ()-> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> DIAMOND_HEAD = RegistryEntry.item(Constants.id("diamond_head"),
            ()-> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> NETHERITE_HEAD = RegistryEntry.item(Constants.id("netherite_head"),
            ()-> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> AMETHYST_HEAD = RegistryEntry.item(Constants.id("amethyst_head"),
            ()-> new Item(new Item.Properties()));

    //Giant Heads
    public static final RegistryEntry<Item> GIANT_STONE_HEAD = RegistryEntry.item(Constants.id("giant_stone_head"),
            ()-> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> GIANT_COPPER_HEAD = RegistryEntry.item(Constants.id("giant_copper_head"),
            ()-> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> GIANT_IRON_HEAD = RegistryEntry.item(Constants.id("giant_iron_head"),
            ()-> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> GIANT_GOLD_HEAD = RegistryEntry.item(Constants.id("giant_gold_head"),
            ()-> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> GIANT_DIAMOND_HEAD = RegistryEntry.item(Constants.id("giant_diamond_head"),
            ()-> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> GIANT_NETHERITE_HEAD = RegistryEntry.item(Constants.id("giant_netherite_head"),
            ()-> new Item(new Item.Properties()));
    public static final RegistryEntry<Item> GIANT_AMETHYST_HEAD = RegistryEntry.item(Constants.id("giant_amethyst_head"),
            ()-> new Item(new Item.Properties()));


}