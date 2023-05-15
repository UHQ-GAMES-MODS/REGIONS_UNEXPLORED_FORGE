package net.regions_unexplored.entity;

import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.damagesource.DamageType;
import net.regions_unexplored.registry.DamageTypeRegistry;

public class RuDamageTypes {
    public static void bootstrap(BootstapContext<DamageType> context) {
        context.register(DamageTypeRegistry.QUICKSAND, new DamageType("quicksand", 1.0F));
        context.register(DamageTypeRegistry.DORCEL, new DamageType("dorcel", 1.0F));
    }
}
