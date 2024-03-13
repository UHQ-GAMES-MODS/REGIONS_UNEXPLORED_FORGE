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
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.block.aquatic.flouramine.FlouramineBlock;

public class FlouramineFeature extends Feature<NoneFeatureConfiguration> {
   public FlouramineFeature(Codec<NoneFeatureConfiguration> p_66219_) {
      super(p_66219_);
   }

   public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_159956_) {
      int i = 0;
      WorldGenLevel worldgenlevel = p_159956_.level();
      BlockPos blockpos = p_159956_.origin();
      RandomSource randomsource = p_159956_.random();
      int j = worldgenlevel.getHeight(Heightmap.Types.OCEAN_FLOOR, blockpos.getX(), blockpos.getZ());
      BlockPos blockpos1 = new BlockPos(blockpos.getX(), j, blockpos.getZ());
      if (worldgenlevel.getBlockState(blockpos1).is(Blocks.WATER)) {
         BlockState blockstate = RuBlocks.FLOURAMINE.get().defaultBlockState();
         BlockState blockstate1 = RuBlocks.FLOURAMINE_PLANT.get().defaultBlockState();
         int k = 1 + randomsource.nextInt(10);

         for(int l = 0; l <= k; ++l) {
            if (worldgenlevel.getBlockState(blockpos1).is(Blocks.WATER) && worldgenlevel.getBlockState(blockpos1.above()).is(Blocks.WATER) && blockstate1.canSurvive(worldgenlevel, blockpos1)) {
               if (l == k) {
                  worldgenlevel.setBlock(blockpos1, blockstate.setValue(FlouramineBlock.AGE, Integer.valueOf(randomsource.nextInt(4) + 20)), 2);
                  ++i;
               } else {
                  worldgenlevel.setBlock(blockpos1, blockstate1, 2);
               }
            } else if (l > 0) {
               BlockPos blockpos2 = blockpos1.below();
               if (blockstate.canSurvive(worldgenlevel, blockpos2) && !worldgenlevel.getBlockState(blockpos2.below()).is(Blocks.KELP)) {
                  worldgenlevel.setBlock(blockpos2, blockstate.setValue(FlouramineBlock.AGE, Integer.valueOf(randomsource.nextInt(4) + 20)), 2);
                  ++i;
               }
               break;
            }

            blockpos1 = blockpos1.above();
         }
      }

      return i > 0;
   }
}