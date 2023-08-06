package net.regions_unexplored.world.level.block.plant.other;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;

public class BranchBlock extends BushBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public BranchBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if(state.is(RuBlocks.JOSHUA_BEARD.get())||state.is(RuBlocks.PALM_BEARD.get())){
            return switch (state.getValue(FACING)) {
                default -> box(0, 0, 0, 16, 16, 3);
                case NORTH -> box(0, 0, 13, 16, 16, 16);
                case EAST -> box(0, 0, 0, 3, 16, 16);
                case WEST -> box(13, 0, 0, 16, 16, 16);
            };
        }
        else{
        return switch (state.getValue(FACING)) {
            default -> box(6, 2, 0, 10, 7, 16);
            case NORTH -> box(6, 2, 0, 10, 7, 16);
            case EAST -> box(0, 2, 6, 16, 7, 10);
            case WEST -> box(0, 2, 6, 16, 7, 10);
        };
        }
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING);
        BlockPos blockposn = pos.north();
        BlockPos blockposs = pos.south();
        BlockPos blockpose = pos.east();
        BlockPos blockposw = pos.west();
        if (direction==Direction.SOUTH) {

            if(!state.is(RuBlocks.JOSHUA_BEARD.get())&&!state.is(RuBlocks.PALM_BEARD.get())){
            if(!level.getBlockState(blockposn).isFaceSturdy(level, blockposn, Direction.SOUTH)){
                return false;
            }
            }
            if(mayPlaceOn(level.getBlockState(blockposn), level, blockposn)){
                return true;
            }
            else{
                return false;
            }
        }

        if (direction==Direction.NORTH) {
            if(!state.is(RuBlocks.JOSHUA_BEARD.get())&&!state.is(RuBlocks.PALM_BEARD.get())){
            if(!level.getBlockState(blockposs).isFaceSturdy(level, blockposs, Direction.NORTH)){
                return false;
            }
            }
            if(mayPlaceOn(level.getBlockState(blockposs), level, blockposs)){
                return true;
            }
            else{
                return false;
            }
        }

        if (direction==Direction.WEST) {
            if(!state.is(RuBlocks.JOSHUA_BEARD.get())&&!state.is(RuBlocks.PALM_BEARD.get())){
            if(!level.getBlockState(blockpose).isFaceSturdy(level, blockpose, Direction.WEST)){
                return false;
            }
            }
            if(mayPlaceOn(level.getBlockState(blockpose), level, blockpose)){
                return true;
            }
            else{
                return false;
            }
        }

        if (direction==Direction.EAST) {
            if(!state.is(RuBlocks.JOSHUA_BEARD.get())&&!state.is(RuBlocks.PALM_BEARD.get())){
            if(!level.getBlockState(blockposw).isFaceSturdy(level, blockposw, Direction.EAST)){
                return false;
            }
            }
            if(mayPlaceOn(level.getBlockState(blockposw), level, blockposw)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.is(RuTags.BRANCHES_CAN_SURVIVE_ON);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        if (context.getClickedFace().getAxis() == Direction.Axis.Y)
            return this.defaultBlockState().setValue(FACING, Direction.NORTH);
        return this.defaultBlockState().setValue(FACING, context.getClickedFace());
    }

    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
    }

    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }
}