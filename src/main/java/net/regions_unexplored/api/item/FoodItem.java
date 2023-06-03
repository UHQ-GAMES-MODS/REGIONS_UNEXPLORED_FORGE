package net.regions_unexplored.api.item;

import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class FoodItem extends Item {
    public FoodItem(@NotNull Properties properties, @NotNull Food food) {
        super(properties.food(food.createComponent()));
    }
}
