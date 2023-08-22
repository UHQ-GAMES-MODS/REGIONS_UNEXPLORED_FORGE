package net.regions_unexplored.world.level.block.wood;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;

public class PineLogBlock extends Block {
   public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
   public static final BooleanProperty TRANSITION_BLOCK = RuBlockStateProperties.TRANSITION_BLOCK;
   public static final BooleanProperty IS_STRIPPED = RuBlockStateProperties.IS_STRIPPED;

   public PineLogBlock(Properties p_55926_) {
      super(p_55926_);
      this.registerDefaultState(this.defaultBlockState().setValue(AXIS, Direction.Axis.Y).setValue(TRANSITION_BLOCK, false).setValue(IS_STRIPPED, false));
   }

   public BlockState rotate(BlockState p_55930_, Rotation p_55931_) {
      return rotatePillar(p_55930_, p_55931_);
   }

   public static BlockState rotatePillar(BlockState state, Rotation rotation) {
      switch (rotation) {
         case COUNTERCLOCKWISE_90:
         case CLOCKWISE_90:
            switch (state.getValue(AXIS)) {
               case X:
                  return state.setValue(AXIS, Direction.Axis.Z);
               case Z:
                  return state.setValue(AXIS, Direction.Axis.X);
               default:
                  return state;
            }
         default:
            return state;
      }
   }

   @Override
   public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
      boolean isTransition = false;
      if(!state.getValue(IS_STRIPPED)){
         if(state.getValue(AXIS)==Direction.Axis.Y){
            if(level.getBlockState(pos.below())==RuBlocks.STRIPPED_PINE_LOG.get().defaultBlockState()||level.getBlockState(pos.below())==RuBlocks.PINE_LOG.get().defaultBlockState().setValue(PineLogBlock.IS_STRIPPED, true)){
               isTransition = true;
            }
         }
      }

      return state.setValue(TRANSITION_BLOCK, isTransition);
   }

   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55933_) {
      p_55933_.add(AXIS, TRANSITION_BLOCK, IS_STRIPPED);
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      boolean isTransition = false;

      if(!this.defaultBlockState().getValue(IS_STRIPPED)){
         if(this.defaultBlockState().getValue(AXIS)==Direction.Axis.Y){
            if(context.getLevel().getBlockState(context.getClickedPos().below())==RuBlocks.STRIPPED_PINE_LOG.get().defaultBlockState()||context.getLevel().getBlockState(context.getClickedPos().below())==RuBlocks.PINE_LOG.get().defaultBlockState().setValue(PineLogBlock.IS_STRIPPED, true)){
               isTransition = true;
            }
         }
      }

      return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis()).setValue(TRANSITION_BLOCK, isTransition);
   }
}