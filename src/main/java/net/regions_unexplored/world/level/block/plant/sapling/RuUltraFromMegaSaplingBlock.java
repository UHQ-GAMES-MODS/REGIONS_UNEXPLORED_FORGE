package net.regions_unexplored.world.level.block.plant.sapling;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.regions_unexplored.block.sapling.RuUltraFromMegaTreeGrower;
import net.regions_unexplored.block.sapling.RuUltraFromSuperTreeGrower;

public class RuUltraFromMegaSaplingBlock extends BushBlock implements BonemealableBlock {

    public static final MapCodec<RuUltraFromMegaSaplingBlock> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
        return instance.group(RuUltraFromMegaTreeGrower.CODEC.fieldOf("tree").forGetter((ultraSaplingBlock) -> {
            return ultraSaplingBlock.treeGrower;
        }), propertiesCodec()).apply(instance, RuUltraFromMegaSaplingBlock::new);
    });

    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    protected final RuUltraFromMegaTreeGrower treeGrower;

    public MapCodec<? extends RuUltraFromMegaSaplingBlock> codec() {
        return CODEC;
    }

    public RuUltraFromMegaSaplingBlock(RuUltraFromMegaTreeGrower treeGrower, Properties properties) {
        super(properties);
        this.treeGrower = treeGrower;
        this.registerDefaultState(this.stateDefinition.any().setValue(STAGE, Integer.valueOf(0)));
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isAreaLoaded(pos, 1)) return;
        if (level.getMaxLocalRawBrightness(pos.above()) >= 9 && random.nextInt(7) == 0) {
            this.advanceTree(level, pos, state, random);
        }

    }

    public void advanceTree(ServerLevel level, BlockPos pos, BlockState state, RandomSource random) {
        if (state.getValue(STAGE) == 0) {
            level.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            this.treeGrower.growTree(level, level.getChunkSource().getGenerator(), pos, state, random);
        }

    }

    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return true;
    }

    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return (double)level.random.nextFloat() < 0.45D;
    }

    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        this.advanceTree(level, pos, state, random);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        state.add(STAGE);
    }
}

