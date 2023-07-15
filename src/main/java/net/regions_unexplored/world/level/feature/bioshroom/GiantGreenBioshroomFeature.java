package net.regions_unexplored.world.level.feature.bioshroom;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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
import net.regions_unexplored.world.level.feature.configuration.GiantBioshroomConfiguration;

import java.util.Random;

public class GiantGreenBioshroomFeature extends Feature<GiantBioshroomConfiguration> {

    public GiantGreenBioshroomFeature(Codec<GiantBioshroomConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<GiantBioshroomConfiguration> context) {
        GiantBioshroomConfiguration bioshroomConfiguration = context.config();
        BlockPos pos = context.origin();
        RandomSource randomSource = context.random();
        WorldGenLevel level = context.level();

        int limbDirection = context.random().nextInt(12);
        int height_main = context.random().nextInt(bioshroomConfiguration.sizeVariation) + bioshroomConfiguration.minimumSize;

        if(!level.getBlockState(pos).canBeReplaced()){
            return false;
        }

        int placeCheck = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while (placeCheck <= height_main) {
            if(placeCheck == 0){
                placeBase(level, placePos, randomSource, bioshroomConfiguration);
            }
            if(placeCheck == height_main){
                placeCap(level, placePos, randomSource, bioshroomConfiguration);
            }
            placeStemBlock(level, placePos, randomSource, bioshroomConfiguration);
            placePos.move(Direction.UP);
            placeCheck = placeCheck + 1;
        }
        return true;
    }

    public void placeBase(LevelAccessor level, BlockPos pos, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration) {
        Random random = new Random();
        int n = random.nextInt(2);
        int s = random.nextInt(2);
        int e = random.nextInt(2);
        int w = random.nextInt(2);
        placeRoot(level,pos.north(),randomSource,bioshroomConfiguration);
        placeRoot(level,pos.south(),randomSource,bioshroomConfiguration);
        placeRoot(level,pos.east(),randomSource,bioshroomConfiguration);
        placeRoot(level,pos.west(),randomSource,bioshroomConfiguration);
        if(n==0){
            placeStemBlock(level,pos.north().above(),randomSource,bioshroomConfiguration);
        }
        if(s==0){
            placeStemBlock(level,pos.south().above(),randomSource,bioshroomConfiguration);
        }
        if(e==0){
            placeStemBlock(level,pos.east().above(),randomSource,bioshroomConfiguration);
        }
        if(w==0){
            placeStemBlock(level,pos.west().above(),randomSource,bioshroomConfiguration);
        }
    }

