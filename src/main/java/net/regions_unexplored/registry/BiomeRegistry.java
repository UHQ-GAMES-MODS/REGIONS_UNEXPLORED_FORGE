package net.regions_unexplored.registry;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;
import net.regions_unexplored.data.worldgen.biome.builder.*;
import net.regions_unexplored.data.worldgen.biome.surface.RuNetherSurfaceBuilder;
import net.regions_unexplored.data.worldgen.biome.surface.RuOverworldSurfaceBuilders;
import net.regions_unexplored.world.level.region.RuRegionNether;
import net.regions_unexplored.world.level.region.RuRegionPrimary;
import net.regions_unexplored.world.level.region.RuRegionSecondary;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

import java.util.function.Supplier;

public class BiomeRegistry {

    public static void addBiomes() {
        registerBiomes();
        registerVillagerTypes();
    }

    public static void setupTerrablender() {
        Regions.register(new RuRegionPrimary(RuCommonConfig.REGION_PRIMARY_WEIGHT.get()));
        Regions.register(new RuRegionSecondary(RuCommonConfig.REGION_SECONDARY_WEIGHT.get()));
        Regions.register(new RuRegionNether(RuCommonConfig.REGION_NETHER_WEIGHT.get()));
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, RegionsUnexploredMod.MOD_ID, RuNetherSurfaceBuilder.makeRules());
        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, RegionsUnexploredMod.MOD_ID, RuOverworldSurfaceBuilders.makeRules());
    }

    public static void registerBiomes() {

        //FOREST
        register(RuBiomes.AUTUMNAL_MAPLE_FOREST, ForestBiomes::autumnalMapleForest);
        register(RuBiomes.BAMBOO_FOREST, ForestBiomes::bambooForest);
        register(RuBiomes.MAGNOLIA_WOODLAND, ForestBiomes::magnoliaHighlands);
        register(RuBiomes.DECIDUOUS_FOREST, ForestBiomes::deciduousForest);
        register(RuBiomes.MAPLE_FOREST, ForestBiomes::mapleForest);
        register(RuBiomes.MAUVE_HILLS, ForestBiomes::mauveHills);
        register(RuBiomes.ORCHARD, ForestBiomes::orchard);
        register(RuBiomes.SILVER_BIRCH_FOREST, ForestBiomes::silverBirchForest);
        register(RuBiomes.TEMPERATE_GROVE, ForestBiomes::temperateGrove);
        register(RuBiomes.WILLOW_FOREST, ForestBiomes::willowForest);
        //TAIGA
        register(RuBiomes.BLACKWOOD_TAIGA, TaigaBiomes::blackwoodTaiga);
        register(RuBiomes.BOREAL_TAIGA, TaigaBiomes::borealTaiga);
        register(RuBiomes.GOLDEN_BOREAL_TAIGA, TaigaBiomes::goldenBorealTaiga);
        register(RuBiomes.PINE_TAIGA, TaigaBiomes::pineTaiga);
        register(RuBiomes.REDWOODS, TaigaBiomes::redwoods);
        register(RuBiomes.SPARSE_REDWOODS, TaigaBiomes::sparseRedwoods);
        //PLAINS
        register(RuBiomes.BARLEY_FIELDS, PlainsBiomes::barleyFields);
        register(RuBiomes.FLOWER_FIELDS, PlainsBiomes::flowerFields);
        register(RuBiomes.GRASSLAND, PlainsBiomes::grassland);
        register(RuBiomes.CLOVER_PLAINS, PlainsBiomes::lupinePlains);
        register(RuBiomes.ROCKY_MEADOW, PlainsBiomes::rockyMeadow);
        register(RuBiomes.POPPY_FIELDS, PlainsBiomes::poppyFields);
        register(RuBiomes.PRAIRIE, PlainsBiomes::prairie);
        register(RuBiomes.PUMPKIN_FIELDS, PlainsBiomes::pumpkinFields);
        register(RuBiomes.SHRUBLAND, PlainsBiomes::shrubland);
        //WET
        register(RuBiomes.BAYOU, WetBiomes::bayou);
        register(RuBiomes.EUCALYPTUS_FOREST, WetBiomes::eucalyptusForest);
        register(RuBiomes.FEN, WetBiomes::fen);
        register(RuBiomes.MARSH, WetBiomes::marsh);
        register(RuBiomes.FUNGAL_FEN, WetBiomes::fungalFen);
        register(RuBiomes.OLD_GROWTH_BAYOU, WetBiomes::oldGrowthBayou);
        register(RuBiomes.SPARSE_RAINFOREST, WetBiomes::sparseRainforest);
        register(RuBiomes.RAINFOREST, WetBiomes::rainforest);
        //ARID
        register(RuBiomes.BAOBAB_SAVANNA, AridBiomes::baobabSavanna);
        register(RuBiomes.DRY_BUSHLAND, AridBiomes::dryBushland);
        register(RuBiomes.JOSHUA_DESERT, AridBiomes::joshuaDesert);
        register(RuBiomes.OUTBACK, AridBiomes::outback);
        register(RuBiomes.SAGUARO_DESERT, AridBiomes::saguaroDesert);
        register(RuBiomes.STEPPE, AridBiomes::steppe);
        //MOUNTAIN
        register(RuBiomes.ARID_MOUNTAINS, MountainBiomes::aridMountains);
        register(RuBiomes.HIGHLAND_FIELDS, MountainBiomes::highlandFields);
        register(RuBiomes.MOUNTAINS, MountainBiomes::mountains);
        register(RuBiomes.PINE_SLOPES, MountainBiomes::slopes);
        register(RuBiomes.TOWERING_CLIFFS, MountainBiomes::toweringCliffs);
        //COASTAL
        register(RuBiomes.CHALK_CLIFFS, CoastalBiomes::chalkCliffs);
        register(RuBiomes.GRASSY_BEACH, CoastalBiomes::grassyBeach);
        register(RuBiomes.GRAVEL_BEACH, CoastalBiomes::gravelBeach);
        //AQUATIC
        register(RuBiomes.ALPHA_GROVE, AquaticBiomes::alphaGrove);
        register(RuBiomes.COLD_RIVER, AquaticBiomes::coldRiver);
        register(RuBiomes.HYACINTH_DEEPS, AquaticBiomes::hyacinthDeeps);
        register(RuBiomes.MUDDY_RIVER, AquaticBiomes::muddyRiver);
        register(RuBiomes.ROCKY_REEF, AquaticBiomes::rockyReef);
        register(RuBiomes.ASHEN_WOODLAND, AquaticBiomes::ashenWoodland);
        register(RuBiomes.TROPICAL_RIVER, AquaticBiomes::tropicalRiver);
        register(RuBiomes.TROPICS, AquaticBiomes::tropics);
        //FROZEN
        register(RuBiomes.COLD_BOREAL_TAIGA, FrozenBiomes::coldBorealTaiga);
        register(RuBiomes.COLD_DECIDUOUS_FOREST, FrozenBiomes::coldDeciduousForest);
        register(RuBiomes.FROZEN_PINE_TAIGA, FrozenBiomes::frozenPineTaiga);
        register(RuBiomes.FROZEN_TUNDRA, FrozenBiomes::frozenTundra);
        register(RuBiomes.ICY_HEIGHTS, FrozenBiomes::icyHeights);
        register(RuBiomes.SPIRES, FrozenBiomes::spires);
        //CAVE
        register(RuBiomes.ANCIENT_DELTA, CaveBiomes::ancientDelta);
        register(RuBiomes.BIOSHROOM_CAVES, CaveBiomes::bioshroomCaves);
        register(RuBiomes.PRISMACHASM, CaveBiomes::prismachasm);
        register(RuBiomes.REDSTONE_CAVES, CaveBiomes::redstoneCaves);
        register(RuBiomes.SCORCHING_CAVES, CaveBiomes::scorchingCaves);
        //NETHER
        register(RuBiomes.BLACKSTONE_BASIN, NetherBiomes::blackstoneBasin);
        register(RuBiomes.INFERNAL_HOLT, NetherBiomes::infernalHolt);
        register(RuBiomes.GLISTERING_MEADOW, NetherBiomes::glisteringMeadow);
        register(RuBiomes.MYCOTOXIC_UNDERGROWTH, NetherBiomes::mycotoxicUndergrowth);
        register(RuBiomes.REDSTONE_ABYSS, NetherBiomes::redstoneAbyss);
    }

    private static void registerVillagerTypes(){
        //FOREST
        registerVillagers(RuBiomes.AUTUMNAL_MAPLE_FOREST, VillagerType.PLAINS);
        registerVillagers(RuBiomes.BAMBOO_FOREST, VillagerType.JUNGLE);
        registerVillagers(RuBiomes.MAGNOLIA_WOODLAND, VillagerType.PLAINS);
        registerVillagers(RuBiomes.DECIDUOUS_FOREST, VillagerType.PLAINS);
        registerVillagers(RuBiomes.MAPLE_FOREST, VillagerType.TAIGA);
        registerVillagers(RuBiomes.MAUVE_HILLS, VillagerType.PLAINS);
        registerVillagers(RuBiomes.ORCHARD, VillagerType.PLAINS);
        registerVillagers(RuBiomes.SILVER_BIRCH_FOREST, VillagerType.PLAINS);
        registerVillagers(RuBiomes.TEMPERATE_GROVE, VillagerType.PLAINS);
        registerVillagers(RuBiomes.WILLOW_FOREST, VillagerType.PLAINS);
        //TAIGA
        registerVillagers(RuBiomes.BLACKWOOD_TAIGA, VillagerType.TAIGA);
        registerVillagers(RuBiomes.BOREAL_TAIGA, VillagerType.TAIGA);
        registerVillagers(RuBiomes.GOLDEN_BOREAL_TAIGA, VillagerType.TAIGA);
        registerVillagers(RuBiomes.PINE_TAIGA, VillagerType.TAIGA);
        registerVillagers(RuBiomes.REDWOODS, VillagerType.PLAINS);
        registerVillagers(RuBiomes.SPARSE_REDWOODS, VillagerType.PLAINS);
        //PLAINS
        registerVillagers(RuBiomes.BARLEY_FIELDS, VillagerType.PLAINS);
        registerVillagers(RuBiomes.FLOWER_FIELDS, VillagerType.PLAINS);
        registerVillagers(RuBiomes.GRASSLAND, VillagerType.PLAINS);
        registerVillagers(RuBiomes.CLOVER_PLAINS, VillagerType.PLAINS);
        registerVillagers(RuBiomes.ROCKY_MEADOW, VillagerType.PLAINS);
        registerVillagers(RuBiomes.POPPY_FIELDS, VillagerType.PLAINS);
        registerVillagers(RuBiomes.PRAIRIE, VillagerType.PLAINS);
        registerVillagers(RuBiomes.PUMPKIN_FIELDS, VillagerType.PLAINS);
        registerVillagers(RuBiomes.SHRUBLAND, VillagerType.TAIGA);
        //WET
        registerVillagers(RuBiomes.BAYOU, VillagerType.SWAMP);
        registerVillagers(RuBiomes.EUCALYPTUS_FOREST, VillagerType.JUNGLE);
        registerVillagers(RuBiomes.FEN, VillagerType.SWAMP);
        registerVillagers(RuBiomes.MARSH, VillagerType.SWAMP);
        registerVillagers(RuBiomes.FUNGAL_FEN, VillagerType.SWAMP);
        registerVillagers(RuBiomes.OLD_GROWTH_BAYOU, VillagerType.SWAMP);
        registerVillagers(RuBiomes.SPARSE_RAINFOREST, VillagerType.JUNGLE);
        registerVillagers(RuBiomes.RAINFOREST, VillagerType.JUNGLE);
        //ARID
        registerVillagers(RuBiomes.BAOBAB_SAVANNA, VillagerType.SAVANNA);
        registerVillagers(RuBiomes.DRY_BUSHLAND, VillagerType.SAVANNA);
        registerVillagers(RuBiomes.JOSHUA_DESERT, VillagerType.DESERT);
        registerVillagers(RuBiomes.OUTBACK, VillagerType.SAVANNA);
        registerVillagers(RuBiomes.SAGUARO_DESERT, VillagerType.DESERT);
        registerVillagers(RuBiomes.STEPPE, VillagerType.PLAINS);
        //MOUNTAIN
        registerVillagers(RuBiomes.ARID_MOUNTAINS, VillagerType.SAVANNA);
        registerVillagers(RuBiomes.HIGHLAND_FIELDS, VillagerType.PLAINS);
        registerVillagers(RuBiomes.MOUNTAINS, VillagerType.TAIGA);
        registerVillagers(RuBiomes.PINE_SLOPES, VillagerType.TAIGA);
        registerVillagers(RuBiomes.TOWERING_CLIFFS, VillagerType.TAIGA);
        //COASTAL
        registerVillagers(RuBiomes.CHALK_CLIFFS, VillagerType.PLAINS);
        registerVillagers(RuBiomes.GRASSY_BEACH, VillagerType.PLAINS);
        registerVillagers(RuBiomes.GRAVEL_BEACH, VillagerType.TAIGA);
        //AQUATIC
        registerVillagers(RuBiomes.ALPHA_GROVE, VillagerType.PLAINS);
        registerVillagers(RuBiomes.COLD_RIVER, VillagerType.PLAINS);
        registerVillagers(RuBiomes.HYACINTH_DEEPS, VillagerType.PLAINS);
        registerVillagers(RuBiomes.MUDDY_RIVER, VillagerType.PLAINS);
        registerVillagers(RuBiomes.ROCKY_REEF, VillagerType.JUNGLE);
        registerVillagers(RuBiomes.ASHEN_WOODLAND, VillagerType.TAIGA);
        registerVillagers(RuBiomes.TROPICAL_RIVER, VillagerType.JUNGLE);
        registerVillagers(RuBiomes.TROPICS, VillagerType.JUNGLE);
        //FROZEN
        registerVillagers(RuBiomes.COLD_BOREAL_TAIGA, VillagerType.SNOW);
        registerVillagers(RuBiomes.COLD_DECIDUOUS_FOREST, VillagerType.SNOW);
        registerVillagers(RuBiomes.FROZEN_PINE_TAIGA, VillagerType.SNOW);
        registerVillagers(RuBiomes.FROZEN_TUNDRA, VillagerType.SNOW);
        registerVillagers(RuBiomes.ICY_HEIGHTS, VillagerType.SNOW);
        registerVillagers(RuBiomes.SPIRES, VillagerType.SNOW);
        //CAVE
        registerVillagers(RuBiomes.BIOSHROOM_CAVES, VillagerType.PLAINS);
        registerVillagers(RuBiomes.ANCIENT_DELTA, VillagerType.PLAINS);
        registerVillagers(RuBiomes.PRISMACHASM, VillagerType.PLAINS);
        registerVillagers(RuBiomes.REDSTONE_CAVES, VillagerType.PLAINS);
        registerVillagers(RuBiomes.SCORCHING_CAVES, VillagerType.PLAINS);
        //NETHER
        registerVillagers(RuBiomes.BLACKSTONE_BASIN, VillagerType.PLAINS);
        registerVillagers(RuBiomes.INFERNAL_HOLT, VillagerType.PLAINS);
        registerVillagers(RuBiomes.GLISTERING_MEADOW, VillagerType.PLAINS);
        registerVillagers(RuBiomes.MYCOTOXIC_UNDERGROWTH, VillagerType.PLAINS);
        registerVillagers(RuBiomes.REDSTONE_ABYSS, VillagerType.PLAINS);

    }

    public static RegistryObject<Biome> register(ResourceKey<Biome> key, Supplier<Biome> biomeSupplier) {
        return RegionsUnexploredMod.BIOME_REGISTRY.register(key.location().getPath(), biomeSupplier);
    }

    private static void registerVillagers(ResourceKey<Biome> key, VillagerType type) {
        VillagerType.BY_BIOME.put(key, type);
    }
}