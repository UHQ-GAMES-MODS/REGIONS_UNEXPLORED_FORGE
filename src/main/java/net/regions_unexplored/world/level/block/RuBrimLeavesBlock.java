package net.regions_unexplored.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class RuBrimLeavesBlock extends LeavesBlock {
    public RuBrimLeavesBlock(MaterialColor colour) {
        super(Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(RuBrimLeavesBlock::ocelotOrParrot).isSuffocating(RuBrimLeavesBlock::never).isViewBlocking(RuBrimLeavesBlock::never));
    }

    @Override
    public int getLightBlock(BlockState state, BlockGetter getter, BlockPos pos) {
        return 15;
    }

    private static boolean never(BlockState state, BlockGetter getter, BlockPos pos) {
        return false;
    }

    private static Boolean ocelotOrParrot(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type) {
        return (boolean)(type == EntityType.OCELOT || type == EntityType.PARROT);
    }
}