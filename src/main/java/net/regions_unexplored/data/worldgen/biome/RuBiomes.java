package net.regions_unexplored.data.worldgen.biome;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.regions_unexplored.RegionsUnexploredMod;

public class RuBiomes {
    //FOREST
    public static ResourceKey<Biome> AUTUMNAL_MAPLE_FOREST = createKey("autumnal_maple_forest");//DONE
    public static ResourceKey<Biome> BAMBOO_FOREST = createKey("bamboo_forest");//DONE
    public static ResourceKey<Biome> MAGNOLIA_HIGHLANDS = createKey("magnolia_highlands");//DONE
    public static ResourceKey<Biome> DECIDUOUS_FOREST = createKey("deciduous_forest");//DONE
    public static ResourceKey<Biome> MAPLE_FOREST = createKey("maple_forest");//DONE
    public static ResourceKey<Biome> MAUVE_HILLS = createKey("mauve_hills");//DONE
    public static ResourceKey<Biome> ORCHARD = createKey("orchard");//DONE
    public static ResourceKey<Biome> SILVER_BIRCH_FOREST = createKey("silver_birch_forest");//DONE
    public static ResourceKey<Biome> TEMPERATE_GROVE = createKey("temperate_grove");//DONE
    public static ResourceKey<Biome> WILLOW_FOREST = createKey("willow_forest");//DONE
    //TAIGA
    public static ResourceKey<Biome> BLACKWOOD_TAIGA = createKey("blackwood_taiga");//DONE
    public static ResourceKey<Biome> BOREAL_TAIGA = createKey("boreal_taiga");//DONE
    public static ResourceKey<Biome> GOLDEN_BOREAL_TAIGA = createKey("golden_boreal_taiga");//DONE
    public static ResourceKey<Biome> PINE_TAIGA = createKey("pine_taiga");//DONE
    public static ResourceKey<Biome> REDWOODS = createKey("redwoods");//DONE
    public static ResourceKey<Biome> SPARSE_REDWOODS = createKey("sparse_redwoods");//DONE
    //PLAINS
    public static ResourceKey<Biome> BARLEY_FIELDS = createKey("barley_fields");//DONE
    public static ResourceKey<Biome> FLOWER_FIELDS = createKey("flower_fields");//DONE
    public static ResourceKey<Biome> GRASSLAND = createKey("grassland");//DONE
    public static ResourceKey<Biome> LUPINE_PLAINS = createKey("lupine_plains");//DONE
    public static ResourceKey<Biome> ROCKY_MEADOW = createKey("rocky_meadow");//DONE
    public static ResourceKey<Biome> POPPY_FIELDS = createKey("poppy_fields");//DONE
    public static ResourceKey<Biome> PRAIRIE = createKey("prairie");//DONE
    public static ResourceKey<Biome> PUMPKIN_FIELDS = createKey("pumpkin_fields");//DONE
    public static ResourceKey<Biome> SHRUBLAND = createKey("shrubland");//DONE
    //WET
    public static ResourceKey<Biome> BAYOU = createKey("bayou");//DONE
    public static ResourceKey<Biome> EUCALYPTUS_FOREST = createKey("eucalyptus_forest");//DONE
    public static ResourceKey<Biome> FEN = createKey("fen");
    public static ResourceKey<Biome> MARSH = createKey("marsh");//DONE
    public static ResourceKey<Biome> FUNGAL_FEN = createKey("fungal_fen");//DONE
    public static ResourceKey<Biome> OLD_GROWTH_BAYOU = createKey("old_growth_bayou");//DONE
    public static ResourceKey<Biome> OLD_GROWTH_RAINFOREST = createKey("old_growth_rainforest");
    public static ResourceKey<Biome> RAINFOREST = createKey("rainforest");
    //ARID
    public static ResourceKey<Biome> BAOBAB_SAVANNA = createKey("baobab_savanna");
    public static ResourceKey<Biome> DRY_BUSHLAND = createKey("dry_bushland");
    public static ResourceKey<Biome> JOSHUA_DESERT = createKey("joshua_desert");//DONE
    public static ResourceKey<Biome> OUTBACK = createKey("outback");//DONE
    public static ResourceKey<Biome> SAGUARO_DESERT = createKey("saguaro_desert");//DONE
    public static ResourceKey<Biome> STEPPE = createKey("steppe");//DONE
    //MOUNTAIN
    public static ResourceKey<Biome> ARID_MOUNTAINS = createKey("arid_mountains");//DONE
    public static ResourceKey<Biome> HIGHLAND_FIELDS = createKey("highland_fields");//DONE
    public static ResourceKey<Biome> MOUNTAINS = createKey("mountains");//DONE
    public static ResourceKey<Biome> PINE_SLOPES = createKey("pine_slopes");//DONE
    public static ResourceKey<Biome> TOWERING_CLIFFS = createKey("towering_cliffs");//DONE
    //COASTAL
    public static ResourceKey<Biome> CHALK_CLIFFS = createKey("chalk_cliffs");//DONE
    public static ResourceKey<Biome> GRASSY_BEACH = createKey("grassy_beach");//DONE
    public static ResourceKey<Biome> GRAVEL_BEACH = createKey("gravel_beach");//DONE
    //AQUATIC
    public static ResourceKey<Biome> ALPHA_GROVE = createKey("alpha_grove");//DONE
    public static ResourceKey<Biome> ASHEN_WOODLAND = createKey("ashen_woodland");//DONE
    public static ResourceKey<Biome> COLD_RIVER = createKey("cold_river");//DONE
    public static ResourceKey<Biome> HYACINTH_DEEPS = createKey("hyacinth_deeps");//DONE
    public static ResourceKey<Biome> MUDDY_RIVER = createKey("muddy_river");//DONE
    public static ResourceKey<Biome> ROCKY_REEF = createKey("rocky_reef");//DONE
    public static ResourceKey<Biome> TROPICS = createKey("tropics");
    //FROZEN
    public static ResourceKey<Biome> COLD_BOREAL_TAIGA = createKey("cold_boreal_taiga");//DONE
    public static ResourceKey<Biome> COLD_DECIDUOUS_FOREST = createKey("cold_deciduous_forest");//DONE
    public static ResourceKey<Biome> FROZEN_PINE_TAIGA = createKey("frozen_pine_taiga");//DONE
    public static ResourceKey<Biome> FROZEN_TUNDRA = createKey("frozen_tundra");//DONE
    public static ResourceKey<Biome> ICY_HEIGHTS = createKey("icy_heights");//DONE
    public static ResourceKey<Biome> SPIRES = createKey("spires");//DONE
    //CAVE
    public static ResourceKey<Biome> BIOSHROOM_CAVES = createKey("bioshroom_caves");//DONE
    public static ResourceKey<Biome> ANCIENT_DELTA = createKey("ancient_delta");//DONE
    public static ResourceKey<Biome> PRISMACHASM = createKey("prismachasm");//DONE
    public static ResourceKey<Biome> REDSTONE_CAVES = createKey("redstone_caves");//DONE
    public static ResourceKey<Biome> SCORCHING_CAVES = createKey("scorching_caves");//DONE
    //NETHER
    public static ResourceKey<Biome> BLACKSTONE_BASIN = createKey("blackstone_basin");
    public static ResourceKey<Biome> INFERNAL_HOLT = createKey("infernal_holt");
    public static ResourceKey<Biome> GLISTERING_MEADOW = createKey("glistering_meadow");
    public static ResourceKey<Biome> MYCOTOXIC_UNDERGROWTH = createKey("mycotoxic_undergrowth");
    public static ResourceKey<Biome> REDSTONE_HELL = createKey("redstone_hell");

    public static ResourceKey<Biome> createKey(String name) {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(RegionsUnexploredMod.MOD_ID, name));
    }
}
