package tierability.item.tool.t3_electro;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class T3ElectroMaterial implements ToolMaterial {

    public static final T3ElectroMaterial T3_ELECTRO_MATERIAL = new T3ElectroMaterial();

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
        return Ingredient.ofItems(TierabilityItems.ELECTRO_INGOT);
    }
}
