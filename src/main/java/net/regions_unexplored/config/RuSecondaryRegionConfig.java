package net.regions_unexplored.config;

import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.ForgeConfigSpec;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;
import net.regions_unexplored.world.level.biome.DefaultBiomes;

public class RuSecondaryRegionConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;
    //MIDDLE_BIOMES
    public static final ForgeConfigSpec.ConfigValue<String> MID_ICY_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> MID_ICY_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> MID_ICY_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> MID_ICY_WET;
    public static final ForgeConfigSpec.ConfigValue<String> MID_ICY_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> MID_COOL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> MID_COOL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> MID_COOL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> MID_COOL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> MID_COOL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> MID_NEUTRAL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> MID_NEUTRAL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> MID_NEUTRAL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> MID_NEUTRAL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> MID_NEUTRAL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> MID_WARM_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> MID_WARM_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> MID_WARM_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> MID_WARM_WET;
    public static final ForgeConfigSpec.ConfigValue<String> MID_WARM_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> MID_HOT_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> MID_HOT_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> MID_HOT_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> MID_HOT_WET;
    public static final ForgeConfigSpec.ConfigValue<String> MID_HOT_HUMID;
    //MIDDLE_BIOMES_VARIANT
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_ICY_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_ICY_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_ICY_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_ICY_WET;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_ICY_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_COOL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_COOL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_COOL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_COOL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_COOL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_NEUTRAL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_NEUTRAL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_NEUTRAL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_NEUTRAL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_NEUTRAL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_WARM_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_WARM_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_WARM_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_WARM_WET;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_WARM_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_HOT_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_HOT_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_HOT_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_HOT_WET;
    public static final ForgeConfigSpec.ConfigValue<String> MID_VAR_HOT_HUMID;
    //PLATEAU_BIOMES
    public static final ForgeConfigSpec.ConfigValue<String> PLT_ICY_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_ICY_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_ICY_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_ICY_WET;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_ICY_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> PLT_COOL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_COOL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_COOL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_COOL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_COOL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> PLT_NEUTRAL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_NEUTRAL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_NEUTRAL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_NEUTRAL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_NEUTRAL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> PLT_WARM_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_WARM_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_WARM_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_WARM_WET;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_WARM_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> PLT_HOT_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_HOT_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_HOT_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_HOT_WET;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_HOT_HUMID;
    //PLATEAU_BIOMES_VARIANT
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_ICY_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_ICY_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_ICY_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_ICY_WET;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_ICY_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_COOL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_COOL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_COOL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_COOL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_COOL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_NEUTRAL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_NEUTRAL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_NEUTRAL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_NEUTRAL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_NEUTRAL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_WARM_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_WARM_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_WARM_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_WARM_WET;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_WARM_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_HOT_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_HOT_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_HOT_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_HOT_WET;
    public static final ForgeConfigSpec.ConfigValue<String> PLT_VAR_HOT_HUMID;
    //SHATTERED_BIOMES
    public static final ForgeConfigSpec.ConfigValue<String> SHT_ICY_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_ICY_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_ICY_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_ICY_WET;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_ICY_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> SHT_COOL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_COOL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_COOL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_COOL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_COOL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> SHT_NEUTRAL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_NEUTRAL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_NEUTRAL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_NEUTRAL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_NEUTRAL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> SHT_WARM_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_WARM_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_WARM_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_WARM_WET;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_WARM_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> SHT_HOT_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_HOT_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_HOT_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_HOT_WET;
    public static final ForgeConfigSpec.ConfigValue<String> SHT_HOT_HUMID;
    //SLOPE_BIOMES
    public static final ForgeConfigSpec.ConfigValue<String> ICY_SLOPE;
    public static final ForgeConfigSpec.ConfigValue<String> COOL_SLOPE;
    public static final ForgeConfigSpec.ConfigValue<String> NEUTRAL_SLOPE;
    public static final ForgeConfigSpec.ConfigValue<String> WARM_SLOPE;
    public static final ForgeConfigSpec.ConfigValue<String> HOT_SLOPE;
    public static final ForgeConfigSpec.ConfigValue<String> ICY_SLOPE_VAR;
    public static final ForgeConfigSpec.ConfigValue<String> COOL_SLOPE_VAR;
    public static final ForgeConfigSpec.ConfigValue<String> NEUTRAL_SLOPE_VAR;
    public static final ForgeConfigSpec.ConfigValue<String> WARM_SLOPE_VAR;
    public static final ForgeConfigSpec.ConfigValue<String> HOT_SLOPE_VAR;
    //PEAK_BIOMES
    public static final ForgeConfigSpec.ConfigValue<String> ICY_PEAK;
    public static final ForgeConfigSpec.ConfigValue<String> COOL_PEAK;
    public static final ForgeConfigSpec.ConfigValue<String> NEUTRAL_PEAK;
    public static final ForgeConfigSpec.ConfigValue<String> WARM_PEAK;
    public static final ForgeConfigSpec.ConfigValue<String> HOT_PEAK;
    public static final ForgeConfigSpec.ConfigValue<String> ICY_PEAK_VAR;
    public static final ForgeConfigSpec.ConfigValue<String> COOL_PEAK_VAR;
    public static final ForgeConfigSpec.ConfigValue<String> NEUTRAL_PEAK_VAR;
    public static final ForgeConfigSpec.ConfigValue<String> WARM_PEAK_VAR;
    public static final ForgeConfigSpec.ConfigValue<String> HOT_PEAK_VAR;
    //RIVER_BIOMES
    public static final ForgeConfigSpec.ConfigValue<String> RVR_ICY_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_ICY_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_ICY_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_ICY_WET;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_ICY_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> RVR_COOL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_COOL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_COOL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_COOL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_COOL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> RVR_NEUTRAL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_NEUTRAL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_NEUTRAL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_NEUTRAL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_NEUTRAL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> RVR_WARM_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_WARM_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_WARM_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_WARM_WET;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_WARM_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> RVR_HOT_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_HOT_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_HOT_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_HOT_WET;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_HOT_HUMID;
    //RIVER_BIOMES_VARIANT
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_ICY_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_ICY_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_ICY_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_ICY_WET;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_ICY_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_COOL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_COOL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_COOL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_COOL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_COOL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_NEUTRAL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_NEUTRAL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_NEUTRAL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_NEUTRAL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_NEUTRAL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_WARM_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_WARM_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_WARM_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_WARM_WET;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_WARM_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_HOT_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_HOT_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_HOT_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_HOT_WET;
    public static final ForgeConfigSpec.ConfigValue<String> RVR_VAR_HOT_HUMID;
    //SWAMP_BIOMES
    public static final ForgeConfigSpec.ConfigValue<String> SMP_ICY_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_ICY_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_ICY_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_ICY_WET;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_ICY_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> SMP_COOL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_COOL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_COOL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_COOL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_COOL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> SMP_NEUTRAL_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_NEUTRAL_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_NEUTRAL_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_NEUTRAL_WET;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_NEUTRAL_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> SMP_WARM_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_WARM_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_WARM_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_WARM_WET;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_WARM_HUMID;

    public static final ForgeConfigSpec.ConfigValue<String> SMP_HOT_ARID;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_HOT_DRY;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_HOT_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_HOT_WET;
    public static final ForgeConfigSpec.ConfigValue<String> SMP_HOT_HUMID;
    //OCEAN_BIOMES
    public static final ForgeConfigSpec.ConfigValue<String> OCA_DEP_ICY;
    public static final ForgeConfigSpec.ConfigValue<String> OCA_DEP_COOL;
    public static final ForgeConfigSpec.ConfigValue<String> OCA_DEP_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> OCA_DEP_WARM;
    public static final ForgeConfigSpec.ConfigValue<String> OCA_DEP_HOT;

    public static final ForgeConfigSpec.ConfigValue<String> OCA_ICY;
    public static final ForgeConfigSpec.ConfigValue<String> OCA_COOL;
    public static final ForgeConfigSpec.ConfigValue<String> OCA_NEUTRAL;
    public static final ForgeConfigSpec.ConfigValue<String> OCA_WARM;
    public static final ForgeConfigSpec.ConfigValue<String> OCA_HOT;
    //SHORE_BIOMES
    public static final ForgeConfigSpec.ConfigValue<String> ICY_BEACH;
    public static final ForgeConfigSpec.ConfigValue<String> COOL_BEACH;
    public static final ForgeConfigSpec.ConfigValue<String> NEUTRAL_BEACH;
    public static final ForgeConfigSpec.ConfigValue<String> WARM_BEACH;
    public static final ForgeConfigSpec.ConfigValue<String> HOT_BEACH;
    public static final ForgeConfigSpec.ConfigValue<String> COLD_STONE_BEACH;
    public static final ForgeConfigSpec.ConfigValue<String> HOT_STONE_BEACH;
    //UNDERGROUND_BIOMES
    public static final ForgeConfigSpec.ConfigValue<String> CAVE_1;
    public static final ForgeConfigSpec.ConfigValue<String> CAVE_2;
    public static final ForgeConfigSpec.ConfigValue<String> CAVE_3;
    public static final ForgeConfigSpec.ConfigValue<String> CAVE_4;
    public static final ForgeConfigSpec.ConfigValue<String> CAVE_5;
    public static final ForgeConfigSpec.ConfigValue<String> CAVE_6;
    public static final ForgeConfigSpec.ConfigValue<String> CAVE_7;
    public static final ForgeConfigSpec.ConfigValue<String> CAVE_8;
    //ISLAND_BIOMES
    public static final ForgeConfigSpec.ConfigValue<String> ICY_ISLAND;
    public static final ForgeConfigSpec.ConfigValue<String> COOL_ISLAND;
    public static final ForgeConfigSpec.ConfigValue<String> NEUTRAL_ISLAND;
    public static final ForgeConfigSpec.ConfigValue<String> WARM_ISLAND;
    public static final ForgeConfigSpec.ConfigValue<String> HOT_ISLAND;
    //SHATTERED_CLIFFS_BIOME
    public static final ForgeConfigSpec.ConfigValue<String> SHA_CLI;

    static {
        BUILDER.comment("Config for Regions Unexplored primary region!");
        BUILDER.comment("NOTICE: Make sure 'enable_custom_regions' is enabled in Common configs or this config will have no effect on generation!");
        BUILDER.comment("If you have custom regions enabled: to get future update biomes to spawn, you will either need to delete the config and let it regen, or add the new biomes manually.");
        BUILDER.push("-----------------MIDDLE_BIOMES--------------------");
        BUILDER.comment("icy_biomes");
        MID_ICY_ARID = BUILDER.define("icy_arid", RuBiomes.FROZEN_TUNDRA.location().toString());
        MID_ICY_DRY = BUILDER.define("icy_dry", RuBiomes.FROZEN_TUNDRA.location().toString());
        MID_ICY_NEUTRAL = BUILDER.define("icy_neutral", RuBiomes.FROZEN_PINE_TAIGA.location().toString());
        MID_ICY_WET = BUILDER.define("icy_wet", RuBiomes.COLD_BOREAL_TAIGA.location().toString());
        MID_ICY_HUMID = BUILDER.define("icy_humid", RuBiomes.COLD_BOREAL_TAIGA.location().toString());
        BUILDER.comment("cool_biomes");
        MID_COOL_ARID = BUILDER.define("cool_arid", RuBiomes.POPPY_FIELDS.location().toString());
        MID_COOL_DRY = BUILDER.define("cool_dry", RuBiomes.AUTUMNAL_MAPLE_FOREST.location().toString());
        MID_COOL_NEUTRAL = BUILDER.define("cool_neutral", RuBiomes.MAPLE_FOREST.location().toString());
        MID_COOL_WET = BUILDER.define("cool_wet", RuBiomes.MAPLE_FOREST.location().toString());
        MID_COOL_HUMID = BUILDER.define("cool_humid", RuBiomes.BOREAL_TAIGA.location().toString());
        BUILDER.comment("neutral_biomes");
        MID_NEUTRAL_ARID = BUILDER.define("neutral_arid", RuBiomes.MAUVE_HILLS.location().toString());
        MID_NEUTRAL_DRY = BUILDER.define("neutral_dry", RuBiomes.ROCKY_MEADOW.location().toString());
        MID_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", RuBiomes.MAGNOLIA_HIGHLANDS.location().toString());
        MID_NEUTRAL_WET = BUILDER.define("neutral_wet", RuBiomes.LUPINE_PLAINS.location().toString());
        MID_NEUTRAL_HUMID = BUILDER.define("neutral_humid", RuBiomes.BLACKWOOD_TAIGA.location().toString());
        BUILDER.comment("warm_biomes");
        MID_WARM_ARID = BUILDER.define("warm_arid", RuBiomes.WILLOW_FOREST.location().toString());
        MID_WARM_DRY = BUILDER.define("warm_dry", RuBiomes.ROCKY_MEADOW.location().toString());
        MID_WARM_NEUTRAL = BUILDER.define("warm_neutral", RuBiomes.BAMBOO_FOREST.location().toString());
        MID_WARM_WET = BUILDER.define("warm_wet", RuBiomes.REDWOODS.location().toString());
        MID_WARM_HUMID = BUILDER.define("warm_humid", RuBiomes.REDWOODS.location().toString());
        BUILDER.comment("hot_biomes");
        MID_HOT_ARID = BUILDER.define("hot_arid", RuBiomes.DRY_BUSHLAND.location().toString());
        MID_HOT_DRY = BUILDER.define("hot_dry", RuBiomes.DRY_BUSHLAND.location().toString());
        MID_HOT_NEUTRAL = BUILDER.define("hot_neutral", RuBiomes.GRASSLAND.location().toString());
        MID_HOT_WET = BUILDER.define("hot_wet", RuBiomes.OUTBACK.location().toString());
        MID_HOT_HUMID = BUILDER.define("hot_humid", RuBiomes.EUCALYPTUS_FOREST.location().toString());
        BUILDER.pop();
        BUILDER.push("-----------------MIDDLE_BIOMES_VARIANT--------------------");
        BUILDER.comment("icy_biomes");
        MID_VAR_ICY_ARID = BUILDER.define("icy_arid", RuBiomes.FROZEN_TUNDRA.location().toString());
        MID_VAR_ICY_DRY = BUILDER.define("icy_dry", RuBiomes.FROZEN_TUNDRA.location().toString());
        MID_VAR_ICY_NEUTRAL = BUILDER.define("icy_neutral", RuBiomes.FROZEN_TUNDRA.location().toString());
        MID_VAR_ICY_WET = BUILDER.define("icy_wet", RuBiomes.COLD_BOREAL_TAIGA.location().toString());
        MID_VAR_ICY_HUMID = BUILDER.define("icy_humid", RuBiomes.SPIRES.location().toString());
        BUILDER.comment("cool_biomes");
        MID_VAR_COOL_ARID = BUILDER.define("cool_arid", RuBiomes.AUTUMNAL_MAPLE_FOREST.location().toString());
        MID_VAR_COOL_DRY = BUILDER.define("cool_dry", RuBiomes.SILVER_BIRCH_FOREST.location().toString());
        MID_VAR_COOL_NEUTRAL = BUILDER.define("cool_neutral", RuBiomes.MAPLE_FOREST.location().toString());
        MID_VAR_COOL_WET = BUILDER.define("cool_wet", RuBiomes.BOREAL_TAIGA.location().toString());
        MID_VAR_COOL_HUMID = BUILDER.define("cool_humid", RuBiomes.GOLDEN_BOREAL_TAIGA.location().toString());
        BUILDER.comment("neutral_biomes");
        MID_VAR_NEUTRAL_ARID = BUILDER.define("neutral_arid", RuBiomes.MAUVE_HILLS.location().toString());
        MID_VAR_NEUTRAL_DRY = BUILDER.define("neutral_dry", RuBiomes.ROCKY_MEADOW.location().toString());
        MID_VAR_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", RuBiomes.MAGNOLIA_HIGHLANDS.location().toString());
        MID_VAR_NEUTRAL_WET = BUILDER.define("neutral_wet", RuBiomes.LUPINE_PLAINS.location().toString());
        MID_VAR_NEUTRAL_HUMID = BUILDER.define("neutral_humid", RuBiomes.BLACKWOOD_TAIGA.location().toString());
        BUILDER.comment("warm_biomes");
        MID_VAR_WARM_ARID = BUILDER.define("warm_arid", RuBiomes.WILLOW_FOREST.location().toString());
        MID_VAR_WARM_DRY = BUILDER.define("warm_dry", RuBiomes.ROCKY_MEADOW.location().toString());
        MID_VAR_WARM_NEUTRAL = BUILDER.define("warm_neutral", RuBiomes.BAMBOO_FOREST.location().toString());
        MID_VAR_WARM_WET = BUILDER.define("warm_wet", RuBiomes.FLOWER_FIELDS.location().toString());
        MID_VAR_WARM_HUMID = BUILDER.define("warm_humid", RuBiomes.SPARSE_REDWOODS.location().toString());
        BUILDER.comment("hot_biomes");
        MID_VAR_HOT_ARID = BUILDER.define("hot_arid", RuBiomes.DRY_BUSHLAND.location().toString());
        MID_VAR_HOT_DRY = BUILDER.define("hot_dry", RuBiomes.DRY_BUSHLAND.location().toString());
        MID_VAR_HOT_NEUTRAL = BUILDER.define("hot_neutral", RuBiomes.OUTBACK.location().toString());
        MID_VAR_HOT_WET = BUILDER.define("hot_wet", RuBiomes.OUTBACK.location().toString());
        MID_VAR_HOT_HUMID = BUILDER.define("hot_humid", RuBiomes.EUCALYPTUS_FOREST.location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------PLATEAU_BIOMES--------------------");
        BUILDER.comment("icy_biomes");
        PLT_ICY_ARID = BUILDER.define("icy_arid", RuBiomes.ICY_HEIGHTS.location().toString());
        PLT_ICY_DRY = BUILDER.define("icy_dry", RuBiomes.ICY_HEIGHTS.location().toString());
        PLT_ICY_NEUTRAL = BUILDER.define("icy_neutral", RuBiomes.ICY_HEIGHTS.location().toString());
        PLT_ICY_WET = BUILDER.define("icy_wet", RuBiomes.ICY_HEIGHTS.location().toString());
        PLT_ICY_HUMID = BUILDER.define("icy_humid", RuBiomes.COLD_BOREAL_TAIGA.location().toString());
        BUILDER.comment("cool_biomes");
        PLT_COOL_ARID = BUILDER.define("cool_arid", RuBiomes.POPPY_FIELDS.location().toString());
        PLT_COOL_DRY = BUILDER.define("cool_dry", RuBiomes.AUTUMNAL_MAPLE_FOREST.location().toString());
        PLT_COOL_NEUTRAL = BUILDER.define("cool_neutral", RuBiomes.MAPLE_FOREST.location().toString());
        PLT_COOL_WET = BUILDER.define("cool_wet", RuBiomes.BOREAL_TAIGA.location().toString());
        PLT_COOL_HUMID = BUILDER.define("cool_humid", RuBiomes.BOREAL_TAIGA.location().toString());
        BUILDER.comment("neutral_biomes");
        PLT_NEUTRAL_ARID = BUILDER.define("neutral_arid", RuBiomes.HIGHLAND_FIELDS.location().toString());
        PLT_NEUTRAL_DRY = BUILDER.define("neutral_dry", RuBiomes.HIGHLAND_FIELDS.location().toString());
        PLT_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", RuBiomes.HIGHLAND_FIELDS.location().toString());
        PLT_NEUTRAL_WET = BUILDER.define("neutral_wet", RuBiomes.HIGHLAND_FIELDS.location().toString());
        PLT_NEUTRAL_HUMID = BUILDER.define("neutral_humid", RuBiomes.BLACKWOOD_TAIGA.location().toString());
        BUILDER.comment("warm_biomes");
        PLT_WARM_ARID = BUILDER.define("warm_arid", RuBiomes.MAGNOLIA_HIGHLANDS.location().toString());
        PLT_WARM_DRY = BUILDER.define("warm_dry", RuBiomes.MAGNOLIA_HIGHLANDS.location().toString());
        PLT_WARM_NEUTRAL = BUILDER.define("warm_neutral", RuBiomes.MAGNOLIA_HIGHLANDS.location().toString());
        PLT_WARM_WET = BUILDER.define("warm_wet", RuBiomes.MAGNOLIA_HIGHLANDS.location().toString());
        PLT_WARM_HUMID = BUILDER.define("warm_humid", RuBiomes.REDWOODS.location().toString());
        BUILDER.comment("hot_biomes");
        PLT_HOT_ARID = BUILDER.define("hot_arid", RuBiomes.STEPPE.location().toString());
        PLT_HOT_DRY = BUILDER.define("hot_dry", RuBiomes.STEPPE.location().toString());
        PLT_HOT_NEUTRAL = BUILDER.define("hot_neutral", RuBiomes.STEPPE.location().toString());
        PLT_HOT_WET = BUILDER.define("hot_wet", RuBiomes.EUCALYPTUS_FOREST.location().toString());
        PLT_HOT_HUMID = BUILDER.define("hot_humid", RuBiomes.EUCALYPTUS_FOREST.location().toString());
        BUILDER.pop();
        BUILDER.push("-----------------PLATEAU_BIOMES_VARIANT--------------------");
        BUILDER.comment("icy_biomes");
        PLT_VAR_ICY_ARID = BUILDER.define("icy_arid", RuBiomes.ICY_HEIGHTS.location().toString());
        PLT_VAR_ICY_DRY = BUILDER.define("icy_dry", RuBiomes.ICY_HEIGHTS.location().toString());
        PLT_VAR_ICY_NEUTRAL = BUILDER.define("icy_neutral", RuBiomes.ICY_HEIGHTS.location().toString());
        PLT_VAR_ICY_WET = BUILDER.define("icy_wet", RuBiomes.ICY_HEIGHTS.location().toString());
        PLT_VAR_ICY_HUMID = BUILDER.define("icy_humid", RuBiomes.SPIRES.location().toString());
        BUILDER.comment("cool_biomes");
        PLT_VAR_COOL_ARID = BUILDER.define("cool_arid", RuBiomes.AUTUMNAL_MAPLE_FOREST.location().toString());
        PLT_VAR_COOL_DRY = BUILDER.define("cool_dry", RuBiomes.AUTUMNAL_MAPLE_FOREST.location().toString());
        PLT_VAR_COOL_NEUTRAL = BUILDER.define("cool_neutral", RuBiomes.MAPLE_FOREST.location().toString());
        PLT_VAR_COOL_WET = BUILDER.define("cool_wet", RuBiomes.BOREAL_TAIGA.location().toString());
        PLT_VAR_COOL_HUMID = BUILDER.define("cool_humid", RuBiomes.GOLDEN_BOREAL_TAIGA.location().toString());
        BUILDER.comment("neutral_biomes");
        PLT_VAR_NEUTRAL_ARID = BUILDER.define("neutral_arid", RuBiomes.HIGHLAND_FIELDS.location().toString());
        PLT_VAR_NEUTRAL_DRY = BUILDER.define("neutral_dry", RuBiomes.MAGNOLIA_HIGHLANDS.location().toString());
        PLT_VAR_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", RuBiomes.MAGNOLIA_HIGHLANDS.location().toString());
        PLT_VAR_NEUTRAL_WET = BUILDER.define("neutral_wet", RuBiomes.MAGNOLIA_HIGHLANDS.location().toString());
        PLT_VAR_NEUTRAL_HUMID = BUILDER.define("neutral_humid", RuBiomes.BLACKWOOD_TAIGA.location().toString());
        BUILDER.comment("warm_biomes");
        PLT_VAR_WARM_ARID = BUILDER.define("warm_arid", RuBiomes.MAGNOLIA_HIGHLANDS.location().toString());
        PLT_VAR_WARM_DRY = BUILDER.define("warm_dry", RuBiomes.MAGNOLIA_HIGHLANDS.location().toString());
        PLT_VAR_WARM_NEUTRAL = BUILDER.define("warm_neutral", RuBiomes.MAGNOLIA_HIGHLANDS.location().toString());
        PLT_VAR_WARM_WET = BUILDER.define("warm_wet", RuBiomes.FLOWER_FIELDS.location().toString());
        PLT_VAR_WARM_HUMID = BUILDER.define("warm_humid", RuBiomes.SPARSE_REDWOODS.location().toString());
        BUILDER.comment("hot_biomes");
        PLT_VAR_HOT_ARID = BUILDER.define("hot_arid", RuBiomes.STEPPE.location().toString());
        PLT_VAR_HOT_DRY = BUILDER.define("hot_dry", RuBiomes.STEPPE.location().toString());
        PLT_VAR_HOT_NEUTRAL = BUILDER.define("hot_neutral", RuBiomes.STEPPE.location().toString());
        PLT_VAR_HOT_WET = BUILDER.define("hot_wet", RuBiomes.EUCALYPTUS_FOREST.location().toString());
        PLT_VAR_HOT_HUMID = BUILDER.define("hot_humid", RuBiomes.EUCALYPTUS_FOREST.location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------SHATTERED_BIOMES--------------------");
        BUILDER.comment("icy_biomes");
        SHT_ICY_ARID = BUILDER.define("icy_arid", RuBiomes.ICY_HEIGHTS.location().toString());
        SHT_ICY_DRY = BUILDER.define("icy_dry", RuBiomes.ICY_HEIGHTS.location().toString());
        SHT_ICY_NEUTRAL = BUILDER.define("icy_neutral", RuBiomes.ICY_HEIGHTS.location().toString());
        SHT_ICY_WET = BUILDER.define("icy_wet", RuBiomes.ICY_HEIGHTS.location().toString());
        SHT_ICY_HUMID = BUILDER.define("icy_humid", RuBiomes.ICY_HEIGHTS.location().toString());
        BUILDER.comment("cool_biomes");
        SHT_COOL_ARID = BUILDER.define("cool_arid", RuBiomes.TOWERING_CLIFFS.location().toString());
        SHT_COOL_DRY = BUILDER.define("cool_dry", RuBiomes.TOWERING_CLIFFS.location().toString());
        SHT_COOL_NEUTRAL = BUILDER.define("cool_neutral", RuBiomes.TOWERING_CLIFFS.location().toString());
        SHT_COOL_WET = BUILDER.define("cool_wet", RuBiomes.TOWERING_CLIFFS.location().toString());
        SHT_COOL_HUMID = BUILDER.define("cool_humid", RuBiomes.TOWERING_CLIFFS.location().toString());
        BUILDER.comment("neutral_biomes");
        SHT_NEUTRAL_ARID = BUILDER.define("neutral_arid", RuBiomes.TOWERING_CLIFFS.location().toString());
        SHT_NEUTRAL_DRY = BUILDER.define("neutral_dry", RuBiomes.TOWERING_CLIFFS.location().toString());
        SHT_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", RuBiomes.TOWERING_CLIFFS.location().toString());
        SHT_NEUTRAL_WET = BUILDER.define("neutral_wet", RuBiomes.TOWERING_CLIFFS.location().toString());
        SHT_NEUTRAL_HUMID = BUILDER.define("neutral_humid", RuBiomes.TOWERING_CLIFFS.location().toString());
        BUILDER.comment("warm_biomes");
        SHT_WARM_ARID = BUILDER.define("warm_arid", RuBiomes.ROCKY_MEADOW.location().toString());
        SHT_WARM_DRY = BUILDER.define("warm_dry", RuBiomes.ROCKY_MEADOW.location().toString());
        SHT_WARM_NEUTRAL = BUILDER.define("warm_neutral", RuBiomes.BAMBOO_FOREST.location().toString());
        SHT_WARM_WET = BUILDER.define("warm_wet", RuBiomes.SPARSE_REDWOODS.location().toString());
        SHT_WARM_HUMID = BUILDER.define("warm_humid", RuBiomes.SPARSE_REDWOODS.location().toString());
        BUILDER.comment("hot_biomes");
        SHT_HOT_ARID = BUILDER.define("hot_arid", RuBiomes.STEPPE.location().toString());
        SHT_HOT_DRY = BUILDER.define("hot_dry", RuBiomes.STEPPE.location().toString());
        SHT_HOT_NEUTRAL = BUILDER.define("hot_neutral", RuBiomes.OUTBACK.location().toString());
        SHT_HOT_WET = BUILDER.define("hot_wet", RuBiomes.OUTBACK.location().toString());
        SHT_HOT_HUMID = BUILDER.define("hot_humid", RuBiomes.EUCALYPTUS_FOREST.location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------SLOPE_BIOMES--------------------");
        BUILDER.comment("slope_biomes");
        ICY_SLOPE = BUILDER.define("icy_slope_biome", Biomes.SNOWY_SLOPES.location().toString());
        COOL_SLOPE = BUILDER.define("cold_slope_biome", RuBiomes.PINE_SLOPES.location().toString());
        NEUTRAL_SLOPE = BUILDER.define("neutral_slope_biome", RuBiomes.PINE_SLOPES.location().toString());
        WARM_SLOPE = BUILDER.define("warm_slope_biome", RuBiomes.DECIDUOUS_FOREST.location().toString());
        HOT_SLOPE = BUILDER.define("hot_slope_biome", RuBiomes.RAINFOREST.location().toString());
        BUILDER.comment("slope_biomes_variant");
        ICY_SLOPE_VAR = BUILDER.define("icy_slope_biome_variant", RuBiomes.COLD_DECIDUOUS_FOREST.location().toString());
        COOL_SLOPE_VAR = BUILDER.define("cold_slope_biome_variant", RuBiomes.PINE_SLOPES.location().toString());
        NEUTRAL_SLOPE_VAR = BUILDER.define("neutral_slope_biome_variant", RuBiomes.PINE_SLOPES.location().toString());
        WARM_SLOPE_VAR = BUILDER.define("warm_slope_biome_variant", RuBiomes.DECIDUOUS_FOREST.location().toString());
        HOT_SLOPE_VAR = BUILDER.define("hot_slope_biome_variant", RuBiomes.RAINFOREST.location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------PEAK_BIOMES--------------------");
        BUILDER.comment("peak_biomes");
        ICY_PEAK = BUILDER.define("icy_peak_biome", Biomes.FROZEN_PEAKS.location().toString());
        COOL_PEAK = BUILDER.define("cold_peak_biome", Biomes.JAGGED_PEAKS.location().toString());
        NEUTRAL_PEAK = BUILDER.define("neutral_peak_biome", RuBiomes.MOUNTAINS.location().toString());
        WARM_PEAK = BUILDER.define("warm_peak_biome", Biomes.STONY_PEAKS.location().toString());
        HOT_PEAK = BUILDER.define("hot_peak_biome", RuBiomes.ARID_MOUNTAINS.location().toString());
        BUILDER.comment("peak_biomes_variant");
        ICY_PEAK_VAR = BUILDER.define("icy_peak_biome_variant", Biomes.JAGGED_PEAKS.location().toString());
        COOL_PEAK_VAR = BUILDER.define("cold_peak_biome_variant", RuBiomes.MOUNTAINS.location().toString());
        NEUTRAL_PEAK_VAR = BUILDER.define("neutral_peak_biome_variant", RuBiomes.MOUNTAINS.location().toString());
        WARM_PEAK_VAR = BUILDER.define("warm_peak_biome_variant", Biomes.STONY_PEAKS.location().toString());
        HOT_PEAK_VAR = BUILDER.define("hot_peak_biome_variant", RuBiomes.ARID_MOUNTAINS.location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------RIVER_BIOMES--------------------");
        BUILDER.comment("icy_biomes");
        RVR_ICY_ARID = BUILDER.define("icy_arid", Biomes.FROZEN_RIVER.location().toString());
        RVR_ICY_DRY = BUILDER.define("icy_dry", Biomes.FROZEN_RIVER.location().toString());
        RVR_ICY_NEUTRAL = BUILDER.define("icy_neutral", Biomes.FROZEN_RIVER.location().toString());
        RVR_ICY_WET = BUILDER.define("icy_wet", Biomes.FROZEN_RIVER.location().toString());
        RVR_ICY_HUMID = BUILDER.define("icy_humid", Biomes.FROZEN_RIVER.location().toString());
        BUILDER.comment("cool_biomes");
        RVR_COOL_ARID = BUILDER.define("cool_arid", RuBiomes.COLD_RIVER.location().toString());
        RVR_COOL_DRY = BUILDER.define("cool_dry", RuBiomes.COLD_RIVER.location().toString());
        RVR_COOL_NEUTRAL = BUILDER.define("cool_neutral", RuBiomes.COLD_RIVER.location().toString());
        RVR_COOL_WET = BUILDER.define("cool_wet", RuBiomes.COLD_RIVER.location().toString());
        RVR_COOL_HUMID = BUILDER.define("cool_humid", RuBiomes.COLD_RIVER.location().toString());
        BUILDER.comment("neutral_biomes");
        RVR_NEUTRAL_ARID = BUILDER.define("neutral_arid", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_NEUTRAL_DRY = BUILDER.define("neutral_dry", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_NEUTRAL_WET = BUILDER.define("neutral_wet", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_NEUTRAL_HUMID = BUILDER.define("neutral_humid", RuBiomes.BLACKWOOD_TAIGA.location().toString());
        BUILDER.comment("warm_biomes");
        RVR_WARM_ARID = BUILDER.define("warm_arid", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_WARM_DRY = BUILDER.define("warm_dry", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_WARM_NEUTRAL = BUILDER.define("warm_neutral", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_WARM_WET = BUILDER.define("warm_wet", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_WARM_HUMID = BUILDER.define("warm_humid", RuBiomes.MUDDY_RIVER.location().toString());
        BUILDER.comment("hot_biomes");
        RVR_HOT_ARID = BUILDER.define("hot_arid", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_HOT_DRY = BUILDER.define("hot_dry", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_HOT_NEUTRAL = BUILDER.define("hot_neutral", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_HOT_WET = BUILDER.define("hot_wet", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_HOT_HUMID = BUILDER.define("hot_humid", RuBiomes.MUDDY_RIVER.location().toString());
        BUILDER.pop();
        BUILDER.push("-----------------RIVER_BIOMES_VARIANT--------------------");
        BUILDER.comment("icy_biomes");
        RVR_VAR_ICY_ARID = BUILDER.define("icy_arid", Biomes.FROZEN_RIVER.location().toString());
        RVR_VAR_ICY_DRY = BUILDER.define("icy_dry", Biomes.FROZEN_RIVER.location().toString());
        RVR_VAR_ICY_NEUTRAL = BUILDER.define("icy_neutral", Biomes.FROZEN_RIVER.location().toString());
        RVR_VAR_ICY_WET = BUILDER.define("icy_wet", Biomes.FROZEN_RIVER.location().toString());
        RVR_VAR_ICY_HUMID = BUILDER.define("icy_humid", Biomes.FROZEN_RIVER.location().toString());
        BUILDER.comment("cool_biomes");
        RVR_VAR_COOL_ARID = BUILDER.define("cool_arid", RuBiomes.COLD_RIVER.location().toString());
        RVR_VAR_COOL_DRY = BUILDER.define("cool_dry", RuBiomes.COLD_RIVER.location().toString());
        RVR_VAR_COOL_NEUTRAL = BUILDER.define("cool_neutral", RuBiomes.COLD_RIVER.location().toString());
        RVR_VAR_COOL_WET = BUILDER.define("cool_wet", RuBiomes.COLD_RIVER.location().toString());
        RVR_VAR_COOL_HUMID = BUILDER.define("cool_humid", RuBiomes.COLD_RIVER.location().toString());
        BUILDER.comment("neutral_biomes");
        RVR_VAR_NEUTRAL_ARID = BUILDER.define("neutral_arid", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_VAR_NEUTRAL_DRY = BUILDER.define("neutral_dry", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_VAR_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_VAR_NEUTRAL_WET = BUILDER.define("neutral_wet", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_VAR_NEUTRAL_HUMID = BUILDER.define("neutral_humid", RuBiomes.BLACKWOOD_TAIGA.location().toString());
        BUILDER.comment("warm_biomes");
        RVR_VAR_WARM_ARID = BUILDER.define("warm_arid", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_VAR_WARM_DRY = BUILDER.define("warm_dry", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_VAR_WARM_NEUTRAL = BUILDER.define("warm_neutral", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_VAR_WARM_WET = BUILDER.define("warm_wet", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_VAR_WARM_HUMID = BUILDER.define("warm_humid", RuBiomes.MUDDY_RIVER.location().toString());
        BUILDER.comment("hot_biomes");
        RVR_VAR_HOT_ARID = BUILDER.define("hot_arid", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_VAR_HOT_DRY = BUILDER.define("hot_dry", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_VAR_HOT_NEUTRAL = BUILDER.define("hot_neutral", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_VAR_HOT_WET = BUILDER.define("hot_wet", RuBiomes.MUDDY_RIVER.location().toString());
        RVR_VAR_HOT_HUMID = BUILDER.define("hot_humid", RuBiomes.MUDDY_RIVER.location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------SWAMP_BIOMES--------------------");
        BUILDER.comment("icy_biomes");
        SMP_ICY_ARID = BUILDER.define("icy_arid", RuBiomes.SPIRES.location().toString());
        SMP_ICY_DRY = BUILDER.define("icy_dry", RuBiomes.SPIRES.location().toString());
        SMP_ICY_NEUTRAL = BUILDER.define("icy_neutral", RuBiomes.SPIRES.location().toString());
        SMP_ICY_WET = BUILDER.define("icy_wet", RuBiomes.SPIRES.location().toString());
        SMP_ICY_HUMID = BUILDER.define("icy_humid", RuBiomes.SPIRES.location().toString());
        BUILDER.comment("cool_biomes");
        SMP_COOL_ARID = BUILDER.define("cool_arid", RuBiomes.FEN.location().toString());
        SMP_COOL_DRY = BUILDER.define("cool_dry", RuBiomes.FEN.location().toString());
        SMP_COOL_NEUTRAL = BUILDER.define("cool_neutral", RuBiomes.FEN.location().toString());
        SMP_COOL_WET = BUILDER.define("cool_wet", RuBiomes.FEN.location().toString());
        SMP_COOL_HUMID = BUILDER.define("cool_humid", RuBiomes.FEN.location().toString());
        BUILDER.comment("neutral_biomes");
        SMP_NEUTRAL_ARID = BUILDER.define("neutral_arid", RuBiomes.BAYOU.location().toString());
        SMP_NEUTRAL_DRY = BUILDER.define("neutral_dry", RuBiomes.BAYOU.location().toString());
        SMP_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", RuBiomes.BAYOU.location().toString());
        SMP_NEUTRAL_WET = BUILDER.define("neutral_wet", RuBiomes.OLD_GROWTH_BAYOU.location().toString());
        SMP_NEUTRAL_HUMID = BUILDER.define("neutral_humid", RuBiomes.OLD_GROWTH_BAYOU.location().toString());
        BUILDER.comment("warm_biomes");
        SMP_WARM_ARID = BUILDER.define("warm_arid", RuBiomes.MARSH.location().toString());
        SMP_WARM_DRY = BUILDER.define("warm_dry", RuBiomes.MARSH.location().toString());
        SMP_WARM_NEUTRAL = BUILDER.define("warm_neutral", RuBiomes.MARSH.location().toString());
        SMP_WARM_WET = BUILDER.define("warm_wet", RuBiomes.OLD_GROWTH_BAYOU.location().toString());
        SMP_WARM_HUMID = BUILDER.define("warm_humid", RuBiomes.OLD_GROWTH_BAYOU.location().toString());
        BUILDER.comment("hot_biomes");
        SMP_HOT_ARID = BUILDER.define("hot_arid", RuBiomes.FUNGAL_FEN.location().toString());
        SMP_HOT_DRY = BUILDER.define("hot_dry", RuBiomes.FUNGAL_FEN.location().toString());
        SMP_HOT_NEUTRAL = BUILDER.define("hot_neutral", RuBiomes.FUNGAL_FEN.location().toString());
        SMP_HOT_WET = BUILDER.define("hot_wet", RuBiomes.FUNGAL_FEN.location().toString());
        SMP_HOT_HUMID = BUILDER.define("hot_humid", RuBiomes.FUNGAL_FEN.location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------OCEAN_BIOMES--------------------");
        BUILDER.comment("deep_oceans");
        OCA_DEP_ICY = BUILDER.define("deep_icy", DefaultBiomes.SECONDARY_OCEAN_BIOMES[0][0].location().toString());
        OCA_DEP_COOL = BUILDER.define("deep_cool", DefaultBiomes.SECONDARY_OCEAN_BIOMES[0][1].location().toString());
        OCA_DEP_NEUTRAL = BUILDER.define("deep_neutral", DefaultBiomes.SECONDARY_OCEAN_BIOMES[0][2].location().toString());
        OCA_DEP_WARM = BUILDER.define("deep_warm", DefaultBiomes.SECONDARY_OCEAN_BIOMES[0][3].location().toString());
        OCA_DEP_HOT = BUILDER.define("deep_hot", DefaultBiomes.SECONDARY_OCEAN_BIOMES[0][4].location().toString());
        BUILDER.comment("oceans");
        OCA_ICY = BUILDER.define("icy", DefaultBiomes.SECONDARY_OCEAN_BIOMES[1][0].location().toString());
        OCA_COOL = BUILDER.define("cool", DefaultBiomes.SECONDARY_OCEAN_BIOMES[1][1].location().toString());
        OCA_NEUTRAL = BUILDER.define("neutral", DefaultBiomes.SECONDARY_OCEAN_BIOMES[1][2].location().toString());
        OCA_WARM = BUILDER.define("warm", DefaultBiomes.SECONDARY_OCEAN_BIOMES[1][3].location().toString());
        OCA_HOT = BUILDER.define("hot", DefaultBiomes.SECONDARY_OCEAN_BIOMES[1][4].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------SHORE_BIOMES--------------------");
        BUILDER.comment("beach_biomes");
        ICY_BEACH = BUILDER.define("icy_beach_biome", DefaultBiomes.SECONDARY_BEACH_BIOMES[0].location().toString());
        COOL_BEACH = BUILDER.define("cold_beach_biome", DefaultBiomes.SECONDARY_BEACH_BIOMES[1].location().toString());
        NEUTRAL_BEACH = BUILDER.define("neutral_beach_biome", DefaultBiomes.SECONDARY_BEACH_BIOMES[2].location().toString());
        WARM_BEACH = BUILDER.define("warm_beach_biome", DefaultBiomes.SECONDARY_BEACH_BIOMES[3].location().toString());
        HOT_BEACH = BUILDER.define("hot_beach_biome", DefaultBiomes.SECONDARY_BEACH_BIOMES[4].location().toString());
        BUILDER.comment("stone_beach_biomes");
        COLD_STONE_BEACH = BUILDER.define("cold_stone_beach_biome", DefaultBiomes.SECONDARY_STONE_SHORE_BIOMES[0].location().toString());
        HOT_STONE_BEACH = BUILDER.define("hot_stone_beach_biome", DefaultBiomes.SECONDARY_STONE_SHORE_BIOMES[1].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------UNDERGROUND_BIOMES--------------------");
        CAVE_1 = BUILDER.define("cave_1_biome", DefaultBiomes.SECONDARY_CAVE_BIOMES[0].location().toString());
        CAVE_2 = BUILDER.define("cave_2_biome", DefaultBiomes.SECONDARY_CAVE_BIOMES[1].location().toString());
        CAVE_3 = BUILDER.define("cave_3_biome", DefaultBiomes.SECONDARY_CAVE_BIOMES[2].location().toString());
        CAVE_4 = BUILDER.define("cave_4_biome", DefaultBiomes.SECONDARY_CAVE_BIOMES[3].location().toString());
        CAVE_5 = BUILDER.define("cave_5_biome", DefaultBiomes.SECONDARY_CAVE_BIOMES[4].location().toString());
        CAVE_6 = BUILDER.define("cave_6_biome", DefaultBiomes.SECONDARY_CAVE_BIOMES[5].location().toString());
        CAVE_7 = BUILDER.define("cave_7_biome", DefaultBiomes.SECONDARY_CAVE_BIOMES[6].location().toString());
        CAVE_8 = BUILDER.define("cave_8_biome", DefaultBiomes.SECONDARY_CAVE_BIOMES[7].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------ISLAND_BIOMES--------------------");
        ICY_ISLAND = BUILDER.define("icy_island_biome", DefaultBiomes.SECONDARY_ISLAND_BIOMES[0].location().toString());
        COOL_ISLAND = BUILDER.define("cool_island_biome", DefaultBiomes.SECONDARY_ISLAND_BIOMES[1].location().toString());
        NEUTRAL_ISLAND = BUILDER.define("neutral_island_biome", DefaultBiomes.SECONDARY_ISLAND_BIOMES[2].location().toString());
        WARM_ISLAND = BUILDER.define("warm_island_biome", DefaultBiomes.SECONDARY_ISLAND_BIOMES[3].location().toString());
        HOT_ISLAND = BUILDER.define("hot_island_biome", DefaultBiomes.SECONDARY_ISLAND_BIOMES[4].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------OTHER_BIOMES--------------------");
        SHA_CLI = BUILDER.define("shattered_cliff_biome", RuBiomes.TOWERING_CLIFFS.location().toString());
        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
