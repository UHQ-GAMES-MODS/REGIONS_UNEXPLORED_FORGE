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

public class HangingEarlightFeature extends Feature<NoneFeatureConfiguration> {
    private static final Direction[] DIRECTIONS = Direction.values();

    public HangingEarlightFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        BlockPos pos = context.origin();
        RandomSource random = context.random();
        if (!level.isEmptyBlock(pos)) {
            return false;
        } else {
            BlockState blockstate = level.getBlockState(pos.above());
            if (!blockstate.is(Blocks.BLACKSTONE) && !blockstate.is(RuBlocks.COBALT_OBSIDIAN.get())) {
                return false;
            } else {
                this.placeRoofCobaltObsidian(level, random, pos);
                this.placeRoofHangingEarlight(level, random, pos);
                return true;
            }
        }
    }

    private void placeRoofCobaltObsidian(LevelAccessor level, RandomSource random, BlockPos pos) {
        level.setBlock(pos, RuBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
        BlockPos.MutableBlockPos pos1 = new BlockPos.MutableBlockPos();
        BlockPos.MutableBlockPos pos2 = new BlockPos.MutableBlockPos();

        for(int i = 0; i < 200; ++i) {
            pos1.setWithOffset(pos, random.nextInt(6) - random.nextInt(6), random.nextInt(2) - random.nextInt(5), random.nextInt(6) - random.nextInt(6));
            if (level.isEmptyBlock(pos1)) {
                int j = 0;

                for(Direction direction : DIRECTIONS) {
                    BlockState blockstate = level.getBlockState(pos2.setWithOffset(pos1, direction));
                    if (blockstate.is(Blocks.NETHERRACK) || blockstate.is(RuBlocks.COBALT_OBSIDIAN.get())) {
                        ++j;
                    }

                    if (j > 1) {
                        break;
                    }
                }

                if (j == 1) {
                    level.setBlock(pos1, RuBlocks.COBALT_OBSIDIAN.get().defaultBlockState(), 2);
                }
            }
        }

    }

    private void placeRoofHangingEarlight(LevelAccessor level, RandomSource random, BlockPos pos) {
        BlockPos.MutableBlockPos pos1 = new BlockPos.MutableBlockPos();

        for(int i = 0; i < 100; ++i) {
            pos1.setWithOffset(pos, random.nextInt(8) - random.nextInt(8), random.nextInt(2) - random.nextInt(7), random.nextInt(8) - random.nextInt(8));
            if (level.isEmptyBlock(pos1)) {
                BlockState blockstate = level.getBlockState(pos1.above());
                if (blockstate.is(Blocks.NETHERRACK) || blockstate.is(RuBlocks.COBALT_OBSIDIAN.get())) {
                    int j = Mth.nextInt(random, 1, 19);
                    if (random.nextInt(6) == 0) {
                        j *= 2;
                    }

                    if (random.nextInt(5) == 0) {
                        j = 1;
                    }

                    placeHangingEarlightColumn(level, random, pos1, j, 10, 19);
                }
            }
        }

    }

    public static void placeHangingEarlightColumn(LevelAccessor level, RandomSource random, BlockPos.MutableBlockPos pos, int length, int low, int high) {
        for(int i = 0; i <= length; ++i) {
            if (level.isEmptyBlock(pos)) {
                if (i == length || !level.isEmptyBlock(pos.below())) {
                    level.setBlock(pos, RuBlocks.HANGING_EARLIGHT.get().defaultBlockState().setValue(GrowingPlantHeadBlock.AGE, Mth.nextInt(random, low, high)), 2);
                    break;
                }

                level.setBlock(pos, RuBlocks.HANGING_EARLIGHT_PLANT.get().defaultBlockState(), 2);
            }

            pos.move(Direction.DOWN);
        }

    }
}