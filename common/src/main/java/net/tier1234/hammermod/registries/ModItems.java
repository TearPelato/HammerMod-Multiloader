package net.tier1234.hammermod.registries;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ToolMaterial;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.item.custom.*;

@RegistryContainer
public class ModItems {

    /**
     *Hammers Registries:
     * Using Framework {@link RegistryEntry} to registry everything on multiloader
     * */
//Base Hammers Registries

    public static final RegistryEntry<HammerItem> STONE_HAMMER = RegistryEntry.item(Constants.id("stone_hammer"),
        HammerItem::new, () -> new Item.Properties().pickaxe(ToolMaterial.STONE, 7F, -3.5f));

    public static final RegistryEntry<HammerItem> COPPER_HAMMER = RegistryEntry.item(Constants.id("copper_hammer"),
            HammerItem::new, () -> new Item.Properties().pickaxe(ToolMaterial.COPPER, 7F, -3.5f));


    public static final RegistryEntry<HammerItem> IRON_HAMMER = RegistryEntry.item(Constants.id("iron_hammer"),
            HammerItem::new, () -> new Item.Properties().pickaxe(ToolMaterial.IRON, 7F, -3.5f));


    public static final RegistryEntry<HammerItem> GOLD_HAMMER = RegistryEntry.item(Constants.id("gold_hammer"),
            HammerItem::new, () -> new Item.Properties().pickaxe(ToolMaterial.GOLD, 7F, -3.5f));


    public static final RegistryEntry<HammerItem> DIAMOND_HAMMER = RegistryEntry.item(Constants.id("diamond_hammer"),
            HammerItem::new, () -> new Item.Properties().pickaxe(ToolMaterial.DIAMOND, 7F, -3.5f));


    public static final RegistryEntry<HammerItem> NETHERITE_HAMMER = RegistryEntry.item(Constants.id("netherite_hammer"),
            HammerItem::new, () -> new Item.Properties().pickaxe(ToolMaterial.NETHERITE, 7F, -3.5f));


    public static final RegistryEntry<HammerItem> AMETHYST_HAMMER = RegistryEntry.item(Constants.id("amethyst_hammer"),
            HammerItem::new, () -> new Item.Properties().pickaxe(ModToolTiers.AMETHYST, 7F, -3.5f));


//Tiny Hammers registries
public static final RegistryEntry<HammerItem2x2> TINY_STONE_HAMMER = RegistryEntry.item(Constants.id("tiny_stone_hammer"),
        HammerItem2x2::new,() -> new Item.Properties().pickaxe(ToolMaterial.STONE, 7F, -3.5f));


    public static final RegistryEntry<HammerItem2x2> TINY_COPPER_HAMMER = RegistryEntry.item(Constants.id("tiny_copper_hammer"),
            HammerItem2x2::new,() -> new Item.Properties().pickaxe(ToolMaterial.COPPER, 7F, -3.5f));


    public static final RegistryEntry<HammerItem2x2> TINY_IRON_HAMMER = RegistryEntry.item(Constants.id("tiny_iron_hammer"),
            HammerItem2x2::new,() -> new Item.Properties().pickaxe(ToolMaterial.IRON, 7F, -3.5f));


    public static final RegistryEntry<HammerItem2x2> TINY_GOLD_HAMMER = RegistryEntry.item(Constants.id("tiny_gold_hammer"),
            HammerItem2x2::new,() -> new Item.Properties().pickaxe(ToolMaterial.GOLD, 7F, -3.5f));


    public static final RegistryEntry<HammerItem2x2> TINY_DIAMOND_HAMMER = RegistryEntry.item(Constants.id("tiny_diamond_hammer"),
            HammerItem2x2::new,() -> new Item.Properties().pickaxe(ToolMaterial.DIAMOND, 7F, -3.5f));


    public static final RegistryEntry<HammerItem2x2> TINY_NETHERITE_HAMMER = RegistryEntry.item(Constants.id("tiny_netherite_hammer"),
            HammerItem2x2::new,() -> new Item.Properties().pickaxe(ToolMaterial.NETHERITE, 7F, -3.5f));


    public static final RegistryEntry<HammerItem2x2> TINY_AMETHYST_HAMMER = RegistryEntry.item(Constants.id("tiny_amethyst_hammer"),
            HammerItem2x2::new,() -> new Item.Properties().pickaxe(ModToolTiers.AMETHYST, 7F, -3.5f));


//Giant Hammers Registries
    public static final RegistryEntry<HammerItem5x5> GIANT_STONE_HAMMER = RegistryEntry.item(Constants.id("giant_stone_hammer"),
        HammerItem5x5::new,() -> new Item.Properties().pickaxe(ToolMaterial.STONE, 7F, -3.5f));


