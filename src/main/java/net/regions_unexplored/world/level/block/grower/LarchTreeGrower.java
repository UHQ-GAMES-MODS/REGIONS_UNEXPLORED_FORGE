package net.regions_unexplored.world.level.block.grower;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class LarchTreeGrower extends AbstractMegaTreeGrower {
   protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
      if(random.nextInt(7)==0){return RuTreeFeatures.BIG_LARCH_TREE;}
      else{return RuTreeFeatures.LARCH_TREE;}
   }

   protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
      return RuTreeFeatures.GIANT_LARCH_TREE;
   }
}

