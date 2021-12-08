package tierability.item.tool.t2_flame;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class T2FlameMaterial implements ToolMaterial {

    public static final T2FlameMaterial T2_FLAME_MATERIAL = new T2FlameMaterial();

    @Override
    public int getDurability() {
        return 1960;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9;
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
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TierabilityItems.FLAME_INGOT);
    }
}
