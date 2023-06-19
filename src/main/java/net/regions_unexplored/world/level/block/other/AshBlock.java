package net.regions_unexplored.world.level.block.other;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Fallable;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;

public class AshBlock extends Block implements Fallable {

    public static final BooleanProperty HAS_GRAVITY = RuBlockStateProperties.HAS_GRAVITY;

    public AshBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(HAS_GRAVITY, true));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(HAS_GRAVITY);
    }

    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState state1, boolean b) {
        level.scheduleTick(pos, this, this.getDelayAfterPlace());
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {
        level.scheduleTick(pos, this, this.getDelayAfterPlace());
        return super.updateShape(state, direction, state1, level, pos, pos1);
    }

    public void tick(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource random) {
        if(level.getBlockState(pos) == this.defaultBlockState().setValue(AshBlock.HAS_GRAVITY, true)){
            if (isFree(level.getBlockState(pos.below())) && pos.getY() >= level.getMinBuildHeight()) {
                FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(level, pos, blockState);
                this.falling(fallingblockentity);
            }
        }
    }

    protected void falling(FallingBlockEntity entity) {
    }

    protected int getDelayAfterPlace() {
        return 2;
    }

    public static boolean isFree(BlockState state) {
        return state.isAir() || state.is(BlockTags.FIRE) || state.liquid() || state.canBeReplaced();
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        if (random.nextInt(16) == 0) {
            BlockPos blockpos = pos.below();
            if (isFree(level.getBlockState(blockpos))) {
                double d0 = (double)pos.getX() + random.nextDouble();
                double d1 = (double)pos.getY() - 0.05D;
                double d2 = (double)pos.getZ() + random.nextDouble();
                level.addParticle(new BlockParticleOption(ParticleTypes.FALLING_DUST, state), d0, d1, d2, 0.0D, 0.0D, 0.0D);
            }
        }

    }

    public int getDustColor(BlockState state, BlockGetter getter, BlockPos pos) {
        return -8356741;
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
                    return (this.defaultBlockState().setValue(HAS_GRAVITY, true));
    }
}