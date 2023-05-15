package net.regions_unexplored.item.behaviour;

import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.Direction;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.phys.Vec3;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.entity.custom.RuChestBoat;

public class RuBoatItemBehaviour extends DefaultDispenseItemBehavior {
    //TODO:Complete Class
    private final DefaultDispenseItemBehavior dispenseItemBehavior = new DefaultDispenseItemBehavior();
    private final RuBoat.ModelType model;
    private final boolean chest;

    public RuBoatItemBehaviour(boolean chest, RuBoat.ModelType model) {
        this.model = model; this.chest = chest;
    }

    @Override
    public ItemStack execute(BlockSource blockSource, ItemStack itemStack) {
        Direction direction = blockSource.getBlockState().getValue(DispenserBlock.FACING);
        Boat boat;
        double d3;

        Vec3 pos = new Vec3(
        blockSource.x() + (double) ((float) direction.getStepX() * 1.125F),
        blockSource.y() + (double) ((float) direction.getStepY() * 1.125F),
        blockSource.y() + (double) ((float) direction.getStepZ() * 1.125F));
        BlockPos blockpos = blockSource.getPos().relative(direction);

        if (blockSource.getLevel().getFluidState(blockpos).is(FluidTags.WATER)) {
            d3 = 1.0D;
        } else {
            if (!blockSource.getLevel().getBlockState(blockpos).isAir() || !blockSource.getLevel().getFluidState(blockpos.below()).is(FluidTags.WATER)) {
                return this.dispenseItemBehavior.dispense(blockSource, itemStack);
            }
            d3 = 0.0D;
        }

        if (this.chest) {
            boat = new RuChestBoat(blockSource.getLevel(), pos.x, pos.y + d3, pos.z); ((RuChestBoat)boat).setModel(this.model);
        } else {
            boat = new RuBoat(blockSource.getLevel(), pos.x, pos.y + d3, pos.z); ((RuBoat)boat).setModel(this.model);
        }

        boat.setYRot(direction.toYRot());
        blockSource.getLevel().addFreshEntity(boat);
        itemStack.shrink(1);

        return itemStack;
    }

    @Override
    protected void playSound(BlockSource p_123373_)
    {
        p_123373_.getLevel().levelEvent(1000, p_123373_.getPos(), 0);
    }
}