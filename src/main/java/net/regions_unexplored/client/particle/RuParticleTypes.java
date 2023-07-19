package net.regions_unexplored.client.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;

public class RuParticleTypes {
    public static RegistryObject<ParticleType<?>> MAUVE_LEAVES;
    public static RegistryObject<ParticleType<?>> MYCOTOXIC_SPORE;
    public static RegistryObject<ParticleType<?>> ORANGE_MAPLE_LEAVES;
    public static RegistryObject<ParticleType<?>> RED_MAPLE_LEAVES;
    public static RegistryObject<ParticleType<?>> BLUE_MAGNOLIA_LEAVES;
    public static RegistryObject<ParticleType<?>> PINK_MAGNOLIA_LEAVES;
    public static RegistryObject<ParticleType<?>> WHITE_MAGNOLIA_LEAVES;
    public static RegistryObject<ParticleType<?>> SILVER_BIRCH_LEAVES;
    public static RegistryObject<ParticleType<?>> ENCHANTED_BIRCH_LEAVES;

    public static void addParticles() {
        MAUVE_LEAVES = RegionsUnexploredMod.PARTICLE_REGISTRY.register("mauve_leaves", () -> new SimpleParticleType(false));
        MYCOTOXIC_SPORE = RegionsUnexploredMod.PARTICLE_REGISTRY.register("mycotoxic_spore", () -> new SimpleParticleType(false));
        ORANGE_MAPLE_LEAVES = RegionsUnexploredMod.PARTICLE_REGISTRY.register("orange_maple_leaves", () -> new SimpleParticleType(false));
        RED_MAPLE_LEAVES = RegionsUnexploredMod.PARTICLE_REGISTRY.register("red_maple_leaves", () -> new SimpleParticleType(false));
        BLUE_MAGNOLIA_LEAVES = RegionsUnexploredMod.PARTICLE_REGISTRY.register("blue_magnolia_leaves", () ->  new SimpleParticleType(false));
        PINK_MAGNOLIA_LEAVES = RegionsUnexploredMod.PARTICLE_REGISTRY.register("pink_magnolia_leaves", () ->  new SimpleParticleType(false));
        WHITE_MAGNOLIA_LEAVES = RegionsUnexploredMod.PARTICLE_REGISTRY.register("white_magnolia_leaves", () ->  new SimpleParticleType(false));
        SILVER_BIRCH_LEAVES = RegionsUnexploredMod.PARTICLE_REGISTRY.register("silver_birch_leaves", () -> new SimpleParticleType(false));
        ENCHANTED_BIRCH_LEAVES = RegionsUnexploredMod.PARTICLE_REGISTRY.register("enchanted_birch_leaves", () -> new SimpleParticleType(false));
    }
}