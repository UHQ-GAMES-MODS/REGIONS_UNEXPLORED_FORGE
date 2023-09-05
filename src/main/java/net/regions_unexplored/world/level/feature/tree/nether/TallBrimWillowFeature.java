package net.regions_unexplored.world.level.feature.tree.nether;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.world.level.block.wood.MagmaLogBlock;

import java.util.Random;

public class TallBrimWillowFeature extends Feature<NoneFeatureConfiguration> {

    public TallBrimWillowFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        int height = context.random().nextInt(3)+13;

        if(level.getBlockState(pos.north()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.west()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.east()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.south()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.south().west()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.south().east()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.north().west()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.north().east()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.below()).getBlock()== RuBlocks.BRIMSPROUT_NYLIUM.get()||level.getBlockState(pos.below()).getBlock()== Blocks.SCULK||level.getBlockState(pos.below()).is(BlockTags.NYLIUM)||level.getBlockState(pos.below()).is(BlockTags.DIRT)){
        }
        else{
            return false;
        }

        if (level.isEmptyBlock(pos)) {
            BlockPos.MutableBlockPos placePos = pos.mutable();

            for(int i = 0; i<=height; i++){
                if(i==1){
                    placeRoots(level, placePos);
                }
                if(i==height-3){
                    placeBranches(level, placePos);
                }
                if(i==height-5){
                    placeSpine(level, placePos);
                }
                if(isReplaceable(level, placePos)){
                    if(level.isOutsideBuildHeight(placePos)){
                        break;
                    }
                    if(i==3){
                        level.setBlock(placePos, RuBlocks.BRIMWOOD_LOG_MAGMA.get().defaultBlockState().setValue(MagmaLogBlock.TRANSITION_BLOCK, true), 2);
                    }
                    else if(i<3){
                        level.setBlock(placePos, RuBlocks.BRIMWOOD_LOG_MAGMA.get().defaultBlockState().setValue(MagmaLogBlock.TRANSITION_BLOCK, false), 2);
                    }
                    else if(i>3){
                        level.setBlock(placePos, RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Y), 2);
                    }
                }
                if(i==height){
                    placeLeavesUpsideDown(level, placePos);
                }
                placePos.move(Direction.UP);
            }

