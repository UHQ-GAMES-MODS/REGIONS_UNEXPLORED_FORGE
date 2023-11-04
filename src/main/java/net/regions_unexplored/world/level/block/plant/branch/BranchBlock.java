package net.regions_unexplored.world.level.block.plant.branch;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;

public class BranchBlock extends BushBlock {
    public static final String BRANCH = "branch";
    public static final String BEARD = "beard";
    private final String type;

    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;

    public BranchBlock(Properties properties, String branchType) {
        super(properties);
        this.type = branchType;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if(type==BEARD){
            return switch (state.getValue(FACING)) {
                default -> box(0, 0, 0, 16, 16, 3);
                case NORTH -> box(0, 0, 13, 16, 16, 16);
                case EAST -> box(0, 0, 0, 3, 16, 16);
                case WEST -> box(13, 0, 0, 16, 16, 16);
            };
        }
        else{
        return switch (state.getValue(FACING)) {
            default -> box(6, 4, 0, 10, 9, 16);
            case NORTH -> box(6, 4, 0, 10, 9, 16);
            case EAST -> box(0, 4, 6, 16, 9, 10);
            case WEST -> box(0, 4, 6, 16, 9, 10);
        };
        }
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(FACING).getOpposite();
        BlockPos.MutableBlockPos blockPos = pos.mutable().move(direction);

        if(mayPlaceOn(level.getBlockState(blockPos), level, blockPos)&&level.getBlockState(blockPos).isFaceSturdy(level, blockPos, direction)){
            return true;
        }
        else{
                return false;
        }
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