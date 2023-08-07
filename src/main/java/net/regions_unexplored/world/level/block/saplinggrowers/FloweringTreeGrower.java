package net.regions_unexplored.world.level.block.saplinggrowers;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class FloweringTreeGrower extends AbstractTreeGrower {
   protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
      if (random.nextInt(10) == 0) {
         return RuTreeFeatures.OAK_TREE_WITH_FLOWERS;
      } else {
         if (random.nextInt(10) == 0) {
            return RuTreeFeatures.BIG_FLOWERING_OAK_TREE;
         }
         return RuTreeFeatures.FLOWERING_OAK_TREE;
      }
   }
}
