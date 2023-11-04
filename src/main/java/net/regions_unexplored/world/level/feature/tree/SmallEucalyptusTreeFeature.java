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
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.world.level.block.plant.branch.BranchBlock;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;

import java.util.Random;

public class SmallEucalyptusTreeFeature extends Feature<RuTreeConfiguration> {

    public SmallEucalyptusTreeFeature(Codec<RuTreeConfiguration> codec) {
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
            if(placeCheck>3){
                placeBranchDecorator(level, placePos, randomSource, treeConfiguration);
            }
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
            level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos), 2);
        }

        if(level.getBlockState(pos.below()).is(RuBlocks.PEAT_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), RuBlocks.PEAT_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.SILT_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), RuBlocks.SILT_PODZOL.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.ALPHA_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), Blocks.DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK)){
            level.setBlock(pos.below(), Blocks.DIRT.defaultBlockState(), 2);
        }
    }

    public void placeBranchDecorator(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        if(randomSource.nextInt(8)==0){
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

    private static void addHangingVine(LevelAccessor level, BlockPos pos, RandomSource randomSource, BooleanProperty bp) {
        if(randomSource.nextInt(3)!=0) {
            level.setBlock(pos, Blocks.VINE.defaultBlockState().setValue(bp, true), 2);
            int i = randomSource.nextInt(3)+3;

            for (BlockPos blockpos = pos.below(); level.getBlockState(blockpos).isAir() && i > 0; --i) {
                level.setBlock(blockpos, Blocks.VINE.defaultBlockState().setValue(bp, true), 2);
                blockpos = blockpos.below();
            }
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
        addHangingVine(level, pos1.north(3), randomSource, VineBlock.SOUTH);
        addHangingVine(level, pos1.north(3).east(), randomSource, VineBlock.SOUTH);
        addHangingVine(level, pos1.north(3).west(), randomSource, VineBlock.SOUTH);

        placeLeavesBlock(level, pos1.south(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.south(2).west(), randomSource, treeConfiguration);
        addHangingVine(level, pos1.south(3), randomSource, VineBlock.NORTH);
        addHangingVine(level, pos1.south(3).east(), randomSource, VineBlock.NORTH);
        addHangingVine(level, pos1.south(3).west(), randomSource, VineBlock.NORTH);

        placeLeavesBlock(level, pos1.east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.east(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.east(2).south(), randomSource, treeConfiguration);
        addHangingVine(level, pos1.east(3), randomSource, VineBlock.WEST);
        addHangingVine(level, pos1.east(3).north(), randomSource, VineBlock.WEST);
        addHangingVine(level, pos1.east(3).south(), randomSource, VineBlock.WEST);

        placeLeavesBlock(level, pos1.west(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.west(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos1.west(2).south(), randomSource, treeConfiguration);
        addHangingVine(level, pos1.west(3), randomSource, VineBlock.EAST);
        addHangingVine(level, pos1.west(3).north(), randomSource, VineBlock.EAST);
        addHangingVine(level, pos1.west(3).south(), randomSource, VineBlock.EAST);

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
        return reader.isStateAtPosition(pos, SmallEucalyptusTreeFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, SmallEucalyptusTreeFeature::isReplaceableBlock);
    }
}