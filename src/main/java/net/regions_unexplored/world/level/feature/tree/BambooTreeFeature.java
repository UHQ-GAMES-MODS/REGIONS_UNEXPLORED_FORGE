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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;

import java.util.Random;

public class BambooTreeFeature extends Feature<RuTreeConfiguration> {

    public BambooTreeFeature(Codec<RuTreeConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<RuTreeConfiguration> context) {
        RuTreeConfiguration treeConfiguration = context.config();
        BlockPos pos = context.origin();
        RandomSource randomSource = context.random();
        WorldGenLevel level = context.level();
        int height_main = context.random().nextInt(treeConfiguration.sizeVariation) + treeConfiguration.minimumSize;

        int check = 0;
        BlockPos.MutableBlockPos checkPos = pos.mutable();
        while (check <= height_main) {
            if(!checkReplaceable(level, checkPos)){
                return false;
            }
            else{
                checkPos.move(Direction.UP);
                check = check + 1;
            }
        }
        int placeCheck = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while (placeCheck <= height_main) {
            placeLog(level, placePos, randomSource, treeConfiguration);
            if(placeCheck == height_main){
                placeLeavesBlob(level, placePos, randomSource, treeConfiguration);
            }
            placePos.move(Direction.UP);
            placeCheck = placeCheck + 1;
        }
        return true;
    }

    public void placeLog(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return;
        }
        if(level.getBlockState(pos).is(RuBlocks.PEAT_GRASS_BLOCK.get())){
            level.setBlock(pos, RuBlocks.PEAT_PODZOL.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.SILT_GRASS_BLOCK.get())){
            level.setBlock(pos, RuBlocks.SILT_PODZOL.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.ALPHA_GRASS_BLOCK.get())){
            level.setBlock(pos, Blocks.PODZOL.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(Blocks.GRASS_BLOCK)){
            level.setBlock(pos, Blocks.PODZOL.defaultBlockState(), 2);
        }
        else if(isReplaceable(level, pos)) {
            level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos), 2);
        }

        if(level.getBlockState(pos.below()).is(RuBlocks.PEAT_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), RuBlocks.PEAT_PODZOL.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.SILT_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), RuBlocks.SILT_PODZOL.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.ALPHA_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), Blocks.PODZOL.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK)){
            level.setBlock(pos.below(), Blocks.PODZOL.defaultBlockState(), 2);
        }
    }

    public void placeLeavesBlob(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        BlockPos.MutableBlockPos pos1 = pos.below(3).mutable();

        placeLeavesBlock(level, pos1, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.west(), randomSource, treeConfiguration);
        pos1.move(Direction.UP);

        placeLeavesBlock(level, pos1, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.west(), randomSource, treeConfiguration);
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos1.north().east(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos1.north().west(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos1.south().east(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos1.south().west(), randomSource, treeConfiguration);
        }
        pos1.move(Direction.UP);

        placeLeavesBlock(level, pos1, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south().west(), randomSource, treeConfiguration);
        pos1.move(Direction.UP);

        placeLeavesBlock(level, pos1, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.east(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.east(2).south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.west(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.west(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.west(2).south(), randomSource, treeConfiguration);
        pos1.move(Direction.UP);

        placeLeavesBlock(level, pos1, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south().west(), randomSource, treeConfiguration);
        pos1.move(Direction.UP);

        placeLeavesBlock(level, pos1, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.west(), randomSource, treeConfiguration);
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos1.north().east(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos1.north().west(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos1.south().east(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos1.south().west(), randomSource, treeConfiguration);
        }
        pos1.move(Direction.UP);

        placeLeavesBlock(level, pos1, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.west(), randomSource, treeConfiguration);
        pos1.move(Direction.UP);

        placeLeavesBlock(level, pos1, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.west(), randomSource, treeConfiguration);
        pos1.move(Direction.UP);

        placeLeavesBlock(level, pos1, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.above(), randomSource, treeConfiguration);
    }

    public boolean placeLeavesBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).canBeReplaced()) {
            level.setBlock(pos, treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        return true;
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
        return reader.isStateAtPosition(pos, BambooTreeFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, BambooTreeFeature::isReplaceableBlock);
    }
}