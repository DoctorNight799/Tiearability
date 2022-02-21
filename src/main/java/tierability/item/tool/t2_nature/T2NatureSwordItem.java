package tierability.item.tool.t2_nature;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import tierability.item.tool.base.CustomAxeItem;
import tierability.util.EffectsUtils;

public class T2NatureSwordItem extends CustomAxeItem {
    public T2NatureSwordItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        EffectsUtils.add(target, StatusEffects.SLOWNESS, 5*20, 0);
        return super.postHit(stack, target, attacker);
    }
}
