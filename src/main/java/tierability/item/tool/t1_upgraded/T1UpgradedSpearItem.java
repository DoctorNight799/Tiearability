package tierability.item.tool.t1_upgraded;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import tierability.item.tool.base.BaseSpearItem;

import java.util.List;

public class T1UpgradedSpearItem extends BaseSpearItem {
    public T1UpgradedSpearItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, float attackRange, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, attackRange, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity player) {
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 140));
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.tierability.spear.tooltip1"));
        tooltip.add(new TranslatableText("item.tierability.spear.tooltip2"));
        tooltip.add(new TranslatableText("item.tierability.spear.tooltip3"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
