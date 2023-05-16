package net.regions_unexplored.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.entity.custom.RuChestBoat;

public class RuEntities {
    public static RegistryObject<EntityType<?>> BOAT;
    public static RegistryObject<EntityType<?>> CHEST_BOAT;

    public static void addEntities() {
        BOAT = RegionsUnexploredMod.ENTITY_REGISTRY.register("boat", () -> EntityType.Builder.<RuBoat>of(
                RuBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(RegionsUnexploredMod.MOD_ID + ":boat"));

        CHEST_BOAT = RegionsUnexploredMod.ENTITY_REGISTRY.register("chest_boat", () -> EntityType.Builder.<RuChestBoat>of(
                RuChestBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).clientTrackingRange(10).build(RegionsUnexploredMod.MOD_ID + ":chest_boat"));
    }
}
