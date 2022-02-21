package tierability.item.tool.t2_flame;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import tierability.item.tool.base.CustomSwordItem;
import tierability.util.EffectsUtils;

public class T2FlameSwordItem extends CustomSwordItem {
    public T2FlameSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        EffectsUtils.add(target, StatusEffects.SLOWNESS, 5*20, 0);
        target.setOnFireFor(5);
        return super.postHit(stack, target, attacker);
    }
}
