package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.world.level.feature.configuration.SmallBushConfiguration;

import java.util.Random;

public class SmallBushFeature extends Feature<SmallBushConfiguration> {

    public SmallBushFeature(Codec<SmallBushConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<SmallBushConfiguration> context) {
        SmallBushConfiguration bushConfig = context.config();
        BlockPos pos = context.origin();
        RandomSource randomSource = context.random();
        WorldGenLevel level = context.level();

        if(!level.getBlockState(pos).canBeReplaced()||level.getBlockState(pos).is(Blocks.WATER)){
            return false;
        }
        placeLeavesBlock(level,pos,randomSource,bushConfig);
        if(randomSource.nextInt(2)==0){
            placeLeavesBlock(level,pos.above(),randomSource,bushConfig);
        }
        return true;
    }

    public boolean placeLeavesBlock(LevelAccessor level, BlockPos pos, RandomSource randomSource, SmallBushConfiguration bushConfig) {
        Random random = new Random();
        if(level.isOutsideBuildHeight(pos)){
            return true;
        }
        if(level.getBlockState(pos).canBeReplaced()) {
            level.setBlock(pos, bushConfig.foliageProvider.getState(randomSource, pos).setValue(LeavesBlock.DISTANCE, 1), 2);
        }
        return true;
    }

    public static boolean isReplaceableBlock(BlockState state) {
        return state.is(RuTags.REPLACEABLE_BLOCKS);
    }

    public static boolean isReplaceable(LevelSimulatedReader reader, BlockPos pos) {
        return reader.isStateAtPosition(pos, SmallBushFeature::isReplaceableBlock);
    }
}