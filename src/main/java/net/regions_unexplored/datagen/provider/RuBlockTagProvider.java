package net.regions_unexplored.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.regions_unexplored.block.RuBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RuBlockTagProvider extends BlockTagsProvider {

    public RuBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    //TODO:set up tags
    @Override
    public void addTags(HolderLookup.Provider provider) {
        this.tag(BlockTags.DIRT)
                .add(RuBlocks.FOREST_GRASS_BLOCK.getKey())
                .add(RuBlocks.FOREST_DIRT.getKey())
                .add(RuBlocks.FOREST_COARSE_DIRT.getKey())
                .add(RuBlocks.FOREST_DIRT_PATH.getKey())
                .add(RuBlocks.FOREST_FARMLAND.getKey())
                .add(RuBlocks.FOREST_MUD.getKey())
                .add(RuBlocks.PLAINS_GRASS_BLOCK.getKey())
                .add(RuBlocks.PLAINS_DIRT.getKey())
                .add(RuBlocks.PLAINS_COARSE_DIRT.getKey())
                .add(RuBlocks.PLAINS_DIRT_PATH.getKey())
                .add(RuBlocks.PLAINS_FARMLAND.getKey())
                .add(RuBlocks.PLAINS_MUD.getKey())
                .add(RuBlocks.ALPHA_GRASS_BLOCK.getKey())
                .add(RuBlocks.ASHEN_DIRT.getKey())
                .add(RuBlocks.CHALK_GRASS_BLOCK.getKey())
                .add(RuBlocks.STONE_GRASS_BLOCK.getKey())
                .add(RuBlocks.DEEPSLATE_GRASS_BLOCK.getKey())
                .add(RuBlocks.VIRIDESCENT_NYLIUM.getKey())
                .add(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.getKey())
                .add(RuBlocks.PRISMOSS.getKey())
                .add(RuBlocks.DEEPSLATE_PRISMOSS.getKey());
    }
}
