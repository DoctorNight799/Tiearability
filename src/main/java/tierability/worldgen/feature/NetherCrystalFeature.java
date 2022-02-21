package tierability.worldgen.feature;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import tierability.block.TierabilityBlocks;

public class NetherCrystalFeature extends Feature<DefaultFeatureConfig> {

    public NetherCrystalFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    protected static boolean isSoul(BlockState state) {
        return state.isOf(Blocks.SOUL_SAND) || state.isOf(Blocks.SOUL_SOIL);
    }

    protected static boolean isMagma(BlockState state) {
        return state.isOf(Blocks.MAGMA_BLOCK);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        boolean generated = false;
        BlockState stateSoul = TierabilityBlocks.SOUL_CRYSTAL.getDefaultState();
        BlockState stateFlame = TierabilityBlocks.FLAME_CRYSTAL.getDefaultState();
        for(int i = 0; i <= 30; i++){
            int x = context.getOrigin().getX() + context.getRandom().nextInt(7);
            int z = context.getOrigin().getZ() + context.getRandom().nextInt(7);
            int y = context.getRandom().nextInt(7) + 26;
            BlockPos pos = new BlockPos(x,y,z);
            StructureWorldAccess world = context.getWorld();
            if(world.isAir(pos)){
                if(isSoul(world.getBlockState(pos.down()))){
                    world.setBlockState(pos, stateSoul, 0);
                    generated = true;
                }
                else if(isSoul(world.getBlockState(pos.add(0,0,-1)))){
                    world.setBlockState(pos, stateSoul.with(Properties.FACING, Direction.SOUTH), 0);
                    generated = true;
                }
                else if(isSoul(world.getBlockState(pos.add(0,0,1)))){
                    world.setBlockState(pos, stateSoul.with(Properties.FACING, Direction.NORTH), 0);
                    generated = true;
                }
                else if(isSoul(world.getBlockState(pos.add(-1,0,0)))){
                    world.setBlockState(pos, stateSoul.with(Properties.FACING, Direction.EAST), 0);
                    generated = true;
                }
                else if(isSoul(world.getBlockState(pos.add(1,0,0)))){
                    world.setBlockState(pos, stateSoul.with(Properties.FACING, Direction.WEST), 0);
                    generated = true;
                }
                else if(isSoul(world.getBlockState(pos.up()))){
                    world.setBlockState(pos,stateSoul.with(Properties.FACING, Direction.DOWN), 0);
                    generated = true;
                }
                if(isMagma(world.getBlockState(pos.down()))){
                    world.setBlockState(pos, stateFlame, 0);
                    generated = true;
                }
                else if(isMagma(world.getBlockState(pos.add(0,0,-1)))){
                    world.setBlockState(pos, stateFlame.with(Properties.FACING, Direction.SOUTH), 0);
                    generated = true;
                }
                else if(isMagma(world.getBlockState(pos.add(0,0,1)))){
                    world.setBlockState(pos, stateFlame.with(Properties.FACING, Direction.NORTH), 0);
                    generated = true;
                }
                else if(isMagma(world.getBlockState(pos.add(-1,0,0)))){
                    world.setBlockState(pos, stateFlame.with(Properties.FACING, Direction.EAST), 0);
                    generated = true;
                }
                else if(isMagma(world.getBlockState(pos.add(1,0,0)))){
                    world.setBlockState(pos, stateFlame.with(Properties.FACING, Direction.WEST), 0);
                    generated = true;
                }
                else if(isMagma(world.getBlockState(pos.up()))){
                    world.setBlockState(pos,stateFlame.with(Properties.FACING, Direction.DOWN), 0);
                    generated = true;
                }
            }
        }
        return generated;
    }
}
