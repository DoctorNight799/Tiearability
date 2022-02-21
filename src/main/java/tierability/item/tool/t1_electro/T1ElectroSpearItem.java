package tierability.item.tool.t1_electro;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import tierability.effect.TierabilityEffects;
import tierability.item.tool.base.BaseSpearItem;
import tierability.util.EffectsUtils;

public class T1ElectroSpearItem extends BaseSpearItem {
    public T1ElectroSpearItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, float attackRange, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, attackRange, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity) {
            EffectsUtils.add(attacker, StatusEffects.JUMP_BOOST, 4*20, 0);
        }
        EffectsUtils.add(target, TierabilityEffects.ELECTRICITY_EFFECT, 4*20, 0);
        return super.postHit(stack, target, attacker);
    }
}
