package net.regions_unexplored.world.level.block.saplinggrowers;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class DeadPineTreeGrower extends AbstractTreeGrower {
   protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
      if(random.nextInt(7)==0){
         if(random.nextInt(3)==0){
            return RuTreeFeatures.DEAD_STRIPPED_PINE_TREE_TALL;
         }
         else{
            return RuTreeFeatures.DEAD_PINE_TREE_TALL;
         }
      }
      else{
         if(random.nextInt(3)==0){
            return RuTreeFeatures.DEAD_STRIPPED_PINE_TREE;
         }
         else{
            return RuTreeFeatures.DEAD_PINE_TREE;
         }
      }
   }
}