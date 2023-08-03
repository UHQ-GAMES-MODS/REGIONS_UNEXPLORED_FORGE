package net.regions_unexplored.world.level.feature.tree;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
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

public class CobaltShrubFeature extends Feature<NoneFeatureConfiguration> {

    public CobaltShrubFeature(Codec<NoneFeatureConfiguration> codec) {
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
        int size = randomSource.nextInt(4);
        int dir = randomSource.nextInt(4);
        Direction direction = switch (dir) {
            case 0 -> Direction.EAST;
            case 1 -> Direction.SOUTH;
            case 2 -> Direction.WEST;
            default -> Direction.NORTH;
        };

        if(size==0){
            placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
            placeTop(level, placePos, randomSource);
        }
        else if(size==1){
            placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
            placeTop(level, placePos, randomSource);

        }
        else if(size==2){
            placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
            placeTop(level, placePos, randomSource);
            if(randomSource.nextInt(4)==0){
                placePos.move(direction);
                placeLogBlock(level, placePos, randomSource, direction.getAxis());
                placePos.move(direction);
                placePos.move(Direction.UP);
                placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
                placePos.move(Direction.UP);
                placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
                placeTop(level, placePos, randomSource);
            }
        }
        else if(size==3){
            placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
            placeTop(level, placePos, randomSource);
            placePos.move(direction);
            placeLogBlock(level, placePos, randomSource, direction.getAxis());
            placePos.move(direction);
            placePos.move(Direction.UP);
            placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
            placeTop(level, placePos, randomSource);
        }
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
    }


    public void placeLogBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, Direction.Axis axis) {
        boolean isBase = false;
        if(level.getBlockState(pos.below()).is(BlockTags.DIRT)){
            isBase = true;
        }
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return;
        }
        if(level.getBlockState(pos).is(RuBlocks.GLISTERING_NYLIUM.get())||level.getBlockState(pos).is(RuBlocks.MYCOTOXIC_NYLIUM.get())||level.getBlockState(pos).is(RuBlocks.BRIMSPROUT_NYLIUM.get())){
            level.setBlock(pos, Blocks.NETHERRACK.defaultBlockState(), 2);
        }
        if(level.getBlockState(pos).is(RuBlocks.COBALT_NYLIUM.get())){
            level.setBlock(pos, Blocks.BLACKSTONE.defaultBlockState(), 2);
        }
        else if(isReplaceable(level, pos)) {
                level.setBlock(pos, RuBlocks.COBALT_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, axis), 2);
        }
        else{
            return;
        }


        if(level.getBlockState(pos.below()).is(RuBlocks.GLISTERING_NYLIUM.get())||level.getBlockState(pos.below()).is(RuBlocks.MYCOTOXIC_NYLIUM.get())||level.getBlockState(pos.below()).is(RuBlocks.BRIMSPROUT_NYLIUM.get())){
            level.setBlock(pos.below(), Blocks.NETHERRACK.defaultBlockState(), 2);
        }
        if(level.getBlockState(pos.below()).is(RuBlocks.COBALT_NYLIUM.get())){
            level.setBlock(pos.below(), Blocks.BLACKSTONE.defaultBlockState(), 2);
        }
        else if(isReplaceable(level, pos.below())) {
            level.setBlock(pos.below(), RuBlocks.COBALT_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, axis), 2);
        }
    }

    public void placeLeavesBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return;
        }
        if(level.getBlockState(pos).canBeReplaced()) {
            level.setBlock(pos, RuBlocks.COBALT_WEBBING.get().defaultBlockState().setValue(LeavesBlock.DISTANCE, 1), 2);
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
        return reader.isStateAtPosition(pos, CobaltShrubFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, CobaltShrubFeature::isReplaceableBlock);
    }
}