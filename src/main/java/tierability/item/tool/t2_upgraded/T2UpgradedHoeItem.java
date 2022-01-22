package tierability.item.tool.t2_upgraded;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import tierability.item.tool.base.CustomHoeItem;
import tierability.util.EffectsUtils;

public class T2UpgradedHoeItem extends CustomHoeItem {
    public T2UpgradedHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        EffectsUtils.add(user, StatusEffects.SATURATION, 4, 0);
        user.getItemCooldownManager().set(this, 200);
        return super.use(world, user, hand);
    }
}
