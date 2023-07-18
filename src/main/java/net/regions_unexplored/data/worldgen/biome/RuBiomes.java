package net.regions_unexplored.data.worldgen.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.regions_unexplored.RegionsUnexploredMod;

public class RuBiomes {
    //FOREST
    public static ResourceKey<Biome> AUTUMNAL_MAPLE_FOREST = createKey("autumnal_maple_forest");
    public static ResourceKey<Biome> BAMBOO_FOREST = createKey("bamboo_forest");
    public static ResourceKey<Biome> MAGNOLIA_HIGHLANDS = createKey("magnolia_highlands");
    public static ResourceKey<Biome> DECIDUOUS_FOREST = createKey("deciduous_forest");
    public static ResourceKey<Biome> MAPLE_FOREST = createKey("maple_forest");
    public static ResourceKey<Biome> MAUVE_HILLS = createKey("mauve_hills");
    public static ResourceKey<Biome> ORCHARD = createKey("orchard");
    public static ResourceKey<Biome> SILVER_BIRCH_FOREST = createKey("silver_birch_forest");
    public static ResourceKey<Biome> TEMPERATE_GROVE = createKey("temperate_grove");
    public static ResourceKey<Biome> WILLOW_FOREST = createKey("willow_forest");
    //TAIGA
    public static ResourceKey<Biome> BLACKWOOD_TAIGA = createKey("blackwood_taiga");
    public static ResourceKey<Biome> BOREAL_TAIGA = createKey("boreal_taiga");
    public static ResourceKey<Biome> GOLDEN_BOREAL_TAIGA = createKey("golden_boreal_taiga");
    public static ResourceKey<Biome> PINE_TAIGA = createKey("pine_taiga");
    public static ResourceKey<Biome> REDWOODS = createKey("redwoods");
    public static ResourceKey<Biome> SPARSE_REDWOODS = createKey("sparse_redwoods");
    //PLAINS
    public static ResourceKey<Biome> BARLEY_FIELDS = createKey("barley_fields");
    public static ResourceKey<Biome> FLOWER_FIELDS = createKey("flower_fields");
    public static ResourceKey<Biome> GRASSLAND = createKey("grassland");
    public static ResourceKey<Biome> LUPINE_PLAINS = createKey("lupine_plains");
    public static ResourceKey<Biome> ROCKY_MEADOW = createKey("rocky_meadow");
    public static ResourceKey<Biome> POPPY_FIELDS = createKey("poppy_fields");
    public static ResourceKey<Biome> PRAIRIE = createKey("prairie");
    public static ResourceKey<Biome> PUMPKIN_FIELDS = createKey("pumpkin_fields");
    public static ResourceKey<Biome> SHRUBLAND = createKey("shrubland");
    //WET
    public static ResourceKey<Biome> BAYOU = createKey("bayou");
    public static ResourceKey<Biome> EUCALYPTUS_FOREST = createKey("eucalyptus_forest");
    public static ResourceKey<Biome> FEN = createKey("fen");
    public static ResourceKey<Biome> FLOODED_PLAINS = createKey("flooded_plains");
    public static ResourceKey<Biome> FUNGAL_FEN = createKey("fungal_fen");
    public static ResourceKey<Biome> OLD_GROWTH_BAYOU = createKey("old_growth_bayou");
    public static ResourceKey<Biome> OLD_GROWTH_RAINFOREST = createKey("old_growth_rainforest");
    public static ResourceKey<Biome> RAINFOREST = createKey("rainforest");
    //ARID
    public static ResourceKey<Biome> BAOBAB_SAVANNA = createKey("baobab_savanna");
    public static ResourceKey<Biome> DRY_BUSHLAND = createKey("dry_bushland");
    public static ResourceKey<Biome> JOSHUA_DESERT = createKey("joshua_desert");
    public static ResourceKey<Biome> OUTBACK = createKey("outback");
    public static ResourceKey<Biome> SAGUARO_DESERT = createKey("saguaro_desert");
    public static ResourceKey<Biome> STEPPE = createKey("steppe");
    //MOUNTAIN
    public static ResourceKey<Biome> ARID_MOUNTAINS = createKey("arid_mountains");
    public static ResourceKey<Biome> HIGHLAND_FIELDS = createKey("highland_fields");
    public static ResourceKey<Biome> LUSH_HILLS = createKey("lush_hills");
    public static ResourceKey<Biome> MOUNTAINS = createKey("mountains");
    public static ResourceKey<Biome> PINE_SLOPES = createKey("pine_slopes");
    public static ResourceKey<Biome> TOWERING_CLIFFS = createKey("towering_cliffs");
    //COASTAL
    public static ResourceKey<Biome> CHALK_CLIFFS = createKey("chalk_cliffs");
    public static ResourceKey<Biome> GRASSY_BEACH = createKey("grassy_beach");
    public static ResourceKey<Biome> GRAVEL_BEACH = createKey("gravel_beach");
    //AQUATIC
    public static ResourceKey<Biome> ALPHA_GROVE = createKey("alpha_grove");
    public static ResourceKey<Biome> ASHEN_WOODLAND = createKey("ashen_woodland");
    public static ResourceKey<Biome> COLD_RIVER = createKey("cold_river");
    public static ResourceKey<Biome> HYACINTH_DEEPS = createKey("hyacinth_deeps");
    public static ResourceKey<Biome> MUDDY_RIVER = createKey("muddy_river");
    public static ResourceKey<Biome> ROCKY_REEF = createKey("rocky_reef");
    public static ResourceKey<Biome> TROPICS = createKey("tropics");
    //FROZEN
    public static ResourceKey<Biome> COLD_BOREAL_TAIGA = createKey("cold_boreal_taiga");
    public static ResourceKey<Biome> COLD_DECIDUOUS_FOREST = createKey("cold_deciduous_forest");
    public static ResourceKey<Biome> FROZEN_PINE_TAIGA = createKey("frozen_pine_taiga");
    public static ResourceKey<Biome> FROZEN_TUNDRA = createKey("frozen_tundra");
    public static ResourceKey<Biome> ICY_HEIGHTS = createKey("icy_heights");
    public static ResourceKey<Biome> SPIRES = createKey("spires");
    //CAVE
    public static ResourceKey<Biome> BIOSHROOM_CAVES = createKey("bioshroom_caves");
    public static ResourceKey<Biome> ANCIENT_DELTA = createKey("ancient_delta");
    public static ResourceKey<Biome> PRISMACHASM = createKey("prismachasm");
    public static ResourceKey<Biome> REDSTONE_CAVES = createKey("redstone_caves");
    public static ResourceKey<Biome> SCORCHING_CAVES = createKey("scorching_caves");
    //NETHER
    public static ResourceKey<Biome> BLACKSTONE_BASIN = createKey("blackstone_basin");
    public static ResourceKey<Biome> CORRUPTED_HOLT = createKey("corrupted_holt");
    public static ResourceKey<Biome> GLISTERING_MEADOW = createKey("glistering_meadow");
    public static ResourceKey<Biome> MYCOTOXIC_UNDERGROWTH = createKey("mycotoxic_undergrowth");
    public static ResourceKey<Biome> REDSTONE_HELL = createKey("redstone_hell");

    public static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(RegionsUnexploredMod.MOD_ID, name));
    }
}
