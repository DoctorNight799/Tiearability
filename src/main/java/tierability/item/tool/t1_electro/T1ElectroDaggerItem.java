package tierability.item.tool.t1_electro;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import tierability.effect.TierabilityEffects;
import tierability.item.tool.base.BaseDaggerItem;
import tierability.util.EffectsUtils;

public class T1ElectroDaggerItem extends BaseDaggerItem {
    public T1ElectroDaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity) {
            EffectsUtils.add(attacker, StatusEffects.SPEED, 6 * 20, 0);
        }
        EffectsUtils.add(target, TierabilityEffects.ELECTRICITY_EFFECT, 4*20, 0);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        EffectsUtils.add(user, StatusEffects.INVISIBILITY, 4*20, 0);
        user.getItemCooldownManager().set(this, 10*20);
        return super.use(world, user, hand);
    }
}
