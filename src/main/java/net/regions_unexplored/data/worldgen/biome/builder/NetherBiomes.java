package net.regions_unexplored.data.worldgen.biome.builder;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Carvers;
import net.minecraft.data.worldgen.placement.NetherPlacements;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.client.particle.RuParticleTypes;
import net.regions_unexplored.data.worldgen.RuBiomeDefaultFeatures;
import net.regions_unexplored.data.worldgen.placement.RuNetherPlacements;
import net.regions_unexplored.data.worldgen.placement.RuTreePlacements;

public class NetherBiomes {

    public static Biome blackstoneBasin(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(395547)
                .fogColor(395547)
                .waterColor(5463027)
                .waterFogColor(395547)
                .foliageColorOverride(5463027)
                .grassColorOverride(5463027)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.02F))
                .ambientLoopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
                .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D))
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_CRIMSON_FOREST));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_OPEN);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.BLACKSTONE_BLOBS);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_FIRE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.RED_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_CLOSED);
        BiomeDefaultFeatures.addNetherDefaultOres(biomeBuilder);

        //add RU features
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.OBSIDIAN_SPIRE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuTreePlacements.COBALT_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.COBALT_ROOTS);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.COBALT_EARLIGHT);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.TALL_COBALT_EARLIGHT);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.BLACKSTONE_CLUSTER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.HANGING_EARLIGHT);


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder())
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 25, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITHER_SKELETON, 20, 1, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 1, 2))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(false)
                .temperature(2f)
                .downfall(0f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome infernalHolt(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(3479565)
                .fogColor(3479565)
                .waterColor(3479565)
                .waterFogColor(3479565)
                .foliageColorOverride(7295817)
                .grassColorOverride(7295817)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.03F))
                .ambientLoopSound(SoundEvents.AMBIENT_BASALT_DELTAS_LOOP)
                .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_SOUL_SAND_VALLEY_ADDITIONS, 0.0111D))
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_BASALT_DELTAS));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_OPEN);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.BLACKSTONE_BLOBS);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_FIRE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.RED_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_CLOSED);
        BiomeDefaultFeatures.addNetherDefaultOres(biomeBuilder);

        //add RU features
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuTreePlacements.BRIM_WILLOW_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuTreePlacements.TALL_BRIM_WILLOW_TREE);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.BRIMSPROUT);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.DORCEL);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.BRIM_FLAMES);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.BRIMWOOD_SHRUB);


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder())
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 1, 2, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HOGLIN, 9, 3, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 5, 3, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(false)
                .temperature(2f)
                .downfall(0f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome glisteringMeadow(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(4328552)
                .fogColor(4328552)
                .waterColor(12058781)
                .waterFogColor(12058781)
                .foliageColorOverride(12058781)
                .grassColorOverride(12058781)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.02F))
                .ambientLoopSound(SoundEvents.AMBIENT_CRIMSON_FOREST_LOOP)
                .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_CRIMSON_FOREST_ADDITIONS, 0.0111D))
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_WARPED_FOREST));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_OPEN);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_FIRE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.RED_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_CLOSED);
        BiomeDefaultFeatures.addNetherDefaultOres(biomeBuilder);

        //add RU features
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.GLISTERING_MEADOW_ROCK);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.GLISTER_BULB);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.GLISTERING_SPROUT);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.GLISTERING_FERN);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.GLISTERING_BLOOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.GLISTER_SPIRE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.GLISTERING_IVY);


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder())
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.GHAST, 5, 1, 1))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ENDERMAN, 1, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 40, 1, 2))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.HOGLIN, 5, 1, 3));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(false)
                .temperature(2f)
                .downfall(0f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome mycotoxicUndergrowth(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(10717988)
                .fogColor(10717988)
                .waterColor(10717988)
                .waterFogColor(10717988)
                .foliageColorOverride(10717988)
                .grassColorOverride(10717988)
                .ambientParticle(new AmbientParticleSettings((SimpleParticleType) (RuParticleTypes.MYCOTOXIC_SPORE.get()), 0.01f))
                .ambientLoopSound(SoundEvents.AMBIENT_WARPED_FOREST_LOOP)
                .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_WARPED_FOREST_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_WARPED_FOREST_ADDITIONS, 0.0111D))
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_WARPED_FOREST));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);
        biomeBuilder.addCarver(GenerationStep.Carving.AIR, Carvers.NETHER_CAVE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_OPEN);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_FIRE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE_EXTRA);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_CLOSED);
        BiomeDefaultFeatures.addNetherDefaultOres(biomeBuilder);

        //add RU features
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuTreePlacements.GIANT_YELLOW_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.SMALL_YELLOW_BIOSHROOM);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.MYCOTOXIC_MUSHROOMS);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.MYCOTOXIC_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.MYCOTOXIC_DAISY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, RuNetherPlacements.MYCOTOXIC_BIOSHROOM);


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder())
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.PIGLIN, 5, 3, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(false)
                .temperature(2f)
                .downfall(0f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome redstoneAbyss(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(5439488)
                .fogColor(5439488)
                .waterColor(10623252)
                .waterFogColor(10623252)
                .foliageColorOverride(10623252)
                .grassColorOverride(10623252)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.CRIMSON_SPORE, 0.025F))
                .ambientLoopSound(SoundEvents.AMBIENT_NETHER_WASTES_LOOP)
                .ambientMoodSound(new AmbientMoodSettings(SoundEvents.AMBIENT_NETHER_WASTES_MOOD, 6000, 8, 2.0D))
                .ambientAdditionsSound(new AmbientAdditionsSettings(SoundEvents.AMBIENT_NETHER_WASTES_ADDITIONS, 0.0111D))
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_NETHER_WASTES));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_OPEN);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.PATCH_FIRE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.GLOWSTONE);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.BROWN_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, VegetationPlacements.RED_MUSHROOM_NETHER);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, OrePlacements.ORE_MAGMA);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, NetherPlacements.SPRING_CLOSED);
        BiomeDefaultFeatures.addNetherDefaultOres(biomeBuilder);

        //add RU features
        RuBiomeDefaultFeatures.netherPointedRedstone(biomeBuilder);


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = (new MobSpawnSettings.Builder())
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.ZOMBIFIED_PIGLIN, 100, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.STRIDER, 60, 1, 2));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(false)
                .temperature(2f)
                .downfall(0f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }
}
