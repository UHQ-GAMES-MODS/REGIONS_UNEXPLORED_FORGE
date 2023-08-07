package net.regions_unexplored.world.level.block.saplinggrowers;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class JoshuaTreeGrower extends AbstractTreeGrower {
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
        if(random.nextInt(5)==0){
         return RuTreeFeatures.LARGE_JOSHUA_TREE;
        }
        else{
            if(random.nextInt(10)==0){
                return RuTreeFeatures.JOSHUA_TREE_SHRUB;
            }
            return RuTreeFeatures.MEDIUM_JOSHUA_TREE;
        }
   }
}

