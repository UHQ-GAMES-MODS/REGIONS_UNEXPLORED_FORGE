package net.regions_unexplored.data.worldgen.biome.surface;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.noise.RuNoises;
import net.regions_unexplored.data.noise.RuleWeight;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;

public class RuNetherSurfaceBuilder {

    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource BLACKSTONE = makeStateRule(Blocks.BLACKSTONE);
    private static final SurfaceRules.RuleSource SCULK_GRASS_BLOCK = makeStateRule(RuBlocks.BRIMSPROUT_NYLIUM.get());
    private static final SurfaceRules.RuleSource MYCOTOXIC_MOSS = makeStateRule(RuBlocks.MYCOTOXIC_NYLIUM.get());
    private static final SurfaceRules.RuleSource GLISTERING_NYLIUM = makeStateRule(RuBlocks.GLISTERING_NYLIUM.get());
    private static final SurfaceRules.RuleSource COBALT_NYLIUM = makeStateRule(RuBlocks.COBALT_NYLIUM.get());

    public static SurfaceRules.RuleSource makeRules()
    {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.verticalGradient("bedrock_floor", VerticalAnchor.bottom(), VerticalAnchor.aboveBottom(5)), BEDROCK),
                SurfaceRules.ifTrue(SurfaceRules.not(SurfaceRules.verticalGradient("bedrock_roof", VerticalAnchor.belowTop(5), VerticalAnchor.top())), BEDROCK),

                SurfaceRules.ifTrue(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(31), 0), SurfaceRules.sequence(
                        //MYCOTOXIC_UNDERGROWTH
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.MYCOTOXIC_UNDERGROWTH),
                                SurfaceRules.ifTrue(shieldNoise(-1.5D), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), MYCOTOXIC_MOSS))),

                        //GLISTERING_MEADOW
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.GLISTERING_MEADOW),
                                SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), SurfaceRules.sequence(SurfaceRules.ifTrue(shieldNoise(-1.0D), GLISTERING_NYLIUM), SurfaceRules.ifTrue(SurfaceRules.noiseCondition(RuNoises.WEIGHTED.getKey(), RuleWeight.getPercent(50)), GLISTERING_NYLIUM)))),

                        //BLACKSTONE_BASIN
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.BLACKSTONE_BASIN),
                                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), SurfaceRules.ifTrue(shieldNoise(-0.95D), COBALT_NYLIUM)), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 10, CaveSurface.FLOOR), BLACKSTONE), SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 5, CaveSurface.CEILING), BLACKSTONE))),

                        //CORRUPTED_HOLT
                        SurfaceRules.ifTrue(SurfaceRules.isBiome(RuBiomes.INFERNAL_HOLT),
                                SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR), SCULK_GRASS_BLOCK)))

                ))

        );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }

    private static SurfaceRules.ConditionSource shieldNoise(double noise) {
        return SurfaceRules.noiseCondition(RuNoises.SHIELD.getKey(), noise / 8.25D, Double.MAX_VALUE);
    }
}
