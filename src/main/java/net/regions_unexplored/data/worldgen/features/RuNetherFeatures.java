package net.regions_unexplored.data.worldgen.features;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ClampedNormalFloat;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.EnvironmentScanPlacement;
import net.minecraft.world.level.levelgen.placement.RandomOffsetPlacement;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.registry.ConfiguredFeatureRegistry;
import net.regions_unexplored.registry.FeatureRegistry;
import net.regions_unexplored.world.level.block.plant.flower.GroundCoverBlock;
import net.regions_unexplored.world.level.feature.configuration.LargePointedRedstoneConfiguration;
import net.regions_unexplored.world.level.feature.configuration.PointedRedstoneClusterConfiguration;
import net.regions_unexplored.world.level.feature.configuration.PointedRedstoneConfiguration;

public class RuNetherFeatures {
    public static final SimpleWeightedRandomList.Builder glisteringBoneMealBlocks = SimpleWeightedRandomList.builder().add(RuBlocks.GLISTERING_SPROUT.get().defaultBlockState(), 140).add(RuBlocks.GLISTERING_BLOOM.get().defaultBlockState(), 30).add(RuBlocks.GLISTERING_BLOOM.get().defaultBlockState(), 10);
    public static final SimpleWeightedRandomList.Builder cobaltBoneMealBlocks = SimpleWeightedRandomList.builder().add(RuBlocks.COBALT_ROOTS.get().defaultBlockState(), 100).add(RuBlocks.COBALT_EARLIGHT.get().defaultBlockState(), 2);
    public static final SimpleWeightedRandomList.Builder brimsproutBoneMealBlocks = SimpleWeightedRandomList.builder().add(RuBlocks.BRIMSPROUT.get().defaultBlockState(), 140).add(RuBlocks.DORCEL.get().defaultBlockState(), 1);

    public static final WeightedStateProvider glisteringWeights = new WeightedStateProvider(glisteringBoneMealBlocks);
    public static final WeightedStateProvider cobaltWeights = new WeightedStateProvider(cobaltBoneMealBlocks);
    public static final WeightedStateProvider brimsproutWeights = new WeightedStateProvider(brimsproutBoneMealBlocks);

