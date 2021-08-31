package tierability.item.tool.t1;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import tierability.item.tool.base.BaseSpear;


public class T1SpearItem extends BaseSpear {


    public T1SpearItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, float reach, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, reach, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity player) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 100));
        }
        return super.postHit(stack, target, attacker);
    }
}
