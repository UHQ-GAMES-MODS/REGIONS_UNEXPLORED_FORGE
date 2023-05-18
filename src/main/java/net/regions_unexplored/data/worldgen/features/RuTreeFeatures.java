package net.regions_unexplored.data.worldgen.features;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.MangrovePropaguleBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.rootplacers.AboveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacement;
import net.minecraft.world.level.levelgen.feature.rootplacers.MangroveRootPlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RandomizedIntStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AttachedToLeavesDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.LeaveVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.*;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.registry.ConfiguredFeatureRegistry;
import net.regions_unexplored.registry.FeatureRegistry;
import net.regions_unexplored.world.level.block.leaves.AppleLeavesBlock;
import net.regions_unexplored.world.level.block.log.BambooLogBlock;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class RuTreeFeatures {
    //TODO:Complete Class
    //-----------------------KEYS-----------------------//
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_GREEN_BIOSHROOM = ConfiguredFeatureRegistry.createKey("giant_green_bioshroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_BLUE_BIOSHROOM = ConfiguredFeatureRegistry.createKey("giant_blue_bioshroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_PINK_BIOSHROOM = ConfiguredFeatureRegistry.createKey("giant_pink_bioshroom");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_YELLOW_BIOSHROOM = ConfiguredFeatureRegistry.createKey("giant_yellow_bioshroom");

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

    public static final ResourceKey<ConfiguredFeature<?, ?>> CHERRY_TREE = ConfiguredFeatureRegistry.createKey("cherry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_CHERRY_TREE = ConfiguredFeatureRegistry.createKey("big_cherry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_CHERRY_TREE = ConfiguredFeatureRegistry.createKey("red_cherry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_BIG_CHERRY_TREE = ConfiguredFeatureRegistry.createKey("red_big_cherry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_CHERRY_TREE = ConfiguredFeatureRegistry.createKey("pink_cherry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINK_BIG_CHERRY_TREE = ConfiguredFeatureRegistry.createKey("pink_big_cherry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_CHERRY_TREE = ConfiguredFeatureRegistry.createKey("white_cherry_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> WHITE_BIG_CHERRY_TREE = ConfiguredFeatureRegistry.createKey("white_big_cherry_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_TREE = ConfiguredFeatureRegistry.createKey("cypress_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_CYPRESS_TREE = ConfiguredFeatureRegistry.createKey("big_cypress_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CYPRESS_TREE_MOSS = ConfiguredFeatureRegistry.createKey("cypress_tree_moss");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_CYPRESS_TREE_MOSS = ConfiguredFeatureRegistry.createKey("big_cypress_tree_moss");

    public static final ResourceKey<ConfiguredFeature<?, ?>> DEAD_TREE = ConfiguredFeatureRegistry.createKey("dead_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_DEAD_TREE = ConfiguredFeatureRegistry.createKey("big_dead_tree");

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
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_LARCH_TREE = ConfiguredFeatureRegistry.createKey("giant_larch_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLDEN_LARCH_TREE = ConfiguredFeatureRegistry.createKey("larch_golden_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_GOLDEN_LARCH_TREE = ConfiguredFeatureRegistry.createKey("big_golden_larch_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_GOLDEN_LARCH_TREE = ConfiguredFeatureRegistry.createKey("giant_golden_larch_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_TREE = ConfiguredFeatureRegistry.createKey("maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_MAPLE_TREE = ConfiguredFeatureRegistry.createKey("big_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RED_MAPLE_TREE = ConfiguredFeatureRegistry.createKey("red_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_RED_MAPLE_TREE = ConfiguredFeatureRegistry.createKey("big_red_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORANGE_MAPLE_TREE = ConfiguredFeatureRegistry.createKey("orange_maple_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_ORANGE_MAPLE_TREE = ConfiguredFeatureRegistry.createKey("big_orange_maple_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> MAUVE_OAK_BEE = ConfiguredFeatureRegistry.createKey("mauve_oak_bee");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAUVE_OAK = ConfiguredFeatureRegistry.createKey("mauve_oak");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BIG_MAUVE_OAK = ConfiguredFeatureRegistry.createKey("big_mauve_oak");

    public static final ResourceKey<ConfiguredFeature<?, ?>> PALM_TREE = ConfiguredFeatureRegistry.createKey("palm_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_PINE = ConfiguredFeatureRegistry.createKey("small_pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SMALL_SCOTTS_PINE = ConfiguredFeatureRegistry.createKey("small_scotts_pine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_TREE = ConfiguredFeatureRegistry.createKey("pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINE_TREE_TALL = ConfiguredFeatureRegistry.createKey("pine_tree_tall");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCOTTS_PINE_TREE = ConfiguredFeatureRegistry.createKey("scotts_pine_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCOTTS_PINE_TREE_TALL = ConfiguredFeatureRegistry.createKey("scotts_pine_tree_tall");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_PINE_TREE = ConfiguredFeatureRegistry.createKey("giant_pine_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SAGUARO_CACTUS = ConfiguredFeatureRegistry.createKey("saguaro_cactus");

    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_BIRCH_ASPEN = ConfiguredFeatureRegistry.createKey("silver_birch_aspen");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_BIRCH = ConfiguredFeatureRegistry.createKey("silver_birch");

    public static final ResourceKey<ConfiguredFeature<?, ?>> REDWOOD_TREE = ConfiguredFeatureRegistry.createKey("redwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GIANT_REDWOOD_TREE = ConfiguredFeatureRegistry.createKey("giant_redwood_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ULTRA_REDWOOD_TREE = ConfiguredFeatureRegistry.createKey("ultra_redwood_tree");

    public static final ResourceKey<ConfiguredFeature<?, ?>> WILLOW_TREE = ConfiguredFeatureRegistry.createKey("willow_tree");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> treeBootstrap) {
        HolderGetter<Block> holderGetter = treeBootstrap.lookup(Registries.BLOCK);

        register(treeBootstrap, ASHEN_TREE, FeatureRegistry.ASHEN_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.ASHEN_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.ASHEN_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.DEAD_BRANCH.get().defaultBlockState()), 12, 5));
        register(treeBootstrap, ASHEN_PINE_TREE, FeatureRegistry.ASHEN_TREE.get(), new RuTreeConfiguration(BlockStateProvider.simple(RuBlocks.ASHEN_LOG.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.PINE_LEAVES.get().defaultBlockState()), BlockStateProvider.simple(RuBlocks.DEAD_BRANCH.get().defaultBlockState()), 12, 7));

        register(treeBootstrap, ALPHA_OAK_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(RuBlocks.ALPHA_LOG.get().defaultBlockState()), new StraightTrunkPlacer(4, 2, 0),BlockStateProvider.simple(RuBlocks.ALPHA_LEAVES.get().defaultBlockState()), new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());

        register(treeBootstrap, BAMBOO_TREE, Feature.TREE,new TreeConfiguration.TreeConfigurationBuilder(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.BAMBOO_LOG.get().defaultBlockState(), 3).add(RuBlocks.BAMBOO_LOG.get().defaultBlockState().setValue(BambooLogBlock.LEAVES, true), 1)),new StraightTrunkPlacer(12, 9, 0),new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(RuBlocks.BAMBOO_LEAVES.get().defaultBlockState(), 5).add(RuBlocks.BAMBOO_LEAVES.get().defaultBlockState(), 1)),new RandomSpreadFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(5), 150), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().dirt(BlockStateProvider.simple(Blocks.PODZOL)).build());

        register(treeBootstrap, FLOWERING_OAK_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),new StraightTrunkPlacer(4, 3, 0),new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3).add(RuBlocks.FLOWERING_LEAVES.get().defaultBlockState(), 1)),new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
        register(treeBootstrap, BIG_FLOWERING_OAK_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 3).add(RuBlocks.FLOWERING_LEAVES.get().defaultBlockState(), 1)),new FancyFoliagePlacer(ConstantInt.of(2), ConstantInt.of(4), 4), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

        register(treeBootstrap, APPLE_OAK_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),new StraightTrunkPlacer(4, 2, 0),new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 18).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState(), 1).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(1)), 1).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(2)), 2).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(3)), 2).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(4)), 2)),new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3), new TwoLayersFeatureSize(1, 0, 1)).ignoreVines().build());
        register(treeBootstrap, BIG_APPLE_OAK_TREE, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(Blocks.OAK_LOG.defaultBlockState()),new FancyTrunkPlacer(8, 11, 0),new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.OAK_LEAVES.defaultBlockState(), 14).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState(), 1).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(1)), 1).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(2)), 2).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(3)), 2).add(RuBlocks.APPLE_OAK_LEAVES.get().defaultBlockState().setValue(AppleLeavesBlock.AGE, Integer.valueOf(4)), 2)),new FancyFoliagePlacer(ConstantInt.of(1), ConstantInt.of(2), 3), new TwoLayersFeatureSize(0, 0, 0, OptionalInt.of(4))).ignoreVines().build());

    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC config) {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}
