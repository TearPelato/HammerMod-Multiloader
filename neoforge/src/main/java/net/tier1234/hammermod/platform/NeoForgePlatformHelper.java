package net.tier1234.hammermod.platform;

import com.mrcrayfish.framework.Registration;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.event.EventHooks;
import net.tier1234.hammermod.Constants;
import net.tier1234.hammermod.platform.services.IPlatformHelper;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {

        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.getCurrent().isProduction();
    }

    @Override
    public CreativeModeTab.Builder getCreativeTabBuilder() {
        return CreativeModeTab.builder();
    }

    @Override
    public void setupCreativeTabDisplayItems(CreativeModeTab.Builder builder)
    {
        builder.displayItems((params, output) -> {
            Registration.get(Registries.BLOCK).stream().filter(entry -> entry.getId().getNamespace().equals(Constants.MOD_ID)).forEach(entry -> {
                output.accept((ItemLike) entry.get());
            });
            Registration.get(Registries.ITEM).stream().filter(entry -> entry.getId().getNamespace().equals(Constants.MOD_ID)).forEach(entry -> {
                output.accept((ItemLike) entry.get());
            });
        });
    }

    @Override
    public void damageItemAutoSmelt(ItemStack tool, Player player) {
        EventHooks.onPlayerDestroyItem(player, tool, player.getUsedItemHand());
    }
}