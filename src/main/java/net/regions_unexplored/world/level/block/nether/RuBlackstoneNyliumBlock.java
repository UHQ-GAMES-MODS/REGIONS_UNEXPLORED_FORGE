package net.regions_unexplored.world.level.block.nether;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.lighting.LightEngine;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.worldgen.features.RuNetherFeatures;
import net.regions_unexplored.registry.ConfiguredFeatureRegistry;

public class RuBlackstoneNyliumBlock extends NyliumBlock implements BonemealableBlock {
    private final ResourceKey<ConfiguredFeature<?, ?>> bonemealfeature;

    public RuBlackstoneNyliumBlock(Properties properties, ResourceKey<ConfiguredFeature<?, ?>> bonemeal) {
        super(properties);
        this.bonemealfeature = bonemeal;
    }

    private static boolean canBeNylium(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = level.getBlockState(blockpos);
        int i = LightEngine.getLightBlockInto(level, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(level, blockpos));
        return i < level.getMaxLightLevel();
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!canBeNylium(state, level, pos)) {
            level.setBlockAndUpdate(pos, Blocks.BLACKSTONE.defaultBlockState());
        }

    }

    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos blockPos = pos.above();
        ChunkGenerator chunkgenerator = level.getChunkSource().getGenerator();
        Registry<ConfiguredFeature<?, ?>> registry = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);

        this.place(registry, this.bonemealfeature, level, chunkgenerator, random, blockPos);

    }

    private void place(Registry<ConfiguredFeature<?, ?>> featureRegistry, ResourceKey<ConfiguredFeature<?, ?>> key, ServerLevel level, ChunkGenerator generator, RandomSource random, BlockPos pos) {
        featureRegistry.getHolder(key).ifPresent((p_255920_) -> {
            p_255920_.value().place(level, generator, random, pos);
        });
    }
}