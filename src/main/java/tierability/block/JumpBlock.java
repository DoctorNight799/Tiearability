package tierability.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import tierability.interfaces.IBlockModel;

public class JumpBlock extends Block implements IBlockModel {
    private final String parentModel;

    public JumpBlock(Settings settings, String parentModel) {
        super(settings);
        this.parentModel = parentModel;
    }

    @Override
    public String getParent() {
        return parentModel;
    }

    public JumpBlock(String parentModel, int miningLevel, int multiplier){
        super(FabricBlockSettings.of(Material.ORGANIC_PRODUCT).requiresTool().breakByTool(FabricToolTags.PICKAXES, miningLevel).strength(2.0f,1.0f).jumpVelocityMultiplier(multiplier).slipperiness(0.4f).sounds(BlockSoundGroup.SLIME));
        this.parentModel = parentModel;
    }
}
