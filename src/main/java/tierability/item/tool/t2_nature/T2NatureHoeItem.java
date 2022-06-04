package tierability.item.tool.t2_nature;

import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import tierability.item.tool.base.NatureHoeItem;
import tierability.util.EffectsUtils;

public class T2NatureHoeItem extends NatureHoeItem {
    public T2NatureHoeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        EffectsUtils.add(user, StatusEffects.SATURATION, 2, 0);
        user.getItemCooldownManager().set(this, 30*60);
        return super.use(world, user, hand);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        PlayerEntity player = context.getPlayer();
        player.getItemCooldownManager().set(this, 20*20);
        return super.useOnBlock(context);
    }
}
