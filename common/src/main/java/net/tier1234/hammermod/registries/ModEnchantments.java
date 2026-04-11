package net.tier1234.hammermod.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.enchantment.custom.*;
import net.tier1234.hammermod.util.ModTags;

public class ModEnchantments {

    public static final ResourceKey<Enchantment> DIGGING = ResourceKey.create(
            Registries.ENCHANTMENT,
            Identifier.fromNamespaceAndPath(Constants.MOD_ID, "digging")
    );


    public static final ResourceKey<Enchantment> EXCAVATOR = ResourceKey.create(
            Registries.ENCHANTMENT,
            Identifier.fromNamespaceAndPath(Constants.MOD_ID, "excavator")
    );
    public static final ResourceKey<Enchantment> VEINMINER = ResourceKey.create(
            Registries.ENCHANTMENT,
            Identifier.fromNamespaceAndPath(Constants.MOD_ID, "veinminer")
    );
    public static final ResourceKey<Enchantment> AUTOSMELT = ResourceKey.create(
            Registries.ENCHANTMENT,
            Identifier.fromNamespaceAndPath(Constants.MOD_ID, "autosmelt")
    );
    public static final ResourceKey<Enchantment> LAND_BREAKER = ResourceKey.create(
            Registries.ENCHANTMENT,
            Identifier.fromNamespaceAndPath(Constants.MOD_ID, "land_breaker")
    );


    public static void bootstrap(BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        register(context, DIGGING, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(ItemTags.MINING_ENCHANTABLE),
                items.getOrThrow(ItemTags.PICKAXES),
                2,
                1,
                Enchantment.dynamicCost(10, 8),
                Enchantment.dynamicCost(40, 8),
                3,
                EquipmentSlotGroup.MAINHAND
        )).withEffect(
                EnchantmentEffectComponents.POST_ATTACK,
                EnchantmentTarget.ATTACKER,
                EnchantmentTarget.VICTIM,
                new DiggingEnchantmentEffect()
        ));

        register(context, EXCAVATOR, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(ItemTags.MINING_ENCHANTABLE),
                items.getOrThrow(ItemTags.PICKAXES),
                2,
                1,
                Enchantment.dynamicCost(10, 8),
                Enchantment.dynamicCost(40, 8),
                7,
                EquipmentSlotGroup.MAINHAND
        )).withEffect(
                EnchantmentEffectComponents.POST_ATTACK,
                EnchantmentTarget.ATTACKER,
                EnchantmentTarget.VICTIM,
                new ExcavatorEnchantmentEffect()
        ));


        register(context, VEINMINER, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(ItemTags.MINING_ENCHANTABLE),
                items.getOrThrow(ItemTags.PICKAXES),
                2,
                1,
                Enchantment.dynamicCost(10, 8),
                Enchantment.dynamicCost(40, 8),
                5,
                EquipmentSlotGroup.MAINHAND
        )).withEffect(
                EnchantmentEffectComponents.POST_ATTACK,
                EnchantmentTarget.ATTACKER,
                EnchantmentTarget.VICTIM,
                new VeinMinerEnchantmentEffect()
        ));

        register(context, AUTOSMELT, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(ItemTags.MINING_ENCHANTABLE),
                items.getOrThrow(ItemTags.PICKAXES),
                1,
                1,
                Enchantment.dynamicCost(30, 10),
                Enchantment.dynamicCost(70, 10),
                8,
                EquipmentSlotGroup.MAINHAND
        )).withEffect(
                EnchantmentEffectComponents.POST_ATTACK,
                EnchantmentTarget.ATTACKER,
                EnchantmentTarget.VICTIM,
                new AutoSmeltEnchantmentEffect()
        ));

        register(context, LAND_BREAKER, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(ModTags.Items.HAMMER_CAN_BE_ENCHANTED),
                1,
                1,
                Enchantment.dynamicCost(30, 10),
                Enchantment.dynamicCost(70, 10),
                8,
                EquipmentSlotGroup.MAINHAND
        )).withEffect(
                EnchantmentEffectComponents.POST_ATTACK,
                EnchantmentTarget.ATTACKER,
                EnchantmentTarget.VICTIM,
                new LandBreakerEnchantmentEffect()
        ));

    }

    private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key,
                                 Enchantment.Builder builder) {
        registry.register(key, builder.build(key.identifier()));
    }
}