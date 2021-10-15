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
            Ingredient.ofItems(TierabilityItems.T1_SHARD));

    public static final BaseArmorMaterial T2_UPGRADED_ARMOR_MATERIAL = new BaseArmorMaterial("t2_upgraded",
            new int[] {495, 680, 635, 651},
            new int[] {4, 9, 7, 4}, 15, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0,
            Ingredient.ofItems(TierabilityItems.T2_SHARD));
}
