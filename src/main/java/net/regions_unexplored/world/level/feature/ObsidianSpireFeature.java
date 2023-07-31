package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;

public class ObsidianSpireFeature extends Feature<NoneFeatureConfiguration> {

    public ObsidianSpireFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        if(level.getBlockState(pos.below()).getBlock()!= RuBlocks.COBALT_NYLIUM.get()){
            return false;
        }
        if (level.isEmptyBlock(pos) && !level.isEmptyBlock(pos.below())) {
            BlockPos.MutableBlockPos placePos = pos.mutable();

            while(level.isEmptyBlock(placePos)||level.getBlockState(placePos).is(RuBlocks.COBALT_OBSIDIAN.get())||level.getBlockState(placePos).is(Blocks.OBSIDIAN)) {
                if (level.isOutsideBuildHeight(placePos)) {
                    return true;
                }
                int north = context.random().nextInt(4);
                int south = context.random().nextInt(4);
                int east = context.random().nextInt(4);
                int west = context.random().nextInt(4);
                level.setBlock(placePos, Blocks.OBSIDIAN.defaultBlockState(), 2);
                if(north==0){
                    level.setBlock(placePos.north(), RuBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
                        if(context.random().nextInt(3)==0){
                            placeBlob(level, placePos, context.random());
                        }
                }
                if(south==0){
                    level.setBlock(placePos.south(), RuBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
                    if(context.random().nextInt(3)==0){
                        placeBlob(level, placePos, context.random());
                    }
                }
                if(east==0){
                    level.setBlock(placePos.east(), RuBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
                    int east2 = context.random().nextInt(3);
                    if(context.random().nextInt(3)==0){
                        placeBlob(level, placePos, context.random());
                    }
                }
                if(west==0){
                    level.setBlock(placePos.west(), RuBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
                    int west2 = context.random().nextInt(3);
                    if(context.random().nextInt(3)==0){
                        placeBlob(level, placePos, context.random());
                    }
                }
                placePos.move(Direction.UP);
            }

            return true;
        } else {
            return false;
        }
    }

    private void placeBlob(WorldGenLevel level, BlockPos pos, RandomSource randomSource){
        int chance = randomSource.nextInt(8);

        if(chance==0){
            placeSmallBlob(level, pos, randomSource);
        }
        else if(chance==1){
            placeSmallBlob(level, pos.south(), randomSource);
        }
        else if(chance==2){
            placeSmallBlob(level, pos.west(), randomSource);
        }
        else if(chance==3){
            placeSmallBlob(level, pos.south().west(), randomSource);
        }
        else if(chance==4){
            placeLargeBlob(level, pos.north().east(), randomSource);
        }
        else if(chance==5){
            placeLargeBlob(level, pos.north().west(), randomSource);
        }
        else if(chance==6){
            placeLargeBlob(level, pos.south().east(), randomSource);
        }
        else{
            placeLargeBlob(level, pos.south().west(), randomSource);
        }
    }

    private void placeSmallBlob(WorldGenLevel level, BlockPos pos, RandomSource randomSource){

        placeBlock(level, pos, randomSource);
        placeBlock(level, pos.north(), randomSource);
        placeBlock(level, pos.east(), randomSource);
        placeBlock(level, pos.north().east(), randomSource);

        placeBlock(level, pos.above(), randomSource);
        placeBlock(level, pos.above().north(), randomSource);
        placeBlock(level, pos.above().east(), randomSource);
        placeBlock(level, pos.above().north().east(), randomSource);
    }

    private void placeLargeBlob(WorldGenLevel level, BlockPos pos, RandomSource randomSource){

        placeBlock(level, pos, randomSource);
        placeBlock(level, pos.above(), randomSource);
        placeBlock(level, pos.below(), randomSource);

        placeBlock(level, pos.north(), randomSource);
        placeBlock(level, pos.above().north(), randomSource);
        placeBlock(level, pos.below().north(), randomSource);

        placeBlock(level, pos.south(), randomSource);
        placeBlock(level, pos.above().south(), randomSource);
        placeBlock(level, pos.below().south(), randomSource);

        placeBlock(level, pos.east(), randomSource);
        placeBlock(level, pos.above().east(), randomSource);
        placeBlock(level, pos.below().east(), randomSource);

        placeBlock(level, pos.west(), randomSource);
        placeBlock(level, pos.above().west(), randomSource);
        placeBlock(level, pos.below().west(), randomSource);

        placeBlock(level, pos.north().east(), randomSource);
        placeBlock(level, pos.north().west(), randomSource);
        placeBlock(level, pos.south().east(), randomSource);
        placeBlock(level, pos.south().west(), randomSource);
    }

    private void placeBlock(WorldGenLevel level, BlockPos pos, RandomSource randomSource){
        if(level.getBlockState(pos).isAir()){
            if(randomSource.nextInt(10)==0){
                level.setBlock(pos, Blocks.OBSIDIAN.defaultBlockState(), 2);
            }
            else {
                level.setBlock(pos, RuBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
            }
        }
    }
}