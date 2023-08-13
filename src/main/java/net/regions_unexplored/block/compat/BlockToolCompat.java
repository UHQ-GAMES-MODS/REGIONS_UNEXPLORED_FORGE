package net.regions_unexplored.block.compat;

import com.google.common.collect.Maps;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.regions_unexplored.block.RuBlocks;

public class BlockToolCompat {

    public static void setup() {
        //StripBlocks

        registerStrippableBlock(RuBlocks.ASHEN_LOG.get(), RuBlocks.STRIPPED_DEAD_LOG.get());
        registerStrippableBlock(RuBlocks.ASHEN_WOOD.get(), RuBlocks.STRIPPED_DEAD_WOOD.get());

        registerStrippableBlock(RuBlocks.SILVER_BIRCH_LOG.get(), Blocks.STRIPPED_BIRCH_LOG);
        registerStrippableBlock(RuBlocks.SILVER_BIRCH_WOOD.get(), Blocks.STRIPPED_BIRCH_WOOD);

        registerStrippableBlock(RuBlocks.BAOBAB_LOG.get(), RuBlocks.STRIPPED_BAOBAB_LOG.get());
        registerStrippableBlock(RuBlocks.BAOBAB_WOOD.get(), RuBlocks.STRIPPED_BAOBAB_WOOD.get());
        
        registerStrippableBlock(RuBlocks.BLACKWOOD_LOG.get(), RuBlocks.STRIPPED_BLACKWOOD_LOG.get());
        registerStrippableBlock(RuBlocks.BLACKWOOD_WOOD.get(), RuBlocks.STRIPPED_BLACKWOOD_WOOD.get());

        registerStrippableBlock(RuBlocks.BLUE_BIOSHROOM_STEM.get(), RuBlocks.STRIPPED_BLUE_BIOSHROOM_STEM.get());
        registerStrippableBlock(RuBlocks.BLUE_BIOSHROOM_HYPHAE.get(), RuBlocks.STRIPPED_BLUE_BIOSHROOM_HYPHAE.get());

        registerStrippableBlock(RuBlocks.BRIMWOOD_LOG.get(), RuBlocks.STRIPPED_BRIMWOOD_LOG.get());
        registerStrippableBlock(RuBlocks.BRIMWOOD_LOG_MAGMA.get(), RuBlocks.STRIPPED_BRIMWOOD_LOG.get());
        registerStrippableBlock(RuBlocks.BRIMWOOD_WOOD.get(), RuBlocks.STRIPPED_BRIMWOOD_WOOD.get());

        registerStrippableBlock(RuBlocks.COBALT_LOG.get(), RuBlocks.STRIPPED_COBALT_LOG.get());
        registerStrippableBlock(RuBlocks.COBALT_WOOD.get(), RuBlocks.STRIPPED_COBALT_WOOD.get());

        registerStrippableBlock(RuBlocks.CYPRESS_LOG.get(), RuBlocks.STRIPPED_CYPRESS_LOG.get());
        registerStrippableBlock(RuBlocks.CYPRESS_WOOD.get(), RuBlocks.STRIPPED_CYPRESS_WOOD.get());

        registerStrippableBlock(RuBlocks.DEAD_LOG.get(), RuBlocks.STRIPPED_DEAD_LOG.get());
        registerStrippableBlock(RuBlocks.DEAD_WOOD.get(), RuBlocks.STRIPPED_DEAD_WOOD.get());

        registerStrippableBlock(RuBlocks.EUCALYPTUS_LOG.get(), RuBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        registerStrippableBlock(RuBlocks.EUCALYPTUS_WOOD.get(), RuBlocks.STRIPPED_EUCALYPTUS_WOOD.get());

        registerStrippableBlock(RuBlocks.GREEN_BIOSHROOM_STEM.get(), RuBlocks.STRIPPED_GREEN_BIOSHROOM_STEM.get());
        registerStrippableBlock(RuBlocks.GREEN_BIOSHROOM_HYPHAE.get(), RuBlocks.STRIPPED_GREEN_BIOSHROOM_HYPHAE.get());

        registerStrippableBlock(RuBlocks.JOSHUA_LOG.get(), RuBlocks.STRIPPED_JOSHUA_LOG.get());
        registerStrippableBlock(RuBlocks.JOSHUA_WOOD.get(), RuBlocks.STRIPPED_JOSHUA_WOOD.get());

        registerStrippableBlock(RuBlocks.KAPOK_LOG.get(), RuBlocks.STRIPPED_KAPOK_LOG.get());
        registerStrippableBlock(RuBlocks.KAPOK_WOOD.get(), RuBlocks.STRIPPED_KAPOK_WOOD.get());

        registerStrippableBlock(RuBlocks.LARCH_LOG.get(), RuBlocks.STRIPPED_LARCH_LOG.get());
        registerStrippableBlock(RuBlocks.LARCH_WOOD.get(), RuBlocks.STRIPPED_LARCH_WOOD.get());

        registerStrippableBlock(RuBlocks.MAPLE_LOG.get(), RuBlocks.STRIPPED_MAPLE_LOG.get());
        registerStrippableBlock(RuBlocks.MAPLE_WOOD.get(), RuBlocks.STRIPPED_MAPLE_WOOD.get());

        registerStrippableBlock(RuBlocks.MAGNOLIA_LOG.get(), RuBlocks.STRIPPED_MAGNOLIA_LOG.get());
        registerStrippableBlock(RuBlocks.MAGNOLIA_WOOD.get(), RuBlocks.STRIPPED_MAGNOLIA_WOOD.get());

        registerStrippableBlock(RuBlocks.MAUVE_LOG.get(), RuBlocks.STRIPPED_MAUVE_LOG.get());
        registerStrippableBlock(RuBlocks.MAUVE_WOOD.get(), RuBlocks.STRIPPED_MAUVE_WOOD.get());

        registerStrippableBlock(RuBlocks.PALM_LOG.get(), RuBlocks.STRIPPED_PALM_LOG.get());
        registerStrippableBlock(RuBlocks.PALM_WOOD.get(), RuBlocks.STRIPPED_PALM_WOOD.get());

        registerStrippableBlock(RuBlocks.PINE_LOG.get(), RuBlocks.STRIPPED_PINE_LOG.get());
        registerStrippableBlock(RuBlocks.PINE_WOOD.get(), RuBlocks.STRIPPED_PINE_WOOD.get());

        registerStrippableBlock(RuBlocks.PINK_BIOSHROOM_STEM.get(), RuBlocks.STRIPPED_PINK_BIOSHROOM_STEM.get());
        registerStrippableBlock(RuBlocks.PINK_BIOSHROOM_HYPHAE.get(), RuBlocks.STRIPPED_PINK_BIOSHROOM_HYPHAE.get());

        registerStrippableBlock(RuBlocks.REDWOOD_LOG.get(), RuBlocks.STRIPPED_REDWOOD_LOG.get());
        registerStrippableBlock(RuBlocks.REDWOOD_WOOD.get(), RuBlocks.STRIPPED_REDWOOD_WOOD.get());

        registerStrippableBlock(RuBlocks.SOCOTRA_LOG.get(), RuBlocks.STRIPPED_SOCOTRA_LOG.get());
        registerStrippableBlock(RuBlocks.SOCOTRA_WOOD.get(), RuBlocks.STRIPPED_SOCOTRA_WOOD.get());

        registerStrippableBlock(RuBlocks.WILLOW_LOG.get(), RuBlocks.STRIPPED_WILLOW_LOG.get());
        registerStrippableBlock(RuBlocks.WILLOW_WOOD.get(), RuBlocks.STRIPPED_WILLOW_WOOD.get());

        registerStrippableBlock(RuBlocks.YELLOW_BIOSHROOM_STEM.get(), RuBlocks.STRIPPED_YELLOW_BIOSHROOM_STEM.get());
        registerStrippableBlock(RuBlocks.YELLOW_BIOSHROOM_HYPHAE.get(), RuBlocks.STRIPPED_YELLOW_BIOSHROOM_HYPHAE.get());

        //ShovelBlocks
        registerShovelled(RuBlocks.CHALK_GRASS_BLOCK.get(), RuBlocks.CHALK.get().defaultBlockState());
        registerShovelled(RuBlocks.ARGILLITE_GRASS_BLOCK.get(), RuBlocks.ARGILLITE.get().defaultBlockState());

        registerShovelled(RuBlocks.STONE_GRASS_BLOCK.get(), Blocks.STONE.defaultBlockState());
        registerShovelled(RuBlocks.VIRIDESCENT_NYLIUM.get(), Blocks.STONE.defaultBlockState());
        registerShovelled(RuBlocks.PRISMOSS.get(), Blocks.STONE.defaultBlockState());
        registerShovelled(RuBlocks.MOSSY_STONE.get(), Blocks.STONE.defaultBlockState());

        registerShovelled(RuBlocks.DEEPSLATE_GRASS_BLOCK.get(), Blocks.DEEPSLATE.defaultBlockState());
        registerShovelled(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get(), Blocks.DEEPSLATE.defaultBlockState());
        registerShovelled(RuBlocks.DEEPSLATE_PRISMOSS.get(), Blocks.DEEPSLATE.defaultBlockState());
    }

    public static void registerStrippableBlock(Block log, Block strippedLog) {
        AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
        AxeItem.STRIPPABLES.put(log, strippedLog);
    }

    public static void registerShovelled(Block block, BlockState shovelledBlock) {
        ShovelItem.FLATTENABLES = Maps.newHashMap(ShovelItem.FLATTENABLES);
        ShovelItem.FLATTENABLES.put(block, shovelledBlock);
    }
}
