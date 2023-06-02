package net.regions_unexplored.data.worldgen.features;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.regions_unexplored.registry.ConfiguredFeatureRegistry;

public class RuMiscOverworldFeatures {
    //-----------------------KEYS-----------------------//
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOODS_ROCK = ConfiguredFeatureRegistry.createKey("redwoods_rock");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        //---------------------FEATURES---------------------//
        register(context, REDWOODS_ROCK, Feature.FOREST_ROCK, new BlockStateConfiguration(Blocks.MOSSY_COBBLESTONE.defaultBlockState()));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
