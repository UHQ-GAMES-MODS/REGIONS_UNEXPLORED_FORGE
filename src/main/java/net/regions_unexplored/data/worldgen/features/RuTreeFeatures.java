package net.regions_unexplored.data.worldgen.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.*;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.registry.ConfiguredFeatureRegistry;
import net.regions_unexplored.registry.FeatureRegistry;
import net.regions_unexplored.world.features.foliageplacers.SakuraFoliagePlacer;
import net.regions_unexplored.world.features.foliageplacers.WillowFoliagePlacer;
import net.regions_unexplored.world.features.treedecorators.PineTrunkDecorator;
import net.regions_unexplored.world.features.treedecorators.WillowTrunkDecorator;
import net.regions_unexplored.world.level.block.leaves.AppleLeavesBlock;
import net.regions_unexplored.world.level.block.wood.BambooLogBlock;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;

import java.util.List;
import java.util.OptionalInt;

public class RuTreeFeatures {
    //TODO:Complete Class
    //-----------------------KEYS-----------------------//

    //public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_GREEN_BIOSHROOM = ConfiguredFeatureRegistry.createKey("giant_green_bioshroom");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_BLUE_BIOSHROOM = ConfiguredFeatureRegistry.createKey("giant_blue_bioshroom");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_PINK_BIOSHROOM = ConfiguredFeatureRegistry.createKey("giant_pink_bioshroom");
    //public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_YELLOW_BIOSHROOM = ConfiguredFeatureRegistry.createKey("giant_yellow_bioshroom");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BRIM_WILLOW_TREE = ConfiguredFeatureRegistry.createKey("brim_willow_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_BRIM_WILLOW_TREE = ConfiguredFeatureRegistry.createKey("tall_brim_willow_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ALPHA_OAK_TREE = ConfiguredFeatureRegistry.createKey("alpha_oak_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ASHEN_TREE = ConfiguredFeatureRegistry.createKey("ashen_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASHEN_PINE_TREE = ConfiguredFeatureRegistry.createKey("ashen_pine_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BAMBOO_TREE = ConfiguredFeatureRegistry.createKey("bamboo_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWERING_OAK_TREE = ConfiguredFeatureRegistry.createKey("flowering_oak_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_FLOWERING_OAK_TREE = ConfiguredFeatureRegistry.createKey("big_flowering_oak_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> APPLE_OAK_TREE = ConfiguredFeatureRegistry.createKey("apple_oak_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_APPLE_OAK_TREE = ConfiguredFeatureRegistry.createKey("big_apple_oak_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BAOBAB_TREE = ConfiguredFeatureRegistry.createKey("baobab_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_BAOBAB_TREE = ConfiguredFeatureRegistry.createKey("big_baobab_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> BLACKWOOD_TREE = ConfiguredFeatureRegistry.createKey("blackwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_BLACKWOOD_TREE = ConfiguredFeatureRegistry.createKey("big_blackwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_BLACKWOOD_TREE = ConfiguredFeatureRegistry.createKey("giant_blackwood_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_DARK_OAK = ConfiguredFeatureRegistry.createKey("tall_dark_oak");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SAKURA_TREE = ConfiguredFeatureRegistry.createKey("sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_SAKURA_TREE = ConfiguredFeatureRegistry.createKey("red_sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_SAKURA_TREE = ConfiguredFeatureRegistry.createKey("pink_sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_SAKURA_TREE = ConfiguredFeatureRegistry.createKey("white_sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_SAKURA_TREE = ConfiguredFeatureRegistry.createKey("big_sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_RED_SAKURA_TREE = ConfiguredFeatureRegistry.createKey("big_red_sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_PINK_SAKURA_TREE = ConfiguredFeatureRegistry.createKey("big_pink_sakura_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_WHITE_SAKURA_TREE = ConfiguredFeatureRegistry.createKey("big_white_sakura_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_TREE = ConfiguredFeatureRegistry.createKey("cypress_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_CYPRESS_TREE = ConfiguredFeatureRegistry.createKey("giant_cypress_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_TREE = ConfiguredFeatureRegistry.createKey("dead_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PINE_TREE = ConfiguredFeatureRegistry.createKey("dead_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_PINE_TREE_TALL = ConfiguredFeatureRegistry.createKey("dead_pine_tree_tall");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SCOTTS_PINE_TREE = ConfiguredFeatureRegistry.createKey("dead_scotts_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_SCOTTS_PINE_TREE_TALL = ConfiguredFeatureRegistry.createKey("dead_scotts_pine_tree_tall");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_GIANT_PINE_TREE = ConfiguredFeatureRegistry.createKey("dead_giant_pine_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> EUCALYPTUS_TREE = ConfiguredFeatureRegistry.createKey("eucalyptus_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARGE_JOSHUA_TREE = ConfiguredFeatureRegistry.createKey("large_joshua_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEDIUM_JOSHUA_TREE = ConfiguredFeatureRegistry.createKey("medium_joshua_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> LARCH_TREE = ConfiguredFeatureRegistry.createKey("larch_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_LARCH_TREE = ConfiguredFeatureRegistry.createKey("big_larch_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_LARCH_TREE = ConfiguredFeatureRegistry.createKey("larch_golden_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_GOLDEN_LARCH_TREE = ConfiguredFeatureRegistry.createKey("big_golden_larch_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_TREE = ConfiguredFeatureRegistry.createKey("maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_MAPLE_TREE = ConfiguredFeatureRegistry.createKey("big_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_TREE = ConfiguredFeatureRegistry.createKey("red_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_RED_MAPLE_TREE = ConfiguredFeatureRegistry.createKey("big_red_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_MAPLE_TREE = ConfiguredFeatureRegistry.createKey("orange_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_ORANGE_MAPLE_TREE = ConfiguredFeatureRegistry.createKey("big_orange_maple_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAUVE_OAK_BEE = ConfiguredFeatureRegistry.createKey("mauve_oak_bee");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAUVE_OAK = ConfiguredFeatureRegistry.createKey("mauve_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_MAUVE_OAK = ConfiguredFeatureRegistry.createKey("big_mauve_oak");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_TREE_SHRUB = ConfiguredFeatureRegistry.createKey("oak_tree_shrub");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OAK_BUSH = ConfiguredFeatureRegistry.createKey("oak_bush");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_TREE = ConfiguredFeatureRegistry.createKey("palm_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TALL_PALM_TREE = ConfiguredFeatureRegistry.createKey("tall_palm_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_TREE = ConfiguredFeatureRegistry.createKey("pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_TREE_TALL = ConfiguredFeatureRegistry.createKey("pine_tree_tall");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCOTTS_PINE_TREE = ConfiguredFeatureRegistry.createKey("scotts_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCOTTS_PINE_TREE_TALL = ConfiguredFeatureRegistry.createKey("scotts_pine_tree_tall");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_PINE_TREE = ConfiguredFeatureRegistry.createKey("giant_pine_tree");

