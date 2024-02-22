package net.regions_unexplored.world.level.block.plant.nether;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.NetherVines;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RuBlocks;

public class HangingEarlightBlock extends GrowingPlantHeadBlock {
    public static final MapCodec<? extends HangingEarlightBlock> CODEC = simpleCodec(HangingEarlightBlock::new);
    protected static final VoxelShape SHAPE = Block.box(1.0D, 1.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    public HangingEarlightBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false, 0.1D);
    }

    @Override
    protected MapCodec<? extends GrowingPlantHeadBlock> codec() {
        return CODEC;
    }

    protected int getBlocksToGrowWhenBonemealed(RandomSource random) {
        return NetherVines.getBlocksToGrowWhenBonemealed(random);
    }

    protected Block getBodyBlock() {
        return RuBlocks.HANGING_EARLIGHT_PLANT.get();
    }

    protected boolean canGrowInto(BlockState state) {
        return NetherVines.isValidGrowthState(state);
    }
}
