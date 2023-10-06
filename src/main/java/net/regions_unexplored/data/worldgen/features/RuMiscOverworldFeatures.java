package net.regions_unexplored.data.worldgen.features;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ClampedNormalFloat;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.registry.ConfiguredFeatureRegistry;
import net.regions_unexplored.registry.FeatureRegistry;
import net.regions_unexplored.world.level.block.other.AshBlock;
import net.regions_unexplored.world.level.block.wood.AspenLogBlock;
import net.regions_unexplored.world.level.feature.configuration.FallenTreeConfiguration;
import net.regions_unexplored.world.level.feature.configuration.LargePointedRedstoneConfiguration;
import net.regions_unexplored.world.level.feature.configuration.PointedRedstoneClusterConfiguration;
import net.regions_unexplored.world.level.feature.configuration.PointedRedstoneConfiguration;

import java.util.List;

public class RuMiscOverworldFeatures {
    public static final RuleTest baseStoneTest = new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD);
    public static final RuleTest stoneOreTest = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
    public static final RuleTest deepslateOreTest = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
    public static final List<OreConfiguration.TargetBlockState> ORE_REDSTONE_TARGET_LIST = List.of(OreConfiguration.target(stoneOreTest, Blocks.REDSTONE_ORE.defaultBlockState()), OreConfiguration.target(deepslateOreTest, Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState()));
    public static final List<OreConfiguration.TargetBlockState> STONE_GRASS_TARGET_LIST = List.of(OreConfiguration.target(stoneOreTest, RuBlocks.STONE_GRASS_BLOCK.get().defaultBlockState()), OreConfiguration.target(deepslateOreTest, RuBlocks.DEEPSLATE_GRASS_BLOCK.get().defaultBlockState()));
    //-----------------------KEYS-----------------------//
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_CLAY = ConfiguredFeatureRegistry.register("disk_clay", Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.CLAY), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, RuBlocks.PEAT_DIRT.get(), RuBlocks.SILT_DIRT.get(), RuBlocks.SILT_MUD.get(), RuBlocks.PEAT_MUD.get(), Blocks.CLAY)), UniformInt.of(2, 3), 1));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_GRAVEL = ConfiguredFeatureRegistry.register("disk_gravel", Feature.DISK, new DiskConfiguration(RuleBasedBlockStateProvider.simple(Blocks.GRAVEL), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, RuBlocks.PEAT_DIRT.get(), RuBlocks.SILT_DIRT.get(), RuBlocks.SILT_MUD.get(), RuBlocks.PEAT_MUD.get(), RuBlocks.SILT_GRASS_BLOCK.get(), RuBlocks.PEAT_GRASS_BLOCK.get(),  Blocks.GRASS_BLOCK)), UniformInt.of(2, 5), 2));
    public static final Holder<ConfiguredFeature<DiskConfiguration, ?>> DISK_SAND = ConfiguredFeatureRegistry.register("disk_sand", Feature.DISK, new DiskConfiguration(new RuleBasedBlockStateProvider(BlockStateProvider.simple(Blocks.SAND), List.of(new RuleBasedBlockStateProvider.Rule(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.AIR), BlockStateProvider.simple(Blocks.SANDSTONE)))), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, RuBlocks.PEAT_DIRT.get(), RuBlocks.SILT_DIRT.get(), RuBlocks.SILT_MUD.get(), RuBlocks.PEAT_MUD.get(), RuBlocks.SILT_GRASS_BLOCK.get(), RuBlocks.PEAT_GRASS_BLOCK.get(),  Blocks.GRASS_BLOCK)), UniformInt.of(2, 6), 2));
    public static final Holder<ConfiguredFeature<BlockStateConfiguration, ?>> REDWOODS_ROCK = ConfiguredFeatureRegistry.register("redwoods_rock", Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.MOSSY_COBBLESTONE.defaultBlockState()));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> FALLEN_LARCH_TREE = ConfiguredFeatureRegistry.register("fallen_larch_tree", FeatureRegistry.FALLEN_BLOB_TREE.get(), new FallenTreeConfiguration(BlockStateProvider.simple(RuBlocks.LARCH_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.LARCH_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.GOLDEN_LARCH_LEAVES.get().defaultBlockState()), 5, 9, false));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> FALLEN_MAPLE_TREE = ConfiguredFeatureRegistry.register("fallen_maple_tree", FeatureRegistry.FALLEN_BLOB_TREE.get(), new FallenTreeConfiguration(BlockStateProvider.simple(RuBlocks.MAPLE_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.MAPLE_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.MAPLE_LEAVES.get().defaultBlockState()), 4, 4, false));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> FALLEN_OAK_TREE = ConfiguredFeatureRegistry.register("fallen_oak_tree", FeatureRegistry.FALLEN_BLOB_TREE.get(), new FallenTreeConfiguration(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), BlockStateProvider.simple(RuBlocks.DEAD_LEAVES.get().defaultBlockState()), 4, 4, false));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> FALLEN_OAK_TREE_WITH_BLOB = ConfiguredFeatureRegistry.register("fallen_oak_tree_with_blob", FeatureRegistry.FALLEN_BLOB_TREE.get(), new FallenTreeConfiguration(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), BlockStateProvider.simple(RuBlocks.DEAD_LEAVES.get().defaultBlockState()), 4, 4, true));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> FALLEN_PINE_TREE = ConfiguredFeatureRegistry.register("fallen_pine_tree", FeatureRegistry.FALLEN_BLOB_TREE.get(), new FallenTreeConfiguration(BlockStateProvider.simple(RuBlocks.PINE_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.PINE_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.PINE_LEAVES.get().defaultBlockState()), 5, 6, false));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> FALLEN_SNOW_PINE_TREE = ConfiguredFeatureRegistry.register("fallen_snow_pine_tree", FeatureRegistry.FALLEN_SNOW_TREE.get(), new FallenTreeConfiguration(BlockStateProvider.simple(RuBlocks.STRIPPED_PINE_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.STRIPPED_PINE_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.PINE_LEAVES.get().defaultBlockState()), 5, 6, false));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> FALLEN_SILVER_BIRCH_TREE = ConfiguredFeatureRegistry.register("fallen_silver_birch_tree", FeatureRegistry.FALLEN_BLOB_TREE.get(), new FallenTreeConfiguration(BlockStateProvider.simple(RuBlocks.SILVER_BIRCH_LOG.get().defaultBlockState().setValue(AspenLogBlock.IS_BASE, true)), BlockStateProvider.simple(RuBlocks.SILVER_BIRCH_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.SILVER_BIRCH_LEAVES.get().defaultBlockState()), 4, 3, false));
    public static final Holder<ConfiguredFeature<SimpleRandomFeatureConfiguration, ?>> POINTED_REDSTONE = ConfiguredFeatureRegistry.register("pointed_redstone", Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfiguration(HolderSet.direct(PlacementUtils.inlinePlaced(FeatureRegistry.POINTED_REDSTONE.get(), new PointedRedstoneConfiguration(0.5F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1))), PlacementUtils.inlinePlaced(FeatureRegistry.POINTED_REDSTONE.get(), new PointedRedstoneConfiguration(0.5F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1))))));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> LARGE_POINTED_REDSTONE = ConfiguredFeatureRegistry.register("large_pointed_redstone", FeatureRegistry.LARGE_POINTED_REDSTONE.get(), new LargePointedRedstoneConfiguration(30, UniformInt.of(1, 6), UniformFloat.of(0.4F, 2.0F), 0.33F, UniformFloat.of(0.3F, 0.9F), UniformFloat.of(0.4F, 1.0F), UniformFloat.of(0.0F, 0.3F), 4, 0.6F));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> POINTED_REDSTONE_CLUSTER = ConfiguredFeatureRegistry.register("pointed_redstone_cluster", FeatureRegistry.POINTED_REDSTONE_CLUSTER.get(), new PointedRedstoneClusterConfiguration(12, UniformInt.of(3, 6), UniformInt.of(2, 8), 1, 3, UniformInt.of(2, 4), UniformFloat.of(0.3F, 0.7F), ClampedNormalFloat.of(0.1F, 0.3F, 0.1F, 0.9F), 0.1F, 3, 8));
    public static final Holder<ConfiguredFeature<OreConfiguration, ?>> ORE_REDSTONE_LARGE = ConfiguredFeatureRegistry.register("ore_redstone_large", Feature.ORE, new OreConfiguration(ORE_REDSTONE_TARGET_LIST, 20));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PRISMARITE_CLUSTERS = ConfiguredFeatureRegistry.register("prismarite_clusters", Feature.RANDOM_PATCH, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.LARGE_PRISMARITE_CLUSTER.get().defaultBlockState(), 1).add(RuBlocks.PRISMARITE_CLUSTER.get().defaultBlockState(), 5)), 32));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> HANGING_PRISMARITE_CLUSTER = ConfiguredFeatureRegistry.register("hanging_prismarite_cluster", FeatureRegistry.HANGING_PRISMARITE.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> MINERAL_POOL = ConfiguredFeatureRegistry.register("mineral_pool", Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.LUSH_GROUND_REPLACEABLE, BlockStateProvider.simple(Blocks.CALCITE), PlacementUtils.inlinePlaced(CaveFeatures.POINTED_DRIPSTONE), CaveSurface.FLOOR, ConstantInt.of(3), 0.8F, 5, 0.1F, UniformInt.of(4, 7), 0.7F));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> LAVA_FALL = ConfiguredFeatureRegistry.register("lava_fall", FeatureRegistry.LAVA_FALL.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> OVERWORLD_LAVA_DELTA = ConfiguredFeatureRegistry.register("overworld_lava_delta", FeatureRegistry.OVERWORLD_LAVA_DELTA.get(), new VegetationPatchConfiguration(BlockTags.LUSH_GROUND_REPLACEABLE, BlockStateProvider.simple(RuBlocks.VOLCANIC_ASH.get().defaultBlockState().setValue(AshBlock.HAS_GRAVITY, false)), PlacementUtils.inlinePlaced(CaveFeatures.POINTED_DRIPSTONE), CaveSurface.FLOOR, ConstantInt.of(3), 0.8F, 5, 0.1F, UniformInt.of(4, 7), 0.7F));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> ASH_VENT = ConfiguredFeatureRegistry.register("ash_vent", FeatureRegistry.ASH_VENT.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> BASALT_BLOB = ConfiguredFeatureRegistry.register("basalt_blob", FeatureRegistry.BASALT_BLOB.get(), new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 4)));
    public static final Holder<ConfiguredFeature<VegetationPatchConfiguration, ?>> MOSS_PATCH_WITH_WATER = ConfiguredFeatureRegistry.register("moss_patch_with_water", Feature.WATERLOGGED_VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.LUSH_GROUND_REPLACEABLE, BlockStateProvider.simple(Blocks.MOSS_BLOCK), PlacementUtils.inlinePlaced(RuVegetationFeatures.PATCH_GRASS), CaveSurface.FLOOR, ConstantInt.of(3), 0.8F, 5, 0.1F, UniformInt.of(4, 7), 0.7F));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> MARSH = ConfiguredFeatureRegistry.register("marsh", FeatureRegistry.MARSH.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> WATER_EDGE = ConfiguredFeatureRegistry.register("water_edge", FeatureRegistry.WATER_EDGE.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> ICICLE_UP = ConfiguredFeatureRegistry.register("icicle_up", FeatureRegistry.ICICLE_UP.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> SMOULDERING_DIRT = ConfiguredFeatureRegistry.register("smouldering_dirt", FeatureRegistry.SMOULDERING_DIRT.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> MEADOW_ROCK = ConfiguredFeatureRegistry.register("meadow_rock", FeatureRegistry.MEADOW_ROCK.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> ROCK = ConfiguredFeatureRegistry.register("rock", FeatureRegistry.ROCK.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_NOISE_PUMPKINS = ConfiguredFeatureRegistry.register("patch_noise_pumpkins", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.PUMPKIN.defaultBlockState(), 4).add(Blocks.CARVED_PUMPKIN.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, Direction.NORTH), 1).add(Blocks.CARVED_PUMPKIN.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, Direction.SOUTH), 1).add(Blocks.CARVED_PUMPKIN.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, Direction.EAST), 1).add(Blocks.CARVED_PUMPKIN.defaultBlockState().setValue(CarvedPumpkinBlock.FACING, Direction.WEST), 1).add(Blocks.AIR.defaultBlockState(), 75))), List.of(RuBlocks.SILT_PODZOL.get(), Blocks.SNOW_BLOCK), 125));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_NOISE_ROCKS = ConfiguredFeatureRegistry.register("patch_noise_rocks", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.STONE_GRASS_BLOCK.get().defaultBlockState(), 1).add(RuBlocks.MOSSY_STONE.get().defaultBlockState(), 1).add(Blocks.STONE.defaultBlockState(), 1).add(Blocks.COBBLESTONE.defaultBlockState(), 1).add(Blocks.AIR.defaultBlockState(), 75))), List.of(Blocks.GRASS_BLOCK), 125));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_NOISE_BUSH = ConfiguredFeatureRegistry.register("patch_noise_bush", Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.MAPLE_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2).add(Blocks.OAK_LEAVES.defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2).add(Blocks.AIR.defaultBlockState(), 75))), List.of(Blocks.GRASS_BLOCK), 125));

    private static RandomPatchConfiguration grassPatch(BlockStateProvider stateProvider, int i) {
        return FeatureUtils.simpleRandomPatchConfiguration(i, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider)));
    }
}
