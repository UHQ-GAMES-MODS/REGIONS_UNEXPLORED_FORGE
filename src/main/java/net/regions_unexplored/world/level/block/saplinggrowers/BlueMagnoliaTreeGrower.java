package net.regions_unexplored.world.level.block.saplinggrowers;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class BlueMagnoliaTreeGrower extends AbstractTreeGrower {
   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
      if (random.nextInt(15) == 0) {
         return RuTreeFeatures.BIG_BLUE_MAGNOLIA_TREE;
      } else {
         return RuTreeFeatures.BLUE_MAGNOLIA_TREE;
      }
   }
}
