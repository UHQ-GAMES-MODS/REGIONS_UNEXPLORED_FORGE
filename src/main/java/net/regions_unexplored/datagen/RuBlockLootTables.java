package net.regions_unexplored.datagen;

import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.item.RuItems;
import net.regions_unexplored.world.level.block.plant.food.SalmonBerryBushBlock;

import java.util.Set;

public class RuBlockLootTables extends BlockLootSubProvider {
    private static final LootItemCondition.Builder HAS_SHEARS_OR_SILK_TOUCH = HAS_SHEARS.or(HAS_SILK_TOUCH);
    private static final LootItemCondition.Builder HAS_NO_SHEARS_OR_SILK_TOUCH = HAS_SHEARS_OR_SILK_TOUCH.invert();

    public RuBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        /*-----------------CAVE_BLOCKS-----------------*/
        //PRISMA_BLOCKS
        add(RuBlocks.PRISMOSS.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.STONE));
        add(RuBlocks.DEEPSLATE_PRISMOSS.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.DEEPSLATE));
        dropSelf(RuBlocks.HANGING_PRISMARITE.get());
        add(RuBlocks.LARGE_PRISMARITE_CLUSTER.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PRISMAGLASS.get(), (block) -> createSilkTouchOnlyTable(block));
        dropSelf(RuBlocks.PRISMARITE_CLUSTER.get());
        add(RuBlocks.PRISMOSS_SPROUT.get(), (block) -> createShearsOnlyDrop(block));
        //REDSTONE_BLOCKS
        dropSelf(RuBlocks.POINTED_REDSTONE.get());
        dropSelf(RuBlocks.RAW_REDSTONE_BLOCK.get());
        add(RuBlocks.REDSTONE_BUD.get(), (block) -> createSilkTouchDispatchTable(block, this.applyExplosionDecay(block, LootItem.lootTableItem(Items.REDSTONE).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))))));
        dropSelf(RuBlocks.REDSTONE_BULB.get());
        //OTHER_CAVE_BLOCKS
        add(RuBlocks.STONE_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.STONE));
        add(RuBlocks.DEEPSLATE_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.DEEPSLATE));
        add(RuBlocks.VIRIDESCENT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.STONE));
        add(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.DEEPSLATE));

        /*-----------------PLANTS-----------------*/
        //GRASS_BLOCKS
        dropSelf(RuBlocks.DEAD_STEPPE_SHRUB.get());
        add(RuBlocks.ASHEN_GRASS.get(), (block) -> createGrassDrops(block));
        add(RuBlocks.FROZEN_GRASS.get(), (block) -> createGrassDrops(block));
        add(RuBlocks.MEDIUM_GRASS.get(), (block) -> createGrassDrops(block));
        add(RuBlocks.SANDY_GRASS.get(), (block) -> createGrassDrops(block));
        add(RuBlocks.SEEDED_GRASS.get(), (block) -> createGrassDrops(block));
        add(RuBlocks.SMALL_DESERT_SHRUB.get(), (block) -> createShearsOnlyDrop(block));
        add(RuBlocks.STEPPE_GRASS.get(), (block) -> createGrassDrops(block));
        add(RuBlocks.STEPPE_SHRUB.get(), (block) -> createGrassDrops(block));
        add(RuBlocks.STONE_BUD.get(), (block) -> createGrassDrops(block));
        //TALL_GRASS_BLOCKS
        add(RuBlocks.ELEPHANT_EAR.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SANDY_TALL_GRASS.get(), (block) -> createDoublePlantWithSeedDrops(block, RuBlocks.SANDY_GRASS.get()));
        add(RuBlocks.SEEDED_TALL_GRASS.get(), (block) -> createDoublePlantWithSeedDrops(block, RuBlocks.SEEDED_GRASS.get()));
        add(RuBlocks.STEPPE_TALL_GRASS.get(), (block) -> createDoublePlantWithSeedDrops(block, RuBlocks.STEPPE_GRASS.get()));
        add(RuBlocks.WINDSWEPT_GRASS.get(), (block) -> createDoublePlantWithSeedDropsNoGrass(block, RuBlocks.WINDSWEPT_GRASS.get()));
        //FLOWERS
        dropSelf(RuBlocks.ALPHA_DANDELION.get());
        dropSelf(RuBlocks.ALPHA_ROSE.get());
        dropSelf(RuBlocks.BLUE_LUPINE.get());
        dropSelf(RuBlocks.DAISY.get());
        dropSelf(RuBlocks.DORCEL.get());
        dropSelf(RuBlocks.FELICIA_DAISY.get());
        dropSelf(RuBlocks.FIREWEED.get());
        dropSelf(RuBlocks.HYSSOP.get());
        dropSelf(RuBlocks.PINK_LUPINE.get());
        dropSelf(RuBlocks.POPPY_BUSH.get());
        dropSelf(RuBlocks.PURPLE_LUPINE.get());
        dropSelf(RuBlocks.RED_LUPINE.get());
        dropSelf(RuBlocks.WARATAH.get());
        dropSelf(RuBlocks.WHITE_TRILLIUM.get());
        dropSelf(RuBlocks.WILTING_TRILLIUM.get());
        dropSelf(RuBlocks.YELLOW_LUPINE.get());

        add(RuBlocks.ORANGE_CONEFLOWER.get(), (block) -> createPetalsDrops(block));
        add(RuBlocks.PURPLE_CONEFLOWER.get(), (block) -> createPetalsDrops(block));
        add(RuBlocks.SAKURA_PETALS.get(), (block) -> createPetalsDrops(block));

        add(RuBlocks.RED_SAKURA_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        add(RuBlocks.PINK_SAKURA_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        add(RuBlocks.WHITE_SAKURA_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        //TALL_PLANTS
        add(RuBlocks.MEADOW_SAGE.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BARLEY.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.CATTAIL.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.TASSEL.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.TSUBAKI.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //SAPLINGS
        dropSelf(RuBlocks.ALPHA_SAPLING.get());
        dropSelf(RuBlocks.APPLE_OAK_SAPLING.get());
        dropSelf(RuBlocks.BAMBOO_SAPLING.get());
        dropSelf(RuBlocks.BAOBAB_SAPLING.get());
        dropSelf(RuBlocks.BLACKWOOD_SAPLING.get());
        dropSelf(RuBlocks.CACTUS_FLOWER.get());
        dropSelf(RuBlocks.SAKURA_SAPLING.get());
        dropSelf(RuBlocks.CYPRESS_SAPLING.get());
        dropSelf(RuBlocks.DEAD_PINE_SAPLING.get());
        dropSelf(RuBlocks.DEAD_SAPLING.get());
        dropSelf(RuBlocks.EUCALYPTUS_SAPLING.get());
        dropSelf(RuBlocks.FLOWERING_SAPLING.get());
        dropSelf(RuBlocks.GOLDEN_LARCH_SAPLING.get());
        dropSelf(RuBlocks.JOSHUA_SAPLING.get());
        dropSelf(RuBlocks.LARCH_SAPLING.get());
        dropSelf(RuBlocks.MAPLE_SAPLING.get());
        dropSelf(RuBlocks.MAUVE_SAPLING.get());
        dropSelf(RuBlocks.ORANGE_MAPLE_SAPLING.get());
        dropSelf(RuBlocks.PALM_SAPLING.get());
        dropSelf(RuBlocks.PINE_SAPLING.get());
        dropSelf(RuBlocks.PINK_SAKURA_SAPLING.get());
        dropSelf(RuBlocks.REDWOOD_SAPLING.get());
        dropSelf(RuBlocks.RED_SAKURA_SAPLING.get());
        dropSelf(RuBlocks.RED_MAPLE_SAPLING.get());
        dropSelf(RuBlocks.BRIMWOOD_SAPLING.get());
        dropSelf(RuBlocks.SILVER_BIRCH_SAPLING.get());
        dropSelf(RuBlocks.WHITE_SAKURA_SAPLING.get());
        dropSelf(RuBlocks.WILLOW_SAPLING.get());
        //SHRUBS
        add(RuBlocks.ASHEN_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.ACACIA_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BAOBAB_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BIRCH_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BLACKWOOD_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SAKURA_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.CYPRESS_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DARK_OAK_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DEAD_PINE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DEAD_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.EUCALYPTUS_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.FLOWERING_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.GOLDEN_LARCH_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.JOSHUA_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.JUNGLE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.LARCH_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MANGROVE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MAPLE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MAUVE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.OAK_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.ORANGE_MAPLE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PALM_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PINE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PINK_SAKURA_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.REDWOOD_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.RED_SAKURA_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.RED_MAPLE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SILVER_BIRCH_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SPRUCE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.WHITE_SAKURA_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.WILLOW_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //MUSHROOMS
        dropSelf(RuBlocks.BLUE_BIOSHROOM.get());
        dropSelf(RuBlocks.GREEN_BIOSHROOM.get());
        dropSelf(RuBlocks.PINK_BIOSHROOM.get());
        dropSelf(RuBlocks.YELLOW_BIOSHROOM.get());
        add(RuBlocks.TALL_BLUE_BIOSHROOM.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.TALL_GREEN_BIOSHROOM.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.TALL_PINK_BIOSHROOM.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.TALL_YELLOW_BIOSHROOM.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //OTHER_PLANT_BLOCKS
        dropSelf(RuBlocks.BARREL_CACTUS.get());
        dropSelf(RuBlocks.CAVE_HYSSOP.get());
        dropSelf(RuBlocks.DUCKWEED.get());
        add(RuBlocks.SPANISH_MOSS.get(), (block) -> createShearsOnlyDrop(block));
        add(RuBlocks.SPANISH_MOSS_PLANT.get(), (block) -> createShearsOnlyDrop(block));
        dropSelf(RuBlocks.FLOWERING_LILY_PAD.get());
        add(RuBlocks.GIANT_LILY_PAD.get(), (block) -> createSingleItemTable(RuBlocks.FLOWERING_LILY_PAD.get()));
        //FOOD_PLANT_BLOCKS
        add(RuBlocks.SALMONBERRY_BUSH.get(), (block) -> applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RuBlocks.SALMONBERRY_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SalmonBerryBushBlock.AGE, 3))).add(LootItem.lootTableItem(RuItems.SALMONBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RuBlocks.SALMONBERRY_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))).add(LootItem.lootTableItem(RuItems.SALMONBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));

        /*-----------------POTTED_PLANTS-----------------*/
        //POTTED_FLOWERS
        add(RuBlocks.POTTED_ALPHA_DANDELION.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ALPHA_ROSE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLUE_LUPINE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DAISY.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DORCEL.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_FELICIA_DAISY.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_FIREWEED.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_HYSSOP.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PINK_LUPINE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_POPPY_BUSH.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PURPLE_LUPINE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_RED_LUPINE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WARATAH.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WHITE_TRILLIUM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WILTING_TRILLIUM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_YELLOW_LUPINE.get(), (block) -> createPotFlowerItemTable(block));
        //POTTED_SAPLINGS
        add(RuBlocks.POTTED_ALPHA_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_APPLE_OAK_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BAMBOO_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BAOBAB_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLACKWOOD_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_CACTUS_FLOWER.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_SAKURA_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_CYPRESS_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DEAD_PINE_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DEAD_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_EUCALYPTUS_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_FLOWERING_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_GOLDEN_LARCH_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_JOSHUA_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_LARCH_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MAPLE_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MAUVE_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ORANGE_MAPLE_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PALM_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PINE_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PINK_SAKURA_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_REDWOOD_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_RED_SAKURA_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_RED_MAPLE_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BRIMWOOD_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_SILVER_BIRCH_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WHITE_SAKURA_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WILLOW_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        //POTTED_MUSHROOMS
        add(RuBlocks.POTTED_BLUE_BIOSHROOM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_GREEN_BIOSHROOM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PINK_BIOSHROOM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_YELLOW_BIOSHROOM.get(), (block) -> createPotFlowerItemTable(block));
        //OTHER_POTTED_PLANTS
        add(RuBlocks.POTTED_BARREL_CACTUS.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_CAVE_HYSSOP.get(), (block) -> createPotFlowerItemTable(block));

        /*-----------------PLANT_BLOCKS-----------------*/
        //MUSHROOMS
        dropSelf(RuBlocks.BLUE_BIOSHROOM_BLOCK.get());
        dropSelf(RuBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get());
        dropSelf(RuBlocks.GREEN_BIOSHROOM_BLOCK.get());
        dropSelf(RuBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get());
        dropSelf(RuBlocks.PINK_BIOSHROOM_BLOCK.get());
        dropSelf(RuBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get());
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_BLOCK.get());
        dropSelf(RuBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get());
        //BAMBOO
        dropSelf(RuBlocks.BAMBOO_LOG.get());
        dropSelf(RuBlocks.STRIPPED_BAMBOO_LOG.get());
        //CACTUS
        dropSelf(RuBlocks.SAGUARO_CACTUS.get());

        /*-----------------LEAVES-----------------*/
        add(RuBlocks.ALPHA_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.APPLE_OAK_LEAVES.get(), (block) -> createOakLeavesDrops(block, RuBlocks.APPLE_OAK_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.ASHEN_LEAVES.get(), (block) -> createShearsOnlyDrop(block));
        add(RuBlocks.BAMBOO_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.BAMBOO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BAOBAB_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.BAOBAB_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BLACKWOOD_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.BLACKWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.SAKURA_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.SAKURA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.CYPRESS_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.CYPRESS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.DEAD_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.DEAD_PINE_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.EUCALYPTUS_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.FLOWERING_LEAVES.get(), (block) -> createOakLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.GOLDEN_LARCH_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.JOSHUA_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.LARCH_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.MAPLE_LEAVES.get(), (block) -> createOakLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.MAUVE_LEAVES.get(), (block) -> createOakLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.ORANGE_MAPLE_LEAVES.get(), (block) -> createOakLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.PALM_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.PINE_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.PINK_SAKURA_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.REDWOOD_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.RED_SAKURA_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.RED_MAPLE_LEAVES.get(), (block) -> createOakLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BRIMWOOD_LEAVES.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(RuBlocks.BRIMWOOD_SAPLING.get())).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, NORMAL_LEAVES_SAPLING_CHANCES))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)));
        add(RuBlocks.SILVER_BIRCH_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.WHITE_SAKURA_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.WILLOW_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        /*-----------------BRANCHES-----------------*/
        add(RuBlocks.ACACIA_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.BAOBAB_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.BIRCH_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.BLACKWOOD_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.SAKURA_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.CYPRESS_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.DARK_OAK_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.DEAD_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.EUCALYPTUS_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.JOSHUA_BEARD.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.JUNGLE_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.LARCH_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MANGROVE_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MAPLE_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MAUVE_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.OAK_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.PALM_BEARD.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.PINE_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.REDWOOD_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.SILVER_BIRCH_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.SPRUCE_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.WILLOW_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));

        /*-----------------DIRT_BLOCKS-----------------*/
        //FOREST_DIRT_BLOCKS
        add(RuBlocks.FOREST_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.FOREST_DIRT.get()));
        dropSelf(RuBlocks.FOREST_DIRT.get());
        add(RuBlocks.FOREST_DIRT_PATH.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.FOREST_DIRT.get()));
        dropSelf(RuBlocks.FOREST_COARSE_DIRT.get());
        dropSelf(RuBlocks.FOREST_MUD.get());
        add(RuBlocks.FOREST_FARMLAND.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.FOREST_DIRT.get()));
        //PLAINS_DIRT_BLOCKS
        add(RuBlocks.PLAINS_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.PLAINS_DIRT.get()));
        dropSelf(RuBlocks.PLAINS_DIRT.get());
        add(RuBlocks.PLAINS_DIRT_PATH.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.PLAINS_DIRT.get()));
        dropSelf(RuBlocks.PLAINS_COARSE_DIRT.get());
        dropSelf(RuBlocks.PLAINS_MUD.get());
        add(RuBlocks.PLAINS_FARMLAND.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.PLAINS_DIRT.get()));
        //OTHER_DIRT_BLOCKS
        add(RuBlocks.ALPHA_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.DIRT));
        dropSelf(RuBlocks.ASHEN_DIRT.get());

        /*-----------------STONE_BLOCKS-----------------*/
        //CHALKS
        dropSelf(RuBlocks.CHALK.get());
        add(RuBlocks.CHALK_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.CHALK.get()));
        dropSelf(RuBlocks.CHALK_BRICKS.get());
        add(RuBlocks.CHALK_BRICK_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.CHALK_BRICK_STAIRS.get());
        dropSelf(RuBlocks.CHALK_PILLAR.get());
        add(RuBlocks.CHALK_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.CHALK_STAIRS.get());
        dropSelf(RuBlocks.POLISHED_CHALK.get());
        add(RuBlocks.POLISHED_CHALK_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.POLISHED_CHALK_STAIRS.get());
        //MOSSY_STONES
        add(RuBlocks.MOSSY_STONE.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.MOSSY_COBBLESTONE));

        /*-----------------OCEAN_BLOCKS-----------------*/
        //HYACINTH_BLOCKS
        dropSelf(RuBlocks.HYACINTH_BLOOM.get());
        add(RuBlocks.HYACINTH_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        dropSelf(RuBlocks.HYACINTH_SEAGRASS.get());
        dropSelf(RuBlocks.HYACINTH_STONE.get());
        dropSelf(RuBlocks.TALL_HYACINTH_STOCK.get());

        /*-----------------OTHER_BLOCKS-----------------*/
        add(RuBlocks.ASH.get(), (block) -> createSilkTouchDispatchTable(block, this.applyExplosionCondition(Items.FLINT, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.SILK_TOUCH, 1.0F)).otherwise(LootItem.lootTableItem(Items.FLINT)))));
        add(RuBlocks.VOLCANIC_ASH.get(), (block) -> createSilkTouchDispatchTable(block, this.applyExplosionCondition(Items.FLINT, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.SILK_TOUCH, 1.0F)).otherwise(LootItem.lootTableItem(Items.FLINT)))));
        dropSelf(RuBlocks.ASH_VENT.get());
        dropSelf(RuBlocks.QUICKSAND.get());

        /*-----------------WOOD_TYPES-----------------*/
        //ASHEN_BLOCKS
        dropSelf(RuBlocks.ASHEN_LOG.get());
        dropSelf(RuBlocks.ASHEN_WOOD.get());
        //SILVER_BIRCH_BLOCKS
        dropSelf(RuBlocks.SILVER_BIRCH_LOG.get());
        dropSelf(RuBlocks.SILVER_BIRCH_WOOD.get());
        //ALPHA_BLOCKS
        dropSelf(RuBlocks.ALPHA_LOG.get());
        dropSelf(RuBlocks.ALPHA_PLANKS.get());
        dropSelf(RuBlocks.ALPHA_STAIRS.get());
        add(RuBlocks.ALPHA_SLAB.get(), (block) -> createSlabItemTable(block));
        //BAOBAB_BLOCKS
        dropSelf(RuBlocks.BAOBAB_LOG.get());
        dropSelf(RuBlocks.STRIPPED_BAOBAB_LOG.get());
        dropSelf(RuBlocks.BAOBAB_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_BAOBAB_WOOD.get());
        dropSelf(RuBlocks.BAOBAB_PLANKS.get());
        dropSelf(RuBlocks.BAOBAB_STAIRS.get());
        add(RuBlocks.BAOBAB_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.BAOBAB_FENCE.get());
        add(RuBlocks.BAOBAB_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.BAOBAB_FENCE_GATE.get());
        dropSelf(RuBlocks.BAOBAB_TRAPDOOR.get());
        dropSelf(RuBlocks.BAOBAB_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.BAOBAB_BUTTON.get());
        dropSelf(RuBlocks.BAOBAB_SIGN.get());
        add(RuBlocks.BAOBAB_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.BAOBAB_SIGN.get()));
        //BLACKWOOD_BLOCKS
        dropSelf(RuBlocks.BLACKWOOD_LOG.get());
        dropSelf(RuBlocks.STRIPPED_BLACKWOOD_LOG.get());
        dropSelf(RuBlocks.BLACKWOOD_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_BLACKWOOD_WOOD.get());
        dropSelf(RuBlocks.BLACKWOOD_PLANKS.get());
        dropSelf(RuBlocks.BLACKWOOD_STAIRS.get());
        add(RuBlocks.BLACKWOOD_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.BLACKWOOD_FENCE.get());
        add(RuBlocks.BLACKWOOD_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.BLACKWOOD_FENCE_GATE.get());
        dropSelf(RuBlocks.BLACKWOOD_TRAPDOOR.get());
        dropSelf(RuBlocks.BLACKWOOD_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.BLACKWOOD_BUTTON.get());
        dropSelf(RuBlocks.BLACKWOOD_SIGN.get());
        add(RuBlocks.BLACKWOOD_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.BLACKWOOD_SIGN.get()));
        //BRIMWOOD_BLOCKS
        dropSelf(RuBlocks.BRIMWOOD_LOG.get());
        dropSelf(RuBlocks.BRIMWOOD_LOG_MAGMA.get());
        dropSelf(RuBlocks.STRIPPED_BRIMWOOD_LOG.get());
        dropSelf(RuBlocks.BRIMWOOD_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_BRIMWOOD_WOOD.get());
        dropSelf(RuBlocks.BRIMWOOD_PLANKS.get());
        dropSelf(RuBlocks.BRIMWOOD_STAIRS.get());
        add(RuBlocks.BRIMWOOD_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.BRIMWOOD_FENCE.get());
        add(RuBlocks.BRIMWOOD_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.BRIMWOOD_FENCE_GATE.get());
        dropSelf(RuBlocks.BRIMWOOD_TRAPDOOR.get());
        dropSelf(RuBlocks.BRIMWOOD_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.BRIMWOOD_BUTTON.get());
        dropSelf(RuBlocks.BRIMWOOD_SIGN.get());
        add(RuBlocks.BRIMWOOD_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.BRIMWOOD_SIGN.get()));
        //CHERRY_BLOCKS
        dropSelf(RuBlocks.SAKURA_LOG.get());
        dropSelf(RuBlocks.STRIPPED_SAKURA_LOG.get());
        dropSelf(RuBlocks.SAKURA_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_SAKURA_WOOD.get());
        dropSelf(RuBlocks.SAKURA_PLANKS.get());
        dropSelf(RuBlocks.SAKURA_STAIRS.get());
        add(RuBlocks.SAKURA_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.SAKURA_FENCE.get());
        add(RuBlocks.SAKURA_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.SAKURA_FENCE_GATE.get());
        dropSelf(RuBlocks.SAKURA_TRAPDOOR.get());
        dropSelf(RuBlocks.SAKURA_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.SAKURA_BUTTON.get());
        dropSelf(RuBlocks.SAKURA_SIGN.get());
        add(RuBlocks.SAKURA_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.SAKURA_SIGN.get()));
        //CYPRESS_BLOCKS
        dropSelf(RuBlocks.CYPRESS_LOG.get());
        dropSelf(RuBlocks.STRIPPED_CYPRESS_LOG.get());
        dropSelf(RuBlocks.CYPRESS_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_CYPRESS_WOOD.get());
        dropSelf(RuBlocks.CYPRESS_PLANKS.get());
        dropSelf(RuBlocks.CYPRESS_STAIRS.get());
        add(RuBlocks.CYPRESS_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.CYPRESS_FENCE.get());
        add(RuBlocks.CYPRESS_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.CYPRESS_FENCE_GATE.get());
        dropSelf(RuBlocks.CYPRESS_TRAPDOOR.get());
        dropSelf(RuBlocks.CYPRESS_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.CYPRESS_BUTTON.get());
        dropSelf(RuBlocks.CYPRESS_SIGN.get());
        add(RuBlocks.CYPRESS_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.CYPRESS_SIGN.get()));
        //DEAD_BLOCKS
        dropSelf(RuBlocks.DEAD_LOG.get());
        dropSelf(RuBlocks.STRIPPED_DEAD_LOG.get());
        dropSelf(RuBlocks.DEAD_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_DEAD_WOOD.get());
        dropSelf(RuBlocks.DEAD_PLANKS.get());
        dropSelf(RuBlocks.DEAD_STAIRS.get());
        add(RuBlocks.DEAD_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.DEAD_FENCE.get());
        add(RuBlocks.DEAD_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.DEAD_FENCE_GATE.get());
        dropSelf(RuBlocks.DEAD_TRAPDOOR.get());
        dropSelf(RuBlocks.DEAD_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.DEAD_BUTTON.get());
        dropSelf(RuBlocks.DEAD_SIGN.get());
        add(RuBlocks.DEAD_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.DEAD_SIGN.get()));
        //EUCALYPTUS_BLOCKS
        dropSelf(RuBlocks.EUCALYPTUS_LOG.get());
        dropSelf(RuBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        dropSelf(RuBlocks.EUCALYPTUS_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
        dropSelf(RuBlocks.EUCALYPTUS_PLANKS.get());
        dropSelf(RuBlocks.EUCALYPTUS_STAIRS.get());
        add(RuBlocks.EUCALYPTUS_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.EUCALYPTUS_FENCE.get());
        add(RuBlocks.EUCALYPTUS_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.EUCALYPTUS_FENCE_GATE.get());
        dropSelf(RuBlocks.EUCALYPTUS_TRAPDOOR.get());
        dropSelf(RuBlocks.EUCALYPTUS_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.EUCALYPTUS_BUTTON.get());
        dropSelf(RuBlocks.EUCALYPTUS_SIGN.get());
        add(RuBlocks.EUCALYPTUS_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.EUCALYPTUS_SIGN.get()));
        //JOSHUA_BLOCKS
        dropSelf(RuBlocks.JOSHUA_LOG.get());
        dropSelf(RuBlocks.STRIPPED_JOSHUA_LOG.get());
        dropSelf(RuBlocks.JOSHUA_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_JOSHUA_WOOD.get());
        dropSelf(RuBlocks.JOSHUA_PLANKS.get());
        dropSelf(RuBlocks.JOSHUA_STAIRS.get());
        add(RuBlocks.JOSHUA_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.JOSHUA_FENCE.get());
        add(RuBlocks.JOSHUA_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.JOSHUA_FENCE_GATE.get());
        dropSelf(RuBlocks.JOSHUA_TRAPDOOR.get());
        dropSelf(RuBlocks.JOSHUA_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.JOSHUA_BUTTON.get());
        dropSelf(RuBlocks.JOSHUA_SIGN.get());
        add(RuBlocks.JOSHUA_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.JOSHUA_SIGN.get()));
        //LARCH_BLOCKS
        dropSelf(RuBlocks.LARCH_LOG.get());
        dropSelf(RuBlocks.STRIPPED_LARCH_LOG.get());
        dropSelf(RuBlocks.LARCH_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_LARCH_WOOD.get());
        dropSelf(RuBlocks.LARCH_PLANKS.get());
        dropSelf(RuBlocks.LARCH_STAIRS.get());
        add(RuBlocks.LARCH_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.LARCH_FENCE.get());
        add(RuBlocks.LARCH_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.LARCH_FENCE_GATE.get());
        dropSelf(RuBlocks.LARCH_TRAPDOOR.get());
        dropSelf(RuBlocks.LARCH_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.LARCH_BUTTON.get());
        dropSelf(RuBlocks.LARCH_SIGN.get());
        add(RuBlocks.LARCH_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.LARCH_SIGN.get()));
        //MAPLE_BLOCKS
        dropSelf(RuBlocks.MAPLE_LOG.get());
        dropSelf(RuBlocks.STRIPPED_MAPLE_LOG.get());
        dropSelf(RuBlocks.MAPLE_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_MAPLE_WOOD.get());
        dropSelf(RuBlocks.MAPLE_PLANKS.get());
        dropSelf(RuBlocks.MAPLE_STAIRS.get());
        add(RuBlocks.MAPLE_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.MAPLE_FENCE.get());
        add(RuBlocks.MAPLE_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.MAPLE_FENCE_GATE.get());
        dropSelf(RuBlocks.MAPLE_TRAPDOOR.get());
        dropSelf(RuBlocks.MAPLE_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.MAPLE_BUTTON.get());
        dropSelf(RuBlocks.MAPLE_SIGN.get());
        add(RuBlocks.MAPLE_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.MAPLE_SIGN.get()));
        //MAUVE_BLOCKS
        dropSelf(RuBlocks.MAUVE_LOG.get());
        dropSelf(RuBlocks.STRIPPED_MAUVE_LOG.get());
        dropSelf(RuBlocks.MAUVE_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_MAUVE_WOOD.get());
        dropSelf(RuBlocks.MAUVE_PLANKS.get());
        dropSelf(RuBlocks.MAUVE_STAIRS.get());
        add(RuBlocks.MAUVE_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.MAUVE_FENCE.get());
        add(RuBlocks.MAUVE_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.MAUVE_FENCE_GATE.get());
        dropSelf(RuBlocks.MAUVE_TRAPDOOR.get());
        dropSelf(RuBlocks.MAUVE_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.MAUVE_BUTTON.get());
        dropSelf(RuBlocks.MAUVE_SIGN.get());
        add(RuBlocks.MAUVE_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.MAUVE_SIGN.get()));
        //PALM_BLOCKS
        dropSelf(RuBlocks.PALM_LOG.get());
        dropSelf(RuBlocks.STRIPPED_PALM_LOG.get());
        dropSelf(RuBlocks.PALM_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_PALM_WOOD.get());
        dropSelf(RuBlocks.PALM_PLANKS.get());
        dropSelf(RuBlocks.PALM_STAIRS.get());
        add(RuBlocks.PALM_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.PALM_FENCE.get());
        add(RuBlocks.PALM_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.PALM_FENCE_GATE.get());
        dropSelf(RuBlocks.PALM_TRAPDOOR.get());
        dropSelf(RuBlocks.PALM_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.PALM_BUTTON.get());
        dropSelf(RuBlocks.PALM_SIGN.get());
        add(RuBlocks.PALM_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.PALM_SIGN.get()));
        //PINE_BLOCKS
        dropSelf(RuBlocks.PINE_LOG.get());
        dropSelf(RuBlocks.PINE_LOG_TRANSITION.get());
        dropSelf(RuBlocks.STRIPPED_PINE_LOG.get());
        dropSelf(RuBlocks.PINE_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_PINE_WOOD.get());
        dropSelf(RuBlocks.PINE_PLANKS.get());
        dropSelf(RuBlocks.PINE_STAIRS.get());
        add(RuBlocks.PINE_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.PINE_FENCE.get());
        add(RuBlocks.PINE_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.PINE_FENCE_GATE.get());
        dropSelf(RuBlocks.PINE_TRAPDOOR.get());
        dropSelf(RuBlocks.PINE_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.PINE_BUTTON.get());
        dropSelf(RuBlocks.PINE_SIGN.get());
        add(RuBlocks.PINE_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.PINE_SIGN.get()));
        //REDWOOD_BLOCKS
        dropSelf(RuBlocks.REDWOOD_LOG.get());
        dropSelf(RuBlocks.STRIPPED_REDWOOD_LOG.get());
        dropSelf(RuBlocks.REDWOOD_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_REDWOOD_WOOD.get());
        dropSelf(RuBlocks.REDWOOD_PLANKS.get());
        dropSelf(RuBlocks.REDWOOD_STAIRS.get());
        add(RuBlocks.REDWOOD_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.REDWOOD_FENCE.get());
        add(RuBlocks.REDWOOD_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.REDWOOD_FENCE_GATE.get());
        dropSelf(RuBlocks.REDWOOD_TRAPDOOR.get());
        dropSelf(RuBlocks.REDWOOD_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.REDWOOD_BUTTON.get());
        dropSelf(RuBlocks.REDWOOD_SIGN.get());
        add(RuBlocks.REDWOOD_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.REDWOOD_SIGN.get()));
        //WILLOW_BLOCKS
        dropSelf(RuBlocks.WILLOW_LOG.get());
        dropSelf(RuBlocks.STRIPPED_WILLOW_LOG.get());
        dropSelf(RuBlocks.WILLOW_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_WILLOW_WOOD.get());
        dropSelf(RuBlocks.WILLOW_PLANKS.get());
        dropSelf(RuBlocks.WILLOW_STAIRS.get());
        add(RuBlocks.WILLOW_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.WILLOW_FENCE.get());
        add(RuBlocks.WILLOW_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.WILLOW_FENCE_GATE.get());
        dropSelf(RuBlocks.WILLOW_TRAPDOOR.get());
        dropSelf(RuBlocks.WILLOW_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.WILLOW_BUTTON.get());
        dropSelf(RuBlocks.WILLOW_SIGN.get());
        add(RuBlocks.WILLOW_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.WILLOW_SIGN.get()));

        /*-----------------PAINTED PLANKS-----------------*/
        //PLANKS
        dropSelf(RuBlocks.RED_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.ORANGE_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.YELLOW_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.LIME_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.GREEN_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.CYAN_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.LIGHT_BLUE_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.BLUE_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.PURPLE_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.MAGENTA_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.PINK_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.BROWN_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.WHITE_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.LIGHT_GRAY_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.GRAY_PAINTED_PLANKS.get());
        dropSelf(RuBlocks.BLACK_PAINTED_PLANKS.get());
        //STAIRS
        dropSelf(RuBlocks.RED_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.ORANGE_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.YELLOW_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.LIME_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.GREEN_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.CYAN_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.LIGHT_BLUE_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.BLUE_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.PURPLE_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.MAGENTA_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.PINK_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.BROWN_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.WHITE_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.LIGHT_GRAY_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.GRAY_PAINTED_STAIRS.get());
        dropSelf(RuBlocks.BLACK_PAINTED_STAIRS.get());
        //SLABS
        add(RuBlocks.RED_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.ORANGE_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.YELLOW_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.LIME_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.GREEN_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.CYAN_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.LIGHT_BLUE_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.BLUE_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.PURPLE_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.MAGENTA_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.PINK_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.BROWN_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.WHITE_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.LIGHT_GRAY_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.GRAY_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));
        add(RuBlocks.BLACK_PAINTED_SLAB.get(), (block) -> createSlabItemTable(block));

        /*-----------------NETHER_BLOCKS-----------------*/
        //NETHER_STONES
        dropSelf(RuBlocks.BLACKSTONE_CLUSTER.get());
        add(RuBlocks.MARROWSTONE.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BONE_MEAL));
        //BRIMSPROUT_BLOCKS
        add(RuBlocks.BRIMSPROUT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        dropSelf(RuBlocks.BRIMSPROUT.get());
        //COBALT_BLOCKS
        add(RuBlocks.COBALT_EARLIGHT.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.COBALT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        dropSelf(RuBlocks.COBALT_OBSIDIAN.get());
        dropSelf(RuBlocks.COBALT_ROOTS.get());
        add(RuBlocks.HANGING_EARLIGHT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.HANGING_EARLIGHT_PLANT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F))));
        //GLISTERING_BLOCKS
        add(RuBlocks.GLISTERING_IVY.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.GLISTERING_IVY_PLANT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.GLISTERING_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        dropSelf(RuBlocks.GLISTERING_SPROUT.get());
        dropSelf(RuBlocks.GLISTERING_WART.get());
        add(RuBlocks.GLISTER_BULB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.GLISTER_SPIRE.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //MYCOTOXIC_BLOCKS
        add(RuBlocks.MYCOTOXIC_DAISY.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        dropSelf(RuBlocks.MYCOTOXIC_GRASS.get());
        add(RuBlocks.MYCOTOXIC_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RegionsUnexploredMod.BLOCK_REGISTRY.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected LootTable.Builder createDoublePlantWithSeedDropsNoGrass(Block p_248590_, Block p_248735_) {
        LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(p_248735_).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).when(HAS_SHEARS).otherwise(this.applyExplosionCondition(p_248590_, LootItem.lootTableItem(Items.WHEAT_SEEDS)).when(LootItemRandomChanceCondition.randomChance(0.125F)));
        return LootTable.lootTable().withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(p_248590_).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(p_248590_).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER).build()).build()), new BlockPos(0, 1, 0)))).withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(p_248590_).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(p_248590_).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER).build()).build()), new BlockPos(0, -1, 0))));
    }
}
