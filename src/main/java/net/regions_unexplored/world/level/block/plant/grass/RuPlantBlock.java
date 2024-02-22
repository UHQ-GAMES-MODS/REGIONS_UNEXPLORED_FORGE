package net.regions_unexplored.world.level.block.plant.grass;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.RuBlocks;

import static net.minecraft.world.level.block.DoublePlantBlock.copyWaterloggedFrom;

public class RuPlantBlock extends BushBlock implements BonemealableBlock, net.minecraftforge.common.IForgeShearable {
    public static final MapCodec<? extends RuPlantBlock> CODEC = simpleCodec(RuPlantBlock::new);
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    protected static final VoxelShape SHAPE_MEDIUM_GRASS = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 9.0D, 14.0D);

    public RuPlantBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if(state==RuBlocks.MEDIUM_GRASS.get().defaultBlockState()){
            return SHAPE_MEDIUM_GRASS;
        }
        else{
            return SHAPE;
        }
    }

    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return true;
    }

    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    public static void placeAt(LevelAccessor level, BlockState state, BlockPos pos, int i) {
        level.setBlock(pos, copyWaterloggedFrom(level, pos, state), i);
    }

    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if(state.is(RuBlocks.MEDIUM_GRASS.get())){
            TallGrassBlock grass = (TallGrassBlock) Blocks.SHORT_GRASS;
            if (grass.defaultBlockState().canSurvive(level, pos)) {
                placeAt(level, grass.defaultBlockState(), pos, 2);
            }
        }
        else if(state.is(RuBlocks.STEPPE_GRASS.get())||state.is(RuBlocks.STEPPE_SHRUB.get())){
            DoublePlantBlock tallSteppeGrass = (DoublePlantBlock) RuBlocks.STEPPE_TALL_GRASS.get();
            if (tallSteppeGrass.defaultBlockState().canSurvive(level, pos) && level.isEmptyBlock(pos.above())) {
                DoublePlantBlock.placeAt(level, tallSteppeGrass.defaultBlockState(), pos, 2);
            }
        }
    }
}
