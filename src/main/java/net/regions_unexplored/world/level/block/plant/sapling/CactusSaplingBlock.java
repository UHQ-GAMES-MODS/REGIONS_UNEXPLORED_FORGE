package net.regions_unexplored.world.level.block.plant.sapling;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.regions_unexplored.block.RuBlocks;

/*public class CactusSaplingBlock extends SaplingBlock {
    public CactusSaplingBlock(AbstractTreeGrower tree) {
        super(tree, Properties.of().mapColor(MapColor.COLOR_MAGENTA).replaceable().pushReaction(PushReaction.DESTROY).noCollission().instabreak().sound(SoundType.GRASS));
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return false;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos p_51030_) {
        BlockPos blockpos = p_51030_.below();
        return mayPlaceOn(level.getBlockState(blockpos), level, blockpos);
    }

    @Override
    public boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.is(BlockTags.SAND) || state.is(BlockTags.DIRT) || state.is(Blocks.FARMLAND)|| state.is(RuBlocks.SAGUARO_CACTUS.get())|| state.is(Blocks.CACTUS);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isAreaLoaded(pos, 1)) return;
        if (level.getMaxLocalRawBrightness(pos.above()) >= 9 && random.nextInt(7) == 0&&level.getBlockState(pos.below()).is(BlockTags.SAND)) {
            this.advanceTree(level, pos, state, random);
        }

    }

    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        if(level.getBlockState(pos.below()).is(BlockTags.SAND)) {
            return true;
        }
        else{
            return false;
        }
    }
}*/
