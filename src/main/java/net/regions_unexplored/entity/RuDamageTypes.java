package net.regions_unexplored.entity;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageType;
import net.regions_unexplored.registry.DamageTypeRegistry;

public class RuDamageTypes {
    public static ResourceKey<DamageType> QUICKSAND = DamageTypeRegistry.createKey("quicksand");
    public static ResourceKey<DamageType> DORCEL = DamageTypeRegistry.createKey("dorcel");

    public static void bootstrap(BootstapContext<DamageType> context) {
        context.register(QUICKSAND, new DamageType("quicksand", 1.0F));
        context.register(DORCEL, new DamageType("dorcel", 1.0F));
    }
}
