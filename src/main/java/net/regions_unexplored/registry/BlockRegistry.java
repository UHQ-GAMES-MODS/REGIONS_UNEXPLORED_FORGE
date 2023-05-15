package net.regions_unexplored.registry;

import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;

import java.util.function.Supplier;

public class BlockRegistry {
    //Register default blocks and items
    public static <T extends Block> RegistryObject<T> registerDefaultBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = RegionsUnexploredMod.BLOCK_REGISTRY.register(name, block);
        ItemRegistry.registerDefaultBlockItem(name, toReturn);
        return toReturn;
    }

    //Register Duckweed block and item
    public static <T extends Block> RegistryObject<T> registerDuckweedBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = RegionsUnexploredMod.BLOCK_REGISTRY.register(name, block);
        ItemRegistry.registerDuckweedItem(name, toReturn);
        return toReturn;
    }
}
