package tierability.item.armor;

import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import tierability.item.TierabilityItems;
import tierability.item.base.BaseArmorMaterial;

public class TierabilityArmorMaterials {
    public static final BaseArmorMaterial T1_ARMOR_MATERIAL = new BaseArmorMaterial("t1",
            new int[] {208, 240, 256, 176},
            new int[] {3, 6, 6, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0,
            Ingredient.ofItems(TierabilityItems.T1_SHARD));
}