            return true;
        } else {
            return false;
        }
    }

    private void placeBrimwoodLog(LevelAccessor level, BlockPos pos, Direction.Axis axis){
        if(level.isOutsideBuildHeight(pos)){
            return;
        }
        if (isReplaceable(level, pos)) {
            level.setBlock(pos, RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, axis), 2);
        }
    }

    private void placeBrimwoodLeaves(LevelAccessor level, BlockPos pos){
        if(level.isOutsideBuildHeight(pos)){
            return;
        }
        if (isReplaceable(level, pos)) {
            level.setBlock(pos, RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
    }

    private void placeBranches(LevelAccessor level, BlockPos pos) {
        //NORTH
        if(isReplaceable(level, pos.north())){
            if(isReplaceable(level, pos.north())){
                placeBrimwoodLog( level, pos.north(), Direction.Axis.Z);
            }
            if(isReplaceable(level, pos.north().above().north())){
                placeBrimwoodLog( level, pos.north().above().north(), Direction.Axis.Z);
            }
            if(isReplaceable(level, pos.north().above().north().north())){
                placeBrimwoodLog( level, pos.north().above().north().north(), Direction.Axis.Z);
            }
            if(isReplaceable(level, pos.north().above().north().north().north())){
                placeBrimwoodLog( level, pos.north().above().north().north().north(), Direction.Axis.Z);
                placeLeavesUpsideDown(level, pos.north().above().north().north().north());
            }
        }
        //SOUTH
        if(isReplaceable(level, pos.south())){
            if(isReplaceable(level, pos.south())){
                placeBrimwoodLog( level, pos.south(), Direction.Axis.Z);
            }
            if(isReplaceable(level, pos.south().above().south())){
                placeBrimwoodLog( level, pos.south().above().south(), Direction.Axis.Z);
            }
            if(isReplaceable(level, pos.south().above().south().south())){
                placeBrimwoodLog( level, pos.south().above().south().south(), Direction.Axis.Z);
            }
            if(isReplaceable(level, pos.south().above().south().south().south())){
                placeBrimwoodLog( level, pos.south().above().south().south().south(), Direction.Axis.Z);
                placeLeavesUpsideDown(level, pos.south().above().south().south().south());
            }
        }
        //EAST
        if(isReplaceable(level, pos.east())){
            if(isReplaceable(level, pos.east())){
                placeBrimwoodLog( level, pos.east(), Direction.Axis.X);
            }
            if(isReplaceable(level, pos.east().above().east())){
                placeBrimwoodLog( level, pos.east().above().east(), Direction.Axis.X);
            }
            if(isReplaceable(level, pos.east().above().east().east())){
                placeBrimwoodLog( level, pos.east().above().east().east(), Direction.Axis.X);
            }
            if(isReplaceable(level, pos.east().above().east().east().east())){
                placeBrimwoodLog( level, pos.east().above().east().east().east(), Direction.Axis.X);
                placeLeavesUpsideDown(level, pos.east().above().east().east().east());
            }
        }
        //WEST
        if(isReplaceable(level, pos.west())){
            if(isReplaceable(level, pos.west())){
                placeBrimwoodLog( level, pos.west(), Direction.Axis.X);
            }
            if(isReplaceable(level, pos.west().above().west())){
                placeBrimwoodLog( level, pos.west().above().west(), Direction.Axis.X);
            }
            if(isReplaceable(level, pos.west().above().west().west())){
                placeBrimwoodLog( level, pos.west().above().west().west(), Direction.Axis.X);
            }
            if(isReplaceable(level, pos.west().above().west().west().west())){
                placeBrimwoodLog( level, pos.west().above().west().west().west(), Direction.Axis.X);
                placeLeavesUpsideDown(level, pos.west().above().west().west().west());
            }
        }
    }


    private void placeBranchesGiant(LevelAccessor level, BlockPos pos) {
        //NORTH
        if(isReplaceable(level, pos.north())){
            if(isReplaceable(level, pos.north())){
                placeBrimwoodLog( level, pos.north(), Direction.Axis.Z);
                if(isReplaceable(level, pos.north().north())){
                    placeBrimwoodLog( level, pos.north().north(), Direction.Axis.Z);
                    if(isReplaceable(level, pos.north().north().north().above())){
                        placeBrimwoodLog( level, pos.north().north().north().above(), Direction.Axis.Z);
                        if(isReplaceable(level, pos.north().north().north().north().above())){
                            placeBrimwoodLog( level, pos.north().north().north().north().above(), Direction.Axis.Z);
                            if(isReplaceable(level, pos.north().north().north().north().above().north().above())){
                                placeBrimwoodLog( level, pos.north().north().north().north().above().north().above(), Direction.Axis.Z);
                                placeLeavesUpsideDownGiant(level, pos.north().north().north().north().above().north().above());
                            }
                        }
                    }
                }
            }
        }
        //SOUTH
        if(isReplaceable(level, pos.south())){
            if(isReplaceable(level, pos.south())){
                placeBrimwoodLog( level, pos.south(), Direction.Axis.Z);
                if(isReplaceable(level, pos.south().south())){
                    placeBrimwoodLog( level, pos.south().south(), Direction.Axis.Z);
                    if(isReplaceable(level, pos.south().south().south().above())){
                        placeBrimwoodLog( level, pos.south().south().south().above(), Direction.Axis.Z);
                        if(isReplaceable(level, pos.south().south().south().south().above())){
                            placeBrimwoodLog( level, pos.south().south().south().south().above(), Direction.Axis.Z);
                            if(isReplaceable(level, pos.south().south().south().south().above().south().above())){
                                placeBrimwoodLog( level, pos.south().south().south().south().above().south().above(), Direction.Axis.Z);
                                placeLeavesUpsideDownGiant(level, pos.south().south().south().south().above().south().above());
                            }
                        }
                    }
                }
            }
        }
        //EAST
        if(isReplaceable(level, pos.east())){
            if(isReplaceable(level, pos.east())){
                placeBrimwoodLog( level, pos.east(), Direction.Axis.X);
                if(isReplaceable(level, pos.east().east())){
                    placeBrimwoodLog( level, pos.east().east(), Direction.Axis.X);
                    if(isReplaceable(level, pos.east().east().east().above())){
                        placeBrimwoodLog( level, pos.east().east().east().above(), Direction.Axis.X);
                        if(isReplaceable(level, pos.east().east().east().east().above())){
                            placeBrimwoodLog( level, pos.east().east().east().east().above(), Direction.Axis.X);
                            if(isReplaceable(level, pos.east().east().east().east().above().east().above())){
                                placeBrimwoodLog( level, pos.east().east().east().east().above().east().above(), Direction.Axis.X);
                                placeLeavesUpsideDownGiant(level, pos.east().east().east().east().above().east().above());
                            }
                        }
                    }
                }
            }
        }
        //WEST
        if(isReplaceable(level, pos.west())){
            if(isReplaceable(level, pos.west())){
                placeBrimwoodLog( level, pos.west(), Direction.Axis.X);
                if(isReplaceable(level, pos.west().west())){
                    placeBrimwoodLog( level, pos.west().west(), Direction.Axis.X);
                    if(isReplaceable(level, pos.west().west().west().above())){
                        placeBrimwoodLog( level, pos.west().west().west().above(), Direction.Axis.X);
                        if(isReplaceable(level, pos.west().west().west().west().above())){
                            placeBrimwoodLog( level, pos.west().west().west().west().above(), Direction.Axis.X);
                            if(isReplaceable(level, pos.west().west().west().west().above().west().above())){
                                placeBrimwoodLog( level, pos.west().west().west().west().above().west().above(), Direction.Axis.X);
                                placeLeavesUpsideDownGiant(level, pos.west().west().west().west().above().west().above());
                            }
                        }
                    }
                }
            }
        }
        //NORTH_WEST
        if(isReplaceable(level, pos.north().west())){
            placeBrimwoodLog( level, pos.north().west(), Direction.Axis.Z);
            if(isReplaceable(level, pos.north().west().north().west().above())){
                placeBrimwoodLog( level, pos.north().west().north().west().above(), Direction.Axis.Z);
                if(isReplaceable(level, pos.north().west().north().west().north().west().above())){
                    placeBrimwoodLog( level, pos.north().west().north().west().north().west().above(), Direction.Axis.Z);
                    if(isReplaceable(level, pos.north().west().north().west().north().west().above().north().west().above())){
                        placeBrimwoodLog( level, pos.north().west().north().west().north().west().above().north().west().above(), Direction.Axis.Z);
                        if(isReplaceable(level, pos.north().west().north().west().north().west().above().north().west().above().north().west())){
                            placeBrimwoodLog( level, pos.north().west().north().west().north().west().above().north().west().above().north().west(), Direction.Axis.Z);
                            if(isReplaceable(level, pos.north().west().north().west().north().west().above().north().west().above().north().west().above().north().west())){
                                placeBrimwoodLog( level, pos.north().west().north().west().north().west().above().north().west().above().north().west().above().north().west(), Direction.Axis.Z);
                                placeLeavesUpsideDownGiant(level, pos.north().west().north().west().north().west().above().north().west().above().north().west().above().north().west());
                            }
                        }
                    }
                }
            }
        }
        //SOUTH_WEST
        if(isReplaceable(level, pos.south().west())){
            placeBrimwoodLog( level, pos.south().west(), Direction.Axis.Z);
            if(isReplaceable(level, pos.south().west().south().west().above())){
                placeBrimwoodLog( level, pos.south().west().south().west().above(), Direction.Axis.Z);
                if(isReplaceable(level, pos.south().west().south().west().south().west().above())){
                    placeBrimwoodLog( level, pos.south().west().south().west().south().west().above(), Direction.Axis.Z);
                    if(isReplaceable(level, pos.south().west().south().west().south().west().above().south().west().above())){
                        placeBrimwoodLog( level, pos.south().west().south().west().south().west().above().south().west().above(), Direction.Axis.Z);
                        if(isReplaceable(level, pos.south().west().south().west().south().west().above().south().west().above().south().west())){
                            placeBrimwoodLog( level, pos.south().west().south().west().south().west().above().south().west().above().south().west(), Direction.Axis.Z);
                            if(isReplaceable(level, pos.south().west().south().west().south().west().above().south().west().above().south().west().above().south().west())){
                                placeBrimwoodLog( level, pos.south().west().south().west().south().west().above().south().west().above().south().west().above().south().west(), Direction.Axis.Z);
                                placeLeavesUpsideDownGiant(level, pos.south().west().south().west().south().west().above().south().west().above().south().west().above().south().west());
                            }
                        }
                    }
                }
            }
        }
        //NORTH_EAST
        if(isReplaceable(level, pos.north().east())){
            placeBrimwoodLog( level, pos.north().east(), Direction.Axis.Z);
            if(isReplaceable(level, pos.north().east().north().east().above())){
                placeBrimwoodLog( level, pos.north().east().north().east().above(), Direction.Axis.Z);
                if(isReplaceable(level, pos.north().east().north().east().north().east().above())){
                    placeBrimwoodLog( level, pos.north().east().north().east().north().east().above(), Direction.Axis.Z);
                    if(isReplaceable(level, pos.north().east().north().east().north().east().above().north().east().above())){
                        placeBrimwoodLog( level, pos.north().east().north().east().north().east().above().north().east().above(), Direction.Axis.Z);
                        if(isReplaceable(level, pos.north().east().north().east().north().east().above().north().east().above().north().east())){
                            placeBrimwoodLog( level, pos.north().east().north().east().north().east().above().north().east().above().north().east(), Direction.Axis.Z);
                            if(isReplaceable(level, pos.north().east().north().east().north().east().above().north().east().above().north().east().above().north().east())){
                                placeBrimwoodLog( level, pos.north().east().north().east().north().east().above().north().east().above().north().east().above().north().east(), Direction.Axis.Z);
                                placeLeavesUpsideDownGiant(level, pos.north().east().north().east().north().east().above().north().east().above().north().east().above().north().east());
                            }
                        }
                    }
                }
            }
        }
        //SOUTH_EAST
        if(isReplaceable(level, pos.south().east())){
            placeBrimwoodLog( level, pos.south().east(), Direction.Axis.Z);
            if(isReplaceable(level, pos.south().east().south().east().above())){
                placeBrimwoodLog( level, pos.south().east().south().east().above(), Direction.Axis.Z);
                if(isReplaceable(level, pos.south().east().south().east().south().east().above())){
                    placeBrimwoodLog( level, pos.south().east().south().east().south().east().above(), Direction.Axis.Z);
                    if(isReplaceable(level, pos.south().east().south().east().south().east().above().south().east().above())){
                        placeBrimwoodLog( level, pos.south().east().south().east().south().east().above().south().east().above(), Direction.Axis.Z);
                        if(isReplaceable(level, pos.south().east().south().east().south().east().above().south().east().above().south().east())){
                            placeBrimwoodLog( level, pos.south().east().south().east().south().east().above().south().east().above().south().east(), Direction.Axis.Z);
                            if(isReplaceable(level, pos.south().east().south().east().south().east().above().south().east().above().south().east().above().south().east())){
                                placeBrimwoodLog( level, pos.south().east().south().east().south().east().above().south().east().above().south().east().above().south().east(), Direction.Axis.Z);
                                placeLeavesUpsideDownGiant(level, pos.south().east().south().east().south().east().above().south().east().above().south().east().above().south().east());
                            }
                        }
                    }
                }
            }
        }
    }

    private void placeSpine(LevelAccessor level, BlockPos pos) {
        //NORTH
        if(isReplaceable(level, pos.north())){
                placeBrimwoodLog( level, pos.north(), Direction.Axis.Z);
        }
        //SOUTH
        if(isReplaceable(level, pos.south())){
                placeBrimwoodLog( level, pos.south(), Direction.Axis.Z);
        }
        //EAST
        if(isReplaceable(level, pos.east())){
                placeBrimwoodLog( level, pos.east(), Direction.Axis.X);
        }
        //WEST
        if(isReplaceable(level, pos.west())){
                placeBrimwoodLog( level, pos.west(), Direction.Axis.X);
        }
    }

    private void placeRoots(LevelAccessor level, BlockPos pos) {
        //NORTH
        if(level.isEmptyBlock(pos.north().below().north().below().below().below())){}
        else{
            if(isReplaceable(level, pos.north())){
                if(isReplaceable(level, pos.north().north().north())){
                    placeBrimwoodLog( level, pos.north().north().north(), Direction.Axis.Z);
                    if(isReplaceable(level, pos.north().north())){
                    }
                }
                if(isReplaceable(level, pos.north().below().north())){
                    placeBrimwoodLog( level, pos.north().below().north(), Direction.Axis.Y);
                    if(isReplaceable(level, pos.north().below().north().below())){
                        placeBrimwoodLog( level, pos.north().below().north().below(), Direction.Axis.Y);
                        if(isReplaceable(level, pos.north().below().north().below().below())){
                            placeBrimwoodLog( level, pos.north().below().north().below().below(), Direction.Axis.Y);
                            if(isReplaceable(level, pos.north().below().north().below().below().below())){
                                placeBrimwoodLog( level, pos.north().below().north().below().below().below(), Direction.Axis.Y);
                            }
                        }
                    }
                }
            }
        }
        //SOUTH
        if(level.isEmptyBlock(pos.south().below().south().below().below().below())){}
        else{
            if(isReplaceable(level, pos.south())){
                if(isReplaceable(level, pos.south().south().south())){
                    placeBrimwoodLog( level, pos.south().south().south(), Direction.Axis.Z);
                    if(isReplaceable(level, pos.south().south())){
                    }
                }
                if(isReplaceable(level, pos.south().below().south())){
                    placeBrimwoodLog( level, pos.south().below().south(), Direction.Axis.Y);
                    if(isReplaceable(level, pos.south().below().south().below())){
                        placeBrimwoodLog( level, pos.south().below().south().below(), Direction.Axis.Y);
                        if(isReplaceable(level, pos.south().below().south().below().below())){
                            placeBrimwoodLog( level, pos.south().below().south().below().below(), Direction.Axis.Y);
                            if(isReplaceable(level, pos.south().below().south().below().below().below())){
                                placeBrimwoodLog( level, pos.south().below().south().below().below().below(), Direction.Axis.Y);
                            }
                        }
                    }
                }
            }
        }
        //EAST
        if(level.isEmptyBlock(pos.east().below().east().below().below().below())){}
        else{
            if(isReplaceable(level, pos.east())){
                if(isReplaceable(level, pos.east().east().east())){
                    placeBrimwoodLog( level, pos.east().east().east(), Direction.Axis.X);
                    if(isReplaceable(level, pos.east().east())){
                    }
                }
                if(isReplaceable(level, pos.east().below().east())){
                    placeBrimwoodLog( level, pos.east().below().east(), Direction.Axis.Y);
                    if(isReplaceable(level, pos.east().below().east().below())){
                        placeBrimwoodLog( level, pos.east().below().east().below(), Direction.Axis.Y);
                        if(isReplaceable(level, pos.east().below().east().below().below())){
                            placeBrimwoodLog( level, pos.east().below().east().below().below(), Direction.Axis.Y);
                            if(isReplaceable(level, pos.east().below().east().below().below().below())){
                                placeBrimwoodLog( level, pos.east().below().east().below().below().below(), Direction.Axis.Y);
                            }
                        }
                    }
                }
            }
        }
        //WEST
        if(level.isEmptyBlock(pos.west().below().west().below().below().below())){}
        else{
            if(isReplaceable(level, pos.west())){
                if(isReplaceable(level, pos.west().west().west())){
                    placeBrimwoodLog( level, pos.west().west().west(), Direction.Axis.X);
                    if(isReplaceable(level, pos.west().west())){
                    }
                }
                if(isReplaceable(level, pos.west().below().west())){
                    placeBrimwoodLog( level, pos.west().below().west(), Direction.Axis.Y);
                    if(isReplaceable(level, pos.west().below().west().below())){
                        placeBrimwoodLog( level, pos.west().below().west().below(), Direction.Axis.Y);
                        if(isReplaceable(level, pos.west().below().west().below().below())){
                            placeBrimwoodLog( level, pos.west().below().west().below().below(), Direction.Axis.Y);
                            if(isReplaceable(level, pos.west().below().west().below().below().below())){
                                placeBrimwoodLog( level, pos.west().below().west().below().below().below(), Direction.Axis.Y);
                            }
                        }
                    }
                }
            }
        }
    }

    private void placeLeavesUpsideDown(LevelAccessor level, BlockPos pos) {
        if (isReplaceable(level, pos)) {
            placeBrimwoodLeaves(level, pos);
        }
        //TOP
        if (isReplaceable(level, pos.above())) {
            placeBrimwoodLeaves(level, pos.above());
        }
        if (isReplaceable(level, pos.above().north())) {
            placeBrimwoodLeaves(level, pos.above().north());
        }
        if (isReplaceable(level, pos.above().north().east())) {
            placeBrimwoodLeaves(level, pos.above().north().east());
        }
        if (isReplaceable(level, pos.above().north().west())) {
            placeBrimwoodLeaves(level, pos.above().north().west());
        }
        if (isReplaceable(level, pos.above().south())) {
            placeBrimwoodLeaves(level, pos.above().south());
        }
        if (isReplaceable(level, pos.above().south().east())) {
            placeBrimwoodLeaves(level, pos.above().south().east());
        }
        if (isReplaceable(level, pos.above().south().west())) {
            placeBrimwoodLeaves(level, pos.above().south().west());
        }
        if (isReplaceable(level, pos.above().east())) {
            placeBrimwoodLeaves(level, pos.above().east());
        }
        if (isReplaceable(level, pos.above().west())) {
            placeBrimwoodLeaves(level, pos.above().west());
        }
        //NORTH
        if (isReplaceable(level, pos.north())) {
            placeBrimwoodLeaves(level, pos.north());
        }
        if (isReplaceable(level, pos.north().north().above())) {
            placeBrimwoodLeaves(level, pos.north().north().above());
            addVine(level,pos.north().north().above());
        }
        //NORTH-WEST
        if (isReplaceable(level, pos.north().west())) {
            placeBrimwoodLeaves(level, pos.north().west());
        }
        if (isReplaceable(level, pos.north().north().west().above())) {
            placeBrimwoodLeaves(level, pos.north().north().west().above());
            addVine(level,pos.north().north().west().above());
        }
        if (isReplaceable(level, pos.north().west().west().above())) {
            placeBrimwoodLeaves(level, pos.north().west().west().above());
            addVine(level,pos.north().west().west().above());
        }
        //WEST
        if (isReplaceable(level, pos.west())) {
            placeBrimwoodLeaves(level, pos.west());
        }
        if (isReplaceable(level, pos.west().west().above())) {
            placeBrimwoodLeaves(level, pos.west().west().above());
            addVine(level,pos.west().west().above());
        }
        //SOUTH-WEST
        if (isReplaceable(level, pos.south().west())) {
            placeBrimwoodLeaves(level, pos.south().west());
        }
        if (isReplaceable(level, pos.south().south().west().above())) {
            placeBrimwoodLeaves(level, pos.south().south().west().above());
            addVine(level,pos.south().south().west().above());
        }
        if (isReplaceable(level, pos.south().west().west().above())) {
            placeBrimwoodLeaves(level, pos.south().west().west().above());
            addVine(level,pos.south().west().west().above());
        }
        //SOUTH
        if (isReplaceable(level, pos.south())) {
            placeBrimwoodLeaves(level, pos.south());
        }
        if (isReplaceable(level, pos.south().south().above())) {
            placeBrimwoodLeaves(level, pos.south().south().above());
            addVine(level,pos.south().south().above());
        }
        //SOUTH-EAST
        if (isReplaceable(level, pos.south().east())) {
            placeBrimwoodLeaves(level, pos.south().east());
        }
        if (isReplaceable(level, pos.south().south().east().above())) {
            placeBrimwoodLeaves(level, pos.south().south().east().above());
            addVine(level,pos.south().south().east().above());
        }
        if (isReplaceable(level, pos.south().east().east().above())) {
            placeBrimwoodLeaves(level, pos.south().east().east().above());
            addVine(level,pos.south().east().east().above());
        }
        //EAST
        if (isReplaceable(level, pos.east())) {
            placeBrimwoodLeaves(level, pos.east());
        }
        if (isReplaceable(level, pos.east().east().above())) {
            placeBrimwoodLeaves(level, pos.east().east().above());
            addVine(level,pos.east().east().above());
        }
        //NORTH-EAST
        if (isReplaceable(level, pos.north().east())) {
            placeBrimwoodLeaves(level, pos.north().east());
        }
        if (isReplaceable(level, pos.north().north().east().above())) {
            placeBrimwoodLeaves(level, pos.north().north().east().above());
            addVine(level,pos.north().north().east().above());
        }
        if (isReplaceable(level, pos.north().east().east().above())) {
            placeBrimwoodLeaves(level, pos.north().east().east().above());
            addVine(level,pos.north().east().east().above());
        }
    }

    private void placeLeavesUpsideDownGiant(LevelAccessor level, BlockPos pos) {
        BlockPos pos2 = pos.above();
        if (isReplaceable(level, pos)) {
            placeBrimwoodLeaves(level, pos);
        }

        //NORTH
        if (!level.isOutsideBuildHeight(pos)) {
            if (isReplaceable(level, pos.north())) {
                placeBrimwoodLeaves(level, pos.north());
            }
            if (isReplaceable(level, pos.north().north())) {
                placeBrimwoodLeaves(level, pos.north().north());
            }
            //NORTH-WEST
            if (isReplaceable(level, pos.north().west())) {
                placeBrimwoodLeaves(level, pos.north().west());
            }
            if (isReplaceable(level, pos.north().north().west())) {
                placeBrimwoodLeaves(level, pos.north().north().west());
            }
            if (isReplaceable(level, pos.north().west().west())) {
                placeBrimwoodLeaves(level, pos.north().west().west());
            }
            //WEST
            if (isReplaceable(level, pos.west())) {
                placeBrimwoodLeaves(level, pos.west());
            }
            if (isReplaceable(level, pos.west().west())) {
                placeBrimwoodLeaves(level, pos.west().west());
            }
            //SOUTH-WEST
            if (isReplaceable(level, pos.south().west())) {
                placeBrimwoodLeaves(level, pos.south().west());
            }
            if (isReplaceable(level, pos.south().south().west())) {
                placeBrimwoodLeaves(level, pos.south().south().west());
            }
            if (isReplaceable(level, pos.south().west().west())) {
                placeBrimwoodLeaves(level, pos.south().west().west());
            }
            //SOUTH
            if (isReplaceable(level, pos.south())) {
                placeBrimwoodLeaves(level, pos.south());
            }
            if (isReplaceable(level, pos.south().south())) {
                placeBrimwoodLeaves(level, pos.south().south());
            }
            //SOUTH-EAST
            if (isReplaceable(level, pos.south().east())) {
                placeBrimwoodLeaves(level, pos.south().east());
            }
            if (isReplaceable(level, pos.south().south().east())) {
                placeBrimwoodLeaves(level, pos.south().south().east());
            }
            if (isReplaceable(level, pos.south().east().east())) {
                placeBrimwoodLeaves(level, pos.south().east().east());
            }
            //EAST
            if (isReplaceable(level, pos.east())) {
                placeBrimwoodLeaves(level, pos.east());
            }
            if (isReplaceable(level, pos.east().east())) {
                placeBrimwoodLeaves(level, pos.east().east());
            }
            //NORTH-EAST
            if (isReplaceable(level, pos.north().east())) {
                placeBrimwoodLeaves(level, pos.north().east());
            }
            if (isReplaceable(level, pos.north().north().east())) {
                placeBrimwoodLeaves(level, pos.north().north().east());
            }
            if (isReplaceable(level, pos.north().east().east())) {
                placeBrimwoodLeaves(level, pos.north().east().east());
            }
        }


        if (!level.isOutsideBuildHeight(pos2)) {
            if (isReplaceable(level, pos2.north())) {
                placeBrimwoodLeaves(level, pos2.north());
            }
            if (isReplaceable(level, pos2.north().north())) {
                placeBrimwoodLeaves(level, pos2.north().north());
            }
            if (isReplaceable(level, pos2.north().north().north())) {
                placeBrimwoodLeaves(level, pos2.north().north().north());
                addVineGiant(level, pos2.north().north().north());
            }
            if (isReplaceable(level, pos2.east().north().north().north())) {
                placeBrimwoodLeaves(level, pos2.east().north().north().north());
                addVineGiant(level, pos2.east().north().north().north());
            }
            if (isReplaceable(level, pos2.east().east().north().north().north())) {
                placeBrimwoodLeaves(level, pos2.east().east().north().north().north());
                addVineGiant(level, pos2.east().east().north().north().north());
            }
            if (isReplaceable(level, pos2.west().north().north().north())) {
                placeBrimwoodLeaves(level, pos2.west().north().north().north());
                addVineGiant(level, pos2.west().north().north().north());
            }
            if (isReplaceable(level, pos2.west().west().north().north().north())) {
                placeBrimwoodLeaves(level, pos2.west().west().north().north().north());
                addVineGiant(level, pos2.west().west().north().north().north());
            }
            //NORTH-WEST
            if (isReplaceable(level, pos2.north().west())) {
                placeBrimwoodLeaves(level, pos2.north().west());
            }
            if (isReplaceable(level, pos2.north().north().west())) {
                placeBrimwoodLeaves(level, pos2.north().north().west());
                addVineGiant(level, pos2.north().north().west());
            }
            if (isReplaceable(level, pos2.north().west().west())) {
                placeBrimwoodLeaves(level, pos2.north().west().west());
                addVineGiant(level, pos2.north().west().west());
            }
            if (isReplaceable(level, pos2.north().north().west().west())) {
                placeBrimwoodLeaves(level, pos2.north().north().west().west());
                addVineGiant(level, pos2.north().north().west().west());
            }
            //WEST
            if (isReplaceable(level, pos2.west())) {
                placeBrimwoodLeaves(level, pos2.west());
            }
            if (isReplaceable(level, pos2.west().west())) {
                placeBrimwoodLeaves(level, pos2.west().west());
            }
            if (isReplaceable(level, pos2.west().west().west())) {
                placeBrimwoodLeaves(level, pos2.west().west().west());
                addVineGiant(level, pos2.west().west().west());
            }
            if (isReplaceable(level, pos2.south().west().west().west())) {
                placeBrimwoodLeaves(level, pos2.south().west().west().west());
                addVineGiant(level, pos2.south().west().west().west());
            }
            if (isReplaceable(level, pos2.south().south().west().west().west())) {
                placeBrimwoodLeaves(level, pos2.south().south().west().west().west());
                addVineGiant(level, pos2.south().south().west().west().west());
            }
            if (isReplaceable(level, pos2.north().west().west().west())) {
                placeBrimwoodLeaves(level, pos2.north().west().west().west());
                addVineGiant(level, pos2.north().west().west().west());
            }
            if (isReplaceable(level, pos2.north().north().west().west().west())) {
                placeBrimwoodLeaves(level, pos2.north().north().west().west().west());
                addVineGiant(level, pos2.north().north().west().west().west());
            }
            //SOUTH-WEST
            if (isReplaceable(level, pos2.south().west())) {
                placeBrimwoodLeaves(level, pos2.south().west());
            }
            if (isReplaceable(level, pos2.south().south().west())) {
                placeBrimwoodLeaves(level, pos2.south().south().west());
                addVineGiant(level, pos2.south().south().west());
            }
            if (isReplaceable(level, pos2.south().west().west())) {
                placeBrimwoodLeaves(level, pos2.south().west().west());
                addVineGiant(level, pos2.south().west().west());
            }
            if (isReplaceable(level, pos2.south().south().west().west())) {
                placeBrimwoodLeaves(level, pos2.south().south().west().west());
                addVineGiant(level, pos2.south().south().west().west());
            }
            //SOUTH
            if (isReplaceable(level, pos2.south())) {
                placeBrimwoodLeaves(level, pos2.south());
            }
            if (isReplaceable(level, pos2.south().south())) {
                placeBrimwoodLeaves(level, pos2.south().south());
            }
            if (isReplaceable(level, pos2.south().south().south())) {
                placeBrimwoodLeaves(level, pos2.south().south().south());
                addVineGiant(level, pos2.south().south().south());
            }
            if (isReplaceable(level, pos2.east().south().south().south())) {
                placeBrimwoodLeaves(level, pos2.east().south().south().south());
                addVineGiant(level, pos2.east().south().south().south());
            }
            if (isReplaceable(level, pos2.east().east().south().south().south())) {
                placeBrimwoodLeaves(level, pos2.east().east().south().south().south());
                addVineGiant(level, pos2.east().east().south().south().south());
            }
            if (isReplaceable(level, pos2.west().south().south().south())) {
                placeBrimwoodLeaves(level, pos2.west().south().south().south());
                addVineGiant(level, pos2.west().south().south().south());
            }
            if (isReplaceable(level, pos2.west().west().south().south().south())) {
                placeBrimwoodLeaves(level, pos2.west().west().south().south().south());
                addVineGiant(level, pos2.west().west().south().south().south());
            }
            //SOUTH-EAST
            if (isReplaceable(level, pos2.south().east())) {
                placeBrimwoodLeaves(level, pos2.south().east());
            }
            if (isReplaceable(level, pos2.south().south().east())) {
                placeBrimwoodLeaves(level, pos2.south().south().east());
                addVineGiant(level, pos2.south().south().east());
            }
            if (isReplaceable(level, pos2.south().east().east())) {
                placeBrimwoodLeaves(level, pos2.south().east().east());
                addVineGiant(level, pos2.south().east().east());
            }
            if (isReplaceable(level, pos2.south().south().east().east())) {
                placeBrimwoodLeaves(level, pos2.south().south().east().east());
                addVineGiant(level, pos2.south().south().east().east());
            }
            //EAST
            if (isReplaceable(level, pos2.east())) {
                placeBrimwoodLeaves(level, pos2.east());
            }
            if (isReplaceable(level, pos2.east().east())) {
                placeBrimwoodLeaves(level, pos2.east().east());
            }
            if (isReplaceable(level, pos2.east().east().east())) {
                placeBrimwoodLeaves(level, pos2.east().east().east());
                addVineGiant(level, pos2.east().east().east());
            }
            if (isReplaceable(level, pos2.south().east().east().east())) {
                placeBrimwoodLeaves(level, pos2.south().east().east().east());
                addVineGiant(level, pos2.south().east().east().east());
            }
            if (isReplaceable(level, pos2.south().south().east().east().east())) {
                placeBrimwoodLeaves(level, pos2.south().south().east().east().east());
                addVineGiant(level, pos2.south().south().east().east().east());
            }
            if (isReplaceable(level, pos2.north().east().east().east())) {
                placeBrimwoodLeaves(level, pos2.north().east().east().east());
                addVineGiant(level, pos2.north().east().east().east());
            }
            if (isReplaceable(level, pos2.north().north().east().east().east())) {
                placeBrimwoodLeaves(level, pos2.north().north().east().east().east());
                addVineGiant(level, pos2.north().north().east().east().east());
            }
            //NORTH-EAST
            if (isReplaceable(level, pos2.north().east())) {
                placeBrimwoodLeaves(level, pos2.north().east());
            }
            if (isReplaceable(level, pos2.north().north().east())) {
                placeBrimwoodLeaves(level, pos2.north().north().east());
                addVineGiant(level, pos2.north().north().east());
            }
            if (isReplaceable(level, pos2.north().east().east())) {
                placeBrimwoodLeaves(level, pos2.north().east().east());
                addVineGiant(level, pos2.north().east().east());
            }
            if (isReplaceable(level, pos2.north().north().east().east())) {
                placeBrimwoodLeaves(level, pos2.north().north().east().east());
                addVineGiant(level, pos2.north().north().east().east());
            }
        }
    }

    private void addVine(LevelAccessor level, BlockPos pos) {
        Random random = new Random();
        int size = random.nextInt(3);
        BlockPos place = pos.above();
        for(int i = 0; i<=size; i++){
            if(isAir(level, place)){
                if(i==size){
                    placeBrimwoodLeaves(level, place);
                }
                else {
                    placeBrimwoodLeaves(level, place);
                }
                place = place.above();
            }
            else{
                if(i!=0){
                    placeBrimwoodLeaves(level, place.below());
                }
                break;
            }
        }
    }

    private void addVineGiant(LevelAccessor level, BlockPos pos) {
        Random random = new Random();
        int size = random.nextInt(4);
        BlockPos place = pos.above();
        for(int i = 0; i<=size; i++){
            if(isAir(level, place)){
                if(i==size){
                    placeBrimwoodLeaves(level, place);
                }
                else {
                    placeBrimwoodLeaves(level, place);
                }
                place = place.above();
            }
            else{
                if(i!=0){
                    placeBrimwoodLeaves(level, place.below());
                }
                break;
            }
        }
    }

    public static boolean isAirBlock(BlockState state) {
        return state.is(Blocks.AIR)||state.is(Blocks.CAVE_AIR)||state.is(Blocks.VOID_AIR);
    }

    public static boolean isAir(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, TallBrimWillowFeature::isAirBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, TallBrimWillowFeature::isReplaceableBlock);
    }
}