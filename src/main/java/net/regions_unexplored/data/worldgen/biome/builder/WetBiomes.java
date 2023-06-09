package net.regions_unexplored.data.worldgen.biome.builder;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
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

public class WetBiomes {
    //TODO:Complete Class
    protected static final int NORMAL_WATER_COLOR = 4159204;
    protected static final int NORMAL_WATER_FOG_COLOR = 329011;
    private static final int OVERWORLD_FOG_COLOR = 12638463;

    protected static int calculateSkyColor(float color) {
        float $$1 = color / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static MobSpawnSettings.Builder baseSwampSpawning() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.SLIME, 1, 1, 1));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 10, 2, 5));
        spawnBuilder.addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 25, 8, 8));
        return spawnBuilder;
    }
    private static MobSpawnSettings.Builder baseJungleSpawning() {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CHICKEN, 10, 4, 4));
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 40, 1, 2));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 2, 1, 1));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        return spawnBuilder;
    }

    private static BiomeGenerationSettings.Builder baseSwampGeneration(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter, boolean hasLilyPads) {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        RuBiomeDefaultFeatures.globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addSwampClayDisk(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_SWAMP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
        if(hasLilyPads) {
            biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY);
        }
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.BROWN_MUSHROOM_SWAMP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.RED_MUSHROOM_SWAMP);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addSwampExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP);
        return biomeBuilder;
    }
    private static BiomeGenerationSettings.Builder baseJungleGeneration(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(featureGetter, carverGetter);
        RuBiomeDefaultFeatures.globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        //add default flowers
        BiomeDefaultFeatures.addJungleGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addJungleVines(biomeBuilder);
        BiomeDefaultFeatures.addJungleMelons(biomeBuilder);
        return biomeBuilder;
    }

    public static Biome bayou(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(-6110795)
                .fogColor(-5124939)
                .waterColor(-12354486)
                .waterFogColor(-10450614)
                .foliageColorOverride(-9333940)
                .grassColorOverride(-8609196)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.01F))
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseSwampGeneration(featureGetter, carverGetter, false);

        //add RU features
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.CYPRESS_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.WILLOW_TREE_VINES);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.OAK_BUSH_SPARSE);
        RuBiomeDefaultFeatures.addBayouVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.ELEPHANT_EAR_SPARSE);


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseSwampSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(1f)
                .downfall(1f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome eucalyptusForest(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.7F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(NORMAL_WATER_COLOR)
                .waterFogColor(NORMAL_WATER_FOG_COLOR)
                .foliageColorOverride(-9651647)
                .grassColorOverride(-9651647)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseJungleGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseJungleSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(1.3F)
                .downfall(0.85f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome fen(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.4F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(-11629645)
                .waterFogColor(-12884349)
                .foliageColorOverride(8754506)
                .grassColorOverride(10858333)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseSwampGeneration(featureGetter, carverGetter, true);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseSwampSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.85f)
                .downfall(0.7f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome floodedPlains(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(0.9F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(-12092489)
                .waterFogColor(-13677218)
                .foliageColorOverride(-8339092)
                .grassColorOverride(-8536223)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseSwampGeneration(featureGetter, carverGetter, true);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseSwampSpawning();
        spawnBuilder.addSpawn(MobCategory.AXOLOTLS, new MobSpawnSettings.SpawnerData(EntityType.AXOLOTL, 5, 2, 6));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(1f)
                .downfall(1f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome fungalFen(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(2.0F))
                .fogColor(12638463)
                .waterColor(-435307641)
                .waterFogColor(-435242116)
                .foliageColorOverride(-433341681)
                .grassColorOverride(-430585537)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WARPED_SPORE, 0.01F))
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseSwampGeneration(featureGetter, carverGetter, true);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseSwampSpawning();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.MOOSHROOM, 8, 4, 8));
        spawnBuilder.addSpawn(MobCategory.AXOLOTLS, new MobSpawnSettings.SpawnerData(EntityType.AXOLOTL, 4, 2, 4));

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(1.15f)
                .downfall(1f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome oldGrowthBayou(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(-1350062718)
                .fogColor(-1350062718)
                .waterColor(-12354486)
                .waterFogColor(-10450614)
                .foliageColorOverride(-9333940)
                .grassColorOverride(-8609196)
                .ambientParticle(new AmbientParticleSettings(ParticleTypes.WHITE_ASH, 0.01F))
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseSwampGeneration(featureGetter, carverGetter, false);

        //add RU features
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.GIANT_CYPRESS_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.GIANT_CYPRESS_TREE_DEEP);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuTreePlacements.OAK_BUSH_SPARSE);
        RuBiomeDefaultFeatures.addBayouVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.ELEPHANT_EAR_DENSE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, RuVegetationPlacements.GIANT_LILY);


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseSwampSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(1.2f)
                .downfall(1f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome oldGrowthRainforest(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(1.5F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(-13392941)
                .waterFogColor(-11558718)
                .foliageColorOverride(-11032271)
                .grassColorOverride(-9718455)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseJungleGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseJungleSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(1f)
                .downfall(0.95f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }

    public static Biome rainforest(HolderGetter<PlacedFeature> featureGetter, HolderGetter<ConfiguredWorldCarver<?>> carverGetter) {
        //TODO:Complete Biome
        BiomeSpecialEffects.Builder effectBuilder = (new BiomeSpecialEffects.Builder())
                .skyColor(calculateSkyColor(1F))
                .fogColor(OVERWORLD_FOG_COLOR)
                .waterColor(-13392941)
                .waterFogColor(-11558718)
                .foliageColorOverride(-11032271)
                .grassColorOverride(-9718455)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE));

        //add features
        BiomeGenerationSettings.Builder biomeBuilder = baseJungleGeneration(featureGetter, carverGetter);

        //add RU features


        //add mob spawns
        MobSpawnSettings.Builder spawnBuilder = baseJungleSpawning();

        return (new Biome.BiomeBuilder())
                .hasPrecipitation(true)
                .temperature(0.95f)
                .downfall(0.9f)
                .specialEffects(effectBuilder.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }
}
