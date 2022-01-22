package tierability.item.tool.t3_upgraded;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import tierability.item.tool.base.CustomSwordItem;
import tierability.util.EffectsUtils;

public class T3UpgradedSwordItem extends CustomSwordItem {
    public T3UpgradedSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        EffectsUtils.add(target, StatusEffects.SLOWNESS, 200, 1);
        return super.postHit(stack, target, attacker);
    }
}
