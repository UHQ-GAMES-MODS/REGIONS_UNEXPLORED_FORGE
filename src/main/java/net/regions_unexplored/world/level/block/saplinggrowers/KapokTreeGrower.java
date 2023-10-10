package net.regions_unexplored.world.level.block.saplinggrowers;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;
import org.jetbrains.annotations.Nullable;

public class KapokTreeGrower extends AbstractSuperTreeGrower {
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
        return null;
   }

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredSuperFeature(RandomSource random) {
        return RuTreeFeatures.KAPOK_TREE;
    }
}

