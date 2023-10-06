package net.regions_unexplored.registry;

import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.RegionsUnexploredMod;

public class ConfiguredFeatureRegistry {
    public static Holder<ConfiguredFeature<NoneFeatureConfiguration, ?>> register(String key, Feature<NoneFeatureConfiguration> feature) {
        return register(key, feature, FeatureConfiguration.NONE);
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> Holder<ConfiguredFeature<FC, ?>> register(String key, F feature, FC featureConfig) {
        return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, RegionsUnexploredMod.MOD_ID+":"+key, new ConfiguredFeature<>(feature, featureConfig));
    }
}