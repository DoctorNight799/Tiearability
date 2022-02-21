package tierability.item.tool.base;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import ru.bclib.items.tool.BasePickaxeItem;
import tierability.item.tool.TierabilityTools;

import java.util.List;

public class CustomPickaxeItem extends BasePickaxeItem {
    public CustomPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("item.tierability.pickaxe.tooltip"));
        if(stack.isOf(TierabilityTools.T1_ELECTRO_PICKAXE)){
            tooltip.add((new TranslatableText("item.tierability.electro")));
        }
        if(stack.isOf(TierabilityTools.T2_ELECTRO_PICKAXE) || stack.isOf(TierabilityTools.T3_ELECTRO_PICKAXE)){
            tooltip.add((new TranslatableText("item.tierability.electro_paralyse")));
        }
        if(stack.isOf(TierabilityTools.T1_FLAME_PICKAXE) || stack.isOf(TierabilityTools.T2_FLAME_PICKAXE) || stack.isOf(TierabilityTools.T3_FLAME_PICKAXE)){
            tooltip.add((new TranslatableText("item.tierability.fire")));
        }
        if(stack.isOf(TierabilityTools.T1_NATURE_PICKAXE) || stack.isOf(TierabilityTools.T2_NATURE_PICKAXE) || stack.isOf(TierabilityTools.T3_NATURE_PICKAXE)){
            tooltip.add((new TranslatableText("item.tierability.nature")));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }
}
