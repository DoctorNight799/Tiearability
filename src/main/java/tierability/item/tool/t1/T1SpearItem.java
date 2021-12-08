package tierability.item.tool.t1;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import tierability.item.tool.base.BaseSpearItem;
import tierability.util.EffectsUtils;

public class T1SpearItem extends BaseSpearItem {

    public T1SpearItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, float reach, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, reach, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity) {
            EffectsUtils.add(attacker, StatusEffects.JUMP_BOOST, 5*20, 0);
        }
        return super.postHit(stack, target, attacker);
    }
}
