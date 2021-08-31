package tierability.item.tool.t1;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class T1Material implements ToolMaterial {

    public static final T1Material T1_MATERIAL = new T1Material();

    @Override
    public int getDurability() {
        return 350;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 2;
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
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TierabilityItems.T1_SHARD);
    }
}
