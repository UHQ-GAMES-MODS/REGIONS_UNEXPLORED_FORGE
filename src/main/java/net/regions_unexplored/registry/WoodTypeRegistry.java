package net.regions_unexplored.registry;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.regions_unexplored.data.block.RuWoodTypes;

public class WoodTypeRegistry {
    public static void addSheets(){
        Sheets.addWoodType(RuWoodTypes.BAOBAB);
        Sheets.addWoodType(RuWoodTypes.BLACKWOOD);
        Sheets.addWoodType(RuWoodTypes.BLUE_BIOSHROOM);
        Sheets.addWoodType(RuWoodTypes.BRIMWOOD);
        Sheets.addWoodType(RuWoodTypes.COBALT);
        Sheets.addWoodType(RuWoodTypes.CYPRESS);
        Sheets.addWoodType(RuWoodTypes.DEAD);
        Sheets.addWoodType(RuWoodTypes.EUCALYPTUS);
        Sheets.addWoodType(RuWoodTypes.GREEN_BIOSHROOM);
        Sheets.addWoodType(RuWoodTypes.JOSHUA);
        Sheets.addWoodType(RuWoodTypes.KAPOK);
        Sheets.addWoodType(RuWoodTypes.LARCH);
        Sheets.addWoodType(RuWoodTypes.MAGNOLIA);
        Sheets.addWoodType(RuWoodTypes.MAPLE);
        Sheets.addWoodType(RuWoodTypes.MAUVE);
        Sheets.addWoodType(RuWoodTypes.PALM);
        Sheets.addWoodType(RuWoodTypes.PINE);
        Sheets.addWoodType(RuWoodTypes.PINK_BIOSHROOM);
        Sheets.addWoodType(RuWoodTypes.REDWOOD);
        Sheets.addWoodType(RuWoodTypes.SOCOTRA);
        Sheets.addWoodType(RuWoodTypes.WILLOW);
        Sheets.addWoodType(RuWoodTypes.YELLOW_BIOSHROOM);
    }
    public static void addWoodTypes(){
        WoodType.register(RuWoodTypes.BAOBAB);
        WoodType.register(RuWoodTypes.BLACKWOOD);
        WoodType.register(RuWoodTypes.BLUE_BIOSHROOM);
        WoodType.register(RuWoodTypes.BRIMWOOD);
        WoodType.register(RuWoodTypes.COBALT);
        WoodType.register(RuWoodTypes.CYPRESS);
        WoodType.register(RuWoodTypes.DEAD);
        WoodType.register(RuWoodTypes.EUCALYPTUS);
        WoodType.register(RuWoodTypes.GREEN_BIOSHROOM);
        WoodType.register(RuWoodTypes.JOSHUA);
        WoodType.register(RuWoodTypes.KAPOK);
        WoodType.register(RuWoodTypes.LARCH);
        WoodType.register(RuWoodTypes.MAGNOLIA);
        WoodType.register(RuWoodTypes.MAPLE);
        WoodType.register(RuWoodTypes.MAUVE);
        WoodType.register(RuWoodTypes.PALM);
        WoodType.register(RuWoodTypes.PINE);
        WoodType.register(RuWoodTypes.PINK_BIOSHROOM);
        WoodType.register(RuWoodTypes.REDWOOD);
        WoodType.register(RuWoodTypes.SOCOTRA);
        WoodType.register(RuWoodTypes.WILLOW);
        WoodType.register(RuWoodTypes.YELLOW_BIOSHROOM);
    }
}
