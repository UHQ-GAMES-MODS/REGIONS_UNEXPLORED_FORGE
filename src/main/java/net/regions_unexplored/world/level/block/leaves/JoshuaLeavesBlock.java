package net.regions_unexplored.world.level.block.leaves;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;

import javax.annotation.Nullable;

public class JoshuaLeavesBlock extends DoublePlantBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty NATURAL = RuBlockStateProperties.NATURAL;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public JoshuaLeavesBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(NATURAL, Boolean.valueOf(false)).setValue(WATERLOGGED, Boolean.valueOf(false)).setValue(HALF, DoubleBlockHalf.LOWER));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_52901_) {
        p_52901_.add(NATURAL, WATERLOGGED, HALF);
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }
        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        if (direction.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (direction == Direction.UP) || state1.is(this) && state1.getValue(HALF) != doubleblockhalf) {
            return doubleblockhalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, state1, level, pos, pos1);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }

    public FluidState getFluidState(BlockState p_221384_) {
        return p_221384_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_221384_);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState groundState = level.getBlockState(blockpos);
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER){
            return groundState.is(this) && groundState.getValue(HALF) == DoubleBlockHalf.LOWER;
        }
        else{
            if(state.getValue(NATURAL)==true){
                return groundState.is(BlockTags.LOGS);
            }
            else{
            return groundState.isFaceSturdy(level, blockpos, Direction.UP);
            }
        }
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return false;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        Level level = context.getLevel();
        if(blockpos.getY() < level.getMaxBuildHeight() - 1) {
            if(level.getBlockState(blockpos.above()).canBeReplaced(context)) {
                return this.stateDefinition.any().setValue(NATURAL, Boolean.valueOf(false)).setValue(HALF, DoubleBlockHalf.LOWER).setValue(WATERLOGGED, Boolean.valueOf(fluidstate.getType() == Fluids.WATER));
            }
        }
        return super.getStateForPlacement(context);
    }
}