    public static final RegistryEntry<HammerItem5x5> GIANT_COPPER_HAMMER = RegistryEntry.item(Constants.id("giant_copper_hammer"),
            HammerItem5x5::new,() -> new Item.Properties().pickaxe(ToolMaterial.COPPER, 7F, -3.5f));


    public static final RegistryEntry<HammerItem5x5> GIANT_IRON_HAMMER = RegistryEntry.item(Constants.id("giant_iron_hammer"),
            HammerItem5x5::new,() -> new Item.Properties().pickaxe(ToolMaterial.IRON, 7F, -3.5f));


    public static final RegistryEntry<HammerItem5x5> GIANT_GOLD_HAMMER = RegistryEntry.item(Constants.id("giant_gold_hammer"),
            HammerItem5x5::new,() -> new Item.Properties().pickaxe(ToolMaterial.GOLD, 7F, -3.5f));


    public static final RegistryEntry<HammerItem5x5> GIANT_DIAMOND_HAMMER = RegistryEntry.item(Constants.id("giant_diamond_hammer"),
            HammerItem5x5::new,() -> new Item.Properties().pickaxe(ToolMaterial.DIAMOND, 7F, -3.5f));


    public static final RegistryEntry<HammerItem5x5> GIANT_NETHERITE_HAMMER = RegistryEntry.item(Constants.id("giant_netherite_hammer"),
            HammerItem5x5::new,() -> new Item.Properties().pickaxe(ToolMaterial.NETHERITE, 7F, -3.5f));


    public static final RegistryEntry<HammerItem5x5> GIANT_AMETHYST_HAMMER = RegistryEntry.item(Constants.id("giant_amethyst_hammer"),
            HammerItem5x5::new,() -> new Item.Properties().pickaxe(ModToolTiers.AMETHYST, 7F, -3.5f));




    //Template Registry
    public static final RegistryEntry<HammerTemplateItem> HAMEMR_SMITHING_TEMPLATE = RegistryEntry.item(Constants.id("hammer_smithing_template"),
            HammerTemplateItem::createHammerUpgradeTemplate, Item.Properties::new);


//Simple Items Registries
    //Heads
    public static final RegistryEntry<Item> STONE_HEAD = RegistryEntry.item(Constants.id("stone_head"),
        Item::new, Item.Properties::new);
    public static final RegistryEntry<Item> COPPER_HEAD = RegistryEntry.item(Constants.id("copper_head"),
            Item::new, Item.Properties::new);
    public static final RegistryEntry<Item> IRON_HEAD = RegistryEntry.item(Constants.id("iron_head"),
            Item::new, Item.Properties::new);
    public static final RegistryEntry<Item> GOLD_HEAD = RegistryEntry.item(Constants.id("gold_head"),
            Item::new, Item.Properties::new);
    public static final RegistryEntry<Item> DIAMOND_HEAD = RegistryEntry.item(Constants.id("diamond_head"),
            Item::new, Item.Properties::new);
    public static final RegistryEntry<Item> NETHERITE_HEAD = RegistryEntry.item(Constants.id("netherite_head"),
            Item::new, Item.Properties::new);
    public static final RegistryEntry<Item> AMETHYST_HEAD = RegistryEntry.item(Constants.id("amethyst_head"),
            Item::new, Item.Properties::new);

    //Giant Heads
    public static final RegistryEntry<Item> GIANT_STONE_HEAD = RegistryEntry.item(Constants.id("giant_stone_head"),
            Item::new, Item.Properties::new);
    public static final RegistryEntry<Item> GIANT_COPPER_HEAD = RegistryEntry.item(Constants.id("giant_copper_head"),
            Item::new, Item.Properties::new);
    public static final RegistryEntry<Item> GIANT_IRON_HEAD = RegistryEntry.item(Constants.id("giant_iron_head"),
            Item::new, Item.Properties::new);
    public static final RegistryEntry<Item> GIANT_GOLD_HEAD = RegistryEntry.item(Constants.id("giant_gold_head"),
            Item::new, Item.Properties::new);
    public static final RegistryEntry<Item> GIANT_DIAMOND_HEAD = RegistryEntry.item(Constants.id("giant_diamond_head"),
            Item::new, Item.Properties::new);
    public static final RegistryEntry<Item> GIANT_NETHERITE_HEAD = RegistryEntry.item(Constants.id("giant_netherite_head"),
            Item::new, Item.Properties::new);
    public static final RegistryEntry<Item> GIANT_AMETHYST_HEAD = RegistryEntry.item(Constants.id("giant_amethyst_head"),
            Item::new, Item.Properties::new);

    public static final RegistryEntry<Item> TINY_STICK = RegistryEntry.item(Constants.id("tiny_stick"), Item::new, Item.Properties::new);

    public static final RegistryEntry<MagnetItem> MAGNET = RegistryEntry.item(Constants.id("magnet"), MagnetItem::new, MagnetItem.Properties::new);

}