package net.regions_unexplored.world.level.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class HyacinthStockConfiguration implements FeatureConfiguration {
    public static final Codec<HyacinthStockConfiguration> CODEC = RecordCodecBuilder.create((p_225468_) -> {
        return p_225468_.group(BlockStateProvider.CODEC.fieldOf("stock_provider").forGetter((stockBlock) -> {
            return stockBlock.stockProvider;
        }), Codec.INT.fieldOf("minimum_size").forGetter((minimumSize) -> {
            return minimumSize.minimumSize;
        }), Codec.INT.fieldOf("size_variation").forGetter((sizeVariation) -> {
            return sizeVariation.sizeVariation;
        })).apply(p_225468_, HyacinthStockConfiguration::new);
    });

    public final BlockStateProvider stockProvider;
    public final int minimumSize;
    public final int sizeVariation;

    public HyacinthStockConfiguration(BlockStateProvider stock, int minSize, int sizeVar) {
        this.stockProvider = stock;
        this.minimumSize = minSize;
        this.sizeVariation = sizeVar;
    }
}

