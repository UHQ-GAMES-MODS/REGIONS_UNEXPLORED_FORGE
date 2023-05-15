package net.regions_unexplored.world.level.block.placer;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.regions_unexplored.block.RuBlocks;
/*
 *
 * INTERNAL_FEATURE_PLACING_HELPER_BLOCK
 *
 * */
public class SandPlacementBlock extends BushBlock {
    public SandPlacementBlock() {
        super(Properties.of(Material.PLANT).sound(SoundType.GRASS).instabreak().noCollission());
    }

    @Override
    public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
        return groundState.is(RuBlocks.QUICKSAND.get())
                || groundState.is(Blocks.SAND) || groundState.is(Blocks.RED_SAND);
    }


    @Override
    public boolean canSurvive(BlockState p_51028_, LevelReader p_51029_, BlockPos p_51030_) {
        BlockPos blockpos = p_51030_.below();
        return this.mayPlaceOn(p_51029_.getBlockState(blockpos), p_51029_, blockpos);
    }
}

