package tierability.item.tool.t1_2;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class T1_2Material implements ToolMaterial {

    public static final T1_2Material T1_2_MATERIAL = new T1_2Material();

    @Override
    public int getDurability() {
        return 1854;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 6.0f;
    }

    @Override
    public float getAttackDamage() {
        return 4;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 14;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TierabilityItems.T1_SHARD, TierabilityItems.T2_SHARD);
    }
}
