package net.regions_unexplored.data.worldgen.placement;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.regions_unexplored.data.worldgen.features.RuVegetationFeatures;
import net.regions_unexplored.registry.PlacedFeatureRegistry;

import java.util.List;

public class RuVegetationPlacements {
    //-----------------------KEYS-----------------------//
    //GRASS
    public static final ResourceKey<PlacedFeature> MEDIUM_GRASS = PlacedFeatureRegistry.createKey("medium_grass");
    public static final ResourceKey<PlacedFeature> REDWOODS_VEGETATION = PlacedFeatureRegistry.createKey("redwoods_vegetation");
    //FLOWERS
    public static final ResourceKey<PlacedFeature> ALPHA_DANDELION = PlacedFeatureRegistry.createKey("alpha_dandelion");
    public static final ResourceKey<PlacedFeature> ALPHA_ROSE = PlacedFeatureRegistry.createKey("alpha_rose");
    //MULTIFACE FLOWERS
    public static final ResourceKey<PlacedFeature> RED_SAKURA_FLOWERS = PlacedFeatureRegistry.createKey("red_sakura_flowers");
    public static final ResourceKey<PlacedFeature> PINK_SAKURA_FLOWERS = PlacedFeatureRegistry.createKey("pink_sakura_flowers");
    public static final ResourceKey<PlacedFeature> WHITE_SAKURA_FLOWERS = PlacedFeatureRegistry.createKey("white_sakura_flowers");
    //SHRUBS
    public static final ResourceKey<PlacedFeature> ASHEN_SHRUB = PlacedFeatureRegistry.createKey("ashen_shrub");
    public static final ResourceKey<PlacedFeature> ACACIA_SHRUB = PlacedFeatureRegistry.createKey("acacia_shrub");
    public static final ResourceKey<PlacedFeature> BAOBAB_SHRUB = PlacedFeatureRegistry.createKey("baobab_shrub");
    public static final ResourceKey<PlacedFeature> BIRCH_SHRUB = PlacedFeatureRegistry.createKey("birch_shrub");
    public static final ResourceKey<PlacedFeature> BLACKWOOD_SHRUB = PlacedFeatureRegistry.createKey("blackwood_shrub");
    public static final ResourceKey<PlacedFeature> SAKURA_SHRUB = PlacedFeatureRegistry.createKey("sakura_shrub");
    public static final ResourceKey<PlacedFeature> RED_SAKURA_SHRUB = PlacedFeatureRegistry.createKey("red_sakura_shrub");
    public static final ResourceKey<PlacedFeature> PINK_SAKURA_SHRUB = PlacedFeatureRegistry.createKey("pink_sakura_shrub");
    public static final ResourceKey<PlacedFeature> WHITE_SAKURA_SHRUB = PlacedFeatureRegistry.createKey("white_sakura_shrub");
    public static final ResourceKey<PlacedFeature> CYPRESS_SHRUB = PlacedFeatureRegistry.createKey("cypress_shrub");
    public static final ResourceKey<PlacedFeature> DARK_OAK_SHRUB = PlacedFeatureRegistry.createKey("dark_oak_shrub");
    public static final ResourceKey<PlacedFeature> DEAD_SHRUB = PlacedFeatureRegistry.createKey("dead_shrub");
    public static final ResourceKey<PlacedFeature> DEAD_PINE_SHRUB = PlacedFeatureRegistry.createKey("dead_pine_shrub");
    public static final ResourceKey<PlacedFeature> EUCALYPTUS_SHRUB = PlacedFeatureRegistry.createKey("eucalyptus_shrub");
    public static final ResourceKey<PlacedFeature> FLOWERING_SHRUB = PlacedFeatureRegistry.createKey("flowering_shrub");
    public static final ResourceKey<PlacedFeature> JOSHUA_SHRUB = PlacedFeatureRegistry.createKey("joshua_shrub");
    public static final ResourceKey<PlacedFeature> JUNGLE_SHRUB = PlacedFeatureRegistry.createKey("jungle_shrub");
    public static final ResourceKey<PlacedFeature> LARCH_SHRUB = PlacedFeatureRegistry.createKey("larch_shrub");
    public static final ResourceKey<PlacedFeature> GOLDEN_LARCH_SHRUB = PlacedFeatureRegistry.createKey("golden_larch_shrub");
    public static final ResourceKey<PlacedFeature> MANGROVE_SHRUB = PlacedFeatureRegistry.createKey("mangrove_shrub");
    public static final ResourceKey<PlacedFeature> MAPLE_SHRUB = PlacedFeatureRegistry.createKey("maple_shrub");
    public static final ResourceKey<PlacedFeature> RED_MAPLE_SHRUB = PlacedFeatureRegistry.createKey("red_maple_shrub");
    public static final ResourceKey<PlacedFeature> ORANGE_MAPLE_SHRUB = PlacedFeatureRegistry.createKey("orange_maple_shrub");
    public static final ResourceKey<PlacedFeature> MAUVE_SHRUB = PlacedFeatureRegistry.createKey("mauve_shrub");
    public static final ResourceKey<PlacedFeature> OAK_SHRUB = PlacedFeatureRegistry.createKey("oak_shrub");
    public static final ResourceKey<PlacedFeature> PALM_SHRUB = PlacedFeatureRegistry.createKey("palm_shrub");
    public static final ResourceKey<PlacedFeature> PINE_SHRUB = PlacedFeatureRegistry.createKey("pine_shrub");
    public static final ResourceKey<PlacedFeature> REDWOOD_SHRUB = PlacedFeatureRegistry.createKey("redwood_shrub");
    public static final ResourceKey<PlacedFeature> SILVER_BIRCH_SHRUB = PlacedFeatureRegistry.createKey("silver_birch_shrub");
    public static final ResourceKey<PlacedFeature> SPRUCE_SHRUB = PlacedFeatureRegistry.createKey("spruce_shrub");
    public static final ResourceKey<PlacedFeature> WILLOW_SHRUB = PlacedFeatureRegistry.createKey("willow_shrub");
    //mixes
    public static final ResourceKey<PlacedFeature> AUTUMNAL_SHRUB_MIX = PlacedFeatureRegistry.createKey("autumnal_shrub_mix");
    public static final ResourceKey<PlacedFeature> BIRCH_SHRUB_MIX = PlacedFeatureRegistry.createKey("birch_shrub_mix");
    public static final ResourceKey<PlacedFeature> BLACKWOOD_DARK_OAK_SHRUB_MIX = PlacedFeatureRegistry.createKey("blackwood_dark_oak_shrub_mix");
    public static final ResourceKey<PlacedFeature> SAKURA_SHRUB_MIX = PlacedFeatureRegistry.createKey("sakura_shrub_mix");
    public static final ResourceKey<PlacedFeature> DEAD_SHRUB_MIX = PlacedFeatureRegistry.createKey("dead_shrub_mix");
    public static final ResourceKey<PlacedFeature> LARCH_SHRUB_MIX = PlacedFeatureRegistry.createKey("larch_shrub_mix");
    public static final ResourceKey<PlacedFeature> GOLDEN_LARCH_SHRUB_MIX = PlacedFeatureRegistry.createKey("golden_larch_shrub_mix");
    public static final ResourceKey<PlacedFeature> MAPLE_SHRUB_MIX = PlacedFeatureRegistry.createKey("maple_shrub_mix");
    public static final ResourceKey<PlacedFeature> PALM_MANGROVE_SHRUB_MIX = PlacedFeatureRegistry.createKey("palm_mangrove_shrub_mix");
    public static final ResourceKey<PlacedFeature> PINE_SPRUCE_SHRUB_MIX = PlacedFeatureRegistry.createKey("pine_spruce_shrub_mix");
    public static final ResourceKey<PlacedFeature> PINE_DEAD_SHRUB_MIX = PlacedFeatureRegistry.createKey("pine_dead_shrub_mix");
    public static final ResourceKey<PlacedFeature> WILLOW_CYPRESS_SHRUB_MIX = PlacedFeatureRegistry.createKey("willow_cypress_shrub_mix");



    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> featureGetter = context.lookup(Registries.CONFIGURED_FEATURE);