    public static final SimpleWeightedRandomList.Builder<BlockState> getMycotoxicMushroomsBuilder(){
        SimpleWeightedRandomList.Builder<BlockState> mycotoxicMushroomsBuilder = SimpleWeightedRandomList.builder();

        for(int i = 1; i <= 4; ++i) {
            for(Direction direction : Direction.Plane.HORIZONTAL) {
                mycotoxicMushroomsBuilder.add(RuBlocks.MYCOTOXIC_MUSHROOMS.get().defaultBlockState().setValue(GroundCoverBlock.AMOUNT, Integer.valueOf(i)).setValue(GroundCoverBlock.FACING, direction), 1);
            }
        }

        return mycotoxicMushroomsBuilder;

    }
    public static final WeightedStateProvider getMycotoxicBoneMeals(){
        SimpleWeightedRandomList.Builder mycotoxicBoneMealBlocks = SimpleWeightedRandomList.builder().add(RuBlocks.MYCOTOXIC_GRASS.get().defaultBlockState(), 100);

        for(int i = 1; i <= 4; ++i) {
            for(Direction direction : Direction.Plane.HORIZONTAL) {
                mycotoxicBoneMealBlocks.add(RuBlocks.MYCOTOXIC_MUSHROOMS.get().defaultBlockState().setValue(GroundCoverBlock.AMOUNT, Integer.valueOf(i)).setValue(GroundCoverBlock.FACING, direction), 1);
            }
        }

        WeightedStateProvider mycotoxicWeights = new WeightedStateProvider(mycotoxicBoneMealBlocks);
        return mycotoxicWeights;

    }

    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> SMALL_YELLOW_BIOSHROOM = ConfiguredFeatureRegistry.register("small_yellow_bioshroom", FeatureRegistry.SMALL_YELLOW_BIOSHROOM.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_MYCOTOXIC_MUSHROOMS = ConfiguredFeatureRegistry.register("patch_mycotoxic_mushrooms", Feature.RANDOM_PATCH, new RandomPatchConfiguration(16, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(getMycotoxicMushroomsBuilder())))));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_MYCOTOXIC_GRASS = ConfiguredFeatureRegistry.register("patch_mycotoxic_grass", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.MYCOTOXIC_GRASS.get().defaultBlockState()), 32));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_MYCOTOXIC_DAISY = ConfiguredFeatureRegistry.register("patch_mycotoxic_daisy", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.MYCOTOXIC_DAISY.get().defaultBlockState()), 16));

    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BRIMSPROUT = ConfiguredFeatureRegistry.register("patch_brimsprout", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.BRIMSPROUT.get().defaultBlockState()), 32));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BRIM_FLAMES = ConfiguredFeatureRegistry.register("patch_brim_flames", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(Blocks.FIRE.defaultBlockState()), 12));
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> DORCEL = ConfiguredFeatureRegistry.register("dorcel", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.DORCEL.get())));
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> BRIMWOOD_SHRUB = ConfiguredFeatureRegistry.register("brimwood_shrub", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.BRIMWOOD_SHRUB.get())));

    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> NETHER_ROCK = ConfiguredFeatureRegistry.register("nether_rock", FeatureRegistry.NETHER_ROCK.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> PATCH_GLISTERING_IVY = ConfiguredFeatureRegistry.register("patch_glistering_ivy", FeatureRegistry.GLISTERING_IVY.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GLISTERING_SPROUT = ConfiguredFeatureRegistry.register("patch_glistering_sprout", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.GLISTERING_SPROUT.get().defaultBlockState()), 32));
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> PATCH_GLISTERING_FERN = ConfiguredFeatureRegistry.register("patch_glistering_fern", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.GLISTERING_FERN.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> PATCH_GLISTERING_BLOOM = ConfiguredFeatureRegistry.register("patch_glistering_bloom", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.GLISTERING_BLOOM.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_GLISTER_SPIRE = ConfiguredFeatureRegistry.register("patch_glister_spire", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.GLISTER_SPIRE.get().defaultBlockState()), 16));
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> PATCH_GLISTER_BULB = ConfiguredFeatureRegistry.register("patch_glister_bulb", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.GLISTER_BULB.get().defaultBlockState())));

    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> PATCH_HANGING_EARLIGHT = ConfiguredFeatureRegistry.register("patch_hanging_earlight", FeatureRegistry.HANGING_EARLIGHT.get(), FeatureConfiguration.NONE);
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_BLACKSTONE_CLUSTER = ConfiguredFeatureRegistry.register("patch_blackstone_cluster", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.BLACKSTONE_CLUSTER.get().defaultBlockState()), 16));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_COBALT_EARLIGHT = ConfiguredFeatureRegistry.register("patch_cobalt_earlight", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.COBALT_EARLIGHT.get().defaultBlockState()), 6));
    public static final Holder<ConfiguredFeature<SimpleBlockConfiguration, ?>> TALL_COBALT_EARLIGHT = ConfiguredFeatureRegistry.register("tall_cobalt_earlight", Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.TALL_COBALT_EARLIGHT.get().defaultBlockState())));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> PATCH_COBALT_ROOTS = ConfiguredFeatureRegistry.register("patch_cobalt_roots", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.COBALT_ROOTS.get().defaultBlockState()), 32));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> OBSIDIAN_SPIRE = ConfiguredFeatureRegistry.register("obsidian_spire", FeatureRegistry.OBSIDIAN_SPIRE.get(), FeatureConfiguration.NONE);

    public static final Holder<ConfiguredFeature<SimpleRandomFeatureConfiguration, ?>> POINTED_REDSTONE_NETHER = ConfiguredFeatureRegistry.register("pointed_redstone_nether", Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfiguration(HolderSet.direct(PlacementUtils.inlinePlaced(FeatureRegistry.POINTED_REDSTONE.get(), new PointedRedstoneConfiguration(0.5F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(1))), PlacementUtils.inlinePlaced(FeatureRegistry.POINTED_REDSTONE.get(), new PointedRedstoneConfiguration(0.5F, 0.7F, 0.5F, 0.5F), EnvironmentScanPlacement.scanningFor(Direction.UP, BlockPredicate.solid(), BlockPredicate.ONLY_IN_AIR_PREDICATE, 12), RandomOffsetPlacement.vertical(ConstantInt.of(-1))))));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> LARGE_POINTED_REDSTONE_NETHER = ConfiguredFeatureRegistry.register("large_pointed_redstone_nether", FeatureRegistry.LARGE_POINTED_REDSTONE.get(), new LargePointedRedstoneConfiguration(30, UniformInt.of(1, 6), UniformFloat.of(0.4F, 2.0F), 0.33F, UniformFloat.of(0.3F, 0.9F), UniformFloat.of(0.4F, 1.0F), UniformFloat.of(0.0F, 0.3F), 4, 0.6F));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> POINTED_REDSTONE_CLUSTER_NETHER = ConfiguredFeatureRegistry.register("pointed_redstone_cluster_nether", FeatureRegistry.POINTED_REDSTONE_CLUSTER.get(), new PointedRedstoneClusterConfiguration(12, UniformInt.of(3, 6), UniformInt.of(2, 8), 1, 3, UniformInt.of(2, 4), UniformFloat.of(0.3F, 0.7F), ClampedNormalFloat.of(0.0F, 0.0F, 0.0F, 0.0F), 0.1F, 3, 8));

    public static final Holder<ConfiguredFeature<NetherForestVegetationConfig, ?>> MYCOTOXIC_NYLIUM_BONEMEAL = ConfiguredFeatureRegistry.register("mycotoxic_nylium_bonemeal", Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(getMycotoxicBoneMeals(), 3, 1));
    public static final Holder<ConfiguredFeature<NetherForestVegetationConfig, ?>> GLISTERING_NYLIUM_BONEMEAL = ConfiguredFeatureRegistry.register("glistering_nylium_bonemeal", Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(glisteringWeights, 3, 1));
    public static final Holder<ConfiguredFeature<NetherForestVegetationConfig, ?>> COBALT_NYLIUM_BONEMEAL = ConfiguredFeatureRegistry.register("cobalt_nylium_bonemeal", Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(cobaltWeights, 3, 1));
    public static final Holder<ConfiguredFeature<NetherForestVegetationConfig, ?>> BRIMSPROUT_NYLIUM_BONEMEAL = ConfiguredFeatureRegistry.register("brimsprout_nylium_bonemeal", Feature.NETHER_FOREST_VEGETATION, new NetherForestVegetationConfig(brimsproutWeights, 3, 1));

    private static RandomPatchConfiguration grassPatch(BlockStateProvider stateProvider, int i) {
        return FeatureUtils.simpleRandomPatchConfiguration(i, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider)));
    }
}
