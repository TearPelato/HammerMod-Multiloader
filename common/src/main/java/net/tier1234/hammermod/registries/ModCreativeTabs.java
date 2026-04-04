package net.tier1234.hammermod.registries;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.platform.Services;

@RegistryContainer
public class ModCreativeTabs {

    public static final RegistryEntry<CreativeModeTab> HAMMER_MOD_TAB_ITEMS = RegistryEntry.creativeModeTab(Constants.id("creative_tab_items"), builder -> {
        builder.title(Component.translatable("creativetab.hammer_mod.hammer_mod_items"));
        builder.icon(()-> new ItemStack(ModItems.HAMEMR_SMITHING_TEMPLATE.get()));
        Services.PLATFORM.setupCreativeTabDisplayItems(builder);
    });

    public static final RegistryEntry<CreativeModeTab> HAMMER_MOD_TAB_TOOLS = RegistryEntry.creativeModeTab(Constants.id("creative_tab_tools"), builder -> {
        builder.title(Component.translatable("creativetab.hammer_mod.hammer_mod_tools"));
        builder.icon(()-> new ItemStack(ModItems.STONE_HAMMER.get()));
        Services.PLATFORM.setupCreativeTabDisplayItems(builder);
    });

}
