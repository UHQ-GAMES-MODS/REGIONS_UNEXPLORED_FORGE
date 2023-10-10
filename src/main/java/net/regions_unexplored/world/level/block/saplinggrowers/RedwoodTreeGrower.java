package net.regions_unexplored.world.level.block.saplinggrowers;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class RedwoodTreeGrower extends AbstractUltraFromSuperTreeGrower {
   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
      return RuTreeFeatures.REDWOOD_TREE;
   }

   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredSuperFeature(RandomSource random) {
      return RuTreeFeatures.GIANT_REDWOOD_TREE;
   }

   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredUltraFeature(RandomSource random) {
      return RuTreeFeatures.ULTRA_REDWOOD_TREE;
   }
}
