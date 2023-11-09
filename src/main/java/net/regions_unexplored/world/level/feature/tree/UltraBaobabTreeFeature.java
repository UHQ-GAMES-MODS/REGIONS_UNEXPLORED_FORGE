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

public class UltraBaobabTreeFeature extends Feature<RuTreeConfiguration> {

    public UltraBaobabTreeFeature(Codec<RuTreeConfiguration> codec) {
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
            if(!checkReplaceable(level, checkPos.north())){
                return false;
            }
            if(!checkReplaceable(level, checkPos.east())){
                return false;
            }
            if(!checkReplaceable(level, checkPos.south())){
                return false;
            }
            if(!checkReplaceable(level, checkPos.west())){
                return false;
            }
            if(!checkReplaceable(level, checkPos.north().east())){
                return false;
            }
            if(!checkReplaceable(level, checkPos.north().west())){
                return false;
            }
            if(!checkReplaceable(level, checkPos.south().east())){
                return false;
            }
            if(!checkReplaceable(level, checkPos.south().west())){
                return false;
            }
            checkPos.move(Direction.UP);
            check = check + 1;
        }
        int placeCheck = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while (placeCheck <= height_main) {

            if(placeCheck == 0){
                placeRoot(level, placePos, randomSource, treeConfiguration);
                placeRoot(level, placePos.north(), randomSource, treeConfiguration);
                placeRoot(level, placePos.south(), randomSource, treeConfiguration);
                placeRoot(level, placePos.east(), randomSource, treeConfiguration);
                placeRoot(level, placePos.west(), randomSource, treeConfiguration);
                placeRoot(level, placePos.north().east(), randomSource, treeConfiguration);
                placeRoot(level, placePos.north().west(), randomSource, treeConfiguration);
                placeRoot(level, placePos.south().east(), randomSource, treeConfiguration);
                placeRoot(level, placePos.south().west(), randomSource, treeConfiguration);
            }
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placeLog(level, placePos.north(), randomSource, treeConfiguration, Direction.Axis.Y);
            placeLog(level, placePos.south(), randomSource, treeConfiguration, Direction.Axis.Y);
            placeLog(level, placePos.east(), randomSource, treeConfiguration, Direction.Axis.Y);
            placeLog(level, placePos.west(), randomSource, treeConfiguration, Direction.Axis.Y);
            placeLog(level, placePos.north().east(), randomSource, treeConfiguration, Direction.Axis.Y);
            placeLog(level, placePos.north().west(), randomSource, treeConfiguration, Direction.Axis.Y);
            placeLog(level, placePos.south().east(), randomSource, treeConfiguration, Direction.Axis.Y);
            placeLog(level, placePos.south().west(), randomSource, treeConfiguration, Direction.Axis.Y);
            if(placeCheck==height_main){
                placeTop(level, placePos, randomSource, treeConfiguration);
            }
            placePos.move(Direction.UP);
            placeCheck = placeCheck + 1;
        }
        return true;
    }

    public void placeTop(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        BlockPos pos1 = pos.above();
        placeLog(level,pos1,randomSource,treeConfiguration,Direction.Axis.Y);

        placeLog(level,pos1.north(),randomSource,treeConfiguration,Direction.Axis.Y);
        placeBranch(level,pos1.north(),randomSource,treeConfiguration,Direction.NORTH);

        placeLog(level,pos1.south(),randomSource,treeConfiguration,Direction.Axis.Y);
        placeBranch(level,pos1.south(),randomSource,treeConfiguration,Direction.SOUTH);

        placeLog(level,pos1.east(),randomSource,treeConfiguration,Direction.Axis.Y);
        placeBranch(level,pos1.east(),randomSource,treeConfiguration,Direction.EAST);

        placeLog(level,pos1.west(),randomSource,treeConfiguration,Direction.Axis.Y);
        placeBranch(level,pos1.west(),randomSource,treeConfiguration,Direction.WEST);
    }

    public void placeBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration, Direction direction) {
        BlockPos.MutableBlockPos placePos = pos.mutable();
        Direction.Axis axis = Direction.Axis.Y;
        if(direction==Direction.NORTH||direction==Direction.SOUTH){
            axis = Direction.Axis.Z;
        }
        else if(direction==Direction.EAST||direction==Direction.WEST){
            axis = Direction.Axis.X;
        }
        int type = randomSource.nextInt(8);
        if(type==0){
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placePos.move(Direction.UP);
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placeLeavesBlob(level,placePos, randomSource, treeConfiguration);
        }
        else if(type==1){
            placePos.move(Direction.UP);
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placePos.move(Direction.UP);
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placeLeavesBlob(level,placePos, randomSource, treeConfiguration);
        }
        else if(type==2){
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placePos.move(Direction.UP);
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placeLeavesBlob(level,placePos, randomSource, treeConfiguration);
        }
        else if(type==3){
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placePos.move(Direction.UP);
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placeLeavesBlob(level,placePos, randomSource, treeConfiguration);
        }
        else if(type==4){
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placePos.move(Direction.UP);
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placeLeavesBlob(level,placePos, randomSource, treeConfiguration);
        }
        else if(type==5){
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placePos.move(Direction.UP);
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placePos.move(Direction.UP);
            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            placeLeavesBlob(level,placePos, randomSource, treeConfiguration);
        }
        else if(type==6){
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placeLeavesBlob(level,placePos, randomSource, treeConfiguration);
        }
        else if(type==7){
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placePos.move(direction);
            placeLog(level, placePos, randomSource, treeConfiguration, axis);
            placeLeavesBlob(level,placePos, randomSource, treeConfiguration);
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
        placeNorthBranch(level, pos, randomSource, treeConfiguration);
        placeSouthBranch(level, pos, randomSource, treeConfiguration);
        placeEastBranch(level, pos, randomSource, treeConfiguration);
        placeWestBranch(level, pos, randomSource, treeConfiguration);
    }
    public void placeNorthBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos), 2);
        if(level.getBlockState(pos.north()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north())){
            level.setBlock(pos.north(), treeConfiguration.branchProvider.getState(randomSource, pos.north()).setValue(BranchBlock.FACING, Direction.NORTH), 2);
        }
        if(level.getBlockState(pos.north().above()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north().above())){
            level.setBlock(pos.north().above(), treeConfiguration.foliageProvider.getState(randomSource, pos.north().above()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.north().north()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north().north())){
            level.setBlock(pos.north().north(), treeConfiguration.foliageProvider.getState(randomSource, pos.north().north()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.north().east()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north().east())){
            level.setBlock(pos.north().east(), treeConfiguration.foliageProvider.getState(randomSource, pos.north().east()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.north().west()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.north().west())){
            level.setBlock(pos.north().west(), treeConfiguration.foliageProvider.getState(randomSource, pos.north().west()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }
    public void placeSouthBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos), 2);
        if(level.getBlockState(pos.south()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south())){
            level.setBlock(pos.south(), treeConfiguration.branchProvider.getState(randomSource, pos.south()).setValue(BranchBlock.FACING, Direction.SOUTH), 2);
        }
        if(level.getBlockState(pos.south().above()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south().above())){
            level.setBlock(pos.south().above(), treeConfiguration.foliageProvider.getState(randomSource, pos.south().above()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.south().south()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south().south())){
            level.setBlock(pos.south().south(), treeConfiguration.foliageProvider.getState(randomSource, pos.south().south()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.south().east()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south().east())){
            level.setBlock(pos.south().east(), treeConfiguration.foliageProvider.getState(randomSource, pos.south().east()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.south().west()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.south().west())){
            level.setBlock(pos.south().west(), treeConfiguration.foliageProvider.getState(randomSource, pos.south().west()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }
    public void placeEastBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos), 2);
        if(level.getBlockState(pos.east()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east())){
            level.setBlock(pos.east(), treeConfiguration.branchProvider.getState(randomSource, pos.east()).setValue(BranchBlock.FACING, Direction.EAST), 2);
        }
        if(level.getBlockState(pos.east().above()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east().above())){
            level.setBlock(pos.east().above(), treeConfiguration.foliageProvider.getState(randomSource, pos.east().above()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.east().east()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east().east())){
            level.setBlock(pos.east().east(), treeConfiguration.foliageProvider.getState(randomSource, pos.east().east()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.east().south()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east().south())){
            level.setBlock(pos.east().south(), treeConfiguration.foliageProvider.getState(randomSource, pos.east().south()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.east().north()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.east().north())){
            level.setBlock(pos.east().north(), treeConfiguration.foliageProvider.getState(randomSource, pos.east().north()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }

    }
    public void placeWestBranch(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos), 2);
        if(level.getBlockState(pos.west()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west())){
            level.setBlock(pos.west(), treeConfiguration.branchProvider.getState(randomSource, pos.west()).setValue(BranchBlock.FACING, Direction.WEST), 2);
        }
        if(level.getBlockState(pos.west().above()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west().above())){
            level.setBlock(pos.west().above(), treeConfiguration.foliageProvider.getState(randomSource, pos.west().above()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.west().west()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west().west())){
            level.setBlock(pos.west().west(), treeConfiguration.foliageProvider.getState(randomSource, pos.west().west()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.west().south()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west().south())){
            level.setBlock(pos.west().south(), treeConfiguration.foliageProvider.getState(randomSource, pos.west().south()).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        if(level.getBlockState(pos.west().north()).canBeReplaced()&&!level.isOutsideBuildHeight(pos.west().north())){
            level.setBlock(pos.west().north(), treeConfiguration.foliageProvider.getState(randomSource, pos.west().north()).setValue(LeavesBlock.DISTANCE, 1), 2);
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
                placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            }
            else{
                break;
            }
            placePos.move(Direction.DOWN);
            i++;
        }
    }

    public void placeLeavesBlob(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        int n = random.nextInt(3);

        placeBranchDecorator(level, pos, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.north(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(3).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(3).west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.south(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(3).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(3).west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2).south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(3).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(3).south(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.west(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2).south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(3).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(3).south(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.north(2).east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).west(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).west(2), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.above(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().north(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().south(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().west(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above().south().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos.below(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().west(), randomSource, treeConfiguration);
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
        return reader.isStateAtPosition(pos, UltraBaobabTreeFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, UltraBaobabTreeFeature::isReplaceableBlock);
    }
}