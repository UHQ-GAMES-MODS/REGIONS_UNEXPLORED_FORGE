package net.regions_unexplored.data.worldgen.placement;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ClampedNormalInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.regions_unexplored.data.worldgen.features.RuMiscOverworldFeatures;
import net.regions_unexplored.registry.PlacedFeatureRegistry;

import java.util.List;

public class RuMiscOverworldPlacements {
    //-----------------------KEYS-----------------------//
    //ROCKS
    public static final ResourceKey<PlacedFeature> REDWOODS_ROCK = PlacedFeatureRegistry.createKey("redwoods_rock");
    //FALLEN_TREES
    public static final ResourceKey<PlacedFeature> FALLEN_LARCH_TREE = PlacedFeatureRegistry.createKey("fallen_larch_tree");
    public static final ResourceKey<PlacedFeature> FALLEN_MAPLE_TREE = PlacedFeatureRegistry.createKey("fallen_maple_tree");
    public static final ResourceKey<PlacedFeature> FALLEN_OAK_TREE_SPARSE = PlacedFeatureRegistry.createKey("fallen_oak_tree_sparse");
    public static final ResourceKey<PlacedFeature> FALLEN_OAK_TREE_DENSE = PlacedFeatureRegistry.createKey("fallen_oak_tree_dense");
    public static final ResourceKey<PlacedFeature> FALLEN_PINE_TREE = PlacedFeatureRegistry.createKey("fallen_pine_tree");
    public static final ResourceKey<PlacedFeature> FALLEN_SILVER_BIRCH_TREE = PlacedFeatureRegistry.createKey("fallen_silver_birch_tree");
    //CAVE_FEATURES
    public static final ResourceKey<PlacedFeature>  POINTED_REDSTONE = PlacedFeatureRegistry.createKey("pointed_redstone");
    public static final ResourceKey<PlacedFeature>  LARGE_POINTED_REDSTONE = PlacedFeatureRegistry.createKey("large_pointed_redstone");
    public static final ResourceKey<PlacedFeature>  POINTED_REDSTONE_CLUSTER = PlacedFeatureRegistry.createKey("pointed_redstone_cluster");
    public static final ResourceKey<PlacedFeature>  POINTED_REDSTONE_NETHER = PlacedFeatureRegistry.createKey("pointed_redstone_nether");
    public static final ResourceKey<PlacedFeature>  LARGE_POINTED_REDSTONE_NETHER = PlacedFeatureRegistry.createKey("large_pointed_redstone_nether");
    public static final ResourceKey<PlacedFeature>  POINTED_REDSTONE_CLUSTER_NETHER = PlacedFeatureRegistry.createKey("pointed_redstone_cluster_nether");
    public static final ResourceKey<PlacedFeature>  ORE_REDSTONE_LARGE = PlacedFeatureRegistry.createKey("ore_redstone_large");
    public static final ResourceKey<PlacedFeature>  PRISMARITE_CLUSTERS = PlacedFeatureRegistry.createKey("prismarite_clusters");
    public static final ResourceKey<PlacedFeature>  HANGING_PRISMARITE_CLUSTER = PlacedFeatureRegistry.createKey("hanging_prismarite_cluster");
    public static final ResourceKey<PlacedFeature>  LAVA_FALL = PlacedFeatureRegistry.createKey("lava_fall");
    public static final ResourceKey<PlacedFeature>  OVERWORLD_LAVA_DELTA = PlacedFeatureRegistry.createKey("overworld_lava_delta");
    public static final ResourceKey<PlacedFeature>  ASH_VENT = PlacedFeatureRegistry.createKey("ash_vent");
    public static final ResourceKey<PlacedFeature>  BASALT_BLOB = PlacedFeatureRegistry.createKey("basalt_blob");
    //OTHER_FEATURES
    public static final ResourceKey<PlacedFeature>  MINERAL_POOL = PlacedFeatureRegistry.createKey("mineral_pool");

