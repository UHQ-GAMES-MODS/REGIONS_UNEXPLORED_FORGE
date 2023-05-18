package net.regions_unexplored.world.level.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class GiantBioshroomConfiguration implements FeatureConfiguration {
    public static final Codec<GiantBioshroomConfiguration> CODEC = RecordCodecBuilder.create((codec) -> {
        return codec.group(BlockStateProvider.CODEC.fieldOf("stem_provider").forGetter((MushroomStemBlock) -> {
            return MushroomStemBlock.stemProvider;
        }), BlockStateProvider.CODEC.fieldOf("cap_provider").forGetter((CapBlock) -> {
            return CapBlock.capProvider;
        }), BlockStateProvider.CODEC.fieldOf("glow_block_provider").forGetter((GlowingBlock) -> {
            return GlowingBlock.glowBlockProvider;
        }), Codec.INT.fieldOf("minimum_size").forGetter((minimumSize) -> {
            return minimumSize.minimumSize;
        }), Codec.INT.fieldOf("size_variation").forGetter((sizeVariation) -> {
            return sizeVariation.sizeVariation;
        })).apply(codec, GiantBioshroomConfiguration::new);
    });

    public final BlockStateProvider stemProvider;
    public final BlockStateProvider capProvider;
    public final BlockStateProvider glowBlockProvider;
    public final int minimumSize;
    public final int sizeVariation;

    public GiantBioshroomConfiguration(BlockStateProvider stem, BlockStateProvider cap, BlockStateProvider glow, int minSize, int sizeVar) {
        this.stemProvider = stem;
        this.capProvider = cap;
        this.glowBlockProvider = glow;
        this.minimumSize = minSize;
        this.sizeVariation = sizeVar;
    }
}

