package tierability.item.tool.t3_electro;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import tierability.effect.TierabilityEffects;
import tierability.item.tool.base.BaseSpearItem;
import tierability.util.EffectsUtils;

public class T3ElectroSpearItem extends BaseSpearItem {
    public T3ElectroSpearItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, float attackRange, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, attackRange, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity) {
            EffectsUtils.add(attacker, StatusEffects.JUMP_BOOST, 2*20, 1);
        }
        EffectsUtils.add(target, TierabilityEffects.ELECTRICITY_EFFECT, 5*20, 0);
        EffectsUtils.add(target, TierabilityEffects.PARALYSE_EFFECT, 4*20, 0);
        return super.postHit(stack, target, attacker);
    }
}
