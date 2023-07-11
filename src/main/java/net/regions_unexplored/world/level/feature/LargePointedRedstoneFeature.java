package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.FloatProvider;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Column;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.phys.Vec3;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.feature.configuration.LargePointedRedstoneConfiguration;
import net.regions_unexplored.world.level.feature.configuration.PointedRedstoneUtils;

import javax.annotation.Nullable;
import java.util.Optional;

public class LargePointedRedstoneFeature extends Feature<LargePointedRedstoneConfiguration> {
    public LargePointedRedstoneFeature(Codec<LargePointedRedstoneConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<LargePointedRedstoneConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        LargePointedRedstoneConfiguration largeRedstoneConfiguration = context.config();
        RandomSource random = context.random();
        if (!PointedRedstoneUtils.isEmptyOrWater(level, pos)) {
            return false;
        } else {
            Optional<Column> optional = Column.scan(level, pos, largeRedstoneConfiguration.floorToCeilingSearchRange, PointedRedstoneUtils::isEmptyOrWater, PointedRedstoneUtils::isRedstoneBaseOrLava);
            if (optional.isPresent() && optional.get() instanceof Column.Range) {
                Column.Range columnRange = (Column.Range)optional.get();
                if (columnRange.height() < 4) {
                    return false;
                } else {
                    int i = (int)((float)columnRange.height() * largeRedstoneConfiguration.maxColumnRadiusToCaveHeightRatio);
                    int j = Mth.clamp(i, largeRedstoneConfiguration.columnRadius.getMinValue(), largeRedstoneConfiguration.columnRadius.getMaxValue());
                    int k = Mth.randomBetweenInclusive(random, largeRedstoneConfiguration.columnRadius.getMinValue(), j);
                    LargeRedstone largeRedstone = makeRedstone(pos.atY(columnRange.ceiling() - 1), false, random, k, largeRedstoneConfiguration.stalactiteBluntness, largeRedstoneConfiguration.heightScale);
                    LargeRedstone largeRedstone1 = makeRedstone(pos.atY(columnRange.floor() + 1), true, random, k, largeRedstoneConfiguration.stalagmiteBluntness, largeRedstoneConfiguration.heightScale);
                    WindOffsetter windOffsetter;
                    if (largeRedstone.isSuitableForWind(largeRedstoneConfiguration) && largeRedstone1.isSuitableForWind(largeRedstoneConfiguration)) {
                        windOffsetter = new WindOffsetter(pos.getY(), random, largeRedstoneConfiguration.windSpeed);
                    } else {
                        windOffsetter = WindOffsetter.noWind();
                    }

                    boolean flag = largeRedstone.moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(level, windOffsetter);
                    boolean flag1 = largeRedstone1.moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(level, windOffsetter);
                    if (flag) {
                        largeRedstone.placeBlocks(level, random, windOffsetter);
                    }

                    if (flag1) {
                        largeRedstone1.placeBlocks(level, random, windOffsetter);
                    }

                    return true;
                }
            } else {
                return false;
            }
        }
    }

    private static LargeRedstone makeRedstone(BlockPos pos, boolean pointingUp, RandomSource random, int radius, FloatProvider bluntness, FloatProvider scale) {
        return new LargeRedstone(pos, pointingUp, radius, (double)bluntness.sample(random), (double)scale.sample(random));
    }

    static final class LargeRedstone {
        private BlockPos root;
        private final boolean pointingUp;
        private int radius;
        private final double bluntness;
        private final double scale;

        LargeRedstone(BlockPos pos, boolean pointingUp, int radius, double bluntness, double scale) {
            this.root = pos;
            this.pointingUp = pointingUp;
            this.radius = radius;
            this.bluntness = bluntness;
            this.scale = scale;
        }

        private int getHeight() {
            return this.getHeightAtRadius(0.0F);
        }

        boolean moveBackUntilBaseIsInsideStoneAndShrinkRadiusIfNecessary(WorldGenLevel level, WindOffsetter windOffsetter) {
            while(this.radius > 1) {
                BlockPos.MutableBlockPos pos = this.root.mutable();
                int i = Math.min(10, this.getHeight());

                for(int j = 0; j < i; ++j) {
                    if (level.getBlockState(pos).is(Blocks.LAVA)) {
                        return false;
                    }

                    if (PointedRedstoneUtils.isCircleMostlyEmbeddedInStone(level, windOffsetter.offset(pos), this.radius)) {
                        this.root = pos;
                        return true;
                    }

                    pos.move(this.pointingUp ? Direction.DOWN : Direction.UP);
                }

                this.radius /= 2;
            }

            return false;
        }

        private int getHeightAtRadius(float v) {
            return (int)PointedRedstoneUtils.getRedstoneHeight((double)v, (double)this.radius, this.scale, this.bluntness);
        }

        void placeBlocks(WorldGenLevel level, RandomSource random, WindOffsetter windOffsetter) {
            for(int i = -this.radius; i <= this.radius; ++i) {
                for(int j = -this.radius; j <= this.radius; ++j) {
                    float f = Mth.sqrt((float)(i * i + j * j));
                    if (!(f > (float)this.radius)) {
                        int k = this.getHeightAtRadius(f);
                        if (k > 0) {
                            if ((double)random.nextFloat() < 0.2D) {
                                k = (int)((float)k * Mth.randomBetween(random, 0.8F, 1.0F));
                            }

                            BlockPos.MutableBlockPos pos = this.root.offset(i, 0, j).mutable();
                            boolean flag = false;
                            int l = this.pointingUp ? level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, pos.getX(), pos.getZ()) : Integer.MAX_VALUE;

                            for(int i1 = 0; i1 < k && pos.getY() < l; ++i1) {
                                BlockPos blockpos = windOffsetter.offset(pos);
                                if (PointedRedstoneUtils.isEmptyOrWaterOrLava(level, blockpos)) {
                                    flag = true;
                                    Block block = RuBlocks.RAW_REDSTONE_BLOCK.get();
                                    level.setBlock(blockpos, block.defaultBlockState(), 2);
                                } else if (flag && level.getBlockState(blockpos).is(BlockTags.BASE_STONE_OVERWORLD)) {
                                    break;
                                }

                                pos.move(this.pointingUp ? Direction.UP : Direction.DOWN);
                            }
                        }
                    }
                }
            }

        }

        boolean isSuitableForWind(LargePointedRedstoneConfiguration largeRedstoneConfiguration) {
            return this.radius >= largeRedstoneConfiguration.minRadiusForWind && this.bluntness >= (double)largeRedstoneConfiguration.minBluntnessForWind;
        }
    }

    static final class WindOffsetter {
        private final int originY;
        @Nullable
        private final Vec3 windSpeed;

        WindOffsetter(int originY, RandomSource random, FloatProvider floatProvider) {
            this.originY = originY;
            float f = floatProvider.sample(random);
            float f1 = Mth.randomBetween(random, 0.0F, (float)Math.PI);
            this.windSpeed = new Vec3((double)(Mth.cos(f1) * f), 0.0D, (double)(Mth.sin(f1) * f));
        }

        private WindOffsetter() {
            this.originY = 0;
            this.windSpeed = null;
        }

        static WindOffsetter noWind() {
            return new WindOffsetter();
        }

        BlockPos offset(BlockPos pos) {
            if (this.windSpeed == null) {
                return pos;
            } else {
                int i = this.originY - pos.getY();
                Vec3 vec3 = this.windSpeed.scale((double)i);
                return pos.offset(Mth.floor(vec3.x), 0, Mth.floor(vec3.z));
            }
        }
    }
}
