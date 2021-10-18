package tierability.block.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class JumpBlock extends Block{

    public JumpBlock(Settings settings) {
        super(settings);
    }

    public JumpBlock(int miningLevel, int multiplier){
        super(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).requiresTool().breakByTool(FabricToolTags.PICKAXES, miningLevel).strength(2.0f,1.0f).jumpVelocityMultiplier(multiplier).slipperiness(0.9f).sounds(BlockSoundGroup.SLIME));
    }
}
