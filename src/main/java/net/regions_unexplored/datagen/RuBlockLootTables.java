package net.regions_unexplored.datagen;

import net.minecraft.advancements.critereon.BlockPredicate;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
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
        add(RuBlocks.ARGILLITE_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.ARGILLITE.get()));
        add(RuBlocks.STONE_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.STONE));
        add(RuBlocks.DEEPSLATE_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.DEEPSLATE));
        add(RuBlocks.VIRIDESCENT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.STONE));
        add(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.DEEPSLATE));

        add(RuBlocks.CORPSE_FLOWER.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BLADED_GRASS.get(), (block) -> createGrassDrops(block));
        add(RuBlocks.BLADED_TALL_GRASS.get(), (block) -> createDoublePlantWithSeedDrops(block, RuBlocks.BLADED_GRASS.get()));
        add(RuBlocks.DROPLEAF.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.DROPLEAF_PLANT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.DUSKMELON.get(), (block) -> applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RuBlocks.DUSKMELON.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SalmonBerryBushBlock.AGE, 3))).add(LootItem.lootTableItem(RuItems.DUSKMELON_SLICE.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RuBlocks.DUSKMELON.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))).add(LootItem.lootTableItem(RuItems.DUSKMELON_SLICE.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
        add(RuBlocks.DUSKTRAP.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        /*-----------------PLANTS-----------------*/
        //GRASS_BLOCKS
        dropSelf(RuBlocks.DEAD_STEPPE_SHRUB.get());
        add(RuBlocks.ASHEN_GRASS.get(), (block) -> createGrassDrops(block));
        add(RuBlocks.FROZEN_GRASS.get(), (block) -> createGrassDrops(block));
        add(RuBlocks.MEDIUM_GRASS.get(), (block) -> createGrassDrops(block));
        add(RuBlocks.SANDY_GRASS.get(), (block) -> createGrassDrops(block));
        add(RuBlocks.SMALL_DESERT_SHRUB.get(), (block) -> createShearsOnlyDrop(block));
        add(RuBlocks.STEPPE_GRASS.get(), (block) -> createGrassDrops(block));
        add(RuBlocks.STEPPE_SHRUB.get(), (block) -> createGrassDrops(block));
        add(RuBlocks.STONE_BUD.get(), (block) -> createGrassDrops(block));
        //TALL_GRASS_BLOCKS
        add(RuBlocks.ELEPHANT_EAR.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SANDY_TALL_GRASS.get(), (block) -> createDoublePlantWithSeedDrops(block, RuBlocks.SANDY_GRASS.get()));
        add(RuBlocks.STEPPE_TALL_GRASS.get(), (block) -> createDoublePlantWithSeedDrops(block, RuBlocks.STEPPE_GRASS.get()));
        add(RuBlocks.WINDSWEPT_GRASS.get(), (block) -> createDoublePlantWithSeedDropsNoGrass(block, RuBlocks.WINDSWEPT_GRASS.get(), Items.WHEAT_SEEDS));
        //FLOWERS
        dropSelf(RuBlocks.ALPHA_DANDELION.get());
        dropSelf(RuBlocks.ALPHA_ROSE.get());
        dropSelf(RuBlocks.ASTER.get());
        dropSelf(RuBlocks.BLEEDING_HEART.get());
        dropSelf(RuBlocks.BLUE_LUPINE.get());
        dropSelf(RuBlocks.DAISY.get());
        dropSelf(RuBlocks.DORCEL.get());
        dropSelf(RuBlocks.FELICIA_DAISY.get());
        dropSelf(RuBlocks.FIREWEED.get());
        dropSelf(RuBlocks.HIBISCUS.get());
        dropSelf(RuBlocks.HYSSOP.get());
        dropSelf(RuBlocks.MALLOW.get());
        dropSelf(RuBlocks.PINK_LUPINE.get());
        dropSelf(RuBlocks.POPPY_BUSH.get());
        dropSelf(RuBlocks.SALMON_POPPY_BUSH.get());
        dropSelf(RuBlocks.PURPLE_LUPINE.get());
        dropSelf(RuBlocks.RED_LUPINE.get());
        dropSelf(RuBlocks.TSUBAKI.get());
        dropSelf(RuBlocks.WARATAH.get());
        dropSelf(RuBlocks.WHITE_TRILLIUM.get());
        dropSelf(RuBlocks.WILTING_TRILLIUM.get());
        dropSelf(RuBlocks.YELLOW_LUPINE.get());

        add(RuBlocks.ORANGE_CONEFLOWER.get(), (block) -> createPetalsDrops(block));
        add(RuBlocks.PURPLE_CONEFLOWER.get(), (block) -> createPetalsDrops(block));
        add(RuBlocks.CLOVER.get(), (block) -> createPetalsDrops(block));

        add(RuBlocks.BLUE_MAGNOLIA_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        add(RuBlocks.PINK_MAGNOLIA_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        add(RuBlocks.WHITE_MAGNOLIA_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        //SNOWBELLE
        dropSelf(RuBlocks.RED_SNOWBELLE.get());
        dropSelf(RuBlocks.ORANGE_SNOWBELLE.get());
        dropSelf(RuBlocks.YELLOW_SNOWBELLE.get());
        dropSelf(RuBlocks.LIME_SNOWBELLE.get());
        dropSelf(RuBlocks.GREEN_SNOWBELLE.get());
        dropSelf(RuBlocks.CYAN_SNOWBELLE.get());
        dropSelf(RuBlocks.LIGHT_BLUE_SNOWBELLE.get());
        dropSelf(RuBlocks.BLUE_SNOWBELLE.get());
        dropSelf(RuBlocks.PURPLE_SNOWBELLE.get());
        dropSelf(RuBlocks.MAGENTA_SNOWBELLE.get());
        dropSelf(RuBlocks.PINK_SNOWBELLE.get());
        dropSelf(RuBlocks.BROWN_SNOWBELLE.get());
        dropSelf(RuBlocks.WHITE_SNOWBELLE.get());
        dropSelf(RuBlocks.LIGHT_GRAY_SNOWBELLE.get());
        dropSelf(RuBlocks.GRAY_SNOWBELLE.get());
        dropSelf(RuBlocks.BLACK_SNOWBELLE.get());

        add(RuBlocks.MAPLE_LEAF_PILE.get(), (block) -> createPetalsDrops(block));
        add(RuBlocks.RED_MAPLE_LEAF_PILE.get(), (block) -> createPetalsDrops(block));
        add(RuBlocks.ORANGE_MAPLE_LEAF_PILE.get(), (block) -> createPetalsDrops(block));
        add(RuBlocks.SILVER_BIRCH_LEAF_PILE.get(), (block) -> createPetalsDrops(block));
        add(RuBlocks.ENCHANTED_BIRCH_LEAF_PILE.get(), (block) -> createPetalsDrops(block));
        //TALL_PLANTS
        add(RuBlocks.MEADOW_SAGE.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BARLEY.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.CATTAIL.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.TASSEL.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DAY_LILY.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //SAPLINGS
        dropSelf(RuBlocks.ASHEN_SAPLING.get());
        dropSelf(RuBlocks.ALPHA_SAPLING.get());
        dropSelf(RuBlocks.APPLE_OAK_SAPLING.get());
        dropSelf(RuBlocks.BAMBOO_SAPLING.get());
        dropSelf(RuBlocks.BAOBAB_SAPLING.get());
        dropSelf(RuBlocks.BLACKWOOD_SAPLING.get());
        dropSelf(RuBlocks.CACTUS_FLOWER.get());
        dropSelf(RuBlocks.COBALT_SAPLING.get());
        dropSelf(RuBlocks.MAGNOLIA_SAPLING.get());
        dropSelf(RuBlocks.CYPRESS_SAPLING.get());
        dropSelf(RuBlocks.DEAD_PINE_SAPLING.get());
        dropSelf(RuBlocks.DEAD_SAPLING.get());
        dropSelf(RuBlocks.EUCALYPTUS_SAPLING.get());
        dropSelf(RuBlocks.FLOWERING_SAPLING.get());
        dropSelf(RuBlocks.GOLDEN_LARCH_SAPLING.get());
        dropSelf(RuBlocks.JOSHUA_SAPLING.get());
        dropSelf(RuBlocks.KAPOK_SAPLING.get());
        dropSelf(RuBlocks.LARCH_SAPLING.get());
        dropSelf(RuBlocks.MAPLE_SAPLING.get());
        dropSelf(RuBlocks.MAUVE_SAPLING.get());
        dropSelf(RuBlocks.ORANGE_MAPLE_SAPLING.get());
        dropSelf(RuBlocks.PALM_SAPLING.get());
        dropSelf(RuBlocks.PINE_SAPLING.get());
        dropSelf(RuBlocks.BLUE_MAGNOLIA_SAPLING.get());
        dropSelf(RuBlocks.PINK_MAGNOLIA_SAPLING.get());
        dropSelf(RuBlocks.REDWOOD_SAPLING.get());
        dropSelf(RuBlocks.RED_MAPLE_SAPLING.get());
        dropSelf(RuBlocks.BRIMWOOD_SAPLING.get());
        dropSelf(RuBlocks.ENCHANTED_BIRCH_SAPLING.get());
        dropSelf(RuBlocks.SILVER_BIRCH_SAPLING.get());
        dropSelf(RuBlocks.SMALL_OAK_SAPLING.get());
        dropSelf(RuBlocks.SOCOTRA_SAPLING.get());
        dropSelf(RuBlocks.WHITE_MAGNOLIA_SAPLING.get());
        dropSelf(RuBlocks.WILLOW_SAPLING.get());
        //SHRUBS
        add(RuBlocks.ASHEN_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.ACACIA_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BAOBAB_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BIRCH_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BLACKWOOD_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BRIMWOOD_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MAGNOLIA_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.CHERRY_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.CYPRESS_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DARK_OAK_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DEAD_PINE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.DEAD_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.EUCALYPTUS_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.FLOWERING_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.GOLDEN_LARCH_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.JOSHUA_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.JUNGLE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.KAPOK_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.LARCH_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MANGROVE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MAPLE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.MAUVE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.OAK_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.ORANGE_MAPLE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PALM_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PINE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.BLUE_MAGNOLIA_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.PINK_MAGNOLIA_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.REDWOOD_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.RED_MAPLE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.ENCHANTED_BIRCH_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SILVER_BIRCH_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SOCOTRA_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.SPRUCE_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.WHITE_MAGNOLIA_SHRUB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
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
        add(RuBlocks.ICICLE.get(), (block) -> createSilkTouchOnlyTable(block));
        dropSelf(RuBlocks.BARREL_CACTUS.get());
        dropSelf(RuBlocks.CAVE_HYSSOP.get());
        dropSelf(RuBlocks.DUCKWEED.get());
        add(RuBlocks.SPANISH_MOSS.get(), (block) -> createShearsOnlyDrop(block));
        add(RuBlocks.SPANISH_MOSS_PLANT.get(), (block) -> createShearsOnlyDrop(block));
        add(RuBlocks.KAPOK_VINES.get(), (block) -> createShearsOnlyDrop(block));
        add(RuBlocks.KAPOK_VINES_PLANT.get(), (block) -> createShearsOnlyDrop(block));
        dropSelf(RuBlocks.FLOWERING_LILY_PAD.get());
        add(RuBlocks.GIANT_LILY_PAD.get(), (block) -> createSingleItemTable(RuBlocks.FLOWERING_LILY_PAD.get()));
        //FOOD_PLANT_BLOCKS
        add(RuBlocks.SALMONBERRY_BUSH.get(), (block) -> applyExplosionDecay(block, LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RuBlocks.SALMONBERRY_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SalmonBerryBushBlock.AGE, 3))).add(LootItem.lootTableItem(RuItems.SALMONBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE))).withPool(LootPool.lootPool().when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(RuBlocks.SALMONBERRY_BUSH.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))).add(LootItem.lootTableItem(RuItems.SALMONBERRY.get())).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));

        /*-----------------POTTED_PLANTS-----------------*/
        add(RuBlocks.POTTED_ALPHA_DANDELION.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ALPHA_ROSE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ASTER.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLEEDING_HEART.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DAISY.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_FELICIA_DAISY.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DORCEL.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_FIREWEED.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_GLISTERING_BLOOM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_HIBISCUS.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_HYSSOP.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MALLOW.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_POPPY_BUSH.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_SALMON_POPPY_BUSH.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_TSUBAKI.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WARATAH.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WHITE_TRILLIUM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WILTING_TRILLIUM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLUE_LUPINE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PINK_LUPINE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PURPLE_LUPINE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_RED_LUPINE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_YELLOW_LUPINE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ORANGE_CONEFLOWER.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PURPLE_CONEFLOWER.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WHITE_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_LIGHT_GRAY_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_GRAY_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_RED_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ORANGE_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_YELLOW_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_LIME_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_GREEN_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_CYAN_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_LIGHT_BLUE_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLUE_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PURPLE_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MAGENTA_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PINK_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BROWN_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLACK_SNOWBELLE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DAY_LILY.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MEADOW_SAGE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_CAVE_HYSSOP.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BARREL_CACTUS.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DUSKTRAP.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_CORPSE_FLOWER.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_COBALT_EARLIGHT.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_TALL_COBALT_EARLIGHT.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MYCOTOXIC_DAISY.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_GLISTER_SPIRE.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLUE_BIOSHROOM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_GREEN_BIOSHROOM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PINK_BIOSHROOM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_YELLOW_BIOSHROOM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_TALL_BLUE_BIOSHROOM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_TALL_GREEN_BIOSHROOM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_TALL_PINK_BIOSHROOM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_TALL_YELLOW_BIOSHROOM.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ASHEN_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ALPHA_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_APPLE_OAK_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BAMBOO_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BAOBAB_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLACKWOOD_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BRIMWOOD_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_COBALT_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_CACTUS_FLOWER.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MAGNOLIA_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_CYPRESS_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DEAD_PINE_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_DEAD_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_EUCALYPTUS_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_FLOWERING_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_GOLDEN_LARCH_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_JOSHUA_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_KAPOK_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_LARCH_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MAPLE_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_MAUVE_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ORANGE_MAPLE_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PALM_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PINE_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_BLUE_MAGNOLIA_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_PINK_MAGNOLIA_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_REDWOOD_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_RED_MAPLE_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_ENCHANTED_BIRCH_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_SILVER_BIRCH_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_SMALL_OAK_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_SOCOTRA_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WHITE_MAGNOLIA_SAPLING.get(), (block) -> createPotFlowerItemTable(block));
        add(RuBlocks.POTTED_WILLOW_SAPLING.get(), (block) -> createPotFlowerItemTable(block));

        /*-----------------PLANT_BLOCKS-----------------*/
        //MUSHROOMS
        dropSelf(RuBlocks.BLUE_BIOSHROOM_BLOCK.get());
        add(RuBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.BLUE_BIOSHROOM_BLOCK.get()));
        dropSelf(RuBlocks.GREEN_BIOSHROOM_BLOCK.get());
        add(RuBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.GREEN_BIOSHROOM_BLOCK.get()));
        dropSelf(RuBlocks.PINK_BIOSHROOM_BLOCK.get());
        add(RuBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.PINK_BIOSHROOM_BLOCK.get()));
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_BLOCK.get());
        add(RuBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.YELLOW_BIOSHROOM_BLOCK.get()));
        //BAMBOO
        dropSelf(RuBlocks.BAMBOO_LOG.get());
        dropSelf(RuBlocks.STRIPPED_BAMBOO_LOG.get());
        //OAK
        dropSelf(RuBlocks.SMALL_OAK_LOG.get());
        dropSelf(RuBlocks.STRIPPED_SMALL_OAK_LOG.get());
        //CACTUS
        dropSelf(RuBlocks.SAGUARO_CACTUS.get());

        /*-----------------LEAVES-----------------*/
        add(RuBlocks.ALPHA_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ALPHA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.APPLE_OAK_LEAVES.get(), (block) -> createOakLeavesDrops(block, RuBlocks.APPLE_OAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.ASHEN_LEAVES.get(), (block) -> createOakLeavesDrops(block, RuBlocks.ASHEN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BAMBOO_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.BAMBOO_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BAOBAB_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.BAOBAB_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BLACKWOOD_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.BLACKWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.COBALT_WEBBING.get(), (block) -> createLeavesDrops(block, RuBlocks.COBALT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.MAGNOLIA_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.MAGNOLIA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.CYPRESS_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.CYPRESS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.DEAD_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.DEAD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.DEAD_PINE_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.DEAD_PINE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.EUCALYPTUS_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.EUCALYPTUS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.FLOWERING_LEAVES.get(), (block) -> createOakLeavesDrops(block, RuBlocks.FLOWERING_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.GOLDEN_LARCH_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.GOLDEN_LARCH_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.JOSHUA_LEAVES.get(), (block) -> createDoublePlantWithSeedDropsNoGrass(block, RuBlocks.JOSHUA_LEAVES.get(), RuBlocks.JOSHUA_SAPLING.get()));
        add(RuBlocks.KAPOK_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.KAPOK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.LARCH_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.LARCH_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.MAPLE_LEAVES.get(), (block) -> createOakLeavesDrops(block, RuBlocks.MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.MAUVE_LEAVES.get(), (block) -> createOakLeavesDrops(block, RuBlocks.MAUVE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.ORANGE_MAPLE_LEAVES.get(), (block) -> createOakLeavesDrops(block, RuBlocks.ORANGE_MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.PALM_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.PALM_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.PINE_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.PINE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BLUE_MAGNOLIA_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.BLUE_MAGNOLIA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.PINK_MAGNOLIA_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.PINK_MAGNOLIA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.REDWOOD_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.REDWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.RED_MAPLE_LEAVES.get(), (block) -> createOakLeavesDrops(block, RuBlocks.RED_MAPLE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.BRIMWOOD_LEAVES.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(RuBlocks.BRIMWOOD_SAPLING.get())).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, NORMAL_LEAVES_SAPLING_CHANCES))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).when(HAS_NO_SHEARS_OR_SILK_TOUCH)));
        add(RuBlocks.SILVER_BIRCH_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.SILVER_BIRCH_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.SMALL_OAK_LEAVES.get(), (block) -> createOakLeavesDrops(block, RuBlocks.SMALL_OAK_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.SOCOTRA_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.SOCOTRA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.ENCHANTED_BIRCH_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.ENCHANTED_BIRCH_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.WHITE_MAGNOLIA_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.WHITE_MAGNOLIA_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        add(RuBlocks.WILLOW_LEAVES.get(), (block) -> createLeavesDrops(block, RuBlocks.WILLOW_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        /*-----------------BRANCHES-----------------*/
        add(RuBlocks.ACACIA_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.BAOBAB_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.BIRCH_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.BLACKWOOD_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MAGNOLIA_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.CYPRESS_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.CHERRY_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.DARK_OAK_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.DEAD_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.EUCALYPTUS_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.JOSHUA_BEARD.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.JUNGLE_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.KAPOK_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.LARCH_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MANGROVE_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MAPLE_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.MAUVE_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.OAK_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.PALM_BEARD.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.PINE_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.REDWOOD_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.SILVER_BIRCH_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.SOCOTRA_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.SPRUCE_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));
        add(RuBlocks.WILLOW_BRANCH.get(), (block) -> createShearsDispatchTable(block, this.applyExplosionCondition(block, LootItem.lootTableItem(Items.STICK))).withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(4.0F)).when(HAS_SHEARS.invert())));

        /*-----------------DIRT_BLOCKS-----------------*/
        //FOREST_DIRT_BLOCKS
        add(RuBlocks.PEAT_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.PEAT_DIRT.get()));
        dropSelf(RuBlocks.PEAT_DIRT.get());
        add(RuBlocks.PEAT_DIRT_PATH.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.PEAT_DIRT.get()));
        dropSelf(RuBlocks.PEAT_COARSE_DIRT.get());
        dropSelf(RuBlocks.PEAT_PODZOL.get());
        dropSelf(RuBlocks.PEAT_MUD.get());
        add(RuBlocks.PEAT_FARMLAND.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.PEAT_DIRT.get()));
        //PLAINS_DIRT_BLOCKS
        add(RuBlocks.SILT_GRASS_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.SILT_DIRT.get()));
        dropSelf(RuBlocks.SILT_DIRT.get());
        add(RuBlocks.SILT_DIRT_PATH.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.SILT_DIRT.get()));
        dropSelf(RuBlocks.SILT_COARSE_DIRT.get());
        dropSelf(RuBlocks.SILT_PODZOL.get());
        dropSelf(RuBlocks.SILT_MUD.get());
        add(RuBlocks.SILT_FARMLAND.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.SILT_DIRT.get()));
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
        //STONES
        dropSelf(RuBlocks.ARGILLITE.get());
        add(RuBlocks.MOSSY_STONE.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.MOSSY_COBBLESTONE));

        /*-----------------OCEAN_BLOCKS-----------------*/
        //HYACINTH_BLOCKS
        dropSelf(RuBlocks.HYACINTH_LAMP.get());
        dropSelf(RuBlocks.HYACINTH_BLOOM.get());
        add(RuBlocks.HYACINTH_FLOWERS.get(), (block) -> createMultifaceBlockDrops(block, HAS_SHEARS));
        dropSelf(RuBlocks.TALL_HYACINTH_STOCK.get());

        /*-----------------OTHER_BLOCKS-----------------*/
        add(RuBlocks.ASH.get(), (block) -> createSilkTouchDispatchTable(block, this.applyExplosionCondition(Items.FLINT, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.SILK_TOUCH, 1.0F)).otherwise(LootItem.lootTableItem(Items.FLINT)))));
        add(RuBlocks.VOLCANIC_ASH.get(), (block) -> createSilkTouchDispatchTable(block, this.applyExplosionCondition(Items.FLINT, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.SILK_TOUCH, 1.0F)).otherwise(LootItem.lootTableItem(Items.FLINT)))));
        dropSelf(RuBlocks.ASH_VENT.get());

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
        dropSelf(RuBlocks.BAOBAB_HANGING_SIGN.get());
        add(RuBlocks.BAOBAB_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.BAOBAB_HANGING_SIGN.get()));
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
        dropSelf(RuBlocks.BLACKWOOD_HANGING_SIGN.get());
        add(RuBlocks.BLACKWOOD_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.BLACKWOOD_HANGING_SIGN.get()));
        //BLUE_BIOSHROOM_BLOCKS
        dropSelf(RuBlocks.BLUE_BIOSHROOM_STEM.get());
        dropSelf(RuBlocks.STRIPPED_BLUE_BIOSHROOM_STEM.get());
        dropSelf(RuBlocks.BLUE_BIOSHROOM_HYPHAE.get());
        dropSelf(RuBlocks.STRIPPED_BLUE_BIOSHROOM_HYPHAE.get());
        dropSelf(RuBlocks.BLUE_BIOSHROOM_PLANKS.get());
        dropSelf(RuBlocks.BLUE_BIOSHROOM_STAIRS.get());
        add(RuBlocks.BLUE_BIOSHROOM_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.BLUE_BIOSHROOM_FENCE.get());
        add(RuBlocks.BLUE_BIOSHROOM_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.BLUE_BIOSHROOM_FENCE_GATE.get());
        dropSelf(RuBlocks.BLUE_BIOSHROOM_TRAPDOOR.get());
        dropSelf(RuBlocks.BLUE_BIOSHROOM_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.BLUE_BIOSHROOM_BUTTON.get());
        dropSelf(RuBlocks.BLUE_BIOSHROOM_SIGN.get());
        add(RuBlocks.BLUE_BIOSHROOM_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.BLUE_BIOSHROOM_SIGN.get()));
        dropSelf(RuBlocks.BLUE_BIOSHROOM_HANGING_SIGN.get());
        add(RuBlocks.BLUE_BIOSHROOM_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.BLUE_BIOSHROOM_HANGING_SIGN.get()));
        //BRIMWOOD_BLOCKS
        dropSelf(RuBlocks.BRIMWOOD_LOG.get());
        add(RuBlocks.BRIMWOOD_LOG_MAGMA.get(), (block) -> createSingleItemTableWithSilkTouch(block, RuBlocks.BRIMWOOD_LOG.get()));
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
        dropSelf(RuBlocks.BRIMWOOD_HANGING_SIGN.get());
        add(RuBlocks.BRIMWOOD_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.BRIMWOOD_HANGING_SIGN.get()));
        //COBALT_BLOCKS
        dropSelf(RuBlocks.COBALT_LOG.get());
        dropSelf(RuBlocks.STRIPPED_COBALT_LOG.get());
        dropSelf(RuBlocks.COBALT_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_COBALT_WOOD.get());
        dropSelf(RuBlocks.COBALT_PLANKS.get());
        dropSelf(RuBlocks.COBALT_STAIRS.get());
        add(RuBlocks.COBALT_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.COBALT_FENCE.get());
        add(RuBlocks.COBALT_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.COBALT_FENCE_GATE.get());
        dropSelf(RuBlocks.COBALT_TRAPDOOR.get());
        dropSelf(RuBlocks.COBALT_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.COBALT_BUTTON.get());
        dropSelf(RuBlocks.COBALT_SIGN.get());
        add(RuBlocks.COBALT_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.COBALT_SIGN.get()));
        dropSelf(RuBlocks.COBALT_HANGING_SIGN.get());
        add(RuBlocks.COBALT_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.COBALT_HANGING_SIGN.get()));
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
        dropSelf(RuBlocks.CYPRESS_HANGING_SIGN.get());
        add(RuBlocks.CYPRESS_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.CYPRESS_HANGING_SIGN.get()));
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
        dropSelf(RuBlocks.DEAD_HANGING_SIGN.get());
        add(RuBlocks.DEAD_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.DEAD_HANGING_SIGN.get()));
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
        dropSelf(RuBlocks.EUCALYPTUS_HANGING_SIGN.get());
        add(RuBlocks.EUCALYPTUS_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.EUCALYPTUS_HANGING_SIGN.get()));
        //GREEN_BIOSHROOM_BLOCKS
        dropSelf(RuBlocks.GREEN_BIOSHROOM_STEM.get());
        dropSelf(RuBlocks.STRIPPED_GREEN_BIOSHROOM_STEM.get());
        dropSelf(RuBlocks.GREEN_BIOSHROOM_HYPHAE.get());
        dropSelf(RuBlocks.STRIPPED_GREEN_BIOSHROOM_HYPHAE.get());
        dropSelf(RuBlocks.GREEN_BIOSHROOM_PLANKS.get());
        dropSelf(RuBlocks.GREEN_BIOSHROOM_STAIRS.get());
        add(RuBlocks.GREEN_BIOSHROOM_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.GREEN_BIOSHROOM_FENCE.get());
        add(RuBlocks.GREEN_BIOSHROOM_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.GREEN_BIOSHROOM_FENCE_GATE.get());
        dropSelf(RuBlocks.GREEN_BIOSHROOM_TRAPDOOR.get());
        dropSelf(RuBlocks.GREEN_BIOSHROOM_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.GREEN_BIOSHROOM_BUTTON.get());
        dropSelf(RuBlocks.GREEN_BIOSHROOM_SIGN.get());
        add(RuBlocks.GREEN_BIOSHROOM_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.GREEN_BIOSHROOM_SIGN.get()));
        dropSelf(RuBlocks.GREEN_BIOSHROOM_HANGING_SIGN.get());
        add(RuBlocks.GREEN_BIOSHROOM_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.GREEN_BIOSHROOM_HANGING_SIGN.get()));
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
        dropSelf(RuBlocks.JOSHUA_HANGING_SIGN.get());
        add(RuBlocks.JOSHUA_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.JOSHUA_HANGING_SIGN.get()));
        //KAPOK_BLOCKS
        dropSelf(RuBlocks.KAPOK_LOG.get());
        dropSelf(RuBlocks.STRIPPED_KAPOK_LOG.get());
        dropSelf(RuBlocks.KAPOK_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_KAPOK_WOOD.get());
        dropSelf(RuBlocks.KAPOK_PLANKS.get());
        dropSelf(RuBlocks.KAPOK_STAIRS.get());
        add(RuBlocks.KAPOK_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.KAPOK_FENCE.get());
        add(RuBlocks.KAPOK_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.KAPOK_FENCE_GATE.get());
        dropSelf(RuBlocks.KAPOK_TRAPDOOR.get());
        dropSelf(RuBlocks.KAPOK_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.KAPOK_BUTTON.get());
        dropSelf(RuBlocks.KAPOK_SIGN.get());
        add(RuBlocks.KAPOK_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.KAPOK_SIGN.get()));
        dropSelf(RuBlocks.KAPOK_HANGING_SIGN.get());
        add(RuBlocks.KAPOK_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.KAPOK_HANGING_SIGN.get()));
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
        dropSelf(RuBlocks.LARCH_HANGING_SIGN.get());
        add(RuBlocks.LARCH_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.LARCH_HANGING_SIGN.get()));
        //MAGNOLIA_BLOCKS
        dropSelf(RuBlocks.MAGNOLIA_LOG.get());
        dropSelf(RuBlocks.STRIPPED_MAGNOLIA_LOG.get());
        dropSelf(RuBlocks.MAGNOLIA_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_MAGNOLIA_WOOD.get());
        dropSelf(RuBlocks.MAGNOLIA_PLANKS.get());
        dropSelf(RuBlocks.MAGNOLIA_STAIRS.get());
        add(RuBlocks.MAGNOLIA_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.MAGNOLIA_FENCE.get());
        add(RuBlocks.MAGNOLIA_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.MAGNOLIA_FENCE_GATE.get());
        dropSelf(RuBlocks.MAGNOLIA_TRAPDOOR.get());
        dropSelf(RuBlocks.MAGNOLIA_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.MAGNOLIA_BUTTON.get());
        dropSelf(RuBlocks.MAGNOLIA_SIGN.get());
        add(RuBlocks.MAGNOLIA_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.MAGNOLIA_SIGN.get()));
        dropSelf(RuBlocks.MAGNOLIA_HANGING_SIGN.get());
        add(RuBlocks.MAGNOLIA_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.MAGNOLIA_HANGING_SIGN.get()));
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
        dropSelf(RuBlocks.MAPLE_HANGING_SIGN.get());
        add(RuBlocks.MAPLE_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.MAPLE_HANGING_SIGN.get()));
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
        dropSelf(RuBlocks.MAUVE_HANGING_SIGN.get());
        add(RuBlocks.MAUVE_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.MAUVE_HANGING_SIGN.get()));
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
        dropSelf(RuBlocks.PALM_HANGING_SIGN.get());
        add(RuBlocks.PALM_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.PALM_HANGING_SIGN.get()));
        //PINE_BLOCKS
        dropSelf(RuBlocks.PINE_LOG.get());
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
        dropSelf(RuBlocks.PINE_HANGING_SIGN.get());
        add(RuBlocks.PINE_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.PINE_HANGING_SIGN.get()));
        //PINK_BIOSHROOM_BLOCKS
        dropSelf(RuBlocks.PINK_BIOSHROOM_STEM.get());
        dropSelf(RuBlocks.STRIPPED_PINK_BIOSHROOM_STEM.get());
        dropSelf(RuBlocks.PINK_BIOSHROOM_HYPHAE.get());
        dropSelf(RuBlocks.STRIPPED_PINK_BIOSHROOM_HYPHAE.get());
        dropSelf(RuBlocks.PINK_BIOSHROOM_PLANKS.get());
        dropSelf(RuBlocks.PINK_BIOSHROOM_STAIRS.get());
        add(RuBlocks.PINK_BIOSHROOM_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.PINK_BIOSHROOM_FENCE.get());
        add(RuBlocks.PINK_BIOSHROOM_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.PINK_BIOSHROOM_FENCE_GATE.get());
        dropSelf(RuBlocks.PINK_BIOSHROOM_TRAPDOOR.get());
        dropSelf(RuBlocks.PINK_BIOSHROOM_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.PINK_BIOSHROOM_BUTTON.get());
        dropSelf(RuBlocks.PINK_BIOSHROOM_SIGN.get());
        add(RuBlocks.PINK_BIOSHROOM_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.PINK_BIOSHROOM_SIGN.get()));
        dropSelf(RuBlocks.PINK_BIOSHROOM_HANGING_SIGN.get());
        add(RuBlocks.PINK_BIOSHROOM_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.PINK_BIOSHROOM_HANGING_SIGN.get()));
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
        dropSelf(RuBlocks.REDWOOD_HANGING_SIGN.get());
        add(RuBlocks.REDWOOD_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.REDWOOD_HANGING_SIGN.get()));
        //SOCOTRA_BLOCKS
        dropSelf(RuBlocks.SOCOTRA_LOG.get());
        dropSelf(RuBlocks.STRIPPED_SOCOTRA_LOG.get());
        dropSelf(RuBlocks.SOCOTRA_WOOD.get());
        dropSelf(RuBlocks.STRIPPED_SOCOTRA_WOOD.get());
        dropSelf(RuBlocks.SOCOTRA_PLANKS.get());
        dropSelf(RuBlocks.SOCOTRA_STAIRS.get());
        add(RuBlocks.SOCOTRA_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.SOCOTRA_FENCE.get());
        add(RuBlocks.SOCOTRA_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.SOCOTRA_FENCE_GATE.get());
        dropSelf(RuBlocks.SOCOTRA_TRAPDOOR.get());
        dropSelf(RuBlocks.SOCOTRA_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.SOCOTRA_BUTTON.get());
        dropSelf(RuBlocks.SOCOTRA_SIGN.get());
        add(RuBlocks.SOCOTRA_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.SOCOTRA_SIGN.get()));
        dropSelf(RuBlocks.SOCOTRA_HANGING_SIGN.get());
        add(RuBlocks.SOCOTRA_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.SOCOTRA_HANGING_SIGN.get()));
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
        dropSelf(RuBlocks.WILLOW_HANGING_SIGN.get());
        add(RuBlocks.WILLOW_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.WILLOW_HANGING_SIGN.get()));
        //YELLOW_BIOSHROOM_BLOCKS
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_STEM.get());
        dropSelf(RuBlocks.STRIPPED_YELLOW_BIOSHROOM_STEM.get());
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_HYPHAE.get());
        dropSelf(RuBlocks.STRIPPED_YELLOW_BIOSHROOM_HYPHAE.get());
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_PLANKS.get());
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_STAIRS.get());
        add(RuBlocks.YELLOW_BIOSHROOM_SLAB.get(), (block) -> createSlabItemTable(block));
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_FENCE.get());
        add(RuBlocks.YELLOW_BIOSHROOM_DOOR.get(), (block) -> createDoorTable(block));
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_FENCE_GATE.get());
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_TRAPDOOR.get());
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_PRESSURE_PLATE.get());
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_BUTTON.get());
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_SIGN.get());
        add(RuBlocks.YELLOW_BIOSHROOM_WALL_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.YELLOW_BIOSHROOM_SIGN.get()));
        dropSelf(RuBlocks.YELLOW_BIOSHROOM_HANGING_SIGN.get());
        add(RuBlocks.YELLOW_BIOSHROOM_WALL_HANGING_SIGN.get(), (block) -> createSingleItemTable(RuBlocks.YELLOW_BIOSHROOM_HANGING_SIGN.get()));

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
        add(RuBlocks.OVERGROWN_BONE_BLOCK.get(), (block) -> createSingleItemTableWithSilkTouch(block, Items.BONE_BLOCK));
        //BRIMSPROUT_BLOCKS
        add(RuBlocks.BRIMSPROUT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        dropSelf(RuBlocks.BRIMSPROUT.get());
        //COBALT_BLOCKS
        dropSelf(RuBlocks.COBALT_EARLIGHT.get());
        add(RuBlocks.TALL_COBALT_EARLIGHT.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.COBALT_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        dropSelf(RuBlocks.COBALT_OBSIDIAN.get());
        dropSelf(RuBlocks.COBALT_ROOTS.get());
        add(RuBlocks.HANGING_EARLIGHT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.66F, 0.78F, 0.9F, 1.0F))));
        add(RuBlocks.HANGING_EARLIGHT_PLANT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.66F, 0.78F, 0.9F, 1.0F))));
        //GLISTERING_BLOCKS
        add(RuBlocks.GLISTERING_IVY.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.GLISTERING_IVY_PLANT.get(), (block) -> createSilkTouchOrShearsDispatchTable(block, LootItem.lootTableItem(block).when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, 0.33F, 0.55F, 0.77F, 1.0F))));
        add(RuBlocks.GLISTERING_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        dropSelf(RuBlocks.GLISTERING_SPROUT.get());
        dropSelf(RuBlocks.GLISTERING_BLOOM.get());
        dropSelf(RuBlocks.GLISTERING_FERN.get());
        dropSelf(RuBlocks.GLISTERING_WART.get());
        add(RuBlocks.GLISTER_BULB.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        add(RuBlocks.GLISTER_SPIRE.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        //MYCOTOXIC_BLOCKS
        add(RuBlocks.MYCOTOXIC_MUSHROOMS.get(), (block) -> createPetalsDrops(block));
        add(RuBlocks.MYCOTOXIC_DAISY.get(), (block) -> createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        dropSelf(RuBlocks.MYCOTOXIC_GRASS.get());
        add(RuBlocks.MYCOTOXIC_NYLIUM.get(), (block) -> createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return RegionsUnexploredMod.BLOCK_REGISTRY.getEntries().stream().map(RegistryObject::get)::iterator;
    }

    protected LootTable.Builder createDoublePlantWithSeedDropsNoGrass(Block p_248590_, Block p_248735_, ItemLike item) {
        LootPoolEntryContainer.Builder<?> builder = LootItem.lootTableItem(p_248735_).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1.0F))).when(HAS_SHEARS).otherwise(this.applyExplosionCondition(p_248590_, LootItem.lootTableItem(item)).when(LootItemRandomChanceCondition.randomChance(0.125F)));
        return LootTable.lootTable().withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(p_248590_).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(p_248590_).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))), new BlockPos(0, 1, 0)))).withPool(LootPool.lootPool().add(builder).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(p_248590_).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER))).when(LocationCheck.checkLocation(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(p_248590_).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER))), new BlockPos(0, -1, 0))));
    }
}
