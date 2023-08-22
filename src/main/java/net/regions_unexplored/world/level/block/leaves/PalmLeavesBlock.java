package net.regions_unexplored.world.level.block.leaves;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.OptionalInt;

public class PalmLeavesBlock extends LeavesBlock {
   public PalmLeavesBlock(Properties p_273704_) {
      super(p_273704_);
   }

   @Override
   public void tick(BlockState p_221369_, ServerLevel p_221370_, BlockPos p_221371_, RandomSource p_221372_) {
      p_221370_.setBlock(p_221371_, updateDistance(p_221369_, p_221370_, p_221371_), 3);
   }

   private static BlockState updateDistance(BlockState p_54436_, LevelAccessor p_54437_, BlockPos p_54438_) {
      int i = 7;


      while(i>0) {
         i = Math.min(i, getDistanceAt(p_54437_.getBlockState(p_54438_)) + 1);
         if (i == 1) {
            break;
         }
      }

      return p_54436_.setValue(DISTANCE, Integer.valueOf(i));
   }

   private static int getDistanceAt(BlockState p_54464_) {
      return getOptionalDistanceAt(p_54464_).orElse(7);
   }

   public static OptionalInt getOptionalDistanceAt(BlockState p_277868_) {
      if (p_277868_.is(BlockTags.LOGS)) {
         return OptionalInt.of(0);
      } else {
         return p_277868_.hasProperty(DISTANCE) ? OptionalInt.of(p_277868_.getValue(DISTANCE)) : OptionalInt.empty();
      }
   }
}