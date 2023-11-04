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
import net.regions_unexplored.world.level.block.plant.other.SpanishMossBlock;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;

import java.util.Random;

public class KapokTreeFeature extends Feature<RuTreeConfiguration> {

    public KapokTreeFeature(Codec<RuTreeConfiguration> codec) {
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
                placeRoot(level, placePos.north(), randomSource, treeConfiguration);
                placeRoot(level, placePos.south(), randomSource, treeConfiguration);
                placeRoot(level, placePos.east(), randomSource, treeConfiguration);
                placeRoot(level, placePos.west(), randomSource, treeConfiguration);

                placeRoot(level, placePos.north().above(), randomSource, treeConfiguration);
                placeRoot(level, placePos.south().above(), randomSource, treeConfiguration);
                placeRoot(level, placePos.east().above(), randomSource, treeConfiguration);
                placeRoot(level, placePos.west().above(), randomSource, treeConfiguration);

                placeRoot(level, placePos.north().above(2), randomSource, treeConfiguration);
                placeRoot(level, placePos.south().above(2), randomSource, treeConfiguration);
                placeRoot(level, placePos.east().above(2), randomSource, treeConfiguration);
                placeRoot(level, placePos.west().above(2), randomSource, treeConfiguration);

                placeRoot(level, placePos.north().above(3), randomSource, treeConfiguration);
                placeRoot(level, placePos.south().above(3), randomSource, treeConfiguration);
                placeRoot(level, placePos.east().above(3), randomSource, treeConfiguration);
                placeRoot(level, placePos.west().above(3), randomSource, treeConfiguration);

                placeRoot(level, placePos.north().above(4), randomSource, treeConfiguration);
                placeRoot(level, placePos.south().above(4), randomSource, treeConfiguration);
                placeRoot(level, placePos.east().above(4), randomSource, treeConfiguration);
                placeRoot(level, placePos.west().above(4), randomSource, treeConfiguration);

                if(randomSource.nextInt(3)==0) {
                    placeRoot(level, placePos.north().above(5), randomSource, treeConfiguration);
                }
                if(randomSource.nextInt(3)==0) {
                    placeRoot(level, placePos.south().above(5), randomSource, treeConfiguration);
                }
                if(randomSource.nextInt(3)==0) {
                    placeRoot(level, placePos.east().above(5), randomSource, treeConfiguration);
                }
                if(randomSource.nextInt(3)==0) {
                    placeRoot(level, placePos.west().above(5), randomSource, treeConfiguration);
                }

                placeRoot(level, placePos.north(2), randomSource, treeConfiguration);
                placeRoot(level, placePos.south(2), randomSource, treeConfiguration);
                placeRoot(level, placePos.east(2), randomSource, treeConfiguration);
                placeRoot(level, placePos.west(2), randomSource, treeConfiguration);

                placeRoot(level, placePos.north(2).above(), randomSource, treeConfiguration);
                placeRoot(level, placePos.south(2).above(), randomSource, treeConfiguration);
                placeRoot(level, placePos.east(2).above(), randomSource, treeConfiguration);
                placeRoot(level, placePos.west(2).above(), randomSource, treeConfiguration);

                placeRoot(level, placePos.north(2).above(2), randomSource, treeConfiguration);
                placeRoot(level, placePos.south(2).above(2), randomSource, treeConfiguration);
                placeRoot(level, placePos.east(2).above(2), randomSource, treeConfiguration);
                placeRoot(level, placePos.west(2).above(2), randomSource, treeConfiguration);

                if(level.getBlockState(placePos.north(3).below(2)).is(BlockTags.DIRT)){
                    placeRoot(level, placePos.north(3), randomSource, treeConfiguration);
                }
                if(level.getBlockState(placePos.south(3).below(2)).is(BlockTags.DIRT)){
                    placeRoot(level, placePos.south(3), randomSource, treeConfiguration);
                }
                if(level.getBlockState(placePos.east(3).below(2)).is(BlockTags.DIRT)){
                    placeRoot(level, placePos.east(3), randomSource, treeConfiguration);
                }
                if(level.getBlockState(placePos.east(3).below(2)).is(BlockTags.DIRT)){
                    placeRoot(level, placePos.east(3), randomSource, treeConfiguration);
                }
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
        BlockPos.MutableBlockPos placePos = new BlockPos.MutableBlockPos(pos.getX(),pos.getY()-5,pos.getZ());
        int n = randomSource.nextInt(4);
        int s = randomSource.nextInt(4);
        int e = randomSource.nextInt(4);
        int w = randomSource.nextInt(4);
        placeLimb(level, placePos.above(n), randomSource, treeConfiguration, Direction.NORTH);
        placeLimb(level, placePos.above(s), randomSource, treeConfiguration, Direction.SOUTH);
        placeLimb(level, placePos.above(e), randomSource, treeConfiguration, Direction.EAST);
        placeLimb(level, placePos.above(w), randomSource, treeConfiguration, Direction.WEST);

        placeLeavesBlob(level,pos,randomSource,treeConfiguration);
    }

