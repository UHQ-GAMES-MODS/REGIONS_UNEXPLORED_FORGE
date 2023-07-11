package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.ClampedNormalFloat;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.feature.configuration.PointedRedstoneClusterConfiguration;
import net.regions_unexplored.world.level.feature.configuration.PointedRedstoneUtils;

import java.util.Optional;
import java.util.OptionalInt;

public class PointedRedstoneClusterFeature extends Feature<PointedRedstoneClusterConfiguration> {
    public PointedRedstoneClusterFeature(Codec<PointedRedstoneClusterConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<PointedRedstoneClusterConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        PointedRedstoneClusterConfiguration redstoneClusterConfiguration = context.config();
        RandomSource random = context.random();
        if (!PointedRedstoneUtils.isEmptyOrWater(level, pos)) {
            return false;
        } else {
            int i = redstoneClusterConfiguration.height.sample(random);
            float f = redstoneClusterConfiguration.wetness.sample(random);
            float f1 = redstoneClusterConfiguration.density.sample(random);
            int j = redstoneClusterConfiguration.radius.sample(random);
            int k = redstoneClusterConfiguration.radius.sample(random);

            for(int l = -j; l <= j; ++l) {
                for(int i1 = -k; i1 <= k; ++i1) {
                    double d0 = this.getChanceOfStalagmiteOrStalactite(j, k, l, i1, redstoneClusterConfiguration);
                    BlockPos blockpos1 = pos.offset(l, 0, i1);
                    this.placeColumn(level, random, blockpos1, l, i1, f, d0, i, f1, redstoneClusterConfiguration);
                }
            }

            return true;
        }
    }

    private void placeColumn(WorldGenLevel level, RandomSource random, BlockPos pos, int i4, int i5, float v, double v1, int i6, float v2, PointedRedstoneClusterConfiguration redstoneClusterConfiguration) {
        Optional<Column> optional = Column.scan(level, pos, redstoneClusterConfiguration.floorToCeilingSearchRange, PointedRedstoneUtils::isEmptyOrWater, PointedRedstoneUtils::isNeitherEmptyNorWater);
        if (optional.isPresent()) {
            OptionalInt optionalInt = optional.get().getCeiling();
            OptionalInt optionalInt1 = optional.get().getFloor();
            if (optionalInt.isPresent() || optionalInt1.isPresent()) {
                boolean flag = random.nextFloat() < v;
                Column column;
                if (flag && optionalInt1.isPresent() && this.canPlacePool(level, pos.atY(optionalInt1.getAsInt()))) {
                    int i = optionalInt1.getAsInt();
                    column = optional.get().withFloor(OptionalInt.of(i - 1));
                    level.setBlock(pos.atY(i), Blocks.WATER.defaultBlockState(), 2);
                } else {
                    column = optional.get();
                }

                OptionalInt optionalint2 = column.getFloor();
                boolean flag1 = random.nextDouble() < v1;
                int j;
                if (optionalInt.isPresent() && flag1 && !this.isLava(level, pos.atY(optionalInt.getAsInt()))) {
                    int k = redstoneClusterConfiguration.redstoneBlockLayerThickness.sample(random);
                    this.replaceBlocksWithRedstoneBlocks(level, pos.atY(optionalInt.getAsInt()), k, Direction.UP);
                    int l;
                    if (optionalint2.isPresent()) {
                        l = Math.min(i6, optionalInt.getAsInt() - optionalint2.getAsInt());
                    } else {
                        l = i6;
                    }

                    j = this.getRedstoneHeight(random, i4, i5, v2, l, redstoneClusterConfiguration);
                } else {
                    j = 0;
                }

                boolean flag2 = random.nextDouble() < v1;
                int i3;
                if (optionalint2.isPresent() && flag2 && !this.isLava(level, pos.atY(optionalint2.getAsInt()))) {
                    int i1 = redstoneClusterConfiguration.redstoneBlockLayerThickness.sample(random);
                    this.replaceBlocksWithRedstoneBlocks(level, pos.atY(optionalint2.getAsInt()), i1, Direction.DOWN);
                    if (optionalInt.isPresent()) {
                        i3 = Math.max(0, j + Mth.randomBetweenInclusive(random, -redstoneClusterConfiguration.maxStalagmiteStalactiteHeightDiff, redstoneClusterConfiguration.maxStalagmiteStalactiteHeightDiff));
                    } else {
                        i3 = this.getRedstoneHeight(random, i4, i5, v2, i6, redstoneClusterConfiguration);
                    }
                } else {
                    i3 = 0;
                }

                int j1;
                int j3;
                if (optionalInt.isPresent() && optionalint2.isPresent() && optionalInt.getAsInt() - j <= optionalint2.getAsInt() + i3) {
                    int k1 = optionalint2.getAsInt();
                    int l1 = optionalInt.getAsInt();
                    int i2 = Math.max(l1 - j, k1 + 1);
                    int j2 = Math.min(k1 + i3, l1 - 1);
                    int k2 = Mth.randomBetweenInclusive(random, i2, j2 + 1);
                    int l2 = k2 - 1;
                    j3 = l1 - k2;
                    j1 = l2 - k1;
                } else {
                    j3 = j;
                    j1 = i3;
                }

                boolean flag3 = random.nextBoolean() && j3 > 0 && j1 > 0 && column.getHeight().isPresent() && j3 + j1 == column.getHeight().getAsInt();
                if (optionalInt.isPresent()) {
                    PointedRedstoneUtils.growPointedRedstone(level, pos.atY(optionalInt.getAsInt() - 1), Direction.DOWN, j3, flag3);
                }

                if (optionalint2.isPresent()) {
                    PointedRedstoneUtils.growPointedRedstone(level, pos.atY(optionalint2.getAsInt() + 1), Direction.UP, j1, flag3);
                }

            }
        }
    }

