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

    public static final RegistryEntry<CreativeModeTab> HAMMER_MOD_TAB_MAIN = RegistryEntry.creativeModeTab(Constants.id("itemGroup_main"), builder -> {
        builder.title(Component.translatable("itemGroup." + Constants.MOD_ID + ".main"));
        builder.icon(()-> new ItemStack(ModItems.STONE_HAMMER.get()));
        Services.PLATFORM.setupCreativeTabDisplayItems(builder);
    });

}
