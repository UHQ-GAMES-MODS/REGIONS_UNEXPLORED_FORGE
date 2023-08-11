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

            Advancement regions_explored = Advancement.Builder.advancement()
                    .parent(parent)
                    .display(
                            RuBlocks.EUCALYPTUS_SAPLING.get(),
                            Component.literal("Regions Explored"),
                            Component.literal("You've explored all the biomes from Regions Unexplored"),
                            new ResourceLocation("textures/gui/advancements/backgrounds/adventure.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    .addCriterion("alpha_grove", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ALPHA_GROVE)))
                    .addCriterion("ancient_delta", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ANCIENT_DELTA)))
                    .addCriterion("arid_mountains", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ARID_MOUNTAINS)))
                    .addCriterion("ashen_woodland", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.ASHEN_WOODLAND)))
                    .addCriterion("autumnal_maple_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.AUTUMNAL_MAPLE_FOREST)))
                    .addCriterion("bayou", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BAYOU)))
                    .addCriterion("bamboo_forest", PlayerTrigger.TriggerInstance.located(LocationPredicate.inBiome(RuBiomes.BAMBOO_FOREST)))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "regions_explored"), existingFileHelper);

            Advancement gotWood = Advancement.Builder.advancement()
                    .parent(parent)
                    .display(
                            RuBlocks.REDWOOD_LOG.get(),
                            Component.literal("Got Wood?"),
                            Component.literal("Collect every log from Regions Unexplored"),
                            new ResourceLocation("textures/gui/advancements/backgrounds/adventure.png"),
                            FrameType.TASK,
                            true,
                            true,
                            false
                    )
                    // TODO: Fix all of these entries to have their own criterion to track progress.
                    .addCriterion("getting_wood", InventoryChangeTrigger.TriggerInstance.hasItems(
                            RuBlocks.BAMBOO_LOG.get().asItem(),
                            RuBlocks.SMALL_OAK_LOG.get().asItem(),
                            RuBlocks.ASHEN_LOG.get().asItem(),
                            RuBlocks.SILVER_BIRCH_LOG.get().asItem(),
                            RuBlocks.ALPHA_LOG.get().asItem(),
                            RuBlocks.BAOBAB_LOG.get().asItem(),
                            RuBlocks.BLACKWOOD_LOG.get().asItem(),
                            RuBlocks.BRIMWOOD_LOG.get().asItem(),
                            RuBlocks.COBALT_LOG.get().asItem(),
                            RuBlocks.CYPRESS_LOG.get().asItem(),
                            RuBlocks.DEAD_LOG.get().asItem(),
                            RuBlocks.EUCALYPTUS_LOG.get().asItem(),
                            RuBlocks.JOSHUA_LOG.get().asItem(),
                            RuBlocks.KAPOK_LOG.get().asItem(),
                            RuBlocks.LARCH_LOG.get().asItem(),
                            RuBlocks.MAGNOLIA_LOG.get().asItem(),
                            RuBlocks.MAPLE_LOG.get().asItem(),
                            RuBlocks.MAUVE_LOG.get().asItem(),
                            RuBlocks.PALM_LOG.get().asItem(),
                            RuBlocks.PINE_LOG.get().asItem(),
                            RuBlocks.REDWOOD_LOG.get().asItem(),
                            RuBlocks.SOCOTRA_LOG.get().asItem(),
                            RuBlocks.WILLOW_LOG.get().asItem(),
                            RuBlocks.BLUE_BIOSHROOM_STEM.get().asItem(),
                            RuBlocks.GREEN_BIOSHROOM_STEM.get().asItem(),
                            RuBlocks.PINK_BIOSHROOM_STEM.get().asItem(),
                            RuBlocks.YELLOW_BIOSHROOM_STEM.get().asItem()
                    ))
                    .save(saver, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "got_wood"), existingFileHelper);
        }
    }
}