    private boolean isLava(LevelReader level, BlockPos pos) {
        return level.getBlockState(pos).is(Blocks.LAVA);
    }

    private int getRedstoneHeight(RandomSource random, int i1, int i2, float v, int i3, PointedRedstoneClusterConfiguration redstoneClusterConfiguration) {
        if (random.nextFloat() > v) {
            return 0;
        } else {
            int i = Math.abs(i1) + Math.abs(i2);
            float f = (float)Mth.clampedMap((double)i, 0.0D, (double)redstoneClusterConfiguration.maxDistanceFromCenterAffectingHeightBias, (double)i3 / 2.0D, 0.0D);
            return (int)randomBetweenBiased(random, 0.0F, (float)i3, f, (float)redstoneClusterConfiguration.heightDeviation);
        }
    }

    private boolean canPlacePool(WorldGenLevel level, BlockPos pos) {
        BlockState blockstate = level.getBlockState(pos);
        if (!blockstate.is(Blocks.RED_TERRACOTTA) && !blockstate.is(RuBlocks.RAW_REDSTONE_BLOCK.get()) && !blockstate.is(RuBlocks.POINTED_REDSTONE.get())) {
            if (level.getBlockState(pos.above()).getFluidState().is(FluidTags.WATER)) {
                return false;
            } else {
                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    if (!this.canBeAdjacentToWater(level, pos.relative(direction))) {
                        return false;
                    }
                }

                return this.canBeAdjacentToWater(level, pos.below());
            }
        } else {
            return false;
        }
    }

    private boolean canBeAdjacentToWater(LevelAccessor level, BlockPos pos) {
        BlockState blockstate = level.getBlockState(pos);
        return blockstate.is(BlockTags.BASE_STONE_OVERWORLD) || blockstate.getFluidState().is(FluidTags.WATER);
    }

    private void replaceBlocksWithRedstoneBlocks(WorldGenLevel level, BlockPos pos, int i1, Direction direction) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();

        for(int i = 0; i < i1; ++i) {
            if (!PointedRedstoneUtils.placeRedstoneBlockIfPossible(level, blockpos$mutableblockpos)) {
                return;
            }

            blockpos$mutableblockpos.move(direction);
        }

    }

    private double getChanceOfStalagmiteOrStalactite(int i1, int i2, int i3, int i4, PointedRedstoneClusterConfiguration redstoneClusterConfiguration) {
        int i = i1 - Math.abs(i3);
        int j = i2 - Math.abs(i4);
        int k = Math.min(i, j);
        return (double)Mth.clampedMap((float)k, 0.0F, (float)redstoneClusterConfiguration.maxDistanceFromEdgeAffectingChanceOfRedstoneColumn, redstoneClusterConfiguration.chanceOfRedstoneColumnAtMaxDistanceFromCenter, 1.0F);
    }

    private static float randomBetweenBiased(RandomSource random, float v, float v1, float v2, float v3) {
        return ClampedNormalFloat.sample(random, v2, v3, v, v1);
    }
}

