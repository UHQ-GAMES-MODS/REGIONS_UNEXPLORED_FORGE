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
import net.regions_unexplored.world.level.block.plant.other.SaguaroCactusBlock;
import net.regions_unexplored.world.level.block.state.properties.SaguaroCactusShape;
import net.regions_unexplored.world.level.feature.configuration.RuTreeConfiguration;

import java.util.Random;

public class SaguaroCactusFeature extends Feature<RuTreeConfiguration> {

    public SaguaroCactusFeature(Codec<RuTreeConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<RuTreeConfiguration> context) {
        RuTreeConfiguration treeConfiguration = context.config();
        BlockPos pos = context.origin();
        RandomSource randomSource = context.random();
        WorldGenLevel level = context.level();
        int height_main = context.random().nextInt(treeConfiguration.sizeVariation) + treeConfiguration.minimumSize;

        BlockPos checkCactus = pos.above(3);
        if(level.getBlockState(checkCactus.north()).is(RuBlocks.SAGUARO_CACTUS.get())||
           level.getBlockState(checkCactus.south()).is(RuBlocks.SAGUARO_CACTUS.get())||
           level.getBlockState(checkCactus.east()).is(RuBlocks.SAGUARO_CACTUS.get())||
           level.getBlockState(checkCactus.west()).is(RuBlocks.SAGUARO_CACTUS.get())||
           level.getBlockState(checkCactus.north().east()).is(RuBlocks.SAGUARO_CACTUS.get())||
           level.getBlockState(checkCactus.north().west()).is(RuBlocks.SAGUARO_CACTUS.get())||
           level.getBlockState(checkCactus.south().east()).is(RuBlocks.SAGUARO_CACTUS.get())||
           level.getBlockState(checkCactus.south().west()).is(RuBlocks.SAGUARO_CACTUS.get())){
            return false;
        }

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
            placeCactusBlock(level, placePos, randomSource, treeConfiguration, SaguaroCactusShape.UP_DOWN);
            if(placeCheck == 0){
                placeRoot(level, placePos, randomSource, treeConfiguration);
                placeLimbs(level, placePos, randomSource, treeConfiguration);
            }
            if(placeCheck == height_main){
                placeChanceFlowerBlock(level, placePos.above(), randomSource, treeConfiguration);
            }
            placePos.move(Direction.UP);
            placeCheck = placeCheck + 1;
        }
        return true;
    }

    public void placeLimbs(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration){
        int bpx1 = randomSource.nextInt(2)+3;
        int bpx2 = randomSource.nextInt(2)+3;
        int bpx3 = randomSource.nextInt(2)+3;
        int bpx4 = randomSource.nextInt(2)+3;

        BlockPos newpos = new BlockPos(pos.getX()+1, pos.getY()+bpx1, pos.getZ());
        BlockPos newpos1 = new BlockPos(pos.getX()-1, pos.getY()+bpx2, pos.getZ());
        BlockPos newpos2 = new BlockPos(pos.getX(), pos.getY()+bpx3, pos.getZ()-1);
        BlockPos newpos3 = new BlockPos(pos.getX(), pos.getY()+bpx4, pos.getZ()+1);

        //LimbE
        placeCactusBlock(level, newpos, randomSource, treeConfiguration, SaguaroCactusShape.EAST_WEST);
        placeCactusBlock(level, newpos.east(), randomSource, treeConfiguration, SaguaroCactusShape.WEST_UP);
        placeCactusBlock(level, newpos.east().above(), randomSource, treeConfiguration, SaguaroCactusShape.UP_DOWN);
        placeCactusBlock(level, newpos.east().above().above(), randomSource, treeConfiguration, SaguaroCactusShape.UP_DOWN);
        placeChanceFlowerBlock(level, newpos.east().above().above().above(), randomSource, treeConfiguration);

        //LimbW
        placeCactusBlock(level, newpos1, randomSource, treeConfiguration, SaguaroCactusShape.EAST_WEST);
        placeCactusBlock(level, newpos1.west(), randomSource, treeConfiguration, SaguaroCactusShape.EAST_UP);
        placeCactusBlock(level, newpos1.west().above(), randomSource, treeConfiguration, SaguaroCactusShape.UP_DOWN);
        placeCactusBlock(level, newpos1.west().above().above(), randomSource, treeConfiguration, SaguaroCactusShape.UP_DOWN);
        placeChanceFlowerBlock(level, newpos1.west().above().above().above(), randomSource, treeConfiguration);

        //LimbN
        placeCactusBlock(level, newpos2, randomSource, treeConfiguration, SaguaroCactusShape.NORTH_SOUTH);
        placeCactusBlock(level, newpos2.north(), randomSource, treeConfiguration, SaguaroCactusShape.SOUTH_UP);
        placeCactusBlock(level, newpos2.north().above(), randomSource, treeConfiguration, SaguaroCactusShape.UP_DOWN);
        placeCactusBlock(level, newpos2.north().above().above(), randomSource, treeConfiguration, SaguaroCactusShape.UP_DOWN);
        placeChanceFlowerBlock(level, newpos2.north().above().above().above(), randomSource, treeConfiguration);

        //LimbN
        placeCactusBlock(level, newpos3, randomSource, treeConfiguration, SaguaroCactusShape.NORTH_SOUTH);
        placeCactusBlock(level, newpos3.south(), randomSource, treeConfiguration, SaguaroCactusShape.NORTH_UP);
        placeCactusBlock(level, newpos3.south().above(), randomSource, treeConfiguration, SaguaroCactusShape.UP_DOWN);
        placeCactusBlock(level, newpos3.south().above().above(), randomSource, treeConfiguration, SaguaroCactusShape.UP_DOWN);
        placeChanceFlowerBlock(level, newpos3.south().above().above().above(), randomSource, treeConfiguration);
    }

    public boolean placeCactusBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration, SaguaroCactusShape shape) {
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
            level.setBlock(pos, treeConfiguration.trunkProvider.getState(randomSource, pos).setValue(SaguaroCactusBlock.SHAPE, shape), 2);
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
                level.setBlock(placePos, Blocks.HANGING_ROOTS.defaultBlockState(), 2);
                break;
            }
            else if(level.getBlockState(placePos).is(BlockTags.DIRT)||level.getBlockState(placePos).is(BlockTags.REPLACEABLE_BY_TREES)||level.isEmptyBlock(placePos)){
                placeCactusBlock(level, placePos, randomSource, treeConfiguration, SaguaroCactusShape.UP_DOWN);
            }
            else{
                break;
            }
            placePos.move(Direction.DOWN);
            i++;
        }
    }
    public boolean placeChanceFlowerBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, RuTreeConfiguration treeConfiguration) {
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).canBeReplaced()&&randomSource.nextInt(4)==0) {
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
        return reader.isStateAtPosition(pos, SaguaroCactusFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, SaguaroCactusFeature::isReplaceableBlock);
    }
}