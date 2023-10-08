package net.regions_unexplored.world.level.block.forest_dirt;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.regions_unexplored.block.RuBlocks;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class NoSpreadForestGrassBlock extends SpreadingForestDirtBlock implements BonemealableBlock {
   public NoSpreadForestGrassBlock(Properties properties) {
      super(properties);
   }

   public boolean isValidBonemealTarget(BlockGetter levelReader, BlockPos pos, BlockState state, boolean bool) {
      return levelReader.getBlockState(pos.above()).isAir();
   }

   public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
      return true;
   }

   public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
      BlockPos blockPos = pos.above();
      BlockState blockState = Blocks.GRASS.defaultBlockState();

      label46:
      for(int i = 0; i < 128; ++i) {
         BlockPos blockPos1 = blockPos;

         for(int j = 0; j < i / 16; ++j) {
            blockPos1 = blockPos1.offset(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
            if (!level.getBlockState(blockPos1.below()).is(this) || level.getBlockState(blockPos1).isCollisionShapeFullBlock(level, blockPos1)) {
               continue label46;
            }
         }

         BlockState blockState1 = level.getBlockState(blockPos1);
         if (blockState1.is(blockState.getBlock()) && random.nextInt(10) == 0) {
            ((BonemealableBlock)blockState.getBlock()).performBonemeal(level, random, blockPos1, blockState1);
         }

         if (blockState1.isAir()) {
            Holder<PlacedFeature> holder;
            if (random.nextInt(8) == 0) {
               List<ConfiguredFeature<?, ?>> list = level.getBiome(blockPos1).value().getGenerationSettings().getFlowerFeatures();
               if (list.isEmpty()) {
                  continue;
               }
               holder = ((RandomPatchConfiguration)list.get(0).config()).feature();
            } else {
               holder = VegetationPlacements.GRASS_BONEMEAL;
            }

            holder.value().place(level, level.getChunkSource().getGenerator(), random, blockPos1);
         }
      }

   }

   @Override
   public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
      if (!canBeGrass(state, level, pos)) {
         if (!level.isAreaLoaded(pos, 1)) return;
         level.setBlockAndUpdate(pos, RuBlocks.PEAT_DIRT.get().defaultBlockState());
      } else {
         if (!level.isAreaLoaded(pos, 3)) return;
         if (level.getMaxLocalRawBrightness(pos.above()) >= 9) {
            BlockState blockstate = this.defaultBlockState();

            for(int i = 0; i < 4; ++i) {
               BlockPos blockpos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
               if (level.getBlockState(blockpos).is(RuBlocks.PEAT_DIRT.get()) && canPropagate(blockstate, level, blockpos)) {
                  level.setBlockAndUpdate(blockpos, RuBlocks.PEAT_GRASS_BLOCK.get().defaultBlockState().setValue(SNOWY, Boolean.valueOf(level.getBlockState(blockpos.above()).is(Blocks.SNOW))));
               }
            }
         }

      }
   }

   @Override
   public BlockState updateShape(BlockState p_56644_, Direction p_56645_, BlockState p_56646_, LevelAccessor p_56647_, BlockPos p_56648_, BlockPos p_56649_) {
      return RuBlocks.PEAT_GRASS_BLOCK.get().defaultBlockState();
   }

   @Override
   @Nullable
   public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction action, boolean simulate) {
      if (ToolActions.SHOVEL_FLATTEN == action && context.getItemInHand().canPerformAction(ToolActions.SHOVEL_FLATTEN)) {
         Block block = state.getBlock();
         if (block == RuBlocks.PEAT_GRASS_BLOCK.get()) {
            return RuBlocks.PEAT_DIRT_PATH.get().defaultBlockState();}
         else{
            return null;
         }

      }
      if (ToolActions.HOE_TILL == action && context.getItemInHand().canPerformAction(ToolActions.HOE_TILL)) {
         Block block = state.getBlock();
         if (block == RuBlocks.PEAT_GRASS_BLOCK.get()) {
            return RuBlocks.PEAT_FARMLAND.get().defaultBlockState();}
         else{
            return null;
         }

      }
      return null;
   }

}
