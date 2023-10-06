package net.regions_unexplored.data.noise;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class RuNoises {
    public static final DeferredRegister<NormalNoise.NoiseParameters> NOISE_PARAMETERS = DeferredRegister.create(Registry.NOISE_REGISTRY, "regions_unexplored");
    public static final RegistryObject<NormalNoise.NoiseParameters> WEIGHTED = NOISE_PARAMETERS.register("weighted", () -> new NormalNoise.NoiseParameters(0, 1.0D));
    public static final RegistryObject<NormalNoise.NoiseParameters> SHIELD = NOISE_PARAMETERS.register("shield", () -> new NormalNoise.NoiseParameters(-5, 1.0D, 1.0D, 1.0D));

    public static void register(IEventBus bus) {
        NOISE_PARAMETERS.register(bus);
    }
}