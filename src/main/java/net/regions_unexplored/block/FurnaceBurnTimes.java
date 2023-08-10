package net.regions_unexplored.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.regions_unexplored.RegionsUnexploredMod;

@Mod.EventBusSubscriber(modid = RegionsUnexploredMod.MOD_ID)
public class FurnaceBurnTimes {
    @SubscribeEvent
    public static void burnTime(FurnaceFuelBurnTimeEvent event) {
        ItemStack stack = event.getItemStack();
        Item item = stack.getItem();
        if (
        item == RuBlocks.SILVER_BIRCH_LOG.get().asItem()||
        item == RuBlocks.SILVER_BIRCH_WOOD.get().asItem()||

        item == RuBlocks.ALPHA_LOG.get().asItem()||
        item == RuBlocks.ALPHA_PLANKS.get().asItem()||
        item == RuBlocks.ALPHA_STAIRS.get().asItem()||

        item == RuBlocks.BAOBAB_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_BAOBAB_LOG.get().asItem()||
        item == RuBlocks.BAOBAB_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_BAOBAB_WOOD.get().asItem()||
        item == RuBlocks.BAOBAB_PLANKS.get().asItem()||
        item == RuBlocks.BAOBAB_STAIRS.get().asItem()||
        item == RuBlocks.BAOBAB_FENCE.get().asItem()||
        item == RuBlocks.BAOBAB_FENCE_GATE.get().asItem()||
        item == RuBlocks.BAOBAB_TRAPDOOR.get().asItem()||
        item == RuBlocks.BAOBAB_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.BLACKWOOD_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_BLACKWOOD_LOG.get().asItem()||
        item == RuBlocks.BLACKWOOD_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_BLACKWOOD_WOOD.get().asItem()||
        item == RuBlocks.BLACKWOOD_PLANKS.get().asItem()||
        item == RuBlocks.BLACKWOOD_STAIRS.get().asItem()||
        item == RuBlocks.BLACKWOOD_FENCE.get().asItem()||
        item == RuBlocks.BLACKWOOD_FENCE_GATE.get().asItem()||
        item == RuBlocks.BLACKWOOD_TRAPDOOR.get().asItem()||
        item == RuBlocks.BLACKWOOD_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.BLUE_BIOSHROOM_STEM.get().asItem()||
        item == RuBlocks.STRIPPED_BLUE_BIOSHROOM_STEM.get().asItem()||
        item == RuBlocks.BLUE_BIOSHROOM_HYPHAE.get().asItem()||
        item == RuBlocks.STRIPPED_BLUE_BIOSHROOM_HYPHAE.get().asItem()||
        item == RuBlocks.BLUE_BIOSHROOM_PLANKS.get().asItem()||
        item == RuBlocks.BLUE_BIOSHROOM_STAIRS.get().asItem()||
        item == RuBlocks.BLUE_BIOSHROOM_FENCE.get().asItem()||
        item == RuBlocks.BLUE_BIOSHROOM_FENCE_GATE.get().asItem()||
        item == RuBlocks.BLUE_BIOSHROOM_TRAPDOOR.get().asItem()||
        item == RuBlocks.BLUE_BIOSHROOM_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.BRIMWOOD_LOG.get().asItem()||
        item == RuBlocks.BRIMWOOD_LOG_MAGMA.get().asItem()||
        item == RuBlocks.STRIPPED_BRIMWOOD_LOG.get().asItem()||
        item == RuBlocks.BRIMWOOD_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_BRIMWOOD_WOOD.get().asItem()||
        item == RuBlocks.BRIMWOOD_PLANKS.get().asItem()||
        item == RuBlocks.BRIMWOOD_STAIRS.get().asItem()||
        item == RuBlocks.BRIMWOOD_FENCE.get().asItem()||
        item == RuBlocks.BRIMWOOD_FENCE_GATE.get().asItem()||
        item == RuBlocks.BRIMWOOD_TRAPDOOR.get().asItem()||
        item == RuBlocks.BRIMWOOD_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.COBALT_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_COBALT_LOG.get().asItem()||
        item == RuBlocks.COBALT_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_COBALT_WOOD.get().asItem()||
        item == RuBlocks.COBALT_PLANKS.get().asItem()||
        item == RuBlocks.COBALT_STAIRS.get().asItem()||
        item == RuBlocks.COBALT_FENCE.get().asItem()||
        item == RuBlocks.COBALT_FENCE_GATE.get().asItem()||
        item == RuBlocks.COBALT_TRAPDOOR.get().asItem()||
        item == RuBlocks.COBALT_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.CYPRESS_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_CYPRESS_LOG.get().asItem()||
        item == RuBlocks.CYPRESS_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_CYPRESS_WOOD.get().asItem()||
        item == RuBlocks.CYPRESS_PLANKS.get().asItem()||
        item == RuBlocks.CYPRESS_STAIRS.get().asItem()||
        item == RuBlocks.CYPRESS_FENCE.get().asItem()||
        item == RuBlocks.CYPRESS_FENCE_GATE.get().asItem()||
        item == RuBlocks.CYPRESS_TRAPDOOR.get().asItem()||
        item == RuBlocks.CYPRESS_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.DEAD_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_DEAD_LOG.get().asItem()||
        item == RuBlocks.DEAD_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_DEAD_WOOD.get().asItem()||
        item == RuBlocks.DEAD_PLANKS.get().asItem()||
        item == RuBlocks.DEAD_STAIRS.get().asItem()||
        item == RuBlocks.DEAD_FENCE.get().asItem()||
        item == RuBlocks.DEAD_FENCE_GATE.get().asItem()||
        item == RuBlocks.DEAD_TRAPDOOR.get().asItem()||
        item == RuBlocks.DEAD_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.EUCALYPTUS_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_EUCALYPTUS_LOG.get().asItem()||
        item == RuBlocks.EUCALYPTUS_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_EUCALYPTUS_WOOD.get().asItem()||
        item == RuBlocks.EUCALYPTUS_PLANKS.get().asItem()||
        item == RuBlocks.EUCALYPTUS_STAIRS.get().asItem()||
        item == RuBlocks.EUCALYPTUS_FENCE.get().asItem()||
        item == RuBlocks.EUCALYPTUS_FENCE_GATE.get().asItem()||
        item == RuBlocks.EUCALYPTUS_TRAPDOOR.get().asItem()||
        item == RuBlocks.EUCALYPTUS_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.GREEN_BIOSHROOM_STEM.get().asItem()||
        item == RuBlocks.STRIPPED_GREEN_BIOSHROOM_STEM.get().asItem()||
        item == RuBlocks.GREEN_BIOSHROOM_HYPHAE.get().asItem()||
        item == RuBlocks.STRIPPED_GREEN_BIOSHROOM_HYPHAE.get().asItem()||
        item == RuBlocks.GREEN_BIOSHROOM_PLANKS.get().asItem()||
        item == RuBlocks.GREEN_BIOSHROOM_STAIRS.get().asItem()||
        item == RuBlocks.GREEN_BIOSHROOM_FENCE.get().asItem()||
        item == RuBlocks.GREEN_BIOSHROOM_FENCE_GATE.get().asItem()||
        item == RuBlocks.GREEN_BIOSHROOM_TRAPDOOR.get().asItem()||
        item == RuBlocks.GREEN_BIOSHROOM_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.JOSHUA_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_JOSHUA_LOG.get().asItem()||
        item == RuBlocks.JOSHUA_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_JOSHUA_WOOD.get().asItem()||
        item == RuBlocks.JOSHUA_PLANKS.get().asItem()||
        item == RuBlocks.JOSHUA_STAIRS.get().asItem()||
        item == RuBlocks.JOSHUA_FENCE.get().asItem()||
        item == RuBlocks.JOSHUA_FENCE_GATE.get().asItem()||
        item == RuBlocks.JOSHUA_TRAPDOOR.get().asItem()||
        item == RuBlocks.JOSHUA_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.KAPOK_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_KAPOK_LOG.get().asItem()||
        item == RuBlocks.KAPOK_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_KAPOK_WOOD.get().asItem()||
        item == RuBlocks.KAPOK_PLANKS.get().asItem()||
        item == RuBlocks.KAPOK_STAIRS.get().asItem()||
        item == RuBlocks.KAPOK_FENCE.get().asItem()||
        item == RuBlocks.KAPOK_FENCE_GATE.get().asItem()||
        item == RuBlocks.KAPOK_TRAPDOOR.get().asItem()||
        item == RuBlocks.KAPOK_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.LARCH_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_LARCH_LOG.get().asItem()||
        item == RuBlocks.LARCH_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_LARCH_WOOD.get().asItem()||
        item == RuBlocks.LARCH_PLANKS.get().asItem()||
        item == RuBlocks.LARCH_STAIRS.get().asItem()||
        item == RuBlocks.LARCH_FENCE.get().asItem()||
        item == RuBlocks.LARCH_FENCE_GATE.get().asItem()||
        item == RuBlocks.LARCH_TRAPDOOR.get().asItem()||
        item == RuBlocks.LARCH_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.MAGNOLIA_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_MAGNOLIA_LOG.get().asItem()||
        item == RuBlocks.MAGNOLIA_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_MAGNOLIA_WOOD.get().asItem()||
        item == RuBlocks.MAGNOLIA_PLANKS.get().asItem()||
        item == RuBlocks.MAGNOLIA_STAIRS.get().asItem()||
        item == RuBlocks.MAGNOLIA_FENCE.get().asItem()||
        item == RuBlocks.MAGNOLIA_FENCE_GATE.get().asItem()||
        item == RuBlocks.MAGNOLIA_TRAPDOOR.get().asItem()||
        item == RuBlocks.MAGNOLIA_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.MAPLE_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_MAPLE_LOG.get().asItem()||
        item == RuBlocks.MAPLE_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_MAPLE_WOOD.get().asItem()||
        item == RuBlocks.MAPLE_PLANKS.get().asItem()||
        item == RuBlocks.MAPLE_STAIRS.get().asItem()||
        item == RuBlocks.MAPLE_FENCE.get().asItem()||
        item == RuBlocks.MAPLE_FENCE_GATE.get().asItem()||
        item == RuBlocks.MAPLE_TRAPDOOR.get().asItem()||
        item == RuBlocks.MAPLE_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.MAUVE_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_MAUVE_LOG.get().asItem()||
        item == RuBlocks.MAUVE_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_MAUVE_WOOD.get().asItem()||
        item == RuBlocks.MAUVE_PLANKS.get().asItem()||
        item == RuBlocks.MAUVE_STAIRS.get().asItem()||
        item == RuBlocks.MAUVE_FENCE.get().asItem()||
        item == RuBlocks.MAUVE_FENCE_GATE.get().asItem()||
        item == RuBlocks.MAUVE_TRAPDOOR.get().asItem()||
        item == RuBlocks.MAUVE_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.PALM_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_PALM_LOG.get().asItem()||
        item == RuBlocks.PALM_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_PALM_WOOD.get().asItem()||
        item == RuBlocks.PALM_PLANKS.get().asItem()||
        item == RuBlocks.PALM_STAIRS.get().asItem()||
        item == RuBlocks.PALM_FENCE.get().asItem()||
        item == RuBlocks.PALM_FENCE_GATE.get().asItem()||
        item == RuBlocks.PALM_TRAPDOOR.get().asItem()||
        item == RuBlocks.PALM_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.PINE_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_PINE_LOG.get().asItem()||
        item == RuBlocks.PINE_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_PINE_WOOD.get().asItem()||
        item == RuBlocks.PINE_PLANKS.get().asItem()||
        item == RuBlocks.PINE_STAIRS.get().asItem()||
        item == RuBlocks.PINE_FENCE.get().asItem()||
        item == RuBlocks.PINE_FENCE_GATE.get().asItem()||
        item == RuBlocks.PINE_TRAPDOOR.get().asItem()||
        item == RuBlocks.PINE_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.PINK_BIOSHROOM_STEM.get().asItem()||
        item == RuBlocks.STRIPPED_PINK_BIOSHROOM_STEM.get().asItem()||
        item == RuBlocks.PINK_BIOSHROOM_HYPHAE.get().asItem()||
        item == RuBlocks.STRIPPED_PINK_BIOSHROOM_HYPHAE.get().asItem()||
        item == RuBlocks.PINK_BIOSHROOM_PLANKS.get().asItem()||
        item == RuBlocks.PINK_BIOSHROOM_STAIRS.get().asItem()||
        item == RuBlocks.PINK_BIOSHROOM_FENCE.get().asItem()||
        item == RuBlocks.PINK_BIOSHROOM_FENCE_GATE.get().asItem()||
        item == RuBlocks.PINK_BIOSHROOM_TRAPDOOR.get().asItem()||
        item == RuBlocks.PINK_BIOSHROOM_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.REDWOOD_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_REDWOOD_LOG.get().asItem()||
        item == RuBlocks.REDWOOD_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_REDWOOD_WOOD.get().asItem()||
        item == RuBlocks.REDWOOD_PLANKS.get().asItem()||
        item == RuBlocks.REDWOOD_STAIRS.get().asItem()||
        item == RuBlocks.REDWOOD_FENCE.get().asItem()||
        item == RuBlocks.REDWOOD_FENCE_GATE.get().asItem()||
        item == RuBlocks.REDWOOD_TRAPDOOR.get().asItem()||
        item == RuBlocks.REDWOOD_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.SOCOTRA_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_SOCOTRA_LOG.get().asItem()||
        item == RuBlocks.SOCOTRA_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_SOCOTRA_WOOD.get().asItem()||
        item == RuBlocks.SOCOTRA_PLANKS.get().asItem()||
        item == RuBlocks.SOCOTRA_STAIRS.get().asItem()||
        item == RuBlocks.SOCOTRA_FENCE.get().asItem()||
        item == RuBlocks.SOCOTRA_FENCE_GATE.get().asItem()||
        item == RuBlocks.SOCOTRA_TRAPDOOR.get().asItem()||
        item == RuBlocks.SOCOTRA_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.WILLOW_LOG.get().asItem()||
        item == RuBlocks.STRIPPED_WILLOW_LOG.get().asItem()||
        item == RuBlocks.WILLOW_WOOD.get().asItem()||
        item == RuBlocks.STRIPPED_WILLOW_WOOD.get().asItem()||
        item == RuBlocks.WILLOW_PLANKS.get().asItem()||
        item == RuBlocks.WILLOW_STAIRS.get().asItem()||
        item == RuBlocks.WILLOW_FENCE.get().asItem()||
        item == RuBlocks.WILLOW_FENCE_GATE.get().asItem()||
        item == RuBlocks.WILLOW_TRAPDOOR.get().asItem()||
        item == RuBlocks.WILLOW_PRESSURE_PLATE.get().asItem()||

        item == RuBlocks.YELLOW_BIOSHROOM_STEM.get().asItem()||
        item == RuBlocks.STRIPPED_YELLOW_BIOSHROOM_STEM.get().asItem()||
        item == RuBlocks.YELLOW_BIOSHROOM_HYPHAE.get().asItem()||
        item == RuBlocks.STRIPPED_YELLOW_BIOSHROOM_HYPHAE.get().asItem()||
        item == RuBlocks.YELLOW_BIOSHROOM_PLANKS.get().asItem()||
        item == RuBlocks.YELLOW_BIOSHROOM_STAIRS.get().asItem()||
        item == RuBlocks.YELLOW_BIOSHROOM_FENCE.get().asItem()||
        item == RuBlocks.YELLOW_BIOSHROOM_FENCE_GATE.get().asItem()||
        item == RuBlocks.YELLOW_BIOSHROOM_TRAPDOOR.get().asItem()||
        item == RuBlocks.YELLOW_BIOSHROOM_PRESSURE_PLATE.get().asItem()||

        /*-----------------PAINTED PLANKS-----------------*/
        //PLANKS
        item == RuBlocks.RED_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.ORANGE_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.YELLOW_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.LIME_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.GREEN_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.CYAN_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.LIGHT_BLUE_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.BLUE_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.PURPLE_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.MAGENTA_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.PINK_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.BROWN_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.WHITE_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.LIGHT_GRAY_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.GRAY_PAINTED_PLANKS.get().asItem()||
        item == RuBlocks.BLACK_PAINTED_PLANKS.get().asItem()||
        //STAIRS
        item == RuBlocks.RED_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.ORANGE_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.YELLOW_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.LIME_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.GREEN_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.CYAN_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.LIGHT_BLUE_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.BLUE_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.PURPLE_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.MAGENTA_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.PINK_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.BROWN_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.WHITE_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.LIGHT_GRAY_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.GRAY_PAINTED_STAIRS.get().asItem()||
        item == RuBlocks.BLACK_PAINTED_STAIRS.get().asItem()||
        //SLABS
        item == RuBlocks.RED_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.ORANGE_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.YELLOW_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.LIME_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.GREEN_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.CYAN_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.LIGHT_BLUE_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.BLUE_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.PURPLE_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.MAGENTA_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.PINK_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.BROWN_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.WHITE_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.LIGHT_GRAY_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.GRAY_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.BLACK_PAINTED_SLAB.get().asItem()
        ) {
            event.setBurnTime(300);
        }

        if (
        item == RuBlocks.BAOBAB_DOOR.get().asItem()||
        item == RuBlocks.BLACKWOOD_DOOR.get().asItem()||
        item == RuBlocks.BLUE_BIOSHROOM_DOOR.get().asItem()||
        item == RuBlocks.BRIMWOOD_DOOR.get().asItem()||
        item == RuBlocks.COBALT_DOOR.get().asItem()||
        item == RuBlocks.CYPRESS_DOOR.get().asItem()||
        item == RuBlocks.DEAD_DOOR.get().asItem()||
        item == RuBlocks.EUCALYPTUS_DOOR.get().asItem()||
        item == RuBlocks.GREEN_BIOSHROOM_DOOR.get().asItem()||
        item == RuBlocks.JOSHUA_DOOR.get().asItem()||
        item == RuBlocks.KAPOK_DOOR.get().asItem()||
        item == RuBlocks.LARCH_DOOR.get().asItem()||
        item == RuBlocks.MAGNOLIA_DOOR.get().asItem()||
        item == RuBlocks.MAPLE_DOOR.get().asItem()||
        item == RuBlocks.MAUVE_DOOR.get().asItem()||
        item == RuBlocks.PALM_DOOR.get().asItem()||
        item == RuBlocks.PINE_DOOR.get().asItem()||
        item == RuBlocks.PINK_BIOSHROOM_DOOR.get().asItem()||
        item == RuBlocks.REDWOOD_DOOR.get().asItem()||
        item == RuBlocks.SOCOTRA_DOOR.get().asItem()||
        item == RuBlocks.WILLOW_DOOR.get().asItem()||
        item == RuBlocks.YELLOW_BIOSHROOM_DOOR.get().asItem()
        ) {
            event.setBurnTime(200);
        }

        if (
        item == RuBlocks.BAOBAB_SLAB.get().asItem()||
        item == RuBlocks.BLACKWOOD_SLAB.get().asItem()||
        item == RuBlocks.BLUE_BIOSHROOM_SLAB.get().asItem()||
        item == RuBlocks.BRIMWOOD_SLAB.get().asItem()||
        item == RuBlocks.COBALT_SLAB.get().asItem()||
        item == RuBlocks.CYPRESS_SLAB.get().asItem()||
        item == RuBlocks.DEAD_SLAB.get().asItem()||
        item == RuBlocks.EUCALYPTUS_SLAB.get().asItem()||
        item == RuBlocks.GREEN_BIOSHROOM_SLAB.get().asItem()||
        item == RuBlocks.JOSHUA_SLAB.get().asItem()||
        item == RuBlocks.KAPOK_SLAB.get().asItem()||
        item == RuBlocks.LARCH_SLAB.get().asItem()||
        item == RuBlocks.MAGNOLIA_SLAB.get().asItem()||
        item == RuBlocks.MAPLE_SLAB.get().asItem()||
        item == RuBlocks.MAUVE_SLAB.get().asItem()||
        item == RuBlocks.PALM_SLAB.get().asItem()||
        item == RuBlocks.PINE_SLAB.get().asItem()||
        item == RuBlocks.PINK_BIOSHROOM_SLAB.get().asItem()||
        item == RuBlocks.REDWOOD_SLAB.get().asItem()||
        item == RuBlocks.SOCOTRA_SLAB.get().asItem()||
        item == RuBlocks.WILLOW_SLAB.get().asItem()||
        item == RuBlocks.YELLOW_BIOSHROOM_SLAB.get().asItem()||
        item == RuBlocks.RED_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.ORANGE_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.YELLOW_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.LIME_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.GREEN_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.CYAN_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.LIGHT_BLUE_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.BLUE_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.PURPLE_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.MAGENTA_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.PINK_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.BROWN_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.WHITE_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.LIGHT_GRAY_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.GRAY_PAINTED_SLAB.get().asItem()||
        item == RuBlocks.BLACK_PAINTED_SLAB.get().asItem()
        ) {
            event.setBurnTime(150);
        }

        if (
        item == RuBlocks.ALPHA_SAPLING.get().asItem()||
        item == RuBlocks.APPLE_OAK_SAPLING.get().asItem()||
        item == RuBlocks.BAMBOO_SAPLING.get().asItem()||
        item == RuBlocks.BAOBAB_SAPLING.get().asItem()||
        item == RuBlocks.BLACKWOOD_SAPLING.get().asItem()||
        item == RuBlocks.CACTUS_FLOWER.get().asItem()||
        item == RuBlocks.CYPRESS_SAPLING.get().asItem()||
        item == RuBlocks.DEAD_PINE_SAPLING.get().asItem()||
        item == RuBlocks.DEAD_SAPLING.get().asItem()||
        item == RuBlocks.EUCALYPTUS_SAPLING.get().asItem()||
        item == RuBlocks.FLOWERING_SAPLING.get().asItem()||
        item == RuBlocks.GOLDEN_LARCH_SAPLING.get().asItem()||
        item == RuBlocks.JOSHUA_SAPLING.get().asItem()||
        item == RuBlocks.KAPOK_SAPLING.get().asItem()||
        item == RuBlocks.LARCH_SAPLING.get().asItem()||
        item == RuBlocks.MAGNOLIA_SAPLING.get().asItem()||
        item == RuBlocks.MAPLE_SAPLING.get().asItem()||
        item == RuBlocks.MAUVE_SAPLING.get().asItem()||
        item == RuBlocks.ORANGE_MAPLE_SAPLING.get().asItem()||
        item == RuBlocks.PALM_SAPLING.get().asItem()||
        item == RuBlocks.PINE_SAPLING.get().asItem()||
        item == RuBlocks.BLUE_MAGNOLIA_SAPLING.get().asItem()||
        item == RuBlocks.PINK_MAGNOLIA_SAPLING.get().asItem()||
        item == RuBlocks.REDWOOD_SAPLING.get().asItem()||
        item == RuBlocks.RED_MAPLE_SAPLING.get().asItem()||
        item == RuBlocks.ENCHANTED_BIRCH_SAPLING.get().asItem()||
        item == RuBlocks.SILVER_BIRCH_SAPLING.get().asItem()||
        item == RuBlocks.SMALL_OAK_SAPLING.get().asItem()||
        item == RuBlocks.SOCOTRA_SAPLING.get().asItem()||
        item == RuBlocks.WHITE_MAGNOLIA_SAPLING.get().asItem()||
        item == RuBlocks.WILLOW_SAPLING.get().asItem()||

        item == RuBlocks.ACACIA_SHRUB.get().asItem()||
        item == RuBlocks.BAOBAB_SHRUB.get().asItem()||
        item == RuBlocks.BIRCH_SHRUB.get().asItem()||
        item == RuBlocks.BLACKWOOD_SHRUB.get().asItem()||
        item == RuBlocks.BRIMWOOD_SHRUB.get().asItem()||
        item == RuBlocks.CHERRY_SHRUB.get().asItem()||
        item == RuBlocks.CYPRESS_SHRUB.get().asItem()||
        item == RuBlocks.DARK_OAK_SHRUB.get().asItem()||
        item == RuBlocks.DEAD_PINE_SHRUB.get().asItem()||
        item == RuBlocks.DEAD_SHRUB.get().asItem()||
        item == RuBlocks.EUCALYPTUS_SHRUB.get().asItem()||
        item == RuBlocks.FLOWERING_SHRUB.get().asItem()||
        item == RuBlocks.GOLDEN_LARCH_SHRUB.get().asItem()||
        item == RuBlocks.JOSHUA_SHRUB.get().asItem()||
        item == RuBlocks.JUNGLE_SHRUB.get().asItem()||
        item == RuBlocks.KAPOK_SHRUB.get().asItem()||
        item == RuBlocks.LARCH_SHRUB.get().asItem()||
        item == RuBlocks.MAGNOLIA_SHRUB.get().asItem()||
        item == RuBlocks.MANGROVE_SHRUB.get().asItem()||
        item == RuBlocks.MAPLE_SHRUB.get().asItem()||
        item == RuBlocks.MAUVE_SHRUB.get().asItem()||
        item == RuBlocks.OAK_SHRUB.get().asItem()||
        item == RuBlocks.ORANGE_MAPLE_SHRUB.get().asItem()||
        item == RuBlocks.PALM_SHRUB.get().asItem()||
        item == RuBlocks.PINE_SHRUB.get().asItem()||
        item == RuBlocks.BLUE_MAGNOLIA_SHRUB.get().asItem()||
        item == RuBlocks.PINK_MAGNOLIA_SHRUB.get().asItem()||
        item == RuBlocks.REDWOOD_SHRUB.get().asItem()||
        item == RuBlocks.RED_MAPLE_SHRUB.get().asItem()||
        item == RuBlocks.ENCHANTED_BIRCH_SHRUB.get().asItem()||
        item == RuBlocks.SILVER_BIRCH_SHRUB.get().asItem()||
        item == RuBlocks.SOCOTRA_SHRUB.get().asItem()||
        item == RuBlocks.SPRUCE_SHRUB.get().asItem()||
        item == RuBlocks.WHITE_MAGNOLIA_SHRUB.get().asItem()||
        item == RuBlocks.WILLOW_SHRUB.get().asItem()||

        item == RuBlocks.BAOBAB_BUTTON.get().asItem()||
        item == RuBlocks.BLACKWOOD_BUTTON.get().asItem()||
        item == RuBlocks.BLUE_BIOSHROOM_BUTTON.get().asItem()||
        item == RuBlocks.BRIMWOOD_BUTTON.get().asItem()||
        item == RuBlocks.COBALT_BUTTON.get().asItem()||
        item == RuBlocks.CYPRESS_BUTTON.get().asItem()||
        item == RuBlocks.DEAD_BUTTON.get().asItem()||
        item == RuBlocks.EUCALYPTUS_BUTTON.get().asItem()||
        item == RuBlocks.GREEN_BIOSHROOM_BUTTON.get().asItem()||
        item == RuBlocks.JOSHUA_BUTTON.get().asItem()||
        item == RuBlocks.KAPOK_BUTTON.get().asItem()||
        item == RuBlocks.LARCH_BUTTON.get().asItem()||
        item == RuBlocks.MAGNOLIA_BUTTON.get().asItem()||
        item == RuBlocks.MAPLE_BUTTON.get().asItem()||
        item == RuBlocks.MAUVE_BUTTON.get().asItem()||
        item == RuBlocks.PALM_BUTTON.get().asItem()||
        item == RuBlocks.PINE_BUTTON.get().asItem()||
        item == RuBlocks.PINK_BIOSHROOM_BUTTON.get().asItem()||
        item == RuBlocks.REDWOOD_BUTTON.get().asItem()||
        item == RuBlocks.SOCOTRA_BUTTON.get().asItem()||
        item == RuBlocks.WILLOW_BUTTON.get().asItem()||
        item == RuBlocks.YELLOW_BIOSHROOM_BUTTON.get().asItem()
        ) {
            event.setBurnTime(100);
        }
    }
}
