package net.regions_unexplored.api.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class FoodItemWithBlock extends BlockItem {
    public FoodItemWithBlock(Block block, @NotNull Properties properties, @NotNull Food food) {
        super(block, properties.food(food.createComponent()));
    }
}
