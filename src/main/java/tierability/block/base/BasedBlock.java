package tierability.block.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;
import tierability.interfaces.IBlockModel;

public class BasedBlock extends Block implements IBlockModel {
    public BasedBlock(FabricBlockSettings settings, String parentModel) {
        super(settings);
        this.parentModel = parentModel;
    }
    private final String parentModel;

    @Override
    public String getParent() {
        return parentModel;
    }

    public BasedBlock(String parentModel) {
        super(FabricBlockSettings.copy(Blocks.STONE).sounds(BlockSoundGroup.STONE));
        this.parentModel = parentModel;
    }

    public BasedBlock(Block copyOf, BlockSoundGroup blockSoundGroup, String parentModel) {
        super(FabricBlockSettings.copy(copyOf).sounds(blockSoundGroup));
        this.parentModel = parentModel;
    }

    public BasedBlock(Block copyOf, String parentModel) {
        super(FabricBlockSettings.copy(copyOf));
        this.parentModel = parentModel;
    }

}
