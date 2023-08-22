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
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;

import java.util.Random;

public class YellowBioshroomShrubFeature extends Feature<NoneFeatureConfiguration> {

    public YellowBioshroomShrubFeature(Codec<NoneFeatureConfiguration> codec) {
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
        placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
        placePos.move(Direction.UP);
        placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
        placePos.move(Direction.UP);
        if(randomSource.nextInt(3)==0){
            placeLogBlock(level, placePos, randomSource, Direction.Axis.Y);
            placePos.move(Direction.UP);
        }
        placeTop(level, placePos, randomSource);
    }


    public void placeTop(LevelAccessor level, BlockPos pos, RandomSource randomSource) {
        placeLeavesBlock(level, pos, randomSource);
        placeLeavesBlock(level, pos.north(), randomSource);
        placeLeavesBlock(level, pos.south(), randomSource);
        placeLeavesBlock(level, pos.east(), randomSource);
        placeLeavesBlock(level, pos.west(), randomSource);
        placeLeavesBlock(level, pos.north().east(), randomSource);
        placeLeavesBlock(level, pos.north().west(), randomSource);
        placeLeavesBlock(level, pos.south().east(), randomSource);
        placeLeavesBlock(level, pos.south().west(), randomSource);
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
                level.setBlock(pos, RuBlocks.YELLOW_BIOSHROOM_STEM.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, axis), 2);
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
            level.setBlock(pos.below(), RuBlocks.YELLOW_BIOSHROOM_STEM.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, axis), 2);
        }
    }

    public void placeLeavesBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return;
        }
        if(level.getBlockState(pos).canBeReplaced()) {
            level.setBlock(pos, RuBlocks.YELLOW_BIOSHROOM_BLOCK.get().defaultBlockState(), 2);
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
        return reader.isStateAtPosition(pos, YellowBioshroomShrubFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, YellowBioshroomShrubFeature::isReplaceableBlock);
    }
}