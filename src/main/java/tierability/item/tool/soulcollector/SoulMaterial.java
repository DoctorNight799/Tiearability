package tierability.item.tool.soulcollector;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import tierability.item.TierabilityItems;

public class SoulMaterial implements ToolMaterial {

    public static final SoulMaterial SOUL_MATERIAL = new SoulMaterial();

    @Override
    public int getDurability() {
        return 1100;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 2;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(TierabilityItems.SOUL_INGOT);
    }
}
