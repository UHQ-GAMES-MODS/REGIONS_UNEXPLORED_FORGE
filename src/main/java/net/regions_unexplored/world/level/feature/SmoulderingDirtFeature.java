package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.block.other_dirt.AshenDirtBlock;

public class SmoulderingDirtFeature extends Feature<NoneFeatureConfiguration> {

    public SmoulderingDirtFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        BlockPos pos = context.origin();
        WorldGenLevel level = context.level();


        if(level.getBlockState(pos.below()).is(RuBlocks.ASHEN_DIRT.get())&&level.getBlockState(pos).isAir()){
            level.setBlock(pos.below(), RuBlocks.ASHEN_DIRT.get().defaultBlockState().setValue(AshenDirtBlock.SMOULDERING, true), 2);
            return true;
        }

        return false;
    }
}