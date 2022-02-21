package tierability.item.tool.t1_nature;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class T1NatureMaterial implements ToolMaterial {
    public static final T1NatureMaterial T1_NATURE_MATERIAL = new T1NatureMaterial();

    @Override
    public int getDurability() {
        return 540;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8f;
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
        return Ingredient.ofItems(TierabilityItems.NATURE_INGOT);
    }
}
