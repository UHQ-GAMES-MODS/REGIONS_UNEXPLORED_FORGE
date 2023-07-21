package net.regions_unexplored.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RuHangingSignBlockEntity extends HangingSignBlockEntity {
    public RuHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }

    @Override
    public BlockEntityType<?> getType(){
        return RuBlockEntities.HANGING_SIGN_BLOCK_ENTITIES.get();
    }
}
