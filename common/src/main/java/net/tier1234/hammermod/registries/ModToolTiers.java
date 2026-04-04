package net.tier1234.hammermod.registries;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class ModToolTiers {

    public static final Tier COPPER = new Tier() {

        @Override
        public int getUses() {
            return 190;
        }

        @Override
        public float getSpeed() {
            return 3F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 3F;
        }



        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            return BlockTags.INCORRECT_FOR_IRON_TOOL;
        }

        @Override
        public int getEnchantmentValue() {
            return 25;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.COPPER_INGOT);
        }
    };

    public static final Tier AMETHYST = new Tier() {

        @Override
        public int getUses() {
            return 150;
        }

        @Override
        public float getSpeed() {
            return 2F;
        }

        @Override
        public float getAttackDamageBonus() {
            return 2F;
        }



        @Override
        public TagKey<Block> getIncorrectBlocksForDrops() {
            return BlockTags.INCORRECT_FOR_STONE_TOOL;
        }

        @Override
        public int getEnchantmentValue() {
            return 25;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.AMETHYST_BLOCK);
        }
    };
}




