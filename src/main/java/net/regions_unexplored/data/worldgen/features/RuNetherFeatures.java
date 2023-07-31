package net.regions_unexplored.data.worldgen.features;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.registry.ConfiguredFeatureRegistry;
import net.regions_unexplored.registry.FeatureRegistry;

public class RuNetherFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BRIMSPROUT = ConfiguredFeatureRegistry.createKey("patch_brimsprout");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BRIM_FLAMES = ConfiguredFeatureRegistry.createKey("patch_brim_flames");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DORCEL = ConfiguredFeatureRegistry.createKey("dorcel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BRIMWOOD_SHRUB = ConfiguredFeatureRegistry.createKey("brimwood_shrub");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_ROCK = ConfiguredFeatureRegistry.createKey("nether_rock");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GLISTERING_IVY = ConfiguredFeatureRegistry.createKey("patch_glistering_ivy");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GLISTERING_SPROUT = ConfiguredFeatureRegistry.createKey("patch_glistering_sprout");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GLISTER_SPIRE = ConfiguredFeatureRegistry.createKey("patch_glister_spire");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GLISTER_BULB = ConfiguredFeatureRegistry.createKey("patch_glister_bulb");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_HANGING_EARLIGHT = ConfiguredFeatureRegistry.createKey("patch_hanging_earlight");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_COBALT_EARLIGHT = ConfiguredFeatureRegistry.createKey("patch_cobalt_earlight");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_COBALT_EARLIGHT = ConfiguredFeatureRegistry.createKey("tall_cobalt_earlight");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLACKSTONE_CLUSTER = ConfiguredFeatureRegistry.createKey("patch_blackstone_cluster");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_COBALT_ROOTS = ConfiguredFeatureRegistry.createKey("patch_cobalt_roots");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OBSIDIAN_SPIRE = ConfiguredFeatureRegistry.createKey("obsidian_spire");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, PATCH_BRIMSPROUT, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.BRIMSPROUT.get().defaultBlockState()), 32));
        register(context, PATCH_BRIM_FLAMES, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(Blocks.FIRE.defaultBlockState()), 12));
        register(context, DORCEL, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.DORCEL.get())));
        register(context, BRIMWOOD_SHRUB, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.BRIMWOOD_SHRUB.get())));

        register(context, NETHER_ROCK, FeatureRegistry.NETHER_ROCK.get(), FeatureConfiguration.NONE);
        register(context, PATCH_GLISTERING_IVY, FeatureRegistry.GLISTERING_IVY.get(), FeatureConfiguration.NONE);
        register(context, PATCH_GLISTERING_SPROUT, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.GLISTERING_SPROUT.get().defaultBlockState()), 32));
        register(context, PATCH_GLISTER_SPIRE, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.GLISTER_SPIRE.get().defaultBlockState()), 16));
        register(context, PATCH_GLISTER_BULB, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.GLISTER_BULB.get().defaultBlockState())));

        register(context, PATCH_HANGING_EARLIGHT, FeatureRegistry.HANGING_EARLIGHT.get(), FeatureConfiguration.NONE);
        register(context, PATCH_BLACKSTONE_CLUSTER, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.BLACKSTONE_CLUSTER.get().defaultBlockState()), 16));
        register(context, PATCH_COBALT_EARLIGHT, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.COBALT_EARLIGHT.get().defaultBlockState()), 6));
        register(context, TALL_COBALT_EARLIGHT, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.TALL_COBALT_EARLIGHT.get().defaultBlockState())));
        register(context, PATCH_COBALT_ROOTS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.COBALT_ROOTS.get().defaultBlockState()), 32));
        register(context, OBSIDIAN_SPIRE, FeatureRegistry.OBSIDIAN_SPIRE.get(), FeatureConfiguration.NONE);
    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider stateProvider, int i) {
        return FeatureUtils.simpleRandomPatchConfiguration(i, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
