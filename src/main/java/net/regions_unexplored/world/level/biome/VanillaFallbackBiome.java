package net.regions_unexplored.world.level.biome;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public class VanillaFallbackBiome {
    public static final ResourceKey<Biome>[][] VANILLA_OCEANS = new ResourceKey[][]{
            {Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN},
            {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.WARM_OCEAN}};

    public static final ResourceKey<Biome>[][] VANILLA_MIDDLE_BIOMES = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA},
            {Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.FLOWER_FOREST, Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
            {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.FOREST, Biomes.JUNGLE, Biomes.JUNGLE},
            {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}};

    public static final ResourceKey<Biome>[][] VANILLA_MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            {Biomes.ICE_SPIKES, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA, Biomes.TAIGA},
            {Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_PINE_TAIGA},
            {Biomes.SUNFLOWER_PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.OLD_GROWTH_BIRCH_FOREST, Biomes.DARK_FOREST},
            {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE},
            {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}};

    public static final ResourceKey<Biome>[][] VANILLA_PLATEAU_BIOMES = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST},
            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
            {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}};

    public static final ResourceKey<Biome>[][] VANILLA_PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {Biomes.ICE_SPIKES, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.OLD_GROWTH_PINE_TAIGA},
            {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE},
            {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}};

    public static final ResourceKey<Biome>[][] VANILLA_SHATTERED_BIOMES = new ResourceKey[][]{
            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.FOREST, Biomes.JUNGLE, Biomes.JUNGLE},
            {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}};

    public static final ResourceKey<Biome>[][] VANILLA_RIVER_BIOMES = new ResourceKey[][]{
            {Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER}};

    public static final ResourceKey<Biome>[][] VANILLA_RIVER_BIOMES_VARIANT = new ResourceKey[][]{
            {Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER, Biomes.FROZEN_RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER},
            {Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER, Biomes.RIVER}};

    public static final ResourceKey<Biome>[][] VANILLA_SWAMP_BIOMES = new ResourceKey[][]{
            {Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA},
            {Biomes.SWAMP, Biomes.SWAMP, Biomes.SWAMP, Biomes.SWAMP, Biomes.SWAMP},
            {Biomes.SWAMP, Biomes.SWAMP, Biomes.SWAMP, Biomes.SWAMP, Biomes.SWAMP},
            {Biomes.MANGROVE_SWAMP, Biomes.MANGROVE_SWAMP, Biomes.SWAMP, Biomes.MANGROVE_SWAMP, Biomes.MANGROVE_SWAMP},
            {Biomes.MANGROVE_SWAMP, Biomes.MANGROVE_SWAMP, Biomes.MANGROVE_SWAMP, Biomes.MANGROVE_SWAMP, Biomes.MANGROVE_SWAMP}};
}
