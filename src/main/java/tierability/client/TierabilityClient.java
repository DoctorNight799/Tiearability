package tierability.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import tierability.block.TierabilityBlocks;
import tierability.block.base.BasedCrystalBlock;
import tierability.client.particles.TierabilityParticles;

public class TierabilityClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        TierabilityParticles.register();

        TierabilityBlocks.BLOCKS.forEach((id, block) -> {
            if(block instanceof BasedCrystalBlock) BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        });
    }
}
