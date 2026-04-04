package net.tier1234.hammermod.registries;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.enchantment.custom.AutoSmeltEnchantmentEffect;
import net.tier1234.hammermod.enchantment.custom.DiggingEnchantmentEffect;
import net.tier1234.hammermod.enchantment.custom.ExcavatorEnchantmentEffect;
import net.tier1234.hammermod.enchantment.custom.VeinMinerEnchantmentEffect;

public class ModEnchantmentEffects {
    public static void register() {
        Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE,
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "digging"),
                DiggingEnchantmentEffect.CODEC);

        Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE,
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "autosmelt"),
                AutoSmeltEnchantmentEffect.CODEC);

        Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE,
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "excavator"),
                ExcavatorEnchantmentEffect.CODEC);

        Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE,
                ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "veinminer"),
                VeinMinerEnchantmentEffect.CODEC);
    }
}