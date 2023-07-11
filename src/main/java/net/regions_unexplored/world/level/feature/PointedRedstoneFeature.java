package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.regions_unexplored.world.level.feature.configuration.PointedRedstoneConfiguration;
import net.regions_unexplored.world.level.feature.configuration.PointedRedstoneUtils;

import java.util.Optional;

public class PointedRedstoneFeature<P> extends Feature<PointedRedstoneConfiguration> {
    public PointedRedstoneFeature(Codec<PointedRedstoneConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<PointedRedstoneConfiguration> context) {
        LevelAccessor level = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();
        PointedRedstoneConfiguration redstoneConfiguration = context.config();
        Optional<Direction> optional = getTipDirection(level, pos, random);
        if (optional.isEmpty()) {
            return false;
        } else {
            BlockPos blockpos1 = pos.relative(optional.get().getOpposite());
            createPatchOfRedstoneBlocks(level, random, blockpos1, redstoneConfiguration);
            int i = random.nextFloat() < redstoneConfiguration.chanceOfTallerRedstone && PointedRedstoneUtils.isEmptyOrWater(level.getBlockState(pos.relative(optional.get()))) ? 2 : 1;
            PointedRedstoneUtils.growPointedRedstone(level, pos, optional.get(), i, false);
            return true;
        }
    }

    private static Optional<Direction> getTipDirection(LevelAccessor level, BlockPos pos, RandomSource random) {
        boolean flag = PointedRedstoneUtils.isRedstoneBase(level.getBlockState(pos.above()));
        boolean flag1 = PointedRedstoneUtils.isRedstoneBase(level.getBlockState(pos.below()));
        if (flag && flag1) {
            return Optional.of(random.nextBoolean() ? Direction.DOWN : Direction.UP);
        } else if (flag) {
            return Optional.of(Direction.DOWN);
        } else {
            return flag1 ? Optional.of(Direction.UP) : Optional.empty();
        }
    }

    private static void createPatchOfRedstoneBlocks(LevelAccessor level, RandomSource random, BlockPos pos, PointedRedstoneConfiguration redstoneConfiguration) {
        PointedRedstoneUtils.placeRedstoneBlockIfPossible(level, pos);

        for(Direction direction : Direction.Plane.HORIZONTAL) {
            if (!(random.nextFloat() > redstoneConfiguration.chanceOfDirectionalSpread)) {
                BlockPos blockpos = pos.relative(direction);
                PointedRedstoneUtils.placeRedstoneBlockIfPossible(level, blockpos);
                if (!(random.nextFloat() > redstoneConfiguration.chanceOfSpreadRadius2)) {
                    BlockPos blockpos1 = blockpos.relative(Direction.getRandom(random));
                    PointedRedstoneUtils.placeRedstoneBlockIfPossible(level, blockpos1);
                    if (!(random.nextFloat() > redstoneConfiguration.chanceOfSpreadRadius3)) {
                        BlockPos blockpos2 = blockpos1.relative(Direction.getRandom(random));
                        PointedRedstoneUtils.placeRedstoneBlockIfPossible(level, blockpos2);
                    }
                }
            }
        }

    }
}
