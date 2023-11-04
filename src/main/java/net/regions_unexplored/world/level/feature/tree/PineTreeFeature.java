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
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.world.level.block.plant.branch.BranchBlock;
import net.regions_unexplored.world.level.block.wood.PineLogBlock;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;

import java.util.Random;

public class PineTreeFeature extends Feature<RuTreeConfiguration> {

    public PineTreeFeature(Codec<RuTreeConfiguration> codec) {
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
            if(check == height_main/2){
                if(!checkReplaceableBlob(level, checkPos)){
                    return false;
                }
            }
            if(!checkReplaceable(level, checkPos)){
                return false;
            }
            else{
                checkPos.move(Direction.UP);
                check = check + 1;
            }
        }
        int placeCheck = 0;
        int rnd = randomSource.nextInt(2)+4;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while (placeCheck <= height_main) {
            if(placeCheck<(height_main/rnd)){
                placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y, false, false);
            }
            else if(placeCheck==(height_main/rnd)){
                placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y, false, false);
            }
            else{
                placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y, false, false);
                placeBranchDecorator(level, placePos, randomSource, treeConfiguration);
            }
            if(placeCheck == 0){
                placeRoot(level, placePos, randomSource, treeConfiguration);
            }
            if(placeCheck == height_main){
                if(randomSource.nextInt(11)==0){
                    placeTop3(level, placePos, randomSource, treeConfiguration);
                }
                else if(randomSource.nextInt(11)<=5){
                    placeTop2(level, placePos, randomSource, treeConfiguration);
                }
                else{
                    placeTop1(level, placePos, randomSource, treeConfiguration);
                }
            }
            placePos.move(Direction.UP);
            placeCheck = placeCheck + 1;
        }
        return true;
    }

    public void placeTop1(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        BlockPos.MutableBlockPos placePos = new BlockPos.MutableBlockPos(pos.getX(),pos.getY()-randomSource.nextInt(2),pos.getZ());
        placeBlobTop(level,placePos,randomSource,treeConfiguration);
        placePos.move(Direction.DOWN);
        placeBlobXSmall(level,placePos,randomSource,treeConfiguration);
        placePos.move(Direction.DOWN);
        placeBlobSmall(level,placePos,randomSource,treeConfiguration);
        placePos.move(Direction.DOWN);
        placeBlobMed(level,placePos,randomSource,treeConfiguration);
        placePos.move(Direction.DOWN);
        placeBlobXSmall(level,placePos,randomSource,treeConfiguration);
        placePos.move(Direction.DOWN);
        placeBlobBig(level,placePos,randomSource,treeConfiguration);
        placePos.move(Direction.DOWN);
        placeBlobMed(level,placePos,randomSource,treeConfiguration);
        if(randomSource.nextInt(3)==0){
            placeBlobXBig(level,placePos,randomSource,treeConfiguration);
        }
        placePos.move(Direction.DOWN);
        placeBlobXSmall(level,placePos,randomSource,treeConfiguration);

        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, placePos.north().east(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, placePos.north().west(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, placePos.south().east(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, placePos.south().west(), randomSource, treeConfiguration);
        }

    }
    public void placeTop2(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        BlockPos.MutableBlockPos placePos = new BlockPos.MutableBlockPos(pos.getX(),pos.getY()-randomSource.nextInt(2),pos.getZ());
        placeBlobTop(level,placePos,randomSource,treeConfiguration);
        placeBlobXSmall(level,placePos,randomSource,treeConfiguration);
        placePos.move(Direction.DOWN);
        placeBlobSmall(level,placePos,randomSource,treeConfiguration);
        placePos.move(Direction.DOWN);
        placeBlobMed(level,placePos,randomSource,treeConfiguration);
        placePos.move(Direction.DOWN);
        placeBlobXSmall(level,placePos,randomSource,treeConfiguration);
        placePos.move(Direction.DOWN);
        placeBlobMed(level,placePos,randomSource,treeConfiguration);
        placePos.move(Direction.DOWN);
        placeBlobBig(level,placePos,randomSource,treeConfiguration);
        placePos.move(Direction.DOWN);
        placeBlobSmall(level,placePos,randomSource,treeConfiguration);
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, placePos.north(2), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, placePos.north(2), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, placePos.south(2), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, placePos.south(2), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0){
            placeBlobXBig(level,placePos,randomSource,treeConfiguration);
        }
        placePos.move(Direction.DOWN);
        placeBlobXSmall(level,placePos,randomSource,treeConfiguration);
    }
    public void placeTop3(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        BlockPos.MutableBlockPos placePos = new BlockPos.MutableBlockPos(pos.getX(),pos.getY()-randomSource.nextInt(2),pos.getZ());
        placeBlobTop(level,placePos,randomSource,treeConfiguration);
        placeBlobXSmall(level,placePos,randomSource,treeConfiguration);
        placePos.move(Direction.DOWN);
        placeBlobXSmall(level,placePos,randomSource,treeConfiguration);
        if(randomSource.nextInt(3)==0){
            placePos.move(Direction.DOWN);
            placeBlobXSmall(level,placePos,randomSource,treeConfiguration);
        }
        placePos.move(Direction.DOWN);
        placeBlobXSmall(level,placePos,randomSource,treeConfiguration);
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, placePos.north().east(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, placePos.north().west(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, placePos.south().east(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, placePos.south().west(), randomSource, treeConfiguration);
        }
        placePos.move(Direction.DOWN);
        placeBlobXSmall(level,placePos,randomSource,treeConfiguration);
        placePos.move(Direction.DOWN);
        placePos.move(Direction.DOWN);
        if(randomSource.nextInt(2)==0){
            placePos.move(Direction.DOWN);
        }
        placeRandomLogDecoration(level,placePos,randomSource,treeConfiguration);

    }

    public void placeRandomLogDecoration(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        int chance = randomSource.nextInt(10);
        if(chance==0){
            placeLog(level, pos.north(), randomSource, treeConfiguration, Direction.Axis.Z, false, false);
        }
        else if(chance==1){
            placeLog(level, pos.south(), randomSource, treeConfiguration, Direction.Axis.Z, false, false);
        }
        else if(chance==2){
            placeLog(level, pos.east(), randomSource, treeConfiguration, Direction.Axis.X, false, false);
        }
        else if(chance==3){
            placeLog(level, pos.west(), randomSource, treeConfiguration, Direction.Axis.X, false, false);
        }
        else{
            return;
        }
    }

    public void placeBlobTop(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        placeLeavesBlock(level,pos.above(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above(2),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above(3),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().north(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().south(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().west(),randomSource,treeConfiguration);
    }

    public void placeBlobXBig(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        placeLeavesBlock(level, pos, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.north(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.north(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2).south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2).south(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.north(2).east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).west(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).west(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(3).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(3).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(3).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(3).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(3).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(3).south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(3).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(3).south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(3), randomSource, treeConfiguration);
    }

    public void placeBlobBig(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        placeLeavesBlock(level, pos, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.north(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.north(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2).south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2).south(), randomSource, treeConfiguration);
    }

    public void placeBlobMed(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        placeLeavesBlock(level, pos, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.north(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2), randomSource, treeConfiguration);
    }

    public void placeBlobSmall(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        placeLeavesBlock(level, pos, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().west(), randomSource, treeConfiguration);
    }

    public void placeBlobXSmall(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        placeLeavesBlock(level, pos, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);
    }

    public boolean placeLog(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration, Direction.Axis axis, boolean isStripped, boolean isTransition) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return true;
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
            if(treeConfiguration.trunkProvider.getState(randomSource, pos).getBlock() instanceof PineLogBlock){
                level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos).setValue(RotatedPillarBlock.AXIS, axis).setValue(PineLogBlock.IS_STRIPPED, isStripped).setValue(PineLogBlock.TRANSITION_BLOCK, isTransition), 2);
            }
            else {
                level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos).setValue(RotatedPillarBlock.AXIS, axis), 2);
            }
        }
        else{
            return true;
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
        return true;
    }

    public void placeBranchDecorator(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        if(randomSource.nextInt(10)==0){
            int rd = random.nextInt(4);
            if(rd==0){
                placeNorthBranch(level, pos, randomSource, treeConfiguration);
            }
            else if(rd==1){
                placeSouthBranch(level, pos, randomSource, treeConfiguration);
            }
            else if(rd==2){
                placeEastBranch(level, pos, randomSource, treeConfiguration);
            }
            else {
                placeWestBranch(level, pos, randomSource, treeConfiguration);
            }
        }
    }
    public void placeNorthBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.north()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north())){
            level.setBlock(pos.north(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.NORTH), 2);
        }
        if(level.getBlockState(pos.north().above()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north().above())){
            level.setBlock(pos.north().above(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.north().north()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north().north())){
            level.setBlock(pos.north().north(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.north().east()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north().east())){
            level.setBlock(pos.north().east(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.north().west()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north().west())){
            level.setBlock(pos.north().west(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }
    public void placeSouthBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.south()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south())){
            level.setBlock(pos.south(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.SOUTH), 2);
        }
        if(level.getBlockState(pos.south().above()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south().above())){
            level.setBlock(pos.south().above(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.south().south()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south().south())){
            level.setBlock(pos.south().south(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.south().east()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south().east())){
            level.setBlock(pos.south().east(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.south().west()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south().west())){
            level.setBlock(pos.south().west(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }
    public void placeEastBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.east()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east())){
            level.setBlock(pos.east(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.EAST), 2);
        }
        if(level.getBlockState(pos.east().above()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east().above())){
            level.setBlock(pos.east().above(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.east().east()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east().east())){
            level.setBlock(pos.east().east(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.east().south()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east().south())){
            level.setBlock(pos.east().south(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.east().north()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east().north())){
            level.setBlock(pos.east().north(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }
    public void placeWestBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.west()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west())){
            level.setBlock(pos.west(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.WEST), 2);
        }
        if(level.getBlockState(pos.west().above()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west().above())){
            level.setBlock(pos.west().above(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.west().west()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west().west())){
            level.setBlock(pos.west().west(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.west().south()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west().south())){
            level.setBlock(pos.west().south(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.west().north()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west().north())){
            level.setBlock(pos.west().north(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }

    public void placeRoot(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        int rd = random.nextInt(2)+4;
        int i = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while(i<=rd){
            if(level.getBlockState(placePos).canBeReplaced()&&level.getBlockState(placePos.above()).is(BlockTags.DIRT)){
                level.setBlock(placePos, Blocks.HANGING_ROOTS.defaultBlockState(), 2);
                break;
            }
            else if(level.getBlockState(placePos).is(BlockTags.DIRT)||level.getBlockState(placePos).is(BlockTags.REPLACEABLE_BY_TREES)||level.isEmptyBlock(placePos)){
                placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y,false,false);
            }
            else{
                break;
            }
            placePos.move(Direction.DOWN);
            i++;
        }
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


    public boolean checkReplaceableBlob(LevelAccessor level, BlockPos pos) {
        if(!checkReplaceable(level, pos.north())){
            return false;
        }
        if(!checkReplaceable(level, pos.south())){
            return false;
        }
        if(!checkReplaceable(level, pos.east())){
            return false;
        }
        if(!checkReplaceable(level, pos.west())){
            return false;
        }

        if(!checkReplaceable(level, pos.north().east())){
            return false;
        }
        if(!checkReplaceable(level, pos.north().west())){
             return false;
        }
        if(!checkReplaceable(level, pos.south().east())){
             return false;
        }
        if(!checkReplaceable(level, pos.south().west())){
             return false;
        }

        if(!checkReplaceable(level, pos.north(2))){
             return false;
        }
        if(!checkReplaceable(level, pos.south(2))){
             return false;
        }
        if(!checkReplaceable(level, pos.east(2))){
             return false;
        }
        if(!checkReplaceable(level, pos.west(2))){
             return false;
        }

        if(!checkReplaceable(level, pos.north(2).east())){
             return false;
        }
        if(!checkReplaceable(level, pos.north(2).west())){
             return false;
        }
        if(!checkReplaceable(level, pos.south(2).east())){
             return false;
        }
        if(!checkReplaceable(level, pos.south(2).west())){
             return false;
        }
        if(!checkReplaceable(level, pos.east(2).north())){
             return false;
        }
        if(!checkReplaceable(level, pos.east(2).south())){
             return false;
        }
        if(!checkReplaceable(level, pos.west(2).north())){
             return false;
        }
        if(!checkReplaceable(level, pos.west(2).south())){
             return false;
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
        return reader.isStateAtPosition(pos, PineTreeFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, PineTreeFeature::isReplaceableBlock);
    }
}