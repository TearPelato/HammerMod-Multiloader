package net.tier1234.hammermod;

import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {

	public static final String MOD_ID = "hammer_mod";
	public static final String MOD_NAME = "Hammer Additions";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);


    public static  ResourceLocation id(String name){
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, name);
    }
}