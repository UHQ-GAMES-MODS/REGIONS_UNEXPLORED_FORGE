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
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.regions_unexplored.data.worldgen.RuBiomeDefaultFeatures;
import net.regions_unexplored.data.worldgen.placement.RuMiscOverworldPlacements;
import net.regions_unexplored.data.worldgen.placement.RuTreePlacements;
import net.regions_unexplored.data.worldgen.placement.RuVegetationPlacements;

public class CaveBiomes {
    protected static final int NORMAL_WATER_COLOR = 4159204;
    protected static final int NORMAL_WATER_FOG_COLOR = 329011;
    private static final int OVERWORLD_FOG_COLOR = 12638463;

    protected static int calculateSkyColor(float color) {
        float $$1 = color / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static MobSpawnSettings.Builder baseCaveSpawning(boolean addDrowned) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.caveSpawns(spawnBuilder);
        BiomeDefaultFeatures.monsters(spawnBuilder, 95, 5, 100, false);
        if(addDrowned){
            spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 95, 4, 4));
        }
        return spawnBuilder;
    }
    private static MobSpawnSettings.Builder baseLushCaveSpawning() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.AXOLOTLS, new MobSpawnSettings.SpawnerData(EntityType.AXOLOTL, 10, 4, 6));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 8, 8));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        return spawnBuilder;
    }

    private static BiomeGenerationSettings.Builder baseCaveGeneration(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);
        RuBiomeDefaultFeatures.globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        RuBiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addPlainVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return biomeBuilder;
    }
    private static BiomeGenerationSettings.Builder baseLushCaveGeneration(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter, boolean addClay) {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);
        RuBiomeDefaultFeatures.globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        if(addClay){
            BiomeDefaultFeatures.addLushCavesSpecialOres(biomeBuilder);
        }
        RuBiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        return biomeBuilder;
    }

    public static Biome ancientDelta(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.7F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(-13369345)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(-10118056)
                .grassColorOverride(16318340)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_LUSH_CAVES));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseLushCaveGeneration(featureGetter, carverGetter, true);

        //add RU features
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuMiscOverworldPlacements.MINERAL_POOL);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.BLADED_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.CORPSE_FLOWER);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.DUSKMELON);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.DUSKTRAP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.DROPLEAF);

        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseLushCaveSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(1.125f)
                .downfall(0.8f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome bioshroomCaves(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(2F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(-11093361)
                .grassColorOverride(-11093410)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.SPORE_BLOSSOM_AIR, 0.01F))
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_LUSH_CAVES));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseLushCaveGeneration(featureGetter, carverGetter, false);

        //add RU features
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.GIANT_GREEN_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.GIANT_BLUE_BIOSHROOM);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.CAVE_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.CAVE_TALL_GRASS);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.BLUE_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.GREEN_BIOSHROOM);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PINK_BIOSHROOM);
        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseLushCaveSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(1.25f)
                .downfall(0.9f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome prismachasm(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.7F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(-16737793)
                .grassColorOverride(-6625354)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.FIREWORK, 0.002f))
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseCaveGeneration(featureGetter, carverGetter);

        //add RU features
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.PRISMOSS_SPROUT);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.CAVE_HYSSOP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuMiscOverworldPlacements.PRISMARITE_CLUSTERS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuMiscOverworldPlacements.HANGING_PRISMARITE_CLUSTER);


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseCaveSpawning(false);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.925f)
                .downfall(0.9f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome redstoneCaves(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.7F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(-6044317)
                .grassColorOverride(-6044317)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseCaveGeneration(featureGetter, carverGetter);

        //add RU features
        RuBiomeDefaultFeatures.pointedRedstone(biomeBuilder);


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseCaveSpawning(false);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.8f)
                .downfall(0.7f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome scorchingCaves(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.7F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(-8949914)
                .grassColorOverride(-8621472)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.1F))
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DEEP_DARK));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseCaveGeneration(featureGetter, carverGetter);

        //add RU features
        biomeBuilder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, RuMiscOverworldPlacements.OVERWORLD_LAVA_DELTA);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, RuMiscOverworldPlacements.BASALT_BLOB);
        biomeBuilder.addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, RuMiscOverworldPlacements.ASH_VENT);
        biomeBuilder.addFeature(GenerationStep.Decoration.FLUID_SPRINGS, RuMiscOverworldPlacements.LAVA_FALL);


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseCaveSpawning(false);

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(false)
                .temperature(2f)
                .downfall(0.0f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }
}
