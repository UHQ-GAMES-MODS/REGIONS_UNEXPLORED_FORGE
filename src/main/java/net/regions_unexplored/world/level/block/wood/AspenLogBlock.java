package net.regions_unexplored.world.level.block.wood;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;

public class AspenLogBlock extends Block {
   public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;
   public static final BooleanProperty IS_BASE = RuBlockStateProperties.IS_BASE;

   public AspenLogBlock(Properties p_55926_) {
      super(p_55926_);
      this.registerDefaultState(this.defaultBlockState().setValue(AXIS, Direction.Axis.Y).setValue(IS_BASE, false));
   }

   public BlockState rotate(BlockState p_55930_, Rotation p_55931_) {
      return rotatePillar(p_55930_, p_55931_);
   }

   public static BlockState rotatePillar(BlockState p_154377_, Rotation p_154378_) {
      switch (p_154378_) {
         case COUNTERCLOCKWISE_90:
         case CLOCKWISE_90:
            switch ((Direction.Axis)p_154377_.getValue(AXIS)) {
               case X:
                  return p_154377_.setValue(AXIS, Direction.Axis.Z);
               case Z:
                  return p_154377_.setValue(AXIS, Direction.Axis.X);
               default:
                  return p_154377_;
            }
         default:
            return p_154377_;
      }
   }

   @Override
   public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
      boolean isBase = false;

      if(this.defaultBlockState().getValue(AXIS)==Direction.Axis.Y){
         if(level.getBlockState(pos.below()).is(BlockTags.DIRT)){
            isBase = true;
         }
      }

      return state.setValue(IS_BASE, isBase);
   }

   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55933_) {
      p_55933_.add(AXIS, IS_BASE);
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      boolean isBase = false;

      if(this.defaultBlockState().getValue(AXIS)==Direction.Axis.Y){
         if(context.getLevel().getBlockState(context.getClickedPos().below()).is(BlockTags.DIRT)){
            isBase = true;
         }
      }

      return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis()).setValue(IS_BASE, isBase);
   }
}