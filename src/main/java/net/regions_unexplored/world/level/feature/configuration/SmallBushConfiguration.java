package net.regions_unexplored.world.level.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

public class SmallBushConfiguration implements FeatureConfiguration {
    public static final Codec<SmallBushConfiguration> CODEC = RecordCodecBuilder.create((p_225468_) -> {
        return p_225468_.group(BlockStateProvider.CODEC.fieldOf("foliage_provider").forGetter((leavesBlock) -> {
            return leavesBlock.foliageProvider;
        })).apply(p_225468_, SmallBushConfiguration::new);
    });

    public final BlockStateProvider foliageProvider;

    public SmallBushConfiguration(BlockStateProvider leaves) {
        this.foliageProvider = leaves;
    }
}

