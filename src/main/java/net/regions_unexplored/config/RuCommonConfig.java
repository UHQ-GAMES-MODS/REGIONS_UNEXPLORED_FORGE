package net.regions_unexplored.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class RuCommonConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_MAUVE_LEAVES_PARTICLE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_BLUE_MAGNOLIA_LEAVES_PARTICLE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_PINK_MAGNOLIA_LEAVES_PARTICLE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_WHITE_MAGNOLIA_LEAVES_PARTICLE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_RED_MAPLE_LEAVES_PARTICLE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_ORANGE_MAPLE_LEAVES_PARTICLE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_SILVER_BIRCH_LEAVES_PARTICLE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_ENCHANTED_BIRCH_LEAVES_PARTICLE;

    public static final ForgeConfigSpec.DoubleValue EUCALYPTUS_TRANSITION_SIZE;
    public static final ForgeConfigSpec.ConfigValue<Double> EUCALYPTUS_SATURATION;
    public static final ForgeConfigSpec.DoubleValue EUCALYPTUS_BRIGHTNESS;

    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_CUSTOM_DIRTS;

    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_CUSTOM_REGIONS;

    public static final ForgeConfigSpec.ConfigValue<Integer> REGION_PRIMARY_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> REGION_SECONDARY_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> REGION_RARE_WEIGHT;
    public static final ForgeConfigSpec.ConfigValue<Integer> REGION_NETHER_WEIGHT;

    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_ALPHA_GROVE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_ARID_MOUNTAINS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_AUTUMNAL_MAPLE_FOREST;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_BAMBOO_FOREST;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_BAOBAB_SAVANNA;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_BARLEY_FIELDS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_BAYOU;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_BLACKWOOD_TAIGA;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_BOREAL_TAIGA;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_CHALK_CLIFFS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_COLD_BOREAL_TAIGA;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_COLD_DECIDUOUS_FOREST;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_COLD_RIVER;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_MAGNOLIA_WOODLAND;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_DECIDUOUS_FOREST;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_DRY_BUSHLAND;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_EUCALYPTUS_FOREST;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_FEN;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_MARSH;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_FLOWER_FIELDS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_FROZEN_PINE_TAIGA;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_FROZEN_TUNDRA;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_FUNGAL_FEN;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_HYACINTH_DEEPS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_OLD_GROWTH_BAYOU;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_GOLDEN_BOREAL_TAIGA;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_GRASSLAND;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_GRASSY_BEACH;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_GRAVEL_BEACH;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_HIGHLAND_FIELDS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_ICY_DESERT;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_ICY_HEIGHTS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_JOSHUA_DESERT;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_CLOVER_PLAINS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_MAPLE_FOREST;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_MAUVE_HILLS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_MEADOW;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_MOUNTAINS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_MUDDY_RIVER;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_SPARSE_RAINFOREST;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_ORCHARD;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_OUTBACK;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_PINE_TAIGA;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_PINE_SLOPES;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_POPPY_FIELDS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_PRAIRIE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_PUMPKIN_FIELDS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_RAINFOREST;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_ROCKY_REEF;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_REDWOODS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_SAGUARO_DESERT;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_SHRUBLAND;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_SILVER_BIRCH_FOREST;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_ASHEN_WOODLAND;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_SPARSE_REDWOODS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_SPIRES;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_STEPPE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_TEMPERATE_GROVE;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_TOWERING_CLIFFS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_TROPICAL_RIVER;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_TROPICS;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_WILLOW_FOREST;

    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_BIOSHROOM_CAVES;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_ANCIENT_DELTA;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_PRISMACHASM;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_REDSTONE_CAVES;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_SCORCHING_CAVES;

    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_BLACKSTONE_BASIN;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_INFERNAL_HOLT;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_GLISTERING_MEADOW;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_MYCOTOXIC_UNDERGROWTH;
    public static final ForgeConfigSpec.ConfigValue<Boolean> TOGGLE_REDSTONE_ABYSS;
    static {
        BUILDER.comment("Config for Regions Unexplored!");

        BUILDER.push("region_configs");


        TOGGLE_CUSTOM_REGIONS = BUILDER.comment("Enable this before changing the other region config files. If disabled, RU will use builtin biome placement.")
                .define("toggle_custom_regions", false);

        REGION_PRIMARY_WEIGHT = BUILDER.comment("Sets Terrablender region weight for the primary region.")
                .defineInRange("primary_region_weight", 11, 0, 2147483646);

        REGION_SECONDARY_WEIGHT = BUILDER.comment("Sets Terrablender region weight for the secondary region.")
                .defineInRange("secondary_region_weight", 8, 0, 2147483646);

        REGION_RARE_WEIGHT = BUILDER.comment("Sets Terrablender region weight for the rare region.")
                .defineInRange("rare_region_weight", 1, 0, 2147483646);

        REGION_NETHER_WEIGHT = BUILDER.comment("Sets Terrablender region weight for Nether region.")
                .defineInRange("nether_region_weight", 14, 0, 2147483646);

        BUILDER.pop();
        BUILDER.push("biome_toggles");


        BUILDER.comment("overworld_biomes");
        TOGGLE_ALPHA_GROVE = BUILDER.define("toggle_alpha_grove", true);
        TOGGLE_ARID_MOUNTAINS = BUILDER.define("toggle_arid_mountains", true);
        TOGGLE_ASHEN_WOODLAND = BUILDER.define("toggle_smouldering_woodland", true);
        TOGGLE_AUTUMNAL_MAPLE_FOREST = BUILDER.define("toggle_autumnal_maple_forest", true);
        TOGGLE_BAMBOO_FOREST = BUILDER.define("toggle_bamboo_forest", true);
        TOGGLE_BAOBAB_SAVANNA = BUILDER.define("toggle_baobab_savanna", true);
        TOGGLE_BARLEY_FIELDS = BUILDER.define("toggle_barley_fields", true);
        TOGGLE_BAYOU = BUILDER.define("toggle_bayou", true);
        TOGGLE_BLACKWOOD_TAIGA = BUILDER.define("toggle_blackwood_taiga", true);
        TOGGLE_BOREAL_TAIGA = BUILDER.define("toggle_boreal_taiga", true);
        TOGGLE_CHALK_CLIFFS = BUILDER.define("toggle_chalk_cliffs", true);
        TOGGLE_CLOVER_PLAINS = BUILDER.define("toggle_clover_plains", true);
        TOGGLE_COLD_BOREAL_TAIGA = BUILDER.define("toggle_cold_boreal_taiga", true);
        TOGGLE_COLD_DECIDUOUS_FOREST = BUILDER.define("toggle_cold_deciduous_forest", true);
        TOGGLE_COLD_RIVER = BUILDER.define("toggle_cold_river", true);
        TOGGLE_DECIDUOUS_FOREST = BUILDER.define("toggle_deciduous_forest", true);
        TOGGLE_DRY_BUSHLAND = BUILDER.define("toggle_dry_bushland", true);
        TOGGLE_EUCALYPTUS_FOREST = BUILDER.define("toggle_eucalyptus_forest", true);
        TOGGLE_FEN = BUILDER.define("toggle_fen", true);
        TOGGLE_FLOWER_FIELDS = BUILDER.define("toggle_flower_field", true);
        TOGGLE_FROZEN_PINE_TAIGA = BUILDER.define("toggle_frozen_pine_taiga", true);
        TOGGLE_FROZEN_TUNDRA = BUILDER.define("toggle_frozen_tundra", true);
        TOGGLE_FUNGAL_FEN = BUILDER.define("toggle_fungal_fen", true);
        TOGGLE_GOLDEN_BOREAL_TAIGA = BUILDER.define("toggle_golden_boreal_taiga", true);
        TOGGLE_GRASSLAND = BUILDER.define("toggle_grassland", true);
        TOGGLE_GRASSY_BEACH = BUILDER.define("toggle_grassy_beach", true);
        TOGGLE_GRAVEL_BEACH = BUILDER.define("toggle_gravel_beach", true);
        TOGGLE_HIGHLAND_FIELDS = BUILDER.define("toggle_highland_fields", true);
        TOGGLE_HYACINTH_DEEPS = BUILDER.define("toggle_hyacinth_deeps", true);
        TOGGLE_ICY_DESERT = BUILDER.define("toggle_icy_desert", true);
        TOGGLE_ICY_HEIGHTS = BUILDER.define("toggle_icy_heights", true);
        TOGGLE_JOSHUA_DESERT = BUILDER.define("toggle_joshua_desert", true);
        TOGGLE_MAGNOLIA_WOODLAND = BUILDER.define("toggle_magnolia_woodland", true);
        TOGGLE_MAPLE_FOREST = BUILDER.define("toggle_maple_forest", true);
        TOGGLE_MARSH = BUILDER.define("toggle_marsh", true);
        TOGGLE_MAUVE_HILLS = BUILDER.define("toggle_mauve_hills", true);
        TOGGLE_MEADOW = BUILDER.define("toggle_meadow", true);
        TOGGLE_MOUNTAINS = BUILDER.define("toggle_mountains", true);
        TOGGLE_MUDDY_RIVER = BUILDER.define("toggle_muddy_river", true);
        TOGGLE_OLD_GROWTH_BAYOU = BUILDER.define("toggle_old_growth_bayou", true);
        TOGGLE_ORCHARD = BUILDER.define("toggle_orchard", true);
        TOGGLE_OUTBACK = BUILDER.define("toggle_outback", true);
        TOGGLE_PINE_SLOPES = BUILDER.define("toggle_pine_slopes", true);
        TOGGLE_PINE_TAIGA = BUILDER.define("toggle_pine_taiga", true);
        TOGGLE_POPPY_FIELDS = BUILDER.define("toggle_poppy_fields", true);
        TOGGLE_PRAIRIE = BUILDER.define("toggle_prairie", true);
        TOGGLE_PUMPKIN_FIELDS = BUILDER.define("toggle_pumpkin_fields", true);
        TOGGLE_RAINFOREST = BUILDER.define("toggle_rainforest", true);
        TOGGLE_ROCKY_REEF = BUILDER.define("toggle_rocky_reef", true);
        TOGGLE_REDWOODS = BUILDER.define("toggle_redwoods", true);
        TOGGLE_SAGUARO_DESERT = BUILDER.define("toggle_saguaro_desert", true);
        TOGGLE_SHRUBLAND = BUILDER.define("toggle_shrubland", true);
        TOGGLE_SILVER_BIRCH_FOREST = BUILDER.define("toggle_silver_birch_forest", true);
        TOGGLE_SPARSE_RAINFOREST = BUILDER.define("toggle_sparse_rainforest", true);
        TOGGLE_SPARSE_REDWOODS = BUILDER.define("toggle_sparse_redwoods", true);
        TOGGLE_SPIRES = BUILDER.define("toggle_spires", true);
        TOGGLE_STEPPE = BUILDER.define("toggle_steppe", true);
        TOGGLE_TEMPERATE_GROVE = BUILDER.define("toggle_temperate_grove", true);
        TOGGLE_TOWERING_CLIFFS = BUILDER.define("toggle_towering_cliffs", true);
        TOGGLE_TROPICAL_RIVER = BUILDER.define("toggle_tropical_river", true);
        TOGGLE_TROPICS = BUILDER.define("toggle_tropics", true);
        TOGGLE_WILLOW_FOREST = BUILDER.define("toggle_willow_forest", true);
        BUILDER.comment("cave_biomes");
        TOGGLE_ANCIENT_DELTA = BUILDER.define("toggle_ancient_delta", true);
        TOGGLE_BIOSHROOM_CAVES = BUILDER.define("toggle_bioshroom_caves", true);
        TOGGLE_PRISMACHASM = BUILDER.define("toggle_prismachasm", true);
        TOGGLE_REDSTONE_CAVES = BUILDER.define("toggle_redstone_caves", true);
        TOGGLE_SCORCHING_CAVES = BUILDER.define("toggle_scorching_caves", true);
        BUILDER.comment("nether_biomes");
        TOGGLE_BLACKSTONE_BASIN = BUILDER.define("toggle_blackstone_basin", true);
        TOGGLE_GLISTERING_MEADOW = BUILDER.define("toggle_glistering_meadow", true);
        TOGGLE_INFERNAL_HOLT = BUILDER.define("toggle_infernal_holt", true);
        TOGGLE_MYCOTOXIC_UNDERGROWTH = BUILDER.define("toggle_mycotoxic_undergrowth", true);
        TOGGLE_REDSTONE_ABYSS = BUILDER.define("toggle_redstone_hell", true);

        BUILDER.pop();
        //
        BUILDER.push("worldgen_options");

        BUILDER.comment("surface_rules");
        TOGGLE_CUSTOM_DIRTS = BUILDER.define("toggle_custom_dirt", true);

        BUILDER.pop();
        //
        BUILDER.push("client_options");
        TOGGLE_MAUVE_LEAVES_PARTICLE = BUILDER.define("toggle_mauve_leaves_particles", true);
        TOGGLE_BLUE_MAGNOLIA_LEAVES_PARTICLE = BUILDER.define("toggle_blue_magnolia_leaves_particles", true);
        TOGGLE_PINK_MAGNOLIA_LEAVES_PARTICLE = BUILDER.define("toggle_pink_magnolia_leaves_particles", true);
        TOGGLE_WHITE_MAGNOLIA_LEAVES_PARTICLE = BUILDER.define("toggle_white_magnolia_leaves_particles", true);
        TOGGLE_RED_MAPLE_LEAVES_PARTICLE = BUILDER.define("toggle_red_maple_leaves_particles", true);
        TOGGLE_ORANGE_MAPLE_LEAVES_PARTICLE = BUILDER.define("toggle_orange_maple_leaves_particles", true);
        TOGGLE_SILVER_BIRCH_LEAVES_PARTICLE = BUILDER.define("toggle_silver_birch_leaves_particles", true);
        TOGGLE_ENCHANTED_BIRCH_LEAVES_PARTICLE = BUILDER.define("toggle_enchanted_birch_leaves_particles", true);

        BUILDER.comment("block_color_options");
        EUCALYPTUS_TRANSITION_SIZE = BUILDER.comment("Sets Eucalyptus colour transition size. Bigger number = bigger distance between colours.")
                .defineInRange("eucalyptus_transition_size", 25.0, 0.0, 200.0);
        EUCALYPTUS_SATURATION = BUILDER.comment("Sets Eucalyptus colour saturation.")
                .defineInRange("eucalyptus_saturation", 0.5, 0.0, 1.0);
        EUCALYPTUS_BRIGHTNESS = BUILDER.comment("Sets Eucalyptus colour saturation.")
                .defineInRange("eucalyptus_brightness", 0.8, 0.0, 1.0);

        BUILDER.pop();
        //
        SPEC = BUILDER.build();
    }
}
