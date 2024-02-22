package net.regions_unexplored.world.level.block.plant.nether;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RuBlocks;

public class HangingEarlightPlantBlock extends GrowingPlantBodyBlock {
    public static final MapCodec<? extends HangingEarlightPlantBlock> CODEC = simpleCodec(HangingEarlightPlantBlock::new);
    public static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public HangingEarlightPlantBlock(Properties properties) {
        super(properties, Direction.DOWN, SHAPE, false);
    }

    protected GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) RuBlocks.HANGING_EARLIGHT.get();
    }

    @Override
    protected MapCodec<? extends GrowingPlantBodyBlock> codec() {
        return CODEC;
    }
}