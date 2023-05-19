package net.regions_unexplored.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RuBiomeTagProvider extends BiomeTagsProvider {
    public RuBiomeTagProvider(PackOutput p_255800_, CompletableFuture<HolderLookup.Provider> p_256205_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_255800_, p_256205_, modId, existingFileHelper);
    }

    public void addTags(HolderLookup.Provider provider) {
        this.tag(BiomeTags.IS_FOREST)
                .add(RuBiomes.ALPHA_GROVE);
    }
}
