package net.regions_unexplored.datagen.recipe;

import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public class RuShapedRecipeBuilder extends ShapedRecipeBuilder {

    public RuShapedRecipeBuilder(ItemLike item, int i) {
        super(item, i);
    }

    @Override
    public void save(Consumer<FinishedRecipe> p_126141_, ResourceLocation p_126142_) {
        //this.ensureValid(p_126142_);
        //this.advancement.parent(ROOT_RECIPE_ADVANCEMENT).addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(p_126142_)).rewards(AdvancementRewards.Builder.recipe(p_126142_)).requirements(RequirementsStrategy.OR);
        //p_126141_.accept(new ShapedRecipeBuilder.Result(p_126142_, this.result, this.count, this.group == null ? "" : this.group, this.rows, this.key, this.advancement, new ResourceLocation(p_126142_.getNamespace(), "recipes/" + this.result.getItemCategory().getRecipeFolderName() + "/" + p_126142_.getPath())));
    }
}
