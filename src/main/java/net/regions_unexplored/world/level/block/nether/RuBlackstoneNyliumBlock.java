package net.regions_unexplored.world.level.block.nether;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.configurations.NetherForestVegetationConfig;
import net.minecraft.world.level.lighting.LayerLightEngine;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.worldgen.features.RuNetherFeatures;

public class RuBlackstoneNyliumBlock extends NyliumBlock implements BonemealableBlock {
    private static Holder<ConfiguredFeature<NetherForestVegetationConfig, ?>> bonemealfeature;

    public RuBlackstoneNyliumBlock(Properties properties) {
        super(properties);
    }

    private static boolean canBeNylium(BlockState p_55079_, LevelReader p_55080_, BlockPos p_55081_) {
        BlockPos blockpos = p_55081_.above();
        BlockState blockstate = p_55080_.getBlockState(blockpos);
        int i = LayerLightEngine.getLightBlockInto(p_55080_, p_55079_, p_55081_, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(p_55080_, blockpos));
        return i < p_55080_.getMaxLightLevel();
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!canBeNylium(state, level, pos)) {
            level.setBlockAndUpdate(pos, Blocks.BLACKSTONE.defaultBlockState());
        }

    }

    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.above();
        ChunkGenerator chunkgenerator = level.getChunkSource().getGenerator();

        this.bonemealfeature = RuNetherFeatures.COBALT_NYLIUM_BONEMEAL;

        this.bonemealfeature.value().place(level,chunkgenerator,random,blockPos);

    }
}