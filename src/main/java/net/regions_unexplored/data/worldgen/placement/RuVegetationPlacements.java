package net.regions_unexplored.data.worldgen.placement;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.regions_unexplored.data.worldgen.features.RuVegetationFeatures;
import net.regions_unexplored.registry.PlacedFeatureRegistry;

import java.util.List;

public class RuVegetationPlacements {
    //TODO:Build Class
    //-----------------------KEYS-----------------------//
    public static final ResourceKey<PlacedFeature> ALPHA_DANDELION = PlacedFeatureRegistry.createKey("alpha_dandelion");
    public static final ResourceKey<PlacedFeature> ALPHA_ROSE = PlacedFeatureRegistry.createKey("alpha_rose");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> featureGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        //---------------------FEATURES---------------------//
        final Holder<ConfiguredFeature<?, ?>> ALPHA_DANDELION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_ALPHA_DANDELION);
        final Holder<ConfiguredFeature<?, ?>> ALPHA_ROSE = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_ALPHA_ROSE);

        //--------------------PLACEMENTS--------------------//
        register(context, RuVegetationPlacements.ALPHA_DANDELION, ALPHA_DANDELION, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.ALPHA_ROSE, ALPHA_ROSE, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, PlacementModifier... placement) {
        register(context, key, feature, List.of(placement));
    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placement) {
        context.register(key, new PlacedFeature(feature, placement));
    }
}
