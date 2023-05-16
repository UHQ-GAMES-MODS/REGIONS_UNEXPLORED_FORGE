package net.regions_unexplored.data.worldgen.biome.builder;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.data.worldgen.RuBiomeDefaultFeatures;

public class TaigaBiomes {
    //TODO:Complete Class
    protected static final int NORMAL_WATER_COLOR = 4159204;
    protected static final int NORMAL_WATER_FOG_COLOR = 329011;
    private static final int OVERWORLD_FOG_COLOR = 12638463;

    protected static int calculateSkyColor(float color) {
        float $$1 = color / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static MobSpawnSettings.Builder baseTaigaSpawning() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 3)).addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 8, 2, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        return spawnBuilder;
    }

    private static BiomeGenerationSettings.Builder baseTaigaGeneration(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);
        RuBiomeDefaultFeatures.globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addFerns(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        //add default flowers
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeBuilder);
        return biomeBuilder;
    }

    public static Biome blackwoodTaiga(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(11454879)
                .fogColor(11454879)
                .waterColor(3108258)
                .waterFogColor(4220035)
                .foliageColorOverride(4347179)
                .grassColorOverride(4089639)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.005F))
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseTaigaGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseTaigaSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.825f)
                .downfall(0.765f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome borealTaiga(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.55F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(4157364)
                .waterFogColor(2769769)
                .foliageColorOverride(8103502)
                .grassColorOverride(8957796)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseTaigaGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseTaigaSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.5f)
                .downfall(0.4f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome goldenBorealTaiga(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.65F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(4157364)
                .waterFogColor(2769769)
                .foliageColorOverride(12562512)
                .grassColorOverride(10400607)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseTaigaGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseTaigaSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.45f)
                .downfall(0.3f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome pineTaiga(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.7F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(7702086)
                .grassColorOverride(8693594)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseTaigaGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseTaigaSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.6f)
                .downfall(0.4f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome redwoods(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.8F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(7512632)
                .grassColorOverride(8240185)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseTaigaGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseTaigaSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(1f)
                .downfall(0.8f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome sparseRedwoods(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.8F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(7512632)
                .grassColorOverride(8240185)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_OLD_GROWTH_TAIGA));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseTaigaGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseTaigaSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.95f)
                .downfall(0.8f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }
}
