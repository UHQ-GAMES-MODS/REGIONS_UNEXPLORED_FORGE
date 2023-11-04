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

public class UltraRedwoodTreeFeature extends Feature<RuTreeConfiguration> {

    public UltraRedwoodTreeFeature(Codec<RuTreeConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<RuTreeConfiguration> context) {
        RuTreeConfiguration treeConfiguration = context.config();
        BlockPos pos = context.origin();
        RandomSource randomSource = context.random();
        WorldGenLevel level = context.level();
        int height_main = context.random().nextInt(treeConfiguration.sizeVariation) + treeConfiguration.minimumSize;
        int height_var = randomSource.nextInt(6);

        int height_2N = context.random().nextInt(4) + treeConfiguration.minimumSize-10-height_var;
        int height_2S = context.random().nextInt(4) + treeConfiguration.minimumSize-10-height_var;
        int height_2E = context.random().nextInt(4) + treeConfiguration.minimumSize-10-height_var;
        int height_2W = context.random().nextInt(4) + treeConfiguration.minimumSize-10-height_var;

        int height_3N = context.random().nextInt(3) + 19;
        int height_3S = context.random().nextInt(3) + 19;
        int height_3E = context.random().nextInt(3) + 19;
        int height_3W = context.random().nextInt(3) + 19;

        int height_4N = context.random().nextInt(3) + 10;
        int height_4S = context.random().nextInt(3) + 10;
        int height_4E = context.random().nextInt(3) + 10;
        int height_4W = context.random().nextInt(3) + 10;

        int height_5NNE = context.random().nextInt(4) + 3;
        int height_5NNW = context.random().nextInt(4) + 3;
        int height_5SSE = context.random().nextInt(4) + 3;
        int height_5SSW = context.random().nextInt(4) + 3;

        int height_5WWN = context.random().nextInt(4) + 3;
        int height_5WWS = context.random().nextInt(4) + 3;
        int height_5EEN = context.random().nextInt(4) + 3;
        int height_5EES = context.random().nextInt(4) + 3;

        int check = 0;
        BlockPos.MutableBlockPos checkPos = pos.mutable();
        while (check <= height_main) {
            if(!checkReplaceable(level, checkPos)){
                return false;
            }
            if(check <= height_2N){
                if(!checkReplaceable(level, checkPos.north())){
                    return false;
                }
            }
            if(check <= height_2S){
                if(!checkReplaceable(level, checkPos.south())){
                    return false;
                }
            }
            if(check <= height_2E){
                if(!checkReplaceable(level, checkPos.east())){
                    return false;
                }
            }
            if(check <= height_2W){
                if(!checkReplaceable(level, checkPos.west())){
                    return false;
                }
            }

            if(check <= height_3N){
                if(!checkReplaceable(level, checkPos.north().east())){
                    return false;
                }
            }
            if(check <= height_3S){
                if(!checkReplaceable(level, checkPos.north().west())){
                    return false;
                }
            }
            if(check <= height_3E){
                if(!checkReplaceable(level, checkPos.south().east())){
                    return false;
                }
            }
            if(check <= height_3W){
                if(!checkReplaceable(level, checkPos.south().west())){
                    return false;
                }
            }

            if(check <= height_4N){
                if(!checkReplaceable(level, checkPos.north().north())){
                    return false;
                }
            }
            if(check <= height_4S){
                if(!checkReplaceable(level, checkPos.south().south())){
                    return false;
                }
            }
            if(check <= height_4E){
                if(!checkReplaceable(level, checkPos.east().east())){
                    return false;
                }
            }
            if(check <= height_4W){
                if(!checkReplaceable(level, checkPos.west().west())){
                    return false;
                }
            }

            if(check <= height_5NNW){
                if(!checkReplaceable(level, checkPos.north().north().west())){
                    return false;
                }
            }
            if(check <= height_5NNE){
                if(!checkReplaceable(level, checkPos.north().north().east())){
                    return false;
                }
            }
            if(check <= height_5SSW){
                if(!checkReplaceable(level, checkPos.south().south().west())){
                    return false;
                }
            }
            if(check <= height_5SSE){
                if(!checkReplaceable(level, checkPos.south().south().east())){
                    return false;
                }
            }

            if(check <= height_5WWN){
                if(!checkReplaceable(level, checkPos.west().west().north())){
                    return false;
                }
            }
            if(check <= height_5WWS){
                if(!checkReplaceable(level, checkPos.west().west().south())){
                    return false;
                }
            }
            if(check <= height_5EEN){
                if(!checkReplaceable(level, checkPos.east().east().north())){
                    return false;
                }
            }
            if(check <= height_5EES){
                if(!checkReplaceable(level, checkPos.east().east().south())){
                    return false;
                }
            }

            checkPos.move(Direction.UP);
            check = check + 1;
        }
        int placeCheck = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while (placeCheck <= height_main) {

            if(placeCheck == 0){
                placeRoot(level, placePos, randomSource, treeConfiguration);
            }
            if(placeCheck == height_main){
                placeLeavesBlob(level, placePos, randomSource, treeConfiguration);
            }

            if(placeCheck <= height_2N){
                if(placeCheck == 0){
                    placeRoot(level, placePos.north(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.north(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.north(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_2S){
                if(placeCheck == 0){
                    placeRoot(level, placePos.south(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.south(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.south(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_2E){
                if(placeCheck == 0){
                    placeRoot(level, placePos.east(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.east(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.east(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_2W){
                if(placeCheck == 0){
                    placeRoot(level, placePos.west(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.west(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.west(), randomSource, treeConfiguration, Direction.Axis.Y);
            }

            if(placeCheck <= height_3N){
                if(placeCheck == 0){
                    placeRoot(level, placePos.north().east(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.north().east(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.north().east(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_3S){
                if(placeCheck == 0){
                    placeRoot(level, placePos.north().west(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.north().west(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.north().west(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_3E){
                if(placeCheck == 0){
                    placeRoot(level, placePos.south().east(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.south().east(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.south().east(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_3W){
                if(placeCheck == 0){
                    placeRoot(level, placePos.south().west(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.south().west(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.south().west(), randomSource, treeConfiguration, Direction.Axis.Y);
            }

            if(placeCheck <= height_4N){
                if(placeCheck == 0){
                    placeRoot(level, placePos.north().north(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.north().north(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.north().north(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_4S){
                if(placeCheck == 0){
                    placeRoot(level, placePos.south().south(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.south().south(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.south().south(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_4E){
                if(placeCheck == 0){
                    placeRoot(level, placePos.east().east(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.east().east(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.east().east(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_4W){
                if(placeCheck == 0){
                    placeRoot(level, placePos.west().west(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.west().west(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.west().west(), randomSource, treeConfiguration, Direction.Axis.Y);
            }

            if(placeCheck <= height_5NNW){
                if(placeCheck == 0){
                    placeRoot(level, placePos.north().north().west(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.north().north().west(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.north().north().west(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_5NNE){
                if(placeCheck == 0){
                    placeRoot(level, placePos.north().north().east(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.north().north().east(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.north().north().east(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_5SSW){
                if(placeCheck == 0){
                    placeRoot(level, placePos.south().south().west(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.south().south().west(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.south().south().west(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_5SSE){
                if(placeCheck == 0){
                    placeRoot(level, placePos.south().south().east(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.south().south().east(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.south().south().east(), randomSource, treeConfiguration, Direction.Axis.Y);
            }

            if(placeCheck <= height_5WWN){
                if(placeCheck == 0){
                    placeRoot(level, placePos.west().west().north(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.west().west().north(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.west().west().north(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_5WWS){
                if(placeCheck == 0){
                    placeRoot(level, placePos.west().west().south(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.west().west().south(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.west().west().south(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_5EEN){
                if(placeCheck == 0){
                    placeRoot(level, placePos.east().east().north(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.east().east().north(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.east().east().north(), randomSource, treeConfiguration, Direction.Axis.Y);
            }
            if(placeCheck <= height_5EES){
                if(placeCheck == 0){
                    placeRoot(level, placePos.east().east().south(), randomSource, treeConfiguration);
                }
                if(placeCheck>5){
                    placeBranchDecorator(level, placePos.east().east().south(), randomSource, treeConfiguration);
                }
                placeLog(level, placePos.east().east().south(), randomSource, treeConfiguration, Direction.Axis.Y);
            }

            placeLog(level, placePos, randomSource, treeConfiguration, Direction.Axis.Y);
            if(placeCheck>5){
                placeBranchDecorator(level, placePos, randomSource, treeConfiguration);
            }
            if(placeCheck==height_main){
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
        if(randomSource.nextInt(6)==0){
            placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
            placeBranchesLong(level, placePos, randomSource, treeConfiguration);
        }
        placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
        placeBranchesXLong(level, placePos, randomSource, treeConfiguration);
        placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
        placeBranchesXLong(level, placePos, randomSource, treeConfiguration);
        if(randomSource.nextInt(6)==0){
            placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
            placeBranchesXLong(level, placePos, randomSource, treeConfiguration);
        }
        placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);placePos.move(Direction.DOWN);
        placeBranchesXXLong(level, placePos, randomSource, treeConfiguration);
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
            placeLeavesBlob(level,pos.north().east().east(), randomSource, treeConfiguration);

            placeLog(level, pos.west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.north().west().west(), randomSource, treeConfiguration);
        }
    }

    public void placeBranchesXLong(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        int type = randomSource.nextInt(2);
        placeLeavesBlock(level,pos.north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.north().east().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.south().east().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.north().west().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.south().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.south().west().south().west(),randomSource,treeConfiguration);

        placeLeavesBlock(level,pos.above().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().north().east().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().south().east().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().north().west().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().south().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().south().west().south().west(),randomSource,treeConfiguration);

        placeLeavesBlock(level,pos.above().above().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().north().east().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().south().east().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().north().west().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().south().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().south().west().south().west(),randomSource,treeConfiguration);

        placeLeavesBlock(level,pos.below().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().north().east().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().south().east().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().north().west().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().south().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().south().west().south().west(),randomSource,treeConfiguration);
        if(type==0){
            placeLog(level, pos.north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.north().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.north().north().north(), randomSource, treeConfiguration);

            placeLog(level, pos.south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.south().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.south().south().south(), randomSource, treeConfiguration);

            placeLog(level, pos.below().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().east().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.below().east().east().east(), randomSource, treeConfiguration);

            placeLog(level, pos.below().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().west().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.below().west().west().west(), randomSource, treeConfiguration);
        }
        else{
            placeLog(level, pos.below().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().north().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.below().north().north().north(), randomSource, treeConfiguration);

            placeLog(level, pos.below().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().south().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.below().south().south().south(), randomSource, treeConfiguration);

            placeLog(level, pos.east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.east().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.east().east().east(), randomSource, treeConfiguration);

            placeLog(level, pos.west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.west().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.west().west().west(), randomSource, treeConfiguration);
        }
    }

    public void placeBranchesXXLong(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        int type = randomSource.nextInt(2);
        placeLeavesBlock(level,pos.north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.north().east().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.south().east().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.north().west().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.south().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.south().west().south().west(),randomSource,treeConfiguration);

        placeLeavesBlock(level,pos.above().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().north().east().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().south().east().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().north().west().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().south().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().south().west().south().west(),randomSource,treeConfiguration);

        placeLeavesBlock(level,pos.above().above().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().north().east().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().south().east().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().north().west().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().south().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.above().above().south().west().south().west(),randomSource,treeConfiguration);

        placeLeavesBlock(level,pos.below().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().north().east().north().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().south().east().south().east(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().north().west().north().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().south().west(),randomSource,treeConfiguration);
        placeLeavesBlock(level,pos.below().south().west().south().west(),randomSource,treeConfiguration);
        if(type==0){
            placeLog(level, pos.north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.north().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.north().north().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.north().north().north().north(), randomSource, treeConfiguration);

            placeLog(level, pos.south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.south().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.south().south().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.south().south().south().south(), randomSource, treeConfiguration);

            placeLog(level, pos.below().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().east().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().east().east().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.below().east().east().east().east(), randomSource, treeConfiguration);

            placeLog(level, pos.below().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().west().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.below().west().west().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.below().west().west().west().west(), randomSource, treeConfiguration);
        }
        else{
            placeLog(level, pos.below().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().north().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().north().north().north().north(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.below().north().north().north().north(), randomSource, treeConfiguration);

            placeLog(level, pos.below().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().south().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLog(level, pos.below().south().south().south().south(), randomSource, treeConfiguration, Direction.Axis.Z);
            placeLeavesBlob(level,pos.below().south().south().south().south(), randomSource, treeConfiguration);

            placeLog(level, pos.east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.east().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.east().east().east().east(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.east().east().east().east(), randomSource, treeConfiguration);

            placeLog(level, pos.west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.west().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLog(level, pos.west().west().west().west(), randomSource, treeConfiguration, Direction.Axis.X);
            placeLeavesBlob(level,pos.west().west().west().west(), randomSource, treeConfiguration);
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
        int rd = random.nextInt(2)+6;
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
        return reader.isStateAtPosition(pos, UltraRedwoodTreeFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, UltraRedwoodTreeFeature::isReplaceableBlock);
    }
}