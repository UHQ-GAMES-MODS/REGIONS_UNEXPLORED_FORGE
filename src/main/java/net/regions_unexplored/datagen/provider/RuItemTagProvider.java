package net.regions_unexplored.datagen.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.data.tags.RuTags;
import net.regions_unexplored.item.RuItems;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RuItemTagProvider extends ItemTagsProvider {


    public RuItemTagProvider(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, modId, existingFileHelper);
    }

    @Override
    public void addTags(HolderLookup.Provider provider) {
        addForgeTags(provider);
        //main_tags
        //this.tag(ItemTags.ACACIA_LOGS);
        //this.tag(ItemTags.ANVIL);
        //this.tag(ItemTags.ARROWS);
        //this.tag(ItemTags.AXES);
        //this.tag(ItemTags.AXOLOTL_TEMPT_ITEMS);
        //this.tag(ItemTags.BANNERS);
        //this.tag(ItemTags.BEACON_PAYMENT_ITEMS);
        //this.tag(ItemTags.BEDS);
        this.tag(ItemTags.BIRCH_LOGS)
                .add(RuBlocks.SILVER_BIRCH_LOG.get().asItem())
        ;
        this.tag(ItemTags.BOATS)
                .add(RuItems.BAOBAB_BOAT.getKey())
                .add(RuItems.BLACKWOOD_BOAT.getKey())
                .add(RuItems.BRIMWOOD_BOAT.getKey())
                .add(RuItems.CYPRESS_BOAT.getKey())
                .add(RuItems.EUCALYPTUS_BOAT.getKey())
                .add(RuItems.JOSHUA_BOAT.getKey())
                .add(RuItems.LARCH_BOAT.getKey())
                .add(RuItems.MAPLE_BOAT.getKey())
                .add(RuItems.MAUVE_BOAT.getKey())
                .add(RuItems.PALM_BOAT.getKey())
                .add(RuItems.PINE_BOAT.getKey())
                .add(RuItems.REDWOOD_BOAT.getKey())
                .add(RuItems.SAKURA_BOAT.getKey())
                .add(RuItems.WILLOW_BOAT.getKey())
        ;
        //this.tag(ItemTags.BUTTONS);
        //this.tag(ItemTags.CANDLES);
        this.tag(ItemTags.CHEST_BOATS)
                .add(RuItems.BAOBAB_CHEST_BOAT.getKey())
                .add(RuItems.BLACKWOOD_CHEST_BOAT.getKey())
                .add(RuItems.BRIMWOOD_CHEST_BOAT.getKey())
                .add(RuItems.CYPRESS_CHEST_BOAT.getKey())
                .add(RuItems.EUCALYPTUS_CHEST_BOAT.getKey())
                .add(RuItems.JOSHUA_CHEST_BOAT.getKey())
                .add(RuItems.LARCH_CHEST_BOAT.getKey())
                .add(RuItems.MAPLE_CHEST_BOAT.getKey())
                .add(RuItems.MAUVE_CHEST_BOAT.getKey())
                .add(RuItems.PALM_CHEST_BOAT.getKey())
                .add(RuItems.PINE_CHEST_BOAT.getKey())
                .add(RuItems.REDWOOD_CHEST_BOAT.getKey())
                .add(RuItems.SAKURA_CHEST_BOAT.getKey())
                .add(RuItems.WILLOW_CHEST_BOAT.getKey())
        ;
        //this.tag(ItemTags.CLUSTER_MAX_HARVESTABLES);
        //this.tag(ItemTags.COAL_ORES);
        //this.tag(ItemTags.COALS);
        //this.tag(ItemTags.COMPASSES);
        //this.tag(ItemTags.COMPLETES_FIND_TREE_TUTORIAL);
        //this.tag(ItemTags.COPPER_ORES);
        //this.tag(ItemTags.CREEPER_DROP_MUSIC_DISCS);
        //this.tag(ItemTags.CREEPER_IGNITERS);
        //this.tag(ItemTags.CRIMSON_STEMS);
        //this.tag(ItemTags.DAMPENS_VIBRATIONS);
        //this.tag(ItemTags.DARK_OAK_LOGS);
        //this.tag(ItemTags.DIAMOND_ORES);
        this.tag(ItemTags.DIRT)
                .add(RuBlocks.ALPHA_GRASS_BLOCK.get().asItem())
                .add(RuBlocks.ASHEN_DIRT.get().asItem())
                .add(RuBlocks.CHALK_GRASS_BLOCK.get().asItem())
                .add(RuBlocks.DEEPSLATE_GRASS_BLOCK.get().asItem())
                .add(RuBlocks.DEEPSLATE_PRISMOSS.get().asItem())
                .add(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get().asItem())
                .add(RuBlocks.FOREST_COARSE_DIRT.get().asItem())
                .add(RuBlocks.FOREST_DIRT.get().asItem())
                .add(RuBlocks.FOREST_DIRT_PATH.get().asItem())
                .add(RuBlocks.FOREST_FARMLAND.get().asItem())
                .add(RuBlocks.FOREST_GRASS_BLOCK.get().asItem())
                .add(RuBlocks.FOREST_MUD.get().asItem())
                .add(RuBlocks.PLAINS_COARSE_DIRT.get().asItem())
                .add(RuBlocks.PLAINS_DIRT.get().asItem())
                .add(RuBlocks.PLAINS_DIRT_PATH.get().asItem())
                .add(RuBlocks.PLAINS_FARMLAND.get().asItem())
                .add(RuBlocks.PLAINS_GRASS_BLOCK.get().asItem())
                .add(RuBlocks.PLAINS_MUD.get().asItem())
                .add(RuBlocks.PRISMOSS.get().asItem())
                .add(RuBlocks.STONE_GRASS_BLOCK.get().asItem())
                .add(RuBlocks.VIRIDESCENT_NYLIUM.get().asItem())
        ;
        //this.tag(ItemTags.DOORS);
        //this.tag(ItemTags.EMERALD_ORES);
        this.tag(ItemTags.FENCE_GATES)
                .add(RuBlocks.BAOBAB_FENCE_GATE.get().asItem())
                .add(RuBlocks.BLACKWOOD_FENCE_GATE.get().asItem())
                .add(RuBlocks.BRIMWOOD_FENCE_GATE.get().asItem())
                .add(RuBlocks.CYPRESS_FENCE_GATE.get().asItem())
                .add(RuBlocks.DEAD_FENCE_GATE.get().asItem())
                .add(RuBlocks.EUCALYPTUS_FENCE_GATE.get().asItem())
                .add(RuBlocks.JOSHUA_FENCE_GATE.get().asItem())
                .add(RuBlocks.LARCH_FENCE_GATE.get().asItem())
                .add(RuBlocks.MAPLE_FENCE_GATE.get().asItem())
                .add(RuBlocks.MAUVE_FENCE_GATE.get().asItem())
                .add(RuBlocks.PALM_FENCE_GATE.get().asItem())
                .add(RuBlocks.PINE_FENCE_GATE.get().asItem())
                .add(RuBlocks.REDWOOD_FENCE_GATE.get().asItem())
                .add(RuBlocks.SAKURA_FENCE_GATE.get().asItem())
                .add(RuBlocks.WILLOW_FENCE_GATE.get().asItem())
        ;
        //this.tag(ItemTags.FENCES);
        //this.tag(ItemTags.FISHES);
        this.tag(ItemTags.FLOWERS)
                .add(RuBlocks.HYACINTH_FLOWERS.get().asItem())
                .add(RuBlocks.ORANGE_CONEFLOWER.get().asItem())
                .add(RuBlocks.SAKURA_PETALS.get().asItem())
                .add(RuBlocks.PINK_SAKURA_FLOWERS.get().asItem())
                .add(RuBlocks.RED_SAKURA_FLOWERS.get().asItem())
                .add(RuBlocks.WHITE_SAKURA_FLOWERS.get().asItem())
        ;
        this.tag(ItemTags.FOX_FOOD)
                .add(RuItems.SALMONBERRY.getKey())
        ;
        //this.tag(ItemTags.FREEZE_IMMUNE_WEARABLES);
        //this.tag(ItemTags.GOLD_ORES);
        //this.tag(ItemTags.HOES);
        //this.tag(ItemTags.IGNORED_BY_PIGLIN_BABIES);
        //this.tag(ItemTags.IRON_ORES);
        //this.tag(ItemTags.JUNGLE_LOGS);
        //this.tag(ItemTags.LAPIS_ORES);
        this.tag(ItemTags.LEAVES)
                .add(RuBlocks.ALPHA_LEAVES.get().asItem())
                .add(RuBlocks.APPLE_OAK_LEAVES.get().asItem())
                .add(RuBlocks.ASHEN_LEAVES.get().asItem())
                .add(RuBlocks.BAMBOO_LEAVES.get().asItem())
                .add(RuBlocks.BAOBAB_LEAVES.get().asItem())
                .add(RuBlocks.BLACKWOOD_LEAVES.get().asItem())
                .add(RuBlocks.BRIMWOOD_LEAVES.get().asItem())
                .add(RuBlocks.CYPRESS_LEAVES.get().asItem())
                .add(RuBlocks.DEAD_LEAVES.get().asItem())
                .add(RuBlocks.DEAD_PINE_LEAVES.get().asItem())
                .add(RuBlocks.EUCALYPTUS_LEAVES.get().asItem())
                .add(RuBlocks.FLOWERING_LEAVES.get().asItem())
                .add(RuBlocks.GOLDEN_LARCH_LEAVES.get().asItem())
                .add(RuBlocks.JOSHUA_LEAVES.get().asItem())
                .add(RuBlocks.LARCH_LEAVES.get().asItem())
                .add(RuBlocks.MAPLE_LEAVES.get().asItem())
                .add(RuBlocks.MAUVE_LEAVES.get().asItem())
                .add(RuBlocks.ORANGE_MAPLE_LEAVES.get().asItem())
                .add(RuBlocks.PALM_LEAVES.get().asItem())
                .add(RuBlocks.PINE_LEAVES.get().asItem())
                .add(RuBlocks.PINK_SAKURA_LEAVES.get().asItem())
                .add(RuBlocks.REDWOOD_LEAVES.get().asItem())
                .add(RuBlocks.RED_MAPLE_LEAVES.get().asItem())
                .add(RuBlocks.RED_SAKURA_LEAVES.get().asItem())
                .add(RuBlocks.SAKURA_LEAVES.get().asItem())
                .add(RuBlocks.SILVER_BIRCH_LEAVES.get().asItem())
                .add(RuBlocks.SPANISH_MOSS.get().asItem())
                .add(RuBlocks.SPANISH_MOSS_PLANT.get().asItem())
                .add(RuBlocks.WHITE_SAKURA_LEAVES.get().asItem())
                .add(RuBlocks.WILLOW_LEAVES.get().asItem())
        ;
        //this.tag(ItemTags.LECTERN_BOOKS);
        this.tag(ItemTags.LOGS)
                .addTags(RuTags.BAMBOO_LOGS_ITEM)
                .addTags(RuTags.BAOBAB_LOGS_ITEM)
                .addTags(RuTags.BRIMWOOD_LOGS_ITEM)
                .addTags(RuTags.BLACKWOOD_LOGS_ITEM)
                .addTags(RuTags.SAKURA_LOGS_ITEM)
                .addTags(RuTags.CYPRESS_LOGS_ITEM)
                .addTags(RuTags.DEAD_LOGS_ITEM)
                .addTags(RuTags.EUCALYPTUS_LOGS_ITEM)
                .addTags(RuTags.JOSHUA_LOGS_ITEM)
                .addTags(RuTags.LARCH_LOGS_ITEM)
                .addTags(RuTags.MAPLE_LOGS_ITEM)
                .addTags(RuTags.MAUVE_LOGS_ITEM)
                .addTags(RuTags.PALM_LOGS_ITEM)
                .addTags(RuTags.PINE_LOGS_ITEM)
                .addTags(RuTags.REDWOOD_LOGS_ITEM)
                .addTags(RuTags.WILLOW_LOGS_ITEM)
                .add(RuBlocks.ALPHA_LOG.get().asItem())
        ;
        this.tag(ItemTags.LOGS_THAT_BURN)
                .addTags(RuTags.BAMBOO_LOGS_ITEM)
                .addTags(RuTags.BAOBAB_LOGS_ITEM)
                .addTags(RuTags.BLACKWOOD_LOGS_ITEM)
                .addTags(RuTags.SAKURA_LOGS_ITEM)
                .addTags(RuTags.CYPRESS_LOGS_ITEM)
                .addTags(RuTags.EUCALYPTUS_LOGS_ITEM)
                .addTags(RuTags.JOSHUA_LOGS_ITEM)
                .addTags(RuTags.LARCH_LOGS_ITEM)
                .addTags(RuTags.MAPLE_LOGS_ITEM)
                .addTags(RuTags.MAUVE_LOGS_ITEM)
                .addTags(RuTags.PALM_LOGS_ITEM)
                .addTags(RuTags.PINE_LOGS_ITEM)
                .addTags(RuTags.REDWOOD_LOGS_ITEM)
                .addTags(RuTags.WILLOW_LOGS_ITEM)
                .add(RuBlocks.ALPHA_LOG.get().asItem())
        ;
        //this.tag(ItemTags.MANGROVE_LOGS);
        //this.tag(ItemTags.MUSIC_DISCS);
        this.tag(ItemTags.NON_FLAMMABLE_WOOD)
                .add(RuBlocks.BRIMWOOD_BUTTON.get().asItem())
                .add(RuBlocks.BRIMWOOD_DOOR.get().asItem())
                .add(RuBlocks.BRIMWOOD_FENCE.get().asItem())
                .add(RuBlocks.BRIMWOOD_FENCE_GATE.get().asItem())
                .add(RuBlocks.BRIMWOOD_PLANKS.get().asItem())
                .add(RuBlocks.BRIMWOOD_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.BRIMWOOD_SLAB.get().asItem())
                .add(RuBlocks.BRIMWOOD_STAIRS.get().asItem())
                .add(RuBlocks.BRIMWOOD_TRAPDOOR.get().asItem())
                .add(RuBlocks.DEAD_BUTTON.get().asItem())
                .add(RuBlocks.DEAD_DOOR.get().asItem())
                .add(RuBlocks.DEAD_FENCE.get().asItem())
                .add(RuBlocks.DEAD_FENCE_GATE.get().asItem())
                .add(RuBlocks.DEAD_PLANKS.get().asItem())
                .add(RuBlocks.DEAD_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.DEAD_SLAB.get().asItem())
                .add(RuBlocks.DEAD_STAIRS.get().asItem())
                .add(RuBlocks.DEAD_TRAPDOOR.get().asItem())
                .add(RuItems.BRIMWOOD_SIGN.getKey())
                .add(RuItems.DEAD_SIGN.getKey())
                .addTags(RuTags.BRIMWOOD_LOGS_ITEM)
                .addTags(RuTags.DEAD_LOGS_ITEM)
        ;
        //this.tag(ItemTags.OAK_LOGS);
        //this.tag(ItemTags.PICKAXES);
        //this.tag(ItemTags.PIGLIN_FOOD);
        //this.tag(ItemTags.PIGLIN_LOVED);
        //this.tag(ItemTags.PIGLIN_REPELLENTS);
        this.tag(ItemTags.PLANKS)
                .add(RuBlocks.ALPHA_PLANKS.get().asItem())
                .add(RuBlocks.BAOBAB_PLANKS.get().asItem())
                .add(RuBlocks.BLACKWOOD_PLANKS.get().asItem())
                .add(RuBlocks.BRIMWOOD_PLANKS.get().asItem())
                .add(RuBlocks.CYPRESS_PLANKS.get().asItem())
                .add(RuBlocks.EUCALYPTUS_PLANKS.get().asItem())
                .add(RuBlocks.JOSHUA_PLANKS.get().asItem())
                .add(RuBlocks.LARCH_PLANKS.get().asItem())
                .add(RuBlocks.MAPLE_PLANKS.get().asItem())
                .add(RuBlocks.MAUVE_PLANKS.get().asItem())
                .add(RuBlocks.PALM_PLANKS.get().asItem())
                .add(RuBlocks.PINE_PLANKS.get().asItem())
                .add(RuBlocks.REDWOOD_PLANKS.get().asItem())
                .add(RuBlocks.SAKURA_PLANKS.get().asItem())
                .add(RuBlocks.WILLOW_PLANKS.get().asItem())
                .add(RuBlocks.LIGHT_GRAY_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.BLACK_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.LIGHT_BLUE_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.GRAY_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.BROWN_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.LIME_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.GREEN_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.YELLOW_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.MAGENTA_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.BLUE_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.RED_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.CYAN_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.WHITE_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.PURPLE_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.PINK_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.ORANGE_PAINTED_PLANKS.get().asItem())
        ;
        //this.tag(ItemTags.RAILS);
        this.tag(ItemTags.REDSTONE_ORES)
                .add(RuBlocks.RAW_REDSTONE_BLOCK.get().asItem())
        ;
        this.tag(ItemTags.SAND)
                .add(RuBlocks.QUICKSAND.get().asItem())
        ;
        this.tag(ItemTags.SAPLINGS)
                .add(RuBlocks.ALPHA_SAPLING.get().asItem())
                .add(RuBlocks.APPLE_OAK_SAPLING.get().asItem())
                .add(RuBlocks.BAMBOO_SAPLING.get().asItem())
                .add(RuBlocks.BAOBAB_SAPLING.get().asItem())
                .add(RuBlocks.BLACKWOOD_SAPLING.get().asItem())
                .add(RuBlocks.BRIMWOOD_SAPLING.get().asItem())
                .add(RuBlocks.CACTUS_FLOWER.get().asItem())
                .add(RuBlocks.CYPRESS_SAPLING.get().asItem())
                .add(RuBlocks.DEAD_PINE_SAPLING.get().asItem())
                .add(RuBlocks.DEAD_SAPLING.get().asItem())
                .add(RuBlocks.EUCALYPTUS_SAPLING.get().asItem())
                .add(RuBlocks.FLOWERING_SAPLING.get().asItem())
                .add(RuBlocks.GOLDEN_LARCH_SAPLING.get().asItem())
                .add(RuBlocks.JOSHUA_SAPLING.get().asItem())
                .add(RuBlocks.LARCH_SAPLING.get().asItem())
                .add(RuBlocks.MAPLE_SAPLING.get().asItem())
                .add(RuBlocks.MAUVE_SAPLING.get().asItem())
                .add(RuBlocks.ORANGE_MAPLE_SAPLING.get().asItem())
                .add(RuBlocks.PALM_SAPLING.get().asItem())
                .add(RuBlocks.PINE_SAPLING.get().asItem())
                .add(RuBlocks.PINK_SAKURA_SAPLING.get().asItem())
                .add(RuBlocks.REDWOOD_SAPLING.get().asItem())
                .add(RuBlocks.RED_MAPLE_SAPLING.get().asItem())
                .add(RuBlocks.RED_SAKURA_SAPLING.get().asItem())
                .add(RuBlocks.SAKURA_SAPLING.get().asItem())
                .add(RuBlocks.SILVER_BIRCH_SAPLING.get().asItem())
                .add(RuBlocks.WHITE_SAKURA_SAPLING.get().asItem())
                .add(RuBlocks.WILLOW_SAPLING.get().asItem())
        ;
        //this.tag(ItemTags.SHOVELS);
        this.tag(ItemTags.SIGNS)
                .add(RuBlocks.BAOBAB_SIGN.get().asItem())
                .add(RuBlocks.BLACKWOOD_SIGN.get().asItem())
                .add(RuBlocks.BRIMWOOD_SIGN.get().asItem())
                .add(RuBlocks.CYPRESS_SIGN.get().asItem())
                .add(RuBlocks.DEAD_SIGN.get().asItem())
                .add(RuBlocks.EUCALYPTUS_SIGN.get().asItem())
                .add(RuBlocks.JOSHUA_SIGN.get().asItem())
                .add(RuBlocks.LARCH_SIGN.get().asItem())
                .add(RuBlocks.MAPLE_SIGN.get().asItem())
                .add(RuBlocks.MAUVE_SIGN.get().asItem())
                .add(RuBlocks.PALM_SIGN.get().asItem())
                .add(RuBlocks.PINE_SIGN.get().asItem())
                .add(RuBlocks.REDWOOD_SIGN.get().asItem())
                .add(RuBlocks.SAKURA_SIGN.get().asItem())
                .add(RuBlocks.WILLOW_SIGN.get().asItem())
        ;
        this.tag(ItemTags.SLABS)
                .add(RuBlocks.CHALK_SLAB.get().asItem())
                .add(RuBlocks.CHALK_BRICK_SLAB.get().asItem())
                .add(RuBlocks.POLISHED_CHALK_SLAB.get().asItem())
        ;
        this.tag(ItemTags.SMALL_FLOWERS)
                .add(RuBlocks.ALPHA_DANDELION.get().asItem())
                .add(RuBlocks.ALPHA_ROSE.get().asItem())
                .add(RuBlocks.BLUE_LUPINE.get().asItem())
                .add(RuBlocks.DAISY.get().asItem())
                .add(RuBlocks.DORCEL.get().asItem())
                .add(RuBlocks.FELICIA_DAISY.get().asItem())
                .add(RuBlocks.FIREWEED.get().asItem())
                .add(RuBlocks.HYSSOP.get().asItem())
                .add(RuBlocks.PINK_LUPINE.get().asItem())
                .add(RuBlocks.POPPY_BUSH.get().asItem())
                .add(RuBlocks.PURPLE_LUPINE.get().asItem())
                .add(RuBlocks.RED_LUPINE.get().asItem())
                .add(RuBlocks.WARATAH.get().asItem())
                .add(RuBlocks.WHITE_TRILLIUM.get().asItem())
                .add(RuBlocks.WILTING_TRILLIUM.get().asItem())
                .add(RuBlocks.YELLOW_LUPINE.get().asItem())
        ;
        //this.tag(ItemTags.SOUL_FIRE_BASE_BLOCKS);
        //this.tag(ItemTags.SPRUCE_LOGS);
        this.tag(ItemTags.SMELTS_TO_GLASS)
                .add(RuBlocks.QUICKSAND.get().asItem())
        ;
        this.tag(ItemTags.STAIRS)
                .add(RuBlocks.CHALK_STAIRS.get().asItem())
                .add(RuBlocks.CHALK_BRICK_STAIRS.get().asItem())
                .add(RuBlocks.POLISHED_CHALK_STAIRS.get().asItem())
        ;
        //this.tag(ItemTags.STONE_BRICKS);
        //this.tag(ItemTags.STONE_CRAFTING_MATERIALS);
        //this.tag(ItemTags.STONE_TOOL_MATERIALS);
        //this.tag(ItemTags.SWORDS);
        this.tag(ItemTags.TALL_FLOWERS)
                .add(RuBlocks.TASSEL.get().asItem())
                .add(RuBlocks.TSUBAKI.get().asItem())
        ;
        //this.tag(ItemTags.TERRACOTTA);
        //this.tag(ItemTags.TOOLS);
        //this.tag(ItemTags.TRAPDOORS);
        //this.tag(ItemTags.WALLS);
        this.tag(ItemTags.WARPED_STEMS)
                .add(RuBlocks.BRIMWOOD_LOG.get().asItem())
                .add(RuBlocks.BRIMWOOD_LOG_MAGMA.get().asItem())
                .add(RuBlocks.STRIPPED_BRIMWOOD_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_BRIMWOOD_WOOD.get().asItem())
                .add(RuBlocks.BRIMWOOD_WOOD.get().asItem())
        ;
        this.tag(ItemTags.WART_BLOCKS)
                .add(RuBlocks.GREEN_BIOSHROOM_BLOCK.get().asItem())
                .add(RuBlocks.BLUE_BIOSHROOM_BLOCK.get().asItem())
                .add(RuBlocks.PINK_BIOSHROOM_BLOCK.get().asItem())
                .add(RuBlocks.YELLOW_BIOSHROOM_BLOCK.get().asItem())
                .add(RuBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get().asItem())
                .add(RuBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get().asItem())
                .add(RuBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get().asItem())
                .add(RuBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get().asItem())
        ;
        this.tag(ItemTags.WOODEN_BUTTONS)
                .add(RuBlocks.BAOBAB_BUTTON.get().asItem())
                .add(RuBlocks.BLACKWOOD_BUTTON.get().asItem())
                .add(RuBlocks.BRIMWOOD_BUTTON.get().asItem())
                .add(RuBlocks.CYPRESS_BUTTON.get().asItem())
                .add(RuBlocks.EUCALYPTUS_BUTTON.get().asItem())
                .add(RuBlocks.JOSHUA_BUTTON.get().asItem())
                .add(RuBlocks.LARCH_BUTTON.get().asItem())
                .add(RuBlocks.MAPLE_BUTTON.get().asItem())
                .add(RuBlocks.MAUVE_BUTTON.get().asItem())
                .add(RuBlocks.PALM_BUTTON.get().asItem())
                .add(RuBlocks.PINE_BUTTON.get().asItem())
                .add(RuBlocks.REDWOOD_BUTTON.get().asItem())
                .add(RuBlocks.SAKURA_BUTTON.get().asItem())
                .add(RuBlocks.WILLOW_BUTTON.get().asItem())
        ;
        this.tag(ItemTags.WOODEN_DOORS)
                .add(RuBlocks.BAOBAB_DOOR.get().asItem())
                .add(RuBlocks.BLACKWOOD_DOOR.get().asItem())
                .add(RuBlocks.BRIMWOOD_DOOR.get().asItem())
                .add(RuBlocks.CYPRESS_DOOR.get().asItem())
                .add(RuBlocks.EUCALYPTUS_DOOR.get().asItem())
                .add(RuBlocks.JOSHUA_DOOR.get().asItem())
                .add(RuBlocks.LARCH_DOOR.get().asItem())
                .add(RuBlocks.MAPLE_DOOR.get().asItem())
                .add(RuBlocks.MAUVE_DOOR.get().asItem())
                .add(RuBlocks.PALM_DOOR.get().asItem())
                .add(RuBlocks.PINE_DOOR.get().asItem())
                .add(RuBlocks.REDWOOD_DOOR.get().asItem())
                .add(RuBlocks.SAKURA_DOOR.get().asItem())
                .add(RuBlocks.WILLOW_DOOR.get().asItem())
        ;
        this.tag(ItemTags.WOODEN_FENCES)
                .add(RuBlocks.BAOBAB_FENCE.get().asItem())
                .add(RuBlocks.BLACKWOOD_FENCE.get().asItem())
                .add(RuBlocks.BRIMWOOD_FENCE.get().asItem())
                .add(RuBlocks.CYPRESS_FENCE.get().asItem())
                .add(RuBlocks.EUCALYPTUS_FENCE.get().asItem())
                .add(RuBlocks.JOSHUA_FENCE.get().asItem())
                .add(RuBlocks.LARCH_FENCE.get().asItem())
                .add(RuBlocks.MAPLE_FENCE.get().asItem())
                .add(RuBlocks.MAUVE_FENCE.get().asItem())
                .add(RuBlocks.PALM_FENCE.get().asItem())
                .add(RuBlocks.PINE_FENCE.get().asItem())
                .add(RuBlocks.REDWOOD_FENCE.get().asItem())
                .add(RuBlocks.SAKURA_FENCE.get().asItem())
                .add(RuBlocks.WILLOW_FENCE.get().asItem())
        ;
        this.tag(ItemTags.WOODEN_PRESSURE_PLATES)
                .add(RuBlocks.BAOBAB_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.BLACKWOOD_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.BRIMWOOD_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.CYPRESS_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.EUCALYPTUS_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.JOSHUA_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.LARCH_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.MAPLE_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.MAUVE_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.PALM_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.PINE_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.REDWOOD_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.SAKURA_PRESSURE_PLATE.get().asItem())
                .add(RuBlocks.WILLOW_PRESSURE_PLATE.get().asItem())
        ;
        this.tag(ItemTags.WOODEN_SLABS)
                .add(RuBlocks.ALPHA_SLAB.get().asItem())
                .add(RuBlocks.BAOBAB_SLAB.get().asItem())
                .add(RuBlocks.BLACKWOOD_SLAB.get().asItem())
                .add(RuBlocks.BRIMWOOD_SLAB.get().asItem())
                .add(RuBlocks.CYPRESS_SLAB.get().asItem())
                .add(RuBlocks.EUCALYPTUS_SLAB.get().asItem())
                .add(RuBlocks.JOSHUA_SLAB.get().asItem())
                .add(RuBlocks.LARCH_SLAB.get().asItem())
                .add(RuBlocks.MAPLE_SLAB.get().asItem())
                .add(RuBlocks.MAUVE_SLAB.get().asItem())
                .add(RuBlocks.PALM_SLAB.get().asItem())
                .add(RuBlocks.PINE_SLAB.get().asItem())
                .add(RuBlocks.REDWOOD_SLAB.get().asItem())
                .add(RuBlocks.SAKURA_SLAB.get().asItem())
                .add(RuBlocks.WILLOW_SLAB.get().asItem())
                .add(RuBlocks.LIGHT_GRAY_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.BLACK_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.LIGHT_BLUE_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.GRAY_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.BROWN_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.LIME_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.GREEN_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.YELLOW_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.MAGENTA_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.BLUE_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.RED_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.CYAN_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.WHITE_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.PURPLE_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.PINK_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.ORANGE_PAINTED_SLAB.get().asItem())
        ;
        this.tag(ItemTags.WOODEN_STAIRS)
                .add(RuBlocks.ALPHA_STAIRS.get().asItem())
                .add(RuBlocks.BAOBAB_STAIRS.get().asItem())
                .add(RuBlocks.BLACKWOOD_STAIRS.get().asItem())
                .add(RuBlocks.BRIMWOOD_STAIRS.get().asItem())
                .add(RuBlocks.CYPRESS_STAIRS.get().asItem())
                .add(RuBlocks.EUCALYPTUS_STAIRS.get().asItem())
                .add(RuBlocks.JOSHUA_STAIRS.get().asItem())
                .add(RuBlocks.LARCH_STAIRS.get().asItem())
                .add(RuBlocks.MAPLE_STAIRS.get().asItem())
                .add(RuBlocks.MAUVE_STAIRS.get().asItem())
                .add(RuBlocks.PALM_STAIRS.get().asItem())
                .add(RuBlocks.PINE_STAIRS.get().asItem())
                .add(RuBlocks.REDWOOD_STAIRS.get().asItem())
                .add(RuBlocks.SAKURA_STAIRS.get().asItem())
                .add(RuBlocks.WILLOW_STAIRS.get().asItem())
                .add(RuBlocks.LIGHT_GRAY_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.BLACK_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.LIGHT_BLUE_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.GRAY_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.BROWN_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.LIME_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.GREEN_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.YELLOW_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.MAGENTA_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.BLUE_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.RED_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.CYAN_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.WHITE_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.PURPLE_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.PINK_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.ORANGE_PAINTED_STAIRS.get().asItem())
        ;
        this.tag(ItemTags.WOODEN_TRAPDOORS)
                .add(RuBlocks.BAOBAB_TRAPDOOR.get().asItem())
                .add(RuBlocks.BLACKWOOD_TRAPDOOR.get().asItem())
                .add(RuBlocks.BRIMWOOD_TRAPDOOR.get().asItem())
                .add(RuBlocks.CYPRESS_TRAPDOOR.get().asItem())
                .add(RuBlocks.EUCALYPTUS_TRAPDOOR.get().asItem())
                .add(RuBlocks.JOSHUA_TRAPDOOR.get().asItem())
                .add(RuBlocks.LARCH_TRAPDOOR.get().asItem())
                .add(RuBlocks.MAPLE_TRAPDOOR.get().asItem())
                .add(RuBlocks.MAUVE_TRAPDOOR.get().asItem())
                .add(RuBlocks.PALM_TRAPDOOR.get().asItem())
                .add(RuBlocks.PINE_TRAPDOOR.get().asItem())
                .add(RuBlocks.REDWOOD_TRAPDOOR.get().asItem())
                .add(RuBlocks.SAKURA_TRAPDOOR.get().asItem())
                .add(RuBlocks.WILLOW_TRAPDOOR.get().asItem())
        ;
        //this.tag(ItemTags.WOOL);
        //this.tag(ItemTags.WOOL_CARPETS);


        this.tag(RuTags.PRISMARITE_CRYSTALS_ITEM)
                .add(RuBlocks.PRISMARITE_CLUSTER.get().asItem())
                .add(RuBlocks.LARGE_PRISMARITE_CLUSTER.get().asItem())
                .add(RuBlocks.HANGING_PRISMARITE.get().asItem())
        ;
        this.tag(RuTags.GRASS_ITEM)
                .add(RuBlocks.FROZEN_GRASS.get().asItem())
                .add(RuBlocks.MEDIUM_GRASS.get().asItem())
                .add(RuBlocks.SANDY_GRASS.get().asItem())
                .add(RuBlocks.SEEDED_GRASS.get().asItem())
                .add(RuBlocks.STEPPE_GRASS.get().asItem())
                .add(RuBlocks.STEPPE_SHRUB.get().asItem())
                .add(RuBlocks.STONE_BUD.get().asItem())
                .add(ResourceKey.create(Registries.ITEM, new ResourceLocation("minecraft", "grass")))
                .add(ResourceKey.create(Registries.ITEM, new ResourceLocation("minecraft", "fern")))
        ;
        this.tag(RuTags.ASH_ITEM)
                .add(RuBlocks.ASH.get().asItem())
                .add(RuBlocks.VOLCANIC_ASH.get().asItem())
        ;
        this.tag(RuTags.BRANCHES_ITEM)
                .add(RuBlocks.ACACIA_BRANCH.get().asItem())
                .add(RuBlocks.BAOBAB_BRANCH.get().asItem())
                .add(RuBlocks.BIRCH_BRANCH.get().asItem())
                .add(RuBlocks.BLACKWOOD_BRANCH.get().asItem())
                .add(RuBlocks.CYPRESS_BRANCH.get().asItem())
                .add(RuBlocks.DARK_OAK_BRANCH.get().asItem())
                .add(RuBlocks.DEAD_BRANCH.get().asItem())
                .add(RuBlocks.EUCALYPTUS_BRANCH.get().asItem())
                .add(RuBlocks.JOSHUA_BEARD.get().asItem())
                .add(RuBlocks.JUNGLE_BRANCH.get().asItem())
                .add(RuBlocks.LARCH_BRANCH.get().asItem())
                .add(RuBlocks.MANGROVE_BRANCH.get().asItem())
                .add(RuBlocks.MAPLE_BRANCH.get().asItem())
                .add(RuBlocks.MAUVE_BRANCH.get().asItem())
                .add(RuBlocks.OAK_BRANCH.get().asItem())
                .add(RuBlocks.PALM_BEARD.get().asItem())
                .add(RuBlocks.PINE_BRANCH.get().asItem())
                .add(RuBlocks.REDWOOD_BRANCH.get().asItem())
                .add(RuBlocks.SAKURA_BRANCH.get().asItem())
                .add(RuBlocks.SILVER_BIRCH_BRANCH.get().asItem())
                .add(RuBlocks.SPRUCE_BRANCH.get().asItem())
                .add(RuBlocks.WILLOW_BRANCH.get().asItem())
        ;
        this.tag(RuTags.SHRUBS_ITEM)
                .add(RuBlocks.ACACIA_SHRUB.get().asItem())
                .add(RuBlocks.BAOBAB_SHRUB.get().asItem())
                .add(RuBlocks.BIRCH_SHRUB.get().asItem())
                .add(RuBlocks.BLACKWOOD_SHRUB.get().asItem())
                .add(RuBlocks.SAKURA_SHRUB.get().asItem())
                .add(RuBlocks.RED_SAKURA_SHRUB.get().asItem())
                .add(RuBlocks.PINK_SAKURA_SHRUB.get().asItem())
                .add(RuBlocks.WHITE_SAKURA_SHRUB.get().asItem())
                .add(RuBlocks.CYPRESS_SHRUB.get().asItem())
                .add(RuBlocks.DARK_OAK_SHRUB.get().asItem())
                .add(RuBlocks.DEAD_SHRUB.get().asItem())
                .add(RuBlocks.DEAD_PINE_SHRUB.get().asItem())
                .add(RuBlocks.EUCALYPTUS_SHRUB.get().asItem())
                .add(RuBlocks.FLOWERING_SHRUB.get().asItem())
                .add(RuBlocks.JOSHUA_SHRUB.get().asItem())
                .add(RuBlocks.JUNGLE_SHRUB.get().asItem())
                .add(RuBlocks.GOLDEN_LARCH_SHRUB.get().asItem())
                .add(RuBlocks.LARCH_SHRUB.get().asItem())
                .add(RuBlocks.MANGROVE_SHRUB.get().asItem())
                .add(RuBlocks.MAPLE_SHRUB.get().asItem())
                .add(RuBlocks.RED_MAPLE_SHRUB.get().asItem())
                .add(RuBlocks.ORANGE_MAPLE_SHRUB.get().asItem())
                .add(RuBlocks.MAUVE_SHRUB.get().asItem())
                .add(RuBlocks.OAK_SHRUB.get().asItem())
                .add(RuBlocks.PALM_SHRUB.get().asItem())
                .add(RuBlocks.PINE_SHRUB.get().asItem())
                .add(RuBlocks.REDWOOD_SHRUB.get().asItem())
                .add(RuBlocks.SILVER_BIRCH_SHRUB.get().asItem())
                .add(RuBlocks.SPRUCE_SHRUB.get().asItem())
                .add(RuBlocks.WILLOW_SHRUB.get().asItem())
        ;
        this.tag(RuTags.BAMBOO_LOGS_ITEM)
                .add(RuBlocks.BAMBOO_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_BAMBOO_LOG.get().asItem())
        ;
        this.tag(RuTags.BAOBAB_LOGS_ITEM)
                .add(RuBlocks.BAOBAB_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_BAOBAB_LOG.get().asItem())
                .add(RuBlocks.BAOBAB_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_BAOBAB_WOOD.get().asItem())
        ;
        this.tag(RuTags.BRIMWOOD_LOGS_ITEM)
                .add(RuBlocks.BRIMWOOD_LOG.get().asItem())
                .add(RuBlocks.BRIMWOOD_LOG_MAGMA.get().asItem())
                .add(RuBlocks.BRIMWOOD_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_BRIMWOOD_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_BRIMWOOD_WOOD.get().asItem())
        ;
        this.tag(RuTags.BLACKWOOD_LOGS_ITEM)
                .add(RuBlocks.BLACKWOOD_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_BLACKWOOD_LOG.get().asItem())
                .add(RuBlocks.BLACKWOOD_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_BLACKWOOD_WOOD.get().asItem())
        ;
        this.tag(RuTags.SAKURA_LOGS_ITEM)
                .add(RuBlocks.SAKURA_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_SAKURA_LOG.get().asItem())
                .add(RuBlocks.SAKURA_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_SAKURA_WOOD.get().asItem())
        ;
        this.tag(RuTags.CYPRESS_LOGS_ITEM)
                .add(RuBlocks.CYPRESS_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_CYPRESS_LOG.get().asItem())
                .add(RuBlocks.CYPRESS_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_CYPRESS_WOOD.get().asItem())
        ;
        this.tag(RuTags.DEAD_LOGS_ITEM)
                .add(RuBlocks.ASHEN_LOG.get().asItem())
                .add(RuBlocks.DEAD_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_DEAD_LOG.get().asItem())
                .add(RuBlocks.ASHEN_WOOD.get().asItem())
                .add(RuBlocks.DEAD_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_DEAD_WOOD.get().asItem())
        ;
        this.tag(RuTags.EUCALYPTUS_LOGS_ITEM)
                .add(RuBlocks.EUCALYPTUS_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_EUCALYPTUS_LOG.get().asItem())
                .add(RuBlocks.EUCALYPTUS_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_EUCALYPTUS_WOOD.get().asItem())
        ;
        this.tag(RuTags.JOSHUA_LOGS_ITEM)
                .add(RuBlocks.JOSHUA_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_JOSHUA_LOG.get().asItem())
                .add(RuBlocks.JOSHUA_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_JOSHUA_WOOD.get().asItem())
        ;
        this.tag(RuTags.LARCH_LOGS_ITEM)
                .add(RuBlocks.LARCH_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_LARCH_LOG.get().asItem())
                .add(RuBlocks.LARCH_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_LARCH_WOOD.get().asItem())
        ;
        this.tag(RuTags.MAPLE_LOGS_ITEM)
                .add(RuBlocks.MAPLE_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_MAPLE_LOG.get().asItem())
                .add(RuBlocks.MAPLE_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_MAPLE_WOOD.get().asItem())
        ;
        this.tag(RuTags.MAUVE_LOGS_ITEM)
                .add(RuBlocks.MAUVE_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_MAUVE_LOG.get().asItem())
                .add(RuBlocks.MAUVE_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_MAUVE_WOOD.get().asItem())
        ;
        this.tag(RuTags.PALM_LOGS_ITEM)
                .add(RuBlocks.PALM_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_PALM_LOG.get().asItem())
                .add(RuBlocks.PALM_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_PALM_WOOD.get().asItem())
        ;
        this.tag(RuTags.PINE_LOGS_ITEM)
                .add(RuBlocks.PINE_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_PINE_LOG.get().asItem())
                .add(RuBlocks.PINE_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_PINE_WOOD.get().asItem())
        ;
        this.tag(RuTags.REDWOOD_LOGS_ITEM)
                .add(RuBlocks.REDWOOD_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_REDWOOD_LOG.get().asItem())
                .add(RuBlocks.REDWOOD_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_REDWOOD_WOOD.get().asItem())
        ;
        this.tag(RuTags.WILLOW_LOGS_ITEM)
                .add(RuBlocks.WILLOW_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_WILLOW_LOG.get().asItem())
                .add(RuBlocks.WILLOW_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_WILLOW_WOOD.get().asItem())
        ;
    }

    public void addForgeTags(HolderLookup.Provider provider) {
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "barrels/wooden")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "chests/ender")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "chests/trapped")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "chests/wooden")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "cobblestone/deepslate")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "cobblestone/infested")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "cobblestone/mossy")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "cobblestone/normal")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "crops/beetroot")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "crops/carrot")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "crops/nether_wart")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "crops/potato")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "crops/wheat")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dusts/glowstone")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dusts/prismarine")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dusts/redstone")));
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "fence_gates/wooden")))
                .add(RuBlocks.BAOBAB_FENCE_GATE.get().asItem())
                .add(RuBlocks.BLACKWOOD_FENCE_GATE.get().asItem())
                .add(RuBlocks.BRIMWOOD_FENCE_GATE.get().asItem())
                .add(RuBlocks.CYPRESS_FENCE_GATE.get().asItem())
                .add(RuBlocks.DEAD_FENCE_GATE.get().asItem())
                .add(RuBlocks.EUCALYPTUS_FENCE_GATE.get().asItem())
                .add(RuBlocks.JOSHUA_FENCE_GATE.get().asItem())
                .add(RuBlocks.LARCH_FENCE_GATE.get().asItem())
                .add(RuBlocks.MAPLE_FENCE_GATE.get().asItem())
                .add(RuBlocks.MAUVE_FENCE_GATE.get().asItem())
                .add(RuBlocks.PALM_FENCE_GATE.get().asItem())
                .add(RuBlocks.PINE_FENCE_GATE.get().asItem())
                .add(RuBlocks.REDWOOD_FENCE_GATE.get().asItem())
                .add(RuBlocks.SAKURA_FENCE_GATE.get().asItem())
                .add(RuBlocks.WILLOW_FENCE_GATE.get().asItem())
        ;
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "fences/nether_brick")));
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "fences/wooden")))
                .add(RuBlocks.BAOBAB_FENCE.get().asItem())
                .add(RuBlocks.BLACKWOOD_FENCE.get().asItem())
                .add(RuBlocks.BRIMWOOD_FENCE.get().asItem())
                .add(RuBlocks.CYPRESS_FENCE.get().asItem())
                .add(RuBlocks.DEAD_FENCE.get().asItem())
                .add(RuBlocks.EUCALYPTUS_FENCE.get().asItem())
                .add(RuBlocks.JOSHUA_FENCE.get().asItem())
                .add(RuBlocks.LARCH_FENCE.get().asItem())
                .add(RuBlocks.MAPLE_FENCE.get().asItem())
                .add(RuBlocks.MAUVE_FENCE.get().asItem())
                .add(RuBlocks.PALM_FENCE.get().asItem())
                .add(RuBlocks.PINE_FENCE.get().asItem())
                .add(RuBlocks.REDWOOD_FENCE.get().asItem())
                .add(RuBlocks.SAKURA_FENCE.get().asItem())
                .add(RuBlocks.WILLOW_FENCE.get().asItem())
        ;
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "glass/colorless")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "glass_panes/colorless")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ore_bearing_ground/deepslate")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ore_bearing_ground/nether")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ore_bearing_ground/stone")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ore_rates/dense")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ore_rates/singular")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ore_rates/sparse")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ores/coal")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ores/copper")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ores/diamond")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ores/emerald")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ores/gold")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ores/iron")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ores/lapis")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ores/quartz")));
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ores/redstone")))
                .add(RuBlocks.RAW_REDSTONE_BLOCK.get().asItem())
        ;
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ores_in_ground/deepslate")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ores_in_ground/netherrack")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ores_in_ground/stone")));
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "sand/colorless")))
                .add(RuBlocks.QUICKSAND.get().asItem())
        ;
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "sand/red")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "seeds/beetroot")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "seeds/melon")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "seeds/pumpkin")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "seeds/wheat")));
        //TODO:Add other storage tags
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "storage_blocks/redstone")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/axes")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/bows")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/crossbows")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/fishing_rods")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/hoes")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/pickaxes")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/shields")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/shovels")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/swords")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools/tridents")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "barrels")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "bones")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "bookshelves")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "chests")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "cobblestone")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "crops")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dusts")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "dyes")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "end_stones")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "fence_gates")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "fences")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "gems")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "glass")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "glass_panes")));
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "gravel")))
                .add(RuBlocks.ASH.get().asItem())
                .add(RuBlocks.VOLCANIC_ASH.get().asItem())
        ;
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "gunpowder")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ingots")));
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "mushrooms")))
                .add(RuBlocks.GREEN_BIOSHROOM.get().asItem())
                .add(RuBlocks.BLUE_BIOSHROOM.get().asItem())
                .add(RuBlocks.PINK_BIOSHROOM.get().asItem())
                .add(RuBlocks.YELLOW_BIOSHROOM.get().asItem())
                .add(RuBlocks.TALL_GREEN_BIOSHROOM.get().asItem())
                .add(RuBlocks.TALL_BLUE_BIOSHROOM.get().asItem())
                .add(RuBlocks.TALL_PINK_BIOSHROOM.get().asItem())
                .add(RuBlocks.TALL_YELLOW_BIOSHROOM.get().asItem())
        ;
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "netherrack")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "nuggets")));
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "obsidian")))
                .add(RuBlocks.COBALT_OBSIDIAN.get().asItem())
        ;
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "ores")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "raw_materials")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "sand")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "sandstone")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "seeds")));
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "stained_glass")))
                .add(RuBlocks.PRISMAGLASS.get().asItem())
        ;
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "stained_glass_panes")));
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "stone")))
                .add(RuBlocks.MOSSY_STONE.get().asItem())
                .add(RuBlocks.CHALK.get().asItem())
                .add(RuBlocks.POLISHED_CHALK.get().asItem())
        ;
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "trapdoors/wooden")))
                .add(RuBlocks.BAOBAB_TRAPDOOR.get().asItem())
                .add(RuBlocks.BLACKWOOD_TRAPDOOR.get().asItem())
                .add(RuBlocks.BRIMWOOD_TRAPDOOR.get().asItem())
                .add(RuBlocks.CYPRESS_TRAPDOOR.get().asItem())
                .add(RuBlocks.EUCALYPTUS_TRAPDOOR.get().asItem())
                .add(RuBlocks.JOSHUA_TRAPDOOR.get().asItem())
                .add(RuBlocks.LARCH_TRAPDOOR.get().asItem())
                .add(RuBlocks.MAPLE_TRAPDOOR.get().asItem())
                .add(RuBlocks.MAUVE_TRAPDOOR.get().asItem())
                .add(RuBlocks.PALM_TRAPDOOR.get().asItem())
                .add(RuBlocks.PINE_TRAPDOOR.get().asItem())
                .add(RuBlocks.REDWOOD_TRAPDOOR.get().asItem())
                .add(RuBlocks.SAKURA_TRAPDOOR.get().asItem())
                .add(RuBlocks.WILLOW_TRAPDOOR.get().asItem())
        ;
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "doors/wooden")))
                .add(RuBlocks.BAOBAB_DOOR.get().asItem())
                .add(RuBlocks.BLACKWOOD_DOOR.get().asItem())
                .add(RuBlocks.BRIMWOOD_DOOR.get().asItem())
                .add(RuBlocks.CYPRESS_DOOR.get().asItem())
                .add(RuBlocks.EUCALYPTUS_DOOR.get().asItem())
                .add(RuBlocks.JOSHUA_DOOR.get().asItem())
                .add(RuBlocks.LARCH_DOOR.get().asItem())
                .add(RuBlocks.MAPLE_DOOR.get().asItem())
                .add(RuBlocks.MAUVE_DOOR.get().asItem())
                .add(RuBlocks.PALM_DOOR.get().asItem())
                .add(RuBlocks.PINE_DOOR.get().asItem())
                .add(RuBlocks.REDWOOD_DOOR.get().asItem())
                .add(RuBlocks.SAKURA_DOOR.get().asItem())
                .add(RuBlocks.WILLOW_DOOR.get().asItem())
        ;
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "stairs/wooden")))
                .add(RuBlocks.ALPHA_STAIRS.get().asItem())
                .add(RuBlocks.BAOBAB_STAIRS.get().asItem())
                .add(RuBlocks.BLACKWOOD_STAIRS.get().asItem())
                .add(RuBlocks.BRIMWOOD_STAIRS.get().asItem())
                .add(RuBlocks.CYPRESS_STAIRS.get().asItem())
                .add(RuBlocks.EUCALYPTUS_STAIRS.get().asItem())
                .add(RuBlocks.JOSHUA_STAIRS.get().asItem())
                .add(RuBlocks.LARCH_STAIRS.get().asItem())
                .add(RuBlocks.MAPLE_STAIRS.get().asItem())
                .add(RuBlocks.MAUVE_STAIRS.get().asItem())
                .add(RuBlocks.PALM_STAIRS.get().asItem())
                .add(RuBlocks.PINE_STAIRS.get().asItem())
                .add(RuBlocks.REDWOOD_STAIRS.get().asItem())
                .add(RuBlocks.SAKURA_STAIRS.get().asItem())
                .add(RuBlocks.WILLOW_STAIRS.get().asItem())
                .add(RuBlocks.LIGHT_GRAY_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.BLACK_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.LIGHT_BLUE_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.GRAY_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.BROWN_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.LIME_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.GREEN_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.YELLOW_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.MAGENTA_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.BLUE_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.RED_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.CYAN_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.WHITE_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.PURPLE_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.PINK_PAINTED_STAIRS.get().asItem())
                .add(RuBlocks.ORANGE_PAINTED_STAIRS.get().asItem())
        ;
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "stairs/stone")))
                .add(RuBlocks.CHALK_STAIRS.get().asItem())
                .add(RuBlocks.CHALK_BRICK_STAIRS.get().asItem())
                .add(RuBlocks.POLISHED_CHALK_STAIRS.get().asItem())
        ;
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "slabs/wooden")))
                .add(RuBlocks.ALPHA_SLAB.get().asItem())
                .add(RuBlocks.BAOBAB_SLAB.get().asItem())
                .add(RuBlocks.BLACKWOOD_SLAB.get().asItem())
                .add(RuBlocks.BRIMWOOD_SLAB.get().asItem())
                .add(RuBlocks.CYPRESS_SLAB.get().asItem())
                .add(RuBlocks.EUCALYPTUS_SLAB.get().asItem())
                .add(RuBlocks.JOSHUA_SLAB.get().asItem())
                .add(RuBlocks.LARCH_SLAB.get().asItem())
                .add(RuBlocks.MAPLE_SLAB.get().asItem())
                .add(RuBlocks.MAUVE_SLAB.get().asItem())
                .add(RuBlocks.PALM_SLAB.get().asItem())
                .add(RuBlocks.PINE_SLAB.get().asItem())
                .add(RuBlocks.REDWOOD_SLAB.get().asItem())
                .add(RuBlocks.SAKURA_SLAB.get().asItem())
                .add(RuBlocks.WILLOW_SLAB.get().asItem())
                .add(RuBlocks.LIGHT_GRAY_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.BLACK_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.LIGHT_BLUE_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.GRAY_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.BROWN_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.LIME_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.GREEN_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.YELLOW_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.MAGENTA_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.BLUE_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.RED_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.CYAN_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.WHITE_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.PURPLE_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.PINK_PAINTED_SLAB.get().asItem())
                .add(RuBlocks.ORANGE_PAINTED_SLAB.get().asItem())
        ;
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "slabs/stone")))
                .add(RuBlocks.CHALK_SLAB.get().asItem())
                .add(RuBlocks.CHALK_BRICK_SLAB.get().asItem())
                .add(RuBlocks.POLISHED_CHALK_SLAB.get().asItem())
        ;
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "planks")))
                .add(RuBlocks.ALPHA_PLANKS.get().asItem())
                .add(RuBlocks.BAOBAB_PLANKS.get().asItem())
                .add(RuBlocks.BLACKWOOD_PLANKS.get().asItem())
                .add(RuBlocks.BRIMWOOD_PLANKS.get().asItem())
                .add(RuBlocks.CYPRESS_PLANKS.get().asItem())
                .add(RuBlocks.EUCALYPTUS_PLANKS.get().asItem())
                .add(RuBlocks.JOSHUA_PLANKS.get().asItem())
                .add(RuBlocks.LARCH_PLANKS.get().asItem())
                .add(RuBlocks.MAPLE_PLANKS.get().asItem())
                .add(RuBlocks.MAUVE_PLANKS.get().asItem())
                .add(RuBlocks.PALM_PLANKS.get().asItem())
                .add(RuBlocks.PINE_PLANKS.get().asItem())
                .add(RuBlocks.REDWOOD_PLANKS.get().asItem())
                .add(RuBlocks.SAKURA_PLANKS.get().asItem())
                .add(RuBlocks.WILLOW_PLANKS.get().asItem())
                .add(RuBlocks.LIGHT_GRAY_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.BLACK_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.LIGHT_BLUE_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.GRAY_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.BROWN_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.LIME_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.GREEN_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.YELLOW_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.MAGENTA_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.BLUE_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.RED_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.CYAN_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.WHITE_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.PURPLE_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.PINK_PAINTED_PLANKS.get().asItem())
                .add(RuBlocks.ORANGE_PAINTED_PLANKS.get().asItem())
        ;
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "logs")))
                .add(RuBlocks.ALPHA_LOG.get().asItem())
                .add(RuBlocks.ASHEN_LOG.get().asItem())
                .add(RuBlocks.BAMBOO_LOG.get().asItem())
                .add(RuBlocks.BAOBAB_LOG.get().asItem())
                .add(RuBlocks.BLACKWOOD_LOG.get().asItem())
                .add(RuBlocks.BRIMWOOD_LOG.get().asItem())
                .add(RuBlocks.BRIMWOOD_LOG_MAGMA.get().asItem())
                .add(RuBlocks.CYPRESS_LOG.get().asItem())
                .add(RuBlocks.DEAD_LOG.get().asItem())
                .add(RuBlocks.EUCALYPTUS_LOG.get().asItem())
                .add(RuBlocks.JOSHUA_LOG.get().asItem())
                .add(RuBlocks.LARCH_LOG.get().asItem())
                .add(RuBlocks.MAPLE_LOG.get().asItem())
                .add(RuBlocks.MAUVE_LOG.get().asItem())
                .add(RuBlocks.PALM_LOG.get().asItem())
                .add(RuBlocks.PINE_LOG.get().asItem())
                .add(RuBlocks.REDWOOD_LOG.get().asItem())
                .add(RuBlocks.SAKURA_LOG.get().asItem())
                .add(RuBlocks.SILVER_BIRCH_LOG.get().asItem())
                .add(RuBlocks.WILLOW_LOG.get().asItem())
        ;
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "wood")))
                .add(RuBlocks.ASHEN_WOOD.get().asItem())
                .add(RuBlocks.BAOBAB_WOOD.get().asItem())
                .add(RuBlocks.BLACKWOOD_WOOD.get().asItem())
                .add(RuBlocks.BRIMWOOD_WOOD.get().asItem())
                .add(RuBlocks.CYPRESS_WOOD.get().asItem())
                .add(RuBlocks.DEAD_WOOD.get().asItem())
                .add(RuBlocks.EUCALYPTUS_WOOD.get().asItem())
                .add(RuBlocks.JOSHUA_WOOD.get().asItem())
                .add(RuBlocks.LARCH_WOOD.get().asItem())
                .add(RuBlocks.MAPLE_WOOD.get().asItem())
                .add(RuBlocks.MAUVE_WOOD.get().asItem())
                .add(RuBlocks.PALM_WOOD.get().asItem())
                .add(RuBlocks.PINE_WOOD.get().asItem())
                .add(RuBlocks.REDWOOD_WOOD.get().asItem())
                .add(RuBlocks.SAKURA_WOOD.get().asItem())
                .add(RuBlocks.SILVER_BIRCH_WOOD.get().asItem())
                .add(RuBlocks.WILLOW_WOOD.get().asItem())
        ;
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "stripped_logs")))
                .add(RuBlocks.STRIPPED_BAMBOO_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_BAOBAB_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_BLACKWOOD_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_BRIMWOOD_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_CYPRESS_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_DEAD_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_EUCALYPTUS_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_JOSHUA_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_LARCH_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_MAPLE_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_MAUVE_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_PALM_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_PINE_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_REDWOOD_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_SAKURA_LOG.get().asItem())
                .add(RuBlocks.STRIPPED_WILLOW_LOG.get().asItem())
        ;
        this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "stripped_wood")))
                .add(RuBlocks.STRIPPED_BAOBAB_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_BLACKWOOD_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_BRIMWOOD_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_CYPRESS_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_DEAD_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_EUCALYPTUS_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_JOSHUA_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_LARCH_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_MAPLE_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_MAUVE_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_PALM_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_PINE_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_REDWOOD_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_SAKURA_WOOD.get().asItem())
                .add(RuBlocks.STRIPPED_WILLOW_WOOD.get().asItem())
        ;
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "storage_blocks")));
        //this.tag(TagKey.create(Registries.ITEM, new ResourceLocation("forge", "tools")));
    }
}
