package net.regions_unexplored.world.level.block.plant.dusktrap;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.common.PlantType;
import net.regions_unexplored.world.level.block.state.properties.RuBlockStateProperties;

public class DuskTrapBlock extends BaseDuskTrapBlock {
    public static final BooleanProperty POWERED = RuBlockStateProperties.CLOSED;
    private final Sensitivity sensitivity;

    public DuskTrapBlock(Sensitivity p_273523_, Properties p_273571_) {
        super(p_273571_);
        this.registerDefaultState(this.stateDefinition.any().setValue(POWERED, Boolean.valueOf(false)).setValue(HALF, DoubleBlockHalf.LOWER));
        this.sensitivity = p_273523_;
    }

    protected int getSignalForState(BlockState p_55270_) {
        return p_55270_.getValue(POWERED) ? 15 : 0;
    }

    protected BlockState setSignalForState(BlockState p_55259_, int p_55260_) {
        return p_55259_.setValue(POWERED, Boolean.valueOf(p_55260_ > 0));
    }

    @Override
    public PlantType getPlantType(BlockGetter getter, BlockPos pos) {
        return PlantType.CAVE;
    }

    protected int getSignalStrength(Level p_55264_, BlockPos p_55265_) {
        Class<? extends Entity> oclass1;
        switch (this.sensitivity) {
            case EVERYTHING:
                oclass1 = Entity.class;
                break;
            case MOBS:
                oclass1 = LivingEntity.class;
                break;
            default:
                throw new IncompatibleClassChangeError();
        }

        Class oclass = oclass1;
        return getEntityCount(p_55264_, TOUCH_AABB.move(p_55265_), oclass) > 0 ? 15 : 0;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_55262_) {
        p_55262_.add(POWERED).add(HALF);
    }

    public static enum Sensitivity {
        EVERYTHING,
        MOBS;
    }
}
