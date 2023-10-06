package net.regions_unexplored.data.worldgen.placement;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.valueproviders.ClampedNormalInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.placement.*;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.worldgen.features.RuNetherFeatures;
import net.regions_unexplored.data.worldgen.features.RuVegetationFeatures;
import net.regions_unexplored.registry.PlacedFeatureRegistry;

import java.util.List;

public class RuNetherPlacements {
    public static final Holder<PlacedFeature> BLACKSTONE_CLUSTER = PlacedFeatureRegistry.register("blackstone_cluster", RuNetherFeatures.PATCH_BLACKSTONE_CLUSTER, List.of(CountOnEveryLayerPlacement.of(4), PlacementUtils.filteredByBlockSurvival(RuBlocks.STONE_BUD.get()), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> BRIMSPROUT = PlacedFeatureRegistry.register("brimsprout", RuNetherFeatures.PATCH_BRIMSPROUT, List.of(CountOnEveryLayerPlacement.of(30), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> BRIMWOOD_SHRUB = PlacedFeatureRegistry.register("brimwood_shrub", RuNetherFeatures.BRIMWOOD_SHRUB, List.of(CountOnEveryLayerPlacement.of(1), PlacementUtils.filteredByBlockSurvival(RuBlocks.BRIMSPROUT.get()), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> BRIM_FLAMES = PlacedFeatureRegistry.register("brim_flames", RuNetherFeatures.PATCH_BRIM_FLAMES, List.of(CountOnEveryLayerPlacement.of(5), PlacementUtils.filteredByBlockSurvival(RuBlocks.BRIMSPROUT.get()), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> COBALT_EARLIGHT = PlacedFeatureRegistry.register("cobalt_earlight", RuNetherFeatures.PATCH_COBALT_EARLIGHT, List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> COBALT_ROOTS = PlacedFeatureRegistry.register("cobalt_roots", RuNetherFeatures.PATCH_COBALT_ROOTS, List.of(CountOnEveryLayerPlacement.of(8), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> DORCEL = PlacedFeatureRegistry.register("dorcel", RuNetherFeatures.DORCEL, List.of(CountOnEveryLayerPlacement.of(2), PlacementUtils.filteredByBlockSurvival(RuBlocks.BRIMSPROUT.get()), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> GLISTERING_BLOOM = PlacedFeatureRegistry.register("glistering_bloom", RuNetherFeatures.PATCH_GLISTERING_BLOOM, List.of(CountOnEveryLayerPlacement.of(7), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> GLISTERING_FERN = PlacedFeatureRegistry.register("glistering_fern", RuNetherFeatures.PATCH_GLISTERING_FERN, List.of(CountOnEveryLayerPlacement.of(15), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> GLISTERING_IVY = PlacedFeatureRegistry.register("glistering_ivy", RuNetherFeatures.PATCH_GLISTERING_IVY, CountPlacement.of(155), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> GLISTERING_MEADOW_ROCK = PlacedFeatureRegistry.register("glistering_meadow_rock", RuNetherFeatures.NETHER_ROCK, CountOnEveryLayerPlacement.of(1), PlacementUtils.filteredByBlockSurvival(RuBlocks.GLISTERING_NYLIUM.get()), BiomeFilter.biome());
    public static final Holder<PlacedFeature> GLISTERING_SPROUT = PlacedFeatureRegistry.register("glistering_sprout", RuNetherFeatures.PATCH_GLISTERING_SPROUT, List.of(CountOnEveryLayerPlacement.of(30), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> GLISTER_BULB = PlacedFeatureRegistry.register("glister_bulb", RuNetherFeatures.PATCH_GLISTER_BULB, List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> GLISTER_SPIRE = PlacedFeatureRegistry.register("glister_spire", RuNetherFeatures.PATCH_GLISTER_SPIRE, List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> HANGING_EARLIGHT = PlacedFeatureRegistry.register("hanging_earlight", RuNetherFeatures.PATCH_HANGING_EARLIGHT, CountPlacement.of(225), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> LARGE_POINTED_REDSTONE_NETHER = PlacedFeatureRegistry.register("large_pointed_redstone_nether", RuNetherFeatures.LARGE_POINTED_REDSTONE_NETHER, CountPlacement.of(UniformInt.of(10, 48)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
    public static final Holder<PlacedFeature> MYCOTOXIC_BIOSHROOM = PlacedFeatureRegistry.register("mycotoxic_bioshroom", RuVegetationFeatures.PATCH_YELLOW_BIOSHROOM, List.of(CountOnEveryLayerPlacement.of(7), PlacementUtils.filteredByBlockSurvival(RuBlocks.STONE_BUD.get()), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> MYCOTOXIC_DAISY = PlacedFeatureRegistry.register("mycotoxic_daisy", RuNetherFeatures.PATCH_MYCOTOXIC_DAISY, List.of(CountOnEveryLayerPlacement.of(5), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> MYCOTOXIC_GRASS = PlacedFeatureRegistry.register("mycotoxic_grass", RuNetherFeatures.PATCH_MYCOTOXIC_GRASS, List.of(CountOnEveryLayerPlacement.of(30), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> MYCOTOXIC_MUSHROOMS = PlacedFeatureRegistry.register("mycotoxic_mushrooms", RuNetherFeatures.PATCH_MYCOTOXIC_MUSHROOMS, List.of(CountOnEveryLayerPlacement.of(1),  NoiseThresholdCountPlacement.of(-0.8D, 5, 12), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> OBSIDIAN_SPIRE = PlacedFeatureRegistry.register("obsidian_spire", RuNetherFeatures.OBSIDIAN_SPIRE, CountPlacement.of(155), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
    public static final Holder<PlacedFeature> POINTED_REDSTONE_CLUSTER_NETHER = PlacedFeatureRegistry.register("pointed_redstone_cluster_nether", RuNetherFeatures.POINTED_REDSTONE_CLUSTER_NETHER, CountPlacement.of(UniformInt.of(78, 126)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, BiomeFilter.biome());
    public static final Holder<PlacedFeature> POINTED_REDSTONE_NETHER = PlacedFeatureRegistry.register("pointed_redstone_nether", RuNetherFeatures.POINTED_REDSTONE_NETHER, CountPlacement.of(UniformInt.of(192, 256)), InSquarePlacement.spread(), PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT, CountPlacement.of(UniformInt.of(1, 5)), RandomOffsetPlacement.of(ClampedNormalInt.of(0.0F, 3.0F, -10, 10), ClampedNormalInt.of(0.0F, 0.6F, -2, 2)), BiomeFilter.biome());
    public static final Holder<PlacedFeature> SMALL_YELLOW_BIOSHROOM = PlacedFeatureRegistry.register("small_yellow_bioshroom", RuNetherFeatures.SMALL_YELLOW_BIOSHROOM, List.of(CountOnEveryLayerPlacement.of(1), PlacementUtils.filteredByBlockSurvival(RuBlocks.MYCOTOXIC_GRASS.get()), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> TALL_COBALT_EARLIGHT = PlacedFeatureRegistry.register("tall_cobalt_earlight", RuNetherFeatures.TALL_COBALT_EARLIGHT, List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome()));
}
