package tierability.item.armor;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tierability.TierabilityMod;
import tierability.api.armor.ArmorEffectRegistry;
import tierability.item.base.BaseArmorItem;

public class TierabilityArmor {

    public static final Item T1_HELMET = new BaseArmorItem(TierabilityArmorMaterials.T1_ARMOR_MATERIAL, EquipmentSlot.HEAD, "speed");
    public static final Item T1_CHESTPLATE = new BaseArmorItem(TierabilityArmorMaterials.T1_ARMOR_MATERIAL, EquipmentSlot.CHEST, "speed");
    public static final Item T1_LEGGINGS = new BaseArmorItem(TierabilityArmorMaterials.T1_ARMOR_MATERIAL, EquipmentSlot.LEGS, "speed");
    public static final Item T1_BOOTS = new BaseArmorItem(TierabilityArmorMaterials.T1_ARMOR_MATERIAL, EquipmentSlot.FEET, "speed");

    public static final Item T2_HELMET = new BaseArmorItem(TierabilityArmorMaterials.T2_ARMOR_MATERIAL, EquipmentSlot.HEAD, "jump_boost");
    public static final Item T2_CHESTPLATE = new BaseArmorItem(TierabilityArmorMaterials.T2_ARMOR_MATERIAL, EquipmentSlot.CHEST, "jump_boost");
    public static final Item T2_LEGGINGS = new BaseArmorItem(TierabilityArmorMaterials.T2_ARMOR_MATERIAL, EquipmentSlot.LEGS, "jump_boost");
    public static final Item T2_BOOTS = new BaseArmorItem(TierabilityArmorMaterials.T2_ARMOR_MATERIAL, EquipmentSlot.FEET, "jump_boost");

    public static final Item T1_HELMET_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T1_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.HEAD, "speed");
    public static final Item T1_CHESTPLATE_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T1_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.CHEST, "speed");
    public static final Item T1_LEGGINGS_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T1_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.LEGS, "speed");
    public static final Item T1_BOOTS_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T1_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.FEET, "speed");

    public static final Item T2_HELMET_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T2_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.HEAD, "jump_boost");
    public static final Item T2_CHESTPLATE_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T2_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.CHEST, "jump_boost");
    public static final Item T2_LEGGINGS_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T2_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.LEGS, "jump_boost");
    public static final Item T2_BOOTS_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T2_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.FEET, "jump_boost");

    public static void register(){
        registerArmorSet("t1", T1_HELMET, T1_CHESTPLATE, T1_LEGGINGS, T1_BOOTS);
        registerArmorSet("t2", T2_HELMET, T2_CHESTPLATE, T2_LEGGINGS, T2_BOOTS);

        registerArmorSet("t1_upgraded", T1_HELMET_UPGRADED, T1_CHESTPLATE_UPGRADED, T1_LEGGINGS_UPGRADED, T1_BOOTS_UPGRADED);
        registerArmorSet("t2_upgraded", T2_HELMET_UPGRADED, T2_CHESTPLATE_UPGRADED, T2_LEGGINGS_UPGRADED, T2_BOOTS_UPGRADED);

        registerArmorEffects();
    }

    static void registerArmorSet(String prefix, Item entryHelmet, Item entryChestplate, Item entryLeggings, Item entryBoots){
        Registry.register(Registry.ITEM, new Identifier(TierabilityMod.MODID, prefix + "_helmet"), entryHelmet);
        Registry.register(Registry.ITEM, new Identifier(TierabilityMod.MODID, prefix + "_chestplate"), entryChestplate);
        Registry.register(Registry.ITEM, new Identifier(TierabilityMod.MODID, prefix + "_leggings"), entryLeggings);
        Registry.register(Registry.ITEM, new Identifier(TierabilityMod.MODID, prefix + "_boots"), entryBoots);
    }

    static void registerArmorEffects(){
        ArmorEffectRegistry.register("T1 Armor", T1_HELMET, T1_CHESTPLATE, T1_LEGGINGS, T1_BOOTS, StatusEffects.SPEED, 0);
        ArmorEffectRegistry.register("T2 Armor", T2_HELMET, T2_CHESTPLATE, T2_LEGGINGS, T2_BOOTS, StatusEffects.JUMP_BOOST, 0);

        ArmorEffectRegistry.register("T1 Upgraded Armor", T1_HELMET_UPGRADED, T1_CHESTPLATE_UPGRADED, T1_LEGGINGS_UPGRADED, T1_BOOTS_UPGRADED, StatusEffects.SPEED, 1);
        ArmorEffectRegistry.register("T2 Upgraded Armor", T2_HELMET_UPGRADED, T2_CHESTPLATE_UPGRADED, T2_LEGGINGS_UPGRADED, T2_BOOTS_UPGRADED, StatusEffects.JUMP_BOOST, 1);
    }

}
