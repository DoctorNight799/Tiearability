package tierability.worldgen.feature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;
import tierability.TierabilityMod;
import tierability.block.TierabilityBlocks;

public class TierabilityConfiguredFeature {

    private static ConfiguredFeature<?, ?> ORE_T1_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    TierabilityBlocks.T1_ORE.getDefaultState(),
                    5)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(5), YOffset.fixed(44)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(7); // Number of veins per chunk

    static public void register() {
        RegistryKey<ConfiguredFeature<?, ?>> oreT1Overworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(TierabilityMod.MODID, "ore_t1_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreT1Overworld.getValue(), ORE_T1_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, oreT1Overworld);
    }


}
