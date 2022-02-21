package tierability.worldgen.feature;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import tierability.block.TierabilityBlocks;

import java.util.List;

import static tierability.TierabilityMod.MODID;

public class TierabilityConfiguredFeature {

    private static final ConfiguredFeature<?, ?> ORE_T1_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig
            (OreConfiguredFeatures.STONE_ORE_REPLACEABLES, TierabilityBlocks.T1_ORE.getDefaultState(), 4));

    private static final PlacedFeature ORE_T1_OVERWORLD_PLACED_FEATURE = ORE_T1_OVERWORLD.withPlacement(CountPlacementModifier.of(15), //number of veins per chunk
            SquarePlacementModifier.of(), /*spreading horizontally*/ HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(20)));

    private static final ConfiguredFeature<?, ?> ORE_T2_OVERWORLD = Feature.ORE.configure(new OreFeatureConfig
            (OreConfiguredFeatures.STONE_ORE_REPLACEABLES, TierabilityBlocks.T2_ORE.getDefaultState(), 3));

    private static final PlacedFeature ORE_T2_OVERWORLD_PLACED_FEATURE = ORE_T2_OVERWORLD.withPlacement(CountPlacementModifier.of(10), //number of veins per chunk
            SquarePlacementModifier.of(), /*spreading horizontally*/ HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(40)));

    public static final Feature<DefaultFeatureConfig> OTHERWORLD_CRYSTAL_FEATURE = new OtherwroldCrystalFeature();

    public static final Feature<DefaultFeatureConfig> NETHER_CRYSTAL_FEATURE = new NetherCrystalFeature();

    public static final ConfiguredFeature<?, ?> OTHERWORLD_CRYSTAL_FEATURE_CONFIG = OTHERWORLD_CRYSTAL_FEATURE
            .configure(new DefaultFeatureConfig());

    public static final ConfiguredFeature<?, ?> NETHER_CRYSTAL_FEATURE_CONFIG = NETHER_CRYSTAL_FEATURE
            .configure(new DefaultFeatureConfig());

    public static final PlacedFeature OTHERWORLD_CRYSTAL_FEATURE_PLACED = new PlacedFeature(() -> OTHERWORLD_CRYSTAL_FEATURE_CONFIG, List.of(PlacedFeatures.BOTTOM_TO_120_RANGE));

    public static final PlacedFeature NETHER_CRYSTAL_FEATURE_PLACED = new PlacedFeature(() -> NETHER_CRYSTAL_FEATURE_CONFIG, List.of(PlacedFeatures.BOTTOM_TO_120_RANGE));

    static public void register() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MODID, "ore_t1_overworld"), ORE_T1_OVERWORLD);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MODID, "ore_t1_overworld"), ORE_T1_OVERWORLD_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(MODID, "ore_t1_overworld")));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MODID, "ore_t2_overworld"), ORE_T2_OVERWORLD);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MODID, "ore_t2_overworld"), ORE_T2_OVERWORLD_PLACED_FEATURE);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(MODID, "ore_t2_overworld")));

        Registry.register(Registry.FEATURE, new Identifier(MODID, "otherworld_crystal_feature"), OTHERWORLD_CRYSTAL_FEATURE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MODID, "otherworld_crystal_feature"), OTHERWORLD_CRYSTAL_FEATURE_CONFIG);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MODID, "otherworld_crystal_feature"), OTHERWORLD_CRYSTAL_FEATURE_PLACED);

        BiomeModifications.addFeature(ctx -> {
                    Biome.Category category = ctx.getBiome().getCategory();
                    return !category.equals(Biome.Category.NETHER) && !category.equals(Biome.Category.THEEND);
                },
                GenerationStep.Feature.UNDERGROUND_DECORATION,
                BuiltinRegistries.PLACED_FEATURE.getKey(OTHERWORLD_CRYSTAL_FEATURE_PLACED).orElseThrow());

        Registry.register(Registry.FEATURE, new Identifier(MODID, "nether_crystal_feature"), NETHER_CRYSTAL_FEATURE);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(MODID, "nether_crystal_feature"), NETHER_CRYSTAL_FEATURE_CONFIG);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(MODID, "nether_crystal_feature"), NETHER_CRYSTAL_FEATURE_PLACED);

        BiomeModifications.addFeature(ctx -> {
                    Biome.Category category = ctx.getBiome().getCategory();
                    return !category.equals(Biome.Category.NETHER) && !category.equals(Biome.Category.THEEND);
                },
                GenerationStep.Feature.UNDERGROUND_DECORATION,
                BuiltinRegistries.PLACED_FEATURE.getKey(NETHER_CRYSTAL_FEATURE_PLACED).orElseThrow());
    }
}
