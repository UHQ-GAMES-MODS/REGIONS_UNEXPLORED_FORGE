package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.block.cave.HangingPrismariteBlock;
import net.regions_unexplored.world.level.block.state.properties.HangingPrismariteShape;

import java.util.Random;

public class HangingPrismariteFeature extends Feature<NoneFeatureConfiguration> {

    public HangingPrismariteFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();


        if(level.getBlockState(pos.above()).isFaceSturdy(level, pos.above(), Direction.DOWN)){
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
                        if(level.getBlockState(blockpos1.above()).isFaceSturdy(level, pos.above(), Direction.DOWN)){
                            if(random.nextInt(10)== 0){
                            placePillar(level,blockpos1);
                            }
                        }
                    }
                }

                pos = pos.offset(-1 + random.nextInt(2), -random.nextInt(2), -1 + random.nextInt(2));
            }

            return true;
        }
    }

    public boolean placePillar(LevelAccessor level, BlockPos pos) {
        Random random = new Random();

        int size = random.nextInt(5)+1;
        if (level.isEmptyBlock(pos) ) {
            if(level.getBlockState(pos.above()).isFaceSturdy(level, pos.above(), Direction.DOWN)
                    ||level.getBlockState(pos.above()).is(RuBlocks.HANGING_PRISMARITE.get())) {

                BlockPos.MutableBlockPos placePos = pos.mutable();
                int count = 0;
                while (level.isEmptyBlock(placePos)) {
                    if(count==size){
                        return true;
                    }
                    if (level.isOutsideBuildHeight(placePos)) {
                        return true;
                    }
                    if(level.getBlockState(placePos.above()).is(RuBlocks.HANGING_PRISMARITE.get())){
                        level.setBlock(placePos.above(), RuBlocks.HANGING_PRISMARITE.get().defaultBlockState().setValue(HangingPrismariteBlock.SHAPE, HangingPrismariteShape.FRUSTUM), 2);
                    }
                    if(level.getBlockState(placePos.above().above()).is(RuBlocks.HANGING_PRISMARITE.get())){
                        level.setBlock(placePos.above().above(), RuBlocks.HANGING_PRISMARITE.get().defaultBlockState().setValue(HangingPrismariteBlock.SHAPE, HangingPrismariteShape.COLUMN), 2);
                    }
                    level.setBlock(placePos, RuBlocks.HANGING_PRISMARITE.get().defaultBlockState(), 2);
                    placePos.move(Direction.DOWN);
                    count=count+1;
                }

                return true;
            }
        }

        return true;
    }
}