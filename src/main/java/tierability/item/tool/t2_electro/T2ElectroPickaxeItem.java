package tierability.item.tool.t2_electro;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tierability.effect.TierabilityEffects;
import tierability.item.tool.base.CustomPickaxeItem;
import tierability.util.EffectsUtils;

public class T2ElectroPickaxeItem extends CustomPickaxeItem {
    public T2ElectroPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        EffectsUtils.add(target, TierabilityEffects.ELECTRICITY_EFFECT, 4*20, 0);
        EffectsUtils.add(target, TierabilityEffects.PARALYSE_EFFECT, 2*20, 0);
        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if(miner instanceof PlayerEntity) {
            EffectsUtils.add(miner, StatusEffects.HASTE, 5*20, 0);
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}
