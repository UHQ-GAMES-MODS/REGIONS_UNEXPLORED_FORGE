package net.regions_unexplored.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PlaceOnWaterBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;

public class ItemRegistry {
    //TODO:Complete Class

    public static <T extends Block> RegistryObject<Item> registerDefaultBlockItem(String name, RegistryObject<T> block) {
        return RegionsUnexploredMod.ITEM_REGISTRY.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static <T extends Block> RegistryObject<Item> registerDuckweedItem(String name, RegistryObject<T> block) {
        return RegionsUnexploredMod.ITEM_REGISTRY.register(name, () -> new PlaceOnWaterBlockItem(block.get(), new Item.Properties()));
    }
}
