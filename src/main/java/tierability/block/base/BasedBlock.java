package tierability.block.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import ru.bclib.blocks.BaseBlock;

public class BasedBlock extends BaseBlock {

    public BasedBlock(FabricBlockSettings settings) {
        super(settings);
    }

    public BasedBlock(int miningLevel, float hardness, float resistance){
        super(FabricBlockSettings.of(Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, miningLevel).strength(hardness,resistance).sounds(BlockSoundGroup.STONE));
    }

    public BasedBlock(float hardness, float resistance){
        super(FabricBlockSettings.of(Material.METAL).requiresTool().strength(hardness,resistance).sounds(BlockSoundGroup.METAL));
    }

}
