package net.regions_unexplored.world.level.feature.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;

import java.util.Random;

public class SmallSocotraTreeFeature extends Feature<NoneFeatureConfiguration> {

    public SmallSocotraTreeFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        RandomSource randomSource = context.random();
        WorldGenLevel level = context.level();

        if(!checkReplaceable(level, pos)){
            return false;
        }
        placeShrub(level, pos, randomSource);
        return true;
    }

    public void placeShrub(LevelAccessor level, BlockPos pos, RandomSource randomSource) {
        BlockPos.MutableBlockPos placePos = pos.mutable();
        if(randomSource.nextInt(3)==0){
            placeLogBlock(level,placePos,randomSource, Direction.Axis.Y);
            placePos.move(Direction.UP);
        }
        placeLogBlock(level,placePos,randomSource, Direction.Axis.Y);
        placePos.move(Direction.UP);
        placeLogBlock(level,placePos,randomSource, Direction.Axis.Y);
        placePos.move(Direction.UP);

        placeLogBlock(level,placePos,randomSource, Direction.Axis.Y);
        placeLogBlock(level,placePos.north(),randomSource, Direction.Axis.Z);
        placeTop(level,placePos.north(),randomSource);
        placeLogBlock(level,placePos.south(),randomSource, Direction.Axis.Z);
        placeTop(level,placePos.south(),randomSource);
        placeLogBlock(level,placePos.east(),randomSource, Direction.Axis.X);
        placeTop(level,placePos.east(),randomSource);
        placeLogBlock(level,placePos.west(),randomSource, Direction.Axis.X);
        placeTop(level,placePos.west(),randomSource);

        placePos.move(Direction.UP);
        placeLogBlock(level,placePos,randomSource, Direction.Axis.Y);
        placeTop(level,placePos,randomSource);
        placePos.move(Direction.UP);
    }


    public void placeTop(LevelAccessor level, BlockPos pos, RandomSource randomSource) {
        placeLeavesBlock(level, pos.north(), randomSource);
        placeLeavesBlock(level, pos.south(), randomSource);
        placeLeavesBlock(level, pos.east(), randomSource);
        placeLeavesBlock(level, pos.west(), randomSource);
        placeLeavesBlock(level, pos.north().east(), randomSource);
        placeLeavesBlock(level, pos.north().west(), randomSource);
        placeLeavesBlock(level, pos.south().east(), randomSource);
        placeLeavesBlock(level, pos.south().west(), randomSource);

        placeLeavesBlock(level, pos.above(), randomSource);
        placeLeavesBlock(level, pos.north().above(), randomSource);
        placeLeavesBlock(level, pos.south().above(), randomSource);
        placeLeavesBlock(level, pos.east().above(), randomSource);
        placeLeavesBlock(level, pos.west().above(), randomSource);
        if(randomSource.nextInt(4)==0) {
            placeLeavesBlock(level, pos.above().north().east(), randomSource);
        }
        if(randomSource.nextInt(4)==0) {
            placeLeavesBlock(level, pos.above().north().west(), randomSource);
        }
        if(randomSource.nextInt(4)==0) {
            placeLeavesBlock(level, pos.above().south().east(), randomSource);
        }
        if(randomSource.nextInt(4)==0) {
            placeLeavesBlock(level, pos.above().south().west(), randomSource);
        }
    }

    public void placeLogBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, Direction.Axis axis) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return;
        }
        if(level.getBlockState(pos).is(RuBlocks.PEAT_GRASS_BLOCK.get())){
            level.setBlock(pos, RuBlocks.PEAT_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.SILT_GRASS_BLOCK.get())){
            level.setBlock(pos, RuBlocks.SILT_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.ALPHA_GRASS_BLOCK.get())){
            level.setBlock(pos, Blocks.DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(Blocks.GRASS_BLOCK)){
            level.setBlock(pos, Blocks.DIRT.defaultBlockState(), 2);
        }
        else if(isReplaceable(level, pos)) {
            level.setBlock(pos, RuBlocks.SOCOTRA_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, axis), 2);
        }
        else{
            return;
        }

        if(level.getBlockState(pos.below()).is(RuBlocks.PEAT_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), RuBlocks.PEAT_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.SILT_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), RuBlocks.SILT_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.ALPHA_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), Blocks.DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK)){
            level.setBlock(pos.below(), Blocks.DIRT.defaultBlockState(), 2);
        }
    }

    public void placeLeavesBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return;
        }
        if(level.getBlockState(pos).canBeReplaced()) {
            level.setBlock(pos, RuBlocks.SOCOTRA_LEAVES.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
        }
    }

    public boolean checkReplaceable(LevelAccessor level, BlockPos pos) {
        if(level.isOutsideBuildHeight(pos)){
            return false;
        }
        if(!isReplaceable(level, pos)) {
            return false;
        }
        return true;
    }
    
    public static boolean isReplaceableDirtBlock(BlockState state) {
        return state.is(RuTags.TREE_GRASS_REPLACEABLES);
    }


    public static boolean isReplaceableDirt(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, SmallSocotraTreeFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, SmallSocotraTreeFeature::isReplaceableBlock);
    }
}