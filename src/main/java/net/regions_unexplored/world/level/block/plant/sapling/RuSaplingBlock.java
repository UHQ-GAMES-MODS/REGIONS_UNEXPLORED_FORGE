package net.regions_unexplored.world.level.block.plant.sapling;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class RuSaplingBlock extends SaplingBlock {
    public RuSaplingBlock(AbstractTreeGrower tree) {
        super(tree, Properties.of().mapColor(MapColor.WOOD).pushReaction(PushReaction.DESTROY).ignitedByLava().noCollission().instabreak().sound(SoundType.GRASS).randomTicks());
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return false;
    }
}
