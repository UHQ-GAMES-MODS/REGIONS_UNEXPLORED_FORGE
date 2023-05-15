package net.regions_unexplored.world.level.block.grower;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class RedwoodTreeGrower extends AbstractUltraTreeGrower {
   protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
      return RuTreeFeatures.REDWOOD_TREE;
   }

   protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
      return RuTreeFeatures.GIANT_REDWOOD_TREE;
   }

   protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredUltraFeature(RandomSource random) {
      return RuTreeFeatures.ULTRA_REDWOOD_TREE;
   }
}
