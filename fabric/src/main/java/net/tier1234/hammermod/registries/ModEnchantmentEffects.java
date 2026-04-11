package net.tier1234.hammermod.registries;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.enchantment.custom.*;

public class ModEnchantmentEffects {
    public static void register() {
        Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, "digging"),
                DiggingEnchantmentEffect.CODEC);

        Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, "autosmelt"),
                AutoSmeltEnchantmentEffect.CODEC);

        Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, "excavator"),
                ExcavatorEnchantmentEffect.CODEC);

        Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, "veinminer"),
                VeinMinerEnchantmentEffect.CODEC);

        Registry.register(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE,
                Identifier.fromNamespaceAndPath(Constants.MOD_ID, "land_breaker"),
                LandBreakerEnchantmentEffect.CODEC);
    }
}