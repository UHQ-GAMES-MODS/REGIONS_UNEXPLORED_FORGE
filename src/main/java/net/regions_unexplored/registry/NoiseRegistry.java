package net.regions_unexplored.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.data.noise.RuNoises;

public class NoiseRegistry {
    public static void bootstrap(BootstapContext<NormalNoise.NoiseParameters> context) {
        RuNoises.bootstrap(context);
    }

    public static ResourceKey<NormalNoise.NoiseParameters> createKey(String name) {
        return ResourceKey.create(Registries.NOISE, new ResourceLocation(RegionsUnexploredMod.MOD_ID, name));
    }
}
