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

public class DeadTreeFeature extends Feature<RuTreeConfiguration> {

    public DeadTreeFeature(Codec<RuTreeConfiguration> codec) {
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
            if(placeCheck>2){
                placeLeafDecorator(level, placePos, randomSource, treeConfiguration);
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
        BlockPos.MutableBlockPos placePos = new BlockPos.MutableBlockPos(pos.getX(),pos.getY()-(randomSource.nextInt(2)+3),pos.getZ());
        int i = randomSource.nextInt(5);

        placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above(), randomSource, treeConfiguration);
        if(i==0){
            placeLog(level, placePos.north(), randomSource, treeConfiguration, Direction.NORTH.getAxis());
        }
        else if(i==1){
            placeLog(level, placePos.south(), randomSource, treeConfiguration, Direction.SOUTH.getAxis());
        }
        else if(i==2){
            placeLog(level, placePos.east(), randomSource, treeConfiguration, Direction.EAST.getAxis());
        }
        else if(i==3){
            placeLog(level, placePos.west(), randomSource, treeConfiguration, Direction.WEST.getAxis());
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
        if(randomSource.nextInt(3)==0){
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

    public void placeLeafDecorator(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        int n = random.nextInt(2);
        int s = random.nextInt(2);
        int e = random.nextInt(2);
        int w = random.nextInt(2);
        if(n==0){
            placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        }
        if(s==0){
            placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        }
        if(e==0){
            placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);
        }
        if(w==0) {
            placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);
        }
    }

    public void placeNorthBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.north()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north())){
            level.setBlock(pos.north(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.NORTH), 2);
        }
    }
    public void placeSouthBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.south()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south())){
            level.setBlock(pos.south(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.SOUTH), 2);
        }
    }
    public void placeEastBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.east()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east())){
            level.setBlock(pos.east(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.EAST), 2);
        }
    }
    public void placeWestBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.getBlockState(pos.west()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west())){
            level.setBlock(pos.west(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.WEST), 2);
        }
    }

    public void placeRoot(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        int rd = random.nextInt(2)+2;
        int i = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while(i<=rd){
            if(level.getBlockState(placePos).canBeReplaced()&&level.getBlockState(placePos.above()).is(BlockTags.DIRT)){
                level.setBlock(placePos, Blocks.HANGING_ROOTS.defaultBlockState(), 2);
                break;
            }
            else if(level.getBlockState(placePos).is(BlockTags.DIRT)||level.getBlockState(placePos).is(BlockTags.REPLACEABLE_BY_TREES)||level.isEmptyBlock(placePos)){
                placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
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
        return reader.isStateAtPosition(pos, DeadTreeFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, DeadTreeFeature::isReplaceableBlock);
    }
}