package net.regions_unexplored.data.worldgen.biome.surface;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.data.noise.RuNoises;
import net.regions_unexplored.data.noise.RuleWeight;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;

public class RuOverworldSurfaceBuilders {
    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.CAVE_AIR);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);

    private static final SurfaceRules.RuleSource PEAT_GRASS_BLOCK = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.PEAT_GRASS_BLOCK.get() : Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource PEAT_COARSE_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.PEAT_COARSE_DIRT.get() : Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource PEAT_PODZOL = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.PEAT_PODZOL.get() : Blocks.PODZOL);
    private static final SurfaceRules.RuleSource PEAT_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.PEAT_DIRT.get() : Blocks.DIRT);
    private static final SurfaceRules.RuleSource PEAT_MUD = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.PEAT_MUD.get() : Blocks.MUD);

    private static final SurfaceRules.RuleSource SILT_GRASS_BLOCK = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.SILT_GRASS_BLOCK.get() : Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource SILT_COARSE_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.SILT_COARSE_DIRT.get() : Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource SILT_PODZOL = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.SILT_PODZOL.get() : Blocks.PODZOL);
    private static final SurfaceRules.RuleSource SILT_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.SILT_DIRT.get() : Blocks.DIRT);
    private static final SurfaceRules.RuleSource SILT_MUD = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.SILT_MUD.get() : Blocks.MUD);

    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);

    private static final SurfaceRules.RuleSource ALPHA_GRASS = makeStateRule(RuBlocks.ALPHA_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource ALPHA_DIRT = makeStateRule(Blocks.DIRT);

    private static final SurfaceRules.RuleSource ARGILLITE_GRASS_BLOCK = makeStateRule(RuBlocks.ARGILLITE_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource ARGILLITE = makeStateRule(RuBlocks.ARGILLITE.get());

    private static final SurfaceRules.RuleSource CHALK_GRASS_BLOCK = makeStateRule(RuBlocks.CHALK_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource VIRIDESCENT_NYLIUM = makeStateRule(RuBlocks.VIRIDESCENT_NYLIUM.get());
    private static final SurfaceRules.RuleSource DEEPSLATE_VIRIDESCENT_NYLIUM = makeStateRule(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get());
    private static final SurfaceRules.RuleSource PRISMOSS = makeStateRule(RuBlocks.PRISMOSS.get());
    private static final SurfaceRules.RuleSource DEEPSLATE_PRISMOSS = makeStateRule(RuBlocks.DEEPSLATE_PRISMOSS.get());
    private static final SurfaceRules.RuleSource RAW_REDSTONE = makeStateRule(RuBlocks.RAW_REDSTONE_BLOCK.get());

    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource CHALK = makeStateRule(RuBlocks.CHALK.get());
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final SurfaceRules.RuleSource COBBLESTONE = makeStateRule(Blocks.COBBLESTONE);
    private static final SurfaceRules.RuleSource MOSSY_STONE = makeStateRule(RuBlocks.MOSSY_STONE.get());

    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource RED_SAND = makeStateRule(Blocks.RED_SAND);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);

    private static final SurfaceRules.RuleSource ASH = makeStateRule(RuBlocks.ASH.get());
    private static final SurfaceRules.RuleSource ASHEN_DIRT = makeStateRule(RuBlocks.ASHEN_DIRT.get());
    private static final SurfaceRules.RuleSource ASH_VENT = makeStateRule(RuBlocks.ASH_VENT.get());

    private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final SurfaceRules.RuleSource POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final SurfaceRules.RuleSource PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);



    public static SurfaceRules.RuleSource makeRules()
    {
        SurfaceRules.ConditionSource y62 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(62), 0);
        SurfaceRules.ConditionSource y63 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(63), 0);
            return SurfaceRules.sequence(
                    SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),SurfaceRules.sequence(
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ICY_HEIGHTS, RuBiomes.SPIRES, RuBiomes.FROZEN_PINE_TAIGA), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.POWDER_SNOW, 0.45D, 0.58D), POWDER_SNOW)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.FROZEN_PINE_TAIGA),SNOW_BLOCK),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.REDWOODS), PODZOL),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.PINE_SLOPES), COARSE_DIRT),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.SAGUARO_DESERT, RuBiomes.GRASSY_BEACH), SAND),

                            //PUMPKIN_FIELDS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.PUMPKIN_FIELDS),
                                    SurfaceRules.ifTrue(surfaceNoiseAbove(-1.75D), SILT_PODZOL)),

                            //PODZOL/COARSE_DIRT SURFACE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.DECIDUOUS_FOREST, RuBiomes.RAINFOREST, RuBiomes.OLD_GROWTH_RAINFOREST),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), COARSE_DIRT), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), PODZOL))),

                            //PODZOL/COARSE_DIRT SURFACE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.PINE_TAIGA),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), PEAT_COARSE_DIRT), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), PEAT_PODZOL), PEAT_GRASS_BLOCK)),

                            //OUTBACK
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.OUTBACK),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED, RuleWeight.getPercent(20)), TERRACOTTA), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED, RuleWeight.getPercent(60)), RED_SAND))),

                            //SMOULDERING_WOODLAND
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ASHEN_WOODLAND),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -0.25D), ASHEN_DIRT), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED, RuleWeight.getPercent(4)), ASH_VENT), ASH)),

                            //FUNGAL_FEN
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.FUNGAL_FEN),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), MYCELIUM), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED, 0.1D), MYCELIUM)))),

                            //FEN
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.FEN),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(y62, SurfaceRules.ifTrue(SurfaceRules.not(y63), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED, 0.0D), WATER))), SurfaceRules.ifTrue(surfaceNoiseAbove(1.1D), COARSE_DIRT))),

                            //TROPICS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.TROPICS),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(64), 0)), SAND),SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(65), 0)), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SAND)))),

                            //BAYOU
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BAYOU),
                                    SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(64), 0)), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), PEAT_MUD))),

                            //BAYOU
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.OLD_GROWTH_BAYOU),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), MUD), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), MUD))),

                            //POPPY_FIELDS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.POPPY_FIELDS),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED, RuleWeight.getPercent(50)), SILT_COARSE_DIRT)),

                            //FROZEN_TUNDRA
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.FROZEN_TUNDRA),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SNOW_BLOCK)),

                            //DRY_BUSHLAND
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.DRY_BUSHLAND),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, RuleWeight.getPercent(40)), SILT_COARSE_DIRT)),

                            //BAOBAB_SAVANNA
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BAOBAB_SAVANNA),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), TERRACOTTA), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), COARSE_DIRT), GRASS_BLOCK)),

                            //TOWERING_CLIFFS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.TOWERING_CLIFFS),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), COBBLESTONE),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), GRAVEL),STONE)), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), GRASS_BLOCK),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -0.25D), COARSE_DIRT),COBBLESTONE)))),

                            //MAPLE_FOREST
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MAPLE_FOREST),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(shieldNoise(1.65D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), STONE),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), MOSSY_STONE),STONE)), SurfaceRules.ifTrue(shieldNoise(0.0D), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.25D), GRASS_BLOCK),SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, -0.25D), COARSE_DIRT),MOSSY_STONE)))),

                            //LUSH_HILLS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.LUSH_HILLS),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), STONE), SurfaceRules.ifTrue(surfaceNoiseAbove(-0.5D), COARSE_DIRT), GRASS_BLOCK)),

                            //JOSHUA_DESERT
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.JOSHUA_DESERT),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SAND)),

                            //ALPHA_GROVE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ALPHA_GROVE),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(66), 0), ALPHA_GRASS), SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(65), 0), AIR))),

                            //SNOWCAPPED_MOUNTAINS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MOUNTAINS),
                                    SurfaceRules.sequence(
                                            SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(138), 0)),COARSE_DIRT),
                                            SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(142), 0)),
                                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED, 0.05D),COARSE_DIRT)))),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BLACKWOOD_TAIGA, RuBiomes.BOREAL_TAIGA, RuBiomes.COLD_BOREAL_TAIGA, RuBiomes.GOLDEN_BOREAL_TAIGA), PEAT_GRASS_BLOCK),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.PUMPKIN_FIELDS, RuBiomes.POPPY_FIELDS, RuBiomes.AUTUMNAL_MAPLE_FOREST, RuBiomes.SILVER_BIRCH_FOREST, RuBiomes.TROPICS, RuBiomes.DRY_BUSHLAND, RuBiomes.JOSHUA_DESERT, RuBiomes.BARLEY_FIELDS, RuBiomes.PRAIRIE, RuBiomes.ORCHARD, RuBiomes.STEPPE), SILT_GRASS_BLOCK)
                    )))),

                    SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),SurfaceRules.sequence(
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ICY_HEIGHTS, RuBiomes.SPIRES), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),SNOW_BLOCK)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR),PACKED_ICE))),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.SAGUARO_DESERT, RuBiomes.GRASSY_BEACH), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SANDSTONE)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.GRAVEL_BEACH), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),GRAVEL)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.CHALK_CLIFFS), SurfaceRules.sequence(SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),CHALK_GRASS_BLOCK), CHALK)),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR),CHALK)))),

                            //BAOBAB_SAVANNA BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BAOBAB_SAVANNA),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(surfaceNoiseAbove(1.75D)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),DIRT)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR),TERRACOTTA))),

                            //LUSH_HILLS/CLIFFS BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.LUSH_HILLS, RuBiomes.TOWERING_CLIFFS),
                                    SurfaceRules.ifTrue(surfaceNoiseAbove(1.75D), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),STONE))),

                            //ALPHA_GROVE BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ALPHA_GROVE),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(66), 0), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),ALPHA_DIRT)),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),GRAVEL))),

                            //JOSHUA_DESERT BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.JOSHUA_DESERT),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SANDSTONE))),

                            //BAYOU
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.OLD_GROWTH_BAYOU),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(-0.95D), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), MUD)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(64), 0)), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), MUD))))),

                            //TROPICS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.TROPICS),
                                    SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(65), 0)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SAND)))),

                            //SNOWCAPPED_MOUNTAINS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MOUNTAINS),
                                    SurfaceRules.sequence(
                                            SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(138), 0)),
                                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),DIRT)),
                                            SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(142), 0)),
                                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED, 0.05D),
                                                            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),DIRT))),
                                            SurfaceRules.ifTrue(SurfaceRules.yStartCheck(VerticalAnchor.absolute(186), 0),
                                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),SNOW_BLOCK)))),

                            //ARID_MOUNTAINS
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ARID_MOUNTAINS), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 30, CaveSurface.FLOOR), TERRACOTTA)),

                            //MAPLE_FOREST_BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MAPLE_FOREST),
                                    SurfaceRules.ifTrue(shieldNoise(1.65D), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),STONE))),

                            //ASHEN_BASE
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ASHEN_WOODLAND),
                                    SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),ASHEN_DIRT)),

                            //DEFAULT
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MOUNTAINS), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),STONE)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.PINE_TAIGA, RuBiomes.BLACKWOOD_TAIGA, RuBiomes.BOREAL_TAIGA, RuBiomes.COLD_BOREAL_TAIGA, RuBiomes.GOLDEN_BOREAL_TAIGA), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),PEAT_DIRT)),
                            SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.PUMPKIN_FIELDS, RuBiomes.POPPY_FIELDS, RuBiomes.AUTUMNAL_MAPLE_FOREST, RuBiomes.SILVER_BIRCH_FOREST, RuBiomes.TROPICS, RuBiomes.DRY_BUSHLAND, RuBiomes.JOSHUA_DESERT, RuBiomes.BARLEY_FIELDS, RuBiomes.PRAIRIE, RuBiomes.ORCHARD, RuBiomes.STEPPE), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SILT_DIRT))
                    )),
                    //REDSTONE_CAVES
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.REDSTONE_CAVES),
                            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),
                                    SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, 0.0D), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED, RuleWeight.getPercent(40)),RAW_REDSTONE)))),

                    //LUSH_DELTA
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.ANCIENT_DELTA), SurfaceRules.sequence(
                            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
                                SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.SHIELD, -0.95D),ARGILLITE_GRASS_BLOCK)
                            ),
                            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),ARGILLITE),
                            SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.CEILING),ARGILLITE)
                            )),

                    //BIOSHROOM_CAVES
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BIOSHROOM_CAVES),
                            SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bioshroom_caves_nylium", VerticalAnchor.absolute(0), VerticalAnchor.absolute(5)), DEEPSLATE_VIRIDESCENT_NYLIUM), VIRIDESCENT_NYLIUM)))),

                    //PRISMACHASM
                    SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.PRISMACHASM),
                            SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0),SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.verticalGradient("prismachasm_prismoss", VerticalAnchor.absolute(0), VerticalAnchor.absolute(5)), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(0.5D), DEEPSLATE_PRISMOSS), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, RuleWeight.getPercent(30)), DEEPSLATE_PRISMOSS))), SurfaceRules.sequence(SurfaceRules.ifTrue(surfaceNoiseAbove(0.5D), PRISMOSS), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(Noises.SWAMP, RuleWeight.getPercent(30)), PRISMOSS)))))),

                    //BEDROCK
                    SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK)
            );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double noise) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, noise / 8.25D, Double.MAX_VALUE);
    }

    private static SurfaceRules.ConditionSource shieldNoise(double noise) {
        return SurfaceRules.noiseCondition(RuNoises.SHIELD, noise / 8.25D, Double.MAX_VALUE);
    }
}
