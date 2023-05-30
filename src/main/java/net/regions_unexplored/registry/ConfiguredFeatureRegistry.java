package net.regions_unexplored.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.data.worldgen.features.*;

public class ConfiguredFeatureRegistry {
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuAquaticFeatures.bootstrap(context);
        RuCaveFeatures.bootstrap(context);
        RuMiscOverworldFeatures.bootstrap(context);
        RuNetherFeatures.bootstrap(context);
        RuTreeFeatures.bootstrap(context);
        RuVegetationFeatures.bootstrap(context);
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(RegionsUnexploredMod.MOD_ID, name));
    }
}
