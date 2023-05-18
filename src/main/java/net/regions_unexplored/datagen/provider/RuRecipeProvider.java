package net.regions_unexplored.datagen.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;

import java.util.function.Consumer;

public class RuRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public RuRecipeProvider(PackOutput output) {
        super(output);
    }

    //TODO:set up recipes
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        planksFromLog(consumer, RuBlocks.BAOBAB_PLANKS.get(), RuTags.BAOBAB_LOGS_ITEM, 4);
    }
}
