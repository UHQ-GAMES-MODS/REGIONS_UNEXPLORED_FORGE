package net.regions_unexplored.world.level.block.saplinggrowers;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

public class BlackwoodTreeGrower extends AbstractMegaTreeGrower {
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean bool) {
        if(random.nextInt(5)==0){
            return RuTreeFeatures.BLACKWOOD_TREE;
        }
        else{
            return RuTreeFeatures.BIG_BLACKWOOD_TREE;
        }
    }

    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
        return null;
    }
}