package net.regions_unexplored.data.block.codec;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.regions_unexplored.world.level.block.plant.branch.BranchBlock;

public class BranchBlockCodec {



    private final BlockBehaviour.Properties properties;
    private final BranchBlock.BranchType branchType;

    public BranchBlockCodec(BlockBehaviour.Properties properties, BranchBlock.BranchType branchType) {
        this.properties = properties;
        this.branchType = branchType;
    }

    public BlockBehaviour.Properties getProperties() {
        return properties;
    }

    public BranchBlock.BranchType getBranchType() {
        return branchType;
    }
}