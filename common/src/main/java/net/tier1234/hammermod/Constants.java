package net.tier1234.hammermod;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MOD_ID = "hammer_mod";
	public static final String MOD_NAME = "Hammer Additions";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);


    public static  Identifier id(String name){
        return Identifier.fromNamespaceAndPath(MOD_ID, name);
    }

    public static ResourceKey<Block> getBlockKey(Block block){
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }

    public static ResourceKey<Item> getItemKey(Item item){
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }
}