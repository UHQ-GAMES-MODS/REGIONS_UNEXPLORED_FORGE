package net.regions_unexplored.data.worldgen.placement;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;
import net.regions_unexplored.registry.PlacedFeatureRegistry;

import java.util.List;

public class RuTreePlacements {
    //TODO:Build Class

    public static BlockPredicate onDirtPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.COARSE_DIRT, Blocks.DIRT, RuBlocks.FOREST_DIRT.get(), RuBlocks.PLAINS_DIRT.get());
    public static BlockPredicate onGrassBlockPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK, RuBlocks.FOREST_GRASS_BLOCK.get(), RuBlocks.PLAINS_GRASS_BLOCK.get(), RuBlocks.STONE_GRASS_BLOCK.get(), RuBlocks.DEEPSLATE_GRASS_BLOCK.get());
    //-----------------------KEYS-----------------------//
    public static final ResourceKey<PlacedFeature> ALPHA_TREE = PlacedFeatureRegistry.createKey("alpha_tree");

    public static final ResourceKey<PlacedFeature> ULTRA_REDWOOD_TREE = PlacedFeatureRegistry.createKey("ultra_redwood_tree");
    public static final ResourceKey<PlacedFeature> GIANT_REDWOOD_TREE_DENSE = PlacedFeatureRegistry.createKey("giant_redwood_tree_dense");
    public static final ResourceKey<PlacedFeature> GIANT_REDWOOD_TREE_SPARSE = PlacedFeatureRegistry.createKey("giant_redwood_tree_sparse");
    public static final ResourceKey<PlacedFeature> REDWOOD_TREE = PlacedFeatureRegistry.createKey("redwood_tree");

    public static final ResourceKey<PlacedFeature> SILVER_BIRCH_DENSE = PlacedFeatureRegistry.createKey("silver_birch_dense");
    public static final ResourceKey<PlacedFeature> SILVER_BIRCH_SPARSE = PlacedFeatureRegistry.createKey("silver_birch_sparse");
    public static final ResourceKey<PlacedFeature> SILVER_BIRCH_ON_DIRT = PlacedFeatureRegistry.createKey("silver_birch_on_dirt");
    public static final ResourceKey<PlacedFeature> SILVER_BIRCH_TALL = PlacedFeatureRegistry.createKey("silver_birch_tall");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> featureGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        //---------------------FEATURES---------------------//
        final Holder<ConfiguredFeature<?, ?>> ALPHA_TREE = featureGetter.getOrThrow(RuTreeFeatures.ALPHA_OAK_TREE);

        final Holder<ConfiguredFeature<?, ?>> ULTRA_REDWOOD_TREE = featureGetter.getOrThrow(RuTreeFeatures.ULTRA_REDWOOD_TREE);
        final Holder<ConfiguredFeature<?, ?>> GIANT_REDWOOD_TREE = featureGetter.getOrThrow(RuTreeFeatures.GIANT_REDWOOD_TREE);
        final Holder<ConfiguredFeature<?, ?>> REDWOOD_TREE = featureGetter.getOrThrow(RuTreeFeatures.REDWOOD_TREE);

        final Holder<ConfiguredFeature<?, ?>> SILVER_BIRCH = featureGetter.getOrThrow(RuTreeFeatures.SILVER_BIRCH);
        final Holder<ConfiguredFeature<?, ?>> SILVER_BIRCH_TALL = featureGetter.getOrThrow(RuTreeFeatures.SILVER_BIRCH_TALL);
        //--------------------PLACEMENTS--------------------//
        register(context, RuTreePlacements.ALPHA_TREE, ALPHA_TREE, List.of(CountPlacement.of(7), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.ULTRA_REDWOOD_TREE, ULTRA_REDWOOD_TREE, List.of(NoiseBasedCountPlacement.of(1, 80.0D, 0.3D), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.GIANT_REDWOOD_TREE_DENSE, GIANT_REDWOOD_TREE, List.of(CountPlacement.of(6), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.GIANT_REDWOOD_TREE_SPARSE, GIANT_REDWOOD_TREE, List.of(NoiseBasedCountPlacement.of(1, 80.0D, 0.3D), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.REDWOOD_TREE, REDWOOD_TREE, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

        register(context, RuTreePlacements.SILVER_BIRCH_DENSE, SILVER_BIRCH, List.of(CountPlacement.of(6), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.SILVER_BIRCH_SPARSE, SILVER_BIRCH, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
        register(context, RuTreePlacements.SILVER_BIRCH_ON_DIRT, SILVER_BIRCH, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BlockPredicateFilter.forPredicate(onDirtPredicate), BiomeFilter.biome()));
        register(context, RuTreePlacements.SILVER_BIRCH_TALL, SILVER_BIRCH_TALL, List.of(CountPlacement.of(2), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, PlacementModifier... placement) {
        register(context, key, feature, List.of(placement));
    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placement) {
        context.register(key, new PlacedFeature(feature, placement));
    }
}
