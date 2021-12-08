package tierability.item.tool.base;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import ru.bclib.items.tool.BaseSwordItem;
import tierability.item.tool.TierabilityTools;

import java.util.List;

public class BaseDaggerItem extends BaseSwordItem {
    private final float attackDamage;

    public BaseDaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.attackDamage = (float)attackDamage + toolMaterial.getAttackDamage();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity) {
            float yawDif = attacker.getYaw() - target.getYaw();
            if(yawDif > 0 && yawDif < 30) {
                target.damage(DamageSource.sting(attacker), attackDamage*2);
            }else if(yawDif < 0 && yawDif > -30) {
                target.damage(DamageSource.sting(attacker), attackDamage*2);
            }
        }
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.tierability.dagger.tooltip1"));
        tooltip.add(new TranslatableText("item.tierability.dagger.tooltip2"));
        tooltip.add(new TranslatableText("item.tierability.dagger.tooltip3"));
        tooltip.add(new TranslatableText("item.tierability.dagger.tooltip4"));
        if(stack.isOf(TierabilityTools.T1_ELECTRO_DAGGER)){
            tooltip.add((new TranslatableText("item.tierability.electro")));
        }
        if(stack.isOf(TierabilityTools.T2_ELECTRO_DAGGER)){
            tooltip.add((new TranslatableText("item.tierability.electro_paralyse")));
        }
        if(stack.isOf(TierabilityTools.T1_FLAME_DAGGER) || stack.isOf(TierabilityTools.T2_FLAME_DAGGER)){
            tooltip.add((new TranslatableText("item.tierability.fire")));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