    public void placeLimb(LevelAccessor level, BlockPos pos1, RandomSource randomSource, RuTreeConfiguration treeConfiguration, Direction direction){
        int type = randomSource.nextInt(8);
        BlockPos.MutableBlockPos pos = pos1.mutable();

        if(type==0){
            pos.move(direction);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            pos.move(Direction.UP);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            placeLeavesBlob(level,pos,randomSource,treeConfiguration);
        }
        else if(type==1){
            pos.move(direction);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            pos.move(Direction.UP);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            pos.move(Direction.UP);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            placeLeavesBlob(level,pos,randomSource,treeConfiguration);
        }
        else if(type==2){
            pos.move(direction);
            placeLog(level,pos,randomSource,treeConfiguration,direction.getAxis());
            placeLogWithVines(level,pos.below(),randomSource,treeConfiguration, Direction.Axis.Y);
            pos.move(direction);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            pos.move(Direction.UP);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,Direction.Axis.Y);
            pos.move(Direction.UP);
            placeLog(level,pos,randomSource,treeConfiguration,Direction.Axis.Y);
            placeLeavesBlob(level,pos,randomSource,treeConfiguration);
        }
        else if(type==3){
            pos.move(direction);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            pos.move(Direction.UP);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            pos.move(Direction.UP);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,Direction.Axis.Y);
            pos.move(Direction.UP);
            placeLog(level,pos,randomSource,treeConfiguration,Direction.Axis.Y);
            placeLeavesBlob(level,pos,randomSource,treeConfiguration);
        }
        else if(type==4){
            pos.move(direction);
            placeLog(level,pos,randomSource,treeConfiguration,direction.getAxis());
            placeLogWithVines(level,pos.below(2),randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            placeLog(level,pos,randomSource,treeConfiguration,direction.getAxis());
            placeLogWithVines(level,pos.below(),randomSource,treeConfiguration, Direction.Axis.Y);
            pos.move(direction);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            pos.move(Direction.UP);
            placeLogWithVines(level,pos,randomSource,treeConfiguration, Direction.Axis.Y);
            pos.move(Direction.UP);
            placeLog(level,pos,randomSource,treeConfiguration, Direction.Axis.Y);
            placeLeavesBlob(level,pos,randomSource,treeConfiguration);
        }
        else if(type==5){
            pos.move(direction);
            placeLog(level,pos,randomSource,treeConfiguration,direction.getAxis());
            placeLogWithVines(level,pos.below(3),randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            placeLog(level,pos,randomSource,treeConfiguration,direction.getAxis());
            placeLog(level,pos.below(),randomSource,treeConfiguration,Direction.Axis.Y);
            placeLogWithVines(level,pos.below(2),randomSource,treeConfiguration,Direction.Axis.Y);
            pos.move(direction);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            placeLog(level,pos.above(),randomSource,treeConfiguration,Direction.Axis.Y);
            pos.move(direction);
            pos.move(Direction.UP);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,Direction.Axis.Y);
            pos.move(Direction.UP);
            placeLog(level,pos,randomSource,treeConfiguration,Direction.Axis.Y);
            placeLeavesBlob(level,pos,randomSource,treeConfiguration);
        }
        else if(type==6){
            pos.move(direction);
            placeLog(level,pos,randomSource,treeConfiguration,direction.getAxis());
            placeLogWithVines(level,pos.below(2),randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            placeLog(level,pos,randomSource,treeConfiguration,Direction.Axis.Y);
            placeLogWithVines(level,pos.below(),randomSource,treeConfiguration,Direction.Axis.Y);
            pos.move(direction);
            pos.move(Direction.UP);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            pos.move(Direction.UP);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,Direction.Axis.Y);
            placeLeavesBlob(level,pos,randomSource,treeConfiguration);
        }
        else if(type==7){
            pos.move(direction);
            placeLog(level,pos,randomSource,treeConfiguration,direction.getAxis());
            placeLogWithVines(level,pos.below(3),randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            placeLog(level,pos,randomSource,treeConfiguration,Direction.Axis.Y);
            placeLog(level,pos.below(),randomSource,treeConfiguration,Direction.Axis.Y);
            placeLogWithVines(level,pos.below(2),randomSource,treeConfiguration,Direction.Axis.Y);
            pos.move(direction);
            pos.move(Direction.UP);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(direction);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,direction.getAxis());
            pos.move(Direction.UP);
            placeLogWithVines(level,pos,randomSource,treeConfiguration,Direction.Axis.Y);
            placeLeavesBlob(level,pos,randomSource,treeConfiguration);
        }
    }

    public boolean placeLeavesBlob(LevelAccessor level, BlockPos pos1, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        BlockPos.MutableBlockPos pos = pos1.mutable();
        Random random = new Random();

        placeLeavesBlock(level, pos.below(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.below().west(), randomSource, treeConfiguration);

        placeLeavesBlock(level, pos, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2).south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2).south(), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.north(3), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.north(3).east(), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.north(3).west(), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.south(3), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.south(3).east(), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.south(3).west(), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.east(3), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.east(3).north(), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.east(3).south(), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.west(3), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.west(3).north(), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.west(3).south(), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.north(2).east(2), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.north(2).west(2), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.south(2).east(2), randomSource, treeConfiguration);
        placeLeavesBlockWithVines(level, pos.south(2).west(2), randomSource, treeConfiguration);

        pos.move(Direction.UP);

        placeLeavesBlock(level, pos, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2).south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2).south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(3), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).west(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).west(2), randomSource, treeConfiguration);

        pos.move(Direction.UP);

        placeLeavesBlock(level, pos, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south().west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(2).west(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(2).south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2).north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(2).south(), randomSource, treeConfiguration);

        pos.move(Direction.UP);

        placeLeavesBlock(level, pos, randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.north(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.south(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.east(), randomSource, treeConfiguration);
        placeLeavesBlock(level, pos.west(), randomSource, treeConfiguration);

        return true;
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

    public boolean placeLogWithVines(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration, Direction.Axis axis) {
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
            if(randomSource.nextInt(3)!=0) {
                placeVine(level,pos);
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

    private static void placeVine(LevelAccessor level, BlockPos pos) {
        Random random = new Random();
        int size = random.nextInt(10);
        BlockPos place = pos.below();
        for(int i = 0; i<=size; i++){
            if(level.getBlockState(place).isAir()){
                if(i==size){
                    level.setBlock(place, RuBlocks.KAPOK_VINES.get().defaultBlockState().setValue(SpanishMossBlock.AGE, 25), 2);
                }
                else {
                    level.setBlock(place, RuBlocks.KAPOK_VINES_PLANT.get().defaultBlockState(), 2);
                }
                place = place.below();
            }
            else{
                if(i!=0){
                    level.setBlock(place.above(), RuBlocks.KAPOK_VINES.get().defaultBlockState().setValue(SpanishMossBlock.AGE, 25), 2);
                }
                break;
            }
        }
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

    public boolean placeLeavesBlockWithVines(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).canBeReplaced()) {
            level.setBlock(pos, treeConfiguration.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
            if(randomSource.nextInt(3)==0) {
                placeVine(level,pos);
            }
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
        return reader.isStateAtPosition(pos, KapokTreeFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, KapokTreeFeature::isReplaceableBlock);
    }
}