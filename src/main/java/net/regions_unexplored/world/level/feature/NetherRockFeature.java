package net.regions_unexplored.world.level.feature;

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
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;

import java.util.Random;

public class NetherRockFeature extends Feature<NoneFeatureConfiguration> {

    public NetherRockFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        RandomSource randomSource = context.random();
        WorldGenLevel level = context.level();
        int height_main = 5;
        int height_1 = randomSource.nextInt(3);
        int height_2 = randomSource.nextInt(3);
        int height_3 = randomSource.nextInt(3);
        int height_4 = randomSource.nextInt(3);

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
            if(placeCheck==0){
                placeBottom(level, placePos, randomSource);
                placeBottom(level, placePos.north(), randomSource);
                placeBottom(level, placePos.north().east(), randomSource);
                placeBottom(level, placePos.east(), randomSource);
            }
            if(placeCheck<=height_1){
                placeRandomBlock(level, placePos, randomSource);
                if(placeCheck==height_1){
                    placeTopBlock(level, placePos, randomSource);
                }
            }
            if(placeCheck<=height_2){
                placeRandomBlock(level, placePos.north(), randomSource);
                if(placeCheck==height_2){
                    placeTopBlock(level, placePos.north(), randomSource);
                }
            }
            if(placeCheck<=height_3){
                placeRandomBlock(level, placePos.north().east(), randomSource);
                if(placeCheck==height_3){
                    placeTopBlock(level, placePos.north().east(), randomSource);
                }
            }
            if(placeCheck<=height_4){
                placeRandomBlock(level, placePos.east(), randomSource);
                if(placeCheck==height_4){
                    placeTopBlock(level, placePos.east(), randomSource);
                }
            }
            placePos.move(Direction.UP);
            placeCheck = placeCheck + 1;
        }
        return true;
    }

    public boolean placeBottom(LevelAccessor level, BlockPos pos, RandomSource randomSource) {
        Random random = new Random();
        int rd = 2;
        int i = 0;
        boolean b = false;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while(i<=rd){
            if(level.getBlockState(placePos).is(RuBlocks.GLISTERING_NYLIUM.get())){
                b=true;
                level.setBlock(placePos, Blocks.NETHERRACK.defaultBlockState(), 2);
            }
            if(i==1&!level.getBlockState(placePos.below(2)).isAir()){
                level.setBlock(placePos.below(), Blocks.NETHERRACK.defaultBlockState(), 2);
            }
            placeNetherrack(level, placePos, randomSource);
            placePos.move(Direction.DOWN);
            if(b&&level.getBlockState(placePos).isAir()) return true;
            i++;
        }
        return true;
    }

    public boolean placeRandomBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource) {
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
                level.setBlock(pos, Blocks.BONE_BLOCK.defaultBlockState(), 2);
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

    public boolean placeNetherrack(LevelAccessor level, BlockPos pos, RandomSource randomSource) {
        boolean isBase = false;
        if(level.getBlockState(pos.below()).is(BlockTags.DIRT)){
            isBase = true;
        }
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(isReplaceable(level, pos)) {
            level.setBlock(pos, Blocks.BONE_BLOCK.defaultBlockState(), 2);
        }
            return true;
    }

    public void placeTopBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource) {
        if(randomSource.nextInt(3)!=0) {
            level.setBlock(pos, RuBlocks.OVERGROWN_BONE_BLOCK.get().defaultBlockState(), 2);
        }
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
        return reader.isStateAtPosition(pos, NetherRockFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, NetherRockFeature::isReplaceableBlock);
    }
}