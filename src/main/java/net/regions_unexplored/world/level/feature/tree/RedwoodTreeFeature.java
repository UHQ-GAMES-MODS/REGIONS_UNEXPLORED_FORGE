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
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;

import java.util.Random;

public class RedwoodTreeFeature extends Feature<RuTreeConfiguration> {

    public RedwoodTreeFeature(Codec<RuTreeConfiguration> codec) {
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
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            if(placeCheck>5){
                placeBranchDecorator(level, placePos, randomSource, treeConfiguration);
            }
            if(placeCheck == 0){
                placeRoot(level, placePos, randomSource, treeConfiguration);
            }
            if(placeCheck == height_main){
                placeTop(level, placePos, randomSource, treeConfiguration);
            }
            placePos.move(Direction.UP);
            placeCheck = placeCheck + 1;
        }
        return true;
    }

    public void placeTop(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        BlockPos.MutableBlockPos placePos = new BlockPos.MutableBlockPos(pos.getX(),pos.getY()-3,pos.getZ());
        placeLeavesBlob(level, pos, randomSource, treeConfiguration);
        placeBranchesShort(level, placePos, randomSource, treeConfiguration);
        placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
        placeBranchesShort(level, placePos, randomSource, treeConfiguration);
        placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
        placeBranchesLong(level, placePos, randomSource, treeConfiguration);
        placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
        placeBranchesLong(level, placePos, randomSource, treeConfiguration);
        placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
        placeBranchesLong(level, placePos, randomSource, treeConfiguration);
    }

    public void placeBranchesShort(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        int type = randomSource.nextInt(2);
        if(type==0){
            placeLog(level, pos.north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.north(), randomSource, treeConfiguration);

            placeLog(level, pos.south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.south(), randomSource, treeConfiguration);

            placeLog(level, pos.below().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.below().east(), randomSource, treeConfiguration);

            placeLog(level, pos.below().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.below().west(), randomSource, treeConfiguration);
        }
        else{
            placeLog(level, pos.below().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.below().north(), randomSource, treeConfiguration);

            placeLog(level, pos.below().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.below().south(), randomSource, treeConfiguration);

            placeLog(level, pos.east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.east(), randomSource, treeConfiguration);

            placeLog(level, pos.west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.west(), randomSource, treeConfiguration);
        }
    }

    public void placeBranchesLong(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        int type = randomSource.nextInt(2);
        if(type==0){
            placeLog(level, pos.north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.north().north(), randomSource, treeConfiguration);

            placeLog(level, pos.south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.south().south(), randomSource, treeConfiguration);

            placeLog(level, pos.below().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.below().east().east(), randomSource, treeConfiguration);

            placeLog(level, pos.below().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.below().west().west(), randomSource, treeConfiguration);
        }
        else{
            placeLog(level, pos.below().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.below().north().north(), randomSource, treeConfiguration);

            placeLog(level, pos.below().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.below().south().south(), randomSource, treeConfiguration);

            placeLog(level, pos.east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.east().east(), randomSource, treeConfiguration);

            placeLog(level, pos.west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.west().west(), randomSource, treeConfiguration);
        }
    }

    public boolean placeLog(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration, Direction.Axis axis) {
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
            level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos).setValue(RotatedPillarBlock.AXIS, axis), 2);
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
        if(level.getBlockState(pos.north()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.north())){
            level.setBlock(pos.north(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.NORTH), 2);
        }
        if(level.getBlockState(pos.north().above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.north().above())){
            level.setBlock(pos.north().above(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.north().north()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.north().north())){
            level.setBlock(pos.north().north(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.north().east()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.north().east())){
            level.setBlock(pos.north().east(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.north().west()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.north().west())){
            level.setBlock(pos.north().west(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }
    public void placeSouthBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.south()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.south())){
            level.setBlock(pos.south(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.SOUTH), 2);
        }
        if(level.getBlockState(pos.south().above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.south().above())){
            level.setBlock(pos.south().above(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.south().south()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.south().south())){
            level.setBlock(pos.south().south(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.south().east()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.south().east())){
            level.setBlock(pos.south().east(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.south().west()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.south().west())){
            level.setBlock(pos.south().west(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }
    public void placeEastBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.east()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.east())){
            level.setBlock(pos.east(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.EAST), 2);
        }
        if(level.getBlockState(pos.east().above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.east().above())){
            level.setBlock(pos.east().above(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.east().east()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.east().east())){
            level.setBlock(pos.east().east(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.east().south()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.east().south())){
            level.setBlock(pos.east().south(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.east().north()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.east().north())){
            level.setBlock(pos.east().north(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }
    public void placeWestBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.west()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.west())){
            level.setBlock(pos.west(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.WEST), 2);
        }
        if(level.getBlockState(pos.west().above()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.west().above())){
            level.setBlock(pos.west().above(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.west().west()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.west().west())){
            level.setBlock(pos.west().west(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.west().south()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.west().south())){
            level.setBlock(pos.west().south(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.west().north()).getMaterial().isReplaceable()&&!level.isOutsideBuildHeight(pos.west().north())){
            level.setBlock(pos.west().north(), treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }

    public void placeRoot(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        int rd = random.nextInt(2)+4;
        int i = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while(i<=rd){
            if(level.getBlockState(placePos).getMaterial().isReplaceable()&&level.getBlockState(placePos.above()).is(BlockTags.DIRT)){
                level.setBlock(placePos, Blocks.HANGING_ROOTS.defaultBlockState(), 2);
                break;
            }
            else if(level.getBlockState(placePos).is(BlockTags.DIRT)||level.getBlockState(placePos).is(RuTags.REPLACEABLE_BLOCKS)||level.isEmptyBlock(placePos)){
                placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            }
            else{
                break;
            }
            placePos.move(Direction.DOWN);
            i++;
        }
    }

    public boolean placeLeavesBlob(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        int n = random.nextInt(3);

        placeLeavesBlock(level, pos, randomSource, treeConfiguration);

        placeLeavesBlock(level, pos, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.above(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().west(), randomSource, treeConfiguration);
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos.above().north().east(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos.above().north().west(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos.above().south().east(), randomSource, treeConfiguration);
        }
        if(randomSource.nextInt(3)==0) {
            placeLeavesBlock(level, pos.above().south().west(), randomSource, treeConfiguration);
        }

        placeLeavesBlock(level, pos.above().above(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().above().north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().above().south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().above().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().above().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.below(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.above().above().above(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().above().above().above(), randomSource, treeConfiguration);
        return true;
    }

    public boolean placeLeavesBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).getMaterial().isReplaceable()) {
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
        return reader.isStateAtPosition(pos, RedwoodTreeFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, RedwoodTreeFeature::isReplaceableBlock);
    }
}