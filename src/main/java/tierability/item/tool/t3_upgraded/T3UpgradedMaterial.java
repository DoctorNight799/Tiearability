package tierability.item.tool.t3_upgraded;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class T3UpgradedMaterial implements ToolMaterial {

    public static final T3UpgradedMaterial T3_UPGRADED_MATERIAL = new T3UpgradedMaterial();

    @Override
    public int getDurability() {
        return 2650;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 10.5f;
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
        return 21;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TierabilityItems.T3_INGOT);
    }
}