    public static final ResourceKey<PlacedFeature> ICICLE_UP = PlacedFeatureRegistry.createKey("icicle_up");
    public static final ResourceKey<PlacedFeature> SMOULDERING_DIRT = PlacedFeatureRegistry.createKey("smouldering_dirt");
    public static final ResourceKey<PlacedFeature> MEADOW_ROCK = PlacedFeatureRegistry.createKey("meadow_rock");
    public static final ResourceKey<PlacedFeature> NOISE_PUMPKINS = PlacedFeatureRegistry.createKey("noise_pumpkins");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> featureGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        //---------------------FEATURES---------------------//
        //ROCKS
        final Holder<ConfiguredFeature<?, ?>> REDWOODS_ROCK = featureGetter.getOrThrow(RuMiscOverworldFeatures.REDWOODS_ROCK);
        //FALLEN_TREES
        final Holder<ConfiguredFeature<?, ?>> FALLEN_LARCH_TREE = featureGetter.getOrThrow(RuMiscOverworldFeatures.FALLEN_LARCH_TREE);
        final Holder<ConfiguredFeature<?, ?>> FALLEN_MAPLE_TREE = featureGetter.getOrThrow(RuMiscOverworldFeatures.FALLEN_MAPLE_TREE);
        final Holder<ConfiguredFeature<?, ?>> FALLEN_OAK_TREE = featureGetter.getOrThrow(RuMiscOverworldFeatures.FALLEN_OAK_TREE);
        final Holder<ConfiguredFeature<?, ?>> FALLEN_OAK_TREE_WITH_BLOB = featureGetter.getOrThrow(RuMiscOverworldFeatures.FALLEN_OAK_TREE_WITH_BLOB);
        final Holder<ConfiguredFeature<?, ?>> FALLEN_PINE_TREE = featureGetter.getOrThrow(RuMiscOverworldFeatures.FALLEN_PINE_TREE);
        final Holder<ConfiguredFeature<?, ?>> FALLEN_SILVER_BIRCH_TREE = featureGetter.getOrThrow(RuMiscOverworldFeatures.FALLEN_SILVER_BIRCH_TREE);
        //CAVE_FEATURES
        final Holder<ConfiguredFeature<?, ?>>  POINTED_REDSTONE = featureGetter.getOrThrow(RuMiscOverworldFeatures.POINTED_REDSTONE);
        final Holder<ConfiguredFeature<?, ?>>  LARGE_POINTED_REDSTONE = featureGetter.getOrThrow(RuMiscOverworldFeatures.LARGE_POINTED_REDSTONE);
        final Holder<ConfiguredFeature<?, ?>>  POINTED_REDSTONE_CLUSTER = featureGetter.getOrThrow(RuMiscOverworldFeatures.POINTED_REDSTONE_CLUSTER);
        final Holder<ConfiguredFeature<?, ?>>  POINTED_REDSTONE_NETHER = featureGetter.getOrThrow(RuMiscOverworldFeatures.POINTED_REDSTONE_NETHER);
        final Holder<ConfiguredFeature<?, ?>>  LARGE_POINTED_REDSTONE_NETHER = featureGetter.getOrThrow(RuMiscOverworldFeatures.LARGE_POINTED_REDSTONE_NETHER);
        final Holder<ConfiguredFeature<?, ?>>  POINTED_REDSTONE_CLUSTER_NETHER = featureGetter.getOrThrow(RuMiscOverworldFeatures.POINTED_REDSTONE_CLUSTER_NETHER);
        final Holder<ConfiguredFeature<?, ?>>  ORE_REDSTONE_LARGE = featureGetter.getOrThrow(RuMiscOverworldFeatures.ORE_REDSTONE_LARGE);

        final Holder<ConfiguredFeature<?, ?>>  PRISMARITE_CLUSTERS = featureGetter.getOrThrow(RuMiscOverworldFeatures.PRISMARITE_CLUSTERS);
        final Holder<ConfiguredFeature<?, ?>>  HANGING_PRISMARITE_CLUSTER = featureGetter.getOrThrow(RuMiscOverworldFeatures.HANGING_PRISMARITE_CLUSTER);

        final Holder<ConfiguredFeature<?, ?>>  MINERAL_POOL = featureGetter.getOrThrow(RuMiscOverworldFeatures.MINERAL_POOL);

        final Holder<ConfiguredFeature<?, ?>>  LAVA_FALL = featureGetter.getOrThrow(RuMiscOverworldFeatures.LAVA_FALL);
        final Holder<ConfiguredFeature<?, ?>>  OVERWORLD_LAVA_DELTA = featureGetter.getOrThrow(RuMiscOverworldFeatures.OVERWORLD_LAVA_DELTA);
        final Holder<ConfiguredFeature<?, ?>>  ASH_VENT = featureGetter.getOrThrow(RuMiscOverworldFeatures.ASH_VENT);
        final Holder<ConfiguredFeature<?, ?>>  BASALT_BLOB = featureGetter.getOrThrow(RuMiscOverworldFeatures.BASALT_BLOB);
        //OTHER_FEATURES
        final Holder<ConfiguredFeature<?, ?>>  ICICLE_UP = featureGetter.getOrThrow(RuMiscOverworldFeatures.ICICLE_UP);
        final Holder<ConfiguredFeature<?, ?>>  SMOULDERING_DIRT = featureGetter.getOrThrow(RuMiscOverworldFeatures.SMOULDERING_DIRT);
        final Holder<ConfiguredFeature<?, ?>>  MEADOW_ROCK = featureGetter.getOrThrow(RuMiscOverworldFeatures.MEADOW_ROCK);
        final Holder<ConfiguredFeature<?, ?>>  NOISE_PUMPKINS = featureGetter.getOrThrow(RuMiscOverworldFeatures.PATCH_NOISE_PUMPKINS);

