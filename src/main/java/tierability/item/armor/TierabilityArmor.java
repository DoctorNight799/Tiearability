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

    public static final Item T1_HELMET = new BaseArmorItem(TierabilityArmorMaterials.T1_ARMOR_MATERIAL, EquipmentSlot.HEAD, "resistance");
    public static final Item T1_CHESTPLATE = new BaseArmorItem(TierabilityArmorMaterials.T1_ARMOR_MATERIAL, EquipmentSlot.CHEST, "resistance");
    public static final Item T1_LEGGINGS = new BaseArmorItem(TierabilityArmorMaterials.T1_ARMOR_MATERIAL, EquipmentSlot.LEGS, "resistance");
    public static final Item T1_BOOTS = new BaseArmorItem(TierabilityArmorMaterials.T1_ARMOR_MATERIAL, EquipmentSlot.FEET, "resistance");

    public static void register(){
        registerArmorSet("t1", T1_HELMET, T1_CHESTPLATE, T1_LEGGINGS, T1_BOOTS);

        registerArmorEffects();
    }

    static void registerArmorSet(String prefix, Item entryHelmet, Item entryChestplate, Item entryLeggings, Item entryBoots){
        Registry.register(Registry.ITEM, new Identifier(TierabilityMod.MODID, prefix + "_helmet"), entryHelmet);
        Registry.register(Registry.ITEM, new Identifier(TierabilityMod.MODID, prefix + "_chestplate"), entryChestplate);
        Registry.register(Registry.ITEM, new Identifier(TierabilityMod.MODID, prefix + "_leggings"), entryLeggings);
        Registry.register(Registry.ITEM, new Identifier(TierabilityMod.MODID, prefix + "_boots"), entryBoots);
    }

    static void registerArmorEffects(){
        ArmorEffectRegistry.register("T1 Armor", T1_HELMET, T1_CHESTPLATE, T1_LEGGINGS, T1_BOOTS, StatusEffects.RESISTANCE);
    }

}
