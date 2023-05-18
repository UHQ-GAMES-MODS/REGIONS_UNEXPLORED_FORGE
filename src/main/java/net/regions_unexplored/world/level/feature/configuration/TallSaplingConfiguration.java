package net.regions_unexplored.world.level.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class TallSaplingConfiguration implements FeatureConfiguration {
    public static final Codec<TallSaplingConfiguration> CODEC = RecordCodecBuilder.create((codec) -> {
        return codec.group(BlockStateProvider.CODEC.fieldOf("sapling_provider").forGetter((DoubleTallSaplingBlock) -> {
            return DoubleTallSaplingBlock.saplingProvider;
        })).apply(codec, TallSaplingConfiguration::new);
    });

    public final BlockStateProvider saplingProvider;

    public TallSaplingConfiguration(BlockStateProvider tallSapling) {
        this.saplingProvider = tallSapling;
    }
}

