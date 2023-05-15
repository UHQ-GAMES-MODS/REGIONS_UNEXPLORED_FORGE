package net.regions_unexplored.world.level.block.grass;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.material.PushReaction;
import net.regions_unexplored.data.tags.RuTags;

public class SandyDoublePlantBlock extends DoublePlantBlock {

    public SandyDoublePlantBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public PushReaction getPistonPushReaction(BlockState state) {
        return PushReaction.DESTROY;
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.is(RuTags.SANDY_GRASS_CAN_SURVIVE_ON);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.below();
        BlockState groundState = level.getBlockState(blockpos);
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER)
            return groundState.is(this) && groundState.getValue(HALF) == DoubleBlockHalf.LOWER;
        else
            return this.mayPlaceOn(groundState, level, blockpos);
    }
}
