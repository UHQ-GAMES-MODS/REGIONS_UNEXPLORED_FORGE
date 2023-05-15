package net.regions_unexplored.world.level.block.grower;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuVegetationFeatures;

public class BrimwoodGrower extends AbstractTreeGrower {
   protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
      if(random.nextInt(7)==0){return RuVegetationFeatures.TALL_BRIM_WILLOW;}
      else{return RuVegetationFeatures.BRIM_WILLOW;}
   }
}

