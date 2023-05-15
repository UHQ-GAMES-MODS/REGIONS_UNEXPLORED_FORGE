package net.regions_unexplored.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;
import net.regions_unexplored.world.level.block.state.properties.SaguaroCactusShape;

public class SaguaroCactusBlock extends Block {
    public static final EnumProperty<SaguaroCactusShape> SHAPE = RuBlockStateProperties.CACTUS_SHAPE;

    public SaguaroCactusBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(SHAPE);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
        SaguaroCactusShape shape = state.getValue(SHAPE);

        if(level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)){
            if(level.getBlockState(pos.below()) != RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)) {
                if(state.getValue(SHAPE)==SaguaroCactusShape.NORTH_UP){
                    if(level.getBlockState(pos.north()) != RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.NORTH_SOUTH)){
                        if(level.getBlockState(pos.east()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.EAST_WEST)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)){
                                shape = SaguaroCactusShape.EAST_UP;
                        }
                        if(level.getBlockState(pos.south()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.NORTH_SOUTH)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)){
                                shape = SaguaroCactusShape.SOUTH_UP;
                        }
                        if(level.getBlockState(pos.west()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.EAST_WEST)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)) {
                                shape = SaguaroCactusShape.WEST_UP;
                        }
                    }
                }
                else if(state.getValue(SHAPE)==SaguaroCactusShape.EAST_UP){
                    if(level.getBlockState(pos.east()) != RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.EAST_WEST)){
                        if(level.getBlockState(pos.north()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.NORTH_SOUTH)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)){
                                shape = SaguaroCactusShape.NORTH_UP;
                        }
                        if(level.getBlockState(pos.south()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.NORTH_SOUTH)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)){
                                shape = SaguaroCactusShape.SOUTH_UP;
                        }
                        if(level.getBlockState(pos.west()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.EAST_WEST)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)) {
                                shape = SaguaroCactusShape.WEST_UP;
                        }
                    }
                }
                else if(state.getValue(SHAPE)==SaguaroCactusShape.SOUTH_UP){
                    if(level.getBlockState(pos.south()) != RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.NORTH_SOUTH)){
                        if(level.getBlockState(pos.north()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.NORTH_SOUTH)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)){
                            shape = SaguaroCactusShape.NORTH_UP;
                        }
                        if(level.getBlockState(pos.east()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.EAST_WEST)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)){
                            shape = SaguaroCactusShape.EAST_UP;
                        }
                        if(level.getBlockState(pos.west()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.EAST_WEST)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)) {
                            shape = SaguaroCactusShape.WEST_UP;
                        }
                    }
                }
                else if(state.getValue(SHAPE)==SaguaroCactusShape.WEST_UP){
                    if(level.getBlockState(pos.west()) != RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.EAST_WEST)){
                        if(level.getBlockState(pos.north()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.NORTH_SOUTH)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)){
                            shape = SaguaroCactusShape.NORTH_UP;
                        }
                        if(level.getBlockState(pos.east()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.EAST_WEST)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)){
                            shape = SaguaroCactusShape.EAST_UP;
                        }
                        if(level.getBlockState(pos.south()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.NORTH_SOUTH)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)){
                            shape = SaguaroCactusShape.SOUTH_UP;
                        }
                    }
                }


            }
            if(level.getBlockState(pos.north()) != RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.NORTH_SOUTH)&&
                    level.getBlockState(pos.south()) != RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.NORTH_SOUTH)&&
                    level.getBlockState(pos.east()) != RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.EAST_WEST)&&
                    level.getBlockState(pos.west()) != RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.EAST_WEST)) {
                shape = SaguaroCactusShape.UP_DOWN;
            }
        }

        if(level.getBlockState(pos.below()) != RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)) {
            if(level.getBlockState(pos.north()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.NORTH_SOUTH)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)){
                if(shape==SaguaroCactusShape.SOUTH_UP||shape==SaguaroCactusShape.EAST_UP||shape==SaguaroCactusShape.WEST_UP){}
                else {
                    shape = SaguaroCactusShape.NORTH_UP;
                }
            }
            if(level.getBlockState(pos.east()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.EAST_WEST)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)){
                if(shape==SaguaroCactusShape.NORTH_UP||shape==SaguaroCactusShape.SOUTH_UP||shape==SaguaroCactusShape.WEST_UP){}
                else {
                    shape = SaguaroCactusShape.EAST_UP;
                }
            }
            if(level.getBlockState(pos.south()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.NORTH_SOUTH)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)){
                if(shape==SaguaroCactusShape.NORTH_UP||shape==SaguaroCactusShape.EAST_UP||shape==SaguaroCactusShape.WEST_UP){}
                else {
                    shape = SaguaroCactusShape.SOUTH_UP;
                }
            }
            if(level.getBlockState(pos.west()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.EAST_WEST)&&level.getBlockState(pos.above()) == RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)) {
                if(shape==SaguaroCactusShape.NORTH_UP||shape==SaguaroCactusShape.EAST_UP||shape==SaguaroCactusShape.SOUTH_UP){}
                else {
                    shape = SaguaroCactusShape.WEST_UP;
                }
            }
        }
        if(level.getBlockState(pos.above()) != RuBlocks.SAGUARO_CACTUS.get().defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN)) {
            if(shape==SaguaroCactusShape.NORTH_UP||shape==SaguaroCactusShape.SOUTH_UP){
                shape = SaguaroCactusShape.NORTH_SOUTH;
            }
            else if(shape==SaguaroCactusShape.EAST_UP||shape==SaguaroCactusShape.WEST_UP){
                shape = SaguaroCactusShape.EAST_WEST;
            }
        }
            return state.setValue(SHAPE, shape);
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        Direction direction = context.getClickedFace();
        if(context.getLevel().getBlockState(blockpos.below())!=RuBlocks.SAGUARO_CACTUS.get().defaultBlockState()){
            if(direction==Direction.NORTH){
                if(context.getLevel().getBlockState(blockpos.above())==RuBlocks.SAGUARO_CACTUS.get().defaultBlockState()){
                    return this.defaultBlockState().setValue(SHAPE, SaguaroCactusShape.SOUTH_UP);
                }
            }
            if(direction==Direction.SOUTH){
                if(context.getLevel().getBlockState(blockpos.above())==RuBlocks.SAGUARO_CACTUS.get().defaultBlockState()){
                    return this.defaultBlockState().setValue(SHAPE, SaguaroCactusShape.NORTH_UP);
                }
            }
            if(direction==Direction.EAST){
                if(context.getLevel().getBlockState(blockpos.above())==RuBlocks.SAGUARO_CACTUS.get().defaultBlockState()){
                    return this.defaultBlockState().setValue(SHAPE, SaguaroCactusShape.WEST_UP);
                }
            }
            if(direction==Direction.WEST){
                if(context.getLevel().getBlockState(blockpos.above())==RuBlocks.SAGUARO_CACTUS.get().defaultBlockState()){
                    return this.defaultBlockState().setValue(SHAPE, SaguaroCactusShape.EAST_UP);
                }
            }
        }
        if(context.getClickedFace().getAxis().equals(Direction.Axis.X)){
            return this.defaultBlockState().setValue(SHAPE, SaguaroCactusShape.EAST_WEST);
        }
        if(context.getClickedFace().getAxis().equals(Direction.Axis.Y)){
            return this.defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN);
        }
        if(context.getClickedFace().getAxis().equals(Direction.Axis.Z)){
            return this.defaultBlockState().setValue(SHAPE, SaguaroCactusShape.NORTH_SOUTH);
        }
        return this.defaultBlockState().setValue(SHAPE, SaguaroCactusShape.UP_DOWN);
    }
}
