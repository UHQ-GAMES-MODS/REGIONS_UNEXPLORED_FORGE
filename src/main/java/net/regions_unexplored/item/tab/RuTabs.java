package net.regions_unexplored.item.tab;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.item.RuItems;

public class RuTabs {
    public static CreativeModeTab REGIONS_UNEXPLORED_MAIN_TAB;

    public static void load() {
        REGIONS_UNEXPLORED_MAIN_TAB = new CreativeModeTab("ru_main") {
            @Override
            public ItemStack makeIcon() {return new ItemStack(RuBlocks.PRISMARITE_CLUSTER.get());}

            @OnlyIn(Dist.CLIENT)
            public boolean hasSearchBar() {return true;}

            @Override
            public int getSearchbarWidth() {
                return 58;
            }

            @OnlyIn(Dist.CLIENT)
            public boolean showTitle() {return false;}

        }
        .setBackgroundImage(new ResourceLocation(RegionsUnexploredMod.MOD_ID, "textures/gui/container/creative_inventory/tab_item_search.png"));
    }
}