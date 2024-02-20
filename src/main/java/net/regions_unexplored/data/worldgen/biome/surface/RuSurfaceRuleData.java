package net.regions_unexplored.data.worldgen.biome.surface;

import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;

public class RuSurfaceRuleData {
    //FILL_BLOCKS
    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.CAVE_AIR);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);
    private static final SurfaceRules.RuleSource LAVA = makeStateRule(Blocks.LAVA);

    //PEAT_BLOCKS
    private static final SurfaceRules.RuleSource PEAT_GRASS_BLOCK = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.PEAT_GRASS_BLOCK.get() : Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource PEAT_COARSE_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.PEAT_COARSE_DIRT.get() : Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource PEAT_PODZOL = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.PEAT_PODZOL.get() : Blocks.PODZOL);
    private static final SurfaceRules.RuleSource PEAT_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.PEAT_DIRT.get() : Blocks.DIRT);
    private static final SurfaceRules.RuleSource PEAT_MUD = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.PEAT_MUD.get() : Blocks.MUD);

    //SILT_BLOCKS
    private static final SurfaceRules.RuleSource SILT_GRASS_BLOCK = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.SILT_GRASS_BLOCK.get() : Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource SILT_COARSE_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.SILT_COARSE_DIRT.get() : Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource SILT_PODZOL = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.SILT_PODZOL.get() : Blocks.PODZOL);
    private static final SurfaceRules.RuleSource SILT_DIRT = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.SILT_DIRT.get() : Blocks.DIRT);
    private static final SurfaceRules.RuleSource SILT_MUD = makeStateRule(RuCommonConfig.TOGGLE_CUSTOM_DIRTS.get() ? RuBlocks.SILT_MUD.get() : Blocks.MUD);

    //DIRT_BLOCKS
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource MOSS_BLOCK = makeStateRule(Blocks.MOSS_BLOCK);
    private static final SurfaceRules.RuleSource MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource MUD = makeStateRule(Blocks.MUD);

    //ASHEN_BLOCKS
    private static final SurfaceRules.RuleSource ASHEN_DIRT = makeStateRule(RuBlocks.ASHEN_DIRT.get());
    private static final SurfaceRules.RuleSource ASH_VENT = makeStateRule(RuBlocks.ASH_VENT.get());

    //ALPHA_BLOCKS
    private static final SurfaceRules.RuleSource ALPHA_GRASS = makeStateRule(RuBlocks.ALPHA_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource ALPHA_DIRT = makeStateRule(Blocks.DIRT);

    //STONE_BLOCKS
    private static final SurfaceRules.RuleSource ARGILLITE_GRASS_BLOCK = makeStateRule(RuBlocks.ARGILLITE_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource CHALK_GRASS_BLOCK = makeStateRule(RuBlocks.CHALK_GRASS_BLOCK.get());
    private static final SurfaceRules.RuleSource PRISMOSS = makeStateRule(RuBlocks.PRISMOSS.get());
    private static final SurfaceRules.RuleSource VIRIDESCENT_NYLIUM = makeStateRule(RuBlocks.VIRIDESCENT_NYLIUM.get());
    private static final SurfaceRules.RuleSource DEEPSLATE_PRISMOSS = makeStateRule(RuBlocks.DEEPSLATE_PRISMOSS.get());
    private static final SurfaceRules.RuleSource DEEPSLATE_VIRIDESCENT_NYLIUM = makeStateRule(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get());
    private static final SurfaceRules.RuleSource ARGILLITE = makeStateRule(RuBlocks.ARGILLITE.get());
    private static final SurfaceRules.RuleSource CHALK = makeStateRule(RuBlocks.CHALK.get());
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final SurfaceRules.RuleSource NETHERRACK = makeStateRule(Blocks.NETHERRACK);
    private static final SurfaceRules.RuleSource BLACKSTONE = makeStateRule(Blocks.BLACKSTONE);
    private static final SurfaceRules.RuleSource END_STONE = makeStateRule(Blocks.END_STONE);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);

    //OTHER_STONE_BLOCKS
    private static final SurfaceRules.RuleSource RAW_REDSTONE = makeStateRule(RuBlocks.RAW_REDSTONE_BLOCK.get());
    private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final SurfaceRules.RuleSource COBBLESTONE = makeStateRule(Blocks.COBBLESTONE);
    private static final SurfaceRules.RuleSource MOSSY_STONE = makeStateRule(RuBlocks.MOSSY_STONE.get());
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);

    //GRAVITY_BLOCKS
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource RED_SAND = makeStateRule(Blocks.RED_SAND);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource ASH = makeStateRule(RuBlocks.ASH.get());

    //COLD_BLOCKS
    private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final SurfaceRules.RuleSource POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final SurfaceRules.RuleSource PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);

    //NETHER_BLOCKS
    private static final SurfaceRules.RuleSource BRIMSPROUT_NYLIUM = makeStateRule(RuBlocks.BRIMSPROUT_NYLIUM.get());
    private static final SurfaceRules.RuleSource MYCOTOXIC_NYLIUM = makeStateRule(RuBlocks.MYCOTOXIC_NYLIUM.get());
    private static final SurfaceRules.RuleSource GLISTERING_NYLIUM = makeStateRule(RuBlocks.GLISTERING_NYLIUM.get());
    private static final SurfaceRules.RuleSource GLISTERING_WART = makeStateRule(RuBlocks.GLISTERING_WART.get());
    private static final SurfaceRules.RuleSource COBALT_NYLIUM = makeStateRule(RuBlocks.COBALT_NYLIUM.get());
    private static final SurfaceRules.RuleSource SOUL_SAND = makeStateRule(Blocks.SOUL_SAND);
    private static final SurfaceRules.RuleSource SOUL_SOIL = makeStateRule(Blocks.SOUL_SOIL);
    private static final SurfaceRules.RuleSource BASALT = makeStateRule(Blocks.BASALT);
    private static final SurfaceRules.RuleSource WARPED_WART_BLOCK = makeStateRule(Blocks.WARPED_WART_BLOCK);
    private static final SurfaceRules.RuleSource WARPED_NYLIUM = makeStateRule(Blocks.WARPED_NYLIUM);
    private static final SurfaceRules.RuleSource NETHER_WART_BLOCK = makeStateRule(Blocks.NETHER_WART_BLOCK);
    private static final SurfaceRules.RuleSource CRIMSON_NYLIUM = makeStateRule(Blocks.CRIMSON_NYLIUM);

    //stateRule Method
    private static SurfaceRules.RuleSource makeStateRule(Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    public static SurfaceRules.RuleSource overworld() {
        return overworldLike(true, false, true);
    }

    public static SurfaceRules.RuleSource overworldLike(boolean p_198381_, boolean p_198382_, boolean p_198383_) {return STONE;}

    public static SurfaceRules.RuleSource nether() {
        SurfaceRules.ConditionSource above31 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(31), 0);
        SurfaceRules.ConditionSource above32 = SurfaceRules.yBlockCheck(VerticalAnchor.absolute(32), 0);
        SurfaceRules.ConditionSource start30 = SurfaceRules.yStartCheck(VerticalAnchor.absolute(30), 0);
        SurfaceRules.ConditionSource end35 = SurfaceRules.not(SurfaceRules.yStartCheck(VerticalAnchor.absolute(35), 0));
        SurfaceRules.ConditionSource belowTop5 = SurfaceRules.yBlockCheck(VerticalAnchor.belowTop(5), 0);
        SurfaceRules.ConditionSource hole = SurfaceRules.hole();
        SurfaceRules.ConditionSource soulSandLayerNoise = SurfaceRules.noiseCondition(Noises.SOUL_SAND_LAYER, -0.012D);
        SurfaceRules.ConditionSource gravelLayerNoise = SurfaceRules.noiseCondition(Noises.GRAVEL_LAYER, -0.012D);
        SurfaceRules.ConditionSource patchNoise = SurfaceRules.noiseCondition(Noises.PATCH, -0.012D);
        SurfaceRules.ConditionSource netherrackNoise = SurfaceRules.noiseCondition(Noises.NETHERRACK, 0.54D);
        SurfaceRules.ConditionSource wartNoise = SurfaceRules.noiseCondition(Noises.NETHER_WART, 1.17D);
        SurfaceRules.ConditionSource stateSelectorNoise = SurfaceRules.noiseCondition(Noises.NETHER_STATE_SELECTOR, 0.0D);
        SurfaceRules.RuleSource gravelPatch =
                SurfaceRules.ifTrue(patchNoise,
                    SurfaceRules.ifTrue(start30,
                        SurfaceRules.ifTrue(end35, GRAVEL)));

        return SurfaceRules.sequence(
                //Nether Roof/Floor
                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK),
                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK),
                SurfaceRules.ifTrue(belowTop5, NETHERRACK),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.INFERNAL_HOLT), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, SurfaceRules.ifTrue(stateSelectorNoise, SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.UNDER_FLOOR), BLACKSTONE))), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.ifTrue(netherrackNoise, BLACKSTONE)))),

                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                        SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(above32), SurfaceRules.ifTrue(hole, LAVA)),

                                SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BLACKSTONE_BASIN), SurfaceRules.sequence(SurfaceRules.ifTrue(netherrackNoise, BLACKSTONE), SurfaceRules.ifTrue(above31, COBALT_NYLIUM))),

                                SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.GLISTERING_MEADOW), SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.noiseCondition(Noises.NETHERRACK, 0.45D)), SurfaceRules.ifTrue(above31, SurfaceRules.sequence(SurfaceRules.ifTrue(wartNoise, GLISTERING_WART), GLISTERING_NYLIUM)))),

                                SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MYCOTOXIC_UNDERGROWTH), SurfaceRules.ifTrue(SurfaceRules.not(netherrackNoise), SurfaceRules.ifTrue(above31, SurfaceRules.sequence(SurfaceRules.ifTrue(wartNoise, NETHERRACK), MYCOTOXIC_NYLIUM)))),

                                SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.INFERNAL_HOLT), SurfaceRules.sequence(SurfaceRules.ifTrue(netherrackNoise, BLACKSTONE), SurfaceRules.ifTrue(above31, BRIMSPROUT_NYLIUM))))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BLACKSTONE_BASIN), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, SurfaceRules.ifTrue(stateSelectorNoise, BLACKSTONE)), SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, BLACKSTONE))),

                SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.REDSTONE_ABYSS), SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SurfaceRules.ifTrue(soulSandLayerNoise, SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.not(hole), SurfaceRules.ifTrue(start30, SurfaceRules.ifTrue(end35, SOUL_SAND))), NETHERRACK))), SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SurfaceRules.ifTrue(above31, SurfaceRules.ifTrue(end35, SurfaceRules.ifTrue(gravelLayerNoise, SurfaceRules.sequence(SurfaceRules.ifTrue(above32, GRAVEL), SurfaceRules.ifTrue(SurfaceRules.not(hole), GRAVEL)))))))), NETHERRACK);
    }

    public static SurfaceRules.RuleSource end() {return END_STONE;}

}