package net.regions_unexplored.data.worldgen.features;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.registry.ConfiguredFeatureRegistry;
import net.regions_unexplored.registry.FeatureRegistry;
import net.regions_unexplored.world.level.block.wood.AspenLogBlock;
import net.regions_unexplored.world.level.feature.configuration.FallenTreeConfiguration;

public class RuMiscOverworldFeatures {
    //-----------------------KEYS-----------------------//
    //ROCKS
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOODS_ROCK = ConfiguredFeatureRegistry.createKey("redwoods_rock");
    //FALLEN_TREES
    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_LARCH_TREE = ConfiguredFeatureRegistry.createKey("fallen_larch_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_MAPLE_TREE = ConfiguredFeatureRegistry.createKey("fallen_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_OAK_TREE = ConfiguredFeatureRegistry.createKey("fallen_oak_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_SILVER_BIRCH_TREE = ConfiguredFeatureRegistry.createKey("fallen_silver_birch_tree");
    //OTHER_FEATURES
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMOULDERING_DIRT = ConfiguredFeatureRegistry.createKey("smouldering_dirt");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEADOW_ROCK = ConfiguredFeatureRegistry.createKey("meadow_rock");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        //---------------------FEATURES---------------------//
        //ROCKS
        register(context, REDWOODS_ROCK, Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.MOSSY_COBBLESTONE.defaultBlockState()));
        //FALLEN_TREES
        register(context, FALLEN_LARCH_TREE, FeatureRegistry.FALLEN_BLOB_TREE.get(), new FallenTreeConfiguration(BlockStateProvider.simple(RuBlocks.LARCH_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.LARCH_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.GOLDEN_LARCH_LEAVES.get().defaultBlockState()), 5, 9, false));
        register(context, FALLEN_MAPLE_TREE, FeatureRegistry.FALLEN_BLOB_TREE.get(), new FallenTreeConfiguration(BlockStateProvider.simple(RuBlocks.MAPLE_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.MAPLE_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.MAPLE_LEAVES.get().defaultBlockState()), 4, 4, false));
        register(context, FALLEN_OAK_TREE, FeatureRegistry.FALLEN_BLOB_TREE.get(), new FallenTreeConfiguration(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), BlockStateProvider.simple(RuBlocks.DEAD_LEAVES.get().defaultBlockState()), 4, 4, true));
        register(context, FALLEN_SILVER_BIRCH_TREE, FeatureRegistry.FALLEN_BLOB_TREE.get(), new FallenTreeConfiguration(BlockStateProvider.simple(RuBlocks.SILVER_BIRCH_LOG.get().defaultBlockState().setValue(AspenLogBlock.IS_BASE, true)), BlockStateProvider.simple(RuBlocks.SILVER_BIRCH_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.SILVER_BIRCH_LEAVES.get().defaultBlockState()), 4, 3, false));
        //OTHER_FEATURES
        register(context, SMOULDERING_DIRT, FeatureRegistry.SMOULDERING_DIRT.get(), FeatureConfiguration.NONE);
        register(context, MEADOW_ROCK, FeatureRegistry.MEADOW_ROCK.get(), FeatureConfiguration.NONE);
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
