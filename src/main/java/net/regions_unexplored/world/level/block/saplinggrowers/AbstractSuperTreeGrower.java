package net.regions_unexplored.world.level.block.saplinggrowers;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

import javax.annotation.Nullable;

public abstract class AbstractSuperTreeGrower extends AbstractTreeGrower {
        public boolean growTree(ServerLevel level, ChunkGenerator generator, BlockPos pos, BlockState state, RandomSource random) {
            for(int i = 1; i >= -1; --i) {
                for(int j = 1; j >= -1; --j) {
                    if (isStarBlockSapling(state, level, pos, i, j)) {
                        return this.placeSuper(level, generator, pos, state, random, i, j);
                    }
                }
            }

            return super.growTree(level, generator, pos, state, random);
        }

        @Nullable
        protected abstract ResourceKey<ConfiguredFeature<?, ?>> getConfiguredSuperFeature(RandomSource random);

        public boolean placeSuper(ServerLevel level, ChunkGenerator generator, BlockPos pos, BlockState state, RandomSource random, int X, int Z) {
            ResourceKey<ConfiguredFeature<?, ?>> resourcekey = this.getConfiguredSuperFeature(random);
            if (resourcekey == null) {
                return false;
            } else {
                Holder<ConfiguredFeature<?, ?>> holder = level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolder(resourcekey).orElse((Holder.Reference<ConfiguredFeature<?, ?>>)null);
                var event = net.minecraftforge.event.ForgeEventFactory.blockGrowFeature(level, random, pos, holder);
                holder = event.getFeature();
                if (event.getResult() == net.minecraftforge.eventbus.api.Event.Result.DENY) return false;
                if (holder == null) {
                    return false;
                } else {
                    ConfiguredFeature<?, ?> configuredfeature = event.getFeature().value();
                    BlockState setAir = Blocks.AIR.defaultBlockState();
                    level.setBlock(pos.offset(X, 0, Z), setAir, 4);
                    level.setBlock(pos.offset(X, 0, Z+1), setAir, 4);
                    level.setBlock(pos.offset(X, 0, Z-1), setAir, 4);
                    level.setBlock(pos.offset(X+1, 0, Z), setAir, 4);
                    level.setBlock(pos.offset(X-1, 0, Z), setAir, 4);
                    if (configuredfeature.place(level, generator, random, pos.offset(X, 0, Z))) {
                        return true;
                    } else {
                        level.setBlock(pos.offset(X, 0, Z), state, 4);
                        level.setBlock(pos.offset(X, 0, Z+1), state, 4);
                        level.setBlock(pos.offset(X, 0, Z-1), state, 4);
                        level.setBlock(pos.offset(X+1, 0, Z), state, 4);
                        level.setBlock(pos.offset(X-1, 0, Z), state, 4);
                        return false;
                    }
                }
            }
        }

        public static boolean isStarBlockSapling(BlockState state, BlockGetter getter, BlockPos pos, int X, int Z) {
            Block block = state.getBlock();
            return  getter.getBlockState(pos.offset(X, 0, Z)).is(block) &&
                    getter.getBlockState(pos.offset(X, 0, Z+1)).is(block) &&
                    getter.getBlockState(pos.offset(X, 0, Z-1)).is(block) &&
                    getter.getBlockState(pos.offset(X+1, 0, Z)).is(block) &&
                    getter.getBlockState(pos.offset(X-1, 0, Z)).is(block);
        }
    }

