package net.tier1234.hammermod.registries;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.platform.Services;

public class ModCreativeTabs {

    public static final ResourceKey<CreativeModeTab> TAB_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), Constants.id("creative_tab"));

    public static final CreativeModeTab HAMMER_MOD_ITEMS = Services.PLATFORM.getCreativeTabBuilder()
            .icon(() -> new ItemStack(ModItems.STONE_HEAD))
            .title(Component.translatable("creativetab.hammer_mod.hammer_mod_items"))
            .displayItems((parameters, output) -> {

                output.accept(ModItems.STONE_HEAD);

                /*   output.accept(net.tier1234.hammermod.item.ModItems.IRON_HEAD);
                output.accept(net.tier1234.hammermod.item.ModItems.COPPER_HEAD);
                output.accept(net.tier1234.hammermod.item.ModItems.AMETHYST_HEAD);
                output.accept(net.tier1234.hammermod.item.ModItems.GOLD_HEAD);
                output.accept(net.tier1234.hammermod.item.ModItems.DIAMOND_HEAD);
                output.accept(net.tier1234.hammermod.item.ModItems.NETHERITE_HEAD);
                output.accept(net.tier1234.hammermod.item.ModItems.GIANT_STONE_HEAD);
                output.accept(net.tier1234.hammermod.item.ModItems.GIANT_IRON_HEAD);
                output.accept(net.tier1234.hammermod.item.ModItems.GIANT_COPPER_HEAD);
                output.accept(net.tier1234.hammermod.item.ModItems.GIANT_AMETHYST_HEAD);
                output.accept(net.tier1234.hammermod.item.ModItems.GIANT_GOLD_HEAD);
                output.accept(net.tier1234.hammermod.item.ModItems.GIANT_DIAMOND_HEAD);
                output.accept(net.tier1234.hammermod.item.ModItems.GIANT_NETHERITE_HEAD);
                output.accept(net.tier1234.hammermod.item.ModItems.TINY_STICK);
                output.accept(ModItems.COPPER_HEAD);*/

            })
            .build();

    public static final CreativeModeTab HAMMER_MOD_TOOLS = Services.PLATFORM.getCreativeTabBuilder()
            .icon(() -> new ItemStack(ModItems.STONE_HAMMER))
            .title(Component.translatable("creativetab.hammer_mod.hammer_mod_tools"))
            .displayItems((parameters, output) -> {

                output.accept(ModItems.STONE_HAMMER);
              /*  output.accept(ModItems.IRON_HAMMER);
                output.accept(ModItems.COPPER_HAMMER);
                output.accept(ModItems.AMETHYST_HAMMER);
                output.accept(ModItems.GOLD_HAMMER);
                output.accept(ModItems.DIAMOND_HAMMER);
                output.accept(ModItems.NETHERITE_HAMMER);
                output.accept(ModItems.TINY_STONE_HAMMER);
                output.accept(ModItems.TINY_IRON_HAMMER);
                output.accept(ModItems.TINY_COPPER_HAMMER);
                output.accept(ModItems.TINY_AMETHYST_HAMMER);
                output.accept(ModItems.TINY_GOLD_HAMMER);
                output.accept(ModItems.TINY_DIAMOND_HAMMER);
                output.accept(ModItems.TINY_NETHERITE_HAMMER);
                output.accept(ModItems.GIANT_STONE_HAMMER);
                output.accept(ModItems.GIANT_IRON_HAMMER);
                output.accept(ModItems.GIANT_COPPER_HAMMER);
                output.accept(ModItems.GIANT_AMETHYST_HAMMER);
                output.accept(ModItems.GIANT_GOLD_HAMMER);
                output.accept(ModItems.GIANT_DIAMOND_HAMMER);
                output.accept(ModItems.GIANT_NETHERITE_HAMMER);
                output.accept(ModItems.HAMMER_SMITHING_TEMPLATE); */

            })
            .build();

    public static void register() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, TAB_KEY, HAMMER_MOD_ITEMS);
    }

}
