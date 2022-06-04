package tierability.item.tool.t3_nature;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import tierability.item.tool.base.NatureSwordItem;
import tierability.util.EffectsUtils;

public class T3NatureSwordItem extends NatureSwordItem {
    public T3NatureSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        EffectsUtils.add(target, StatusEffects.SLOWNESS, 6*20, 0);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        player.getItemCooldownManager().set(this, 15*20);
        return super.useOnBlock(context);
    }
}
