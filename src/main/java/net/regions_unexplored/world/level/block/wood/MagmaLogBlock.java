package net.regions_unexplored.world.level.block.wood;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;

public class MagmaLogBlock extends RotatedPillarBlock {

    public static final BooleanProperty TRANSITION_BLOCK = RuBlockStateProperties.TRANSITION_BLOCK;

    public MagmaLogBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(TRANSITION_BLOCK, true).setValue(AXIS, Direction.Axis.Y));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(TRANSITION_BLOCK, AXIS);
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
        boolean isTransition = true;
        if(level.getBlockState(pos.above()).is(this)){
           isTransition = false;
        }
        return state.setValue(TRANSITION_BLOCK, isTransition);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean isTransition = true;
        if(context.getLevel().getBlockState(context.getClickedPos().above()).is(this)){
            isTransition = false;
        }
        return this.defaultBlockState().setValue(TRANSITION_BLOCK, isTransition);
    }
}