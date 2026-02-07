package net.tier1234.hammermod.registries;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tier1234.hammermod.Constants;

@RegistryContainer
public class ModCreativeTabs {

    public static final RegistryEntry<CreativeModeTab> HAMMER_MOD_TAB_ITEMS = RegistryEntry.creativeModeTab(Constants.id("creative_tab_items"), builder -> {
        builder.title(Component.translatable("creativetab.hammer_mod.hammer_mod_items"));
        builder.icon(()-> new ItemStack(ModItems.HAMEMR_SMITHING_TEMPLATE.get()));
        builder.displayItems((params, output) -> {
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
        });
    });

    public static final RegistryEntry<CreativeModeTab> HAMMER_MOD_TAB_TOOLS = RegistryEntry.creativeModeTab(Constants.id("creative_tab_tools"), builder -> {
        builder.title(Component.translatable("creativetab.hammer_mod.hammer_mod_tools"));
        builder.icon(()-> new ItemStack(ModItems.STONE_HAMMER.get()));
        builder.displayItems((params, output) -> {
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

        });
    });

}
