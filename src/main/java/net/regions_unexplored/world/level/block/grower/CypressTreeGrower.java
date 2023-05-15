package net.regions_unexplored.world.level.block.grower;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class CypressTreeGrower extends AbstractTreeGrower {
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
      if (random.nextInt(10) == 0) {
      	int i = random.nextInt(3);
      	if(i==0){
         return RuTreeFeatures.CYPRESS_TREE;
      	} else {
         return RuTreeFeatures.CYPRESS_TREE_MOSS;
      	}
      }
      else{
      	int j = random.nextInt(3);
      	if(j==0){
         return RuTreeFeatures.BIG_CYPRESS_TREE;
      	} else {
         return RuTreeFeatures.BIG_CYPRESS_TREE_MOSS;
      	}
      }
   }
}
