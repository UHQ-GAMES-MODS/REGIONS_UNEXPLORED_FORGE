package net.regions_unexplored.data.worldgen.biome.builder;

import net.minecraft.core.HolderGetter;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.data.worldgen.RuBiomeDefaultFeatures;
import net.regions_unexplored.data.worldgen.placement.RuTreePlacements;
import net.regions_unexplored.data.worldgen.placement.RuVegetationPlacements;

public class ForestBiomes {
    //TODO:Complete Class
    protected static final int NORMAL_WATER_COLOR = 4159204;
    protected static final int NORMAL_WATER_FOG_COLOR = 329011;
    private static final int OVERWORLD_FOG_COLOR = 12638463;

    protected static int calculateSkyColor(float color) {
        float $$1 = color / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static MobSpawnSettings.Builder baseForestSpawning() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        return spawnBuilder;
    }

    private static BiomeGenerationSettings.Builder baseForestGeneration(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);
        RuBiomeDefaultFeatures.globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        //add default flowers
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return biomeBuilder;
    }

    public static Biome alphaGrove(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete SurfaceBuilder
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.7F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(1857757)
                .waterFogColor(4485074)
                .foliageColorOverride(6028091)
                .grassColorOverride(8901207)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);
        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

        //add RU features
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.ALPHA_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.ALPHA_DANDELION);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.ALPHA_ROSE);

        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseForestSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.0f)
                .downfall(0.6f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome autumnalMapleForest(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.5F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(9877306)
                .grassColorOverride(12896058)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseForestGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseForestSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.25f)
                .downfall(0.35f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome bambooForest(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(-6110795)
                .fogColor(-5124939)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(-5636253)
                .grassColorOverride(-4923788)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseForestGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseForestSpawning();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PANDA, 80, 1, 2));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.875f)
                .downfall(0.8f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome darkSakuraGrove(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.75F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(8437033)
                .grassColorOverride(10406459)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseForestGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseForestSpawning();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.95f)
                .downfall(0.8f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome deciduousForest(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.7F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(7578936)
                .grassColorOverride(8700997)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseForestGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseForestSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.75f)
                .downfall(0.8f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome mapleForest(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.6F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(6462505)
                .grassColorOverride(9550928)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseForestGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseForestSpawning();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.6f)
                .downfall(0.5f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome mauveHills(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(1.0F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(-11230855)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(-12810288)
                .grassColorOverride(-9259116)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseForestGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseForestSpawning();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(1.1f)
                .downfall(0.85f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome orchard(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.7F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(-6108056)
                .grassColorOverride(-5059481)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseForestGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseForestSpawning();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 8, 4, 4));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.7f)
                .downfall(0.4f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome silverBirchForest(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.5F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(11585338)
                .grassColorOverride(8960834)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseForestGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseForestSpawning();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.5f)
                .downfall(0.6f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome temperateGrove(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.8F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(7054415)
                .grassColorOverride(8432236)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseForestGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseForestSpawning();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 5, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 15, 3, 4));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.725f)
                .downfall(0.6f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome willowForest(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.7F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(-8999072)
                .grassColorOverride(-8739993)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE_AND_FOREST));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseForestGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseForestSpawning();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 10, 3, 4));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.6f)
                .downfall(0.5f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }
}
