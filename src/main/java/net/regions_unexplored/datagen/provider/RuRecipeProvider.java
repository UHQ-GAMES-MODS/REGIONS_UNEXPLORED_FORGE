package net.regions_unexplored.datagen.provider;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

public class RuRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public static final ImmutableList<ItemLike> REDSTONE_SMELTABLES = ImmutableList.of(RuBlocks.RAW_REDSTONE_BLOCK.get(), RuBlocks.REDSTONE_BULB.get());

    public RuRecipeProvider(PackOutput output) {
        super(output);
    }

    //TODO:set up recipes
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        planksFromLog(consumer, RuBlocks.BAOBAB_PLANKS.get(), RuTags.BAOBAB_LOGS_ITEM, 4);
        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, Blocks.DANDELION, "yellow_dye");
        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, Blocks.SUNFLOWER, "yellow_dye", 2);

        /*-----------------CAVE_BLOCKS_DONE-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.PRISMOSS.get(), 1).define('#', Blocks.STONE).define('X', RuBlocks.PRISMOSS_SPROUT.get()).pattern("X").pattern("#").group("prismoss").unlockedBy("has_stone", has(Blocks.STONE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.DEEPSLATE_PRISMOSS.get(), 1).define('#', Blocks.DEEPSLATE).define('X', RuBlocks.PRISMOSS_SPROUT.get()).pattern("X").pattern("#").group("prismoss").unlockedBy("has_deepslate", has(Blocks.DEEPSLATE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.HANGING_PRISMARITE.get(), 1).define('#', RuBlocks.PRISMARITE_CLUSTER.get()).pattern("#").pattern("#").pattern("#").group("prismarite").unlockedBy("has_prismarite", has(RuBlocks.PRISMARITE_CLUSTER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.LARGE_PRISMARITE_CLUSTER.get(), 1).define('#', RuBlocks.PRISMARITE_CLUSTER.get()).pattern("#").pattern("#").group("prismarite").unlockedBy("has_prismarite", has(RuBlocks.PRISMARITE_CLUSTER.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.PRISMAGLASS.get(), 2).define('#', TagKey.create(Registries.ITEM, new ResourceLocation("forge", "glass"))).define('X', RuTags.PRISMARITE_CRYSTALS_ITEM).pattern(" X ").pattern("X#X").pattern(" X ").group("stained_glass").unlockedBy("has_glass", has(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "glass")))).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, RuBlocks.RAW_REDSTONE_BLOCK.get(), 1).define('#', Items.REDSTONE).pattern("##").pattern("##").group("redstone").unlockedBy("has_redstone", has(Items.REDSTONE)).save(consumer);
        oreSmelting(consumer, REDSTONE_SMELTABLES, RecipeCategory.REDSTONE, Items.REDSTONE, 0.7F, 200, "redstone");
        oreBlasting(consumer, REDSTONE_SMELTABLES, RecipeCategory.REDSTONE, Items.REDSTONE, 0.7F, 100, "redstone");
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, RuBlocks.REDSTONE_BUD.get(), 2).define('#', Items.REDSTONE).pattern("###").group("redstone").unlockedBy("has_redstone", has(Items.REDSTONE)).save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.STONE_GRASS_BLOCK.get(), 1).define('#', Blocks.STONE).define('X', RuTags.GRASS_ITEM).pattern("X").pattern("#").group("stone_grass").unlockedBy("has_stone", has(Blocks.STONE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.DEEPSLATE_GRASS_BLOCK.get(), 1).define('#', Blocks.DEEPSLATE).define('X', RuTags.GRASS_ITEM).pattern("X").pattern("#").group("stone_grass").unlockedBy("has_deepslate", has(Blocks.DEEPSLATE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.VIRIDESCENT_NYLIUM.get(), 1).define('#', Blocks.STONE).define('X', TagKey.create(Registries.ITEM, new ResourceLocation("forge", "mushrooms"))).pattern("X").pattern("#").group("viridescent_nylium").unlockedBy("has_stone", has(Blocks.STONE)).unlockedBy("has_mushroom", has(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "mushrooms")))).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get(), 1).define('#', Blocks.DEEPSLATE).define('X', TagKey.create(Registries.ITEM, new ResourceLocation("forge", "mushrooms"))).pattern("X").pattern("#").group("viridescent_nylium").unlockedBy("has_deepslate", has(Blocks.DEEPSLATE)).unlockedBy("has_mushroom", has(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "mushrooms")))).save(consumer);

        /*-----------------PLANTS-----------------*/
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RuBlocks.DEAD_STEPPE_SHRUB.get(), "brown_dye");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WHEAT_SEEDS, 1).requires(RuBlocks.SEEDED_GRASS.get()).group("seeds").unlockedBy("has_seeded_grass", has(RuBlocks.SEEDED_GRASS.get())).save(consumer, new ResourceLocation(RegionsUnexploredMod.MOD_ID, getConversionRecipeName(Items.WHEAT_SEEDS, RuBlocks.SEEDED_GRASS.get())));
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RuBlocks.SMALL_DESERT_SHRUB.get(), "brown_dye");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WHEAT_SEEDS, 2).requires(RuBlocks.SEEDED_TALL_GRASS.get()).group("seeds").unlockedBy("has_seeded_tall_grass", has(RuBlocks.SEEDED_TALL_GRASS.get())).save(consumer, new ResourceLocation(RegionsUnexploredMod.MOD_ID, getConversionRecipeName(Items.WHEAT_SEEDS, RuBlocks.SEEDED_TALL_GRASS.get())));

        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RuBlocks.ALPHA_DANDELION.get(), "yellow_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.ALPHA_ROSE.get(), "red_dye");
        oneToOneConversionRecipe(consumer, Items.BLUE_DYE, RuBlocks.BLUE_LUPINE.get(), "blue_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_GRAY_DYE, RuBlocks.DAISY.get(), "light_gray_dye");
        oneToOneConversionRecipe(consumer, Items.BLACK_DYE, RuBlocks.DORCEL.get(), "black_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_BLUE_DYE, RuBlocks.FELICIA_DAISY.get(), "light_blue_dye");
        oneToOneConversionRecipe(consumer, Items.MAGENTA_DYE, RuBlocks.FIREWEED.get(), "magenta_dye");
        oneToOneConversionRecipe(consumer, Items.PURPLE_DYE, RuBlocks.HYSSOP.get(), "purple_dye");
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RuBlocks.PINK_LUPINE.get(), "pink_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.POPPY_BUSH.get(), "red_dye");
        oneToOneConversionRecipe(consumer, Items.PURPLE_DYE, RuBlocks.PURPLE_LUPINE.get(), "purple_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.RED_LUPINE.get(), "red_dye");
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.WARATAH.get(), "red_dye");
        oneToOneConversionRecipe(consumer, Items.WHITE_DYE, RuBlocks.WHITE_TRILLIUM.get(), "white_dye");
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RuBlocks.WILTING_TRILLIUM.get(), "brown_dye");
        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RuBlocks.YELLOW_LUPINE.get(), "yellow_dye");

        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RuBlocks.PINK_SAKURA_FLOWERS.get(), "pink_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.PINK_SAKURA_FLOWERS.get(), 6).define('#', RuBlocks.PINK_SAKURA_LEAVES.get()).pattern("###").group("multiface_flowers").unlockedBy("has_pink_sakura_leaves", has(RuBlocks.PINK_SAKURA_LEAVES.get())).save(consumer);
        oneToOneConversionRecipe(consumer, Items.RED_DYE, RuBlocks.RED_SAKURA_FLOWERS.get(), "red_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.RED_SAKURA_FLOWERS.get(), 6).define('#', RuBlocks.RED_SAKURA_LEAVES.get()).pattern("###").group("multiface_flowers").unlockedBy("has_red_sakura_leaves", has(RuBlocks.RED_SAKURA_LEAVES.get())).save(consumer);
        oneToOneConversionRecipe(consumer, Items.WHITE_DYE, RuBlocks.WHITE_SAKURA_FLOWERS.get(), "white_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.WHITE_SAKURA_FLOWERS.get(), 6).define('#', RuBlocks.WHITE_SAKURA_LEAVES.get()).pattern("###").group("multiface_flowers").unlockedBy("has_white_sakura_leaves", has(RuBlocks.WHITE_SAKURA_LEAVES.get())).save(consumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(RuBlocks.BARLEY.get()), RecipeCategory.FOOD, Items.BREAD, 0.35F, 200).unlockedBy("has_barley", has(RuBlocks.BARLEY.get())).save(consumer, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "barley_smelting"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(RuBlocks.BARLEY.get()), RecipeCategory.FOOD, Items.BREAD, 0.35F, 100).unlockedBy("has_barley", has(RuBlocks.BARLEY.get())).save(consumer, new ResourceLocation(RegionsUnexploredMod.MOD_ID, "barley_smoking"));
        oneToOneConversionRecipe(consumer, Items.BROWN_DYE, RuBlocks.CATTAIL.get(), "brown_dye");
        oneToOneConversionRecipe(consumer, Items.LIGHT_GRAY_DYE, RuBlocks.TASSEL.get(), "light_gray_dye");
        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RuBlocks.TSUBAKI.get(), "orange_dye");

        oneToOneConversionRecipe(consumer, Blocks.ACACIA_SAPLING, RuBlocks.ACACIA_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.BIRCH_SAPLING, RuBlocks.BIRCH_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.BAOBAB_SAPLING.get(), RuBlocks.BAOBAB_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.BLACKWOOD_SAPLING.get(), RuBlocks.BLACKWOOD_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Items.MAGENTA_DYE, RuBlocks.CACTUS_FLOWER.get(), "magenta_dye");
        oneToOneConversionRecipe(consumer, RuBlocks.SAKURA_SAPLING.get(), RuBlocks.SAKURA_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.CYPRESS_SAPLING.get(), RuBlocks.CYPRESS_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.DARK_OAK_SAPLING, RuBlocks.DARK_OAK_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.DEAD_PINE_SAPLING.get(), RuBlocks.DEAD_PINE_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.DEAD_SAPLING.get(), RuBlocks.DEAD_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.EUCALYPTUS_SAPLING.get(), RuBlocks.EUCALYPTUS_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.FLOWERING_SAPLING.get(), RuBlocks.FLOWERING_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.GOLDEN_LARCH_SAPLING.get(), RuBlocks.GOLDEN_LARCH_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.JOSHUA_SAPLING.get(), RuBlocks.JOSHUA_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.JUNGLE_SAPLING, RuBlocks.JUNGLE_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.LARCH_SAPLING.get(), RuBlocks.LARCH_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.MANGROVE_PROPAGULE, RuBlocks.MANGROVE_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.MAPLE_SAPLING.get(), RuBlocks.MAPLE_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.MAUVE_SAPLING.get(), RuBlocks.MAUVE_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.OAK_SAPLING, RuBlocks.OAK_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.ORANGE_MAPLE_SAPLING.get(), RuBlocks.ORANGE_MAPLE_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.PALM_SAPLING.get(), RuBlocks.PALM_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.PINE_SAPLING.get(), RuBlocks.PINE_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.PINK_SAKURA_SAPLING.get(), RuBlocks.PINK_SAKURA_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.REDWOOD_SAPLING.get(), RuBlocks.REDWOOD_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.RED_SAKURA_SAPLING.get(), RuBlocks.RED_SAKURA_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.RED_MAPLE_SAPLING.get(), RuBlocks.RED_MAPLE_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.SILVER_BIRCH_SAPLING.get(), RuBlocks.SILVER_BIRCH_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, Blocks.SPRUCE_SAPLING, RuBlocks.SPRUCE_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.WHITE_SAKURA_SAPLING.get(), RuBlocks.WHITE_SAKURA_SHRUB.get(), "saplings", 2);
        oneToOneConversionRecipe(consumer, RuBlocks.WILLOW_SAPLING.get(), RuBlocks.WILLOW_SHRUB.get(), "saplings", 2);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.ACACIA_SHRUB.get(), 1).define('#', Blocks.ACACIA_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_acacia_sapling", has(Blocks.ACACIA_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BAOBAB_SHRUB.get(), 1).define('#', RuBlocks.BAOBAB_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_baobab_sapling", has(RuBlocks.BAOBAB_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BIRCH_SHRUB.get(), 1).define('#', Blocks.BIRCH_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_birch_sapling", has(Blocks.BIRCH_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.BLACKWOOD_SHRUB.get(), 1).define('#', RuBlocks.BLACKWOOD_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_blackwood_sapling", has(RuBlocks.BLACKWOOD_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.SAKURA_SHRUB.get(), 1).define('#', RuBlocks.SAKURA_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_sakura_sapling", has(RuBlocks.SAKURA_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.CYPRESS_SHRUB.get(), 1).define('#', RuBlocks.CYPRESS_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_cypress_sapling", has(RuBlocks.CYPRESS_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.DARK_OAK_SHRUB.get(), 1).define('#', Blocks.DARK_OAK_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_dark_oak_sapling", has(Blocks.DARK_OAK_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.DEAD_PINE_SHRUB.get(), 1).define('#', RuBlocks.DEAD_PINE_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_dead_pine_sapling", has(RuBlocks.DEAD_PINE_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.DEAD_SHRUB.get(), 1).define('#', RuBlocks.DEAD_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_dead_sapling", has(RuBlocks.DEAD_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.EUCALYPTUS_SHRUB.get(), 1).define('#', RuBlocks.EUCALYPTUS_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_eucalyptus_sapling", has(RuBlocks.EUCALYPTUS_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.FLOWERING_SHRUB.get(), 1).define('#', RuBlocks.FLOWERING_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_flowering_sapling", has(RuBlocks.FLOWERING_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.GOLDEN_LARCH_SHRUB.get(), 1).define('#', RuBlocks.GOLDEN_LARCH_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_golden_larch_sapling", has(RuBlocks.GOLDEN_LARCH_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.JOSHUA_SHRUB.get(), 1).define('#', RuBlocks.JOSHUA_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_joshua_sapling", has(RuBlocks.JOSHUA_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.JUNGLE_SHRUB.get(), 1).define('#', Blocks.JUNGLE_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_jungle_sapling", has(Blocks.JUNGLE_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.LARCH_SHRUB.get(), 1).define('#', RuBlocks.LARCH_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_larch_sapling", has(RuBlocks.LARCH_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.MANGROVE_SHRUB.get(), 1).define('#', Blocks.MANGROVE_PROPAGULE).pattern("#").pattern("#").group("shrubs").unlockedBy("has_mangrove_propagule", has(Blocks.MANGROVE_PROPAGULE)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.MAPLE_SHRUB.get(), 1).define('#', RuBlocks.MAPLE_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_maple_sapling", has(RuBlocks.MAPLE_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.MAUVE_SHRUB.get(), 1).define('#', RuBlocks.MAUVE_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_mauve_sapling", has(RuBlocks.MAUVE_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.OAK_SHRUB.get(), 1).define('#', Blocks.OAK_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_oak_sapling", has(Blocks.OAK_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.ORANGE_MAPLE_SHRUB.get(), 1).define('#', RuBlocks.ORANGE_MAPLE_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_orange_maple_sapling", has(RuBlocks.ORANGE_MAPLE_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.PALM_SHRUB.get(), 1).define('#', RuBlocks.PALM_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_palm_sapling", has(RuBlocks.PALM_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.PINE_SHRUB.get(), 1).define('#', RuBlocks.PINE_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_pine_sapling", has(RuBlocks.PINE_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.PINK_SAKURA_SHRUB.get(), 1).define('#', RuBlocks.PINK_SAKURA_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_pink_sakura_sapling", has(RuBlocks.PINK_SAKURA_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.REDWOOD_SHRUB.get(), 1).define('#', RuBlocks.REDWOOD_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_redwood_sapling", has(RuBlocks.REDWOOD_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.RED_SAKURA_SHRUB.get(), 1).define('#', RuBlocks.RED_SAKURA_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_red_sakura_sapling", has(RuBlocks.RED_SAKURA_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.RED_MAPLE_SHRUB.get(), 1).define('#', RuBlocks.RED_MAPLE_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_red_maple_sapling", has(RuBlocks.RED_MAPLE_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.SILVER_BIRCH_SHRUB.get(), 1).define('#', RuBlocks.SILVER_BIRCH_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_silver_birch_sapling", has(RuBlocks.SILVER_BIRCH_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.SPRUCE_SHRUB.get(), 1).define('#', Blocks.SPRUCE_SAPLING).pattern("#").pattern("#").group("shrubs").unlockedBy("has_spruce_sapling", has(Blocks.SPRUCE_SAPLING)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.WHITE_SAKURA_SHRUB.get(), 1).define('#', RuBlocks.WHITE_SAKURA_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_white_sakura_sapling", has(RuBlocks.WHITE_SAKURA_SAPLING.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.WILLOW_SHRUB.get(), 1).define('#', RuBlocks.WILLOW_SAPLING.get()).pattern("#").pattern("#").group("shrubs").unlockedBy("has_willow_sapling", has(RuBlocks.WILLOW_SAPLING.get())).save(consumer);

        oneToOneConversionRecipe(consumer, RuBlocks.BLUE_BIOSHROOM.get(), RuBlocks.TALL_BLUE_BIOSHROOM.get(), "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.BLUE_DYE, RuBlocks.BLUE_BIOSHROOM.get(), "blue_dye");
        oneToOneConversionRecipe(consumer, RuBlocks.GREEN_BIOSHROOM.get(), RuBlocks.TALL_GREEN_BIOSHROOM.get(), "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.LIME_DYE, RuBlocks.GREEN_BIOSHROOM.get(), "lime_dye");
        oneToOneConversionRecipe(consumer, RuBlocks.PINK_BIOSHROOM.get(), RuBlocks.TALL_PINK_BIOSHROOM.get(), "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.PINK_DYE, RuBlocks.PINK_BIOSHROOM.get(), "pink_dye");
        oneToOneConversionRecipe(consumer, RuBlocks.YELLOW_BIOSHROOM.get(), RuBlocks.TALL_YELLOW_BIOSHROOM.get(), "bioshrooms", 2);
        oneToOneConversionRecipe(consumer, Items.YELLOW_DYE, RuBlocks.TALL_YELLOW_BIOSHROOM.get(), "yellow_dye");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.TALL_BLUE_BIOSHROOM.get(), 1).define('#', RuBlocks.BLUE_BIOSHROOM.get()).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_blue_bioshroom", has(RuBlocks.BLUE_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.TALL_GREEN_BIOSHROOM.get(), 1).define('#', RuBlocks.GREEN_BIOSHROOM.get()).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_green_bioshroom", has(RuBlocks.GREEN_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.TALL_PINK_BIOSHROOM.get(), 1).define('#', RuBlocks.PINK_BIOSHROOM.get()).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_pink_bioshroom", has(RuBlocks.PINK_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, RuBlocks.TALL_YELLOW_BIOSHROOM.get(), 1).define('#', RuBlocks.YELLOW_BIOSHROOM.get()).pattern("#").pattern("#").group("bioshrooms").unlockedBy("has_yellow_bioshroom", has(RuBlocks.YELLOW_BIOSHROOM.get())).save(consumer);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(RuBlocks.BARREL_CACTUS.get()), RecipeCategory.MISC, Items.GREEN_DYE, 1.0F, 200).group("cactus").unlockedBy("has_barrel_cactus", has(RuBlocks.BARREL_CACTUS.get())).save(consumer, new ResourceLocation(RegionsUnexploredMod.MOD_ID, getConversionRecipeName(Items.GREEN_DYE, RuBlocks.BARREL_CACTUS.get())));
        oneToOneConversionRecipe(consumer, Items.ORANGE_DYE, RuBlocks.CAVE_HYSSOP.get(), "orange_dye");

        /*-----------------PLANT_BLOCKS-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.BLUE_BIOSHROOM_BLOCK.get(), 1).define('#', RuBlocks.BLUE_BIOSHROOM.get()).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_blue_bioshroom", has(RuBlocks.BLUE_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get(), 1).define('#', RuBlocks.BLUE_BIOSHROOM_BLOCK.get()).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_blue_bioshroom_block", has(RuBlocks.BLUE_BIOSHROOM_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GREEN_BIOSHROOM_BLOCK.get(), 1).define('#', RuBlocks.GREEN_BIOSHROOM.get()).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_green_bioshroom", has(RuBlocks.GREEN_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get(), 1).define('#', RuBlocks.GREEN_BIOSHROOM_BLOCK.get()).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_green_bioshroom_block", has(RuBlocks.GREEN_BIOSHROOM_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.PINK_BIOSHROOM_BLOCK.get(), 1).define('#', RuBlocks.PINK_BIOSHROOM.get()).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_pink_bioshroom", has(RuBlocks.PINK_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get(), 1).define('#', RuBlocks.PINK_BIOSHROOM_BLOCK.get()).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_pink_bioshroom_block", has(RuBlocks.PINK_BIOSHROOM_BLOCK.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.YELLOW_BIOSHROOM_BLOCK.get(), 1).define('#', RuBlocks.YELLOW_BIOSHROOM.get()).pattern("##").pattern("##").group("bioshroom_blocks").unlockedBy("has_yellow_bioshroom", has(RuBlocks.YELLOW_BIOSHROOM.get())).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get(), 1).define('#', RuBlocks.YELLOW_BIOSHROOM_BLOCK.get()).define('X', Blocks.GLOWSTONE).pattern(" # ").pattern("#X#").pattern(" # ").group("bioshroom_blocks").unlockedBy("has_yellow_bioshroom_block", has(RuBlocks.YELLOW_BIOSHROOM_BLOCK.get())).save(consumer);

        //TODO:BAMBOO_RECIPES
        //-----------BAMBOO_LOG;
        //-----------STRIPPED_BAMBOO_LOG;

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(RuBlocks.SAGUARO_CACTUS.get()), RecipeCategory.MISC, Items.GREEN_DYE, 1.0F, 200).group("cactus").unlockedBy("has_saguaro_cactus", has(RuBlocks.SAGUARO_CACTUS.get())).save(consumer, new ResourceLocation(RegionsUnexploredMod.MOD_ID, getConversionRecipeName(Items.GREEN_DYE, RuBlocks.SAGUARO_CACTUS.get())));

        /*-----------------BRANCHES-----------------*/
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.ACACIA_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.BAOBAB_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.BIRCH_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.BLACKWOOD_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.SAKURA_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.CYPRESS_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.DARK_OAK_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.DEAD_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.EUCALYPTUS_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.JOSHUA_BEARD.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.JUNGLE_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.LARCH_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.MANGROVE_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.MAPLE_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.MAUVE_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.OAK_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.PALM_BEARD.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.PINE_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.REDWOOD_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.SPRUCE_BRANCH.get(), "branches", 4);
        oneToOneConversionRecipe(consumer, Items.STICK, RuBlocks.WILLOW_BRANCH.get(), "branches", 4);

        /*-----------------DIRT_BLOCKS-----------------*/
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.FOREST_COARSE_DIRT.get(), 4).define('D', RuBlocks.FOREST_DIRT.get()).define('G', Blocks.GRAVEL).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_gravel", has(Blocks.GRAVEL)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.PLAINS_COARSE_DIRT.get(), 4).define('D', RuBlocks.PLAINS_DIRT.get()).define('G', Blocks.GRAVEL).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_gravel", has(Blocks.GRAVEL)).save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.ASHEN_DIRT.get(), 4).define('D', Blocks.DIRT).define('G', RuTags.ASH_ITEM).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_ash", has(RuTags.ASH_ITEM)).save(consumer, new ResourceLocation(RegionsUnexploredMod.MOD_ID, getConversionRecipeName(RuBlocks.ASHEN_DIRT.get(), Blocks.DIRT)));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.ASHEN_DIRT.get(), 4).define('D', RuBlocks.FOREST_DIRT.get()).define('G', RuTags.ASH_ITEM).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_ash", has(RuTags.ASH_ITEM)).save(consumer, new ResourceLocation(RegionsUnexploredMod.MOD_ID, getConversionRecipeName(RuBlocks.ASHEN_DIRT.get(), RuBlocks.FOREST_DIRT.get())));
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.ASHEN_DIRT.get(), 4).define('D', RuBlocks.PLAINS_DIRT.get()).define('G', RuTags.ASH_ITEM).pattern("DG").pattern("GD").group("coarse_dirt").unlockedBy("has_ash", has(RuTags.ASH_ITEM)).save(consumer, new ResourceLocation(RegionsUnexploredMod.MOD_ID, getConversionRecipeName(RuBlocks.ASHEN_DIRT.get(), RuBlocks.PLAINS_DIRT.get())));

        /*-----------------STONE_BLOCKS-----------------*/
        //CHALKS
        //-----------CHALK;
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, RuBlocks.CHALK_GRASS_BLOCK.get(), 1).define('#', RuBlocks.CHALK.get()).define('X', RuTags.GRASS_ITEM).pattern("X").pattern("#").group("stone_grass").unlockedBy("has_chalk", has(RuBlocks.CHALK.get())).save(consumer);
        //-----------CHALK_BRICKS;
        //-----------CHALK_BRICK_SLAB;
        //-----------CHALK_BRICK_STAIRS;
        //-----------CHALK_PILLAR;
        //-----------CHALK_SLAB;
        //-----------CHALK_STAIRS;
        //-----------POLISHED_CHALK;
        //-----------POLISHED_CHALK_SLAB;
        //-----------POLISHED_CHALK_STAIRS;
        //MOSSY_STONES
        //-----------MOSSY_STONE;

        /*-----------------OCEAN_BLOCKS-----------------*/
        //HYACINTH_BLOCKS
        //-----------HYACINTH_BLOOM;
        //-----------HYACINTH_FLOWERS;
        //-----------HYACINTH_SEAGRASS;
        //-----------HYACINTH_STONE;
        //-----------TALL_HYACINTH_STOCK;
        //ASHEN_BLOCKS
        //-----------ASHEN_DIRT;
        //-----------ASHEN_SHRUB;
        //-----------ASHEN_LEAVES;
        //-----------ASHEN_GRASS;

        /*-----------------OTHER_BLOCKS-----------------*/
        //-----------ASH;
        //-----------VOLCANIC_ASH;
        //-----------ASH_VENT;
        //-----------QUICKSAND;

        /*-----------------WOOD_TYPES-----------------*/
        //ASHEN_BLOCKS
        //-----------ASHEN_LOG;
        //-----------ASHEN_WOOD;
        //SILVER_BIRCH_BLOCKS
        //-----------SILVER_BIRCH_LOG;
        //-----------SILVER_BIRCH_WOOD;
        //ALPHA_BLOCKS
        //-----------ALPHA_LOG;
        //-----------ALPHA_PLANKS;
        //-----------ALPHA_STAIRS;
        //-----------ALPHA_SLAB;
        //BAOBAB_BLOCKS
        //-----------BAOBAB_LOG;
        //-----------STRIPPED_BAOBAB_LOG;
        //-----------BAOBAB_WOOD;
        //-----------STRIPPED_BAOBAB_WOOD;
        //-----------BAOBAB_PLANKS;
        //-----------BAOBAB_STAIRS;
        //-----------BAOBAB_SLAB;
        //-----------BAOBAB_FENCE;
        //-----------BAOBAB_DOOR;
        //-----------BAOBAB_FENCE_GATE;
        //-----------BAOBAB_TRAPDOOR;
        //-----------BAOBAB_PRESSURE_PLATE;
        //-----------BAOBAB_BUTTON;
        //-----------BAOBAB_SIGN;
        //-----------BAOBAB_WALL_SIGN;
        //BLACKWOOD_BLOCKS
        //-----------BLACKWOOD_LOG;
        //-----------STRIPPED_BLACKWOOD_LOG;
        //-----------BLACKWOOD_WOOD;
        //-----------STRIPPED_BLACKWOOD_WOOD;
        //-----------BLACKWOOD_PLANKS;
        //-----------BLACKWOOD_STAIRS;
        //-----------BLACKWOOD_SLAB;
        //-----------BLACKWOOD_FENCE;
        //-----------BLACKWOOD_DOOR;
        //-----------BLACKWOOD_FENCE_GATE;
        //-----------BLACKWOOD_TRAPDOOR;
        //-----------BLACKWOOD_PRESSURE_PLATE;
        //-----------BLACKWOOD_BUTTON;
        //-----------BLACKWOOD_SIGN;
        //-----------BLACKWOOD_WALL_SIGN;
        //BRIMWOOD_BLOCKS
        //-----------BRIMWOOD_LOG;
        //-----------BRIMWOOD_LOG_MAGMA;
        //-----------STRIPPED_BRIMWOOD_LOG;
        //-----------BRIMWOOD_WOOD;
        //-----------STRIPPED_BRIMWOOD_WOOD;
        //-----------BRIMWOOD_PLANKS;
        //-----------BRIMWOOD_STAIRS;
        //-----------BRIMWOOD_SLAB;
        //-----------BRIMWOOD_FENCE;
        //-----------BRIMWOOD_DOOR;
        //-----------BRIMWOOD_FENCE_GATE;
        //-----------BRIMWOOD_TRAPDOOR;
        //-----------BRIMWOOD_PRESSURE_PLATE;
        //-----------BRIMWOOD_BUTTON;
        //-----------BRIMWOOD_SIGN;
        //-----------BRIMWOOD_WALL_SIGN;
        //SAKURA_BLOCKS
        //-----------SAKURA_LOG;
        //-----------STRIPPED_SAKURA_LOG;
        //-----------SAKURA_WOOD;
        //-----------STRIPPED_SAKURA_WOOD;
        //-----------SAKURA_PLANKS;
        //-----------SAKURA_STAIRS;
        //-----------SAKURA_SLAB;
        //-----------SAKURA_FENCE;
        //-----------SAKURA_DOOR;
        //-----------SAKURA_FENCE_GATE;
        //-----------SAKURA_TRAPDOOR;
        //-----------SAKURA_PRESSURE_PLATE;
        //-----------SAKURA_BUTTON;
        //-----------SAKURA_SIGN;
        //-----------SAKURA_WALL_SIGN;
        //CYPRESS_BLOCKS
        //-----------CYPRESS_LOG;
        //-----------STRIPPED_CYPRESS_LOG;
        //-----------CYPRESS_WOOD;
        //-----------STRIPPED_CYPRESS_WOOD;
        //-----------CYPRESS_PLANKS;
        //-----------CYPRESS_STAIRS;
        //-----------CYPRESS_SLAB;
        //-----------CYPRESS_FENCE;
        //-----------CYPRESS_DOOR;
        //-----------CYPRESS_FENCE_GATE;
        //-----------CYPRESS_TRAPDOOR;
        //-----------CYPRESS_PRESSURE_PLATE;
        //-----------CYPRESS_BUTTON;
        //-----------CYPRESS_SIGN;
        //-----------CYPRESS_WALL_SIGN;
        //DEAD_BLOCKS
        //-----------DEAD_LOG;
        //-----------STRIPPED_DEAD_LOG;
        //-----------DEAD_WOOD;
        //-----------STRIPPED_DEAD_WOOD;
        //-----------DEAD_PLANKS;
        //-----------DEAD_STAIRS;
        //-----------DEAD_SLAB;
        //-----------DEAD_FENCE;
        //-----------DEAD_DOOR;
        //-----------DEAD_FENCE_GATE;
        //-----------DEAD_TRAPDOOR;
        //-----------DEAD_PRESSURE_PLATE;
        //-----------DEAD_BUTTON;
        //-----------DEAD_SIGN;
        //-----------DEAD_WALL_SIGN;
        //EUCALYPTUS_BLOCKS
        //-----------EUCALYPTUS_LOG;
        //-----------STRIPPED_EUCALYPTUS_LOG;
        //-----------EUCALYPTUS_WOOD;
        //-----------STRIPPED_EUCALYPTUS_WOOD;
        //-----------EUCALYPTUS_PLANKS;
        //-----------EUCALYPTUS_STAIRS;
        //-----------EUCALYPTUS_SLAB;
        //-----------EUCALYPTUS_FENCE;
        //-----------EUCALYPTUS_DOOR;
        //-----------EUCALYPTUS_FENCE_GATE;
        //-----------EUCALYPTUS_TRAPDOOR;
        //-----------EUCALYPTUS_PRESSURE_PLATE;
        //-----------EUCALYPTUS_BUTTON;
        //-----------EUCALYPTUS_SIGN;
        //-----------EUCALYPTUS_WALL_SIGN;
        //JOSHUA_BLOCKS
        //-----------JOSHUA_LOG;
        //-----------STRIPPED_JOSHUA_LOG;
        //-----------JOSHUA_WOOD;
        //-----------STRIPPED_JOSHUA_WOOD;
        //-----------JOSHUA_PLANKS;
        //-----------JOSHUA_STAIRS;
        //-----------JOSHUA_SLAB;
        //-----------JOSHUA_FENCE;
        //-----------JOSHUA_DOOR;
        //-----------JOSHUA_FENCE_GATE;
        //-----------JOSHUA_TRAPDOOR;
        //-----------JOSHUA_PRESSURE_PLATE;
        //-----------JOSHUA_BUTTON;
        //-----------JOSHUA_SIGN;
        //-----------JOSHUA_WALL_SIGN;
        //LARCH_BLOCKS
        //-----------LARCH_LOG;
        //-----------STRIPPED_LARCH_LOG;
        //-----------LARCH_WOOD;
        //-----------STRIPPED_LARCH_WOOD;
        //-----------LARCH_PLANKS;
        //-----------LARCH_STAIRS;
        //-----------LARCH_SLAB;
        //-----------LARCH_FENCE;
        //-----------LARCH_DOOR;
        //-----------LARCH_FENCE_GATE;
        //-----------LARCH_TRAPDOOR;
        //-----------LARCH_PRESSURE_PLATE;
        //-----------LARCH_BUTTON;
        //-----------LARCH_SIGN;
        //-----------LARCH_WALL_SIGN;
        //MAPLE_BLOCKS
        //-----------MAPLE_LOG;
        //-----------STRIPPED_MAPLE_LOG;
        //-----------MAPLE_WOOD;
        //-----------STRIPPED_MAPLE_WOOD;
        //-----------MAPLE_PLANKS;
        //-----------MAPLE_STAIRS;
        //-----------MAPLE_SLAB;
        //-----------MAPLE_FENCE;
        //-----------MAPLE_DOOR;
        //-----------MAPLE_FENCE_GATE;
        //-----------MAPLE_TRAPDOOR;
        //-----------MAPLE_PRESSURE_PLATE;
        //-----------MAPLE_BUTTON;
        //-----------MAPLE_SIGN;
        //-----------MAPLE_WALL_SIGN;
        //MAUVE_BLOCKS
        //-----------MAUVE_LOG;
        //-----------STRIPPED_MAUVE_LOG;
        //-----------MAUVE_WOOD;
        //-----------STRIPPED_MAUVE_WOOD;
        //-----------MAUVE_PLANKS;
        //-----------MAUVE_STAIRS;
        //-----------MAUVE_SLAB;
        //-----------MAUVE_FENCE;
        //-----------MAUVE_DOOR;
        //-----------MAUVE_FENCE_GATE;
        //-----------MAUVE_TRAPDOOR;
        //-----------MAUVE_PRESSURE_PLATE;
        //-----------MAUVE_BUTTON;
        //-----------MAUVE_SIGN;
        //-----------MAUVE_WALL_SIGN;
        //PALM_BLOCKS
        //-----------PALM_LOG;
        //-----------STRIPPED_PALM_LOG;
        //-----------PALM_WOOD;
        //-----------STRIPPED_PALM_WOOD;
        //-----------PALM_PLANKS;
        //-----------PALM_STAIRS;
        //-----------PALM_SLAB;
        //-----------PALM_FENCE;
        //-----------PALM_DOOR;
        //-----------PALM_FENCE_GATE;
        //-----------PALM_TRAPDOOR;
        //-----------PALM_PRESSURE_PLATE;
        //-----------PALM_BUTTON;
        //-----------PALM_SIGN;
        //-----------PALM_WALL_SIGN;
        //PINE_BLOCKS
        //-----------PINE_LOG;
        //-----------PINE_LOG_TRANSITION;
        //-----------STRIPPED_PINE_LOG;
        //-----------PINE_WOOD;
        //-----------STRIPPED_PINE_WOOD;
        //-----------PINE_PLANKS;
        //-----------PINE_STAIRS;
        //-----------PINE_SLAB;
        //-----------PINE_FENCE;
        //-----------PINE_DOOR;
        //-----------PINE_FENCE_GATE;
        //-----------PINE_TRAPDOOR;
        //-----------PINE_PRESSURE_PLATE;
        //-----------PINE_BUTTON;
        //-----------PINE_SIGN;
        //-----------PINE_WALL_SIGN;
        //REDWOOD_BLOCKS
        //-----------REDWOOD_LOG;
        //-----------STRIPPED_REDWOOD_LOG;
        //-----------REDWOOD_WOOD;
        //-----------STRIPPED_REDWOOD_WOOD;
        //-----------REDWOOD_PLANKS;
        //-----------REDWOOD_STAIRS;
        //-----------REDWOOD_SLAB;
        //-----------REDWOOD_FENCE;
        //-----------REDWOOD_DOOR;
        //-----------REDWOOD_FENCE_GATE;
        //-----------REDWOOD_TRAPDOOR;
        //-----------REDWOOD_PRESSURE_PLATE;
        //-----------REDWOOD_BUTTON;
        //-----------REDWOOD_SIGN;
        //-----------REDWOOD_WALL_SIGN;
        //WILLOW_BLOCKS
        //-----------WILLOW_LOG;
        //-----------STRIPPED_WILLOW_LOG;
        //-----------WILLOW_WOOD;
        //-----------STRIPPED_WILLOW_WOOD;
        //-----------WILLOW_PLANKS;
        //-----------WILLOW_STAIRS;
        //-----------WILLOW_SLAB;
        //-----------WILLOW_FENCE;
        //-----------WILLOW_DOOR;
        //-----------WILLOW_FENCE_GATE;
        //-----------WILLOW_TRAPDOOR;
        //-----------WILLOW_PRESSURE_PLATE;
        //-----------WILLOW_BUTTON;
        //-----------WILLOW_SIGN;
        //-----------WILLOW_WALL_SIGN;

        /*-----------------PAINTED PLANKS-----------------*/
        //PLANKS
        //-----------RED_PAINTED_PLANKS;
        //-----------ORANGE_PAINTED_PLANKS;
        //-----------YELLOW_PAINTED_PLANKS;
        //-----------LIME_PAINTED_PLANKS;
        //-----------GREEN_PAINTED_PLANKS;
        //-----------CYAN_PAINTED_PLANKS;
        //-----------LIGHT_BLUE_PAINTED_PLANKS;
        //-----------BLUE_PAINTED_PLANKS;
        //-----------PURPLE_PAINTED_PLANKS;
        //-----------MAGENTA_PAINTED_PLANKS;
        //-----------PINK_PAINTED_PLANKS;
        //-----------BROWN_PAINTED_PLANKS;
        //-----------WHITE_PAINTED_PLANKS;
        //-----------LIGHT_GRAY_PAINTED_PLANKS;
        //-----------GRAY_PAINTED_PLANKS;
        //-----------BLACK_PAINTED_PLANKS;
        //STAIRS
        //-----------RED_PAINTED_STAIRS;
        //-----------ORANGE_PAINTED_STAIRS;
        //-----------YELLOW_PAINTED_STAIRS;
        //-----------LIME_PAINTED_STAIRS;
        //-----------GREEN_PAINTED_STAIRS;
        //-----------CYAN_PAINTED_STAIRS;
        //-----------LIGHT_BLUE_PAINTED_STAIRS;
        //-----------BLUE_PAINTED_STAIRS;
        //-----------PURPLE_PAINTED_STAIRS;
        //-----------MAGENTA_PAINTED_STAIRS;
        //-----------PINK_PAINTED_STAIRS;
        //-----------BROWN_PAINTED_STAIRS;
        //-----------WHITE_PAINTED_STAIRS;
        //-----------LIGHT_GRAY_PAINTED_STAIRS;
        //-----------GRAY_PAINTED_STAIRS;
        //-----------BLACK_PAINTED_STAIRS;
        //SLABS
        //-----------RED_PAINTED_SLAB;
        //-----------ORANGE_PAINTED_SLAB;
        //-----------YELLOW_PAINTED_SLAB;
        //-----------LIME_PAINTED_SLAB;
        //-----------GREEN_PAINTED_SLAB;
        //-----------CYAN_PAINTED_SLAB;
        //-----------LIGHT_BLUE_PAINTED_SLAB;
        //-----------BLUE_PAINTED_SLAB;
        //-----------PURPLE_PAINTED_SLAB;
        //-----------MAGENTA_PAINTED_SLAB;
        //-----------PINK_PAINTED_SLAB;
        //-----------BROWN_PAINTED_SLAB;
        //-----------WHITE_PAINTED_SLAB;
        //-----------LIGHT_GRAY_PAINTED_SLAB;
        //-----------GRAY_PAINTED_SLAB;
        //-----------BLACK_PAINTED_SLAB;

        /*-----------------NETHER_BLOCKS-----------------*/
        //NETHER_STONES
        //-----------BLACKSTONE_CLUSTER;
        //-----------MARROWSTONE;
        //BRIMSPROUT_BLOCKS
        //-----------BRIMSPROUT_NYLIUM;
        //-----------BRIMSPROUT;
        //COBALT_BLOCKS
        //-----------COBALT_EARLIGHT;
        //-----------COBALT_NYLIUM;
        //-----------COBALT_OBSIDIAN;
        //-----------COBALT_ROOTS;
        //-----------HANGING_EARLIGHT;
        //-----------HANGING_EARLIGHT_PLANT;
        //GLISTERING_BLOCKS
        //-----------GLISTERING_IVY;
        //-----------GLISTERING_IVY_PLANT;
        //-----------GLISTERING_NYLIUM;
        //-----------GLISTERING_SPROUT;
        //-----------GLISTERING_WART;
        //-----------GLISTER_BULB;
        //-----------GLISTER_SPIRE;
        //MYCOTOXIC_BLOCKS
        //-----------MYCOTOXIC_DAISY;
        //-----------MYCOTOXIC_GRASS;
        //-----------MYCOTOXIC_NYLIUM;
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> consumer, List<ItemLike> itemList, RecipeCategory category, ItemLike item, float f, int i, String s) {
        oreCooking(consumer, RecipeSerializer.SMELTING_RECIPE, itemList, category, item, f, i, s, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> consumer, List<ItemLike> itemList, RecipeCategory category, ItemLike item, float f, int i, String s) {
        oreCooking(consumer, RecipeSerializer.BLASTING_RECIPE, itemList, category, item, f, i, s, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> consumer, RecipeSerializer<? extends AbstractCookingRecipe> serializer, List<ItemLike> itemList, RecipeCategory category, ItemLike item, float f, int i, String s, String s2) {
        for(ItemLike itemlike : itemList) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, item, f, i, serializer).group(s).unlockedBy(getHasName(itemlike), has(itemlike)).save(consumer, new ResourceLocation(RegionsUnexploredMod.MOD_ID, getItemName(item) + s2 + "_" + getItemName(itemlike)));
        }

    }

    protected static void oneToOneConversionRecipe(Consumer<FinishedRecipe> consumer, ItemLike item, ItemLike item2, @Nullable String group) {
        oneToOneConversionRecipe(consumer, item, item2, group, 1);
    }

    protected static void oneToOneConversionRecipe(Consumer<FinishedRecipe> consumer, ItemLike item, ItemLike item2, @Nullable String group, int ammount) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, item, ammount).requires(item2).group(group).unlockedBy(getHasName(item2), has(item2)).save(consumer, new ResourceLocation(RegionsUnexploredMod.MOD_ID, getConversionRecipeName(item, item2)));
    }
}
