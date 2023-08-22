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

public class GiantPinkBioshroomFeature extends Feature<GiantBioshroomConfiguration> {

    public GiantPinkBioshroomFeature(Codec<GiantBioshroomConfiguration> codec) {
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
        int n = random.nextInt(5);
        int s = random.nextInt(5);
        int e = random.nextInt(5);
        int w = random.nextInt(5);
        if(n==0){
            placeRoot(level,pos.north(),randomSource,bioshroomConfiguration);
        }
        if(s==0){
            placeRoot(level,pos.south(),randomSource,bioshroomConfiguration);
        }
        if(e==0){
            placeRoot(level,pos.east(),randomSource,bioshroomConfiguration);
        }
        if(w==0){
            placeRoot(level,pos.west(),randomSource,bioshroomConfiguration);
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

    public void placeCap(LevelAccessor level, BlockPos pos1, RandomSource randomSource, GiantBioshroomConfiguration bioshroomConfiguration) {
        Random random = new Random();
        BlockPos.MutableBlockPos pos = pos1.below().mutable();

        placeCapBlock(level,pos.north().east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.north().west(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south().east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south().west(),randomSource,bioshroomConfiguration);

        pos.move(Direction.UP);

        placeCapBlock(level,pos.north().east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.north().west(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south().east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south().west(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.north(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.south(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.east(),randomSource,bioshroomConfiguration);
        placeGlowingBlock(level,pos.west(),randomSource,bioshroomConfiguration);

        pos.move(Direction.UP);

        placeCapBlock(level,pos,randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.north(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.west(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.north().east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.north().west(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south().east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south().west(),randomSource,bioshroomConfiguration);

        pos.move(Direction.UP);

        placeCapBlock(level,pos,randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.north(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.west(),randomSource,bioshroomConfiguration);

        pos.move(Direction.UP);

        placeCapBlock(level,pos,randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.north(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.south(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.east(),randomSource,bioshroomConfiguration);
        placeCapBlock(level,pos.west(),randomSource,bioshroomConfiguration);

        pos.move(Direction.UP);

        placeCapBlock(level,pos,randomSource,bioshroomConfiguration);
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
        return reader.isStateAtPosition(pos, GiantPinkBioshroomFeature::isReplaceableDirtBlock);
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, GiantPinkBioshroomFeature::isReplaceableBlock);
    }
}