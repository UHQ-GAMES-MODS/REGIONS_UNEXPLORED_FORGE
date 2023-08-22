package net.regions_unexplored.world.level.block.plant.tall;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RuBlocks;

public class ElephantEarBlock extends DoublePlantBlock {
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE_LOWER = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    protected static final VoxelShape SHAPE_UPPER = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D);

    public ElephantEarBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if(state== RuBlocks.ELEPHANT_EAR.get().defaultBlockState().setValue(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)){
            return SHAPE_LOWER;
        }
        else if(state== RuBlocks.ELEPHANT_EAR.get().defaultBlockState().setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER)){
            return SHAPE_UPPER;
        }
        return SHAPE_LOWER;
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return false;
    }

}
