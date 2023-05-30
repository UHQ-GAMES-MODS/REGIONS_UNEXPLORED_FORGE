package net.regions_unexplored.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RuBiomeTagProvider extends BiomeTagsProvider {

    public RuBiomeTagProvider(PackOutput p_255800_, CompletableFuture<HolderLookup.Provider> p_256205_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_255800_, p_256205_, modId, existingFileHelper);
    }

    public void addTags(HolderLookup.Provider provider) {
        //HAS_STRUCTURE_TAGS
        this.tag(BiomeTags.HAS_ANCIENT_CITY)
        ;
        this.tag(BiomeTags.HAS_BASTION_REMNANT)
        ;
        this.tag(BiomeTags.HAS_BURIED_TREASURE)
        ;
        this.tag(BiomeTags.HAS_DESERT_PYRAMID)
        ;
        this.tag(BiomeTags.HAS_END_CITY)
        ;
        this.tag(BiomeTags.HAS_IGLOO)
        ;
        this.tag(BiomeTags.HAS_JUNGLE_TEMPLE)
        ;
        this.tag(BiomeTags.HAS_MINESHAFT)
        ;
        this.tag(BiomeTags.HAS_MINESHAFT_MESA)
        ;
        this.tag(BiomeTags.HAS_NETHER_FORTRESS)
        ;
        this.tag(BiomeTags.HAS_NETHER_FOSSIL)
        ;
        this.tag(BiomeTags.HAS_OCEAN_MONUMENT)
        ;
        this.tag(BiomeTags.HAS_OCEAN_RUIN_COLD)
        ;
        this.tag(BiomeTags.HAS_OCEAN_RUIN_WARM)
        ;
        this.tag(BiomeTags.HAS_PILLAGER_OUTPOST)
        ;
        this.tag(BiomeTags.HAS_RUINED_PORTAL_DESERT)
        ;
        this.tag(BiomeTags.HAS_RUINED_PORTAL_JUNGLE)
        ;
        this.tag(BiomeTags.HAS_RUINED_PORTAL_MOUNTAIN)
        ;
        this.tag(BiomeTags.HAS_RUINED_PORTAL_NETHER)
        ;
        this.tag(BiomeTags.HAS_RUINED_PORTAL_OCEAN)
        ;
        this.tag(BiomeTags.HAS_RUINED_PORTAL_STANDARD)
        ;
        this.tag(BiomeTags.HAS_RUINED_PORTAL_SWAMP)
        ;
        this.tag(BiomeTags.HAS_SHIPWRECK)
        ;
        this.tag(BiomeTags.HAS_SHIPWRECK_BEACHED)
        ;
        this.tag(BiomeTags.HAS_STRONGHOLD)
        ;
        this.tag(BiomeTags.HAS_SWAMP_HUT)
        ;
        this.tag(BiomeTags.HAS_VILLAGE_DESERT)
        ;
        this.tag(BiomeTags.HAS_VILLAGE_PLAINS)
        ;
        this.tag(BiomeTags.HAS_VILLAGE_SAVANNA)
        ;
        this.tag(BiomeTags.HAS_VILLAGE_SNOWY)
        ;
        this.tag(BiomeTags.HAS_VILLAGE_TAIGA)
        ;
        this.tag(BiomeTags.HAS_WOODLAND_MANSION)
        ;
        //MINECRAFT_TAGS
        this.tag(BiomeTags.ALLOWS_SURFACE_SLIME_SPAWNS)
                .addOptional(RuBiomes.BAYOU.location())
                .addOptional(RuBiomes.FEN.location())
                .addOptional(RuBiomes.FUNGAL_FEN.location())
                .addOptional(RuBiomes.FLOODED_PLAINS.location())
                .addOptional(RuBiomes.GIANT_BAYOU.location())
        ;
        this.tag(BiomeTags.ALLOWS_TROPICAL_FISH_SPAWNS_AT_ANY_HEIGHT)
                .addOptional(RuBiomes.LUSH_DELTA.location())
                .addOptional(RuBiomes.BIOSHROOM_CAVES.location())
        ;
        this.tag(BiomeTags.HAS_CLOSER_WATER_FOG)
                .addOptional(RuBiomes.BAYOU.location())
                .addOptional(RuBiomes.FEN.location())
                .addOptional(RuBiomes.FUNGAL_FEN.location())
                .addOptional(RuBiomes.FLOODED_PLAINS.location())
                .addOptional(RuBiomes.GIANT_BAYOU.location())
        ;
        this.tag(BiomeTags.INCREASED_FIRE_BURNOUT)
                .addOptional(RuBiomes.BAYOU.location())
                .addOptional(RuBiomes.FEN.location())
                .addOptional(RuBiomes.FUNGAL_FEN.location())
                .addOptional(RuBiomes.FLOODED_PLAINS.location())
                .addOptional(RuBiomes.GIANT_BAYOU.location())
                .addOptional(RuBiomes.REDWOODS.location())
                .addOptional(RuBiomes.SPARSE_REDWOODS.location())
                .addOptional(RuBiomes.BAMBOO_FOREST.location())
                .addOptional(RuBiomes.RAINFOREST.location())
                .addOptional(RuBiomes.OLD_GROWTH_RAINFOREST.location())
                .addOptional(RuBiomes.EUCALYPTUS_FOREST.location())
                .addOptional(RuBiomes.ROCKY_REEF.location())
        ;
        this.tag(BiomeTags.IS_BADLANDS)
                .addOptional(RuBiomes.ARID_MOUNTAINS.location())
        ;
        this.tag(BiomeTags.IS_BEACH)
                .addOptional(RuBiomes.GRAVEL_BEACH.location())
                .addOptional(RuBiomes.GRASSY_BEACH.location())
        ;
        this.tag(BiomeTags.IS_DEEP_OCEAN)
                .addOptional(RuBiomes.HYACINTH_DEEPS.location())
        ;
        this.tag(BiomeTags.IS_END)
        ;
        this.tag(BiomeTags.IS_FOREST)
                .addOptional(RuBiomes.ALPHA_GROVE.location())
                .addOptional(RuBiomes.AUTUMNAL_MAPLE_FOREST.location())
                .addOptional(RuBiomes.BAMBOO_FOREST.location())
                .addOptional(RuBiomes.DARK_SAKURA_GROVE.location())
                .addOptional(RuBiomes.DECIDUOUS_FOREST.location())
                .addOptional(RuBiomes.MAPLE_FOREST.location())
                .addOptional(RuBiomes.MAUVE_HILLS.location())
                .addOptional(RuBiomes.ORCHARD.location())
                .addOptional(RuBiomes.SILVER_BIRCH_FOREST.location())
                .addOptional(RuBiomes.TEMPERATE_GROVE.location())
                .addOptional(RuBiomes.WILLOW_FOREST.location())
        ;
        this.tag(BiomeTags.IS_HILL)
                .addOptional(RuBiomes.LUSH_HILLS.location())
                .addOptional(RuBiomes.TOWERING_CLIFFS.location())
                .addOptional(RuBiomes.ICY_HEIGHTS.location())
        ;
        this.tag(BiomeTags.IS_JUNGLE)
                .addOptional(RuBiomes.RAINFOREST.location())
                .addOptional(RuBiomes.OLD_GROWTH_RAINFOREST.location())
                .addOptional(RuBiomes.EUCALYPTUS_FOREST.location())
        ;
        this.tag(BiomeTags.IS_MOUNTAIN)
                .addOptional(RuBiomes.LUSH_HILLS.location())
                .addOptional(RuBiomes.TOWERING_CLIFFS.location())
                .addOptional(RuBiomes.ICY_HEIGHTS.location())
                .addOptional(RuBiomes.HIGHLAND_FIELDS.location())
                .addOptional(RuBiomes.MOUNTAINS.location())
                .addOptional(RuBiomes.ARID_MOUNTAINS.location())
        ;
        this.tag(BiomeTags.IS_NETHER)
                .addOptional(RuBiomes.MYCOTOXIC_UNDERGROWTH.location())
                .addOptional(RuBiomes.BLACKSTONE_BASIN.location())
                .addOptional(RuBiomes.CORRUPTED_HOLT.location())
                .addOptional(RuBiomes.GLISTERING_MEADOW.location())
                .addOptional(RuBiomes.REDSTONE_HELL.location())
        ;
        this.tag(BiomeTags.IS_OCEAN)
                .addOptional(RuBiomes.ROCKY_REEF.location())
        ;
        this.tag(BiomeTags.IS_OVERWORLD)
                .addOptional(RuBiomes.AUTUMNAL_MAPLE_FOREST.location())
                .addOptional(RuBiomes.BAMBOO_FOREST.location())
                .addOptional(RuBiomes.DARK_SAKURA_GROVE.location())
                .addOptional(RuBiomes.DECIDUOUS_FOREST.location())
                .addOptional(RuBiomes.MAPLE_FOREST.location())
                .addOptional(RuBiomes.MAUVE_HILLS.location())
                .addOptional(RuBiomes.ORCHARD.location())
                .addOptional(RuBiomes.SILVER_BIRCH_FOREST.location())
                .addOptional(RuBiomes.TEMPERATE_GROVE.location())
                .addOptional(RuBiomes.WILLOW_FOREST.location())
                //TAIGA
                .addOptional(RuBiomes.BLACKWOOD_FOREST.location())
                .addOptional(RuBiomes.BOREAL_FOREST.location())
                .addOptional(RuBiomes.GOLDEN_BOREAL_FOREST.location())
                .addOptional(RuBiomes.PINE_FOREST.location())
                .addOptional(RuBiomes.REDWOODS.location())
                .addOptional(RuBiomes.SPARSE_REDWOODS.location())
                //PLAINS
                .addOptional(RuBiomes.BARLEY_FIELDS.location())
                .addOptional(RuBiomes.FLOWER_FIELDS.location())
                .addOptional(RuBiomes.GRASSLAND.location())
                .addOptional(RuBiomes.LUPINE_PLAINS.location())
                .addOptional(RuBiomes.MEADOW.location())
                .addOptional(RuBiomes.POPPY_FIELDS.location())
                .addOptional(RuBiomes.PRAIRIE.location())
                .addOptional(RuBiomes.PUMPKIN_FIELDS.location())
                .addOptional(RuBiomes.SHRUBLAND.location())
                //WET
                .addOptional(RuBiomes.BAYOU.location())
                .addOptional(RuBiomes.EUCALYPTUS_FOREST.location())
                .addOptional(RuBiomes.FEN.location())
                .addOptional(RuBiomes.FLOODED_PLAINS.location())
                .addOptional(RuBiomes.FUNGAL_FEN.location())
                .addOptional(RuBiomes.GIANT_BAYOU.location())
                .addOptional(RuBiomes.OLD_GROWTH_RAINFOREST.location())
                .addOptional(RuBiomes.RAINFOREST.location())
                //ARID
                .addOptional(RuBiomes.BAOBAB_SAVANNA.location())
                .addOptional(RuBiomes.DRY_BUSHLAND.location())
                .addOptional(RuBiomes.JOSHUA_DESERT.location())
                .addOptional(RuBiomes.OUTBACK.location())
                .addOptional(RuBiomes.SAGUARO_DESERT.location())
                .addOptional(RuBiomes.STEPPE.location())
                //MOUNTAIN
                .addOptional(RuBiomes.ARID_MOUNTAINS.location())
                .addOptional(RuBiomes.HIGHLAND_FIELDS.location())
                .addOptional(RuBiomes.LUSH_HILLS.location())
                .addOptional(RuBiomes.MOUNTAINS.location())
                .addOptional(RuBiomes.PINE_SLOPES.location())
                .addOptional(RuBiomes.TOWERING_CLIFFS.location())
                //COASTAL
                .addOptional(RuBiomes.CHALK_CLIFFS.location())
                .addOptional(RuBiomes.GRASSY_BEACH.location())
                .addOptional(RuBiomes.GRAVEL_BEACH.location())
                //AQUATIC
                .addOptional(RuBiomes.ALPHA_GROVE.location())
                .addOptional(RuBiomes.COLD_RIVER.location())
                .addOptional(RuBiomes.HYACINTH_DEEPS.location())
                .addOptional(RuBiomes.MUDDY_RIVER.location())
                .addOptional(RuBiomes.ROCKY_REEF.location())
                .addOptional(RuBiomes.SMOULDERING_WOODLAND.location())
                .addOptional(RuBiomes.TROPICS.location())
                //FROZEN
                .addOptional(RuBiomes.COLD_BOREAL_FOREST.location())
                .addOptional(RuBiomes.COLD_DECIDUOUS_FOREST.location())
                .addOptional(RuBiomes.FROZEN_FOREST.location())
                .addOptional(RuBiomes.FROZEN_TUNDRA.location())
                .addOptional(RuBiomes.ICY_DESERT.location())
                .addOptional(RuBiomes.ICY_HEIGHTS.location())
                .addOptional(RuBiomes.SPIRES.location())
                //CAVE
                .addOptional(RuBiomes.BIOSHROOM_CAVES.location())
                .addOptional(RuBiomes.LUSH_DELTA.location())
                .addOptional(RuBiomes.PRISMACHASM.location())
                .addOptional(RuBiomes.REDSTONE_CAVES.location())
                .addOptional(RuBiomes.SCORCHING_CAVES.location())
        ;
        this.tag(BiomeTags.IS_RIVER)
                .addOptional(RuBiomes.COLD_RIVER.location())
                .addOptional(RuBiomes.MUDDY_RIVER.location())
        ;
        this.tag(BiomeTags.IS_SAVANNA)
                .addOptional(RuBiomes.STEPPE.location())
                .addOptional(RuBiomes.BAOBAB_SAVANNA.location())
                .addOptional(RuBiomes.DRY_BUSHLAND.location())
        ;
        this.tag(BiomeTags.IS_TAIGA)
                .addOptional(RuBiomes.BLACKWOOD_FOREST.location())
                .addOptional(RuBiomes.BOREAL_FOREST.location())
                .addOptional(RuBiomes.GOLDEN_BOREAL_FOREST.location())
                .addOptional(RuBiomes.PINE_FOREST.location())
                .addOptional(RuBiomes.REDWOODS.location())
                .addOptional(RuBiomes.SPARSE_REDWOODS.location())
        ;
        this.tag(BiomeTags.MINESHAFT_BLOCKING)
                .addOptional(RuBiomes.SCORCHING_CAVES.location())
        ;
        this.tag(BiomeTags.MORE_FREQUENT_DROWNED_SPAWNS)
        ;
        this.tag(BiomeTags.PLAYS_UNDERWATER_MUSIC)
        ;
        this.tag(BiomeTags.POLAR_BEARS_SPAWN_ON_ALTERNATE_BLOCKS)
                .addOptional(RuBiomes.FROZEN_TUNDRA.location())
                .addOptional(RuBiomes.ICY_DESERT.location())
        ;
        this.tag(BiomeTags.PRODUCES_CORALS_FROM_BONEMEAL)
                .addOptional(RuBiomes.TROPICS.location())
                .addOptional(RuBiomes.ROCKY_REEF.location())
        ;
        this.tag(BiomeTags.REDUCED_WATER_AMBIENT_SPAWNS)
        ;
        this.tag(BiomeTags.REQUIRED_OCEAN_MONUMENT_SURROUNDING)
        ;
        this.tag(BiomeTags.SNOW_GOLEM_MELTS)
                .addOptional(RuBiomes.JOSHUA_DESERT.location())
                .addOptional(RuBiomes.SAGUARO_DESERT.location())
                .addOptional(RuBiomes.OUTBACK.location())
                .addOptional(RuBiomes.ARID_MOUNTAINS.location())
                .addOptional(RuBiomes.STEPPE.location())
                .addOptional(RuBiomes.BAOBAB_SAVANNA.location())
                .addOptional(RuBiomes.DRY_BUSHLAND.location())
        ;
        this.tag(BiomeTags.SPAWNS_COLD_VARIANT_FROGS)
                .addOptional(RuBiomes.ALPHA_GROVE.location())
                .addOptional(RuBiomes.COLD_DECIDUOUS_FOREST.location())
                .addOptional(RuBiomes.COLD_BOREAL_FOREST.location())
                .addOptional(RuBiomes.ICY_DESERT.location())
                .addOptional(RuBiomes.ICY_HEIGHTS.location())
                .addOptional(RuBiomes.FROZEN_FOREST.location())
                .addOptional(RuBiomes.FROZEN_TUNDRA.location())
        ;
        this.tag(BiomeTags.SPAWNS_GOLD_RABBITS)
                .addOptional(RuBiomes.JOSHUA_DESERT.location())
                .addOptional(RuBiomes.SAGUARO_DESERT.location())
                .addOptional(RuBiomes.OUTBACK.location())
        ;
        this.tag(BiomeTags.SPAWNS_SNOW_FOXES)
                .addOptional(RuBiomes.ALPHA_GROVE.location())
                .addOptional(RuBiomes.COLD_DECIDUOUS_FOREST.location())
                .addOptional(RuBiomes.COLD_BOREAL_FOREST.location())
                .addOptional(RuBiomes.ICY_DESERT.location())
                .addOptional(RuBiomes.ICY_HEIGHTS.location())
                .addOptional(RuBiomes.FROZEN_FOREST.location())
                .addOptional(RuBiomes.FROZEN_TUNDRA.location())
        ;
        this.tag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS)
                .addOptional(RuBiomes.JOSHUA_DESERT.location())
                .addOptional(RuBiomes.SAGUARO_DESERT.location())
                .addOptional(RuBiomes.OUTBACK.location())
                .addOptional(RuBiomes.TROPICS.location())
                .addOptional(RuBiomes.BAMBOO_FOREST.location())
                .addOptional(RuBiomes.GIANT_BAYOU.location())
                .addOptional(RuBiomes.FLOODED_PLAINS.location())
                .addOptional(RuBiomes.FUNGAL_FEN.location())
        ;
        this.tag(BiomeTags.SPAWNS_WHITE_RABBITS)
                .addOptional(RuBiomes.ALPHA_GROVE.location())
                .addOptional(RuBiomes.COLD_DECIDUOUS_FOREST.location())
                .addOptional(RuBiomes.COLD_BOREAL_FOREST.location())
                .addOptional(RuBiomes.ICY_DESERT.location())
                .addOptional(RuBiomes.ICY_HEIGHTS.location())
                .addOptional(RuBiomes.FROZEN_FOREST.location())
                .addOptional(RuBiomes.FROZEN_TUNDRA.location())
        ;
        this.tag(BiomeTags.STRONGHOLD_BIASED_TO)
                .addOptional(RuBiomes.AUTUMNAL_MAPLE_FOREST.location())
                .addOptional(RuBiomes.BAMBOO_FOREST.location())
                .addOptional(RuBiomes.DARK_SAKURA_GROVE.location())
                .addOptional(RuBiomes.DECIDUOUS_FOREST.location())
                .addOptional(RuBiomes.MAPLE_FOREST.location())
                .addOptional(RuBiomes.MAUVE_HILLS.location())
                .addOptional(RuBiomes.ORCHARD.location())
                .addOptional(RuBiomes.SILVER_BIRCH_FOREST.location())
                .addOptional(RuBiomes.TEMPERATE_GROVE.location())
                .addOptional(RuBiomes.WILLOW_FOREST.location())
                //TAIGA
                .addOptional(RuBiomes.BLACKWOOD_FOREST.location())
                .addOptional(RuBiomes.BOREAL_FOREST.location())
                .addOptional(RuBiomes.GOLDEN_BOREAL_FOREST.location())
                .addOptional(RuBiomes.PINE_FOREST.location())
                .addOptional(RuBiomes.REDWOODS.location())
                .addOptional(RuBiomes.SPARSE_REDWOODS.location())
                //PLAINS
                .addOptional(RuBiomes.BARLEY_FIELDS.location())
                .addOptional(RuBiomes.FLOWER_FIELDS.location())
                .addOptional(RuBiomes.GRASSLAND.location())
                .addOptional(RuBiomes.LUPINE_PLAINS.location())
                .addOptional(RuBiomes.MEADOW.location())
                .addOptional(RuBiomes.POPPY_FIELDS.location())
                .addOptional(RuBiomes.PRAIRIE.location())
                .addOptional(RuBiomes.PUMPKIN_FIELDS.location())
                .addOptional(RuBiomes.SHRUBLAND.location())
                //WET
                .addOptional(RuBiomes.EUCALYPTUS_FOREST.location())
                .addOptional(RuBiomes.FUNGAL_FEN.location())
                .addOptional(RuBiomes.OLD_GROWTH_RAINFOREST.location())
                .addOptional(RuBiomes.RAINFOREST.location())
                //ARID
                .addOptional(RuBiomes.BAOBAB_SAVANNA.location())
                .addOptional(RuBiomes.DRY_BUSHLAND.location())
                .addOptional(RuBiomes.JOSHUA_DESERT.location())
                .addOptional(RuBiomes.OUTBACK.location())
                .addOptional(RuBiomes.SAGUARO_DESERT.location())
                .addOptional(RuBiomes.STEPPE.location())
                //MOUNTAIN
                .addOptional(RuBiomes.ARID_MOUNTAINS.location())
                .addOptional(RuBiomes.HIGHLAND_FIELDS.location())
                .addOptional(RuBiomes.LUSH_HILLS.location())
                .addOptional(RuBiomes.MOUNTAINS.location())
                .addOptional(RuBiomes.PINE_SLOPES.location())
                .addOptional(RuBiomes.TOWERING_CLIFFS.location())
                //AQUATIC
                .addOptional(RuBiomes.COLD_RIVER.location())
                .addOptional(RuBiomes.MUDDY_RIVER.location())
                //FROZEN
                .addOptional(RuBiomes.COLD_BOREAL_FOREST.location())
                .addOptional(RuBiomes.COLD_DECIDUOUS_FOREST.location())
                .addOptional(RuBiomes.FROZEN_FOREST.location())
                .addOptional(RuBiomes.FROZEN_TUNDRA.location())
                .addOptional(RuBiomes.ICY_DESERT.location())
                .addOptional(RuBiomes.ICY_HEIGHTS.location())
                .addOptional(RuBiomes.SPIRES.location())
                //CAVE
                .addOptional(RuBiomes.BIOSHROOM_CAVES.location())
                .addOptional(RuBiomes.LUSH_DELTA.location())
                .addOptional(RuBiomes.PRISMACHASM.location())
                .addOptional(RuBiomes.REDSTONE_CAVES.location())
        ;
        this.tag(BiomeTags.WATER_ON_MAP_OUTLINES)
                .addOptional(RuBiomes.BAYOU.location())
                .addOptional(RuBiomes.FEN.location())
                .addOptional(RuBiomes.FUNGAL_FEN.location())
                .addOptional(RuBiomes.FLOODED_PLAINS.location())
                .addOptional(RuBiomes.GIANT_BAYOU.location())
        ;
        this.tag(BiomeTags.WITHOUT_PATROL_SPAWNS)
                .addOptional(RuBiomes.TROPICS.location())
                .addOptional(RuBiomes.ALPHA_GROVE.location())
                .addOptional(RuBiomes.SMOULDERING_WOODLAND.location())
        ;
        this.tag(BiomeTags.WITHOUT_WANDERING_TRADER_SPAWNS)
                .addOptional(RuBiomes.TROPICS.location())
                .addOptional(RuBiomes.ALPHA_GROVE.location())
                .addOptional(RuBiomes.SMOULDERING_WOODLAND.location())
        ;
        this.tag(BiomeTags.WITHOUT_ZOMBIE_SIEGES)
                .addOptional(RuBiomes.TROPICS.location())
                .addOptional(RuBiomes.ALPHA_GROVE.location())
                .addOptional(RuBiomes.SMOULDERING_WOODLAND.location())
        ;
        //FORGE_TAGS
        //is_cold
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_cold/end")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_cold/nether")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_cold/overworld")))
                .addOptional(RuBiomes.ALPHA_GROVE.location())
                .addOptional(RuBiomes.AUTUMNAL_MAPLE_FOREST.location())
                .addOptional(RuBiomes.PUMPKIN_FIELDS.location())
                .addOptional(RuBiomes.POPPY_FIELDS.location())
                .addOptional(RuBiomes.HYACINTH_DEEPS.location())
                .addOptional(RuBiomes.SILVER_BIRCH_FOREST.location())
                .addOptional(RuBiomes.BOREAL_FOREST.location())
                .addOptional(RuBiomes.GOLDEN_BOREAL_FOREST.location())
                .addOptional(RuBiomes.COLD_DECIDUOUS_FOREST.location())
                .addOptional(RuBiomes.COLD_BOREAL_FOREST.location())
                .addOptional(RuBiomes.ICY_DESERT.location())
                .addOptional(RuBiomes.ICY_HEIGHTS.location())
                .addOptional(RuBiomes.FROZEN_FOREST.location())
                .addOptional(RuBiomes.FROZEN_TUNDRA.location())
        ;
        //is_dense
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_dense/end")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_dense/nether")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_dense/overworld")))
                .addOptional(RuBiomes.BLACKWOOD_FOREST.location())
                .addOptional(RuBiomes.BOREAL_FOREST.location())
                .addOptional(RuBiomes.GOLDEN_BOREAL_FOREST.location())
                .addOptional(RuBiomes.REDWOODS.location())
                .addOptional(RuBiomes.BAMBOO_FOREST.location())
                .addOptional(RuBiomes.DECIDUOUS_FOREST.location())
                .addOptional(RuBiomes.RAINFOREST.location())
                .addOptional(RuBiomes.OLD_GROWTH_RAINFOREST.location())
                .addOptional(RuBiomes.BAYOU.location())
                .addOptional(RuBiomes.GIANT_BAYOU.location())
        ;
        //is_dry
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_dry/end")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_dry/nether")))
                .addOptional(RuBiomes.MYCOTOXIC_UNDERGROWTH.location())
                .addOptional(RuBiomes.BLACKSTONE_BASIN.location())
                .addOptional(RuBiomes.CORRUPTED_HOLT.location())
                .addOptional(RuBiomes.GLISTERING_MEADOW.location())
                .addOptional(RuBiomes.REDSTONE_HELL.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_dry/overworld")))
                .addOptional(RuBiomes.JOSHUA_DESERT.location())
                .addOptional(RuBiomes.SAGUARO_DESERT.location())
                .addOptional(RuBiomes.OUTBACK.location())
                .addOptional(RuBiomes.ARID_MOUNTAINS.location())
                .addOptional(RuBiomes.STEPPE.location())
                .addOptional(RuBiomes.BAOBAB_SAVANNA.location())
                .addOptional(RuBiomes.DRY_BUSHLAND.location())
        ;
        //is_hot
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_hot/end")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_hot/nether")))
                .addOptional(RuBiomes.MYCOTOXIC_UNDERGROWTH.location())
                .addOptional(RuBiomes.BLACKSTONE_BASIN.location())
                .addOptional(RuBiomes.CORRUPTED_HOLT.location())
                .addOptional(RuBiomes.GLISTERING_MEADOW.location())
                .addOptional(RuBiomes.REDSTONE_HELL.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_hot/overworld")))
                .addOptional(RuBiomes.JOSHUA_DESERT.location())
                .addOptional(RuBiomes.SAGUARO_DESERT.location())
                .addOptional(RuBiomes.OUTBACK.location())
                .addOptional(RuBiomes.ARID_MOUNTAINS.location())
                .addOptional(RuBiomes.STEPPE.location())
                .addOptional(RuBiomes.BAOBAB_SAVANNA.location())
                .addOptional(RuBiomes.DRY_BUSHLAND.location())
                .addOptional(RuBiomes.RAINFOREST.location())
                .addOptional(RuBiomes.OLD_GROWTH_RAINFOREST.location())
                .addOptional(RuBiomes.GRASSLAND.location())
                .addOptional(RuBiomes.EUCALYPTUS_FOREST.location())
        ;
        //is_sparse
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_sparse/end")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_sparse/nether")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_sparse/overworld")))
                .addOptional(RuBiomes.BAOBAB_SAVANNA.location())
                .addOptional(RuBiomes.DRY_BUSHLAND.location())
                .addOptional(RuBiomes.TEMPERATE_GROVE.location())
                .addOptional(RuBiomes.LUSH_HILLS.location())
                .addOptional(RuBiomes.ICY_HEIGHTS.location())
                .addOptional(RuBiomes.TOWERING_CLIFFS.location())
        ;
        //is_wet
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_wet/end")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_wet/nether")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_wet/overworld")))
                .addOptional(RuBiomes.RAINFOREST.location())
                .addOptional(RuBiomes.OLD_GROWTH_RAINFOREST.location())
                .addOptional(RuBiomes.REDWOODS.location())
                .addOptional(RuBiomes.SPARSE_REDWOODS.location())
                .addOptional(RuBiomes.EUCALYPTUS_FOREST.location())
                .addOptional(RuBiomes.BLACKWOOD_FOREST.location())
        ;
        //other_forge_tags
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_cave")))
                .addOptional(RuBiomes.LUSH_DELTA.location())
                .addOptional(RuBiomes.REDSTONE_CAVES.location())
                .addOptional(RuBiomes.PRISMACHASM.location())
                .addOptional(RuBiomes.BIOSHROOM_CAVES.location())
                .addOptional(RuBiomes.SCORCHING_CAVES.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_cold")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_coniferous")))
                .addOptional(RuBiomes.BLACKWOOD_FOREST.location())
                .addOptional(RuBiomes.BOREAL_FOREST.location())
                .addOptional(RuBiomes.GOLDEN_BOREAL_FOREST.location())
                .addOptional(RuBiomes.PINE_FOREST.location())
                .addOptional(RuBiomes.REDWOODS.location())
                .addOptional(RuBiomes.SPARSE_REDWOODS.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_dense")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_desert")))
                .addOptional(RuBiomes.JOSHUA_DESERT.location())
                .addOptional(RuBiomes.SAGUARO_DESERT.location())
                .addOptional(RuBiomes.OUTBACK.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_dry")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_hot")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_lush")))
                .addOptional(RuBiomes.LUSH_DELTA.location())
                .addOptional(RuBiomes.BIOSHROOM_CAVES.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_mountain")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_mushroom")))
                .addOptional(RuBiomes.BLACKWOOD_FOREST.location())
                .addOptional(RuBiomes.BIOSHROOM_CAVES.location())
                .addOptional(RuBiomes.FUNGAL_FEN.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_peak")))
                .addOptional(RuBiomes.ARID_MOUNTAINS.location())
                .addOptional(RuBiomes.MOUNTAINS.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_plains")))
                .addOptional(RuBiomes.BARLEY_FIELDS.location())
                .addOptional(RuBiomes.FLOWER_FIELDS.location())
                .addOptional(RuBiomes.GRASSLAND.location())
                .addOptional(RuBiomes.LUPINE_PLAINS.location())
                .addOptional(RuBiomes.MEADOW.location())
                .addOptional(RuBiomes.POPPY_FIELDS.location())
                .addOptional(RuBiomes.PRAIRIE.location())
                .addOptional(RuBiomes.PUMPKIN_FIELDS.location())
                .addOptional(RuBiomes.SHRUBLAND.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_plateau")))
                .addOptional(RuBiomes.DARK_SAKURA_GROVE.location())
                .addOptional(RuBiomes.HIGHLAND_FIELDS.location())
                .addOptional(RuBiomes.STEPPE.location())
                .addOptional(RuBiomes.ICY_HEIGHTS.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_rare")))
                .addOptional(RuBiomes.ALPHA_GROVE.location())
                .addOptional(RuBiomes.TROPICS.location())
                .addOptional(RuBiomes.SMOULDERING_WOODLAND.location())
                .addOptional(RuBiomes.FUNGAL_FEN.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_sandy")))
                .addOptional(RuBiomes.JOSHUA_DESERT.location())
                .addOptional(RuBiomes.SAGUARO_DESERT.location())
                .addOptional(RuBiomes.OUTBACK.location())
                .addOptional(RuBiomes.GRASSY_BEACH.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_slope")))
                .addOptional(RuBiomes.PINE_SLOPES.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_snowy")))
                .addOptional(RuBiomes.ALPHA_GROVE.location())
                .addOptional(RuBiomes.COLD_DECIDUOUS_FOREST.location())
                .addOptional(RuBiomes.COLD_BOREAL_FOREST.location())
                .addOptional(RuBiomes.ICY_DESERT.location())
                .addOptional(RuBiomes.ICY_HEIGHTS.location())
                .addOptional(RuBiomes.FROZEN_FOREST.location())
                .addOptional(RuBiomes.FROZEN_TUNDRA.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_sparse")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_spooky")))
                .addOptional(RuBiomes.BLACKWOOD_FOREST.location())
                .addOptional(RuBiomes.SMOULDERING_WOODLAND.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_swamp")))
                .addOptional(RuBiomes.BAYOU.location())
                .addOptional(RuBiomes.FEN.location())
                .addOptional(RuBiomes.FUNGAL_FEN.location())
                .addOptional(RuBiomes.FLOODED_PLAINS.location())
                .addOptional(RuBiomes.GIANT_BAYOU.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_underground")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_void")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_wasteland")))
                .addOptional(RuBiomes.SMOULDERING_WOODLAND.location())
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_water")))
        ;
        this.tag(TagKey.create(Registries.BIOME, new ResourceLocation("forge", "is_wet")))
        ;
    }
}
