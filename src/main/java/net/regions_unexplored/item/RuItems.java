package net.regions_unexplored.item;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.api.item.Food;
import net.regions_unexplored.api.item.FoodItemWithBlock;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.item.items.RuBoatItem;

public class RuItems {
    //TODO:Complete Class
    public static RegistryObject<Item> BAOBAB_SIGN;
    public static RegistryObject<Item> BLACKWOOD_SIGN;
    public static RegistryObject<Item> MAGNOLIA_SIGN;
    public static RegistryObject<Item> CYPRESS_SIGN;
    public static RegistryObject<Item> DEAD_SIGN;
    public static RegistryObject<Item> EUCALYPTUS_SIGN;
    public static RegistryObject<Item> JOSHUA_SIGN;
    public static RegistryObject<Item> LARCH_SIGN;
    public static RegistryObject<Item> MAPLE_SIGN;
    public static RegistryObject<Item> MAUVE_SIGN;
    public static RegistryObject<Item> PALM_SIGN;
    public static RegistryObject<Item> PINE_SIGN;
    public static RegistryObject<Item> REDWOOD_SIGN;
    public static RegistryObject<Item> BRIMWOOD_SIGN;
    public static RegistryObject<Item> WILLOW_SIGN;

    public static RegistryObject<Item> BAOBAB_BOAT;
    public static RegistryObject<Item> BAOBAB_CHEST_BOAT;
    public static RegistryObject<Item> BLACKWOOD_BOAT;
    public static RegistryObject<Item> BLACKWOOD_CHEST_BOAT;
    public static RegistryObject<Item> MAGNOLIA_BOAT;
    public static RegistryObject<Item> MAGNOLIA_CHEST_BOAT;
    public static RegistryObject<Item> CYPRESS_BOAT;
    public static RegistryObject<Item> CYPRESS_CHEST_BOAT;
    public static RegistryObject<Item> DEAD_BOAT;
    public static RegistryObject<Item> DEAD_CHEST_BOAT;
    public static RegistryObject<Item> EUCALYPTUS_BOAT;
    public static RegistryObject<Item> EUCALYPTUS_CHEST_BOAT;
    public static RegistryObject<Item> JOSHUA_BOAT;
    public static RegistryObject<Item> JOSHUA_CHEST_BOAT;
    public static RegistryObject<Item> LARCH_BOAT;
    public static RegistryObject<Item> LARCH_CHEST_BOAT;
    public static RegistryObject<Item> MAPLE_BOAT;
    public static RegistryObject<Item> MAPLE_CHEST_BOAT;
    public static RegistryObject<Item> MAUVE_BOAT;
    public static RegistryObject<Item> MAUVE_CHEST_BOAT;
    public static RegistryObject<Item> PALM_BOAT;
    public static RegistryObject<Item> PALM_CHEST_BOAT;
    public static RegistryObject<Item> PINE_BOAT;
    public static RegistryObject<Item> PINE_CHEST_BOAT;
    public static RegistryObject<Item> REDWOOD_BOAT;
    public static RegistryObject<Item> REDWOOD_CHEST_BOAT;
    public static RegistryObject<Item> BRIMWOOD_BOAT;
    public static RegistryObject<Item> BRIMWOOD_CHEST_BOAT;
    public static RegistryObject<Item> WILLOW_BOAT;
    public static RegistryObject<Item> WILLOW_CHEST_BOAT;

    public static RegistryObject<Item> SALMONBERRY;
    public static RegistryObject<Item> DUSKMELON_SLICE;
    public static RegistryObject<Item> MEADOW_SAGE;
    
