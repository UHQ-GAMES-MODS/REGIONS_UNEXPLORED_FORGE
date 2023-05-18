package net.regions_unexplored.world.level.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class PointedRedstoneClusterConfiguration implements FeatureConfiguration {
    public static final Codec<PointedRedstoneClusterConfiguration> CODEC = RecordCodecBuilder.create((p_160784_) -> {
        return p_160784_.group(Codec.intRange(1, 512).fieldOf("floor_to_ceiling_search_range").forGetter((searchRange) -> {
            return searchRange.floorToCeilingSearchRange;
        }), IntProvider.codec(1, 128).fieldOf("height").forGetter((height) -> {
            return height.height;
        }), IntProvider.codec(1, 128).fieldOf("radius").forGetter((radius) -> {
            return radius.radius;
        }), Codec.intRange(0, 64).fieldOf("max_stalagmite_stalactite_height_diff").forGetter((heightDiff) -> {
            return heightDiff.maxStalagmiteStalactiteHeightDiff;
        }), Codec.intRange(1, 64).fieldOf("height_deviation").forGetter((heightDeviation) -> {
            return heightDeviation.heightDeviation;
        }), IntProvider.codec(0, 128).fieldOf("redstone_block_layer_thickness").forGetter((blockLayerThickness) -> {
            return blockLayerThickness.redstoneBlockLayerThickness;
        }), FloatProvider.codec(0.0F, 2.0F).fieldOf("density").forGetter((density) -> {
            return density.density;
        }), FloatProvider.codec(0.0F, 2.0F).fieldOf("wetness").forGetter((wetness) -> {
            return wetness.wetness;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_redstone_column_at_max_distance_from_center").forGetter((maxColumnDistanceChance) -> {
            return maxColumnDistanceChance.chanceOfRedstoneColumnAtMaxDistanceFromCenter;
        }), Codec.intRange(1, 64).fieldOf("max_distance_from_edge_affecting_chance_of_redstone_column").forGetter((maxColumnDistanceFromEdge) -> {
            return maxColumnDistanceFromEdge.maxDistanceFromEdgeAffectingChanceOfRedstoneColumn;
        }), Codec.intRange(1, 64).fieldOf("max_distance_from_center_affecting_height_bias").forGetter((maxDistanceAffectingHeight) -> {
            return maxDistanceAffectingHeight.maxDistanceFromCenterAffectingHeightBias;
        })).apply(p_160784_, PointedRedstoneClusterConfiguration::new);
    });
    public final int floorToCeilingSearchRange;
    public final IntProvider height;
    public final IntProvider radius;
    public final int maxStalagmiteStalactiteHeightDiff;
    public final int heightDeviation;
    public final IntProvider redstoneBlockLayerThickness;
    public final FloatProvider density;
    public final FloatProvider wetness;
    public final float chanceOfRedstoneColumnAtMaxDistanceFromCenter;
    public final int maxDistanceFromEdgeAffectingChanceOfRedstoneColumn;
    public final int maxDistanceFromCenterAffectingHeightBias;

    public PointedRedstoneClusterConfiguration(int searchRange, IntProvider height, IntProvider radius, int heightDiff, int heightDeviation, IntProvider blockLayerThickness, FloatProvider density, FloatProvider wetness, float maxColumnDistanceChance, int maxColumnDistanceFromEdge, int maxDistanceAffectingHeight) {
        this.floorToCeilingSearchRange = searchRange;
        this.height = height;
        this.radius = radius;
        this.maxStalagmiteStalactiteHeightDiff = heightDiff;
        this.heightDeviation = heightDeviation;
        this.redstoneBlockLayerThickness = blockLayerThickness;
        this.density = density;
        this.wetness = wetness;
        this.chanceOfRedstoneColumnAtMaxDistanceFromCenter = maxColumnDistanceChance;
        this.maxDistanceFromEdgeAffectingChanceOfRedstoneColumn = maxColumnDistanceFromEdge;
        this.maxDistanceFromCenterAffectingHeightBias = maxDistanceAffectingHeight;
    }
}
