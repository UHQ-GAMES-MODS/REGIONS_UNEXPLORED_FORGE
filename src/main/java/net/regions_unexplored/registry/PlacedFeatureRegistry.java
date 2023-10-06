package net.regions_unexplored.registry;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.block.RuBlocks;

import java.util.List;

public class PlacedFeatureRegistry {

    public static Holder<PlacedFeature> register(String key, Holder<? extends ConfiguredFeature<?, ?>> feature, PlacementModifier... placements) {
        return register(key, feature, List.of(placements));
    }

    public static Holder<PlacedFeature> register(String key, Holder<? extends ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placements) {
        return BuiltinRegistries.register(BuiltinRegistries.PLACED_FEATURE, RegionsUnexploredMod.MOD_ID+":"+key, new PlacedFeature(Holder.hackyErase(feature), List.copyOf(placements)));
    }

    public static BlockPredicate onDirtPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.PODZOL, Blocks.COARSE_DIRT, Blocks.DIRT, RuBlocks.PEAT_DIRT.get(), RuBlocks.SILT_DIRT.get(), RuBlocks.PEAT_COARSE_DIRT.get(), RuBlocks.SILT_COARSE_DIRT.get(), RuBlocks.PEAT_PODZOL.get(), RuBlocks.SILT_PODZOL.get());
    public static BlockPredicate onGrassBlockPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK, RuBlocks.PEAT_GRASS_BLOCK.get(), RuBlocks.SILT_GRASS_BLOCK.get(), RuBlocks.STONE_GRASS_BLOCK.get(), RuBlocks.DEEPSLATE_GRASS_BLOCK.get());
    public static BlockPredicate onViridescentNyliumPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), RuBlocks.VIRIDESCENT_NYLIUM.get(), RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get());
    public static BlockPredicate onSnowPredicate = BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.SNOW_BLOCK, Blocks.GRASS_BLOCK, RuBlocks.PEAT_GRASS_BLOCK.get(), RuBlocks.SILT_GRASS_BLOCK.get());
}
