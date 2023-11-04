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
import net.regions_unexplored.world.level.block.wood.AspenLogBlock;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;

import java.util.Random;

public class AspenTreeFeature extends Feature<RuTreeConfiguration> {

    public AspenTreeFeature(Codec<RuTreeConfiguration> codec) {
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
            if(placeCheck == 0){
                placeRoot(level, placePos, randomSource, treeConfiguration);
            }
            if(placeCheck == height_main-2){
                placeStem(level, placePos, randomSource, treeConfiguration);
            }
            if(placeCheck == height_main){
                placeBranches(level, placePos, randomSource, treeConfiguration);
            }
            placePos.move(Direction.UP);
            placeCheck = placeCheck + 1;
        }
        return true;
    }

    public boolean placeStem(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        int move = randomSource.nextInt(3)-3;
        int rd = randomSource.nextInt(4);
        if(rd==0&&isReplaceable(level, pos.north())&&!level.isOutsideBuildHeight(pos.north())){
            if(randomSource.nextInt(3)!=0) {
                placeLog(level, pos.north(), randomSource, treeConfiguration, Direction.Axis.Z);
            }
            else {
                level.setBlock(pos.north(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.NORTH), 2);
                if(randomSource.nextInt(2)==0){
                    placeLeavesBlock(level, pos.north().above(), randomSource, treeConfiguration);
                    placeLeavesBlock(level, pos.north().north(), randomSource, treeConfiguration);
                    placeLeavesBlock(level, pos.north().east(), randomSource, treeConfiguration);
                    placeLeavesBlock(level, pos.north().west(), randomSource, treeConfiguration);
                }
            }

        }
        if(rd==1&&isReplaceable(level, pos.south())&&!level.isOutsideBuildHeight(pos.south())){
            if(randomSource.nextInt(3)!=0) {
                placeLog(level, pos.south(), randomSource, treeConfiguration, Direction.Axis.Z);
            }
            else {
                level.setBlock(pos.south(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.SOUTH), 2);
                if(randomSource.nextInt(2)==0){
                    placeLeavesBlock(level, pos.south().above(), randomSource, treeConfiguration);
                    placeLeavesBlock(level, pos.south().south(), randomSource, treeConfiguration);
                    placeLeavesBlock(level, pos.south().east(), randomSource, treeConfiguration);
                    placeLeavesBlock(level, pos.south().west(), randomSource, treeConfiguration);
                }
            }
        }
        if(rd==2&&isReplaceable(level, pos.east())&&!level.isOutsideBuildHeight(pos.east())){
            if(randomSource.nextInt(3)!=0) {
                placeLog(level, pos.east(), randomSource, treeConfiguration, Direction.Axis.X);
            }
            else {
                level.setBlock(pos.east(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.EAST), 2);
                if(randomSource.nextInt(2)==0){
                    placeLeavesBlock(level, pos.east().above(), randomSource, treeConfiguration);
                    placeLeavesBlock(level, pos.east().east(), randomSource, treeConfiguration);
                    placeLeavesBlock(level, pos.east().north(), randomSource, treeConfiguration);
                    placeLeavesBlock(level, pos.east().south(), randomSource, treeConfiguration);
                }
            }
        }
        if(rd==3&&isReplaceable(level, pos.west())&&!level.isOutsideBuildHeight(pos.west())){
            if(randomSource.nextInt(3)!=0) {
                placeLog(level, pos.west(), randomSource, treeConfiguration, Direction.Axis.X);
            }
            else {
                level.setBlock(pos.west(), treeConfiguration.branchProvider.getState(randomSource, pos).setValue(BranchBlock.FACING, Direction.WEST), 2);
                if(randomSource.nextInt(2)==0){
                    placeLeavesBlock(level, pos.west().above(), randomSource, treeConfiguration);
                    placeLeavesBlock(level, pos.west().west(), randomSource, treeConfiguration);
                    placeLeavesBlock(level, pos.west().north(), randomSource, treeConfiguration);
                    placeLeavesBlock(level, pos.west().south(), randomSource, treeConfiguration);
                }
            }
        }
        return true;
    }

    public boolean placeBranches(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        int type = randomSource.nextInt(3);
        BlockPos.MutableBlockPos placePos = pos.mutable();
        BlockPos.MutableBlockPos placePos2 = pos.mutable();

        Direction direction;
        Direction.Axis axis;
        int pickDirection = randomSource.nextInt(4);
        if(pickDirection==0){
            direction = Direction.NORTH;
            axis = Direction.Axis.Z;
        }
        else if(pickDirection==1){
            direction = Direction.SOUTH;
            axis = Direction.Axis.Z;
        }
        else if(pickDirection==2){
            direction = Direction.EAST;
            axis = Direction.Axis.X;
        }
        else{
            direction = Direction.WEST;
            axis = Direction.Axis.X;
        }

        if (type==0){
            int s = randomSource.nextInt(2);
            placePos2.move(direction.getOpposite());
            placeLog(level,placePos2,randomSource,treeConfiguration, axis);
            placeLeavesBlob(level,placePos2,randomSource,treeConfiguration);
            placePos.move(direction);
            placePos.move(Direction.UP);
            placeLog(level,placePos,randomSource,treeConfiguration, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLog(level,placePos,randomSource,treeConfiguration, Direction.Axis.Y);
            if(s != 0){
                placeLeavesBlob(level,placePos,randomSource,treeConfiguration);
            }
            else{
                placePos.move(Direction.UP);
                placeLog(level,placePos,randomSource,treeConfiguration, Direction.Axis.Y);
                placeLeavesBlob(level,placePos,randomSource,treeConfiguration);
            }
        }
        else if(type==1){
            placePos.move(direction);
            placePos.move(Direction.UP);
            placeLog(level,placePos,randomSource,treeConfiguration, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLog(level,placePos,randomSource,treeConfiguration, Direction.Axis.Y);
            placeLeavesBlob(level,placePos,randomSource,treeConfiguration);
        }
        else{
            placeLeavesBlob(level, pos, randomSource, treeConfiguration);
        }


        return true;
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

    public boolean placeLeavesBlob(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        placeLeavesBlock(level, pos, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);
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
        placeLeavesBlock(level, pos.above().north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().south().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.above().above(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().above().north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().above().south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().above().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().above().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.above().above().above(), randomSource, treeConfiguration);
        if(random.nextInt(2)==0) {
            placeLeavesBlock(level, pos.above().above().above().north(), randomSource, treeConfiguration);
        }
        if(random.nextInt(2)==0) {
            placeLeavesBlock(level, pos.above().above().above().south(), randomSource, treeConfiguration);
        }
        if(random.nextInt(2)==0) {
            placeLeavesBlock(level, pos.above().above().above().east(), randomSource, treeConfiguration);
        }
        if(random.nextInt(2)==0) {
            placeLeavesBlock(level, pos.above().above().above().west(), randomSource, treeConfiguration);
        }
        return true;
    }

    public boolean placeLog(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration, Direction.Axis axis) {
        boolean isBase = false;
        if(level.getBlockState(pos.below()).is(BlockTags.DIRT)){
            isBase = true;
        }
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
            if(treeConfiguration.trunkProvider.getState(randomSource, pos).getBlock() instanceof AspenLogBlock){
                level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos).setValue(RotatedPillarBlock.AXIS, axis).setValue(AspenLogBlock.IS_BASE, isBase), 2);
            }
            else{
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
        return reader.isStateAtPosition(pos, AspenTreeFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, AspenTreeFeature::isReplaceableBlock);
    }
}