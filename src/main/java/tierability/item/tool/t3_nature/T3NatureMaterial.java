package tierability.item.tool.t3_nature;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class T3NatureMaterial implements ToolMaterial {

    public static final T3NatureMaterial T3_NATURE_MATERIAL = new T3NatureMaterial();

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
        return Ingredient.ofItems(TierabilityItems.NATURE_INGOT);
    }
}
