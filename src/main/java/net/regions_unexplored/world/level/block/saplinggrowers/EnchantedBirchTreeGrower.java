package net.regions_unexplored.world.level.block.saplinggrowers;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class EnchantedBirchTreeGrower extends AbstractTreeGrower {
   protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
      if (random.nextInt(6) == 0) {
         return RuTreeFeatures.ENCHANTED_BIRCH_TREE_TALL;
      } else {
         return RuTreeFeatures.ENCHANTED_BIRCH_TREE;
      }
   }
}
