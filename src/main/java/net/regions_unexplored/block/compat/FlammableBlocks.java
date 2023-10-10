package net.regions_unexplored.block.compat;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.regions_unexplored.block.RuBlocks;

public class FlammableBlocks {

    public static void setup() {
        /*-----------------CAVE_BLOCKS-----------------*/
        //PRISMA_BLOCKS
        registerFlammableBlock(RuBlocks.PRISMOSS_SPROUT.get(), 60, 100);

        registerFlammableBlock(RuBlocks.CORPSE_FLOWER.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLADED_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLADED_TALL_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DROPLEAF.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DROPLEAF_PLANT.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DUSKMELON.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DUSKTRAP.get(), 60, 100);
        /*-----------------PLANTS-----------------*/
        //GRASS_BLOCKS
        registerFlammableBlock(RuBlocks.DEAD_STEPPE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.FROZEN_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MEDIUM_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SANDY_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SMALL_DESERT_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.STEPPE_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.STEPPE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.STONE_BUD.get(), 60, 100);
        //TALL_GRASS_BLOCKS
        registerFlammableBlock(RuBlocks.ELEPHANT_EAR.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SANDY_TALL_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.STEPPE_TALL_GRASS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WINDSWEPT_GRASS.get(), 60, 100);
        //FLOWERS
        registerFlammableBlock(RuBlocks.ALPHA_DANDELION.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ALPHA_ROSE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ASTER.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLEEDING_HEART.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLUE_LUPINE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DAISY.get(), 60, 100);
        registerFlammableBlock(RuBlocks.FELICIA_DAISY.get(), 60, 100);
        registerFlammableBlock(RuBlocks.FIREWEED.get(), 60, 100);
        registerFlammableBlock(RuBlocks.HIBISCUS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.HYSSOP.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MALLOW.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PINK_LUPINE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.POPPY_BUSH.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SALMON_POPPY_BUSH.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PURPLE_LUPINE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.RED_LUPINE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WARATAH.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WHITE_TRILLIUM.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WILTING_TRILLIUM.get(), 60, 100);
        registerFlammableBlock(RuBlocks.YELLOW_LUPINE.get(), 60, 100);

        registerFlammableBlock(RuBlocks.ORANGE_CONEFLOWER.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PURPLE_CONEFLOWER.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CLOVER.get(), 60, 100);

        registerFlammableBlock(RuBlocks.BLUE_MAGNOLIA_FLOWERS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PINK_MAGNOLIA_FLOWERS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WHITE_MAGNOLIA_FLOWERS.get(), 60, 100);
        //SNOWBELLE
        registerFlammableBlock(RuBlocks.RED_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ORANGE_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.YELLOW_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.LIME_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.GREEN_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CYAN_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.LIGHT_BLUE_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLUE_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PURPLE_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MAGENTA_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PINK_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BROWN_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WHITE_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.LIGHT_GRAY_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.GRAY_SNOWBELLE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLACK_SNOWBELLE.get(), 60, 100);

        registerFlammableBlock(RuBlocks.MAPLE_LEAF_PILE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.RED_MAPLE_LEAF_PILE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ORANGE_MAPLE_LEAF_PILE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SILVER_BIRCH_LEAF_PILE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ENCHANTED_BIRCH_LEAF_PILE.get(), 60, 100);
        //TALL_PLANTS
        registerFlammableBlock(RuBlocks.MEADOW_SAGE.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BARLEY.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CATTAIL.get(), 60, 100);
        registerFlammableBlock(RuBlocks.TASSEL.get(), 60, 100);
        registerFlammableBlock(RuBlocks.TSUBAKI.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DAY_LILY.get(), 60, 100);
        //SAPLINGS
        registerFlammableBlock(RuBlocks.ALPHA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.APPLE_OAK_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BAMBOO_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BAOBAB_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLACKWOOD_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CACTUS_FLOWER.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CYPRESS_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.FLOWERING_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.GOLDEN_LARCH_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.JOSHUA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.KAPOK_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.LARCH_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MAGNOLIA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MAPLE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MAUVE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ORANGE_MAPLE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PALM_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PINE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLUE_MAGNOLIA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PINK_MAGNOLIA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.REDWOOD_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.RED_MAPLE_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ENCHANTED_BIRCH_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SILVER_BIRCH_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SMALL_OAK_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SOCOTRA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WHITE_MAGNOLIA_SAPLING.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WILLOW_SAPLING.get(), 60, 100);
        //SHRUBS
        registerFlammableBlock(RuBlocks.ACACIA_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BAOBAB_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BIRCH_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLACKWOOD_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CHERRY_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CYPRESS_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DARK_OAK_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.FLOWERING_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.GOLDEN_LARCH_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.JOSHUA_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.JUNGLE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.KAPOK_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.LARCH_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MAGNOLIA_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MANGROVE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MAPLE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.MAUVE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.OAK_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ORANGE_MAPLE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PALM_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PINE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.BLUE_MAGNOLIA_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.PINK_MAGNOLIA_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.REDWOOD_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.RED_MAPLE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.ENCHANTED_BIRCH_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SILVER_BIRCH_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SOCOTRA_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SPRUCE_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WHITE_MAGNOLIA_SHRUB.get(), 60, 100);
        registerFlammableBlock(RuBlocks.WILLOW_SHRUB.get(), 60, 100);
        //MUSHROOMS
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RuBlocks.TALL_BLUE_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RuBlocks.TALL_GREEN_BIOSHROOM.get(), 30, 60);
        registerFlammableBlock(RuBlocks.TALL_PINK_BIOSHROOM.get(), 30, 60);

