package tierability.item.tool.base;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import ru.bclib.items.tool.BaseSwordItem;

public class BaseDaggerItem extends BaseSwordItem {
    private final float attackDamage;

    public BaseDaggerItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.attackDamage = (float)attackDamage + toolMaterial.getAttackDamage();
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if(attacker instanceof PlayerEntity player) {
            float yawDif = attacker.getYaw() - target.getYaw();
            if(yawDif > 0 && yawDif < 30) {
                target.damage(DamageSource.sting(attacker), attackDamage*2);
            }else if(yawDif < 0 && yawDif > -30) {
                target.damage(DamageSource.sting(attacker), attackDamage*2);
            }
        }
        return super.postHit(stack, target, attacker);
    }
}
