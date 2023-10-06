package net.regions_unexplored.data.worldgen.placement;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.placement.*;
import net.regions_unexplored.data.worldgen.features.RuAquaticFeatures;
import net.regions_unexplored.data.worldgen.features.RuVegetationFeatures;
import net.regions_unexplored.registry.PlacedFeatureRegistry;

import java.util.List;

public class RuAquaticPlacements {

    public static final Holder<PlacedFeature> CATTAIL_FEN = PlacedFeatureRegistry.register("cattail_fen", RuAquaticFeatures.FEN_CATTAIL, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 24), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(3), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome()));
    public static final Holder<PlacedFeature> CATTAIL_RIVER = PlacedFeatureRegistry.register("cattail_river", RuAquaticFeatures.WATER_CATTAIL, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 6), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(3), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome()));

    public static final Holder<PlacedFeature> TALL_HYACINTH_STOCK = PlacedFeatureRegistry.register("tall_hyacinth_stock", RuAquaticFeatures.TALL_HYACINTH_STOCK, NoiseBasedCountPlacement.of(20, 80.0D, 0.3D), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
    public static final Holder<PlacedFeature> HYACINTH_PLANTS = PlacedFeatureRegistry.register("hyacinth_plants", RuAquaticFeatures.HYACINTH_PLANTS, seagrassPlacement(80));
    public static final Holder<PlacedFeature> HYACINTH_FLOWERS = PlacedFeatureRegistry.register("hyacinth_flowers", RuAquaticFeatures.HYACINTH_FLOWERS, CountPlacement.of(15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
    public static final Holder<PlacedFeature> HYACINTH_ROCKS = PlacedFeatureRegistry.register("hyacinth_rocks", RuAquaticFeatures.HYACINTH_ROCKS, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());

    public static final Holder<PlacedFeature> MOSSY_SEA_ROCKS = PlacedFeatureRegistry.register("mossy_sea_rocks", RuAquaticFeatures.MOSSY_SEA_ROCKS, NoiseBasedCountPlacement.of(1, 80.0D, 0.3D), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());

    public static final Holder<PlacedFeature> BLUE_MAGNOLIA_FLOWERS_AQUATIC = PlacedFeatureRegistry.register("blue_magnolia_flowers_aquatic", RuAquaticFeatures.BLUE_MAGNOLIA_FLOWERS_AQUATIC, CountPlacement.of(35), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
    public static final Holder<PlacedFeature> PINK_MAGNOLIA_FLOWERS_AQUATIC = PlacedFeatureRegistry.register("pink_magnolia_flowers_aquatic", RuAquaticFeatures.PINK_MAGNOLIA_FLOWERS_AQUATIC, CountPlacement.of(35), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
    public static final Holder<PlacedFeature> WHITE_MAGNOLIA_FLOWERS_AQUATIC = PlacedFeatureRegistry.register("white_magnolia_flowers_aquatic", RuAquaticFeatures.WHITE_MAGNOLIA_FLOWERS_AQUATIC, CountPlacement.of(35), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
    public static final Holder<PlacedFeature> JUNGLE_TREE_AQUATIC = PlacedFeatureRegistry.register("jungle_tree_aquatic", RuAquaticFeatures.JUNGLE_TREE_AQUATIC, List.of(CountPlacement.of(24), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> PALM_TREE_AQUATIC = PlacedFeatureRegistry.register("palm_tree_aquatic", RuAquaticFeatures.PALM_TREE_AQUATIC, List.of(CountPlacement.of(15), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> PALM_SAPLING_AQUATIC = PlacedFeatureRegistry.register("palm_sapling_aquatic", RuVegetationFeatures.PALM_SHRUB, List.of(CountPlacement.of(5), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));
    public static final Holder<PlacedFeature> ELEPHANT_EAR_AQUATIC = PlacedFeatureRegistry.register("elephant_ear_aquatic", RuAquaticFeatures.ELEPHANT_EAR_AQUATIC, List.of(CountPlacement.of(8), InSquarePlacement.spread(), SurfaceWaterDepthFilter.forMaxDepth(0), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome()));

    private static List<PlacementModifier> seagrassPlacement(int count) {
        return List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_TOP_SOLID, CountPlacement.of(count), BiomeFilter.biome());
    }
}
