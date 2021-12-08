package tierability.item.tool.t1_electro;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class T1ElectroMaterial implements ToolMaterial {

    public static final T1ElectroMaterial T1_ELECTRO_MATERIAL = new T1ElectroMaterial();

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
        return Ingredient.ofItems(TierabilityItems.ELECTRO_INGOT);
    }
}
