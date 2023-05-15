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
 * INTERNAL_FEATURE_PLACING_HELPER
 *
 * */
public class GrassPlacementBlock extends BushBlock {
    public GrassPlacementBlock() {
        super(Properties.of(Material.PLANT).sound(SoundType.GRASS).instabreak().noCollission());
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.is(RuBlocks.ALPHA_GRASS_BLOCK.get()) || state.is(RuBlocks.VIRIDESCENT_NYLIUM.get())
                || state.is(RuBlocks.FOREST_GRASS_BLOCK.get())
                || state.is(RuBlocks.PLAINS_GRASS_BLOCK.get())
                || state.is(RuBlocks.CHALK_GRASS_BLOCK.get()) || state.is(Blocks.GRASS_BLOCK) || state.is(Blocks.MOSS_BLOCK);
    }


    @Override
    public boolean canSurvive(BlockState p_51028_, LevelReader p_51029_, BlockPos p_51030_) {
        BlockPos blockpos = p_51030_.below();
        return this.mayPlaceOn(p_51029_.getBlockState(blockpos), p_51029_, blockpos);
    }
}

