package net.regions_unexplored.world.level.block.nether;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.worldgen.features.RuNetherFeatures;

public class RuNyliumBlock extends NyliumBlock implements BonemealableBlock {
    private static Holder<ConfiguredFeature<NetherForestVegetationConfig, ?>> bonemealfeature;

    public RuNyliumBlock(Properties properties) {
        super(properties);
    }

    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.above();
        ChunkGenerator chunkgenerator = level.getChunkSource().getGenerator();

        if (state == RuBlocks.GLISTERING_NYLIUM.get().defaultBlockState()) {
            this.bonemealfeature = RuNetherFeatures.GLISTERING_NYLIUM_BONEMEAL;
        } else if (state == RuBlocks.MYCOTOXIC_NYLIUM.get().defaultBlockState()) {
            this.bonemealfeature = RuNetherFeatures.MYCOTOXIC_NYLIUM_BONEMEAL;
        } else {
            this.bonemealfeature = RuNetherFeatures.BRIMSPROUT_NYLIUM_BONEMEAL;
        }

        this.bonemealfeature.value().place(level,chunkgenerator,random,blockPos);


    }
}