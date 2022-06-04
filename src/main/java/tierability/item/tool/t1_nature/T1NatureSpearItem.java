package tierability.item.tool.t1_nature;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import tierability.item.tool.base.NatureSpearItem;
import tierability.util.EffectsUtils;

public class T1NatureSpearItem extends NatureSpearItem {
    public T1NatureSpearItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, float attackRange, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, attackRange, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity) {
            EffectsUtils.add(attacker, StatusEffects.JUMP_BOOST, 4*20, 0);
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        player.getItemCooldownManager().set(this, 30*20);
        return super.useOnBlock(context);
    }
}
