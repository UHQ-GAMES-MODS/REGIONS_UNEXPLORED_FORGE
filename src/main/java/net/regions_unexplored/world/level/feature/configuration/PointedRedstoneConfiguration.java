package net.regions_unexplored.world.level.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class PointedRedstoneConfiguration implements FeatureConfiguration {
    public static final Codec<PointedRedstoneConfiguration> CODEC = RecordCodecBuilder.create((p_191286_) -> {
        return p_191286_.group(Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_taller_redstone").orElse(0.2F).forGetter((tallRedstoneChance) -> {
            return tallRedstoneChance.chanceOfTallerRedstone;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_directional_spread").orElse(0.7F).forGetter((spreadChance) -> {
            return spreadChance.chanceOfDirectionalSpread;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_spread_radius2").orElse(0.5F).forGetter((spreadChanceRadius1) -> {
            return spreadChanceRadius1.chanceOfSpreadRadius2;
        }), Codec.floatRange(0.0F, 1.0F).fieldOf("chance_of_spread_radius3").orElse(0.5F).forGetter((spreadChanceRadius2) -> {
            return spreadChanceRadius2.chanceOfSpreadRadius3;
        })).apply(p_191286_, PointedRedstoneConfiguration::new);
    });
    public final float chanceOfTallerRedstone;
    public final float chanceOfDirectionalSpread;
    public final float chanceOfSpreadRadius2;
    public final float chanceOfSpreadRadius3;

    public PointedRedstoneConfiguration(float tallRedstoneChance, float spreadChance, float spreadChanceRadius1, float spreadChanceRadius2) {
        this.chanceOfTallerRedstone = tallRedstoneChance;
        this.chanceOfDirectionalSpread = spreadChance;
        this.chanceOfSpreadRadius2 = spreadChanceRadius1;
        this.chanceOfSpreadRadius3 = spreadChanceRadius2;
    }
}
