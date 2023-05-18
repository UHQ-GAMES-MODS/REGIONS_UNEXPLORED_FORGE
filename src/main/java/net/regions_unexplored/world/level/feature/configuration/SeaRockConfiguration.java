package net.regions_unexplored.world.level.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public class SeaRockConfiguration implements FeatureConfiguration {
    public static final Codec<SeaRockConfiguration> CODEC = RecordCodecBuilder.create((p_225468_) -> {
        return p_225468_.group(BlockState.CODEC.fieldOf("state").forGetter((state) -> {
            return state.state;
        }),
        BlockState.CODEC.fieldOf("alt_state").forGetter((altState) -> {
            return altState.altState;
        })
        ).apply(p_225468_, SeaRockConfiguration::new);
    });

    public final BlockState state;
    public final BlockState altState;

    public SeaRockConfiguration(BlockState state, BlockState altState) {
        this.state = state;
        this.altState = altState;
    }
}

