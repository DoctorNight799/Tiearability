package tierability.worldgen.feature;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import tierability.block.TierabilityBlocks;

import java.util.ArrayList;
import java.util.List;

public class CrystalFeature extends Feature<DefaultFeatureConfig> {

    public static final ArrayList<Block> CRYSTALS = new ArrayList<>(List.of(TierabilityBlocks.FLAME_CRYSTAL, TierabilityBlocks.ELECTRO_CRYSTAL, TierabilityBlocks.SOUL_CRYSTAL));

    public CrystalFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        boolean generated = false;
        BlockState state = CRYSTALS.get(context.getRandom().nextInt(CRYSTALS.size())).getDefaultState();
        for(int i = 0; i <= 30; i++){
            int x = context.getOrigin().getX() + context.getRandom().nextInt(7);
            int z = context.getOrigin().getZ() + context.getRandom().nextInt(7);
            int y = context.getRandom().nextInt(7) + 26;
            BlockPos pos = new BlockPos(x,y,z);
            StructureWorldAccess world = context.getWorld();
            if(world.isAir(pos)){
                if(isStone(world.getBlockState(pos.down()))){
                    world.setBlockState(pos, state, 0);
                    generated = true;
                }
                else if(isStone(world.getBlockState(pos.add(0,0,-1)))){
                    world.setBlockState(pos, state.with(Properties.FACING, Direction.SOUTH), 0);
                    generated = true;
                }
                else if(isStone(world.getBlockState(pos.add(0,0,1)))){
                    world.setBlockState(pos, state.with(Properties.FACING, Direction.NORTH), 0);
                    generated = true;
                }
                else if(isStone(world.getBlockState(pos.add(-1,0,0)))){
                    world.setBlockState(pos, state.with(Properties.FACING, Direction.EAST), 0);
                    generated = true;
                }
                else if(isStone(world.getBlockState(pos.add(1,0,0)))){
                    world.setBlockState(pos, state.with(Properties.FACING, Direction.WEST), 0);
                    generated = true;
                }
                else if(isStone(world.getBlockState(pos.up()))){
                    world.setBlockState(pos,state.with(Properties.FACING, Direction.DOWN), 0);
                    generated = true;
                }
            }
        }
        return generated;
    }
}
