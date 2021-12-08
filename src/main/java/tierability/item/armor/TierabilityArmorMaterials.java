package tierability.item.armor;

import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import tierability.item.TierabilityItems;
import tierability.item.base.BaseArmorMaterial;

public class TierabilityArmorMaterials {
    public static final BaseArmorMaterial T1_ARMOR_MATERIAL = new BaseArmorMaterial("t1",
            new int[] {208, 240, 256, 176},
            new int[] {3, 6, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0,
            Ingredient.ofItems(TierabilityItems.T1_SHARD));

    public static final BaseArmorMaterial T2_ARMOR_MATERIAL = new BaseArmorMaterial("t2",
            new int[] {395, 560, 515, 451},
            new int[] {3, 8, 6, 3}, 11, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0,
            Ingredient.ofItems(TierabilityItems.T2_SHARD));

    public static final BaseArmorMaterial T1_UPGRADED_ARMOR_MATERIAL = new BaseArmorMaterial("t1_upgraded",
            new int[] {308, 360, 376, 251},
            new int[] {4, 7, 7, 3}, 13, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0,
            Ingredient.ofItems(TierabilityItems.T1_INGOT));

    public static final BaseArmorMaterial T2_UPGRADED_ARMOR_MATERIAL = new BaseArmorMaterial("t2_upgraded",
            new int[] {495, 680, 635, 651},
            new int[] {4, 9, 7, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0,
            Ingredient.ofItems(TierabilityItems.T2_INGOT));

    public static final BaseArmorMaterial T1_FLAME_ARMOR_MATERIAL = new BaseArmorMaterial("t1_flame",
            new int[] {282, 300, 284, 215},
            new int[] {5, 8, 7, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0,
            Ingredient.ofItems(TierabilityItems.FLAME_INGOT));

    public static final BaseArmorMaterial T2_FLAME_ARMOR_MATERIAL = new BaseArmorMaterial("t2_flame",
            new int[] {435, 620, 585, 542},
            new int[] {4, 9, 7, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0,
            Ingredient.ofItems(TierabilityItems.FLAME_INGOT));

    public static final BaseArmorMaterial T1_ELECTRO_ARMOR_MATERIAL = new BaseArmorMaterial("t1_electro",
            new int[] {288, 310, 298, 230},
            new int[] {6, 6, 6, 4}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0,
            Ingredient.ofItems(TierabilityItems.ELECTRO_INGOT));

    public static final BaseArmorMaterial T2_ELECTRO_ARMOR_MATERIAL = new BaseArmorMaterial("t2_electro",
            new int[] {470, 635, 605, 584},
            new int[] {7, 6, 7, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0,
            Ingredient.ofItems(TierabilityItems.ELECTRO_INGOT));
}
