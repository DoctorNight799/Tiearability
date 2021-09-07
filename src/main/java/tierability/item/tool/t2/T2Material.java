package tierability.item.tool.t2;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class T2Material implements ToolMaterial {

    public static final T2Material T2_MATERIAL = new T2Material();

    @Override
    public int getDurability() {
        return 1854;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.0f;
    }

    @Override
    public float getAttackDamage() {
        return 6;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 14;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TierabilityItems.T2_SHARD);
    }
}
