package tierability.item.tool.t2;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tierability.item.tool.base.CustomAxeItem;

public class T2AxeItem extends CustomAxeItem {
    public T2AxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity player) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 80));
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if(miner instanceof PlayerEntity player) {
            miner.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 120));
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}
