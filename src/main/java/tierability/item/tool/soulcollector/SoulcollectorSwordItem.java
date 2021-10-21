package tierability.item.tool.soulcollector;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import ru.bclib.items.tool.BaseSwordItem;

import java.util.List;

public class SoulcollectorSwordItem extends BaseSwordItem {
    public SoulcollectorSwordItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    public static void setKillCount(ItemStack stack, int count){
        stack.getOrCreateNbt().putInt("killCount", count);
    }

    public static int getKillCount(ItemStack stack){
        return stack.getOrCreateNbt().getInt("killCount");
    }

    public static int getDamage(ItemStack stack){
        int count = getKillCount(stack);
        float damage = (float) count/100;
        return (int) damage;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker){
        target.damage(DamageSource.mob(attacker), getDamage(stack));
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.tierability.soulcoll.tooltip1"));
        tooltip.add(new TranslatableText("item.tierability.soulcoll.tooltip2"));
        tooltip.add(new LiteralText("Souls: " + getKillCount(stack)).formatted(Formatting.AQUA));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
