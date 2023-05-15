package net.regions_unexplored.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.block.state.properties.HangingPrismariteShape;
import net.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;

public class HangingPrismariteBlock extends Block {
    public static final EnumProperty<HangingPrismariteShape> SHAPE = RuBlockStateProperties.HANGING_PRISMARITE_SHAPE;
    protected static final VoxelShape BOX = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public HangingPrismariteBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(SHAPE, HangingPrismariteShape.TIP));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(SHAPE);
    }
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return BOX.move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.above();
        return mayPlaceOn(level.getBlockState(blockpos), level, blockpos);
    }

    public boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.isFaceSturdy(getter, pos, Direction.DOWN) || state.is(RuBlocks.HANGING_PRISMARITE.get());
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
        HangingPrismariteShape shape = state.getValue(SHAPE);
        if(level.getBlockState(pos.below()) == RuBlocks.HANGING_PRISMARITE.get().defaultBlockState().setValue(SHAPE, HangingPrismariteShape.TIP)) {
                shape = HangingPrismariteShape.FRUSTUM;
        }
        else if(level.getBlockState(pos.below()) == RuBlocks.HANGING_PRISMARITE.get().defaultBlockState().setValue(SHAPE, HangingPrismariteShape.FRUSTUM)) {
            shape = HangingPrismariteShape.COLUMN;
        }
        else if(!level.getBlockState(pos.below()).is(RuBlocks.HANGING_PRISMARITE.get())) {
            shape = HangingPrismariteShape.TIP;
        }
        if(!this.canSurvive(state, level, pos)){
            return Blocks.AIR.defaultBlockState();
        }
        return state.setValue(SHAPE, shape);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        if(context.getLevel().getBlockState(context.getClickedPos().below())==RuBlocks.HANGING_PRISMARITE.get().defaultBlockState().setValue(SHAPE, HangingPrismariteShape.FRUSTUM)
                ||context.getLevel().getBlockState(context.getClickedPos().below())==RuBlocks.HANGING_PRISMARITE.get().defaultBlockState().setValue(SHAPE, HangingPrismariteShape.COLUMN)){
            return this.defaultBlockState().setValue(SHAPE, HangingPrismariteShape.COLUMN);
        }
        if(context.getLevel().getBlockState(context.getClickedPos().below())==RuBlocks.HANGING_PRISMARITE.get().defaultBlockState().setValue(SHAPE, HangingPrismariteShape.TIP)){
            return this.defaultBlockState().setValue(SHAPE, HangingPrismariteShape.FRUSTUM);
        }
        else{
            return this.defaultBlockState().setValue(SHAPE, HangingPrismariteShape.TIP);
        }
    }
}

