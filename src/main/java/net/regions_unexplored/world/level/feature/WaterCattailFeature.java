package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.world.level.block.plant.tall.CattailBlock;

import java.util.Random;

public class WaterCattailFeature extends Feature<NoneFeatureConfiguration> {
    public WaterCattailFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();


        if(level.getBlockState(pos.below()).isFaceSturdy(level, pos.below(), Direction.UP)){
            placeBlob(level, pos);
            return true;
        }

        return false;
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
                        if(level.getBlockState(blockpos1.below()).isFaceSturdy(level, pos.below(), Direction.DOWN)){
                            if(blockpos1.getY()==62||blockpos1.getY()==63){
                                if(random.nextInt(5)== 0){
                                    placeCattail(level,blockpos1);
                                }
                            }
                        }
                    }
                }

                pos = pos.offset(-1 + random.nextInt(2), -random.nextInt(2), -1 + random.nextInt(2));
            }

            return true;
        }
    }

    public boolean placeCattail(LevelAccessor level, BlockPos pos) {
        if (level.getBlockState(pos.below()).is(RuTags.CATTAIL_CAN_SURVIVE_ON)&&level.isWaterAt(pos)&&level.isEmptyBlock(pos.above())) {
            level.setBlock(pos, RuBlocks.CATTAIL.get().defaultBlockState().setValue(CattailBlock.HALF, DoubleBlockHalf.LOWER).setValue(CattailBlock.WATERLOGGED, true), 2);
            level.setBlock(pos.above(), RuBlocks.CATTAIL.get().defaultBlockState().setValue(CattailBlock.HALF, DoubleBlockHalf.UPPER).setValue(CattailBlock.WATERLOGGED, false), 2);
        }
        else if (level.getBlockState(pos.below()).is(RuTags.CATTAIL_CAN_SURVIVE_ON)&&level.isEmptyBlock(pos)&&level.isEmptyBlock(pos.above())) {
            level.setBlock(pos, RuBlocks.CATTAIL.get().defaultBlockState().setValue(CattailBlock.HALF, DoubleBlockHalf.LOWER).setValue(CattailBlock.WATERLOGGED, false), 2);
            level.setBlock(pos.above(), RuBlocks.CATTAIL.get().defaultBlockState().setValue(CattailBlock.HALF, DoubleBlockHalf.UPPER).setValue(CattailBlock.WATERLOGGED, false), 2);
        }
        return true;
    }
}