package net.regions_unexplored.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.regions_unexplored.block.entity.custom.RuSignBlockEntity;

public class RuStandingSignBlock extends StandingSignBlock {
    public RuStandingSignBlock(Properties properties, WoodType type) {
        super(properties, type);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state){
        return new RuSignBlockEntity(pos, state);
    }
}
