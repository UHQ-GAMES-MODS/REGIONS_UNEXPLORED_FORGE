package net.regions_unexplored.data.noise;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;

public class RuNoises {
    public static RegistryObject<NormalNoise.NoiseParameters> WEIGHTED;
    public static RegistryObject<NormalNoise.NoiseParameters> SHIELD;

    public static void addNoises() {
        WEIGHTED = RegionsUnexploredMod.NOISE_REGISTRY.register("weighted", () -> new NormalNoise.NoiseParameters(0, 1.0D));
        SHIELD = RegionsUnexploredMod.NOISE_REGISTRY.register("shield", () -> new NormalNoise.NoiseParameters(-5, 1.0D, 1.0D, 1.0D));
    }
}