package net.tier1234.hammermod.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.List;
import java.util.function.Consumer;

public class HammerTemplateItem
       // extends Item
{
   /* private static final ChatFormatting TITLE_FORMAT = ChatFormatting.GRAY;
    private static final ChatFormatting DESCRIPTION_FORMAT = ChatFormatting.BLUE;
    private static final String DESCRIPTION_ID = Util.makeDescriptionId("item", Identifier.withDefaultNamespace("smithing_template"));
    private static final Component INGREDIENTS_TITLE = Component.translatable(Util.makeDescriptionId("item", Identifier.withDefaultNamespace("smithing_template.ingredients"))).withStyle(TITLE_FORMAT);
    private static final Component APPLIES_TO_TITLE = Component.translatable(Util.makeDescriptionId("item", Identifier.withDefaultNamespace("smithing_template.applies_to"))).withStyle(TITLE_FORMAT);
    private static final Component HAMMER_UPGRADE = Component.translatable("item.hammer_mod.hammer_upgrade.desc").withStyle(TITLE_FORMAT);
    private static final Component HAMMER_UPGRADE_APPLIES_TO = Component.translatable("item.hammer_mod.hammer_upgrade.applies_to.desc").withStyle(DESCRIPTION_FORMAT);
    private static final Component HAMMER_UPGRADE_INGREDIENTS = Component.translatable("item.hammer_mod.hammer_upgrade.ingredients.desc").withStyle(DESCRIPTION_FORMAT);


    private static final Component HAMMER_UPGRADE_BASE_SLOT_DESCRIPTION = Component.translatable("item.hammer_mod.hammer_upgrade.base_slot.desc");
    private static final Component HAMMER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION = Component.translatable("item.hammer_mod.hammer_upgrade.additions_slot.desc");
    private static final Identifier EMPTY_SLOT_HELMET = Identifier.withDefaultNamespace("item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_SLOT_CHESTPLATE = Identifier.withDefaultNamespace("item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_SLOT_LEGGINGS = Identifier.withDefaultNamespace("item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_SLOT_BOOTS = Identifier.withDefaultNamespace("item/empty_armor_slot_boots");
    private static final Identifier EMPTY_SLOT_INGOT = Identifier.withDefaultNamespace("item/empty_slot_ingot");
    private final Component appliesTo;
    private final Component ingredients;
    private final Component upgradeDescription;
    private final Component baseSlotDescription;
    private final Component additionsSlotDescription;
    private final List<Identifier> baseSlotEmptyIcons;
    private final List<Identifier> additionalSlotEmptyIcons;




    public HammerTemplateItem(Component p_266834_, Component p_267043_, Component p_267048_, Component p_267278_, Component p_267090_, List<Identifier> p_266755_, List<Identifier> p_267060_) {
        super(new Properties().fireResistant());
        this.appliesTo = p_266834_;
        this.ingredients = p_267043_;
        this.upgradeDescription = p_267048_;
        this.baseSlotDescription = p_267278_;
        this.additionsSlotDescription = p_267090_;
        this.baseSlotEmptyIcons = p_266755_;
        this.additionalSlotEmptyIcons = p_267060_;
    }


    public static HammerTemplateItem createhammerUpgradeTemplate() {
        return new HammerTemplateItem(HAMMER_UPGRADE_APPLIES_TO, HAMMER_UPGRADE_INGREDIENTS, HAMMER_UPGRADE, HAMMER_UPGRADE_BASE_SLOT_DESCRIPTION, HAMMER_UPGRADE_ADDITIONS_SLOT_DESCRIPTION, createhammerUpgradeIconList(), createhammerUpgradeMaterialList());
    }


    private static List<Identifier> createhammerUpgradeIconList() {
        return List.of(EMPTY_SLOT_HELMET, EMPTY_SLOT_CHESTPLATE, EMPTY_SLOT_LEGGINGS, EMPTY_SLOT_BOOTS);
    }

    private static List<Identifier> createhammerUpgradeMaterialList() {
        return List.of(EMPTY_SLOT_INGOT);
    }


    public void appendHoverText(ItemStack p_267313_, TooltipContext p_339591_, TooltipDisplay p_266820_, Consumer<Component> p_266830,TooltipFlag p_266857_) {
        super.appendHoverText(p_267313_, p_339591_, p_266820_, p_266830, p_266857_);
        p_266820_.add(this.upgradeDescription);
        p_266820_.add(CommonComponents.EMPTY);
        p_266820_.add(APPLIES_TO_TITLE);
        p_266820_.add(CommonComponents.space().append(this.appliesTo));
        p_266820_.add(INGREDIENTS_TITLE);
        p_266820_.add(CommonComponents.space().append(this.ingredients));
    }

    public Component getBaseSlotDescription() {
        return this.baseSlotDescription;
    }

    public Component getAdditionSlotDescription() {
        return this.additionsSlotDescription;
    }

    public List<Identifier> getBaseSlotEmptyIcons() {
        return this.baseSlotEmptyIcons;
    }

    public List<Identifier> getAdditionalSlotEmptyIcons() {
        return this.additionalSlotEmptyIcons;
    }*/

}
