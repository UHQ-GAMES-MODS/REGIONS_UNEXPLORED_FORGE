package net.regions_unexplored.registry;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.regions_unexplored.world.level.block.state.properties.RuWoodTypes;

public class WoodTypeRegistry {
    public static void addSheets(){
        Sheets.addWoodType(RuWoodTypes.BAOBAB);
        Sheets.addWoodType(RuWoodTypes.BLACKWOOD);
        Sheets.addWoodType(RuWoodTypes.CHERRY);
        Sheets.addWoodType(RuWoodTypes.CYPRESS);
        Sheets.addWoodType(RuWoodTypes.DEAD);
        Sheets.addWoodType(RuWoodTypes.EUCALYPTUS);
        Sheets.addWoodType(RuWoodTypes.JOSHUA);
        Sheets.addWoodType(RuWoodTypes.LARCH);
        Sheets.addWoodType(RuWoodTypes.MAPLE);
        Sheets.addWoodType(RuWoodTypes.MAUVE);
        Sheets.addWoodType(RuWoodTypes.PALM);
        Sheets.addWoodType(RuWoodTypes.PINE);
        Sheets.addWoodType(RuWoodTypes.REDWOOD);
        Sheets.addWoodType(RuWoodTypes.BRIMWOOD);
        Sheets.addWoodType(RuWoodTypes.WILLOW);
    }
    public static void addWoodTypes(){
        WoodType.register(RuWoodTypes.BAOBAB);
        WoodType.register(RuWoodTypes.BLACKWOOD);
        WoodType.register(RuWoodTypes.CHERRY);
        WoodType.register(RuWoodTypes.CYPRESS);
        WoodType.register(RuWoodTypes.DEAD);
        WoodType.register(RuWoodTypes.EUCALYPTUS);
        WoodType.register(RuWoodTypes.JOSHUA);
        WoodType.register(RuWoodTypes.LARCH);
        WoodType.register(RuWoodTypes.MAPLE);
        WoodType.register(RuWoodTypes.MAUVE);
        WoodType.register(RuWoodTypes.PALM);
        WoodType.register(RuWoodTypes.PINE);
        WoodType.register(RuWoodTypes.REDWOOD);
        WoodType.register(RuWoodTypes.BRIMWOOD);
        WoodType.register(RuWoodTypes.WILLOW);
    }
}
