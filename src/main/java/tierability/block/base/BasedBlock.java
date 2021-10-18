package tierability.block.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import ru.bclib.interfaces.BlockModelProvider;

public class BasedBlock extends Block {

    public BasedBlock() {
        super(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE));
    }

    public BasedBlock(Block copyOf, BlockSoundGroup blockSoundGroup) {
        super(FabricBlockSettings.copy(copyOf).sounds(blockSoundGroup));
    }

    public BasedBlock(Block copyOf) {
        super(FabricBlockSettings.copy(copyOf));
    }

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
