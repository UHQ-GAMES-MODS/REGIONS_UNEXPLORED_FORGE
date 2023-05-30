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
import net.regions_unexplored.world.level.block.log.MagmaLogBlock;

import java.util.Random;

public class BrimWillowFeature extends Feature<NoneFeatureConfiguration> {

    public BrimWillowFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        int height = context.random().nextInt(4)+8;

        if(level.getBlockState(pos.north()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.north().north()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.west()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.west().west()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.east()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.east().east()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.south()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
            return false;
        }
        if(level.getBlockState(pos.south().south()).getBlock() == RuBlocks.BRIMWOOD_LOG_MAGMA.get()){
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

        if(level.getBlockState(pos.below()).getBlock()== Blocks.SCULK||level.getBlockState(pos.below()).getBlock()== RuBlocks.BRIMSPROUT_NYLIUM.get()||level.getBlockState(pos.below()).is(BlockTags.NYLIUM)||level.getBlockState(pos.below()).is(BlockTags.DIRT)){
        }
        else{
            return false;
        }

        if (level.isEmptyBlock(pos)) {
            BlockPos.MutableBlockPos placePos = pos.mutable();

            for(int i = 0; i<=height; i++){
                if(i==height-3){
                    placeBranches(level, placePos);
                }
                if(i==height-5){
                    placeSpine(level, placePos);
                }
                if(isReplaceable(level, placePos)){
                    if(i==2){
                        level.setBlock(placePos, RuBlocks.BRIMWOOD_LOG_MAGMA.get().defaultBlockState().setValue(MagmaLogBlock.TRANSITION_BLOCK, true), 2);
                    }
                    else if(i<2){
                        level.setBlock(placePos, RuBlocks.BRIMWOOD_LOG_MAGMA.get().defaultBlockState().setValue(MagmaLogBlock.TRANSITION_BLOCK, false), 2);
                    }
                    else if(i>2){
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

    private void placeBranches(LevelAccessor level, BlockPos pos) {
        //NORTH
        if(isReplaceable(level, pos.north())){
            if(isReplaceable(level, pos.north())){
                level.setBlock(pos.north(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
            }
            if(isReplaceable(level, pos.north().above().north())){
                level.setBlock(pos.north().above().north(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
            }
            if(isReplaceable(level, pos.north().above().north().north())){
                level.setBlock(pos.north().above().north().north(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
            }
            if(isReplaceable(level, pos.north().above().north().north().north())){
                level.setBlock(pos.north().above().north().north().north(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
                placeLeavesUpsideDown(level, pos.north().above().north().north().north());
            }
        }
        //SOUTH
        if(isReplaceable(level, pos.south())){
            if(isReplaceable(level, pos.south())){
                level.setBlock(pos.south(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
            }
            if(isReplaceable(level, pos.south().above().south())){
                level.setBlock(pos.south().above().south(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
            }
            if(isReplaceable(level, pos.south().above().south().south())){
                level.setBlock(pos.south().above().south().south(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
            }
            if(isReplaceable(level, pos.south().above().south().south().south())){
                level.setBlock(pos.south().above().south().south().south(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
                placeLeavesUpsideDown(level, pos.south().above().south().south().south());
            }
        }
        //EAST
        if(isReplaceable(level, pos.east())){
            if(isReplaceable(level, pos.east())){
                level.setBlock(pos.east(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
            }
            if(isReplaceable(level, pos.east().above().east())){
                level.setBlock(pos.east().above().east(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
            }
            if(isReplaceable(level, pos.east().above().east().east())){
                level.setBlock(pos.east().above().east().east(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
            }
            if(isReplaceable(level, pos.east().above().east().east().east())){
                level.setBlock(pos.east().above().east().east().east(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
                placeLeavesUpsideDown(level, pos.east().above().east().east().east());
            }
        }
        //WEST
        if(isReplaceable(level, pos.west())){
            if(isReplaceable(level, pos.west())){
                level.setBlock(pos.west(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
            }
            if(isReplaceable(level, pos.west().above().west())){
                level.setBlock(pos.west().above().west(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
            }
            if(isReplaceable(level, pos.west().above().west().west())){
                level.setBlock(pos.west().above().west().west(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
            }
            if(isReplaceable(level, pos.west().above().west().west().west())){
                level.setBlock(pos.west().above().west().west().west(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
                placeLeavesUpsideDown(level, pos.west().above().west().west().west());
            }
        }
    }

    private void placeSpine(LevelAccessor level, BlockPos pos) {
        //NORTH
        if(isReplaceable(level, pos.north())){
                level.setBlock(pos.north(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
        }
        //SOUTH
        if(isReplaceable(level, pos.south())){
                level.setBlock(pos.south(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
        }
        //EAST
        if(isReplaceable(level, pos.east())){
                level.setBlock(pos.east(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
        }
        //WEST
        if(isReplaceable(level, pos.west())){
                level.setBlock(pos.west(), RuBlocks.BRIMWOOD_LOG.get().defaultBlockState().setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
        }
    }

    private void placeLeavesUpsideDown(LevelAccessor level, BlockPos pos) {
        if (isReplaceable(level, pos)) {
            level.setBlock(pos, RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        //TOP
        if (isReplaceable(level, pos.above())) {
            level.setBlock(pos.above(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.above().north())) {
            level.setBlock(pos.above().north(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.above().north().east())) {
            level.setBlock(pos.above().north().east(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.above().north().west())) {
            level.setBlock(pos.above().north().west(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.above().south())) {
            level.setBlock(pos.above().south(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.above().south().east())) {
            level.setBlock(pos.above().south().east(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.above().south().west())) {
            level.setBlock(pos.above().south().west(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.above().east())) {
            level.setBlock(pos.above().east(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.above().west())) {
            level.setBlock(pos.above().west(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        //NORTH
        if (isReplaceable(level, pos.north())) {
            level.setBlock(pos.north(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.north().north().above())) {
            level.setBlock(pos.north().north().above(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
            addVine(level,pos.north().north().above());
        }
        //NORTH-WEST
        if (isReplaceable(level, pos.north().west())) {
            level.setBlock(pos.north().west(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.north().north().west().above())) {
            level.setBlock(pos.north().north().west().above(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
            addVine(level,pos.north().north().west().above());
        }
        if (isReplaceable(level, pos.north().west().west().above())) {
            level.setBlock(pos.north().west().west().above(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
            addVine(level,pos.north().west().west().above());
        }
        //WEST
        if (isReplaceable(level, pos.west())) {
            level.setBlock(pos.west(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.west().west().above())) {
            level.setBlock(pos.west().west().above(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
            addVine(level,pos.west().west().above());
        }
        //SOUTH-WEST
        if (isReplaceable(level, pos.south().west())) {
            level.setBlock(pos.south().west(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.south().south().west().above())) {
            level.setBlock(pos.south().south().west().above(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
            addVine(level,pos.south().south().west().above());
        }
        if (isReplaceable(level, pos.south().west().west().above())) {
            level.setBlock(pos.south().west().west().above(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
            addVine(level,pos.south().west().west().above());
        }
        //SOUTH
        if (isReplaceable(level, pos.south())) {
            level.setBlock(pos.south(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.south().south().above())) {
            level.setBlock(pos.south().south().above(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
            addVine(level,pos.south().south().above());
        }
        //SOUTH-EAST
        if (isReplaceable(level, pos.south().east())) {
            level.setBlock(pos.south().east(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.south().south().east().above())) {
            level.setBlock(pos.south().south().east().above(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
            addVine(level,pos.south().south().east().above());
        }
        if (isReplaceable(level, pos.south().east().east().above())) {
            level.setBlock(pos.south().east().east().above(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
            addVine(level,pos.south().east().east().above());
        }
        //EAST
        if (isReplaceable(level, pos.east())) {
            level.setBlock(pos.east(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.east().east().above())) {
            level.setBlock(pos.east().east().above(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
            addVine(level,pos.east().east().above());
        }
        //NORTH-EAST
        if (isReplaceable(level, pos.north().east())) {
            level.setBlock(pos.north().east(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
        }
        if (isReplaceable(level, pos.north().north().east().above())) {
            level.setBlock(pos.north().north().east().above(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
            addVine(level,pos.north().north().east().above());
        }
        if (isReplaceable(level, pos.north().east().east().above())) {
            level.setBlock(pos.north().east().east().above(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
            addVine(level,pos.north().east().east().above());
        }
    }

    private void addVine(LevelAccessor level, BlockPos pos) {
        Random random = new Random();
        int size = random.nextInt(3);
        BlockPos place = pos.above();
        for(int i = 0; i<=size; i++){
            if(isAir(level, place)){
                if(i==size){
                    level.setBlock(place, RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
                }
                else {
                    level.setBlock(place, RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
                }
                place = place.above();
            }
            else{
                if(i!=0){
                    level.setBlock(place.below(), RuBlocks.BRIMWOOD_LEAVES.get().defaultBlockState().setValue(LeavesBlock.PERSISTENT, true), 2);
                }
                break;
            }
        }
    }

    public static boolean isAirBlock(BlockState state) {
        return state.is(Blocks.AIR)||state.is(Blocks.CAVE_AIR)||state.is(Blocks.VOID_AIR);
    }

    public static boolean isAir(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, BrimWillowFeature::isAirBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, BrimWillowFeature::isReplaceableBlock);
    }
}