        //---------------------FEATURES---------------------//
        //GRASS
        final Holder<ConfiguredFeature<?, ?>> MEDIUM_GRASS = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_MEDIUM_GRASS);
        final Holder<ConfiguredFeature<?, ?>> REDWOODS_VEGETATION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_REDWOODS_VEGETATION);
        //FLOWERS
        final Holder<ConfiguredFeature<?, ?>> ALPHA_DANDELION = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_ALPHA_DANDELION);
        final Holder<ConfiguredFeature<?, ?>> ALPHA_ROSE = featureGetter.getOrThrow(RuVegetationFeatures.PATCH_ALPHA_ROSE);
        //MULTIFACE FLOWERS
        final Holder<ConfiguredFeature<?, ?>> RED_SAKURA_FLOWERS = featureGetter.getOrThrow(RuVegetationFeatures.RED_SAKURA_FLOWERS);
        final Holder<ConfiguredFeature<?, ?>> PINK_SAKURA_FLOWERS = featureGetter.getOrThrow(RuVegetationFeatures.PINK_SAKURA_FLOWERS);
        final Holder<ConfiguredFeature<?, ?>> WHITE_SAKURA_FLOWERS = featureGetter.getOrThrow(RuVegetationFeatures.WHITE_SAKURA_FLOWERS);
        //SHRUBS
        final Holder<ConfiguredFeature<?, ?>> ASHEN_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.ASHEN_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> ACACIA_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.ACACIA_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> BAOBAB_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.BAOBAB_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> BIRCH_SHRUB =  featureGetter.getOrThrow(RuVegetationFeatures.BIRCH_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> BLACKWOOD_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.BLACKWOOD_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> SAKURA_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.SAKURA_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> RED_SAKURA_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.RED_SAKURA_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> PINK_SAKURA_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.PINK_SAKURA_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> WHITE_SAKURA_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.WHITE_SAKURA_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> CYPRESS_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.CYPRESS_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> DARK_OAK_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.DARK_OAK_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> DEAD_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.DEAD_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> DEAD_PINE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.DEAD_PINE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> EUCALYPTUS_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.EUCALYPTUS_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> FLOWERING_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.FLOWERING_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> JOSHUA_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.JOSHUA_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> JUNGLE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.JUNGLE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> LARCH_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.LARCH_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> GOLDEN_LARCH_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.GOLDEN_LARCH_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> MANGROVE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.MANGROVE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> MAPLE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.MAPLE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> RED_MAPLE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.RED_MAPLE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> ORANGE_MAPLE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.ORANGE_MAPLE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> MAUVE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.MAUVE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> OAK_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.OAK_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> PALM_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.PALM_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> PINE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.PINE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> REDWOOD_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.REDWOOD_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> SILVER_BIRCH_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.SILVER_BIRCH_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> SPRUCE_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.SPRUCE_SHRUB);
        final Holder<ConfiguredFeature<?, ?>> WILLOW_SHRUB = featureGetter.getOrThrow(RuVegetationFeatures.WILLOW_SHRUB);
        //mixes
        final Holder<ConfiguredFeature<?, ?>> AUTUMNAL_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.AUTUMNAL_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> BIRCH_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.BIRCH_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> BLACKWOOD_DARK_OAK_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.BLACKWOOD_DARK_OAK_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> SAKURA_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.SAKURA_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> DEAD_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.DEAD_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> LARCH_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.LARCH_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> GOLDEN_LARCH_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.GOLDEN_LARCH_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> MAPLE_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.MAPLE_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> PALM_MANGROVE_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.PALM_MANGROVE_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> PINE_SPRUCE_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.PINE_SPRUCE_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> PINE_DEAD_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.PINE_SPRUCE_SHRUB_MIX);
        final Holder<ConfiguredFeature<?, ?>> WILLOW_CYPRESS_SHRUB_MIX = featureGetter.getOrThrow(RuVegetationFeatures.WILLOW_CYPRESS_SHRUB_MIX);


        //--------------------PLACEMENTS--------------------//
        //GRASS
        register(context, RuVegetationPlacements.MEDIUM_GRASS, MEDIUM_GRASS, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 7), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.REDWOODS_VEGETATION, REDWOODS_VEGETATION, List.of(NoiseThresholdCountPlacement.of(-0.8D, 5, 14), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        //FLOWERS
        register(context, RuVegetationPlacements.ALPHA_DANDELION, ALPHA_DANDELION, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        register(context, RuVegetationPlacements.ALPHA_ROSE, ALPHA_ROSE, List.of(RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome()));
        //MULTIFACE FLOWERS
        register(context, RuVegetationPlacements.RED_SAKURA_FLOWERS, RED_SAKURA_FLOWERS, CountPlacement.of(15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
        register(context, RuVegetationPlacements.PINK_SAKURA_FLOWERS, PINK_SAKURA_FLOWERS, CountPlacement.of(15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
        register(context, RuVegetationPlacements.WHITE_SAKURA_FLOWERS, WHITE_SAKURA_FLOWERS, CountPlacement.of(15), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_OCEAN_FLOOR, BiomeFilter.biome());
        //SHRUBS
        register(context, RuVegetationPlacements.ASHEN_SHRUB, ASHEN_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.ACACIA_SHRUB, ACACIA_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.BAOBAB_SHRUB, BAOBAB_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.BIRCH_SHRUB, BIRCH_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.BLACKWOOD_SHRUB, BLACKWOOD_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.SAKURA_SHRUB, SAKURA_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.RED_SAKURA_SHRUB, RED_SAKURA_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PINK_SAKURA_SHRUB, PINK_SAKURA_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.WHITE_SAKURA_SHRUB, WHITE_SAKURA_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.CYPRESS_SHRUB, CYPRESS_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.DARK_OAK_SHRUB, DARK_OAK_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.DEAD_SHRUB, DEAD_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.DEAD_PINE_SHRUB, DEAD_PINE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.EUCALYPTUS_SHRUB, EUCALYPTUS_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.FLOWERING_SHRUB, FLOWERING_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.JOSHUA_SHRUB, JOSHUA_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.JUNGLE_SHRUB, JUNGLE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.LARCH_SHRUB, LARCH_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.GOLDEN_LARCH_SHRUB, GOLDEN_LARCH_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.MANGROVE_SHRUB, MANGROVE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.MAPLE_SHRUB, MAPLE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.RED_MAPLE_SHRUB, RED_MAPLE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.ORANGE_MAPLE_SHRUB, ORANGE_MAPLE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.MAUVE_SHRUB, MAUVE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.OAK_SHRUB, OAK_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PALM_SHRUB, PALM_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PINE_SHRUB, PINE_SHRUB, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.REDWOOD_SHRUB, REDWOOD_SHRUB, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.SILVER_BIRCH_SHRUB, SILVER_BIRCH_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.SPRUCE_SHRUB, SPRUCE_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.WILLOW_SHRUB, WILLOW_SHRUB, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        //mixes
        register(context, RuVegetationPlacements.AUTUMNAL_SHRUB_MIX, AUTUMNAL_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.BIRCH_SHRUB_MIX, BIRCH_SHRUB_MIX, CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.BLACKWOOD_DARK_OAK_SHRUB_MIX, BLACKWOOD_DARK_OAK_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.SAKURA_SHRUB_MIX, SAKURA_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.DEAD_SHRUB_MIX, DEAD_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.LARCH_SHRUB_MIX, LARCH_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.GOLDEN_LARCH_SHRUB_MIX, GOLDEN_LARCH_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.MAPLE_SHRUB_MIX, MAPLE_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PALM_MANGROVE_SHRUB_MIX, PALM_MANGROVE_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PINE_SPRUCE_SHRUB_MIX, PINE_SPRUCE_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.PINE_DEAD_SHRUB_MIX, PINE_DEAD_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
        register(context, RuVegetationPlacements.WILLOW_CYPRESS_SHRUB_MIX, WILLOW_CYPRESS_SHRUB_MIX, CountPlacement.of(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING), BiomeFilter.biome());
    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, PlacementModifier... placement) {
        register(context, key, feature, List.of(placement));
    }

    protected static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placement) {
        context.register(key, new PlacedFeature(feature, placement));
    }
}
