package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;

import java.util.Random;

public class MarshFeature extends Feature<NoneFeatureConfiguration> {
    public MarshFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();
        placeBlob(level, pos);
        return true;
    }
    public boolean placeBlob(LevelAccessor level, BlockPos pos) {
        Random random = new Random();

        if (pos.getY() <= level.getMinBuildHeight() + 3) {
            return false;
        } else {
            for(int l = 0; l < 3; ++l) {
                int i = random.nextInt(4)+2;
                int j = random.nextInt(4)+2;
                int k = random.nextInt(4)+2;
                float f = (float)(i + j + k) * 0.333F + 0.5F;

                for(BlockPos blockpos1 : BlockPos.betweenClosed(pos.offset(-i, -j, -k), pos.offset(i, j, k))) {
                    if (blockpos1.distSqr(pos) <= (double)(f * f)) {
                        if(blockpos1.getY()==62){
                            placeBlocks(level,blockpos1);
                        }
                    }
                }

                pos = pos.offset(-1 + random.nextInt(2), -random.nextInt(2), -1 + random.nextInt(2));
            }

            return true;
        }
    }

    public void placeBlocks(LevelAccessor level, BlockPos pos) {
        Random random = new Random();
        int chance = random.nextInt(5);
        int chance_grass = random.nextInt(4);
        if (!level.isEmptyBlock(pos.below(5))&&!level.isEmptyBlock(pos.below(4))&&!level.isEmptyBlock(pos.below(3))&&!level.isEmptyBlock(pos.below(2))&&!level.isEmptyBlock(pos.below())){
        if(chance== 0){
            if (!level.getFluidState(pos.below(5)).is(FluidTags.WATER)&&level.isWaterAt(pos)) {
                level.setBlock(pos, Blocks.GRASS_BLOCK.defaultBlockState(), 2);
                if(level.getBlockState(pos.above()).is(Blocks.LILY_PAD)||level.getBlockState(pos.above()).is(RuBlocks.DUCKWEED.get())||level.getBlockState(pos.above()).is(RuBlocks.FLOWERING_LILY_PAD.get())){
                    level.setBlock(pos.above(), Blocks.AIR.defaultBlockState(), 2);
                }
                if(level.getBlockState(pos.above()).isAir()&&level.getBlockState(pos.above(2)).isAir()){
                    if(chance_grass==0||chance_grass==1){
                        level.setBlock(pos.above(), Blocks.SHORT_GRASS.defaultBlockState(), 2);
                    }
                    if(chance_grass==2){
                        level.setBlock(pos.above(), Blocks.TALL_GRASS.defaultBlockState().setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER), 2);
                        if(level.getBlockState(pos.above())==Blocks.TALL_GRASS.defaultBlockState().setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)) {
                            level.setBlock(pos.above(2), Blocks.TALL_GRASS.defaultBlockState().setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER), 2);
                        }
                    }
                }
                if(level.isWaterAt(pos.below())) {
                    level.setBlock(pos.below(), Blocks.DIRT.defaultBlockState(), 2);
                }
                if(level.isWaterAt(pos.below(2))) {
                    level.setBlock(pos.below(2), Blocks.DIRT.defaultBlockState(), 2);
                }
                if(level.isWaterAt(pos.below(3))) {
                    level.setBlock(pos.below(3), Blocks.DIRT.defaultBlockState(), 2);
                }
                if(level.isWaterAt(pos.below(4))) {
                    level.setBlock(pos.below(4), Blocks.DIRT.defaultBlockState(), 2);
                }
            }
        }
        else if(chance==1){
            if (!level.getFluidState(pos.below(5)).is(FluidTags.WATER)&&level.isWaterAt(pos)) {
                if(level.isWaterAt(pos.below())) {
                    level.setBlock(pos.below(), Blocks.DIRT.defaultBlockState(), 2);
                }
                if(level.isWaterAt(pos.below(2))) {
                    level.setBlock(pos.below(2), Blocks.DIRT.defaultBlockState(), 2);
                }
                if(level.isWaterAt(pos.below(3))) {
                    level.setBlock(pos.below(3), Blocks.DIRT.defaultBlockState(), 2);
                }
                if(level.isWaterAt(pos.below(4))) {
                    level.setBlock(pos.below(4), Blocks.DIRT.defaultBlockState(), 2);
                }
            }
        }
        else if(chance==2){
            if (!level.getFluidState(pos.below(5)).is(FluidTags.WATER)&&level.isWaterAt(pos)) {
                if(level.getBlockState(pos.below()).is(Blocks.AIR)) {
                    level.setBlock(pos.below(), Blocks.WATER.defaultBlockState(), 2);
                }
                if(level.isWaterAt(pos.below(2))) {
                    level.setBlock(pos.below(2), Blocks.DIRT.defaultBlockState(), 2);
                }
                if(level.isWaterAt(pos.below(3))) {
                    level.setBlock(pos.below(3), Blocks.DIRT.defaultBlockState(), 2);
                }
                if(level.isWaterAt(pos.below(4))) {
                    level.setBlock(pos.below(4), Blocks.DIRT.defaultBlockState(), 2);
                }
            }
        }
        else if(chance==3){
            if (!level.getFluidState(pos.below(5)).is(FluidTags.WATER)&&level.isWaterAt(pos)) {
                if(level.getBlockState(pos.below()).is(Blocks.AIR)) {
                    level.setBlock(pos.below(), Blocks.WATER.defaultBlockState(), 2);
                }
                if(level.getBlockState(pos.below(2)).is(Blocks.AIR)) {
                    level.setBlock(pos.below(2), Blocks.WATER.defaultBlockState(), 2);
                }
                if(level.isWaterAt(pos.below(3))) {
                    level.setBlock(pos.below(3), Blocks.DIRT.defaultBlockState(), 2);
                }
                if(level.isWaterAt(pos.below(4))) {
                    level.setBlock(pos.below(4), Blocks.DIRT.defaultBlockState(), 2);
                }
            }
        }
        }
    }
}