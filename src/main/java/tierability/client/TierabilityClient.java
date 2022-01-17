package tierability.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import tierability.block.TierabilityBlocks;
import tierability.block.base.BasedCrystalBlock;
import tierability.client.particles.TierabilityParticles;
import tierability.screen.TierCraftingScreen;
import tierability.screen.TierCraftingScreenHandler;

public class TierabilityClient implements ClientModInitializer {

    public static final ScreenHandlerType<TierCraftingScreenHandler> TIER_UPGRADE = ScreenHandlerRegistry.registerSimple(new Identifier("tier"), TierCraftingScreenHandler::new);

    @Override
    public void onInitializeClient() {
        TierabilityParticles.register();
        ScreenRegistry.register(TIER_UPGRADE, TierCraftingScreen::new);

        TierabilityBlocks.BLOCKS.forEach((id, block) -> {
            if(block instanceof BasedCrystalBlock) BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
        });
    }
}
