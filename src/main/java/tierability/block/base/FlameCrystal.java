package tierability.block.base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class FlameCrystal extends CrystalBasedBlock{

    public FlameCrystal(String type){
        super(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).sounds(BlockSoundGroup.AMETHYST_CLUSTER).luminance(10), type);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);
        if(random.nextFloat() > 0.5) {
            world.addParticle(ParticleTypes.FLAME, pos.getX() + random.nextFloat(), pos.getY() + random.nextFloat(), pos.getZ() + random.nextFloat(), 0, 0, 0);
        }
    }
}
