package net.regions_unexplored.world.level.block.other_dirt;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LayerLightEngine;
import net.regions_unexplored.block.RuBlocks;

public abstract class ChalkDirtBlock extends SnowyDirtBlock {
   protected ChalkDirtBlock(Properties properties) {
      super(properties);
   }

   private static boolean canBeGrass(BlockState state, LevelReader reader, BlockPos pos) {
      BlockPos blockPos = pos.above();
      BlockState blockState = reader.getBlockState(blockPos);
      if (blockState.is(Blocks.SNOW) && blockState.getValue(SnowLayerBlock.LAYERS) == 1) {
         return true;
      } else if (blockState.getFluidState().getAmount() == 8) {
         return false;
      } else {
         int i = LayerLightEngine.getLightBlockInto(reader, state, pos, blockState, blockPos, Direction.UP, blockState.getLightBlock(reader, blockPos));
         return i < reader.getMaxLightLevel();
      }
   }

   private static boolean canPropagate(BlockState state, LevelReader reader, BlockPos pos) {
      BlockPos blockpos = pos.above();
      return canBeGrass(state, reader, pos) && !reader.getFluidState(blockpos).is(FluidTags.WATER);
   }

   public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
      if (!canBeGrass(state, level, pos)) {
         if (!level.isAreaLoaded(pos, 1)) return;
         level.setBlockAndUpdate(pos, RuBlocks.CHALK.get().defaultBlockState());
      } else {
         if (!level.isAreaLoaded(pos, 3)) return;
         if (level.getMaxLocalRawBrightness(pos.above()) >= 9) {
            BlockState blockstate = this.defaultBlockState();

            for(int i = 0; i < 4; ++i) {
               BlockPos blockPos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
               if (level.getBlockState(blockPos).is(RuBlocks.CHALK.get()) && canPropagate(blockstate, level, blockPos)) {
               }
            }
         }

      }
   }
}
