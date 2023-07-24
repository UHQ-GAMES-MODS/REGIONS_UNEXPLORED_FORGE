package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ProbabilityFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;

public class HyacinthPlantsFeature extends Feature<ProbabilityFeatureConfiguration> {
   public HyacinthPlantsFeature(Codec<ProbabilityFeatureConfiguration> p_66768_) {
      super(p_66768_);
   }

   public boolean place(FeaturePlaceContext<ProbabilityFeatureConfiguration> p_160318_) {
      RandomSource randomsource = p_160318_.random();
      WorldGenLevel worldgenlevel = p_160318_.level();
      BlockPos blockpos = p_160318_.origin();
      BlockState blockstate = Blocks.SEAGRASS.defaultBlockState();
      int i = randomsource.nextInt(8) - randomsource.nextInt(8);
      int j = randomsource.nextInt(8) - randomsource.nextInt(8);
      int k = worldgenlevel.getHeight(Heightmap.Types.OCEAN_FLOOR, blockpos.getX() + i, blockpos.getZ() + j);
      BlockPos blockpos1 = new BlockPos(blockpos.getX() + i, k, blockpos.getZ() + j);
      if (worldgenlevel.getBlockState(blockpos1).is(Blocks.WATER)) {
         if (blockstate.canSurvive(worldgenlevel, blockpos1)) {
            if(randomsource.nextInt(7)==0){
               blockstate = RuBlocks.HYACINTH_BLOOM.get().defaultBlockState();
            }
            else{
               blockstate = Blocks.SEAGRASS.defaultBlockState();
            }
               worldgenlevel.setBlock(blockpos1, blockstate, 2);
         }
      }
      return true;
   }
}