    public static void addItems(){
    BAOBAB_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("baobab_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BAOBAB_SIGN.get(), RuBlocks.BAOBAB_WALL_SIGN.get()));
    BLACKWOOD_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("blackwood_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BLACKWOOD_SIGN.get(), RuBlocks.BLACKWOOD_WALL_SIGN.get()));
    MAGNOLIA_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("magnolia_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.MAGNOLIA_SIGN.get(), RuBlocks.MAGNOLIA_WALL_SIGN.get()));
    CYPRESS_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("cypress_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.CYPRESS_SIGN.get(), RuBlocks.CYPRESS_WALL_SIGN.get()));
    DEAD_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("dead_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.DEAD_SIGN.get(), RuBlocks.DEAD_WALL_SIGN.get()));
    EUCALYPTUS_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("eucalyptus_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.EUCALYPTUS_SIGN.get(), RuBlocks.EUCALYPTUS_WALL_SIGN.get()));
    JOSHUA_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("joshua_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.JOSHUA_SIGN.get(), RuBlocks.JOSHUA_WALL_SIGN.get()));
    LARCH_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("larch_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.LARCH_SIGN.get(), RuBlocks.LARCH_WALL_SIGN.get()));
    MAPLE_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("maple_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.MAPLE_SIGN.get(), RuBlocks.MAPLE_WALL_SIGN.get()));
    MAUVE_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("mauve_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.MAUVE_SIGN.get(), RuBlocks.MAUVE_WALL_SIGN.get()));
    PALM_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("palm_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.PALM_SIGN.get(), RuBlocks.PALM_WALL_SIGN.get()));
    PINE_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("pine_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.PINE_SIGN.get(), RuBlocks.PINE_WALL_SIGN.get()));
    REDWOOD_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("redwood_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.REDWOOD_SIGN.get(), RuBlocks.REDWOOD_WALL_SIGN.get()));
    BRIMWOOD_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("brimwood_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.BRIMWOOD_SIGN.get(), RuBlocks.BRIMWOOD_WALL_SIGN.get()));
    WILLOW_SIGN = RegionsUnexploredMod.ITEM_REGISTRY.register("willow_sign", () -> new SignItem(new Item.Properties().stacksTo(16), RuBlocks.WILLOW_SIGN.get(), RuBlocks.WILLOW_WALL_SIGN.get()));

    BAOBAB_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("baobab_boat", () -> new RuBoatItem(false, RuBoat.ModelType.BAOBAB, (new Item.Properties()).stacksTo(1)));
    BAOBAB_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("baobab_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.BAOBAB, (new Item.Properties()).stacksTo(1)));
    BLACKWOOD_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("blackwood_boat", () -> new RuBoatItem(false, RuBoat.ModelType.BLACKWOOD, (new Item.Properties()).stacksTo(1)));
    BLACKWOOD_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("blackwood_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.BLACKWOOD, (new Item.Properties()).stacksTo(1)));
    MAGNOLIA_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("magnolia_boat", () -> new RuBoatItem(false, RuBoat.ModelType.MAGNOLIA, (new Item.Properties()).stacksTo(1)));
    MAGNOLIA_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("magnolia_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.MAGNOLIA, (new Item.Properties()).stacksTo(1)));
    CYPRESS_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("cypress_boat", () -> new RuBoatItem(false, RuBoat.ModelType.CYPRESS, (new Item.Properties()).stacksTo(1)));
    CYPRESS_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("cypress_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.CYPRESS, (new Item.Properties()).stacksTo(1)));
    DEAD_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("dead_boat", () -> new RuBoatItem(false, RuBoat.ModelType.DEAD, (new Item.Properties()).stacksTo(1)));
    DEAD_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("dead_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.DEAD, (new Item.Properties()).stacksTo(1)));
    EUCALYPTUS_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("eucalyptus_boat", () -> new RuBoatItem(false, RuBoat.ModelType.EUCALYPTUS, (new Item.Properties()).stacksTo(1)));
    EUCALYPTUS_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("eucalyptus_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.EUCALYPTUS, (new Item.Properties()).stacksTo(1)));
    JOSHUA_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("joshua_boat", () -> new RuBoatItem(false, RuBoat.ModelType.JOSHUA, (new Item.Properties()).stacksTo(1)));
    JOSHUA_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("joshua_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.JOSHUA, (new Item.Properties()).stacksTo(1)));
    LARCH_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("larch_boat", () -> new RuBoatItem(false, RuBoat.ModelType.LARCH, (new Item.Properties()).stacksTo(1)));
    LARCH_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("larch_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.LARCH, (new Item.Properties()).stacksTo(1)));
    MAPLE_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("maple_boat", () -> new RuBoatItem(false, RuBoat.ModelType.MAPLE, (new Item.Properties()).stacksTo(1)));
    MAPLE_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("maple_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.MAPLE, (new Item.Properties()).stacksTo(1)));
    MAUVE_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("mauve_boat", () -> new RuBoatItem(false, RuBoat.ModelType.MAUVE, (new Item.Properties()).stacksTo(1)));
    MAUVE_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("mauve_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.MAUVE, (new Item.Properties()).stacksTo(1)));
    PALM_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("palm_boat", () -> new RuBoatItem(false, RuBoat.ModelType.PALM, (new Item.Properties()).stacksTo(1)));
    PALM_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("palm_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.PALM, (new Item.Properties()).stacksTo(1)));
    PINE_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("pine_boat", () -> new RuBoatItem(false, RuBoat.ModelType.PINE, (new Item.Properties()).stacksTo(1)));
    PINE_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("pine_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.PINE, (new Item.Properties()).stacksTo(1)));
    REDWOOD_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("redwood_boat", () -> new RuBoatItem(false, RuBoat.ModelType.REDWOOD, (new Item.Properties()).stacksTo(1)));
    REDWOOD_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("redwood_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.REDWOOD, (new Item.Properties()).stacksTo(1)));
    BRIMWOOD_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("brimwood_boat", () -> new RuBoatItem(false, RuBoat.ModelType.BRIMWOOD, (new Item.Properties()).stacksTo(1)));
    BRIMWOOD_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("brimwood_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.BRIMWOOD, (new Item.Properties()).stacksTo(1)));
    WILLOW_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("willow_boat", () -> new RuBoatItem(false, RuBoat.ModelType.WILLOW, (new Item.Properties()).stacksTo(1)));
    WILLOW_CHEST_BOAT = RegionsUnexploredMod.ITEM_REGISTRY.register("willow_chest_boat", () -> new RuBoatItem(true, RuBoat.ModelType.WILLOW, (new Item.Properties()).stacksTo(1)));

    SALMONBERRY = RegionsUnexploredMod.ITEM_REGISTRY.register("salmonberry", () -> new FoodItemWithBlock(RuBlocks.SALMONBERRY_BUSH.get(), new Item.Properties(), new Food(3, 0.3f)));
    DUSKMELON_SLICE = RegionsUnexploredMod.ITEM_REGISTRY.register("duskmelon_slice", () -> new FoodItemWithBlock(RuBlocks.DUSKMELON.get(), new Item.Properties(), new Food(5, 1.1f).addEffect(MobEffects.BLINDNESS, 240, 1)));
    MEADOW_SAGE = RegionsUnexploredMod.ITEM_REGISTRY.register("meadow_sage", () -> new FoodItemWithBlock(RuBlocks.MEADOW_SAGE.get(), new Item.Properties(), new Food(2, 0.15f).addEffect(MobEffects.HEAL, 20, 0.5f)));
    }
}
