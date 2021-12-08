package tierability.item.tool.base;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import ru.bclib.items.tool.BaseAxeItem;
import tierability.item.tool.TierabilityTools;

import java.util.List;

public class CustomAxeItem extends BaseAxeItem {
    public CustomAxeItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.tierability.axe.tooltip1"));
        tooltip.add(new TranslatableText("item.tierability.axe.tooltip2"));
        if(stack.isOf(TierabilityTools.T1_ELECTRO_AXE)){
            tooltip.add((new TranslatableText("item.tierability.electro")));
        }
        if(stack.isOf(TierabilityTools.T2_ELECTRO_AXE)){
            tooltip.add((new TranslatableText("item.tierability.electro_paralyse")));
        }
        if(stack.isOf(TierabilityTools.T1_FLAME_AXE) || stack.isOf(TierabilityTools.T2_FLAME_AXE)){
            tooltip.add((new TranslatableText("item.tierability.fire")));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
