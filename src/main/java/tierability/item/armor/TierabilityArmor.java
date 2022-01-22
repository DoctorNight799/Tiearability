package tierability.item.armor;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import tierability.TierabilityMod;
import tierability.api.armor.ArmorEffectRegistry;
import tierability.effect.TierabilityEffects;
import tierability.item.AmuletItem;
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

    public static final Item T3_HELMET = new BaseArmorItem(TierabilityArmorMaterials.T3_ARMOR_MATERIAL, EquipmentSlot.HEAD, "haste");
    public static final Item T3_CHESTPLATE = new BaseArmorItem(TierabilityArmorMaterials.T3_ARMOR_MATERIAL, EquipmentSlot.CHEST, "haste");
    public static final Item T3_LEGGINGS = new BaseArmorItem(TierabilityArmorMaterials.T3_ARMOR_MATERIAL, EquipmentSlot.LEGS, "haste");
    public static final Item T3_BOOTS = new BaseArmorItem(TierabilityArmorMaterials.T3_ARMOR_MATERIAL, EquipmentSlot.FEET, "haste");

    public static final Item T1_HELMET_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T1_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.HEAD, "speed");
    public static final Item T1_CHESTPLATE_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T1_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.CHEST, "speed");
    public static final Item T1_LEGGINGS_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T1_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.LEGS, "speed");
    public static final Item T1_BOOTS_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T1_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.FEET, "speed");

    public static final Item T2_HELMET_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T2_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.HEAD, "jump_boost");
    public static final Item T2_CHESTPLATE_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T2_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.CHEST, "jump_boost");
    public static final Item T2_LEGGINGS_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T2_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.LEGS, "jump_boost");
    public static final Item T2_BOOTS_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T2_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.FEET, "jump_boost");

    public static final Item T3_HELMET_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T3_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.HEAD, "haste");
    public static final Item T3_CHESTPLATE_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T3_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.CHEST, "haste");
    public static final Item T3_LEGGINGS_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T3_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.LEGS, "haste");
    public static final Item T3_BOOTS_UPGRADED = new BaseArmorItem(TierabilityArmorMaterials.T3_UPGRADED_ARMOR_MATERIAL, EquipmentSlot.FEET, "haste");

    public static final Item T1_HELMET_FLAME = new BaseArmorItem(TierabilityArmorMaterials.T1_FLAME_ARMOR_MATERIAL, EquipmentSlot.HEAD, "fire_resist");
    public static final Item T1_CHESTPLATE_FLAME = new BaseArmorItem(TierabilityArmorMaterials.T1_FLAME_ARMOR_MATERIAL, EquipmentSlot.CHEST, "fire_resist");
    public static final Item T1_LEGGINGS_FLAME = new BaseArmorItem(TierabilityArmorMaterials.T1_FLAME_ARMOR_MATERIAL, EquipmentSlot.LEGS, "fire_resist");
    public static final Item T1_BOOTS_FLAME = new BaseArmorItem(TierabilityArmorMaterials.T1_FLAME_ARMOR_MATERIAL, EquipmentSlot.FEET, "fire_resist");

    public static final Item T2_HELMET_FLAME = new BaseArmorItem(TierabilityArmorMaterials.T2_FLAME_ARMOR_MATERIAL, EquipmentSlot.HEAD, "fire_resist");
    public static final Item T2_CHESTPLATE_FLAME = new BaseArmorItem(TierabilityArmorMaterials.T2_FLAME_ARMOR_MATERIAL, EquipmentSlot.CHEST, "fire_resist");
    public static final Item T2_LEGGINGS_FLAME = new BaseArmorItem(TierabilityArmorMaterials.T2_FLAME_ARMOR_MATERIAL, EquipmentSlot.LEGS, "fire_resist");
    public static final Item T2_BOOTS_FLAME = new BaseArmorItem(TierabilityArmorMaterials.T2_FLAME_ARMOR_MATERIAL, EquipmentSlot.FEET, "fire_resist");

    public static final Item T1_HELMET_ELECTRO = new BaseArmorItem(TierabilityArmorMaterials.T1_ELECTRO_ARMOR_MATERIAL, EquipmentSlot.HEAD, "electric_field_effect");
    public static final Item T1_CHESTPLATE_ELECTRO = new BaseArmorItem(TierabilityArmorMaterials.T1_ELECTRO_ARMOR_MATERIAL, EquipmentSlot.CHEST, "electric_field_effect");
    public static final Item T1_LEGGINGS_ELECTRO = new BaseArmorItem(TierabilityArmorMaterials.T1_ELECTRO_ARMOR_MATERIAL, EquipmentSlot.LEGS, "electric_field_effect");
    public static final Item T1_BOOTS_ELECTRO = new BaseArmorItem(TierabilityArmorMaterials.T1_ELECTRO_ARMOR_MATERIAL, EquipmentSlot.FEET, "electric_field_effect");

    public static final Item T2_HELMET_ELECTRO = new BaseArmorItem(TierabilityArmorMaterials.T2_ELECTRO_ARMOR_MATERIAL, EquipmentSlot.HEAD, "electric_field_effect");
    public static final Item T2_CHESTPLATE_ELECTRO = new BaseArmorItem(TierabilityArmorMaterials.T2_ELECTRO_ARMOR_MATERIAL, EquipmentSlot.CHEST, "electric_field_effect");
    public static final Item T2_LEGGINGS_ELECTRO = new BaseArmorItem(TierabilityArmorMaterials.T2_ELECTRO_ARMOR_MATERIAL, EquipmentSlot.LEGS, "electric_field_effect");
    public static final Item T2_BOOTS_ELECTRO = new BaseArmorItem(TierabilityArmorMaterials.T2_ELECTRO_ARMOR_MATERIAL, EquipmentSlot.FEET, "electric_field_effect");

    static void registerArmorSet(String prefix, Item entryHelmet, Item entryChestplate, Item entryLeggings, Item entryBoots){
        Registry.register(Registry.ITEM, new Identifier(TierabilityMod.MODID, prefix + "_helmet"), entryHelmet);
        Registry.register(Registry.ITEM, new Identifier(TierabilityMod.MODID, prefix + "_chestplate"), entryChestplate);
        Registry.register(Registry.ITEM, new Identifier(TierabilityMod.MODID, prefix + "_leggings"), entryLeggings);
        Registry.register(Registry.ITEM, new Identifier(TierabilityMod.MODID, prefix + "_boots"), entryBoots);
    }

    static void registerArmorEffects(){
        ArmorEffectRegistry.register("T1 Armor", T1_HELMET, T1_CHESTPLATE, T1_LEGGINGS, T1_BOOTS, StatusEffects.SPEED, 0);
        ArmorEffectRegistry.register("T2 Armor", T2_HELMET, T2_CHESTPLATE, T2_LEGGINGS, T2_BOOTS, StatusEffects.JUMP_BOOST, 0);
        ArmorEffectRegistry.register("T3 Armor", T3_HELMET, T3_CHESTPLATE, T3_LEGGINGS, T3_BOOTS, StatusEffects.HASTE, 0);

        ArmorEffectRegistry.register("T1 Upgraded Armor", T1_HELMET_UPGRADED, T1_CHESTPLATE_UPGRADED, T1_LEGGINGS_UPGRADED, T1_BOOTS_UPGRADED, StatusEffects.SPEED, 1);
        ArmorEffectRegistry.register("T2 Upgraded Armor", T2_HELMET_UPGRADED, T2_CHESTPLATE_UPGRADED, T2_LEGGINGS_UPGRADED, T2_BOOTS_UPGRADED, StatusEffects.JUMP_BOOST, 1);
        ArmorEffectRegistry.register("T3 Upgraded Armor", T3_HELMET_UPGRADED, T3_CHESTPLATE_UPGRADED, T3_LEGGINGS_UPGRADED, T3_BOOTS_UPGRADED, StatusEffects.HASTE, 1);

        ArmorEffectRegistry.register("T1 Flame Armor", T1_HELMET_FLAME, T1_CHESTPLATE_FLAME, T1_LEGGINGS_FLAME, T1_BOOTS_FLAME, StatusEffects.FIRE_RESISTANCE, 0);
        ArmorEffectRegistry.register("T2 Flame Armor", T2_HELMET_FLAME, T2_CHESTPLATE_FLAME, T2_LEGGINGS_FLAME, T2_BOOTS_FLAME, StatusEffects.FIRE_RESISTANCE, 1);

        ArmorEffectRegistry.register("T1 Electro Armor", T1_HELMET_ELECTRO, T1_CHESTPLATE_ELECTRO, T1_LEGGINGS_ELECTRO, T1_BOOTS_ELECTRO, TierabilityEffects.ELECTRIC_FIELD_EFFECT, 0);
        ArmorEffectRegistry.register("T2 Electro Armor", T2_HELMET_ELECTRO, T2_CHESTPLATE_ELECTRO, T2_LEGGINGS_ELECTRO, T2_BOOTS_ELECTRO, TierabilityEffects.ELECTRIC_FIELD_EFFECT, 0);
    }

    public static void register(){
        registerArmorSet("t1", T1_HELMET, T1_CHESTPLATE, T1_LEGGINGS, T1_BOOTS);
        registerArmorSet("t2", T2_HELMET, T2_CHESTPLATE, T2_LEGGINGS, T2_BOOTS);
        registerArmorSet("t3", T3_HELMET, T3_CHESTPLATE, T3_LEGGINGS, T3_BOOTS);

        registerArmorSet("t1_upgraded", T1_HELMET_UPGRADED, T1_CHESTPLATE_UPGRADED, T1_LEGGINGS_UPGRADED, T1_BOOTS_UPGRADED);
        registerArmorSet("t2_upgraded", T2_HELMET_UPGRADED, T2_CHESTPLATE_UPGRADED, T2_LEGGINGS_UPGRADED, T2_BOOTS_UPGRADED);
        registerArmorSet("t3_upgraded", T3_HELMET_UPGRADED, T3_CHESTPLATE_UPGRADED, T3_LEGGINGS_UPGRADED, T3_BOOTS_UPGRADED);

        registerArmorSet("t1_flame", T1_HELMET_FLAME, T1_CHESTPLATE_FLAME, T1_LEGGINGS_FLAME, T1_BOOTS_FLAME);
        registerArmorSet("t2_flame", T2_HELMET_FLAME, T2_CHESTPLATE_FLAME, T2_LEGGINGS_FLAME, T2_BOOTS_FLAME);

        registerArmorSet("t1_electro", T1_HELMET_ELECTRO, T1_CHESTPLATE_ELECTRO, T1_LEGGINGS_ELECTRO, T1_BOOTS_ELECTRO);
        registerArmorSet("t2_electro", T2_HELMET_ELECTRO, T2_CHESTPLATE_ELECTRO, T2_LEGGINGS_ELECTRO, T2_BOOTS_ELECTRO);

        registerArmorEffects();
    }

}
