package net.regions_unexplored.data.worldgen.placement;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.MiscOverworldFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
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
    //OTHER_FEATURES
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
        //OTHER_FEATURES
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
        //OTHER_FEATURES
        register(context, RuMiscOverworldPlacements.SMOULDERING_DIRT, SMOULDERING_DIRT, CountPlacement.of(25), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE,  BiomeFilter.biome());
        register(context, RuMiscOverworldPlacements.MEADOW_ROCK, MEADOW_ROCK, List.of(CountPlacement.of(1), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuMiscOverworldPlacements.NOISE_PUMPKINS, NOISE_PUMPKINS, List.of(CountPlacement.of(18), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, PlacementModifier... placement) {
        register(context, key, feature, List.of(placement));
    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placement) {
        context.register(key, new PlacedFeature(feature, placement));
    }
}
