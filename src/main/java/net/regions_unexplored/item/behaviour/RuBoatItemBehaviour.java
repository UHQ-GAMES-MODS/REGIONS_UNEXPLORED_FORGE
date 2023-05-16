package net.regions_unexplored.item.behaviour;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.Vec3;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.entity.custom.RuChestBoat;

public class RuBoatItemBehaviour extends DefaultDispenseItemBehavior {
    private final DefaultDispenseItemBehavior dispenseItemBehavior = new DefaultDispenseItemBehavior();
    private final RuBoat.ModelType model;
    private final boolean chest;

    public RuBoatItemBehaviour(RuBoat.ModelType model) {
        this(false, model);
    }

    public RuBoatItemBehaviour(boolean chest, RuBoat.ModelType model) {
        this.model = model;
        this.chest = chest;
    }

    @Override
    public ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
        Direction direction = blockSource.getBlockState().getValue(DispenserBlock.FACING);
        Level level = blockSource.getLevel();

        Vec3 pos = new Vec3(
        blockSource.x() + (double) ((float) direction.getStepX() * 1.125F),
        blockSource.y() + (double) ((float) direction.getStepY() * 1.125F),
        blockSource.y() + (double) ((float) direction.getStepZ() * 1.125F));

        Boat boat = (this.chest ? new RuChestBoat(level, pos.x, pos.y, pos.z) : new RuBoat(level, pos.x, pos.y, pos.z));

        if (this.chest) {
            ((RuChestBoat) boat).setModel(this.model);
        }
        else {
            ((RuBoat) boat).setModel(this.model);
        }

        boat.setYRot(direction.toYRot());
        BlockPos blockpos = blockSource.getPos().relative(direction);
        double d3;
        if (boat.canBoatInFluid(level.getFluidState(blockpos))) {
            d3 = 1.0D;
        }
        else {
            if (!level.getBlockState(blockpos).isAir() || !boat.canBoatInFluid(level.getFluidState(blockpos.below()))) {
                return this.dispenseItemBehavior.dispense(blockSource, itemStack);
            }
            d3 = 0.0D;
        }

        boat.setPos(pos.x, pos.y + d3, pos.z);
        level.addFreshEntity(boat);
        itemStack.shrink(1);
        return itemStack;
    }

    @Override
    protected void playSound(BlockSource p_123373_)
    {
        p_123373_.getLevel().levelEvent(1000, p_123373_.getPos(), 0);
    }
}