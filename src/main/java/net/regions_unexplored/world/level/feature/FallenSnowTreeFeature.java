package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.world.level.feature.configuration.FallenTreeConfiguration;

import java.util.Random;

public class FallenSnowTreeFeature extends Feature<FallenTreeConfiguration> {

    public FallenSnowTreeFeature(Codec<FallenTreeConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<FallenTreeConfiguration> context) {
        FallenTreeConfiguration treeConfiguration = context.config();

        BlockPos pos = context.origin();

        RandomSource randomSource = context.random();

        WorldGenLevel level = context.level();

        int direction = randomSource.nextInt(4);

        int height = context.random().nextInt(treeConfiguration.sizeVariation) + treeConfiguration.minimumSize;

        if(level.isOutsideBuildHeight(pos)){
            return false;
        }

        int placeCheck = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while (placeCheck <= height && level.getBlockState(placePos.below()).isFaceSturdy(level, placePos.below(), Direction.UP)) {
            if(!level.getBlockState(placePos.below()).isFaceSturdy(level, placePos.below(), Direction.UP)) {
                return true;
            }
            if(!isReplaceable(level, placePos)) {
                return true;
            }
            if(direction==0){
                if(placeCheck == 0){
                    placeStump(level, placePos, randomSource, treeConfiguration);
                    placeSnow(level, placePos.north(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.south(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.east(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.west(), randomSource, treeConfiguration);
                    placePos.move(Direction.NORTH);
                }
                else{
                    placeLogZ(level, placePos, randomSource, treeConfiguration);
                    placeSnow(level, placePos.east(), randomSource, treeConfiguration);
                    placeSnowAbove(level, placePos.above(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.west(), randomSource, treeConfiguration);
                }
                if(placeCheck == height){
                    if(height> treeConfiguration.minimumSize+1) {
                        if(treeConfiguration.hasLeaves) {
                            placeLeavesBlobNorth(level,placePos,randomSource,treeConfiguration);
                        }
                    }
                }
                placePos.move(Direction.NORTH);
                placeCheck = placeCheck + 1;
            }
            else if(direction==1){
                if(placeCheck == 0){
                    placeStump(level, placePos, randomSource, treeConfiguration);
                    placeSnow(level, placePos.north(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.south(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.east(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.west(), randomSource, treeConfiguration);
                    placePos.move(Direction.SOUTH);
                }
                else{
                    placeLogZ(level, placePos, randomSource, treeConfiguration);
                    placeSnow(level, placePos.east(), randomSource, treeConfiguration);
                    placeSnowAbove(level, placePos.above(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.west(), randomSource, treeConfiguration);
                }
                if(placeCheck == height){
                    if(height> treeConfiguration.minimumSize+1) {
                        if(treeConfiguration.hasLeaves) {
                            placeLeavesBlobSouth(level,placePos,randomSource,treeConfiguration);
                        }
                    }
                }
                placePos.move(Direction.SOUTH);
                placeCheck = placeCheck + 1;
            }
            else if(direction==2){
                if(placeCheck == 0){
                    placeStump(level, placePos, randomSource, treeConfiguration);
                    placeSnow(level, placePos.north(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.south(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.east(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.west(), randomSource, treeConfiguration);
                    placePos.move(Direction.EAST);
                }
                else{
                    placeLogX(level, placePos, randomSource, treeConfiguration);
                    placeSnow(level, placePos.north(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.above(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.south(), randomSource, treeConfiguration);
                }
                if(placeCheck == height){
                    if(height> treeConfiguration.minimumSize+1) {
                        if(treeConfiguration.hasLeaves) {
                            placeLeavesBlobEast(level,placePos,randomSource,treeConfiguration);
                        }
                    }
                }
                placePos.move(Direction.EAST);
                placeCheck = placeCheck + 1;
            }
            else if(direction==3){
                if(placeCheck == 0){
                    placeStump(level, placePos, randomSource, treeConfiguration);
                    placeSnow(level, placePos.north(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.south(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.east(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.west(), randomSource, treeConfiguration);
                    placePos.move(Direction.WEST);
                }
                else{
                    placeLogX(level, placePos, randomSource, treeConfiguration);
                    placeSnow(level, placePos.north(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.above(), randomSource, treeConfiguration);
                    placeSnow(level, placePos.south(), randomSource, treeConfiguration);
                }
                if(placeCheck == height){
                    if(height> treeConfiguration.minimumSize+1) {
                        if(treeConfiguration.hasLeaves) {
                            placeLeavesBlobWest(level,placePos,randomSource,treeConfiguration);
                        }
                    }
                }
                placePos.move(Direction.WEST);
                placeCheck = placeCheck + 1;
            }
        }
        return true;
    }

    //BlockPlacers
    public boolean placeStump(LevelAccessor level, BlockPos pos, RandomSource randomSource, FallenTreeConfiguration treeConfiguration) {
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
            if(level.getBlockState(pos).getBlock() instanceof DoublePlantBlock){
                level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 2);
            }
            level.setBlock(pos, treeConfiguration.stumpProvider.getState(randomSource, pos), 2);
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
    public boolean placeLogX(LevelAccessor level, BlockPos pos, RandomSource randomSource, FallenTreeConfiguration treeConfiguration) {
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
            if(level.getBlockState(pos).getBlock() instanceof DoublePlantBlock){
                level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 2);
            }
            level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.X), 2);
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
    public boolean placeLogZ(LevelAccessor level, BlockPos pos, RandomSource randomSource, FallenTreeConfiguration treeConfiguration) {
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
            if(level.getBlockState(pos).getBlock() instanceof DoublePlantBlock){
                level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 2);
            }
            level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z), 2);
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
    public boolean placeSnow(LevelAccessor level, BlockPos pos, RandomSource randomSource, FallenTreeConfiguration treeConfiguration) {
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).canBeReplaced()&&randomSource.nextInt(5)==0){
            if(level.getBlockState(pos.below()).isFaceSturdy(level, pos.below(), Direction.UP)) {
                if(level.getBlockState(pos).getBlock() instanceof DoublePlantBlock){
                    level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 2);
                }
                level.setBlock(pos, Blocks.SNOW.defaultBlockState(), 2);
            }
        }
        return true;
    }
    public boolean placeSnowAbove(LevelAccessor level, BlockPos pos, RandomSource randomSource, FallenTreeConfiguration treeConfiguration) {
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).canBeReplaced()&&randomSource.nextInt(2)==0){
            if(level.getBlockState(pos.below()).isFaceSturdy(level, pos.below(), Direction.UP)) {
                if(level.getBlockState(pos).getBlock() instanceof DoublePlantBlock){
                    level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 2);
                }
                level.setBlock(pos, Blocks.SNOW.defaultBlockState(), 2);
            }
        }
        return true;
    }
    public boolean placeLeaves(LevelAccessor level, BlockPos pos, RandomSource randomSource, FallenTreeConfiguration treeConfiguration) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).canBeReplaced()||level.getBlockState(pos).is(Blocks.MOSS_CARPET)) {
            if(level.getBlockState(pos).getBlock() instanceof DoublePlantBlock){
                level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 2);
            }
            level.setBlock(pos, treeConfiguration.foliageProvider.getState(randomSource, pos), 2);
        }
        return true;
    }

    public boolean placeLeavesLayerX(LevelAccessor level, BlockPos pos, RandomSource randomSource, FallenTreeConfiguration treeConfiguration) {
        Random random = new Random();
        placeLeaves(level,pos,randomSource,treeConfiguration);
        placeLeaves(level,pos.above(),randomSource,treeConfiguration);
        placeLeaves(level,pos.below(),randomSource,treeConfiguration);
        placeLeaves(level,pos.north(),randomSource,treeConfiguration);
        placeLeaves(level,pos.south(),randomSource,treeConfiguration);
        placeLeaves(level,pos.above().north(),randomSource,treeConfiguration);
        placeLeaves(level,pos.above().south(),randomSource,treeConfiguration);
        placeLeaves(level,pos.below().north(),randomSource,treeConfiguration);
        placeLeaves(level,pos.below().south(),randomSource,treeConfiguration);

        if(random.nextInt(3)!=0){
            placeLeaves(level,pos.above().above(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0){
            placeLeaves(level,pos.above().above().north(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0){
            placeLeaves(level,pos.above().above().south(),randomSource,treeConfiguration);
        }

        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.below().below(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.below().below().north(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.below().below().south(),randomSource,treeConfiguration);
        }

        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.north().north(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.north().north().above(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.north().north().below(),randomSource,treeConfiguration);
        }

        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.south().south(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.south().south().above(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.south().south().below(),randomSource,treeConfiguration);
        }
        return true;
    }
    public boolean placeLeavesLayerZ(LevelAccessor level, BlockPos pos, RandomSource randomSource, FallenTreeConfiguration treeConfiguration) {
        Random random = new Random();
        placeLeaves(level,pos,randomSource,treeConfiguration);
        placeLeaves(level,pos.above(),randomSource,treeConfiguration);
        placeLeaves(level,pos.below(),randomSource,treeConfiguration);
        placeLeaves(level,pos.east(),randomSource,treeConfiguration);
        placeLeaves(level,pos.west(),randomSource,treeConfiguration);
        placeLeaves(level,pos.above().east(),randomSource,treeConfiguration);
        placeLeaves(level,pos.above().west(),randomSource,treeConfiguration);
        placeLeaves(level,pos.below().east(),randomSource,treeConfiguration);
        placeLeaves(level,pos.below().west(),randomSource,treeConfiguration);

        if(random.nextInt(3)!=0){
        placeLeaves(level,pos.above().above(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0){
        placeLeaves(level,pos.above().above().east(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0){
        placeLeaves(level,pos.above().above().west(),randomSource,treeConfiguration);
        }

        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.below().below(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.below().below().east(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.below().below().west(),randomSource,treeConfiguration);
        }

        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.east().east(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.east().east().above(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.east().east().below(),randomSource,treeConfiguration);
        }

        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.west().west(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.west().west().above(),randomSource,treeConfiguration);
        }
        if(random.nextInt(3)!=0) {
            placeLeaves(level,pos.west().west().below(),randomSource,treeConfiguration);
        }
        return true;
    }

    public boolean placeLeavesBlobNorth(LevelAccessor level, BlockPos pos, RandomSource randomSource, FallenTreeConfiguration treeConfiguration) {
        Random random = new Random();
        placeLeavesLayerZ(level,pos.south().south(),randomSource,treeConfiguration);
        placeLeavesLayerZ(level,pos.south(),randomSource,treeConfiguration);

        placeLeaves(level,pos,randomSource,treeConfiguration);
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.above(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.below(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.east(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.west(),randomSource,treeConfiguration);
        }

        placeLeaves(level,pos.north(),randomSource,treeConfiguration);
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.north().above(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.north().below(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.north().east(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.north().west(),randomSource,treeConfiguration);
        }
        return true;
    }
    public boolean placeLeavesBlobSouth(LevelAccessor level, BlockPos pos, RandomSource randomSource, FallenTreeConfiguration treeConfiguration) {
        Random random = new Random();
        placeLeavesLayerZ(level,pos.north().north(),randomSource,treeConfiguration);
        placeLeavesLayerZ(level,pos.north(),randomSource,treeConfiguration);

        placeLeaves(level,pos,randomSource,treeConfiguration);
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.above(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.below(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.east(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.west(),randomSource,treeConfiguration);
        }

        placeLeaves(level,pos.south(),randomSource,treeConfiguration);
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.south().above(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.south().below(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.south().east(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.south().west(),randomSource,treeConfiguration);
        }
        return true;
    }
    public boolean placeLeavesBlobEast(LevelAccessor level, BlockPos pos, RandomSource randomSource, FallenTreeConfiguration treeConfiguration) {
        Random random = new Random();
        placeLeavesLayerX(level,pos.west().west(),randomSource,treeConfiguration);
        placeLeavesLayerX(level,pos.west(),randomSource,treeConfiguration);

        placeLeaves(level,pos,randomSource,treeConfiguration);
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.above(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.below(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.north(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.south(),randomSource,treeConfiguration);
        }

        placeLeaves(level,pos.east(),randomSource,treeConfiguration);
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.east().above(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.east().below(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.east().north(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.east().south(),randomSource,treeConfiguration);
        }
        return true;
    }
    public boolean placeLeavesBlobWest(LevelAccessor level, BlockPos pos, RandomSource randomSource, FallenTreeConfiguration treeConfiguration) {
        Random random = new Random();
        placeLeavesLayerX(level,pos.east().east(),randomSource,treeConfiguration);
        placeLeavesLayerX(level,pos.east(),randomSource,treeConfiguration);

        placeLeaves(level,pos,randomSource,treeConfiguration);
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.above(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.below(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.north(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.south(),randomSource,treeConfiguration);
        }

        placeLeaves(level,pos.west(),randomSource,treeConfiguration);
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.west().above(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.west().below(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.west().north(),randomSource,treeConfiguration);
        }
        if(random.nextInt(4)!=0) {
            placeLeaves(level,pos.west().south(),randomSource,treeConfiguration);
        }
        return true;
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, FallenSnowTreeFeature::isReplaceableBlock);
    }
}