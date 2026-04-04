package net.tier1234.hammermod.enchantment.custom.helper;


import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.tier1234.hammermod.platform.Services;

public class AutoSmeltHelper {
    public static void damageItem(ItemStack tool, Player player) {
        Services.PLATFORM.damageItemAutoSmelt(tool, player);
    }
}