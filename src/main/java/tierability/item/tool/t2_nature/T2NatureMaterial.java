package tierability.item.tool.t2_nature;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class T2NatureMaterial implements ToolMaterial {

    public static final T2NatureMaterial T2_NATURE_MATERIAL = new T2NatureMaterial();

    @Override
    public int getDurability() {
        return 1940;
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
        return Ingredient.ofItems(TierabilityItems.NATURE_INGOT);
    }
}
