package net.regions_unexplored.world.level.block.saplinggrowers;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;
import org.jetbrains.annotations.Nullable;

public class BaobabTreeGrower extends AbstractUltraFromMegaTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
        return null;
    }

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
        return RuTreeFeatures.MEGA_BAOBAB_TREE;
    }

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredUltraFeature(RandomSource random) {
        return RuTreeFeatures.ULTRA_BAOBAB_TREE;
    }
}
