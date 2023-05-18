package net.regions_unexplored.world.level.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class RuTreeConfiguration implements FeatureConfiguration {
    public static final Codec<RuTreeConfiguration> CODEC = RecordCodecBuilder.create((p_225468_) -> {
        return p_225468_.group(BlockStateProvider.CODEC.fieldOf("trunk_provider").forGetter((logBlock) -> {
            return logBlock.trunkProvider;
        }), BlockStateProvider.CODEC.fieldOf("foliage_provider").forGetter((leavesBlock) -> {
            return leavesBlock.foliageProvider;
        }), BlockStateProvider.CODEC.fieldOf("branch_provider").forGetter((branchBlock) -> {
            return branchBlock.branchProvider;
        }), Codec.INT.fieldOf("minimum_size").forGetter((minimumSize) -> {
            return minimumSize.minimumSize;
        }), Codec.INT.fieldOf("size_variation").forGetter((sizeVariation) -> {
            return sizeVariation.sizeVariation;
        })).apply(p_225468_, RuTreeConfiguration::new);
    });

    public final BlockStateProvider trunkProvider;
    public final BlockStateProvider foliageProvider;
    public final BlockStateProvider branchProvider;
    public final int minimumSize;
    public final int sizeVariation;

    public RuTreeConfiguration(BlockStateProvider log, BlockStateProvider leaves, BlockStateProvider branch, int minSize, int sizeVar) {
        this.trunkProvider = log;
        this.foliageProvider = leaves;
        this.branchProvider = branch;
        this.minimumSize = minSize;
        this.sizeVariation = sizeVar;
    }
}

