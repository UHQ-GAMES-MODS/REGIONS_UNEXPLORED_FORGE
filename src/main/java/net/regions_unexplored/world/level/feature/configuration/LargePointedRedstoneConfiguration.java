package net.regions_unexplored.world.level.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class LargePointedRedstoneConfiguration implements FeatureConfiguration {
    public static final Codec<LargePointedRedstoneConfiguration> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(Codec.intRange(1, 512).fieldOf("floor_to_ceiling_search_range").orElse(30).forGetter((searchRange) -> {
            return searchRange.floorToCeilingSearchRange;
        }), IntProvider.codec(1, 60).fieldOf("column_radius").forGetter((radius) -> {
            return radius.columnRadius;
        }), FloatProvider.codec(0.0F, 20.0F).fieldOf("height_scale").forGetter((height) -> {
            return height.heightScale;
        }), Codec.floatRange(0.1F, 1.0F).fieldOf("max_column_radius_to_cave_height_ratio").forGetter((maxColumnRadius) -> {
            return maxColumnRadius.maxColumnRadiusToCaveHeightRatio;
        }), FloatProvider.codec(0.1F, 10.0F).fieldOf("stalactite_bluntness").forGetter((topBluntness) -> {
            return topBluntness.stalactiteBluntness;
        }), FloatProvider.codec(0.1F, 10.0F).fieldOf("stalagmite_bluntness").forGetter((bottomBluntness) -> {
            return bottomBluntness.stalagmiteBluntness;
        }), FloatProvider.codec(0.0F, 2.0F).fieldOf("wind_speed").forGetter((windSpeed) -> {
            return windSpeed.windSpeed;
        }), Codec.intRange(0, 100).fieldOf("min_radius_for_wind").forGetter((minWindRadius) -> {
            return minWindRadius.minRadiusForWind;
        }), Codec.floatRange(0.0F, 5.0F).fieldOf("min_bluntness_for_wind").forGetter((minWindBluntness) -> {
            return minWindBluntness.minBluntnessForWind;
        })).apply(instance, LargePointedRedstoneConfiguration::new);
    });
    public final int floorToCeilingSearchRange;
    public final IntProvider columnRadius;
    public final FloatProvider heightScale;
    public final float maxColumnRadiusToCaveHeightRatio;
    public final FloatProvider stalactiteBluntness;
    public final FloatProvider stalagmiteBluntness;
    public final FloatProvider windSpeed;
    public final int minRadiusForWind;
    public final float minBluntnessForWind;

    public LargePointedRedstoneConfiguration(int searchRange, IntProvider radius, FloatProvider height, float maxColumnRadius, FloatProvider stalactiteBluntness, FloatProvider stalagmiteBluntness, FloatProvider windSpeed, int minWindRadius, float minWindBluntness) {
        this.floorToCeilingSearchRange = searchRange;
        this.columnRadius = radius;
        this.heightScale = height;
        this.maxColumnRadiusToCaveHeightRatio = maxColumnRadius;
        this.stalactiteBluntness = stalactiteBluntness;
        this.stalagmiteBluntness = stalagmiteBluntness;
        this.windSpeed = windSpeed;
        this.minRadiusForWind = minWindRadius;
        this.minBluntnessForWind = minWindBluntness;
    }
}

