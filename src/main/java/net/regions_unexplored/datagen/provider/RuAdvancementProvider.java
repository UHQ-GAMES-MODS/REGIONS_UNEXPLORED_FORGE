package net.regions_unexplored.datagen.provider;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.LocationPredicate;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.common.data.ForgeAdvancementProvider;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class RuAdvancementProvider extends ForgeAdvancementProvider {

    /**
     * Constructs an advancement provider using the generators to write the
     * advancements to a file.
     *
     * @param output             the target directory of the data generator
     * @param registries         a future of a lookup for registries and their objects
     * @param existingFileHelper a helper used to find whether a file exists
     */
    public RuAdvancementProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, ExistingFileHelper existingFileHelper) {
        super(output, registries, existingFileHelper, List.of(new AdvancementBuilder()));
    }

    private static class AdvancementBuilder implements ForgeAdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<Advancement> saver, ExistingFileHelper existingFileHelper) {
            Advancement parent = Advancement.Builder.advancement()
                    .display(
                            RuBlocks.EUCALYPTUS_SAPLING.get(),
                            Component.literal("Regions Unexplored"),
                            Component.literal("Discover the many biomes and explore the world!"),
                            new ResourceLocation("textures/gui/advancements/backgrounds/adventure.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("load_in_world", PlayerTrigger.TriggerInstance.located(LocationPredicate.inDimension(Level.OVERWORLD)))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "parent"), existingFileHelper);

            Advancement exploring_the_world = Advancement.Builder.advancement()
                    .parent(parent)
                    .display(
                            RuBlocks.HIBISCUS.get(),
                            Component.literal("Pioneer"),
                            Component.literal("Explore all Surface biomes from Regions Unexplored!"),
                            new ResourceLocation("textures/gui/advancements/backgrounds/adventure.png"),
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
                    .addCriterion("lupine_plains", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.LUPINE_PLAINS)))
                    .addCriterion("magnolia_highlands", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MAGNOLIA_HIGHLANDS)))
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
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "exploring_the_world"), existingFileHelper);

            Advancement regions_explored = Advancement.Builder.advancement()
                    .parent(exploring_the_world)
                    .display(
                            Items.LEATHER_BOOTS,
                            Component.literal("Regions Explored"),
                            Component.literal("You've explored all the biomes from Regions Unexplored"),
                            new ResourceLocation("textures/gui/advancements/backgrounds/adventure.png"),
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
                    .addCriterion("lupine_plains", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.LUPINE_PLAINS)))
                    .addCriterion("magnolia_highlands", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.MAGNOLIA_HIGHLANDS)))
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

            Advancement nethery_explorer = Advancement.Builder.advancement()
                    .parent(parent)
                    .display(
                            RuBlocks.BRIMWOOD_SAPLING.get(),
                            Component.literal("Eternal Expedition"),
                            Component.literal("Venture into all Nether biomes from Regions Unexplored!"),
                            new ResourceLocation("textures/gui/advancements/backgrounds/adventure.png"),
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
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "nethery_explorer"), existingFileHelper);

            Advancement deep_cave_explorer = Advancement.Builder.advancement()
                    .parent(parent)
                    .display(
                            RuBlocks.DROPLEAF.get(),
                            Component.literal("Spelunker"),
                            Component.literal("Find all Cave biomes from Regions Unexplored!"),
                            new ResourceLocation("textures/gui/advancements/backgrounds/adventure.png"),
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
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "deep_cave_explorer"), existingFileHelper);

            Advancement gotWood = Advancement.Builder.advancement()
                    .parent(parent)
                    .display(
                            RuBlocks.REDWOOD_LOG.get(),
                            Component.literal("Got Wood?"),
                            Component.literal("Collect every log from Regions Unexplored"),
                            new ResourceLocation("textures/gui/advancements/backgrounds/adventure.png"),
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

            Advancement mycologist = Advancement.Builder.advancement()
                    .parent(parent)
                    .display(
                            RuBlocks.BLUE_BIOSHROOM.get(),
                            Component.literal("Mycologist"),
                            Component.literal("Collect every Bioshroom type."),
                            new ResourceLocation("textures/gui/advancements/backgrounds/adventure.png"),
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

            Advancement every_bit_of_the_rainbow = Advancement.Builder.advancement()
                    .parent(parent)
                    .display(
                            RuBlocks.WHITE_SNOWBELLE.get(),
                            Component.literal("Every Bit of the Rainbow"),
                            Component.literal("Collect or craft every colour of the Snowbelle Flower."),
                            new ResourceLocation("textures/gui/advancements/backgrounds/adventure.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("snowbelle", InventoryChangeTrigger.TriggerInstance.hasItems(RuBlocks.WHITE_SNOWBELLE.get().asItem()))
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
        }
    }
}
