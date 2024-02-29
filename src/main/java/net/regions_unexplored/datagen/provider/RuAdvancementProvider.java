package net.regions_unexplored.datagen.provider;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;
import net.regions_unexplored.item.RuItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class RuAdvancementProvider extends ForgeAdvancementProvider {

    public RuAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new AdvancementBuilder()));
    }

    private static class AdvancementBuilder implements ForgeAdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
            Advancement PARENT = Advancement.Builder.advancement()
                    .display(
                            RuBlocks.EUCALYPTUS_SAPLING.get(),
                            Component.translatable("advancements.regions_unexplored.title"),
                            Component.translatable("advancements.regions_unexplored.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.TASK,
                            true,
                            false,
                            false
                    )
                    .addCriterion("load_in_world", PlayerTrigger.TriggerInstance.located(LocationPredicate.inDimension(Level.OVERWORLD)))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "parent"), existingFileHelper);

            //SURFACE
            Advancement PIONEER = Advancement.Builder.advancement()
                    .parent(PARENT)
                    .display(
                            RuBlocks.HIBISCUS.get(),
                            Component.translatable("advancements.regions_unexplored.pioneer.title"),
                            Component.translatable("advancements.regions_unexplored.pioneer.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("alpha_grove", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ALPHA_GROVE)))
                    .addCriterion("arid_mountains", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ARID_MOUNTAINS)))
                    .addCriterion("ashen_woodland", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ASHEN_WOODLAND)))
                    .addCriterion("autumnal_maple_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.AUTUMNAL_MAPLE_FOREST)))
                    .addCriterion("bayou", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BAYOU)))
                    .addCriterion("bamboo_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BAMBOO_FOREST)))
                    .addCriterion("baobab_savanna", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BAOBAB_SAVANNA)))
                    .addCriterion("barley_fields", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BARLEY_FIELDS)))
                    .addCriterion("blackwood_taiga", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BLACKWOOD_TAIGA)))
                    .addCriterion("boreal_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BOREAL_TAIGA)))
                    .addCriterion("chalk_cliffs", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.CHALK_CLIFFS)))
                    .addCriterion("cold_boreal_taiga", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.COLD_BOREAL_TAIGA)))
                    .addCriterion("cold_deciduous_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.COLD_DECIDUOUS_FOREST)))
                    .addCriterion("cold_river", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.COLD_RIVER)))
                    .addCriterion("deciduous_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.DECIDUOUS_FOREST)))
                    .addCriterion("dry_bushland", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.DRY_BUSHLAND)))
                    .addCriterion("eucalyptus_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.EUCALYPTUS_FOREST)))
                    .addCriterion("fen", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.FEN)))
                    .addCriterion("flower_fields", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.FLOWER_FIELDS)))
                    .addCriterion("frozen_pine_taiga", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.FROZEN_PINE_TAIGA)))
                    .addCriterion("frozen_tundra", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.FROZEN_TUNDRA)))
                    .addCriterion("fungal_fen", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.FUNGAL_FEN)))
                    .addCriterion("golden_boreal_taiga", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.GOLDEN_BOREAL_TAIGA)))
                    .addCriterion("grassland", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.GRASSLAND)))
                    .addCriterion("grassy_beach", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.GRASSY_BEACH)))
                    .addCriterion("gravel_beach", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.GRAVEL_BEACH)))
                    .addCriterion("highland_fields", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.HIGHLAND_FIELDS)))
                    .addCriterion("hyacinth_deeps", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.HYACINTH_DEEPS)))
                    .addCriterion("icy_heights", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ICY_HEIGHTS)))
                    .addCriterion("joshua_desert", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.JOSHUA_DESERT)))
                    .addCriterion("lupine_plains", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.CLOVER_PLAINS)))
                    .addCriterion("magnolia_highlands", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MAGNOLIA_WOODLAND)))
                    .addCriterion("maple_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MAPLE_FOREST)))
                    .addCriterion("marsh", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MARSH)))
                    .addCriterion("mauve_hills", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MAUVE_HILLS)))
                    .addCriterion("mountains", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MOUNTAINS)))
                    .addCriterion("muddy_river", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MUDDY_RIVER)))
                    .addCriterion("old_growth_bayou", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.OLD_GROWTH_BAYOU)))
                    .addCriterion("ochard", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ORCHARD)))
                    .addCriterion("outback", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.OUTBACK)))
                    .addCriterion("pine_slopes", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.PINE_SLOPES)))
                    .addCriterion("pine_taiga", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.PINE_TAIGA)))
                    .addCriterion("poppy_fields", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.POPPY_FIELDS)))
                    .addCriterion("prairie", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.PRAIRIE)))
                    .addCriterion("pumpkin_fields", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.PUMPKIN_FIELDS)))
                    .addCriterion("rainforest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.RAINFOREST)))
                    .addCriterion("redwoods", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.REDWOODS)))
                    .addCriterion("rocky_meadow", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ROCKY_MEADOW)))
                    .addCriterion("rocky_reef", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ROCKY_REEF)))
                    .addCriterion("saguaro_desert", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.SAGUARO_DESERT)))
                    .addCriterion("shrubland", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.SHRUBLAND)))
                    .addCriterion("silver_birch_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.SILVER_BIRCH_FOREST)))
                    .addCriterion("sparse_rainforest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.SPARSE_RAINFOREST)))
                    .addCriterion("sparse_redwoods", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.SPARSE_REDWOODS)))
                    .addCriterion("spires", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.SPIRES)))
                    .addCriterion("steppe", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.STEPPE)))
                    .addCriterion("temperate_grove", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.TEMPERATE_GROVE)))
                    .addCriterion("towering_cliffs", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.TOWERING_CLIFFS)))
                    .addCriterion("tropical_river", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.TROPICAL_RIVER)))
                    .addCriterion("tropics", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.TROPICS)))
                    .addCriterion("willow_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.WILLOW_FOREST)))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "pioneer"), existingFileHelper);

            Advancement REGIONS_EXPLORED = Advancement.Builder.advancement()
                    .parent(PIONEER)
                    .display(
                            Items.LEATHER_BOOTS,
                            Component.translatable("advancements.regions_unexplored.regions_explored.title"),
                            Component.translatable("advancements.regions_unexplored.regions_explored.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.CHALLENGE,
                            true,
                            true,
                            true
                    )
                    .addCriterion("alpha_grove", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ALPHA_GROVE)))
                    .addCriterion("ancient_delta", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ANCIENT_DELTA)))
                    .addCriterion("arid_mountains", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ARID_MOUNTAINS)))
                    .addCriterion("ashen_woodland", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ASHEN_WOODLAND)))
                    .addCriterion("autumnal_maple_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.AUTUMNAL_MAPLE_FOREST)))
                    .addCriterion("bayou", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BAYOU)))
                    .addCriterion("bamboo_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BAMBOO_FOREST)))
                    .addCriterion("baobab_savanna", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BAOBAB_SAVANNA)))
                    .addCriterion("barley_fields", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BARLEY_FIELDS)))
                    .addCriterion("bioshroom_caves", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BIOSHROOM_CAVES)))
                    .addCriterion("blackstone_basin", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BLACKSTONE_BASIN)))
                    .addCriterion("blackwood_taiga", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BLACKWOOD_TAIGA)))
                    .addCriterion("boreal_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BOREAL_TAIGA)))
                    .addCriterion("chalk_cliffs", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.CHALK_CLIFFS)))
                    .addCriterion("cold_boreal_taiga", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.COLD_BOREAL_TAIGA)))
                    .addCriterion("cold_deciduous_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.COLD_DECIDUOUS_FOREST)))
                    .addCriterion("cold_river", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.COLD_RIVER)))
                    .addCriterion("deciduous_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.DECIDUOUS_FOREST)))
                    .addCriterion("dry_bushland", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.DRY_BUSHLAND)))
                    .addCriterion("eucalyptus_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.EUCALYPTUS_FOREST)))
                    .addCriterion("fen", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.FEN)))
                    .addCriterion("flower_fields", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.FLOWER_FIELDS)))
                    .addCriterion("frozen_pine_taiga", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.FROZEN_PINE_TAIGA)))
                    .addCriterion("frozen_tundra", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.FROZEN_TUNDRA)))
                    .addCriterion("fungal_fen", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.FUNGAL_FEN)))
                    .addCriterion("glistering_meadow", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.GLISTERING_MEADOW)))
                    .addCriterion("golden_boreal_taiga", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.GOLDEN_BOREAL_TAIGA)))
                    .addCriterion("grassland", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.GRASSLAND)))
                    .addCriterion("grassy_beach", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.GRASSY_BEACH)))
                    .addCriterion("gravel_beach", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.GRAVEL_BEACH)))
                    .addCriterion("highland_fields", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.HIGHLAND_FIELDS)))
                    .addCriterion("hyacinth_deeps", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.HYACINTH_DEEPS)))
                    .addCriterion("icy_heights", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ICY_HEIGHTS)))
                    .addCriterion("infernal_holt", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.INFERNAL_HOLT)))
                    .addCriterion("joshua_desert", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.JOSHUA_DESERT)))
                    .addCriterion("lupine_plains", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.CLOVER_PLAINS)))
                    .addCriterion("magnolia_highlands", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MAGNOLIA_WOODLAND)))
                    .addCriterion("maple_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MAPLE_FOREST)))
                    .addCriterion("marsh", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MARSH)))
                    .addCriterion("mauve_hills", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MAUVE_HILLS)))
                    .addCriterion("mountains", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MOUNTAINS)))
                    .addCriterion("muddy_river", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MUDDY_RIVER)))
                    .addCriterion("mycotoxic_undergrowth", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MYCOTOXIC_UNDERGROWTH)))
                    .addCriterion("old_growth_bayou", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.OLD_GROWTH_BAYOU)))
                    .addCriterion("ochard", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ORCHARD)))
                    .addCriterion("outback", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.OUTBACK)))
                    .addCriterion("pine_slopes", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.PINE_SLOPES)))
                    .addCriterion("pine_taiga", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.PINE_TAIGA)))
                    .addCriterion("poppy_fields", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.POPPY_FIELDS)))
                    .addCriterion("prairie", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.PRAIRIE)))
                    .addCriterion("prismachasm", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.PRISMACHASM)))
                    .addCriterion("pumpkin_fields", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.PUMPKIN_FIELDS)))
                    .addCriterion("rainforest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.RAINFOREST)))
                    .addCriterion("redstone_abyss", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.REDSTONE_ABYSS)))
                    .addCriterion("redstone_caves", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.REDSTONE_CAVES)))
                    .addCriterion("redwoods", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.REDWOODS)))
                    .addCriterion("rocky_meadow", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ROCKY_MEADOW)))
                    .addCriterion("rocky_reef", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ROCKY_REEF)))
                    .addCriterion("saguaro_desert", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.SAGUARO_DESERT)))
                    .addCriterion("scorching_caves", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.SCORCHING_CAVES)))
                    .addCriterion("shrubland", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.SHRUBLAND)))
                    .addCriterion("silver_birch_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.SILVER_BIRCH_FOREST)))
                    .addCriterion("sparse_rainforest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.SPARSE_RAINFOREST)))
                    .addCriterion("sparse_redwoods", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.SPARSE_REDWOODS)))
                    .addCriterion("spires", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.SPIRES)))
                    .addCriterion("steppe", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.STEPPE)))
                    .addCriterion("temperate_grove", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.TEMPERATE_GROVE)))
                    .addCriterion("towering_cliffs", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.TOWERING_CLIFFS)))
                    .addCriterion("tropical_river", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.TROPICAL_RIVER)))
                    .addCriterion("tropics", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.TROPICS)))
                    .addCriterion("willow_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.WILLOW_FOREST)))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "regions_explored"), existingFileHelper);

            Advancement EVERY_BIT_OF_THE_RAINBOW = Advancement.Builder.advancement()
                    .parent(PIONEER)
                    .display(
                            RuBlocks.WHITE_SNOWBELLE.get(),
                            Component.translatable("advancements.regions_unexplored.every_bit_of_the_rainbow.title"),
                            Component.translatable("advancements.regions_unexplored.every_bit_of_the_rainbow.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("white_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.WHITE_SNOWBELLE.get().asItem()))
                    .addCriterion("black_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.BLACK_SNOWBELLE.get().asItem()))
                    .addCriterion("blue_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.BLUE_SNOWBELLE.get().asItem()))
                    .addCriterion("green_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.GREEN_SNOWBELLE.get().asItem()))
                    .addCriterion("pink_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.PINK_SNOWBELLE.get().asItem()))
                    .addCriterion("brown_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.BROWN_SNOWBELLE.get().asItem()))
                    .addCriterion("cyan_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.CYAN_SNOWBELLE.get().asItem()))
                    .addCriterion("gray_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.GRAY_SNOWBELLE.get().asItem()))
                    .addCriterion("magenta_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.MAGENTA_SNOWBELLE.get().asItem()))
                    .addCriterion("red_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.RED_SNOWBELLE.get().asItem()))
                    .addCriterion("orange_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.ORANGE_SNOWBELLE.get().asItem()))
                    .addCriterion("yellow_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.YELLOW_SNOWBELLE.get().asItem()))
                    .addCriterion("purple_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.PURPLE_SNOWBELLE.get().asItem()))
                    .addCriterion("lime_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.LIME_SNOWBELLE.get().asItem()))
                    .addCriterion("light_gray_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.LIGHT_GRAY_SNOWBELLE.get().asItem()))
                    .addCriterion("light_blue_snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.LIGHT_BLUE_SNOWBELLE.get().asItem()))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "every_bit_of_the_rainbow"), existingFileHelper);


            Advancement FROM_THE_TREE_TOPS = Advancement.Builder.advancement()
                    .parent(PIONEER)
                    .display(
                            RuBlocks.KAPOK_VINES.get(),
                            Component.translatable("advancements.regions_unexplored.from_the_tree_tops.title"),
                            Component.translatable("advancements.regions_unexplored.from_the_tree_tops.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("kapok_vines", EnterBlockTrigger.TriggerInstance.entersBlock(RuBlocks.KAPOK_VINES_PLANT.get()))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "from_the_tree_tops"), existingFileHelper);


            Advancement LIGHT_AS_A_FROG = Advancement.Builder.advancement()
                    .parent(PIONEER)
                    .display(
                            RuBlocks.FLOWERING_LILY_PAD.get(),
                            Component.translatable("advancements.regions_unexplored.light_as_a_frog.title"),
                            Component.translatable("advancements.regions_unexplored.light_as_a_frog.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("lily_pad", EnterBlockTrigger.TriggerInstance.entersBlock(RuBlocks.GIANT_LILY_PAD.get()))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "light_as_a_frog"), existingFileHelper);

            //NETHER
            Advancement ETERNAL_EXPEDITION = Advancement.Builder.advancement()
                    .parent(PARENT)
                    .display(
                            RuBlocks.BRIMWOOD_SAPLING.get(),
                            Component.translatable("advancements.regions_unexplored.eternal_expedition.title"),
                            Component.translatable("advancements.regions_unexplored.eternal_expedition.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("blackstone_basin", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BLACKSTONE_BASIN)))
                    .addCriterion("mycotoxic_undergrowth", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MYCOTOXIC_UNDERGROWTH)))
                    .addCriterion("glistering_meadow", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.GLISTERING_MEADOW)))
                    .addCriterion("infernal_holt", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.INFERNAL_HOLT)))
                    .addCriterion("redstone_abyss", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.REDSTONE_ABYSS)))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "eternal_expedition"), existingFileHelper);

            Advancement DOWNER = Advancement.Builder.advancement()
                    .parent(ETERNAL_EXPEDITION)
                    .display(
                            RuBlocks.DORCEL.get(),
                            Component.translatable("advancements.regions_unexplored.downer.title"),
                            Component.translatable("advancements.regions_unexplored.downer.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("dorcel", EnterBlockTrigger.TriggerInstance.entersBlock(RuBlocks.DORCEL.get()))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "downer"), existingFileHelper);

            Advancement LIGHT_SNACK = Advancement.Builder.advancement()
                    .parent(ETERNAL_EXPEDITION)
                    .display(
                            RuBlocks.HANGING_EARLIGHT.get(),
                            Component.translatable("advancements.regions_unexplored.light_snack.title"),
                            Component.translatable("advancements.regions_unexplored.light_snack.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("earlight", ConsumeItemTrigger.TriggerInstance.usedItem(RuItems.HANGING_EARLIGHT_FRUIT.get()))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "light_snack"), existingFileHelper);

            //CAVE
            Advancement SPELUNKER = Advancement.Builder.advancement()
                    .parent(PARENT)
                    .display(
                            RuBlocks.DROPLEAF.get(),
                            Component.translatable("advancements.regions_unexplored.spelunker.title"),
                            Component.translatable("advancements.regions_unexplored.spelunker.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("bioshroom_caves", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BIOSHROOM_CAVES)))
                    .addCriterion("ancient_delta", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ANCIENT_DELTA)))
                    .addCriterion("prismachasm", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.PRISMACHASM)))
                    .addCriterion("redstone_caves", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.REDSTONE_CAVES)))
                    .addCriterion("scorching_caves", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.SCORCHING_CAVES)))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "spelunker"), existingFileHelper);

            Advancement BLIND_AS_A_BAT = Advancement.Builder.advancement()
                    .parent(SPELUNKER)
                    .display(
                            RuBlocks.DUSKMELON.get(),
                            Component.translatable("advancements.regions_unexplored.blind_as_a_bat.title"),
                            Component.translatable("advancements.regions_unexplored.blind_as_a_bat.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("duskmelon", ConsumeItemTrigger.TriggerInstance.usedItem(RuItems.DUSKMELON_SLICE.get()))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "blind_as_a_bat"), existingFileHelper);

            Advancement THIS_TREE_BLEEDS_RED = Advancement.Builder.advancement()
                    .parent(PARENT)
                    .display(
                            RuBlocks.SOCOTRA_LOG.get(),
                            Component.translatable("advancements.regions_unexplored.this_tree_bleeds_red.title"),
                            Component.translatable("advancements.regions_unexplored.this_tree_bleeds_red.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("socotra_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.SOCOTRA_LOG.get()))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "this_tree_bleeds_red"), existingFileHelper);

            Advancement GOT_WOOD = Advancement.Builder.advancement()
                    .parent(THIS_TREE_BLEEDS_RED)
                    .display(
                            RuBlocks.REDWOOD_LOG.get(),
                            Component.translatable("advancements.regions_unexplored.got_wood.title"),
                            Component.translatable("advancements.regions_unexplored.got_wood.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.CHALLENGE,
                            true,
                            true,
                            false
                    )
                    .addCriterion("bamboo_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.BAMBOO_LOG.get().asItem()))
                    .addCriterion("small_oak_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.SMALL_OAK_LOG.get().asItem()))
                    .addCriterion("ashen_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.ASHEN_LOG.get().asItem()))
                    .addCriterion("silver_birch_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.SILVER_BIRCH_LOG.get().asItem()))
                    .addCriterion("alpha_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.ALPHA_LOG.get().asItem()))
                    .addCriterion("baobab_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.BAOBAB_LOG.get().asItem()))
                    .addCriterion("blackwood_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.BLACKWOOD_LOG.get().asItem()))
                    .addCriterion("brimwood_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.BRIMWOOD_LOG.get().asItem()))
                    .addCriterion("cobalt_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.COBALT_LOG.get().asItem()))
                    .addCriterion("cypress_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.CYPRESS_LOG.get().asItem()))
                    .addCriterion("dead_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.DEAD_LOG.get().asItem()))
                    .addCriterion("eucalyptus_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.EUCALYPTUS_LOG.get().asItem()))
                    .addCriterion("joshua_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.JOSHUA_LOG.get().asItem()))
                    .addCriterion("kapok_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.KAPOK_LOG.get().asItem()))
                    .addCriterion("larch_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.LARCH_LOG.get().asItem()))
                    .addCriterion("magnolia_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.MAGNOLIA_LOG.get().asItem()))
                    .addCriterion("maple_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.MAPLE_LOG.get().asItem()))
                    .addCriterion("mauve_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.MAUVE_LOG.get().asItem()))
                    .addCriterion("palm_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.PALM_LOG.get().asItem()))
                    .addCriterion("pine_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.PINE_LOG.get().asItem()))
                    .addCriterion("redwood_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.REDWOOD_LOG.get().asItem()))
                    .addCriterion("socotra_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.SOCOTRA_LOG.get().asItem()))
                    .addCriterion("willow_log", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.WILLOW_LOG.get().asItem()))
                    .addCriterion("blue_bioshroom_stem", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.BLUE_BIOSHROOM_STEM.get().asItem()))
                    .addCriterion("green_bioshroom_stem", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.GREEN_BIOSHROOM_STEM.get().asItem()))
                    .addCriterion("pink_bioshroom_stem", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.PINK_BIOSHROOM_STEM.get().asItem()))
                    .addCriterion("yellow_bioshroom_stem", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.YELLOW_BIOSHROOM_STEM.get().asItem()))

                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "got_wood"), existingFileHelper);

            Advancement MYCOLOGIST = Advancement.Builder.advancement()
                    .parent(PARENT)
                    .display(
                            RuBlocks.BLUE_BIOSHROOM.get(),
                            Component.translatable("advancements.regions_unexplored.mycologist.title"),
                            Component.translatable("advancements.regions_unexplored.mycologist.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("blue_bioshroom", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.BLUE_BIOSHROOM.get().asItem()))
                    .addCriterion("pink_bioshroom", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.PINK_BIOSHROOM.get().asItem()))
                    .addCriterion("yellow_bioshroom", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.YELLOW_BIOSHROOM.get().asItem()))
                    .addCriterion("green_bioshroom", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.GREEN_BIOSHROOM.get().asItem()))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "mycologist"), existingFileHelper);

            Advancement ANCIENT_SPECIMENS = Advancement.Builder.advancement()
                    .parent(MYCOLOGIST)
                    .display(
                            RuBlocks.BLUE_BIOSHROOM_STEM.get(),
                            Component.translatable("advancements.regions_unexplored.ancient_specimens.title"),
                            Component.translatable("advancements.regions_unexplored.ancient_specimens.description"),
                            new ResourceLocation("regions_unexplored:textures/gui/advancements/backgrounds/argillite.png"),
                            FrameType.CHALLENGE,
                            true,
                            true,
                            false
                    )
                    .addCriterion("blue_bioshroom_stem", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.BLUE_BIOSHROOM_STEM.get().asItem()))
                    .addCriterion("pink_bioshroom_stem", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.PINK_BIOSHROOM_STEM.get().asItem()))
                    .addCriterion("yellow_bioshroom_stem", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.YELLOW_BIOSHROOM_STEM.get().asItem()))
                    .addCriterion("green_bioshroom_stem", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.GREEN_BIOSHROOM_STEM.get().asItem()))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "ancient_specimens"), existingFileHelper);
        }
    }
}
