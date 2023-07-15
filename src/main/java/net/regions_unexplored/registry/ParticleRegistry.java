package net.regions_unexplored.registry;

import net.minecraft.client.Minecraft;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.regions_unexplored.client.particle.MycotoxicSporeParticle;
import net.regions_unexplored.client.particle.RuParticleTypes;
import net.regions_unexplored.client.particle.LeafParticle;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ParticleRegistry {
    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register((SimpleParticleType) RuParticleTypes.MYCOTOXIC_SPORE.get(), MycotoxicSporeParticle::provider);

        Minecraft.getInstance().particleEngine.register(RuParticleTypes.SILVER_BIRCH_LEAVES.get(), (p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_277221_, p_277222_, p_277223_, p_277224_) -> {
                return new LeafParticle(p_277218_, p_277219_, p_277220_, p_277221_, p_277215_);
            };
        });

        Minecraft.getInstance().particleEngine.register(RuParticleTypes.ENCHANTED_BIRCH_LEAVES.get(), (p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_277221_, p_277222_, p_277223_, p_277224_) -> {
                return new LeafParticle(p_277218_, p_277219_, p_277220_, p_277221_, p_277215_);
            };
        });

        Minecraft.getInstance().particleEngine.register(RuParticleTypes.RED_MAPLE_LEAVES.get(), (p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_277221_, p_277222_, p_277223_, p_277224_) -> {
                return new LeafParticle(p_277218_, p_277219_, p_277220_, p_277221_, p_277215_);
            };
        });

        Minecraft.getInstance().particleEngine.register(RuParticleTypes.ORANGE_MAPLE_LEAVES.get(), (p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_277221_, p_277222_, p_277223_, p_277224_) -> {
                return new LeafParticle(p_277218_, p_277219_, p_277220_, p_277221_, p_277215_);
            };
        });

        Minecraft.getInstance().particleEngine.register(RuParticleTypes.MAUVE_LEAVES.get(), (p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_277221_, p_277222_, p_277223_, p_277224_) -> {
                return new LeafParticle(p_277218_, p_277219_, p_277220_, p_277221_, p_277215_);
            };
        });

        Minecraft.getInstance().particleEngine.register(RuParticleTypes.RED_SAKURA_LEAVES.get(), (p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_277221_, p_277222_, p_277223_, p_277224_) -> {
                return new LeafParticle(p_277218_, p_277219_, p_277220_, p_277221_, p_277215_);
            };
        });

        Minecraft.getInstance().particleEngine.register(RuParticleTypes.PINK_SAKURA_LEAVES.get(), (p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_277221_, p_277222_, p_277223_, p_277224_) -> {
                return new LeafParticle(p_277218_, p_277219_, p_277220_, p_277221_, p_277215_);
            };
        });

        Minecraft.getInstance().particleEngine.register(RuParticleTypes.WHITE_SAKURA_LEAVES.get(), (p_277215_) -> {
            return (p_277217_, p_277218_, p_277219_, p_277220_, p_277221_, p_277222_, p_277223_, p_277224_) -> {
                return new LeafParticle(p_277218_, p_277219_, p_277220_, p_277221_, p_277215_);
            };
        });
    }
}
