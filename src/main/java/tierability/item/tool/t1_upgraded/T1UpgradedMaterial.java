package tierability.item.tool.t1_upgraded;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class T1UpgradedMaterial implements ToolMaterial {

    public static final T1UpgradedMaterial T1_UPGRADED_MATERIAL = new T1UpgradedMaterial();

    @Override
    public int getDurability() {
        return 554;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 7.5f;
    }

    @Override
    public float getAttackDamage() {
        return 5;
    }

    @Override
    public int getMiningLevel() {
        return 2;
    }

    @Override
    public int getEnchantability() {
        return 18;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TierabilityItems.T1_INGOT);
    }
}
