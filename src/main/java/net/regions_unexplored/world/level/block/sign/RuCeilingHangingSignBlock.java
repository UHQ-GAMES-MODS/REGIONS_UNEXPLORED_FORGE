package net.regions_unexplored.world.level.block.sign;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.CeilingHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.regions_unexplored.block.entity.RuHangingSignBlockEntity;

public class RuCeilingHangingSignBlock extends CeilingHangingSignBlock {
    public RuCeilingHangingSignBlock(Properties properties, WoodType type) {
        super(properties, type);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state){
        return new RuHangingSignBlockEntity(pos, state);
    }
}