        registerFlammableBlock(RuBlocks.BARREL_CACTUS.get(), 60, 100);
        registerFlammableBlock(RuBlocks.CAVE_HYSSOP.get(), 60, 100);
        registerFlammableBlock(RuBlocks.DUCKWEED.get(), 60, 100);
        registerFlammableBlock(RuBlocks.SPANISH_MOSS.get(), 15, 100);
        registerFlammableBlock(RuBlocks.SPANISH_MOSS_PLANT.get(), 15, 100);
        registerFlammableBlock(RuBlocks.KAPOK_VINES.get(), 15, 100);
        registerFlammableBlock(RuBlocks.KAPOK_VINES_PLANT.get(), 15, 100);
        registerFlammableBlock(RuBlocks.FLOWERING_LILY_PAD.get(), 15, 100);
        registerFlammableBlock(RuBlocks.GIANT_LILY_PAD.get(), 15, 100);
        //FOOD_PLANT_BLOCKS
        registerFlammableBlock(RuBlocks.SALMONBERRY_BUSH.get(), 60, 100);
        /*-----------------PLANT_BLOCKS-----------------*/
        //MUSHROOMS
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RuBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RuBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM_BLOCK.get(), 30, 60);
        registerFlammableBlock(RuBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get(), 30, 60);
        //BAMBOO
        registerFlammableBlock(RuBlocks.BAMBOO_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_BAMBOO_LOG.get(), 5, 5);
        //OAK_LOG
        registerFlammableBlock(RuBlocks.SMALL_OAK_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_SMALL_OAK_LOG.get(), 5, 5);
        //CACTUS
        registerFlammableBlock(RuBlocks.SAGUARO_CACTUS.get(), 5, 5);

        /*-----------------LEAVES-----------------*/
        registerFlammableBlock(RuBlocks.ALPHA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.APPLE_OAK_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.BAMBOO_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.BAOBAB_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.BLACKWOOD_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.MAGNOLIA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.CYPRESS_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.FLOWERING_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.GOLDEN_LARCH_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.JOSHUA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.KAPOK_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.LARCH_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.MAPLE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.MAUVE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.ORANGE_MAPLE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.PALM_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.PINE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.BLUE_MAGNOLIA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.PINK_MAGNOLIA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.REDWOOD_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.RED_MAPLE_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.SMALL_OAK_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.SILVER_BIRCH_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.SOCOTRA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.ENCHANTED_BIRCH_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.WHITE_MAGNOLIA_LEAVES.get(), 30, 60);
        registerFlammableBlock(RuBlocks.WILLOW_LEAVES.get(), 30, 60);

        /*-----------------BRANCHES-----------------*/
        registerFlammableBlock(RuBlocks.ACACIA_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.BAOBAB_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.BIRCH_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.BLACKWOOD_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.MAGNOLIA_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.CYPRESS_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.CHERRY_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.DARK_OAK_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.JOSHUA_BEARD.get(), 30, 100);
        registerFlammableBlock(RuBlocks.JUNGLE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.KAPOK_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.LARCH_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.MANGROVE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.MAPLE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.MAUVE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.OAK_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.PALM_BEARD.get(), 30, 100);
        registerFlammableBlock(RuBlocks.PINE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.REDWOOD_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.SILVER_BIRCH_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.SOCOTRA_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.SPRUCE_BRANCH.get(), 30, 100);
        registerFlammableBlock(RuBlocks.WILLOW_BRANCH.get(), 30, 100);
        /*-----------------WOOD_TYPES-----------------*/
        //SILVER_BIRCH_BLOCKS
        registerFlammableBlock(RuBlocks.SILVER_BIRCH_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.SILVER_BIRCH_WOOD.get(), 5, 5);
        //ALPHA_BLOCKS
        registerFlammableBlock(RuBlocks.ALPHA_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.ALPHA_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.ALPHA_STAIRS.get(), 5, 20);
        //BAOBAB_BLOCKS
        registerFlammableBlock(RuBlocks.BAOBAB_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_BAOBAB_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.BAOBAB_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_BAOBAB_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.BAOBAB_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BAOBAB_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BAOBAB_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BAOBAB_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BAOBAB_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BAOBAB_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BAOBAB_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BAOBAB_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BAOBAB_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BAOBAB_WALL_SIGN.get(), 5, 20);
        //BLACKWOOD_BLOCKS
        registerFlammableBlock(RuBlocks.BLACKWOOD_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_BLACKWOOD_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.BLACKWOOD_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_BLACKWOOD_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.BLACKWOOD_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLACKWOOD_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLACKWOOD_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLACKWOOD_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLACKWOOD_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLACKWOOD_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLACKWOOD_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLACKWOOD_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLACKWOOD_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLACKWOOD_WALL_SIGN.get(), 5, 20);
        //BLUE_BIOSHROOM_BLOCKS
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM_STEM.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_BLUE_BIOSHROOM_STEM.get(), 5, 5);
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM_HYPHAE.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_BLUE_BIOSHROOM_HYPHAE.get(), 5, 5);
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLUE_BIOSHROOM_WALL_SIGN.get(), 5, 20);
        //CYPRESS_BLOCKS
        registerFlammableBlock(RuBlocks.CYPRESS_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_CYPRESS_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.CYPRESS_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_CYPRESS_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.CYPRESS_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.CYPRESS_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.CYPRESS_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.CYPRESS_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.CYPRESS_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.CYPRESS_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.CYPRESS_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.CYPRESS_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.CYPRESS_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.CYPRESS_WALL_SIGN.get(), 5, 20);
        //EUCALYPTUS_BLOCKS
        registerFlammableBlock(RuBlocks.EUCALYPTUS_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_EUCALYPTUS_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_EUCALYPTUS_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.EUCALYPTUS_WALL_SIGN.get(), 5, 20);
        //GREEN_BIOSHROOM_BLOCKS
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM_STEM.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_GREEN_BIOSHROOM_STEM.get(), 5, 5);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM_HYPHAE.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_GREEN_BIOSHROOM_HYPHAE.get(), 5, 5);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GREEN_BIOSHROOM_WALL_SIGN.get(), 5, 20);
        //JOSHUA_BLOCKS
        registerFlammableBlock(RuBlocks.JOSHUA_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_JOSHUA_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.JOSHUA_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_JOSHUA_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.JOSHUA_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.JOSHUA_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.JOSHUA_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.JOSHUA_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.JOSHUA_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.JOSHUA_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.JOSHUA_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.JOSHUA_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.JOSHUA_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.JOSHUA_WALL_SIGN.get(), 5, 20);
        //KAPOK_BLOCKS
        registerFlammableBlock(RuBlocks.KAPOK_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_KAPOK_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.KAPOK_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_KAPOK_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.KAPOK_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.KAPOK_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.KAPOK_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.KAPOK_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.KAPOK_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.KAPOK_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.KAPOK_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.KAPOK_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.KAPOK_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.KAPOK_WALL_SIGN.get(), 5, 20);
        //LARCH_BLOCKS
        registerFlammableBlock(RuBlocks.LARCH_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_LARCH_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.LARCH_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_LARCH_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.LARCH_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LARCH_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LARCH_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LARCH_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LARCH_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LARCH_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LARCH_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LARCH_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LARCH_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LARCH_WALL_SIGN.get(), 5, 20);
        //MAGNOLIA_BLOCKS
        registerFlammableBlock(RuBlocks.MAGNOLIA_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_MAGNOLIA_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.MAGNOLIA_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_MAGNOLIA_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.MAGNOLIA_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAGNOLIA_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAGNOLIA_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAGNOLIA_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAGNOLIA_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAGNOLIA_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAGNOLIA_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAGNOLIA_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAGNOLIA_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAGNOLIA_WALL_SIGN.get(), 5, 20);
        //MAPLE_BLOCKS
        registerFlammableBlock(RuBlocks.MAPLE_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_MAPLE_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.MAPLE_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_MAPLE_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.MAPLE_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAPLE_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAPLE_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAPLE_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAPLE_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAPLE_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAPLE_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAPLE_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAPLE_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAPLE_WALL_SIGN.get(), 5, 20);
        //MAUVE_BLOCKS
        registerFlammableBlock(RuBlocks.MAUVE_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_MAUVE_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.MAUVE_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_MAUVE_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.MAUVE_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAUVE_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAUVE_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAUVE_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAUVE_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAUVE_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAUVE_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAUVE_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAUVE_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAUVE_WALL_SIGN.get(), 5, 20);
        //PALM_BLOCKS
        registerFlammableBlock(RuBlocks.PALM_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_PALM_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.PALM_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_PALM_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.PALM_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PALM_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PALM_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PALM_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PALM_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PALM_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PALM_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PALM_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PALM_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PALM_WALL_SIGN.get(), 5, 20);
        //PINE_BLOCKS
        registerFlammableBlock(RuBlocks.PINE_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_PINE_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.PINE_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_PINE_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.PINE_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINE_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINE_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINE_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINE_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINE_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINE_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINE_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINE_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINE_WALL_SIGN.get(), 5, 20);
        //PINK_BIOSHROOM_BLOCKS
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM_STEM.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_PINK_BIOSHROOM_STEM.get(), 5, 5);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM_HYPHAE.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_PINK_BIOSHROOM_HYPHAE.get(), 5, 5);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINK_BIOSHROOM_WALL_SIGN.get(), 5, 20);
        //REDWOOD_BLOCKS
        registerFlammableBlock(RuBlocks.REDWOOD_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_REDWOOD_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.REDWOOD_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_REDWOOD_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.REDWOOD_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.REDWOOD_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.REDWOOD_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.REDWOOD_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.REDWOOD_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.REDWOOD_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.REDWOOD_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.REDWOOD_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.REDWOOD_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.REDWOOD_WALL_SIGN.get(), 5, 20);
        //SOCOTRA_BLOCKS
        registerFlammableBlock(RuBlocks.SOCOTRA_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_SOCOTRA_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.SOCOTRA_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_SOCOTRA_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.SOCOTRA_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.SOCOTRA_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.SOCOTRA_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.SOCOTRA_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.SOCOTRA_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.SOCOTRA_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.SOCOTRA_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.SOCOTRA_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.SOCOTRA_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.SOCOTRA_WALL_SIGN.get(), 5, 20);
        //WILLOW_BLOCKS
        registerFlammableBlock(RuBlocks.WILLOW_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_WILLOW_LOG.get(), 5, 5);
        registerFlammableBlock(RuBlocks.WILLOW_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.STRIPPED_WILLOW_WOOD.get(), 5, 5);
        registerFlammableBlock(RuBlocks.WILLOW_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.WILLOW_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.WILLOW_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.WILLOW_FENCE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.WILLOW_DOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.WILLOW_FENCE_GATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.WILLOW_TRAPDOOR.get(), 5, 20);
        registerFlammableBlock(RuBlocks.WILLOW_PRESSURE_PLATE.get(), 5, 20);
        registerFlammableBlock(RuBlocks.WILLOW_SIGN.get(), 5, 20);
        registerFlammableBlock(RuBlocks.WILLOW_WALL_SIGN.get(), 5, 20);

        /*-----------------PAINTED PLANKS-----------------*/
        //PLANKS
        registerFlammableBlock(RuBlocks.RED_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.ORANGE_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.YELLOW_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LIME_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GREEN_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.CYAN_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LIGHT_BLUE_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLUE_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PURPLE_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAGENTA_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINK_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BROWN_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.WHITE_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LIGHT_GRAY_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GRAY_PAINTED_PLANKS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLACK_PAINTED_PLANKS.get(), 5, 20);
        //STAIRS
        registerFlammableBlock(RuBlocks.RED_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.ORANGE_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.YELLOW_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LIME_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GREEN_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.CYAN_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LIGHT_BLUE_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLUE_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PURPLE_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAGENTA_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINK_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BROWN_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.WHITE_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LIGHT_GRAY_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GRAY_PAINTED_STAIRS.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLACK_PAINTED_STAIRS.get(), 5, 20);
        //SLABS
        registerFlammableBlock(RuBlocks.RED_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.ORANGE_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.YELLOW_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LIME_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GREEN_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.CYAN_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LIGHT_BLUE_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLUE_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PURPLE_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.MAGENTA_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.PINK_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BROWN_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.WHITE_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.LIGHT_GRAY_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.GRAY_PAINTED_SLAB.get(), 5, 20);
        registerFlammableBlock(RuBlocks.BLACK_PAINTED_SLAB.get(), 5, 20);
    }

    public static void registerFlammableBlock(Block block, int spreadSpeed, int flammability) {
        FireBlock fireblock = (FireBlock)Blocks.FIRE;
        fireblock.setFlammable(block, spreadSpeed, flammability);
    }
}
