package net.tier1234.hammermod.registries;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.enchantment.custom.*;

import java.util.function.Supplier;

public class ModEnchantmentEffects {

    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENCHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Constants.MOD_ID);

    public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> DIGGING =
            ENCHANTMENT_EFFECTS.register("digging", () -> DiggingEnchantmentEffect.CODEC);

   public static final Supplier<MapCodec<? extends  EnchantmentEntityEffect>> AUTOSMELT =
            ENCHANTMENT_EFFECTS.register("autosmelt", ()-> AutoSmeltEnchantmentEffect.CODEC);

    public static final Supplier<MapCodec<? extends  EnchantmentEntityEffect>> EXCAVATOR =
            ENCHANTMENT_EFFECTS.register("excavator",()-> ExcavatorEnchantmentEffect.CODEC);


    public static final Supplier<MapCodec<? extends  EnchantmentEntityEffect>> VEINMINER =
            ENCHANTMENT_EFFECTS.register("veinminer",()-> VeinMinerEnchantmentEffect.CODEC);

    public static final Supplier<MapCodec<? extends  EnchantmentEntityEffect>> LAND_BREAKER =
            ENCHANTMENT_EFFECTS.register("land_breaker",()-> LandBreakerEnchantmentEffect.CODEC);

    public static void register(IEventBus eventBus) {
        ENCHANTMENT_EFFECTS.register(eventBus);
    }
}