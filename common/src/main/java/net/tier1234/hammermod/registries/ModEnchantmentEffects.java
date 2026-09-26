package net.tier1234.hammermod.registries;

import com.mojang.serialization.MapCodec;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.enchantment.custom.AutoSmeltEnchantmentEffect;
import net.tier1234.hammermod.enchantment.custom.DiggingEnchantmentEffect;
import net.tier1234.hammermod.enchantment.custom.ExcavatorEnchantmentEffect;
import net.tier1234.hammermod.enchantment.custom.VeinMinerEnchantmentEffect;

public class ModEnchantmentEffects {

    public static final ObjectRegistries<MapCodec<EnchantmentEntityEffect>> AUTOSMELT = ObjectRegistries.registerEnchantmentEffect(
            Constants.id("autosmelt"), ()-> AutoSmeltEnchantmentEffect.CODEC);

    public static final ObjectRegistries<MapCodec<EnchantmentEntityEffect>> DIGGING = ObjectRegistries.registerEnchantmentEffect(
            Constants.id("digging"), () -> DiggingEnchantmentEffect.CODEC);


    public static final ObjectRegistries<MapCodec<EnchantmentEntityEffect>> EXCAVATOR = ObjectRegistries.registerEnchantmentEffect(
            Constants.id("excavator"),()-> ExcavatorEnchantmentEffect.CODEC);


    public static final ObjectRegistries<MapCodec<EnchantmentEntityEffect>> VEINMINER = ObjectRegistries.registerEnchantmentEffect(
            Constants.id("veinminer"),()-> VeinMinerEnchantmentEffect.CODEC);



    public static void init() {}
}
