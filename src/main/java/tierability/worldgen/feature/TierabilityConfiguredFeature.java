package tierability.worldgen.feature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import ru.bclib.world.features.BCLDecorators;
import tierability.TierabilityMod;
import tierability.block.TierabilityBlocks;

public class TierabilityConfiguredFeature {

    private static final ConfiguredFeature<?, ?> ORE_T1_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig
            (OreConfiguredFeatures.STONE_ORE_REPLACEABLES, TierabilityBlocks.T1_ORE.getDefaultState(), 4));

    private static final PlacedFeature ORE_T1_OVERWORLD_PLACED_FEATURE = ORE_T1_OVERWORLD.withPlacement(CountPlacementModifier.of(15), //number of veins per chunk
            SquarePlacementModifier.of(), /*spreading horizontally*/ HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(20)));

    private static final ConfiguredFeature<?, ?> ORE_T2_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig
            (OreConfiguredFeatures.STONE_ORE_REPLACEABLES, TierabilityBlocks.T2_ORE.getDefaultState(), 3));

    private static final PlacedFeature ORE_T2_OVERWORLD_PLACED_FEATURE = ORE_T2_OVERWORLD.withPlacement(CountPlacementModifier.of(10), //number of veins per chunk
            SquarePlacementModifier.of(), /*spreading horizontally*/ HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(40)));

    public static final Feature<DefaultFeatureConfig> CRYSTAL_FEATURE = new CrystalFeature();

    static public void register() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(TierabilityMod.MODID, "ore_t1_overworld"), ORE_T1_OVERWORLD);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(TierabilityMod.MODID, "ore_t1_overworld"), ORE_T1_OVERWORLD_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(TierabilityMod.MODID, "ore_t1_overworld")));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(TierabilityMod.MODID, "ore_t2_overworld"), ORE_T2_OVERWORLD);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(TierabilityMod.MODID, "ore_t2_overworld"), ORE_T2_OVERWORLD_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(TierabilityMod.MODID, "ore_t2_overworld")));

        Registry.register(Registry.FEATURE, new Identifier(TierabilityMod.MODID, "crystal_feature"), CRYSTAL_FEATURE);
    }


}
