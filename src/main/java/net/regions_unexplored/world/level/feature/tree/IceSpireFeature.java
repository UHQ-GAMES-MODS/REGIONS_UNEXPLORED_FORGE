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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;

import java.util.Random;

public class IceSpireFeature extends Feature<RuTreeConfiguration> {

    public IceSpireFeature(Codec<RuTreeConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<RuTreeConfiguration> context) {
        RuTreeConfiguration treeConfiguration = context.config();
        BlockPos pos = context.origin();
        RandomSource randomSource = context.random();
        WorldGenLevel level = context.level();
        int height_main = context.random().nextInt(treeConfiguration.sizeVariation) + treeConfiguration.minimumSize;
        int height_2n = height_main>10 ? (height_main/2)+randomSource.nextInt(3) : (height_main/2);
        int height_2s = height_main>10 ? (height_main/2)+randomSource.nextInt(3) : (height_main/2);
        int height_2e = height_main>10 ? (height_main/2)+randomSource.nextInt(3) : (height_main/2);
        int height_2w = height_main>10 ? (height_main/2)+randomSource.nextInt(3) : (height_main/2);
        int height_ne = randomSource.nextInt(5);
        int height_nw = randomSource.nextInt(5);
        int height_se = randomSource.nextInt(5);
        int height_sw = randomSource.nextInt(5);

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
        if(randomSource.nextInt(2)==0){
            generateSmallSpire(level,pos,randomSource,treeConfiguration);
            return true;
        }
        int placeCheck = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while (placeCheck <= height_main) {
            placeLog(level, placePos, randomSource, treeConfiguration);
            if(placeCheck<=height_ne){
                if(placeCheck==height_ne){
                    placeLeavesBlob(level,placePos.north().east(),randomSource,treeConfiguration);
                }
                placeLog(level, placePos.north().east(), randomSource, treeConfiguration);
            }
            if(placeCheck<=height_nw){
                if(placeCheck==height_nw){
                    placeLeavesBlob(level,placePos.north().west(),randomSource,treeConfiguration);
                }
                placeLog(level, placePos.north().west(), randomSource, treeConfiguration);
            }
            if(placeCheck<=height_se){
                if(placeCheck==height_se){
                    placeLeavesBlob(level,placePos.south().east(),randomSource,treeConfiguration);
                }
                placeLog(level, placePos.south().east(), randomSource, treeConfiguration);
            }
            if(placeCheck<=height_sw){
                if(placeCheck==height_sw){
                    placeLeavesBlob(level,placePos.south().west(),randomSource,treeConfiguration);
                }
                placeLog(level, placePos.south().west(), randomSource, treeConfiguration);
            }

            if(placeCheck<=height_2n){
                if(placeCheck==height_2n){
                    placeLeavesBlob(level,placePos.north(),randomSource,treeConfiguration);
                }
                placeLog(level, placePos.north(), randomSource, treeConfiguration);
            }
            if(placeCheck<=height_2s){
                if(placeCheck==height_2s){
                    placeLeavesBlob(level,placePos.south(),randomSource,treeConfiguration);
                }
                placeLog(level, placePos.south(), randomSource, treeConfiguration);
            }
            if(placeCheck<=height_2e){
                if(placeCheck==height_2e){
                    placeLeavesBlob(level,placePos.east(),randomSource,treeConfiguration);
                }
                placeLog(level, placePos.east(), randomSource, treeConfiguration);
            }
            if(placeCheck<=height_2w){
                if(placeCheck==height_2w){
                    placeLeavesBlob(level,placePos.west(),randomSource,treeConfiguration);
                }
                placeLog(level, placePos.west(), randomSource, treeConfiguration);
            }

            if(placeCheck == 0){
                placeRoot(level, placePos.below(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().north(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().north().east(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().north().west(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().south(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().south().east(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().south().west(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().east(), randomSource, treeConfiguration);
                placeRoot(level, placePos.below().west(), randomSource, treeConfiguration);
                if(randomSource.nextInt(2)==0) {
                    placeLeavesBlob(level,placePos.north().north(),randomSource,treeConfiguration);
                    placeRoot(level, placePos.north().north(), randomSource, treeConfiguration);
                }
                if(randomSource.nextInt(2)==0) {
                    placeLeavesBlob(level,placePos.south().south(),randomSource,treeConfiguration);
                    placeRoot(level, placePos.south().south(), randomSource, treeConfiguration);
                }
                if(randomSource.nextInt(2)==0) {
                    placeLeavesBlob(level,placePos.east().east(),randomSource,treeConfiguration);
                    placeRoot(level, placePos.east().east(), randomSource, treeConfiguration);
                }
                if(randomSource.nextInt(2)==0) {
                    placeLeavesBlob(level,placePos.west().west(),randomSource,treeConfiguration);
                    placeRoot(level, placePos.west().west(), randomSource, treeConfiguration);
                }
            }
            if(placeCheck == height_main){
                placeLeavesBlob(level,placePos,randomSource,treeConfiguration);
            }
            placePos.move(Direction.UP);
            placeCheck = placeCheck + 1;
        }
        return true;
    }

    public void generateSmallSpire(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        BlockPos.MutableBlockPos placePos = pos.mutable();
        int size = randomSource.nextInt(3)+5;

        for(int i = 0; i<= size; i++){
            if(i==0){
                placeRoot(level, pos, randomSource, treeConfiguration);
                placeRoot(level, pos.north(), randomSource, treeConfiguration);
                placeRoot(level, pos.south(), randomSource, treeConfiguration);
                placeRoot(level, pos.east(), randomSource, treeConfiguration);
                placeRoot(level, pos.west(), randomSource, treeConfiguration);
            }
            placeLog(level, placePos, randomSource, treeConfiguration);
            if(i==size){
                placeLeavesBlob(level, placePos, randomSource, treeConfiguration);
            }
            placePos.move(Direction.UP);
        }
        placeLog(level, pos.north(), randomSource, treeConfiguration);
        placeLog(level, pos.north().above(), randomSource, treeConfiguration);
        placeLeavesBlob(level, pos.north().above(), randomSource, treeConfiguration);
        placeLog(level, pos.south(), randomSource, treeConfiguration);
        placeLog(level, pos.south().above(), randomSource, treeConfiguration);
        placeLeavesBlob(level, pos.south().above(), randomSource, treeConfiguration);
        placeLog(level, pos.east(), randomSource, treeConfiguration);
        placeLog(level, pos.east().above(), randomSource, treeConfiguration);
        placeLeavesBlob(level, pos.east().above(), randomSource, treeConfiguration);
        placeLog(level, pos.west(), randomSource, treeConfiguration);
        placeLog(level, pos.west().above(), randomSource, treeConfiguration);
        placeLeavesBlob(level, pos.west().above(), randomSource, treeConfiguration);
    }

    public boolean placeLog(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
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
            level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos), 2);
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

    public void placeRoot(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        int rd = random.nextInt(2)+4;
        int i = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while(i<=rd){
            if(level.getBlockState(placePos).canBeReplaced()&&level.getBlockState(placePos.above()).is(BlockTags.DIRT)){
                break;
            }
            placeLog(level, placePos, randomSource, treeConfiguration);
            placePos.move(Direction.DOWN);
            i++;
        }
    }

    public boolean placeLeavesBlob(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        int n = random.nextInt(3);

        placeLeavesBlock(level, pos.above(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.above(2), randomSource, treeConfiguration);
        if(randomSource.nextBoolean()){
            placeLeavesBlock(level, pos.above(3), randomSource, treeConfiguration);
        }
        return true;
    }

    public boolean placeLeavesBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).canBeReplaced()) {
            level.setBlock(pos, treeConfiguration.foliageProvider.getState(randomSource, pos), 2);
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
        return reader.isStateAtPosition(pos, IceSpireFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, IceSpireFeature::isReplaceableBlock);
    }
}