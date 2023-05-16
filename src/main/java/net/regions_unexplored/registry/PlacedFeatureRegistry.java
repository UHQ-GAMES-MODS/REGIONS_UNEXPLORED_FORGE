package net.regions_unexplored.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.data.worldgen.placement.RuVegetationPlacements;

public class PlacedFeatureRegistry {
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        RuVegetationPlacements.bootstrap(context);
    }

    public static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(RegionsUnexploredMod.MOD_ID, name));
    }
}
