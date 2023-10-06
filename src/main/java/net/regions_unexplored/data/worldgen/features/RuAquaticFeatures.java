package net.regions_unexplored.data.worldgen.features;

import com.mojang.datafixers.kinds.IdF;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.registry.ConfiguredFeatureRegistry;
import net.regions_unexplored.registry.FeatureRegistry;
import net.regions_unexplored.world.level.feature.configuration.HyacinthStockConfiguration;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;
import net.regions_unexplored.world.level.feature.configuration.SeaRockConfiguration;

public class RuAquaticFeatures {
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> FEN_CATTAIL = ConfiguredFeatureRegistry.register("fen_cattail", FeatureRegistry.FEN_CATTAIL.get());
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> WATER_CATTAIL = ConfiguredFeatureRegistry.register("water_cattail", FeatureRegistry.WATER_CATTAIL.get());
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> TALL_HYACINTH_STOCK = ConfiguredFeatureRegistry.register("tall_hyacinth_stock", FeatureRegistry.TALL_HYACINTH_STOCK.get(), new HyacinthStockConfiguration(BlockStateProvider.simple(RuBlocks.TALL_HYACINTH_STOCK.get()), 1, 14));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> HYACINTH_PLANTS = ConfiguredFeatureRegistry.register("hyacinth_plants", FeatureRegistry.HYACINTH_PLANTS.get(), new ProbabilityFeatureConfiguration(0.1F));
    public static final Holder<ConfiguredFeature<MultifaceGrowthConfiguration, ?>> HYACINTH_FLOWERS = ConfiguredFeatureRegistry.register("hyacinth_flowers", Feature.MULTIFACE_GROWTH, new MultifaceGrowthConfiguration((MultifaceBlock)RuBlocks.HYACINTH_FLOWERS.get(), 20, true, true, true, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS)));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> HYACINTH_ROCKS = ConfiguredFeatureRegistry.register("hyacinth_rocks", FeatureRegistry.OCEAN_ROCK.get(), new SeaRockConfiguration(Blocks.STONE.defaultBlockState(), RuBlocks.MOSSY_STONE.get().defaultBlockState()));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> MOSSY_SEA_ROCKS = ConfiguredFeatureRegistry.register("mossy_sea_rocks", FeatureRegistry.ROCK_PILLAR.get());
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> BLUE_MAGNOLIA_FLOWERS_AQUATIC = ConfiguredFeatureRegistry.register("blue_magnolia_flowers_aquatic", FeatureRegistry.AIR_MULTIFACE_GROWTH.get(), new MultifaceGrowthConfiguration((MultifaceBlock)RuBlocks.BLUE_MAGNOLIA_FLOWERS.get(), 20, true, true, true, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, RuBlocks.STONE_GRASS_BLOCK.get())));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> PINK_MAGNOLIA_FLOWERS_AQUATIC = ConfiguredFeatureRegistry.register("pink_magnolia_flowers_aquatic", FeatureRegistry.AIR_MULTIFACE_GROWTH.get(), new MultifaceGrowthConfiguration((MultifaceBlock)RuBlocks.PINK_MAGNOLIA_FLOWERS.get(), 20, true, true, true, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, RuBlocks.STONE_GRASS_BLOCK.get())));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> WHITE_MAGNOLIA_FLOWERS_AQUATIC = ConfiguredFeatureRegistry.register("white_magnolia_flowers_aquatic", FeatureRegistry.AIR_MULTIFACE_GROWTH.get(), new MultifaceGrowthConfiguration((MultifaceBlock)RuBlocks.WHITE_MAGNOLIA_FLOWERS.get(), 20, true, true, true, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.STONE, RuBlocks.STONE_GRASS_BLOCK.get())));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> JUNGLE_TREE_AQUATIC = ConfiguredFeatureRegistry.register("jungle_tree_aquatic", FeatureRegistry.SAKURA_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(Blocks.JUNGLE_LOG.defaultBlockState()), BlockStateProvider.simple(Blocks.JUNGLE_LEAVES.defaultBlockState()), BlockStateProvider.simple(RuBlocks.JUNGLE_BRANCH.get().defaultBlockState()), 1, 4));
    public static final Holder<ConfiguredFeature<FeatureConfiguration, ?>> PALM_TREE_AQUATIC = ConfiguredFeatureRegistry.register("palm_tree_aquatic", FeatureRegistry.PALM_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.PALM_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.PALM_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.PALM_BEARD.get().defaultBlockState()), 8, 4));
    public static final Holder<ConfiguredFeature<RandomPatchConfiguration, ?>> ELEPHANT_EAR_AQUATIC = ConfiguredFeatureRegistry.register("elephant_ear_aquatic", Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.ELEPHANT_EAR.get().defaultBlockState()), 32));

    private static RandomPatchConfiguration grassPatch(BlockStateProvider stateProvider, int i) {
        return FeatureUtils.simpleRandomPatchConfiguration(i, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider)));
    }
}
