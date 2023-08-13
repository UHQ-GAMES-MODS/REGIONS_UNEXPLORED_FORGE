package net.regions_unexplored.config;

import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.ForgeConfigSpec;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;
import net.regions_unexplored.world.level.biome.DefaultBiomes;

public class RuPrimaryRegionConfig {
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
        MID_ICY_ARID = BUILDER.define("icy_arid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[0][0].location().toString());
        MID_ICY_DRY = BUILDER.define("icy_dry", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[0][1].location().toString());
        MID_ICY_NEUTRAL = BUILDER.define("icy_neutral", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[0][2].location().toString());
        MID_ICY_WET = BUILDER.define("icy_wet", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[0][3].location().toString());
        MID_ICY_HUMID = BUILDER.define("icy_humid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[0][4].location().toString());
        BUILDER.comment("cool_biomes");
        MID_COOL_ARID = BUILDER.define("cool_arid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[1][0].location().toString());
        MID_COOL_DRY = BUILDER.define("cool_dry", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[1][1].location().toString());
        MID_COOL_NEUTRAL = BUILDER.define("cool_neutral", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[1][2].location().toString());
        MID_COOL_WET = BUILDER.define("cool_wet", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[1][3].location().toString());
        MID_COOL_HUMID = BUILDER.define("cool_humid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[1][4].location().toString());
        BUILDER.comment("neutral_biomes");
        MID_NEUTRAL_ARID = BUILDER.define("neutral_arid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[2][0].location().toString());
        MID_NEUTRAL_DRY = BUILDER.define("neutral_dry", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[2][1].location().toString());
        MID_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[2][2].location().toString());
        MID_NEUTRAL_WET = BUILDER.define("neutral_wet", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[2][3].location().toString());
        MID_NEUTRAL_HUMID = BUILDER.define("neutral_humid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[2][4].location().toString());
        BUILDER.comment("warm_biomes");
        MID_WARM_ARID = BUILDER.define("warm_arid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[3][0].location().toString());
        MID_WARM_DRY = BUILDER.define("warm_dry", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[3][1].location().toString());
        MID_WARM_NEUTRAL = BUILDER.define("warm_neutral", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[3][2].location().toString());
        MID_WARM_WET = BUILDER.define("warm_wet", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[3][3].location().toString());
        MID_WARM_HUMID = BUILDER.define("warm_humid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[3][4].location().toString());
        BUILDER.comment("hot_biomes");
        MID_HOT_ARID = BUILDER.define("hot_arid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[4][0].location().toString());
        MID_HOT_DRY = BUILDER.define("hot_dry", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[4][1].location().toString());
        MID_HOT_NEUTRAL = BUILDER.define("hot_neutral", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[4][2].location().toString());
        MID_HOT_WET = BUILDER.define("hot_wet", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[4][3].location().toString());
        MID_HOT_HUMID = BUILDER.define("hot_humid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES[4][4].location().toString());
        BUILDER.pop();
        BUILDER.push("-----------------MIDDLE_BIOMES_VARIANT--------------------");
        BUILDER.comment("icy_biomes");
        MID_VAR_ICY_ARID = BUILDER.define("icy_arid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[0][0].location().toString());
        MID_VAR_ICY_DRY = BUILDER.define("icy_dry", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[0][1].location().toString());
        MID_VAR_ICY_NEUTRAL = BUILDER.define("icy_neutral", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[0][2].location().toString());
        MID_VAR_ICY_WET = BUILDER.define("icy_wet", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[0][3].location().toString());
        MID_VAR_ICY_HUMID = BUILDER.define("icy_humid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[0][4].location().toString());
        BUILDER.comment("cool_biomes");
        MID_VAR_COOL_ARID = BUILDER.define("cool_arid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[1][0].location().toString());
        MID_VAR_COOL_DRY = BUILDER.define("cool_dry", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[1][1].location().toString());
        MID_VAR_COOL_NEUTRAL = BUILDER.define("cool_neutral", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[1][2].location().toString());
        MID_VAR_COOL_WET = BUILDER.define("cool_wet", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[1][3].location().toString());
        MID_VAR_COOL_HUMID = BUILDER.define("cool_humid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[1][4].location().toString());
        BUILDER.comment("neutral_biomes");
        MID_VAR_NEUTRAL_ARID = BUILDER.define("neutral_arid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[2][0].location().toString());
        MID_VAR_NEUTRAL_DRY = BUILDER.define("neutral_dry", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[2][1].location().toString());
        MID_VAR_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[2][2].location().toString());
        MID_VAR_NEUTRAL_WET = BUILDER.define("neutral_wet", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[2][3].location().toString());
        MID_VAR_NEUTRAL_HUMID = BUILDER.define("neutral_humid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[2][4].location().toString());
        BUILDER.comment("warm_biomes");
        MID_VAR_WARM_ARID = BUILDER.define("warm_arid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[3][0].location().toString());
        MID_VAR_WARM_DRY = BUILDER.define("warm_dry", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[3][1].location().toString());
        MID_VAR_WARM_NEUTRAL = BUILDER.define("warm_neutral", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[3][2].location().toString());
        MID_VAR_WARM_WET = BUILDER.define("warm_wet", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[3][3].location().toString());
        MID_VAR_WARM_HUMID = BUILDER.define("warm_humid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[3][4].location().toString());
        BUILDER.comment("hot_biomes");
        MID_VAR_HOT_ARID = BUILDER.define("hot_arid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[4][0].location().toString());
        MID_VAR_HOT_DRY = BUILDER.define("hot_dry", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[4][1].location().toString());
        MID_VAR_HOT_NEUTRAL = BUILDER.define("hot_neutral", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[4][2].location().toString());
        MID_VAR_HOT_WET = BUILDER.define("hot_wet", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[4][3].location().toString());
        MID_VAR_HOT_HUMID = BUILDER.define("hot_humid", DefaultBiomes.PRIMARY_MIDDLE_BIOMES_VARIANT[4][4].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------PLATEAU_BIOMES--------------------");
        BUILDER.comment("icy_biomes");
        PLT_ICY_ARID = BUILDER.define("icy_arid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[0][0].location().toString());
        PLT_ICY_DRY = BUILDER.define("icy_dry", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[0][1].location().toString());
        PLT_ICY_NEUTRAL = BUILDER.define("icy_neutral", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[0][2].location().toString());
        PLT_ICY_WET = BUILDER.define("icy_wet", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[0][3].location().toString());
        PLT_ICY_HUMID = BUILDER.define("icy_humid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[0][4].location().toString());
        BUILDER.comment("cool_biomes");
        PLT_COOL_ARID = BUILDER.define("cool_arid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[1][0].location().toString());
        PLT_COOL_DRY = BUILDER.define("cool_dry", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[1][1].location().toString());
        PLT_COOL_NEUTRAL = BUILDER.define("cool_neutral", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[1][2].location().toString());
        PLT_COOL_WET = BUILDER.define("cool_wet", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[1][3].location().toString());
        PLT_COOL_HUMID = BUILDER.define("cool_humid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[1][4].location().toString());
        BUILDER.comment("neutral_biomes");
        PLT_NEUTRAL_ARID = BUILDER.define("neutral_arid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[2][0].location().toString());
        PLT_NEUTRAL_DRY = BUILDER.define("neutral_dry", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[2][1].location().toString());
        PLT_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[2][2].location().toString());
        PLT_NEUTRAL_WET = BUILDER.define("neutral_wet", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[2][3].location().toString());
        PLT_NEUTRAL_HUMID = BUILDER.define("neutral_humid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[2][4].location().toString());
        BUILDER.comment("warm_biomes");
        PLT_WARM_ARID = BUILDER.define("warm_arid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[3][0].location().toString());
        PLT_WARM_DRY = BUILDER.define("warm_dry", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[3][1].location().toString());
        PLT_WARM_NEUTRAL = BUILDER.define("warm_neutral", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[3][2].location().toString());
        PLT_WARM_WET = BUILDER.define("warm_wet", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[3][3].location().toString());
        PLT_WARM_HUMID = BUILDER.define("warm_humid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[3][4].location().toString());
        BUILDER.comment("hot_biomes");
        PLT_HOT_ARID = BUILDER.define("hot_arid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[4][0].location().toString());
        PLT_HOT_DRY = BUILDER.define("hot_dry", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[4][1].location().toString());
        PLT_HOT_NEUTRAL = BUILDER.define("hot_neutral", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[4][2].location().toString());
        PLT_HOT_WET = BUILDER.define("hot_wet", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[4][3].location().toString());
        PLT_HOT_HUMID = BUILDER.define("hot_humid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES[4][4].location().toString());
        BUILDER.pop();
        BUILDER.push("-----------------PLATEAU_BIOMES_VARIANT--------------------");
        BUILDER.comment("icy_biomes");
        PLT_VAR_ICY_ARID = BUILDER.define("icy_arid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[0][0].location().toString());
        PLT_VAR_ICY_DRY = BUILDER.define("icy_dry", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[0][1].location().toString());
        PLT_VAR_ICY_NEUTRAL = BUILDER.define("icy_neutral", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[0][2].location().toString());
        PLT_VAR_ICY_WET = BUILDER.define("icy_wet", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[0][3].location().toString());
        PLT_VAR_ICY_HUMID = BUILDER.define("icy_humid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[0][4].location().toString());
        BUILDER.comment("cool_biomes");
        PLT_VAR_COOL_ARID = BUILDER.define("cool_arid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[1][0].location().toString());
        PLT_VAR_COOL_DRY = BUILDER.define("cool_dry", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[1][1].location().toString());
        PLT_VAR_COOL_NEUTRAL = BUILDER.define("cool_neutral", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[1][2].location().toString());
        PLT_VAR_COOL_WET = BUILDER.define("cool_wet", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[1][3].location().toString());
        PLT_VAR_COOL_HUMID = BUILDER.define("cool_humid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[1][4].location().toString());
        BUILDER.comment("neutral_biomes");
        PLT_VAR_NEUTRAL_ARID = BUILDER.define("neutral_arid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[2][0].location().toString());
        PLT_VAR_NEUTRAL_DRY = BUILDER.define("neutral_dry", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[2][1].location().toString());
        PLT_VAR_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[2][2].location().toString());
        PLT_VAR_NEUTRAL_WET = BUILDER.define("neutral_wet", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[2][3].location().toString());
        PLT_VAR_NEUTRAL_HUMID = BUILDER.define("neutral_humid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[2][4].location().toString());
        BUILDER.comment("warm_biomes");
        PLT_VAR_WARM_ARID = BUILDER.define("warm_arid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[3][0].location().toString());
        PLT_VAR_WARM_DRY = BUILDER.define("warm_dry", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[3][1].location().toString());
        PLT_VAR_WARM_NEUTRAL = BUILDER.define("warm_neutral", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[3][2].location().toString());
        PLT_VAR_WARM_WET = BUILDER.define("warm_wet", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[3][3].location().toString());
        PLT_VAR_WARM_HUMID = BUILDER.define("warm_humid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[3][4].location().toString());
        BUILDER.comment("hot_biomes");
        PLT_VAR_HOT_ARID = BUILDER.define("hot_arid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[4][0].location().toString());
        PLT_VAR_HOT_DRY = BUILDER.define("hot_dry", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[4][1].location().toString());
        PLT_VAR_HOT_NEUTRAL = BUILDER.define("hot_neutral", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[4][2].location().toString());
        PLT_VAR_HOT_WET = BUILDER.define("hot_wet", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[4][3].location().toString());
        PLT_VAR_HOT_HUMID = BUILDER.define("hot_humid", DefaultBiomes.PRIMARY_PLATEAU_BIOMES_VARIANT[4][4].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------SHATTERED_BIOMES--------------------");
        BUILDER.comment("icy_biomes");
        SHT_ICY_ARID = BUILDER.define("icy_arid", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[0][0].location().toString());
        SHT_ICY_DRY = BUILDER.define("icy_dry", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[0][1].location().toString());
        SHT_ICY_NEUTRAL = BUILDER.define("icy_neutral", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[0][2].location().toString());
        SHT_ICY_WET = BUILDER.define("icy_wet", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[0][3].location().toString());
        SHT_ICY_HUMID = BUILDER.define("icy_humid", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[0][4].location().toString());
        BUILDER.comment("cool_biomes");
        SHT_COOL_ARID = BUILDER.define("cool_arid", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[1][0].location().toString());
        SHT_COOL_DRY = BUILDER.define("cool_dry", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[1][1].location().toString());
        SHT_COOL_NEUTRAL = BUILDER.define("cool_neutral", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[1][2].location().toString());
        SHT_COOL_WET = BUILDER.define("cool_wet", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[1][3].location().toString());
        SHT_COOL_HUMID = BUILDER.define("cool_humid", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[1][4].location().toString());
        BUILDER.comment("neutral_biomes");
        SHT_NEUTRAL_ARID = BUILDER.define("neutral_arid", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[2][0].location().toString());
        SHT_NEUTRAL_DRY = BUILDER.define("neutral_dry", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[2][1].location().toString());
        SHT_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[2][2].location().toString());
        SHT_NEUTRAL_WET = BUILDER.define("neutral_wet", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[2][3].location().toString());
        SHT_NEUTRAL_HUMID = BUILDER.define("neutral_humid", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[2][4].location().toString());
        BUILDER.comment("warm_biomes");
        SHT_WARM_ARID = BUILDER.define("warm_arid", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[3][0].location().toString());
        SHT_WARM_DRY = BUILDER.define("warm_dry", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[3][1].location().toString());
        SHT_WARM_NEUTRAL = BUILDER.define("warm_neutral", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[3][2].location().toString());
        SHT_WARM_WET = BUILDER.define("warm_wet", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[3][3].location().toString());
        SHT_WARM_HUMID = BUILDER.define("warm_humid", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[3][4].location().toString());
        BUILDER.comment("hot_biomes");
        SHT_HOT_ARID = BUILDER.define("hot_arid", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[4][0].location().toString());
        SHT_HOT_DRY = BUILDER.define("hot_dry", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[4][1].location().toString());
        SHT_HOT_NEUTRAL = BUILDER.define("hot_neutral", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[4][2].location().toString());
        SHT_HOT_WET = BUILDER.define("hot_wet", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[4][3].location().toString());
        SHT_HOT_HUMID = BUILDER.define("hot_humid", DefaultBiomes.PRIMARY_SHATTERED_BIOMES[4][4].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------SLOPE_BIOMES--------------------");
        BUILDER.comment("slope_biomes");
        ICY_SLOPE = BUILDER.define("icy_slope_biome", DefaultBiomes.PRIMARY_SLOPE_BIOMES[0].location().toString());
        COOL_SLOPE = BUILDER.define("cold_slope_biome", DefaultBiomes.PRIMARY_SLOPE_BIOMES[1].location().toString());
        NEUTRAL_SLOPE = BUILDER.define("neutral_slope_biome", DefaultBiomes.PRIMARY_SLOPE_BIOMES[2].location().toString());
        WARM_SLOPE = BUILDER.define("warm_slope_biome", DefaultBiomes.PRIMARY_SLOPE_BIOMES[3].location().toString());
        HOT_SLOPE = BUILDER.define("hot_slope_biome", DefaultBiomes.PRIMARY_SLOPE_BIOMES[4].location().toString());
        BUILDER.comment("slope_biomes_variant");
        ICY_SLOPE_VAR = BUILDER.define("icy_slope_biome_variant", DefaultBiomes.PRIMARY_SLOPE_BIOMES_VARIANT[0].location().toString());
        COOL_SLOPE_VAR = BUILDER.define("cold_slope_biome_variant", DefaultBiomes.PRIMARY_SLOPE_BIOMES_VARIANT[1].location().toString());
        NEUTRAL_SLOPE_VAR = BUILDER.define("neutral_slope_biome_variant", DefaultBiomes.PRIMARY_SLOPE_BIOMES_VARIANT[2].location().toString());
        WARM_SLOPE_VAR = BUILDER.define("warm_slope_biome_variant", DefaultBiomes.PRIMARY_SLOPE_BIOMES_VARIANT[3].location().toString());
        HOT_SLOPE_VAR = BUILDER.define("hot_slope_biome_variant", DefaultBiomes.PRIMARY_SLOPE_BIOMES_VARIANT[4].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------PEAK_BIOMES--------------------");
        BUILDER.comment("peak_biomes");
        ICY_PEAK = BUILDER.define("icy_peak_biome", DefaultBiomes.PRIMARY_PEAK_BIOMES[0].location().toString());
        COOL_PEAK = BUILDER.define("cold_peak_biome", DefaultBiomes.PRIMARY_PEAK_BIOMES[1].location().toString());
        NEUTRAL_PEAK = BUILDER.define("neutral_peak_biome", DefaultBiomes.PRIMARY_PEAK_BIOMES[2].location().toString());
        WARM_PEAK = BUILDER.define("warm_peak_biome", DefaultBiomes.PRIMARY_PEAK_BIOMES[3].location().toString());
        HOT_PEAK = BUILDER.define("hot_peak_biome", DefaultBiomes.PRIMARY_PEAK_BIOMES[4].location().toString());
        BUILDER.comment("peak_biomes_variant");
        ICY_PEAK_VAR = BUILDER.define("icy_peak_biome_variant", DefaultBiomes.PRIMARY_PEAK_BIOMES_VARIANT[0].location().toString());
        COOL_PEAK_VAR = BUILDER.define("cold_peak_biome_variant", DefaultBiomes.PRIMARY_PEAK_BIOMES_VARIANT[1].location().toString());
        NEUTRAL_PEAK_VAR = BUILDER.define("neutral_peak_biome_variant", DefaultBiomes.PRIMARY_PEAK_BIOMES_VARIANT[2].location().toString());
        WARM_PEAK_VAR = BUILDER.define("warm_peak_biome_variant", DefaultBiomes.PRIMARY_PEAK_BIOMES_VARIANT[3].location().toString());
        HOT_PEAK_VAR = BUILDER.define("hot_peak_biome_variant", DefaultBiomes.PRIMARY_PEAK_BIOMES_VARIANT[4].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------RIVER_BIOMES--------------------");
        BUILDER.comment("icy_biomes");
        RVR_ICY_ARID = BUILDER.define("icy_arid", DefaultBiomes.PRIMARY_RIVER_BIOMES[0][0].location().toString());
        RVR_ICY_DRY = BUILDER.define("icy_dry", DefaultBiomes.PRIMARY_RIVER_BIOMES[0][1].location().toString());
        RVR_ICY_NEUTRAL = BUILDER.define("icy_neutral", DefaultBiomes.PRIMARY_RIVER_BIOMES[0][2].location().toString());
        RVR_ICY_WET = BUILDER.define("icy_wet", DefaultBiomes.PRIMARY_RIVER_BIOMES[0][3].location().toString());
        RVR_ICY_HUMID = BUILDER.define("icy_humid", DefaultBiomes.PRIMARY_RIVER_BIOMES[0][4].location().toString());
        BUILDER.comment("cool_biomes");
        RVR_COOL_ARID = BUILDER.define("cool_arid", DefaultBiomes.PRIMARY_RIVER_BIOMES[1][0].location().toString());
        RVR_COOL_DRY = BUILDER.define("cool_dry", DefaultBiomes.PRIMARY_RIVER_BIOMES[1][1].location().toString());
        RVR_COOL_NEUTRAL = BUILDER.define("cool_neutral", DefaultBiomes.PRIMARY_RIVER_BIOMES[1][2].location().toString());
        RVR_COOL_WET = BUILDER.define("cool_wet", DefaultBiomes.PRIMARY_RIVER_BIOMES[1][3].location().toString());
        RVR_COOL_HUMID = BUILDER.define("cool_humid", DefaultBiomes.PRIMARY_RIVER_BIOMES[1][4].location().toString());
        BUILDER.comment("neutral_biomes");
        RVR_NEUTRAL_ARID = BUILDER.define("neutral_arid", DefaultBiomes.PRIMARY_RIVER_BIOMES[2][0].location().toString());
        RVR_NEUTRAL_DRY = BUILDER.define("neutral_dry", DefaultBiomes.PRIMARY_RIVER_BIOMES[2][1].location().toString());
        RVR_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", DefaultBiomes.PRIMARY_RIVER_BIOMES[2][2].location().toString());
        RVR_NEUTRAL_WET = BUILDER.define("neutral_wet", DefaultBiomes.PRIMARY_RIVER_BIOMES[2][3].location().toString());
        RVR_NEUTRAL_HUMID = BUILDER.define("neutral_humid", DefaultBiomes.PRIMARY_RIVER_BIOMES[2][4].location().toString());
        BUILDER.comment("warm_biomes");
        RVR_WARM_ARID = BUILDER.define("warm_arid", DefaultBiomes.PRIMARY_RIVER_BIOMES[3][0].location().toString());
        RVR_WARM_DRY = BUILDER.define("warm_dry", DefaultBiomes.PRIMARY_RIVER_BIOMES[3][1].location().toString());
        RVR_WARM_NEUTRAL = BUILDER.define("warm_neutral", DefaultBiomes.PRIMARY_RIVER_BIOMES[3][2].location().toString());
        RVR_WARM_WET = BUILDER.define("warm_wet", DefaultBiomes.PRIMARY_RIVER_BIOMES[3][3].location().toString());
        RVR_WARM_HUMID = BUILDER.define("warm_humid", DefaultBiomes.PRIMARY_RIVER_BIOMES[3][4].location().toString());
        BUILDER.comment("hot_biomes");
        RVR_HOT_ARID = BUILDER.define("hot_arid", DefaultBiomes.PRIMARY_RIVER_BIOMES[4][0].location().toString());
        RVR_HOT_DRY = BUILDER.define("hot_dry", DefaultBiomes.PRIMARY_RIVER_BIOMES[4][1].location().toString());
        RVR_HOT_NEUTRAL = BUILDER.define("hot_neutral", DefaultBiomes.PRIMARY_RIVER_BIOMES[4][2].location().toString());
        RVR_HOT_WET = BUILDER.define("hot_wet", DefaultBiomes.PRIMARY_RIVER_BIOMES[4][3].location().toString());
        RVR_HOT_HUMID = BUILDER.define("hot_humid", DefaultBiomes.PRIMARY_RIVER_BIOMES[4][4].location().toString());
        BUILDER.pop();
        BUILDER.push("-----------------RIVER_BIOMES_VARIANT--------------------");
        BUILDER.comment("icy_biomes");
        RVR_VAR_ICY_ARID = BUILDER.define("icy_arid", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[0][0].location().toString());
        RVR_VAR_ICY_DRY = BUILDER.define("icy_dry", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[0][1].location().toString());
        RVR_VAR_ICY_NEUTRAL = BUILDER.define("icy_neutral", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[0][2].location().toString());
        RVR_VAR_ICY_WET = BUILDER.define("icy_wet", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[0][3].location().toString());
        RVR_VAR_ICY_HUMID = BUILDER.define("icy_humid", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[0][4].location().toString());
        BUILDER.comment("cool_biomes");
        RVR_VAR_COOL_ARID = BUILDER.define("cool_arid", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[1][0].location().toString());
        RVR_VAR_COOL_DRY = BUILDER.define("cool_dry", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[1][1].location().toString());
        RVR_VAR_COOL_NEUTRAL = BUILDER.define("cool_neutral", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[1][2].location().toString());
        RVR_VAR_COOL_WET = BUILDER.define("cool_wet", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[1][3].location().toString());
        RVR_VAR_COOL_HUMID = BUILDER.define("cool_humid", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[1][4].location().toString());
        BUILDER.comment("neutral_biomes");
        RVR_VAR_NEUTRAL_ARID = BUILDER.define("neutral_arid", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[2][0].location().toString());
        RVR_VAR_NEUTRAL_DRY = BUILDER.define("neutral_dry", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[2][1].location().toString());
        RVR_VAR_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[2][2].location().toString());
        RVR_VAR_NEUTRAL_WET = BUILDER.define("neutral_wet", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[2][3].location().toString());
        RVR_VAR_NEUTRAL_HUMID = BUILDER.define("neutral_humid", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[2][4].location().toString());
        BUILDER.comment("warm_biomes");
        RVR_VAR_WARM_ARID = BUILDER.define("warm_arid", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[3][0].location().toString());
        RVR_VAR_WARM_DRY = BUILDER.define("warm_dry", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[3][1].location().toString());
        RVR_VAR_WARM_NEUTRAL = BUILDER.define("warm_neutral", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[3][2].location().toString());
        RVR_VAR_WARM_WET = BUILDER.define("warm_wet", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[3][3].location().toString());
        RVR_VAR_WARM_HUMID = BUILDER.define("warm_humid", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[3][4].location().toString());
        BUILDER.comment("hot_biomes");
        RVR_VAR_HOT_ARID = BUILDER.define("hot_arid", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[4][0].location().toString());
        RVR_VAR_HOT_DRY = BUILDER.define("hot_dry", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[4][1].location().toString());
        RVR_VAR_HOT_NEUTRAL = BUILDER.define("hot_neutral", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[4][2].location().toString());
        RVR_VAR_HOT_WET = BUILDER.define("hot_wet", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[4][3].location().toString());
        RVR_VAR_HOT_HUMID = BUILDER.define("hot_humid", DefaultBiomes.PRIMARY_RIVER_BIOMES_VARIANT[4][4].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------SWAMP_BIOMES--------------------");
        BUILDER.comment("icy_biomes");
        SMP_ICY_ARID = BUILDER.define("icy_arid", DefaultBiomes.PRIMARY_SWAMP_BIOMES[0][0].location().toString());
        SMP_ICY_DRY = BUILDER.define("icy_dry", DefaultBiomes.PRIMARY_SWAMP_BIOMES[0][1].location().toString());
        SMP_ICY_NEUTRAL = BUILDER.define("icy_neutral", DefaultBiomes.PRIMARY_SWAMP_BIOMES[0][2].location().toString());
        SMP_ICY_WET = BUILDER.define("icy_wet", DefaultBiomes.PRIMARY_SWAMP_BIOMES[0][3].location().toString());
        SMP_ICY_HUMID = BUILDER.define("icy_humid", DefaultBiomes.PRIMARY_SWAMP_BIOMES[0][4].location().toString());
        BUILDER.comment("cool_biomes");
        SMP_COOL_ARID = BUILDER.define("cool_arid", DefaultBiomes.PRIMARY_SWAMP_BIOMES[1][0].location().toString());
        SMP_COOL_DRY = BUILDER.define("cool_dry", DefaultBiomes.PRIMARY_SWAMP_BIOMES[1][1].location().toString());
        SMP_COOL_NEUTRAL = BUILDER.define("cool_neutral", DefaultBiomes.PRIMARY_SWAMP_BIOMES[1][2].location().toString());
        SMP_COOL_WET = BUILDER.define("cool_wet", DefaultBiomes.PRIMARY_SWAMP_BIOMES[1][3].location().toString());
        SMP_COOL_HUMID = BUILDER.define("cool_humid", DefaultBiomes.PRIMARY_SWAMP_BIOMES[1][4].location().toString());
        BUILDER.comment("neutral_biomes");
        SMP_NEUTRAL_ARID = BUILDER.define("neutral_arid", DefaultBiomes.PRIMARY_SWAMP_BIOMES[2][0].location().toString());
        SMP_NEUTRAL_DRY = BUILDER.define("neutral_dry", DefaultBiomes.PRIMARY_SWAMP_BIOMES[2][1].location().toString());
        SMP_NEUTRAL_NEUTRAL = BUILDER.define("neutral_neutral", DefaultBiomes.PRIMARY_SWAMP_BIOMES[2][2].location().toString());
        SMP_NEUTRAL_WET = BUILDER.define("neutral_wet", DefaultBiomes.PRIMARY_SWAMP_BIOMES[2][3].location().toString());
        SMP_NEUTRAL_HUMID = BUILDER.define("neutral_humid", DefaultBiomes.PRIMARY_SWAMP_BIOMES[2][4].location().toString());
        BUILDER.comment("warm_biomes");
        SMP_WARM_ARID = BUILDER.define("warm_arid", DefaultBiomes.PRIMARY_SWAMP_BIOMES[3][0].location().toString());
        SMP_WARM_DRY = BUILDER.define("warm_dry", DefaultBiomes.PRIMARY_SWAMP_BIOMES[3][1].location().toString());
        SMP_WARM_NEUTRAL = BUILDER.define("warm_neutral", DefaultBiomes.PRIMARY_SWAMP_BIOMES[3][2].location().toString());
        SMP_WARM_WET = BUILDER.define("warm_wet", DefaultBiomes.PRIMARY_SWAMP_BIOMES[3][3].location().toString());
        SMP_WARM_HUMID = BUILDER.define("warm_humid", DefaultBiomes.PRIMARY_SWAMP_BIOMES[3][4].location().toString());
        BUILDER.comment("hot_biomes");
        SMP_HOT_ARID = BUILDER.define("hot_arid", DefaultBiomes.PRIMARY_SWAMP_BIOMES[4][0].location().toString());
        SMP_HOT_DRY = BUILDER.define("hot_dry", DefaultBiomes.PRIMARY_SWAMP_BIOMES[4][1].location().toString());
        SMP_HOT_NEUTRAL = BUILDER.define("hot_neutral", DefaultBiomes.PRIMARY_SWAMP_BIOMES[4][2].location().toString());
        SMP_HOT_WET = BUILDER.define("hot_wet", DefaultBiomes.PRIMARY_SWAMP_BIOMES[4][3].location().toString());
        SMP_HOT_HUMID = BUILDER.define("hot_humid", DefaultBiomes.PRIMARY_SWAMP_BIOMES[4][4].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------OCEAN_BIOMES--------------------");
        BUILDER.comment("deep_oceans");
        OCA_DEP_ICY = BUILDER.define("deep_icy", DefaultBiomes.PRIMARY_OCEAN_BIOMES[0][0].location().toString());
        OCA_DEP_COOL = BUILDER.define("deep_cool", DefaultBiomes.PRIMARY_OCEAN_BIOMES[0][1].location().toString());
        OCA_DEP_NEUTRAL = BUILDER.define("deep_neutral", DefaultBiomes.PRIMARY_OCEAN_BIOMES[0][2].location().toString());
        OCA_DEP_WARM = BUILDER.define("deep_warm", DefaultBiomes.PRIMARY_OCEAN_BIOMES[0][3].location().toString());
        OCA_DEP_HOT = BUILDER.define("deep_hot", DefaultBiomes.PRIMARY_OCEAN_BIOMES[0][4].location().toString());
        BUILDER.comment("oceans");
        OCA_ICY = BUILDER.define("icy", DefaultBiomes.PRIMARY_OCEAN_BIOMES[1][0].location().toString());
        OCA_COOL = BUILDER.define("cool", DefaultBiomes.PRIMARY_OCEAN_BIOMES[1][1].location().toString());
        OCA_NEUTRAL = BUILDER.define("neutral", DefaultBiomes.PRIMARY_OCEAN_BIOMES[1][2].location().toString());
        OCA_WARM = BUILDER.define("warm", DefaultBiomes.PRIMARY_OCEAN_BIOMES[1][3].location().toString());
        OCA_HOT = BUILDER.define("hot", DefaultBiomes.PRIMARY_OCEAN_BIOMES[1][4].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------SHORE_BIOMES--------------------");
        BUILDER.comment("beach_biomes");
        ICY_BEACH = BUILDER.define("icy_beach_biome", DefaultBiomes.PRIMARY_BEACH_BIOMES[0].location().toString());
        COOL_BEACH = BUILDER.define("cold_beach_biome", DefaultBiomes.PRIMARY_BEACH_BIOMES[1].location().toString());
        NEUTRAL_BEACH = BUILDER.define("neutral_beach_biome", DefaultBiomes.PRIMARY_BEACH_BIOMES[2].location().toString());
        WARM_BEACH = BUILDER.define("warm_beach_biome", DefaultBiomes.PRIMARY_BEACH_BIOMES[3].location().toString());
        HOT_BEACH = BUILDER.define("hot_beach_biome", DefaultBiomes.PRIMARY_BEACH_BIOMES[4].location().toString());
        BUILDER.comment("stone_beach_biomes");
        COLD_STONE_BEACH = BUILDER.define("cold_stone_beach_biome", DefaultBiomes.PRIMARY_STONE_SHORE_BIOMES[0].location().toString());
        HOT_STONE_BEACH = BUILDER.define("hot_stone_beach_biome", DefaultBiomes.PRIMARY_STONE_SHORE_BIOMES[1].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------UNDERGROUND_BIOMES--------------------");
        CAVE_1 = BUILDER.define("cave_1_biome", DefaultBiomes.PRIMARY_CAVE_BIOMES[0].location().toString());
        CAVE_2 = BUILDER.define("cave_2_biome", DefaultBiomes.PRIMARY_CAVE_BIOMES[1].location().toString());
        CAVE_3 = BUILDER.define("cave_3_biome", DefaultBiomes.PRIMARY_CAVE_BIOMES[2].location().toString());
        CAVE_4 = BUILDER.define("cave_4_biome", DefaultBiomes.PRIMARY_CAVE_BIOMES[3].location().toString());
        CAVE_5 = BUILDER.define("cave_5_biome", DefaultBiomes.PRIMARY_CAVE_BIOMES[4].location().toString());
        CAVE_6 = BUILDER.define("cave_6_biome", DefaultBiomes.PRIMARY_CAVE_BIOMES[5].location().toString());
        CAVE_7 = BUILDER.define("cave_7_biome", DefaultBiomes.PRIMARY_CAVE_BIOMES[6].location().toString());
        CAVE_8 = BUILDER.define("cave_8_biome", DefaultBiomes.PRIMARY_CAVE_BIOMES[7].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------ISLAND_BIOMES--------------------");
        ICY_ISLAND = BUILDER.define("icy_island_biome", DefaultBiomes.PRIMARY_ISLAND_BIOMES[0].location().toString());
        COOL_ISLAND = BUILDER.define("cool_island_biome", DefaultBiomes.PRIMARY_ISLAND_BIOMES[1].location().toString());
        NEUTRAL_ISLAND = BUILDER.define("neutral_island_biome", DefaultBiomes.PRIMARY_ISLAND_BIOMES[2].location().toString());
        WARM_ISLAND = BUILDER.define("warm_island_biome", DefaultBiomes.PRIMARY_ISLAND_BIOMES[3].location().toString());
        HOT_ISLAND = BUILDER.define("hot_island_biome", DefaultBiomes.PRIMARY_ISLAND_BIOMES[4].location().toString());
        BUILDER.pop();

        BUILDER.push("-----------------OTHER_BIOMES--------------------");
        SHA_CLI = BUILDER.define("shattered_cliff_biome", RuBiomes.TOWERING_CLIFFS.location().toString());
        BUILDER.pop();

        SPEC = BUILDER.build();
    }
}
