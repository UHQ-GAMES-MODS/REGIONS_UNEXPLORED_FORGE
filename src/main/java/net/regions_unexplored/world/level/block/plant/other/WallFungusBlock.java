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

public class WallFungusBlock extends BushBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    public WallFungusBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return switch (state.getValue(FACING)) {
            default -> box(0, 0, 0, 16, 16, 3);
            case NORTH -> box(0, 0, 13, 16, 16, 16);
            case EAST -> box(0, 0, 0, 3, 16, 16);
            case WEST -> box(13, 0, 0, 16, 16, 16);
        };
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
            if(!level.getBlockState(blockposn).isFaceSturdy(level, blockposn, Direction.SOUTH)){
                return false;
            }
            else{
                return true;
            }
        }

        if (direction==Direction.NORTH) {
            if(!level.getBlockState(blockposs).isFaceSturdy(level, blockposs, Direction.NORTH)){
                return false;
            }
            else{
                return true;
            }
        }

        if (direction==Direction.WEST) {
            if(!level.getBlockState(blockpose).isFaceSturdy(level, blockpose, Direction.WEST)){
                return false;
            }
            else{
                return true;
            }
        }

        if (direction==Direction.EAST) {
            if(!level.getBlockState(blockposw).isFaceSturdy(level, blockposw, Direction.EAST)){
                return false;
            }
            else{
                return true;
            }
        }
        return false;
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