        //--------------------PLACEMENTS--------------------//
        //ROCKS
        register(context, RuMiscOverworldPlacements.REDWOODS_ROCK, REDWOODS_ROCK, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        //FALLEN_TREES
        register(context, RuMiscOverworldPlacements.FALLEN_LARCH_TREE, FALLEN_LARCH_TREE, List.of(RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.FALLEN_SILVER_BIRCH_TREE, FALLEN_SILVER_BIRCH_TREE, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.FALLEN_MAPLE_TREE, FALLEN_MAPLE_TREE, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.FALLEN_OAK_TREE_SPARSE, FALLEN_OAK_TREE, List.of(RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.FALLEN_OAK_TREE_DENSE, FALLEN_OAK_TREE_WITH_BLOB, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.FALLEN_PINE_TREE, FALLEN_PINE_TREE, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(PlacedFeatureRegistry.onDirtPredicate), BiomeFilter.biome()));
        //CAVE_FEATURES
        register(context, RuMiscOverworldPlacements.POINTED_REDSTONE, POINTED_REDSTONE, CountPlacement.of(UniformInt.of(192, 256)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, CountPlacement.of(UniformInt.of(1, 5)), RandomOffsetPlacement.of(ClampedNormalInt.of(0.0F, 3.0F, -10, 10), ClampedNormalInt.of(0.0F, 0.6F, -2, 2)), BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.LARGE_POINTED_REDSTONE, LARGE_POINTED_REDSTONE, CountPlacement.of(UniformInt.of(10, 48)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.POINTED_REDSTONE_CLUSTER, POINTED_REDSTONE_CLUSTER, CountPlacement.of(UniformInt.of(78, 126)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.POINTED_REDSTONE_NETHER, POINTED_REDSTONE_NETHER, CountPlacement.of(UniformInt.of(192, 256)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, CountPlacement.of(UniformInt.of(1, 5)), RandomOffsetPlacement.of(ClampedNormalInt.of(0.0F, 3.0F, -10, 10), ClampedNormalInt.of(0.0F, 0.6F, -2, 2)), BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.LARGE_POINTED_REDSTONE_NETHER, LARGE_POINTED_REDSTONE_NETHER, CountPlacement.of(UniformInt.of(10, 48)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.POINTED_REDSTONE_CLUSTER_NETHER, POINTED_REDSTONE_CLUSTER_NETHER, CountPlacement.of(UniformInt.of(78, 126)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.ORE_REDSTONE_LARGE, ORE_REDSTONE_LARGE, commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(112))));

        register(context, RuMiscOverworldPlacements.PRISMARITE_CLUSTERS, PRISMARITE_CLUSTERS, List.of(CountOnEveryLayerPlacement.of(8), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.HANGING_PRISMARITE_CLUSTER, HANGING_PRISMARITE_CLUSTER, CountPlacement.of(UniformInt.of(78, 126)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());

        register(context, RuMiscOverworldPlacements.MINERAL_POOL, MINERAL_POOL, CountPlacement.of(70), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());

        register(context, RuMiscOverworldPlacements.LAVA_FALL, LAVA_FALL, List.of(CountOnEveryLayerPlacement.of(6), InSquarePlacement.spread(), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.OVERWORLD_LAVA_DELTA, OVERWORLD_LAVA_DELTA, CountPlacement.of(115), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1)), BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.ASH_VENT, ASH_VENT, List.of(CountOnEveryLayerPlacement.of(7), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.BASALT_BLOB, BASALT_BLOB, CountOnEveryLayerPlacement.of(4), BiomeFilter.biome());
        //OTHER_FEATURES
        register(context, RuMiscOverworldPlacements.ICICLE_UP, ICICLE_UP, List.of(CountPlacement.of(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BlockPredicateFilter.forPredicate(PlacedFeatureRegistry.onSnowPredicate), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.SMOULDERING_DIRT, SMOULDERING_DIRT, CountPlacement.of(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE,  BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.MEADOW_ROCK, MEADOW_ROCK, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.NOISE_PUMPKINS, NOISE_PUMPKINS, List.of(CountPlacement.of(18), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    }
    private static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier placementModifier1) {
        return List.of(placementModifier, InSquarePlacement.spread(), placementModifier1, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int i, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(i), placementModifier);
    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, PlacementModifier... placement) {
        register(context, key, feature, List.of(placement));
    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placement) {
        context.register(key, new PlacedFeature(feature, placement));
    }
}
