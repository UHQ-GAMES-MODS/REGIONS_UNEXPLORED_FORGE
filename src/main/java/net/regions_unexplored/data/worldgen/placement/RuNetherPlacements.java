package net.regions_unexplored.data.worldgen.placement;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.worldgen.features.RuNetherFeatures;
import net.regions_unexplored.data.worldgen.features.RuVegetationFeatures;
import net.regions_unexplored.registry.PlacedFeatureRegistry;

import java.util.List;

public class RuNetherPlacements {
    public static final ResourceKey<PlacedFeature> BRIMSPROUT = PlacedFeatureRegistry.createKey("brimsprout");
    public static final ResourceKey<PlacedFeature> BRIM_FLAMES = PlacedFeatureRegistry.createKey("brim_flames");
    public static final ResourceKey<PlacedFeature> DORCEL = PlacedFeatureRegistry.createKey("dorcel");
    public static final ResourceKey<PlacedFeature> BRIMWOOD_SHRUB = PlacedFeatureRegistry.createKey("brimwood_shrub");

    public static final ResourceKey<PlacedFeature> GLISTERING_MEADOW_ROCK = PlacedFeatureRegistry.createKey("glistering_meadow_rock");
    public static final ResourceKey<PlacedFeature> GLISTERING_MEADOW_IVY = PlacedFeatureRegistry.createKey("glistering_meadow_ivy");
    public static final ResourceKey<PlacedFeature> GLISTERING_MEADOW_GRASS = PlacedFeatureRegistry.createKey("glistering_meadow_grass");
    public static final ResourceKey<PlacedFeature> GLISTERING_MEADOW_SPIRE = PlacedFeatureRegistry.createKey("glistering_meadow_spire");
    public static final ResourceKey<PlacedFeature> GLISTERING_MEADOW_BULB = PlacedFeatureRegistry.createKey("glistering_meadow_bulb");

    public static final ResourceKey<PlacedFeature> HANGING_EARLIGHT = PlacedFeatureRegistry.createKey("hanging_earlight");
    public static final ResourceKey<PlacedFeature> COBALT_ROOTS = PlacedFeatureRegistry.createKey("cobalt_roots");
    public static final ResourceKey<PlacedFeature> BLACKSTONE_CLUSTER = PlacedFeatureRegistry.createKey("blackstone_cluster");
    public static final ResourceKey<PlacedFeature> COBALT_EARLIGHT = PlacedFeatureRegistry.createKey("cobalt_earlight");
    public static final ResourceKey<PlacedFeature> TALL_COBALT_EARLIGHT = PlacedFeatureRegistry.createKey("tall_cobalt_earlight");
    public static final ResourceKey<PlacedFeature> OBSIDIAN_SPIRE = PlacedFeatureRegistry.createKey("obsidian_spire");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> featureGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        final Holder<ConfiguredFeature<?, ?>> BRIMSPROUT = featureGetter.getOrThrow(RuNetherFeatures.PATCH_BRIMSPROUT);
        final Holder<ConfiguredFeature<?, ?>> BRIM_FLAMES = featureGetter.getOrThrow(RuNetherFeatures.PATCH_BRIM_FLAMES);
        final Holder<ConfiguredFeature<?, ?>> DORCEL = featureGetter.getOrThrow(RuNetherFeatures.DORCEL);
        final Holder<ConfiguredFeature<?, ?>> BRIMWOOD_SHRUB = featureGetter.getOrThrow(RuNetherFeatures.BRIMWOOD_SHRUB);

        final Holder<ConfiguredFeature<?, ?>> GLISTERING_MEADOW_ROCK = featureGetter.getOrThrow(RuNetherFeatures.NETHER_ROCK);
        final Holder<ConfiguredFeature<?, ?>> GLISTERING_MEADOW_IVY = featureGetter.getOrThrow(RuNetherFeatures.PATCH_GLISTERING_IVY);
        final Holder<ConfiguredFeature<?, ?>> GLISTERING_MEADOW_GRASS = featureGetter.getOrThrow(RuNetherFeatures.PATCH_GLISTERING_SPROUT);
        final Holder<ConfiguredFeature<?, ?>> GLISTERING_MEADOW_SPIRE = featureGetter.getOrThrow(RuNetherFeatures.PATCH_GLISTER_SPIRE);
        final Holder<ConfiguredFeature<?, ?>> GLISTERING_MEADOW_BULB = featureGetter.getOrThrow(RuNetherFeatures.PATCH_GLISTER_BULB);

