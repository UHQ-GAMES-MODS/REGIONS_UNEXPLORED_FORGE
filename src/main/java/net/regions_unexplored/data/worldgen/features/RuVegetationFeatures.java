package net.regions_unexplored.data.worldgen.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MultifaceBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.NoiseProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.registry.ConfiguredFeatureRegistry;
import net.regions_unexplored.registry.FeatureRegistry;
import net.regions_unexplored.registry.PlacedFeatureRegistry;
import net.regions_unexplored.world.features.treedecorators.BlackwoodBioshroom;
import net.regions_unexplored.world.level.block.plant.flower.GroundCoverBlock;
import net.regions_unexplored.world.level.block.plant.food.SalmonBerryBushBlock;
import net.regions_unexplored.world.level.block.plant.grass.AshenGrassBlock;
import net.regions_unexplored.world.level.feature.configuration.ShrubConfiguration;

import java.util.List;

public class RuVegetationFeatures {
    //TODO:Build Class
    //-----------------------KEYS-----------------------//
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKWOOD_BIOSHROOMS = ConfiguredFeatureRegistry.createKey("blackwood_bioshrooms");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKWOOD_DECORATION = ConfiguredFeatureRegistry.createKey("blackwood_decoration");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUPINE_VEGETATION = ConfiguredFeatureRegistry.createKey("lupine_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_MEADOW_VEGETATION = ConfiguredFeatureRegistry.createKey("patch_meadow_vegetation");
    //GRASS
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_GRASS = ConfiguredFeatureRegistry.createKey("patch_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_MEDIUM_GRASS = ConfiguredFeatureRegistry.createKey("patch_medium_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SEEDED_GRASS = ConfiguredFeatureRegistry.createKey("patch_seeded_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WINDSWEPT_GRASS = ConfiguredFeatureRegistry.createKey("patch_windswept_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_STONE_BUD = ConfiguredFeatureRegistry.createKey("patch_stone_bud");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_ASHEN_GRASS = ConfiguredFeatureRegistry.createKey("patch_ashen_grass");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_REDWOODS_VEGETATION = ConfiguredFeatureRegistry.createKey("patch_redwoods_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BLACKWOOD_VEGETATION = ConfiguredFeatureRegistry.createKey("patch_blackwood_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BAYOU_VEGETATION = ConfiguredFeatureRegistry.createKey("patch_bayou_vegetation");
    //FLOWERS
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SMALL_FLOWERS = ConfiguredFeatureRegistry.createKey("patch_small_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_TALL_FLOWERS = ConfiguredFeatureRegistry.createKey("patch_tall_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_ALPHA_DANDELION = ConfiguredFeatureRegistry.createKey("patch_alpha_dandelion");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_ALPHA_ROSE = ConfiguredFeatureRegistry.createKey("patch_alpha_rose");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WHITE_TRILLIUM = ConfiguredFeatureRegistry.createKey("patch_white_trillium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_WILTING_TRILLIUM = ConfiguredFeatureRegistry.createKey("patch_wilting_trillium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TASSEL = ConfiguredFeatureRegistry.createKey("tassel");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TSUBAKI = ConfiguredFeatureRegistry.createKey("tsubaki");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEADOW_SAGE = ConfiguredFeatureRegistry.createKey("meadow_sage");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_ORANGE_CONEFLOWER = ConfiguredFeatureRegistry.createKey("patch_orange_coneflower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_PURPLE_CONEFLOWER = ConfiguredFeatureRegistry.createKey("patch_purple_coneflower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SAKURA_FLOWERS = ConfiguredFeatureRegistry.createKey("patch_sakura_flowers");
    //MULTIFACE FLOWERS
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_SAKURA_FLOWERS = ConfiguredFeatureRegistry.createKey("red_sakura_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_SAKURA_FLOWERS = ConfiguredFeatureRegistry.createKey("pink_sakura_flowers");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_SAKURA_FLOWERS = ConfiguredFeatureRegistry.createKey("white_sakura_flowers");
    //FOOD_PLANTS
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_SALMONBERRY_BUSH = ConfiguredFeatureRegistry.createKey("patch_salmonberry_bush");
    //OTHER
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_LILY = ConfiguredFeatureRegistry.createKey("flowering_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_LILY = ConfiguredFeatureRegistry.createKey("giant_lily");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ELEPHANT_EAR = ConfiguredFeatureRegistry.createKey("elephant_ear");
    //SHRUBS
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASHEN_SHRUB = ConfiguredFeatureRegistry.createKey("ashen_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ACACIA_SHRUB = ConfiguredFeatureRegistry.createKey("tall_acacia_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BAOBAB_SHRUB = ConfiguredFeatureRegistry.createKey("tall_baobab_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_SHRUB = ConfiguredFeatureRegistry.createKey("tall_birch_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKWOOD_SHRUB = ConfiguredFeatureRegistry.createKey("tall_blackwood_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_SHRUB = ConfiguredFeatureRegistry.createKey("tall_sakura_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_SAKURA_SHRUB = ConfiguredFeatureRegistry.createKey("tall_red_sakura_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_SAKURA_SHRUB = ConfiguredFeatureRegistry.createKey("tall_pink_sakura_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_SAKURA_SHRUB = ConfiguredFeatureRegistry.createKey("tall_white_sakura_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_SHRUB = ConfiguredFeatureRegistry.createKey("tall_cypress_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DARK_OAK_SHRUB = ConfiguredFeatureRegistry.createKey("tall_dark_oak_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SHRUB = ConfiguredFeatureRegistry.createKey("tall_dead_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PINE_SHRUB = ConfiguredFeatureRegistry.createKey("tall_dead_pine_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EUCALYPTUS_SHRUB = ConfiguredFeatureRegistry.createKey("tall_eucalyptus_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_SHRUB = ConfiguredFeatureRegistry.createKey("tall_flowering_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JOSHUA_SHRUB = ConfiguredFeatureRegistry.createKey("tall_joshua_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_SHRUB = ConfiguredFeatureRegistry.createKey("tall_jungle_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARCH_SHRUB = ConfiguredFeatureRegistry.createKey("tall_larch_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_LARCH_SHRUB = ConfiguredFeatureRegistry.createKey("tall_golden_larch_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGROVE_SHRUB = ConfiguredFeatureRegistry.createKey("tall_mangrove_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_SHRUB = ConfiguredFeatureRegistry.createKey("tall_maple_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_SHRUB = ConfiguredFeatureRegistry.createKey("tall_red_maple_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_MAPLE_SHRUB = ConfiguredFeatureRegistry.createKey("tall_orange_maple_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAUVE_SHRUB = ConfiguredFeatureRegistry.createKey("tall_mauve_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_SHRUB = ConfiguredFeatureRegistry.createKey("tall_oak_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_SHRUB = ConfiguredFeatureRegistry.createKey("tall_palm_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_SHRUB = ConfiguredFeatureRegistry.createKey("tall_pine_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_SHRUB = ConfiguredFeatureRegistry.createKey("tall_redwood_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_BIRCH_SHRUB = ConfiguredFeatureRegistry.createKey("tall_silver_birch_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_SHRUB = ConfiguredFeatureRegistry.createKey("tall_spruce_sapling");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_SHRUB = ConfiguredFeatureRegistry.createKey("tall_willow_sapling");
    //mixes
    public static final ResourceKey<ConfiguredFeature<?, ?>> AUTUMNAL_SHRUB_MIX = ConfiguredFeatureRegistry.createKey("tall_autumnal_sapling_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIRCH_SHRUB_MIX = ConfiguredFeatureRegistry.createKey("tall_birch_sapling_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKWOOD_DARK_OAK_SHRUB_MIX = ConfiguredFeatureRegistry.createKey("tall_blackwood_dark_oak_sapling_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_SHRUB_MIX = ConfiguredFeatureRegistry.createKey("tall_sakura_sapling_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SHRUB_MIX = ConfiguredFeatureRegistry.createKey("tall_dead_sapling_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LARCH_SHRUB_MIX = ConfiguredFeatureRegistry.createKey("tall_larch_sapling_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_LARCH_SHRUB_MIX = ConfiguredFeatureRegistry.createKey("tall_golden_larch_sapling_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_SHRUB_MIX = ConfiguredFeatureRegistry.createKey("tall_maple_sapling_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_MANGROVE_SHRUB_MIX = ConfiguredFeatureRegistry.createKey("tall_palm_mangrove_sapling_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_SPRUCE_SHRUB_MIX = ConfiguredFeatureRegistry.createKey("tall_pine_spruce_sapling_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_DEAD_SHRUB_MIX = ConfiguredFeatureRegistry.createKey("tall_pine_dead_sapling_mix");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_CYPRESS_SHRUB_MIX = ConfiguredFeatureRegistry.createKey("tall_willow_cypress_sapling_mix");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holderGetter = context.lookup(Registries.CONFIGURED_FEATURE);
        //Petal-Like Builders
        SimpleWeightedRandomList.Builder<BlockState> orangeConeflowerBuilder = SimpleWeightedRandomList.builder();
        SimpleWeightedRandomList.Builder<BlockState> purpleConeflowerBuilder = SimpleWeightedRandomList.builder();
        SimpleWeightedRandomList.Builder<BlockState> sakuraFlowerBuilder = SimpleWeightedRandomList.builder();

        for(int i = 1; i <= 4; ++i) {
            for(Direction direction : Direction.Plane.HORIZONTAL) {
                orangeConeflowerBuilder.add(RuBlocks.ORANGE_CONEFLOWER.get().defaultBlockState().setValue(GroundCoverBlock.AMOUNT, Integer.valueOf(i)).setValue(GroundCoverBlock.FACING, direction), 1);
                purpleConeflowerBuilder.add(RuBlocks.PURPLE_CONEFLOWER.get().defaultBlockState().setValue(GroundCoverBlock.AMOUNT, Integer.valueOf(i)).setValue(GroundCoverBlock.FACING, direction), 1);
                sakuraFlowerBuilder.add(RuBlocks.SAKURA_PETALS.get().defaultBlockState().setValue(GroundCoverBlock.AMOUNT, Integer.valueOf(i)).setValue(GroundCoverBlock.FACING, direction), 1);
            }
        }


        //---------------------FEATURES---------------------//
        register(context, BLACKWOOD_BIOSHROOMS, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState()), new StraightTrunkPlacer(2, 1, 0), BlockStateProvider.simple(Blocks.MUSHROOM_STEM.defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), 0), new TwoLayersFeatureSize(0, 0, 0)).decorators(ImmutableList.of(BlackwoodBioshroom.INSTANCE)).ignoreVines().build());
        register(context, BLACKWOOD_DECORATION, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.BLUE_BIOSHROOM.get().defaultBlockState(), 3).add(RuBlocks.PINK_BIOSHROOM.get().defaultBlockState(), 3).add(RuBlocks.TALL_BLUE_BIOSHROOM.get().defaultBlockState(), 1).add(RuBlocks.TALL_PINK_BIOSHROOM.get().defaultBlockState(), 1))));
        register(context, LUPINE_VEGETATION, Feature.FLOWER, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.YELLOW_LUPINE.get().defaultBlockState(), 1).add(RuBlocks.RED_LUPINE.get().defaultBlockState(), 1).add(RuBlocks.BLUE_LUPINE.get().defaultBlockState(), 10).add(RuBlocks.PINK_LUPINE.get().defaultBlockState(), 10).add(RuBlocks.PURPLE_LUPINE.get().defaultBlockState(), 10).add(Blocks.GRASS.defaultBlockState(), 5)), 64));
        register(context, PATCH_MEADOW_VEGETATION, Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.HYSSOP.get().defaultBlockState(), 20).add(RuBlocks.FIREWEED.get().defaultBlockState(), 15).add(RuBlocks.DAISY.get().defaultBlockState(), 10).add(Blocks.GRASS.defaultBlockState(), 25))))));
        //GRASS
        register(context, PATCH_GRASS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(Blocks.GRASS.defaultBlockState()), 32));
        register(context, PATCH_MEDIUM_GRASS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.MEDIUM_GRASS.get().defaultBlockState()), 32));
        register(context, PATCH_SEEDED_GRASS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.SEEDED_GRASS.get().defaultBlockState()), 32));
        register(context, PATCH_WINDSWEPT_GRASS, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.WINDSWEPT_GRASS.get().defaultBlockState()), 32));
        register(context, PATCH_STONE_BUD, Feature.RANDOM_PATCH, grassPatch(BlockStateProvider.simple(RuBlocks.STONE_BUD.get().defaultBlockState()), 32));
        register(context, PATCH_ASHEN_GRASS, Feature.RANDOM_PATCH, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.ASHEN_GRASS.get().defaultBlockState(), 4).add(RuBlocks.ASHEN_GRASS.get().defaultBlockState().setValue(AshenGrassBlock.SMOULDERING, true), 1)), 32));
        register(context, PATCH_REDWOODS_VEGETATION, Feature.RANDOM_PATCH, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.FERN.defaultBlockState(), 30).add(Blocks.GRASS.defaultBlockState(), 15).add(Blocks.LARGE_FERN.defaultBlockState(), 1)), 32));
        register(context, PATCH_BLACKWOOD_VEGETATION, Feature.RANDOM_PATCH, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.FERN.defaultBlockState(), 15).add(Blocks.GRASS.defaultBlockState(), 20).add(Blocks.TALL_GRASS.defaultBlockState(), 10).add(Blocks.LARGE_FERN.defaultBlockState(), 1)), 32));
        register(context, PATCH_BAYOU_VEGETATION, Feature.RANDOM_PATCH, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.FERN.defaultBlockState(), 30).add(Blocks.GRASS.defaultBlockState(), 15).add(Blocks.TALL_GRASS.defaultBlockState(), 3)), 32));
        //FLOWERS
        register(context, PATCH_SMALL_FLOWERS, Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new NoiseProvider(2345L, new NormalNoise.NoiseParameters(0, 1.0D), 0.075F, List.of(RuBlocks.YELLOW_LUPINE.get().defaultBlockState(), Blocks.PINK_TULIP.defaultBlockState(), RuBlocks.POPPY_BUSH.get().defaultBlockState(), Blocks.OXEYE_DAISY.defaultBlockState(), RuBlocks.RED_LUPINE.get().defaultBlockState(), Blocks.CORNFLOWER.defaultBlockState(), RuBlocks.PINK_LUPINE.get().defaultBlockState(), Blocks.ORANGE_TULIP.defaultBlockState(), RuBlocks.WARATAH.get().defaultBlockState(), Blocks.WHITE_TULIP.defaultBlockState(), RuBlocks.HYSSOP.get().defaultBlockState(), Blocks.ALLIUM.defaultBlockState(), RuBlocks.BLUE_LUPINE.get().defaultBlockState(), RuBlocks.WHITE_TRILLIUM.get().defaultBlockState(), Blocks.BLUE_ORCHID.defaultBlockState(), RuBlocks.FIREWEED.get().defaultBlockState(), RuBlocks.DAISY.get().defaultBlockState(), RuBlocks.PURPLE_LUPINE.get().defaultBlockState(), Blocks.RED_TULIP.defaultBlockState(), RuBlocks.FELICIA_DAISY.get().defaultBlockState(), Blocks.POPPY.defaultBlockState(), Blocks.LILY_OF_THE_VALLEY.defaultBlockState()))))));
        register(context, PATCH_TALL_FLOWERS, Feature.SIMPLE_RANDOM_SELECTOR, new SimpleRandomFeatureConfiguration(HolderSet.direct(PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.TASSEL.get())))), PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.TSUBAKI.get())))), PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.LILAC)))), PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.ROSE_BUSH)))), PlacementUtils.inlinePlaced(Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.PEONY)))), PlacementUtils.inlinePlaced(Feature.NO_BONEMEAL_FLOWER, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.LILY_OF_THE_VALLEY)))))));
        register(context, PATCH_ALPHA_DANDELION, Feature.FLOWER, grassPatch(BlockStateProvider.simple(RuBlocks.ALPHA_DANDELION.get().defaultBlockState()), 32));
        register(context, PATCH_ALPHA_ROSE, Feature.FLOWER, grassPatch(BlockStateProvider.simple(RuBlocks.ALPHA_ROSE.get().defaultBlockState()), 32));
        register(context, PATCH_WHITE_TRILLIUM, Feature.FLOWER, grassPatch(BlockStateProvider.simple(RuBlocks.WHITE_TRILLIUM.get().defaultBlockState()), 32));
        register(context, PATCH_WILTING_TRILLIUM, Feature.FLOWER, grassPatch(BlockStateProvider.simple(RuBlocks.WILTING_TRILLIUM.get().defaultBlockState()), 32));
        register(context, TASSEL, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.TASSEL.get())));
        register(context, TSUBAKI, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.TSUBAKI.get()))));
        register(context, MEADOW_SAGE, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.MEADOW_SAGE.get())));
        
        register(context, PATCH_ORANGE_CONEFLOWER, Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(orangeConeflowerBuilder)))));
        register(context, PATCH_PURPLE_CONEFLOWER, Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(purpleConeflowerBuilder)))));
        register(context, PATCH_SAKURA_FLOWERS, Feature.FLOWER, new RandomPatchConfiguration(96, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(sakuraFlowerBuilder)))));

        //MULTIFACE FLOWERS
        register(context, RED_SAKURA_FLOWERS, FeatureRegistry.AIR_MULTIFACE_GROWTH.get(), new MultifaceGrowthConfiguration((MultifaceBlock)RuBlocks.RED_SAKURA_FLOWERS.get(), 20, true, false, false, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.GRASS_BLOCK, RuBlocks.FOREST_GRASS_BLOCK.get(), RuBlocks.PLAINS_GRASS_BLOCK.get())));
        register(context, PINK_SAKURA_FLOWERS, FeatureRegistry.AIR_MULTIFACE_GROWTH.get(), new MultifaceGrowthConfiguration((MultifaceBlock)RuBlocks.PINK_SAKURA_FLOWERS.get(), 20, true, false, false, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.GRASS_BLOCK, RuBlocks.FOREST_GRASS_BLOCK.get(), RuBlocks.PLAINS_GRASS_BLOCK.get())));
        register(context, WHITE_SAKURA_FLOWERS, FeatureRegistry.AIR_MULTIFACE_GROWTH.get(), new MultifaceGrowthConfiguration((MultifaceBlock)RuBlocks.WHITE_SAKURA_FLOWERS.get(), 20, true, false, false, 1.0F, HolderSet.direct(Block::builtInRegistryHolder, Blocks.GRASS_BLOCK, RuBlocks.FOREST_GRASS_BLOCK.get(), RuBlocks.PLAINS_GRASS_BLOCK.get())));
        //FOOD_PLANTS
        register(context, PATCH_SALMONBERRY_BUSH, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.SALMONBERRY_BUSH.get().defaultBlockState().setValue(SalmonBerryBushBlock.AGE, Integer.valueOf(3)))), List.of(Blocks.GRASS_BLOCK, Blocks.PODZOL, RuBlocks.FOREST_GRASS_BLOCK.get(), RuBlocks.PLAINS_GRASS_BLOCK.get())));
        //OTHER
        register(context, FLOWERING_LILY, Feature.RANDOM_PATCH, new RandomPatchConfiguration(10, 7, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.FLOWERING_LILY_PAD.get())))));
        register(context, GIANT_LILY, FeatureRegistry.GIANT_LILY.get(), FeatureConfiguration.NONE);
        register(context, ELEPHANT_EAR, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(RuBlocks.ELEPHANT_EAR.get())));
        //SHRUBS
        register(context, ASHEN_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.ASHEN_SHRUB.get().defaultBlockState())));
        register(context, ACACIA_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.ACACIA_SHRUB.get().defaultBlockState())));
        register(context, BAOBAB_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.BAOBAB_SHRUB.get().defaultBlockState())));
        register(context, BIRCH_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.BIRCH_SHRUB.get().defaultBlockState())));
        register(context, BLACKWOOD_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.BLACKWOOD_SHRUB.get().defaultBlockState())));
        register(context, SAKURA_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.SAKURA_SHRUB.get().defaultBlockState())));
        register(context, RED_SAKURA_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.RED_SAKURA_SHRUB.get().defaultBlockState())));
        register(context, PINK_SAKURA_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.PINK_SAKURA_SHRUB.get().defaultBlockState())));
        register(context, WHITE_SAKURA_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.WHITE_SAKURA_SHRUB.get().defaultBlockState())));
        register(context, CYPRESS_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.CYPRESS_SHRUB.get().defaultBlockState())));
        register(context, DARK_OAK_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.DARK_OAK_SHRUB.get().defaultBlockState())));
        register(context, DEAD_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.DEAD_SHRUB.get().defaultBlockState())));
        register(context, DEAD_PINE_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.DEAD_PINE_SHRUB.get().defaultBlockState())));
        register(context, EUCALYPTUS_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.EUCALYPTUS_SHRUB.get().defaultBlockState())));
        register(context, FLOWERING_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.FLOWERING_SHRUB.get().defaultBlockState())));
        register(context, JOSHUA_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.JOSHUA_SHRUB.get().defaultBlockState())));
        register(context, JUNGLE_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.JUNGLE_SHRUB.get().defaultBlockState())));
        register(context, LARCH_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.LARCH_SHRUB.get().defaultBlockState())));
        register(context, GOLDEN_LARCH_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.GOLDEN_LARCH_SHRUB.get().defaultBlockState())));
        register(context, MANGROVE_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.MANGROVE_SHRUB.get().defaultBlockState())));
        register(context, MAPLE_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.MAPLE_SHRUB.get().defaultBlockState())));
        register(context, RED_MAPLE_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.RED_MAPLE_SHRUB.get().defaultBlockState())));
        register(context, ORANGE_MAPLE_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.ORANGE_MAPLE_SHRUB.get().defaultBlockState())));
        register(context, MAUVE_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.MAUVE_SHRUB.get().defaultBlockState())));
        register(context, OAK_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.OAK_SHRUB.get().defaultBlockState())));
        register(context, PALM_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.PALM_SHRUB.get().defaultBlockState())));
        register(context, PINE_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.PINE_SHRUB.get().defaultBlockState())));
        register(context, REDWOOD_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.REDWOOD_SHRUB.get().defaultBlockState())));
        register(context, SILVER_BIRCH_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.SILVER_BIRCH_SHRUB.get().defaultBlockState())));
        register(context, SPRUCE_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.SPRUCE_SHRUB.get().defaultBlockState())));
        register(context, WILLOW_SHRUB, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(BlockStateProvider.simple(RuBlocks.WILLOW_SHRUB.get().defaultBlockState())));
        //mixes
        register(context, AUTUMNAL_SHRUB_MIX, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.MAPLE_SHRUB.get().defaultBlockState(), 2).add(RuBlocks.SILVER_BIRCH_SHRUB.get().defaultBlockState(), 4).add(RuBlocks.RED_MAPLE_SHRUB.get().defaultBlockState(), 4).add(RuBlocks.ORANGE_MAPLE_SHRUB.get().defaultBlockState(), 4).add(RuBlocks.DEAD_SHRUB.get().defaultBlockState(), 1))));
        register(context, BIRCH_SHRUB_MIX, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.SILVER_BIRCH_SHRUB.get().defaultBlockState(), 3).add(RuBlocks.BIRCH_SHRUB.get().defaultBlockState(), 1))));
        register(context, BLACKWOOD_DARK_OAK_SHRUB_MIX, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.BLACKWOOD_SHRUB.get().defaultBlockState(), 3).add(RuBlocks.DARK_OAK_SHRUB.get().defaultBlockState(), 1))));
        register(context, SAKURA_SHRUB_MIX, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.SAKURA_SHRUB.get().defaultBlockState(), 1).add(RuBlocks.RED_SAKURA_SHRUB.get().defaultBlockState(), 1).add(RuBlocks.PINK_SAKURA_SHRUB.get().defaultBlockState(), 1).add(RuBlocks.WHITE_SAKURA_SHRUB.get().defaultBlockState(), 1))));
        register(context, DEAD_SHRUB_MIX, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.DEAD_SHRUB.get().defaultBlockState(), 2).add(RuBlocks.DEAD_PINE_SHRUB.get().defaultBlockState(), 1))));
        register(context, LARCH_SHRUB_MIX, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.LARCH_SHRUB.get().defaultBlockState(), 3).add(RuBlocks.GOLDEN_LARCH_SHRUB.get().defaultBlockState(), 1))));
        register(context, GOLDEN_LARCH_SHRUB_MIX, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.LARCH_SHRUB.get().defaultBlockState(), 1).add(RuBlocks.GOLDEN_LARCH_SHRUB.get().defaultBlockState(), 3))));
        register(context, MAPLE_SHRUB_MIX, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.MAPLE_SHRUB.get().defaultBlockState(), 4).add(RuBlocks.RED_MAPLE_SHRUB.get().defaultBlockState(), 1))));
        register(context, PINE_SPRUCE_SHRUB_MIX, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.PINE_SHRUB.get().defaultBlockState(), 1).add(RuBlocks.SPRUCE_SHRUB.get().defaultBlockState(), 1))));
        register(context, PINE_DEAD_SHRUB_MIX, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.PINE_SHRUB.get().defaultBlockState(), 2).add(RuBlocks.DEAD_PINE_SHRUB.get().defaultBlockState(), 1))));
        register(context, PALM_MANGROVE_SHRUB_MIX, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.PALM_SHRUB.get().defaultBlockState(), 5).add(RuBlocks.MANGROVE_SHRUB.get().defaultBlockState(), 1))));
        register(context, WILLOW_CYPRESS_SHRUB_MIX, FeatureRegistry.SHRUB.get(), new ShrubConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.WILLOW_SHRUB.get().defaultBlockState(), 2).add(RuBlocks.CYPRESS_SHRUB.get().defaultBlockState(), 1))));


    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider stateProvider, int i) {
        return FeatureUtils.simpleRandomPatchConfiguration(i, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider)));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
