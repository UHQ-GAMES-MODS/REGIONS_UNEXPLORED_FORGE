package net.regions_unexplored.block.entity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.block.RuBlocks;

public class RuBlockEntities {
    
    public static RegistryObject<BlockEntityType<RuSignBlockEntity>> SIGN_BLOCK_ENTITIES;
    
    public static void addBlockEntities() {
        SIGN_BLOCK_ENTITIES = RegionsUnexploredMod.BLOCK_ENTITY_REGISTRY.register("sign_block_entity", () ->

                BlockEntityType.Builder.of(RuSignBlockEntity::new,

                        RuBlocks.BAOBAB_WALL_SIGN.get(), RuBlocks.BAOBAB_SIGN.get(),
                        RuBlocks.BLACKWOOD_WALL_SIGN.get(), RuBlocks.BLACKWOOD_SIGN.get(),
                        RuBlocks.BRIMWOOD_WALL_SIGN.get(), RuBlocks.BRIMWOOD_SIGN.get(),
                        RuBlocks.CYPRESS_WALL_SIGN.get(), RuBlocks.CYPRESS_SIGN.get(),
                        RuBlocks.DEAD_WALL_SIGN.get(), RuBlocks.DEAD_SIGN.get(),
                        RuBlocks.EUCALYPTUS_WALL_SIGN.get(), RuBlocks.EUCALYPTUS_SIGN.get(),
                        RuBlocks.JOSHUA_WALL_SIGN.get(), RuBlocks.JOSHUA_SIGN.get(),
                        RuBlocks.LARCH_WALL_SIGN.get(), RuBlocks.LARCH_SIGN.get(),
                        RuBlocks.MAGNOLIA_WALL_SIGN.get(), RuBlocks.MAGNOLIA_SIGN.get(),
                        RuBlocks.MAPLE_WALL_SIGN.get(), RuBlocks.MAPLE_SIGN.get(),
                        RuBlocks.MAUVE_WALL_SIGN.get(), RuBlocks.MAUVE_SIGN.get(),
                        RuBlocks.PALM_WALL_SIGN.get(), RuBlocks.PALM_SIGN.get(),
                        RuBlocks.PINE_WALL_SIGN.get(), RuBlocks.PINE_SIGN.get(),
                        RuBlocks.REDWOOD_WALL_SIGN.get(), RuBlocks.REDWOOD_SIGN.get(),
                        RuBlocks.WILLOW_WALL_SIGN.get(), RuBlocks.WILLOW_SIGN.get()

                ).build(null));
    }
}
