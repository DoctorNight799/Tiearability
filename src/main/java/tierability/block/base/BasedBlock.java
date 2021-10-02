package tierability.block.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.Tag;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;
import tierability.interfaces.IBlockModel;

import java.util.List;

public class BasedBlock extends Block implements IBlockModel {
    private final String parentModel;

    @Override
    public String getParent() {
        return parentModel;
    }

    public BasedBlock(String parentModel) {
        super(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE));
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

    public BasedBlock(FabricBlockSettings settings, String parentModel) {
        super(settings);
        this.parentModel = parentModel;
    }

    public BasedBlock(String parentModel, int miningLevel, float hardness, float resistance){
        super(FabricBlockSettings.of(Material.STONE).requiresTool().breakByTool(FabricToolTags.PICKAXES, miningLevel).strength(hardness,resistance).sounds(BlockSoundGroup.STONE));
        this.parentModel = parentModel;
    }

    public BasedBlock(String parentModel, float hardness, float resistance){
        super(FabricBlockSettings.of(Material.METAL).requiresTool().strength(hardness,resistance).sounds(BlockSoundGroup.METAL));
        this.parentModel = parentModel;
    }

}
