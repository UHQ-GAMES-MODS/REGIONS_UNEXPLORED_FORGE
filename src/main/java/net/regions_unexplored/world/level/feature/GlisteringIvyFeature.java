package net.regions_unexplored.world.level.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.regions_unexplored.block.RuBlocks;

public class GlisteringIvyFeature extends Feature<NoneFeatureConfiguration> {
    private static final Direction[] DIRECTIONS = Direction.values();

    public GlisteringIvyFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel worldgenlevel = context.level();
        BlockPos pos = context.origin();
        RandomSource randomsource = context.random();
        if (!worldgenlevel.isEmptyBlock(pos)) {
            return false;
        } else {
            BlockState blockstate = worldgenlevel.getBlockState(pos.above());
            if (!blockstate.is(Blocks.NETHERRACK) && !blockstate.is(RuBlocks.GLISTERING_WART.get())) {
                return false;
            } else {
                this.placeRoofGlisteringWart(worldgenlevel, randomsource, pos);
                this.placeRoofGlisteringIvy(worldgenlevel, randomsource, pos);
                return true;
            }
        }
    }

    private void placeRoofGlisteringWart(LevelAccessor level, RandomSource random, BlockPos pos) {
        level.setBlock(pos, RuBlocks.GLISTERING_WART.get().defaultBlockState(), 2);
        BlockPos.MutableBlockPos pos1 = new BlockPos.MutableBlockPos();
        BlockPos.MutableBlockPos pos2 = new BlockPos.MutableBlockPos();

        for(int i = 0; i < 200; ++i) {
            pos1.setWithOffset(pos, random.nextInt(6) - random.nextInt(6), random.nextInt(2) - random.nextInt(5), random.nextInt(6) - random.nextInt(6));
            if (level.isEmptyBlock(pos1)) {
                int j = 0;

                for(Direction direction : DIRECTIONS) {
                    BlockState blockstate = level.getBlockState(pos2.setWithOffset(pos1, direction));
                    if (blockstate.is(Blocks.NETHERRACK) || blockstate.is(RuBlocks.GLISTERING_WART.get())) {
                        ++j;
                    }

                    if (j > 1) {
                        break;
                    }
                }

                if (j == 1) {
                    level.setBlock(pos1, RuBlocks.GLISTERING_WART.get().defaultBlockState(), 2);
                }
            }
        }

    }

    private void placeRoofGlisteringIvy(LevelAccessor level, RandomSource random, BlockPos pos) {
        BlockPos.MutableBlockPos pos1 = new BlockPos.MutableBlockPos();

        for(int i = 0; i < 100; ++i) {
            pos1.setWithOffset(pos, random.nextInt(8) - random.nextInt(8), random.nextInt(2) - random.nextInt(7), random.nextInt(8) - random.nextInt(8));
            if (level.isEmptyBlock(pos1)) {
                BlockState blockstate = level.getBlockState(pos1.above());
                if (blockstate.is(Blocks.NETHERRACK) || blockstate.is(RuBlocks.GLISTERING_WART.get())) {
                    int j = Mth.nextInt(random, 1, 25);
                    if (random.nextInt(6) == 0) {
                        j *= 2;
                    }

                    if (random.nextInt(5) == 0) {
                        j = 1;
                    }

                    placeGlisteringIvyColumn(level, random, pos1, j, 17, 25);
                }
            }
        }

    }

    public static void placeGlisteringIvyColumn(LevelAccessor level, RandomSource random, BlockPos.MutableBlockPos pos, int length, int low, int high) {
        for(int i = 0; i <= length; ++i) {
            if (level.isEmptyBlock(pos)) {
                if (i == length || !level.isEmptyBlock(pos.below())) {
                    level.setBlock(pos, RuBlocks.GLISTERING_IVY.get().defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, Mth.nextInt(random, low, high)), 2);
                    break;
                }

                level.setBlock(pos, RuBlocks.GLISTERING_IVY_PLANT.get().defaultBlockState(), 2);
            }

            pos.move(Direction.DOWN);
        }

    }
}