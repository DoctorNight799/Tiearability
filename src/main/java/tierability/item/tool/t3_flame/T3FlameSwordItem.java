package tierability.item.tool.t3_flame;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import tierability.item.tool.base.CustomSwordItem;
import tierability.util.EffectsUtils;

public class T3FlameSwordItem extends CustomSwordItem {
    public T3FlameSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        EffectsUtils.add(target, StatusEffects.SLOWNESS, 6*20, 0);
        target.setOnFireFor(6);
        return super.postHit(stack, target, attacker);
    }
}