    public void placeStemBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration) {

        if(level.isOutsideBuildHeight(pos)){
            return;
        }
        if(level.getBlockState(pos).is(RuBlocks.PEAT_GRASS_BLOCK.get())){
            level.setBlock(pos, RuBlocks.PEAT_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.SILT_GRASS_BLOCK.get())){
            level.setBlock(pos, RuBlocks.SILT_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.ALPHA_GRASS_BLOCK.get())||level.getBlockState(pos).is(Blocks.GRASS_BLOCK)||level.getBlockState(pos).is(Blocks.MYCELIUM)){
            level.setBlock(pos, Blocks.DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.MYCOTOXIC_NYLIUM.get())||level.getBlockState(pos).is(RuBlocks.GLISTERING_NYLIUM.get())|| level.getBlockState(pos).is(Blocks.CRIMSON_NYLIUM)|| level.getBlockState(pos).is(Blocks.WARPED_NYLIUM)){
            level.setBlock(pos, Blocks.NETHERRACK.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.COBALT_NYLIUM.get())){
            level.setBlock(pos, Blocks.BLACKSTONE.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.PRISMOSS.get())|| level.getBlockState(pos).is(RuBlocks.VIRIDESCENT_NYLIUM.get())|| level.getBlockState(pos).is(RuBlocks.STONE_GRASS_BLOCK.get())){
            level.setBlock(pos, Blocks.STONE.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos).is(RuBlocks.DEEPSLATE_PRISMOSS.get())||level.getBlockState(pos).is(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get())||level.getBlockState(pos).is(RuBlocks.DEEPSLATE_GRASS_BLOCK.get())){
            level.setBlock(pos, Blocks.DEEPSLATE.defaultBlockState(), 2);
        }
        else if(isReplaceable(level, pos)) {
            level.setBlock(pos, bioshroomConfiguration.stemProvider.getState(randomSource, pos), 2);
        }
        else{
            return;
        }

        if(level.getBlockState(pos.below()).is(RuBlocks.PEAT_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), RuBlocks.PEAT_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.SILT_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), RuBlocks.SILT_DIRT.get().defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.ALPHA_GRASS_BLOCK.get())||level.getBlockState(pos.below()).is(Blocks.GRASS_BLOCK)||level.getBlockState(pos.below()).is(Blocks.MYCELIUM)){
            level.setBlock(pos.below(), Blocks.DIRT.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.MYCOTOXIC_NYLIUM.get())||level.getBlockState(pos.below()).is(RuBlocks.GLISTERING_NYLIUM.get())|| level.getBlockState(pos.below()).is(Blocks.CRIMSON_NYLIUM)|| level.getBlockState(pos.below()).is(Blocks.WARPED_NYLIUM)){
            level.setBlock(pos.below(), Blocks.NETHERRACK.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.COBALT_NYLIUM.get())){
            level.setBlock(pos.below(), Blocks.BLACKSTONE.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.PRISMOSS.get())|| level.getBlockState(pos.below()).is(RuBlocks.VIRIDESCENT_NYLIUM.get())|| level.getBlockState(pos.below()).is(RuBlocks.STONE_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), Blocks.STONE.defaultBlockState(), 2);
        }
        else if(level.getBlockState(pos.below()).is(RuBlocks.DEEPSLATE_PRISMOSS.get())||level.getBlockState(pos.below()).is(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get())||level.getBlockState(pos.below()).is(RuBlocks.DEEPSLATE_GRASS_BLOCK.get())){
            level.setBlock(pos.below(), Blocks.DEEPSLATE.defaultBlockState(), 2);
        }
    }

    public void placeRoot(LevelAccessor level, BlockPos pos, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration) {
        int rd = 2;
        int i = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while(i<=rd){
            if(i>0){
                if(!level.getBlockState(placePos.above()).is(bioshroomConfiguration.stemProvider.getState(randomSource, placePos.above()).getBlock())&&level.getBlockState(placePos).canBeReplaced()) {
                    return;
                }
            }
            placeStemBlock(level, placePos, randomSource, bioshroomConfiguration);
            placePos.move(Direction.DOWN);
            i++;
        }
    }

    public void placeCap(LevelAccessor level, BlockPos pos, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration) {
        Random random = new Random();
        placeStemBlock(level,pos,randomSource,bioshroomConfiguration);
        placeStemBlock(level,pos.north(),randomSource,bioshroomConfiguration);
        placeStemBlock(level,pos.south(),randomSource,bioshroomConfiguration);
        placeStemBlock(level,pos.east(),randomSource,bioshroomConfiguration);
        placeStemBlock(level,pos.west(),randomSource,bioshroomConfiguration);
        placeStemBlock(level,pos.below(),randomSource,bioshroomConfiguration);
        placeStemBlock(level,pos.below().north(),randomSource,bioshroomConfiguration);
        placeStemBlock(level,pos.below().south(),randomSource,bioshroomConfiguration);
        placeStemBlock(level,pos.below().east(),randomSource,bioshroomConfiguration);
        placeStemBlock(level,pos.below().west(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.north().east(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.north().west(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.south().east(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.south().west(),randomSource,bioshroomConfiguration);

        placeCapBlock(level,pos.north().north(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.north().north().east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.north().north().west(),randomSource,bioshroomConfiguration);

        placeCapBlock(level,pos.south().south(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south().south().east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south().south().west(),randomSource,bioshroomConfiguration);

        placeCapBlock(level,pos.east().east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.east().east().north(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.east().east().south(),randomSource,bioshroomConfiguration);

        placeCapBlock(level,pos.west().west(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.west().west().north(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.west().west().south(),randomSource,bioshroomConfiguration);

        placeCapBlock(level,pos.above(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.above().north(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.above().south(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.above().east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.above().west(),randomSource,bioshroomConfiguration);
        if(random.nextInt(3)!=0){
            placeCapBlock(level,pos.above().north().east(),randomSource,bioshroomConfiguration);
        }
        if(random.nextInt(3)!=0){
            placeCapBlock(level,pos.above().north().west(),randomSource,bioshroomConfiguration);
        }
        if(random.nextInt(3)!=0){
            placeCapBlock(level,pos.above().south().east(),randomSource,bioshroomConfiguration);
        }
        if(random.nextInt(3)!=0){
            placeCapBlock(level,pos.above().south().west(),randomSource,bioshroomConfiguration);
        }



        placeGlowingBlock(level,pos.below().north().north(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.below().north().north().east(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.below().north().north().west(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.below().south().south(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.below().south().south().east(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.below().south().south().west(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.below().east().east(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.below().east().east().north(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.below().east().east().south(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.below().west().west(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.below().west().west().north(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.below().west().west().south(),randomSource,bioshroomConfiguration);


        placeCapVine(level,pos.below().north().north().east().east(),randomSource,bioshroomConfiguration);
        placeCapVine(level,pos.below().north().north().west().west(),randomSource,bioshroomConfiguration);
        placeCapVine(level,pos.below().south().south().east().east(),randomSource,bioshroomConfiguration);
        placeCapVine(level,pos.below().south().south().west().west(),randomSource,bioshroomConfiguration);

        placeCapVine(level,pos.below().north().north().north(),randomSource,bioshroomConfiguration);
        placeCapVine(level,pos.below().north().north().north().east(),randomSource,bioshroomConfiguration);
        placeCapVine(level,pos.below().north().north().north().west(),randomSource,bioshroomConfiguration);

        placeCapVine(level,pos.below().south().south().south(),randomSource,bioshroomConfiguration);
        placeCapVine(level,pos.below().south().south().south().east(),randomSource,bioshroomConfiguration);
        placeCapVine(level,pos.below().south().south().south().west(),randomSource,bioshroomConfiguration);

        placeCapVine(level,pos.below().east().east().east(),randomSource,bioshroomConfiguration);
        placeCapVine(level,pos.below().east().east().east().north(),randomSource,bioshroomConfiguration);
        placeCapVine(level,pos.below().east().east().east().south(),randomSource,bioshroomConfiguration);

        placeCapVine(level,pos.below().west().west().west(),randomSource,bioshroomConfiguration);
        placeCapVine(level,pos.below().west().west().west().north(),randomSource,bioshroomConfiguration);
        placeCapVine(level,pos.below().west().west().west().south(),randomSource,bioshroomConfiguration);
    }

    public void placeCapVine(LevelAccessor level, BlockPos pos, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration) {
        Random random = new Random();
        int rd = random.nextInt(4);
        int i = 0;
        BlockPos.MutableBlockPos placePos = pos.mutable();
        while(i<=rd){
            placeCapBlock(level, placePos, randomSource, bioshroomConfiguration);
            placePos.move(Direction.DOWN);
            i++;
        }
    }

    public void placeCapBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration) {
        if(level.isOutsideBuildHeight(pos)){
            return;
        }
        else if(isReplaceable(level, pos)) {
            level.setBlock(pos, bioshroomConfiguration.capProvider.getState(randomSource, pos), 2);
        }
    }
    public void placeGlowingBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration) {
        if(level.isOutsideBuildHeight(pos)){
            return;
        }
        else if(isReplaceable(level, pos)) {
            level.setBlock(pos, bioshroomConfiguration.glowBlockProvider.getState(randomSource, pos), 2);
        }
    }

    
    public static boolean isReplaceableDirtBlock(BlockState state) {
        return state.is(RuTags.TREE_GRASS_REPLACEABLES);
    }

    public static boolean isReplaceableDirt(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, GiantGreenBioshroomFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, GiantGreenBioshroomFeature::isReplaceableBlock);
    }
}