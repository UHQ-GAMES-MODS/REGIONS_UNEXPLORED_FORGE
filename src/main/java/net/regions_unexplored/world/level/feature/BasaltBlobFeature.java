package net.regions_unexplored.world.level.feature;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.ColumnFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;

import javax.annotation.Nullable;

public class BasaltBlobFeature extends Feature<ColumnFeatureConfiguration> {
    private static final ImmutableList<Block> CANNOT_PLACE_ON = ImmutableList.of(
            Blocks.COBBLESTONE,
            Blocks.COBBLESTONE_SLAB,
            Blocks.COBBLESTONE_STAIRS,
            Blocks.MOSSY_COBBLESTONE,
            Blocks.MOSSY_COBBLESTONE_SLAB,
            Blocks.MOSSY_COBBLESTONE_STAIRS,
            Blocks.STONE_BRICKS,
            Blocks.MOSSY_STONE_BRICKS,
            Blocks.CRACKED_STONE_BRICKS,
            Blocks.STONE_BRICK_SLAB,
            Blocks.RED_NETHER_BRICKS,
            Blocks.RED_NETHER_BRICK_SLAB,
            Blocks.RED_NETHER_BRICK_STAIRS,
            Blocks.MOSSY_STONE_BRICK_SLAB,
            Blocks.STONE_BRICK_SLAB,
            Blocks.COAL_BLOCK,
            Blocks.NETHERRACK,
            Blocks.SOUL_SAND,
            Blocks.POLISHED_ANDESITE,
            Blocks.POLISHED_DIORITE,
            Blocks.POLISHED_GRANITE,
            Blocks.POLISHED_ANDESITE_SLAB,
            Blocks.POLISHED_DIORITE_SLAB,
            Blocks.POLISHED_GRANITE_SLAB,
            Blocks.POLISHED_ANDESITE_STAIRS,
            Blocks.POLISHED_DIORITE_STAIRS,
            Blocks.POLISHED_GRANITE_STAIRS,
            Blocks.IRON_BARS,
            Blocks.SOUL_SOIL,
            Blocks.GRAVEL,
            Blocks.MOSSY_STONE_BRICK_SLAB,
            Blocks.LAVA,
            Blocks.BEDROCK,
            Blocks.MAGMA_BLOCK,
            Blocks.SOUL_SAND,
            Blocks.NETHER_BRICKS,
            Blocks.NETHER_BRICK_FENCE,
            Blocks.NETHER_BRICK_STAIRS,
            Blocks.NETHER_WART,
            Blocks.CHEST,
            RuBlocks.ASH_VENT.get(),
            RuBlocks.DEAD_LEAVES.get());

    public BasaltBlobFeature(Codec<ColumnFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<ColumnFeatureConfiguration> context) {
        int i = context.chunkGenerator().getSeaLevel();
        BlockPos blockpos = context.origin();
        WorldGenLevel worldgenlevel = context.level();
        RandomSource randomsource = context.random();
        ColumnFeatureConfiguration columnfeatureconfiguration = context.config();
        if (!canPlaceAt(worldgenlevel, i, blockpos.mutable())) {
            return false;
        } else {
            int j = columnfeatureconfiguration.height().sample(randomsource);
            boolean flag = randomsource.nextFloat() < 0.9F;
            int k = Math.min(j, flag ? 5 : 8);
            int l = flag ? 50 : 15;
            boolean flag1 = false;

            for(BlockPos blockpos1 : BlockPos.randomBetweenClosed(randomsource, l, blockpos.getX() - k, blockpos.getY(), blockpos.getZ() - k, blockpos.getX() + k, blockpos.getY(), blockpos.getZ() + k)) {
                int i1 = j - blockpos1.distManhattan(blockpos);
                if (i1 >= 0) {
                    flag1 |= this.placeColumn(worldgenlevel, i, blockpos1, i1, columnfeatureconfiguration.reach().sample(randomsource));
                }
            }

            return flag1;
        }
    }

    private boolean placeColumn(LevelAccessor level, int ylevel, BlockPos pos, int k, int offset) {
        boolean flag = false;

        for(BlockPos blockpos : BlockPos.betweenClosed(pos.getX() - offset, pos.getY(), pos.getZ() - offset, pos.getX() + offset, pos.getY(), pos.getZ() + offset)) {
            int i = blockpos.distManhattan(pos);
            BlockPos pos1 = isAirOrLavaOcean(level, ylevel, blockpos) ? findSurface(level, ylevel, blockpos.mutable(), i) : findAir(level, blockpos.mutable(), i);
            if (pos1 != null) {
                int j = k - i / 2;

                for(BlockPos.MutableBlockPos blockpos$mutableblockpos = pos1.mutable(); j >= 0; --j) {
                    if (isAirOrLavaOcean(level, ylevel, blockpos$mutableblockpos)) {
                        this.setBlock(level, blockpos$mutableblockpos, Blocks.BASALT.defaultBlockState());
                        blockpos$mutableblockpos.move(Direction.UP);
                        flag = true;
                    } else {
                        if (!level.getBlockState(blockpos$mutableblockpos).is(Blocks.BASALT)) {
                            break;
                        }

                        blockpos$mutableblockpos.move(Direction.UP);
                    }
                }
            }
        }

        return flag;
    }

    @Nullable
    private static BlockPos findSurface(LevelAccessor level, int ylevel, BlockPos.MutableBlockPos pos, int i) {
        while(pos.getY() > level.getMinBuildHeight() + 1 && i > 0) {
            --i;
            if (canPlaceAt(level, ylevel, pos)) {
                return pos;
            }

            pos.move(Direction.DOWN);
        }

        return null;
    }

    private static boolean canPlaceAt(LevelAccessor level, int ylevel, BlockPos.MutableBlockPos pos) {
        if (!isAirOrLavaOcean(level, ylevel, pos)) {
            return false;
        } else {
            BlockState blockstate = level.getBlockState(pos.move(Direction.DOWN));
            pos.move(Direction.UP);
            return !blockstate.isAir() && !CANNOT_PLACE_ON.contains(blockstate.getBlock());
        }
    }

    @Nullable
    private static BlockPos findAir(LevelAccessor level, BlockPos.MutableBlockPos pos, int i) {
        while(pos.getY() < level.getMaxBuildHeight() && i > 0) {
            --i;
            BlockState blockstate = level.getBlockState(pos);
            if (CANNOT_PLACE_ON.contains(blockstate.getBlock())) {
                return null;
            }

            if (blockstate.isAir()) {
                return pos;
            }

            pos.move(Direction.UP);
        }

        return null;
    }

    private static boolean isAirOrLavaOcean(LevelAccessor levelAccessor, int ylevel, BlockPos pos) {
        BlockState blockstate = levelAccessor.getBlockState(pos);
        return blockstate.isAir() || blockstate.is(Blocks.LAVA) || blockstate.is(RuTags.REPLACEABLE_BLOCKS) || blockstate.is(Blocks.WATER) && pos.getY() <= ylevel;
    }
}