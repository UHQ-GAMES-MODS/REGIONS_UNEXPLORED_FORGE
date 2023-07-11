package net.regions_unexplored.world.level.block.plant.tall;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.PlantType;
import net.regions_unexplored.entity.RuDamageTypes;
import net.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;

import javax.annotation.Nullable;

public class DuskTrapBlock extends DoublePlantBlock {
    private static final BooleanProperty CLOSED = RuBlockStateProperties.CLOSED;

    public DuskTrapBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(CLOSED, false));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> stateBuilder) {
        stateBuilder.add(HALF).add(CLOSED);
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource randomSource) {
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        Vec3 inPos = new Vec3(pos.getX()+0.05D, pos.getY(), pos.getZ()+0.05D);
        Vec3 outPos = new Vec3(pos.getX()+0.95D, pos.getY(), pos.getZ()+0.95D);


        Vec3 entityPos = entity.position();

        if (!level.isClientSide) {
            if(entity instanceof Monster){
                if(entityPos.x>inPos.x&&entityPos.z>inPos.z&&entityPos.x<outPos.x&&entityPos.z<outPos.z&&entity.isAlive()){
                    entity.makeStuckInBlock(state, new Vec3(0.4D, 0.1D, 0.4D));
                    entity.hurt(level.damageSources().source(RuDamageTypes.DUSK_TRAP), 3.0F);
                    this.setClosedAndScheduleTick(state, level, pos, true, null);
                }
                else{
                    setOpen(state, level, pos);
                }
            }
        }
    }

    private void setClosedAndScheduleTick(BlockState state, Level level, BlockPos pos, boolean isClosed, @Nullable SoundEvent soundEvent) {
        setClosed(state, level, pos, isClosed);
        level.scheduleTick(pos, this, 2);
    }

    private static void setOpen(BlockState state, Level level, BlockPos pos) {
        setClosed(state, level, pos, false);
    }

    private static void setClosed(BlockState state, Level level, BlockPos pos, boolean isClosed) {
        level.setBlock(pos, state.setValue(CLOSED, isClosed), 2);
        if(level.getBlockState(pos.above()).getBlock() instanceof DuskTrapBlock){
            level.setBlock(pos.above(), level.getBlockState(pos.above()).setValue(CLOSED, isClosed), 2);
        }
        if(level.getBlockState(pos.below()).getBlock() instanceof DuskTrapBlock){
            level.setBlock(pos.below(), level.getBlockState(pos.below()).setValue(CLOSED, isClosed), 2);
        }
    }

    @Override
    public PlantType getPlantType(BlockGetter getter, BlockPos pos) {
        return PlantType.CAVE;
    }
}
