package tierability.item.tool.t1_flame;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class T1FlameMaterial implements ToolMaterial {

    public static final T1FlameMaterial T1_FLAME_MATERIAL = new T1FlameMaterial();

    @Override
    public int getDurability() {
        return 570;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8;
    }

    @Override
    public float getAttackDamage() {
        return 6;
    }

    @Override
    public int getMiningLevel() {
        return 2;
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
