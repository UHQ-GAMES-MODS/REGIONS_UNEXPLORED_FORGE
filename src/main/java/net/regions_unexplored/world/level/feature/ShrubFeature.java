package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.regions_unexplored.world.level.block.plant.tall.ShrubBlock;
import net.regions_unexplored.world.level.feature.configuration.ShrubConfiguration;

public class ShrubFeature extends Feature<ShrubConfiguration> {

    public ShrubFeature(Codec<ShrubConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<ShrubConfiguration> context) {
        ShrubConfiguration shrubConfiguration = context.config();
        BlockPos pos = context.origin();
        RandomSource randomSource = context.random();
        WorldGenLevel level = context.level();

        if(!level.isOutsideBuildHeight(pos.above())&&level.getBlockState(pos).canBeReplaced()&&level.getBlockState(pos.above()).canBeReplaced()) {
            placeSapling(level, pos, shrubConfiguration.saplingProvider.getState(randomSource, pos));
            return true;
        }
        else{
            return false;
        }
    }

    public void placeSapling(WorldGenLevel level, BlockPos pos, BlockState state){
        level.setBlock(pos, state.setValue(ShrubBlock.HALF, DoubleBlockHalf.LOWER), 2);
        level.setBlock(pos.above(), state.setValue(ShrubBlock.HALF, DoubleBlockHalf.UPPER), 2);
    }
}