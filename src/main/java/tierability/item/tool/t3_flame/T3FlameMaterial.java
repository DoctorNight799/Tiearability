package tierability.item.tool.t3_flame;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class T3FlameMaterial implements ToolMaterial {

    public static final T3FlameMaterial T3_FLAME_MATERIAL = new T3FlameMaterial();

    @Override
    public int getDurability() {
        return 2323;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10;
    }

    @Override
    public float getAttackDamage() {
        return 7;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 17;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TierabilityItems.FLAME_INGOT);
    }
}
