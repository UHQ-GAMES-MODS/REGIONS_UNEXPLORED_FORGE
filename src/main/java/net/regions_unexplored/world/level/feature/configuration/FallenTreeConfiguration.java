package net.regions_unexplored.world.level.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class FallenTreeConfiguration implements FeatureConfiguration {
    public static final Codec<FallenTreeConfiguration> CODEC = RecordCodecBuilder.create((p_225468_) -> {
        return p_225468_.group(
            BlockStateProvider.CODEC.fieldOf("stump_provider").forGetter((stumpProvider) -> {
            return stumpProvider.stumpProvider;
        }), BlockStateProvider.CODEC.fieldOf("trunk_provider").forGetter((logBlock) -> {
            return logBlock.trunkProvider;
        }), BlockStateProvider.CODEC.fieldOf("foliage_provider").forGetter((leavesBlock) -> {
            return leavesBlock.foliageProvider;
        }), Codec.INT.fieldOf("minimum_size").forGetter((minimumSize) -> {
            return minimumSize.minimumSize;
        }), Codec.INT.fieldOf("size_variation").forGetter((sizeVariation) -> {
            return sizeVariation.sizeVariation;
        }), Codec.BOOL.fieldOf("has_leaves").forGetter((hasLeaves) -> {
                    return hasLeaves.hasLeaves;
        })).apply(p_225468_, FallenTreeConfiguration::new);
    });

    public final BlockStateProvider stumpProvider;
    public final BlockStateProvider trunkProvider;
    public final BlockStateProvider foliageProvider;
    public final int minimumSize;
    public final int sizeVariation;
    public final boolean hasLeaves;

    public FallenTreeConfiguration(BlockStateProvider stump, BlockStateProvider log, BlockStateProvider leaves, int minSize, int sizeVar, boolean hasLeaves) {
        this.stumpProvider = stump;
        this.trunkProvider = log;
        this.foliageProvider = leaves;
        this.minimumSize = minSize;
        this.sizeVariation = sizeVar;
        this.hasLeaves = hasLeaves;
    }
}