        final Holder<ConfiguredFeature<?, ?>> HANGING_EARLIGHT = featureGetter.getOrThrow(RuNetherFeatures.PATCH_HANGING_EARLIGHT);
        final Holder<ConfiguredFeature<?, ?>> COBALT_ROOTS = featureGetter.getOrThrow(RuNetherFeatures.PATCH_COBALT_ROOTS);
        final Holder<ConfiguredFeature<?, ?>> BLACKSTONE_CLUSTER = featureGetter.getOrThrow(RuNetherFeatures.PATCH_BLACKSTONE_CLUSTER);
        final Holder<ConfiguredFeature<?, ?>> COBALT_EARLIGHT = featureGetter.getOrThrow(RuNetherFeatures.PATCH_COBALT_EARLIGHT);
        final Holder<ConfiguredFeature<?, ?>> TALL_COBALT_EARLIGHT = featureGetter.getOrThrow(RuNetherFeatures.TALL_COBALT_EARLIGHT);
        final Holder<ConfiguredFeature<?, ?>> OBSIDIAN_SPIRE = featureGetter.getOrThrow(RuNetherFeatures.OBSIDIAN_SPIRE);

        register(context, RuNetherPlacements.BRIMSPROUT, BRIMSPROUT, List.of(CountOnEveryLayerPlacement.of(30), BiomeFilter.biome()));
        register(context, RuNetherPlacements.BRIM_FLAMES, BRIM_FLAMES, List.of(CountOnEveryLayerPlacement.of(5), PlacementUtils.filteredByBlockSurvival(RuBlocks.BRIMSPROUT.get()), BiomeFilter.biome()));
        register(context, RuNetherPlacements.DORCEL, DORCEL, List.of(CountOnEveryLayerPlacement.of(2), PlacementUtils.filteredByBlockSurvival(RuBlocks.BRIMSPROUT.get()), BiomeFilter.biome()));
        register(context, RuNetherPlacements.BRIMWOOD_SHRUB, BRIMWOOD_SHRUB, List.of(CountOnEveryLayerPlacement.of(1), PlacementUtils.filteredByBlockSurvival(RuBlocks.BRIMSPROUT.get()), BiomeFilter.biome()));

        register(context, RuNetherPlacements.GLISTERING_MEADOW_ROCK, GLISTERING_MEADOW_ROCK, CountOnEveryLayerPlacement.of(1), PlacementUtils.filteredByBlockSurvival(RuBlocks.GLISTERING_NYLIUM.get()), BiomeFilter.biome());
        register(context, RuNetherPlacements.GLISTERING_MEADOW_IVY, GLISTERING_MEADOW_IVY, CountPlacement.of(155), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
        register(context, RuNetherPlacements.GLISTERING_MEADOW_GRASS, GLISTERING_MEADOW_GRASS, List.of(CountOnEveryLayerPlacement.of(30), BiomeFilter.biome()));
        register(context, RuNetherPlacements.GLISTERING_MEADOW_SPIRE, GLISTERING_MEADOW_SPIRE, List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome()));
        register(context, RuNetherPlacements.GLISTERING_MEADOW_BULB, GLISTERING_MEADOW_BULB, List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome()));

        register(context, RuNetherPlacements.HANGING_EARLIGHT, HANGING_EARLIGHT, CountPlacement.of(225), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());
        register(context, RuNetherPlacements.COBALT_ROOTS, COBALT_ROOTS, List.of(CountOnEveryLayerPlacement.of(8), BiomeFilter.biome()));
        register(context, RuNetherPlacements.BLACKSTONE_CLUSTER, BLACKSTONE_CLUSTER, List.of(CountOnEveryLayerPlacement.of(4), PlacementUtils.filteredByBlockSurvival(RuBlocks.STONE_BUD.get()), BiomeFilter.biome()));
        register(context, RuNetherPlacements.COBALT_EARLIGHT, COBALT_EARLIGHT, List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome()));
        register(context, RuNetherPlacements.TALL_COBALT_EARLIGHT, TALL_COBALT_EARLIGHT, List.of(CountOnEveryLayerPlacement.of(3), BiomeFilter.biome()));
        register(context, RuNetherPlacements.OBSIDIAN_SPIRE, OBSIDIAN_SPIRE, CountPlacement.of(155), InSquarePlacement.spread(), PlacementUtils.FULL_RANGE, BiomeFilter.biome());

    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, PlacementModifier... placement) {
        register(context, key, feature, List.of(placement));
    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placement) {
        context.register(key, new PlacedFeature(feature, placement));
    }
}
