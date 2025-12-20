package net.tier1234.hammermod.registries;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tiers;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.item.custom.HammerItem;

public class ModItems {

    //Hammer 3x3
    public static final Item STONE_HAMMER = new HammerItem(Tiers.STONE, new Item.Properties().attributes(PickaxeItem.createAttributes(Tiers.STONE, 7F, -3.5f)));
    public static final Item STONE_HEAD = new Item(new Item.Properties());


    public static void register() {
        Registry.register(BuiltInRegistries.ITEM, Constants.id("stone_hammer"), STONE_HAMMER);
        Registry.register(BuiltInRegistries.ITEM, Constants.id("stone_head"), STONE_HEAD);
    }
}