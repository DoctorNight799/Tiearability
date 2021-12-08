package tierability.item.tool.t2_upgraded;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class T2UpgradedMaterial implements ToolMaterial {

    public static final T2UpgradedMaterial T2_UPGRADED_MATERIAL = new T2UpgradedMaterial();

    @Override
    public int getDurability() {
        return 20004;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 9.5f;
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
        return 16;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TierabilityItems.T2_INGOT);
    }
}
