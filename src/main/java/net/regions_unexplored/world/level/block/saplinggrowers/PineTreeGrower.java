package net.regions_unexplored.world.level.block.saplinggrowers;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class PineTreeGrower extends AbstractMegaTreeGrower {
   protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
      
      if(random.nextInt(7)==0){
      if(random.nextInt(3)==0){return RuTreeFeatures.SCOTTS_PINE_TREE_TALL;}
      else{return RuTreeFeatures.PINE_TREE_TALL;}
      }
      else{
      if(random.nextInt(3)==0){return RuTreeFeatures.SCOTTS_PINE_TREE;}
      else{return RuTreeFeatures.PINE_TREE;}
      }
   }

   protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
      return RuTreeFeatures.GIANT_PINE_TREE;
   }
}

