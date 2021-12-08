package tierability.item.tool.base;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import ru.bclib.items.tool.BaseShovelItem;
import tierability.item.tool.TierabilityTools;

import java.util.List;

public class CustomShovelItem extends BaseShovelItem {
    public CustomShovelItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.tierability.shovel.tooltip"));
        if(stack.isOf(TierabilityTools.T1_ELECTRO_SHOVEL)){
            tooltip.add((new TranslatableText("item.tierability.electro")));
        }
        if(stack.isOf(TierabilityTools.T2_ELECTRO_SHOVEL)){
            tooltip.add((new TranslatableText("item.tierability.electro_paralyse")));
        }
        if(stack.isOf(TierabilityTools.T1_FLAME_SHOVEL) || stack.isOf(TierabilityTools.T2_FLAME_SHOVEL)){
            tooltip.add((new TranslatableText("item.tierability.fire")));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
