package net.regions_unexplored.registry;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.regions_unexplored.client.particle.MauveParticle;
import net.regions_unexplored.client.particle.MycotoxicSporeParticle;
import net.regions_unexplored.client.particle.RegionsUnexploredParticleTypes;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ParticleRegistry {
    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        //TODO:Complete Class
        Minecraft.getInstance().particleEngine.register((SimpleParticleType) RegionsUnexploredParticleTypes.MAUVE.get(), MauveParticle::provider);
        Minecraft.getInstance().particleEngine.register((SimpleParticleType) RegionsUnexploredParticleTypes.MYCOTOXIC_SPORE.get(), MycotoxicSporeParticle::provider);
    }
}
