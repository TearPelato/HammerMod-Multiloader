package net.tier1234.hammermod.registries;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.hammermod.Constants;

import java.util.stream.IntStream;

public class ModCreativeTabs {
        
    public static final ObjectRegistries<CreativeModeTab> HAMMER_MOD_TAB_ITEMS = ObjectRegistries.registerCreativeTab(Constants.id("creative_tab_items"),
            ()->  new CreativeModeTab.Builder(CreativeModeTab.Row.TOP,1)
                    .title(Component.translatable("creativetab.hammer_mod.hammer_mod_items"))
                    .icon(()-> new ItemStack(ModItems.HAMEMR_SMITHING_TEMPLATE.get()))
                    .displayItems((parameters, output)-> {
                        output.accept(ModItems.STONE_HEAD.get());
                        output.accept(ModItems.COPPER_HEAD.get());
                        output.accept(ModItems.AMETHYST_HEAD.get());
                        output.accept(ModItems.IRON_HEAD.get());
                        output.accept(ModItems.GOLD_HEAD.get());
                        output.accept(ModItems.DIAMOND_HEAD.get());
                        output.accept(ModItems.NETHERITE_HEAD.get());

                        output.accept(ModItems.GIANT_STONE_HEAD.get());
                        output.accept(ModItems.GIANT_COPPER_HEAD.get());
                        output.accept(ModItems.GIANT_AMETHYST_HEAD.get());
                        output.accept(ModItems.GIANT_IRON_HEAD.get());
                        output.accept(ModItems.GIANT_GOLD_HEAD.get());
                        output.accept(ModItems.GIANT_DIAMOND_HEAD.get());
                        output.accept(ModItems.GIANT_NETHERITE_HEAD.get());

                        output.accept(ModItems.HAMEMR_SMITHING_TEMPLATE.get());
                        output.accept(ModItems.TINY_STICK.get());



                    }).build());


    public static final ObjectRegistries<CreativeModeTab> HAMMER_MOD_TAB_TOOLS = ObjectRegistries.registerCreativeTab(Constants.id("creative_tab_tools"),
            ()-> new CreativeModeTab.Builder(CreativeModeTab.Row.TOP, 2)
                    .title(Component.translatable("creativetab.hammer_mod.hammer_mod_tools"))
                    .icon(()-> new ItemStack(ModItems.STONE_HAMMER.get()))
                    .displayItems((parameters, output)-> {
                        output.accept(ModItems.STONE_HAMMER.get());
                        output.accept(ModItems.AMETHYST_HAMMER.get());
                        output.accept(ModItems.COPPER_HAMMER.get());
                        output.accept(ModItems.IRON_HAMMER.get());
                        output.accept(ModItems.GOLD_HAMMER.get());
                        output.accept(ModItems.DIAMOND_HAMMER.get());
                        output.accept(ModItems.NETHERITE_HAMMER.get());

                        output.accept(ModItems.TINY_STONE_HAMMER.get());
                        output.accept(ModItems.TINY_AMETHYST_HAMMER.get());
                        output.accept(ModItems.TINY_COPPER_HAMMER.get());
                        output.accept(ModItems.TINY_IRON_HAMMER.get());
                        output.accept(ModItems.TINY_GOLD_HAMMER.get());
                        output.accept(ModItems.TINY_DIAMOND_HAMMER.get());
                        output.accept(ModItems.TINY_NETHERITE_HAMMER.get());

                        output.accept(ModItems.GIANT_STONE_HAMMER.get());
                        output.accept(ModItems.GIANT_AMETHYST_HAMMER.get());
                        output.accept(ModItems.GIANT_COPPER_HAMMER.get());
                        output.accept(ModItems.GIANT_IRON_HAMMER.get());
                        output.accept(ModItems.GIANT_GOLD_HAMMER.get());
                        output.accept(ModItems.GIANT_DIAMOND_HAMMER.get());
                        output.accept(ModItems.GIANT_NETHERITE_HAMMER.get());
                    }).build());


    public static void init() {}
}