    //DONE
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAGUARO_CACTUS = ConfiguredFeatureRegistry.createKey("saguaro_cactus");

    //DONE
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_BIRCH = ConfiguredFeatureRegistry.createKey("silver_birch");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_BIRCH_TALL = ConfiguredFeatureRegistry.createKey("silver_birch_tall");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SPRUCE_TREE_TALL = ConfiguredFeatureRegistry.createKey("spruce_tree_tall");

    //DONE
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_TREE = ConfiguredFeatureRegistry.createKey("redwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_REDWOOD_TREE = ConfiguredFeatureRegistry.createKey("giant_redwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ULTRA_REDWOOD_TREE = ConfiguredFeatureRegistry.createKey("ultra_redwood_tree");

    //DONE
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_TREE = ConfiguredFeatureRegistry.createKey("willow_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_WILLOW_TREE = ConfiguredFeatureRegistry.createKey("big_willow_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_TREE_VINES = ConfiguredFeatureRegistry.createKey("willow_tree_vines");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<Block> holderGetter = context.lookup(Registries.BLOCK);

        register(context, ASHEN_TREE, FeatureRegistry.ASHEN_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.ASHEN_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.ASHEN_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.DEAD_BRANCH.get().defaultBlockState()), 12, 5));
        register(context, ASHEN_PINE_TREE, FeatureRegistry.ASHEN_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.ASHEN_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.PINE_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.DEAD_BRANCH.get().defaultBlockState()), 12, 7));

        register(context, BRIM_WILLOW_TREE, FeatureRegistry.BRIM_WILLOW.get(), FeatureConfiguration.NONE);
        register(context, TALL_BRIM_WILLOW_TREE, FeatureRegistry.TALL_BRIM_WILLOW.get(), FeatureConfiguration.NONE);

        register(context, ALPHA_OAK_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.ALPHA_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 2, 0),BlockStateProvider.simple(RuBlocks.ALPHA_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, BAMBOO_TREE, Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.BAMBOO_LOG.get().defaultBlockState(), 3).add(RuBlocks.BAMBOO_LOG.get().defaultBlockState().setValue(BambooLogBlock.LEAVES, true), 1)),new StraightTrunkPlacer(12, 9, 0),new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.BAMBOO_LEAVES.get().defaultBlockState(), 5).add(RuBlocks.BAMBOO_LEAVES.get().defaultBlockState(), 1)),new RandomSpreadFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(5), 150), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().dirt(BlockStateProvider.simple(Blocks.PODZOL)).build());

        register(context, FLOWERING_OAK_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),new StraightTrunkPlacer(4, 3, 0),new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3).add(RuBlocks.FLOWERING_LEAVES.get().defaultBlockState(), 1)),new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
        register(context, BIG_FLOWERING_OAK_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3).add(RuBlocks.FLOWERING_LEAVES.get().defaultBlockState(), 1)),new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

        register(context, APPLE_OAK_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),new StraightTrunkPlacer(4, 2, 0),new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 18).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState(), 1).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(1)), 1).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(2)), 2).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(3)), 2).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(4)), 2)),new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
        register(context, BIG_APPLE_OAK_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 14).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState(), 1).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(1)), 1).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(2)), 2).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(3)), 2).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(4)), 2)),new FancyFoliagePlacer(ConstantInt.of(1), ConstantInt.of(2), 3), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

        register(context, BAOBAB_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.BAOBAB_LOG.get().defaultBlockState()),new ForkingTrunkPlacer(5, 2, 2),BlockStateProvider.simple(RuBlocks.BAOBAB_LEAVES.get().defaultBlockState()),new AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)), new TwoLayersFeatureSize(1, 0, 2)).ignoreVines().build());
        register(context, BIG_BAOBAB_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.BAOBAB_LOG.get().defaultBlockState()),new DarkOakTrunkPlacer(9, 6, 1),BlockStateProvider.simple(RuBlocks.BAOBAB_LEAVES.get().defaultBlockState()),new AcaciaFoliagePlacer(ConstantInt.of(3), ConstantInt.of(1)),new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).ignoreVines().build());

        register(context, BLACKWOOD_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.BLACKWOOD_LOG.get().defaultBlockState()), new StraightTrunkPlacer(12, 4, 2), BlockStateProvider.simple(RuBlocks.BLACKWOOD_LEAVES.get().defaultBlockState()), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(2, 2), UniformInt.of(5, 5)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());
        register(context, BIG_BLACKWOOD_TREE, FeatureRegistry.BLACKWOOD_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.BLACKWOOD_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.BLACKWOOD_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.BLACKWOOD_BRANCH.get().defaultBlockState()), 19, 5));
        register(context, GIANT_BLACKWOOD_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.BLACKWOOD_LOG.get().defaultBlockState()), new GiantTrunkPlacer(22, 4, 5), BlockStateProvider.simple(RuBlocks.BLACKWOOD_LEAVES.get().defaultBlockState()), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 1, 2)).build());

        register(context, TALL_DARK_OAK, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.DARK_OAK_LOG), new DarkOakTrunkPlacer(8, 4, 1), BlockStateProvider.simple(Blocks.DARK_OAK_LEAVES), new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)), new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())).ignoreVines().build());

        register(context, BIG_SAKURA_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.SAKURA_LOG.get().defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RuBlocks.SAKURA_LEAVES.get().defaultBlockState()),new SakuraFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
        register(context, SAKURA_TREE, FeatureRegistry.SAKURA_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.SAKURA_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.SAKURA_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.SAKURA_BRANCH.get().defaultBlockState()), 1, 4));
        register(context, RED_SAKURA_TREE, FeatureRegistry.SAKURA_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.SAKURA_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.RED_SAKURA_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.SAKURA_BRANCH.get().defaultBlockState()), 1, 5));
        register(context, BIG_RED_SAKURA_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.SAKURA_LOG.get().defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RuBlocks.RED_SAKURA_LEAVES.get().defaultBlockState()),new SakuraFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
        register(context, PINK_SAKURA_TREE, FeatureRegistry.SAKURA_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.SAKURA_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.PINK_SAKURA_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.SAKURA_BRANCH.get().defaultBlockState()), 1, 4));
        register(context, BIG_PINK_SAKURA_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.SAKURA_LOG.get().defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RuBlocks.PINK_SAKURA_LEAVES.get().defaultBlockState()),new SakuraFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
        register(context, WHITE_SAKURA_TREE, FeatureRegistry.SAKURA_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.SAKURA_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.WHITE_SAKURA_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.SAKURA_BRANCH.get().defaultBlockState()), 1, 5));
        register(context, BIG_WHITE_SAKURA_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.SAKURA_LOG.get().defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RuBlocks.WHITE_SAKURA_LEAVES.get().defaultBlockState()),new SakuraFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
        register(context, CYPRESS_TREE, FeatureRegistry.CYPRESS_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.CYPRESS_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.CYPRESS_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.CYPRESS_BRANCH.get().defaultBlockState()), 17, 4));
        register(context, GIANT_CYPRESS_TREE, FeatureRegistry.GIANT_CYPRESS_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.CYPRESS_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.CYPRESS_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.CYPRESS_BRANCH.get().defaultBlockState()), 25, 5));

        //TODO: dead trees
        register(context, DEAD_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.DEAD_LOG.get().defaultBlockState()), new StraightTrunkPlacer(6, 2, 0),BlockStateProvider.simple(RuBlocks.DEAD_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(context, DEAD_PINE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.PINE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(10, 2, 2),BlockStateProvider.simple(RuBlocks.DEAD_PINE_LEAVES.get().defaultBlockState()),new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(2, 2), UniformInt.of(5, 5)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());
        register(context, DEAD_PINE_TREE_TALL, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.PINE_LOG.get().defaultBlockState()),new StraightTrunkPlacer(10, 2, 2),BlockStateProvider.simple(RuBlocks.DEAD_PINE_LEAVES.get().defaultBlockState()),new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 4)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());
        register(context, DEAD_SCOTTS_PINE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.PINE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(10, 2, 2),BlockStateProvider.simple(RuBlocks.DEAD_PINE_LEAVES.get().defaultBlockState()),new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(2, 2), UniformInt.of(5, 5)), new TwoLayersFeatureSize(2, 0, 2)).decorators(ImmutableList.of(PineTrunkDecorator.INSTANCE)).ignoreVines().build());
        register(context, DEAD_SCOTTS_PINE_TREE_TALL, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.PINE_LOG.get().defaultBlockState()),new StraightTrunkPlacer(10, 2, 2),BlockStateProvider.simple(RuBlocks.DEAD_PINE_LEAVES.get().defaultBlockState()),new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 4)), new TwoLayersFeatureSize(2, 0, 2)).decorators(ImmutableList.of(PineTrunkDecorator.INSTANCE)).ignoreVines().build());
        register(context, DEAD_GIANT_PINE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.PINE_LOG.get().defaultBlockState()), new GiantTrunkPlacer(22, 4, 5), BlockStateProvider.simple(RuBlocks.DEAD_PINE_LEAVES.get().defaultBlockState()), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 1, 2)).build());

        register(context, EUCALYPTUS_TREE, FeatureRegistry.EUCALYPTUS_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.EUCALYPTUS_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.EUCALYPTUS_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.EUCALYPTUS_BRANCH.get().defaultBlockState()), 14, 8));

        register(context, MEDIUM_JOSHUA_TREE, FeatureRegistry.MEDIUM_JOSHUA_TREE.get(), FeatureConfiguration.NONE);
        register(context, LARGE_JOSHUA_TREE, FeatureRegistry.LARGE_JOSHUA_TREE.get(), FeatureConfiguration.NONE);

        register(context, LARCH_TREE, FeatureRegistry.LARCH_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.LARCH_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.LARCH_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.LARCH_BRANCH.get().defaultBlockState()), 18, 5));
        register(context, BIG_LARCH_TREE, FeatureRegistry.LARCH_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.LARCH_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.LARCH_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.LARCH_BRANCH.get().defaultBlockState()), 23, 7));

        register(context, GOLDEN_LARCH_TREE, FeatureRegistry.LARCH_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.LARCH_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.GOLDEN_LARCH_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.LARCH_BRANCH.get().defaultBlockState()), 18, 5));
        register(context, BIG_GOLDEN_LARCH_TREE, FeatureRegistry.LARCH_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.LARCH_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.GOLDEN_LARCH_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.LARCH_BRANCH.get().defaultBlockState()), 23, 7));

        register(context, MAPLE_TREE, FeatureRegistry.MAPLE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.MAPLE_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.MAPLE_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.MAPLE_BRANCH.get().defaultBlockState()), 6, 4));
        register(context, BIG_MAPLE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.MAPLE_LOG.get().defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RuBlocks.MAPLE_LEAVES.get().defaultBlockState()),new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
        register(context, RED_MAPLE_TREE, FeatureRegistry.MAPLE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.MAPLE_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.RED_MAPLE_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.MAPLE_BRANCH.get().defaultBlockState()), 6, 4));
        register(context, BIG_RED_MAPLE_TREE, Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.MAPLE_LOG.get().defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RuBlocks.RED_MAPLE_LEAVES.get().defaultBlockState()),new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
        register(context, ORANGE_MAPLE_TREE, FeatureRegistry.MAPLE_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.MAPLE_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.ORANGE_MAPLE_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.MAPLE_BRANCH.get().defaultBlockState()), 6, 4));
        register(context, BIG_ORANGE_MAPLE_TREE, Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.MAPLE_LOG.get().defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RuBlocks.ORANGE_MAPLE_LEAVES.get().defaultBlockState()),new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

        register(context, MAUVE_OAK_BEE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.MAUVE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(5, 2, 0),BlockStateProvider.simple(RuBlocks.MAUVE_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(new BeehiveDecorator(1f))).ignoreVines().build());
        register(context, MAUVE_OAK, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.MAUVE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(5, 2, 0),BlockStateProvider.simple(RuBlocks.MAUVE_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(List.of(new BeehiveDecorator(0.25f))).ignoreVines().build());
        register(context, BIG_MAUVE_OAK, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.MAUVE_LOG.get().defaultBlockState()), new FancyTrunkPlacer(8, 11, 0),BlockStateProvider.simple(RuBlocks.MAUVE_LEAVES.get().defaultBlockState()), new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

        register(context, OAK_TREE_SHRUB, FeatureRegistry.TREE_SHRUB.get(), new RuTreeConfiguration(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()), BlockStateProvider.simple(RuBlocks.OAK_BRANCH.get().defaultBlockState()), 1, 0));
        register(context, OAK_BUSH, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()), new StraightTrunkPlacer(1, 0, 0), BlockStateProvider.simple(Blocks.OAK_LEAVES.defaultBlockState()), new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2), new TwoLayersFeatureSize(0, 0, 0)).build());

        register(context, PALM_TREE, FeatureRegistry.PALM_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.PALM_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.PALM_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.PALM_BEARD.get().defaultBlockState()), 8, 5));
        register(context, TALL_PALM_TREE, FeatureRegistry.PALM_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.PALM_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.PALM_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.PALM_BEARD.get().defaultBlockState()), 12, 5));

        register(context, PINE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.PINE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(10, 2, 2),BlockStateProvider.simple(RuBlocks.PINE_LEAVES.get().defaultBlockState()),new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(2, 2), UniformInt.of(5, 5)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());
        register(context, PINE_TREE_TALL, Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.PINE_LOG.get().defaultBlockState()),new StraightTrunkPlacer(10, 2, 2),BlockStateProvider.simple(RuBlocks.PINE_LEAVES.get().defaultBlockState()),new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 4)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());
        register(context, SCOTTS_PINE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.PINE_LOG.get().defaultBlockState()), new StraightTrunkPlacer(10, 2, 2),BlockStateProvider.simple(RuBlocks.PINE_LEAVES.get().defaultBlockState()),new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(2, 2), UniformInt.of(5, 5)), new TwoLayersFeatureSize(2, 0, 2)).decorators(ImmutableList.of(PineTrunkDecorator.INSTANCE)).ignoreVines().build());
        register(context, SCOTTS_PINE_TREE_TALL, Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.PINE_LOG.get().defaultBlockState()),new StraightTrunkPlacer(10, 2, 2),BlockStateProvider.simple(RuBlocks.PINE_LEAVES.get().defaultBlockState()),new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 4)), new TwoLayersFeatureSize(2, 0, 2)).decorators(ImmutableList.of(PineTrunkDecorator.INSTANCE)).ignoreVines().build());
        register(context, GIANT_PINE_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.PINE_LOG.get().defaultBlockState()), new GiantTrunkPlacer(22, 4, 5), BlockStateProvider.simple(RuBlocks.PINE_LEAVES.get().defaultBlockState()), new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(13, 17)), new TwoLayersFeatureSize(1, 1, 2)).build());

        register(context, SAGUARO_CACTUS, FeatureRegistry.SAGUARO_CACTUS.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.SAGUARO_CACTUS.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.CACTUS_FLOWER.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.REDWOOD_BRANCH.get().defaultBlockState()), 7, 2));

        register(context, SILVER_BIRCH, FeatureRegistry.ASPEN_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.SILVER_BIRCH_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.SILVER_BIRCH_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.SILVER_BIRCH_BRANCH.get().defaultBlockState()), 4, 4));
        register(context, SILVER_BIRCH_TALL, FeatureRegistry.ASPEN_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.SILVER_BIRCH_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.SILVER_BIRCH_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.SILVER_BIRCH_BRANCH.get().defaultBlockState()), 5, 5));

        register(context, SPRUCE_TREE_TALL, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.SPRUCE_LOG.defaultBlockState()), new StraightTrunkPlacer(13, 2, 2), BlockStateProvider.simple(Blocks.SPRUCE_LEAVES.defaultBlockState()), new SpruceFoliagePlacer(UniformInt.of(2, 3), UniformInt.of(2, 2), UniformInt.of(5, 5)), new TwoLayersFeatureSize(2, 0, 2)).ignoreVines().build());

        //TODO:redesign giant and normal redwoods
        register(context, REDWOOD_TREE, FeatureRegistry.REDWOOD_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.REDWOOD_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.REDWOOD_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.REDWOOD_BRANCH.get()), 21, 9));
        register(context, GIANT_REDWOOD_TREE, FeatureRegistry.SUPER_REDWOOD_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.REDWOOD_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.REDWOOD_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.REDWOOD_BRANCH.get()), 30, 14));
        register(context, ULTRA_REDWOOD_TREE, FeatureRegistry.ULTRA_REDWOOD_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.REDWOOD_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.REDWOOD_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.REDWOOD_BRANCH.get()), 45, 9));

        register(context, WILLOW_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.WILLOW_LOG.get().defaultBlockState()), new StraightTrunkPlacer(8, 2, 0),BlockStateProvider.simple(RuBlocks.WILLOW_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(ImmutableList.of(WillowTrunkDecorator.INSTANCE)).build());
        register(context, BIG_WILLOW_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.WILLOW_LOG.get().defaultBlockState()), new FancyTrunkPlacer(9, 6, 0), BlockStateProvider.simple(RuBlocks.WILLOW_LEAVES.get().defaultBlockState()), new WillowFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());
        register(context, WILLOW_TREE_VINES, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.WILLOW_LOG.get().defaultBlockState()), new StraightTrunkPlacer(8, 2, 0),BlockStateProvider.simple(RuBlocks.WILLOW_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).decorators(ImmutableList.of(new LeaveVineDecorator(0.25f), WillowTrunkDecorator.INSTANCE)).build());
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
