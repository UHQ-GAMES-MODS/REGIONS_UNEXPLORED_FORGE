package net.regions_unexplored.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.datagen.provider.RuAdvancementProvider;
import net.regions_unexplored.datagen.provider.RuBiomeTagProvider;
import net.regions_unexplored.datagen.provider.RuBlockModelProvider;
import net.regions_unexplored.datagen.provider.RuRecipeProvider;

@Mod.EventBusSubscriber( modid = RegionsUnexploredMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGeneration {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(true, new RuAdvancementProvider(generator));
        generator.addProvider(true, new RuRecipeProvider(generator));
        generator.addProvider(true, new RuLootTableProvider(generator));
        generator.addProvider(true, new RuBlockModelProvider(generator, existingFileHelper));
        generator.addProvider(true, new RuBiomeTagProvider(generator));
    }
}
