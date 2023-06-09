package net.regions_unexplored.data.worldgen;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.regions_unexplored.data.worldgen.placement.RuMiscOverworldPlacements;
import net.regions_unexplored.data.worldgen.placement.RuTreePlacements;
import net.regions_unexplored.data.worldgen.placement.RuVegetationPlacements;

public class RuBiomeDefaultFeatures {
    public static void mediumGrass(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.MEDIUM_GRASS);
    }
    public static void redwoodDecoration(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, RuMiscOverworldPlacements.REDWOODS_ROCK);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.REDWOODS_VEGETATION);
        addRareSalmonberryBush(builder);
    }
    public static void pointedRedstone(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, RuMiscOverworldPlacements.ORE_REDSTONE_LARGE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuMiscOverworldPlacements.POINTED_REDSTONE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuMiscOverworldPlacements.LARGE_POINTED_REDSTONE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuMiscOverworldPlacements.POINTED_REDSTONE_CLUSTER);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.REDSTONE_BUD);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.REDSTONE_BULB);
    }
    public static void addMeadowRocks(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuMiscOverworldPlacements.MEADOW_ROCK);
    }
    public static void addPrairieGrass(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.GRASS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_GRASS);
    }
    public static void addPrairieFlowers(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PRAIRIE_FLOWERS);
    }
    public static void addPoppies(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.POPPIES);
    }
    public static void addDirtSurfaceVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.DIRT_VEGETATION);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.GRASS_VEGETATION);
    }
    public static void addTaigaFlowerPatch(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TRILLIUM_DAISY);
    }
    public static void addMeadowVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.MEADOW_VEGETATION);
    }
    public static void addBayouVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.BAYOU_VEGETATION);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.FLOWERING_LILY);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.WILLOW_CYPRESS_SHRUB_MIX);
    }
    public static void addRareSalmonberryBush(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.RARE_SALMONBERRY_BUSH);
    }
    public static void addCommonSalmonberryBush(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.COMMON_SALMONBERRY_BUSH);
    }
    public static void addOrangeCornflower(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.ORANGE_CONEFLOWER);
    }
    public static void autumnalTrees(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.ORANGE_MAPLE_TREE_ON_GRASS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.RED_MAPLE_TREE_ON_GRASS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.MAPLE_TREE_ON_GRASS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.SILVER_BIRCH_ON_GRASS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.BIG_ORANGE_MAPLE_TREE_ON_GRASS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.BIG_RED_MAPLE_TREE_ON_GRASS);
    }
    public static void addSparseOrangeCornflower(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.SPARSE_ORANGE_CONEFLOWER);
    }
    public static void addMapleGroundcover(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.SILVER_BIRCH_LEAF_PILE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.ORANGE_MAPLE_LEAF_PILE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.RED_MAPLE_LEAF_PILE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.MAPLE_LEAF_PILE);
    }
    public static void addPurpleCornflower(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PURPLE_CONEFLOWER);
    }
    public static void addSakuraFlowers(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.SAKURA_FLOWERS);
    }
    public static void addLupineVegetation(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.LUPINE_VEGETATION);
    }
    public static void mapleForestTrees(BiomeGenerationSettings.Builder builder){
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.MAPLE_TREE_DENSE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.RED_MAPLE_TREE_SPARSE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.BIG_MAPLE_TREE_SPARSE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.SPRUCE_TREE_TALL_DENSE);
    }
    public static void mapleForestVegetation(BiomeGenerationSettings.Builder builder){
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.GRASS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.STONE_BUD_DENSE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.WHITE_TRILLIUM);
    }
    public static void addTrillium(BiomeGenerationSettings.Builder builder){
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.WHITE_TRILLIUM);
    }
    public static void flowerFieldsFlowers(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.SMALL_FLOWERS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.TALL_FLOWERS);
    }
    public static void sakuraTrees(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.SAKURA_TREE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.BIG_SAKURA_TREE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.RED_SAKURA_TREE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.BIG_RED_SAKURA_TREE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.PINK_SAKURA_TREE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.BIG_PINK_SAKURA_TREE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.WHITE_SAKURA_TREE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.BIG_WHITE_SAKURA_TREE);
    }
    public static void blackwoodTrees(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.TALL_BLACKWOOD_TREE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.BLACKWOOD_TREE);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.TALL_DARK_OAK);
    }
    public static void addBlackwoodBioshrooms(BiomeGenerationSettings.Builder builder) {
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.BLACKWOOD_MUSHROOMS);
        builder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.BLACKWOOD_DECORATION);
    }
    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }
}
