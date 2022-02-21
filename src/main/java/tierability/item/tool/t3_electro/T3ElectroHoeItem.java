package tierability.item.tool.t3_electro;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import tierability.effect.TierabilityEffects;
import tierability.item.tool.base.CustomHoeItem;
import tierability.util.EffectsUtils;

public class T3ElectroHoeItem extends CustomHoeItem {
    public T3ElectroHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        EffectsUtils.add(target, TierabilityEffects.ELECTRICITY_EFFECT, 4*20, 0);
        EffectsUtils.add(target, TierabilityEffects.PARALYSE_EFFECT, 3*20, 0);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        EffectsUtils.add(user, StatusEffects.SATURATION, 3, 0);
        user.getItemCooldownManager().set(this, 60*20);
        return super.use(world, user, hand);
    }
}
