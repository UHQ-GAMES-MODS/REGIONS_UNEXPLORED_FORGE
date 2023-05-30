package net.regions_unexplored.data.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.RegionsUnexploredMod;

public class RuTags {
    public static final TagKey<Block> BRANCHES_CAN_SURVIVE_ON = createBlock("branches_can_survive_on");
    public static final TagKey<Block> BRIM_PLANT_CAN_SURVIVE_ON = createBlock("brim_plant_can_survive_on");
    public static final TagKey<Block> CATTAIL_CAN_SURVIVE_ON = createBlock("cattail_can_survive_on");
    public static final TagKey<Block> SANDY_PLANT_CAN_SURVIVE_ON = createBlock("sandy_plant_can_survive_on");
    public static final TagKey<Block> SHRUB_CAN_SURVIVE_ON = createBlock("shrub_can_survive_on");
    public static final TagKey<Block> SNOW_PLANT_CAN_SURVIVE_ON = createBlock("snow_plant_can_survive_on");
    public static final TagKey<Block> STONE_PLANT_CAN_SURVIVE_ON = createBlock("stone_plant_can_survive_on");
    public static final TagKey<Block> BIOSHROOM_GROW_BLOCK = createBlock("bioshroom_grow_block");
    public static final TagKey<Block> REPLACEABLE_BLOCKS = createBlock("replaceable_blocks");
    public static final TagKey<Block> SHRUBS = createBlock("shrubs");
    public static final TagKey<Block> TREE_GRASS_REPLACEABLES = createBlock("tree_grass_replaceables");
    public static final TagKey<Block> SANDS = createBlock("sands");
    public static final TagKey<Block> FLUIDS = createBlock("fluids");
    public static final TagKey<Block> ASH = createBlock("ash");
    public static final TagKey<Block> BRANCHES = createBlock("branches");
    public static final TagKey<Block> BAMBOO_LOGS = createBlock("bamboo_logs");
    public static final TagKey<Block> BAOBAB_LOGS = createBlock("baobab_logs");
    public static final TagKey<Block> BLACKWOOD_LOGS = createBlock("blackwood_logs");
    public static final TagKey<Block> BRIMWOOD_LOGS = createBlock("brimwood_logs");
    public static final TagKey<Block> SAKURA_LOGS = createBlock("sakura_logs");
    public static final TagKey<Block> CYPRESS_LOGS = createBlock("cypress_logs");
    public static final TagKey<Block> DEAD_LOGS = createBlock("dead_logs");
    public static final TagKey<Block> EUCALYPTUS_LOGS = createBlock("eucalyptus_logs");
    public static final TagKey<Block> JOSHUA_LOGS = createBlock("joshua_logs");
    public static final TagKey<Block> LARCH_LOGS = createBlock("larch_logs");
    public static final TagKey<Block> MAPLE_LOGS = createBlock("maple_logs");
    public static final TagKey<Block> MAUVE_LOGS = createBlock("mauve_logs");
    public static final TagKey<Block> PALM_LOGS = createBlock("palm_logs");
    public static final TagKey<Block> PINE_LOGS = createBlock("pine_logs");
    public static final TagKey<Block> REDWOOD_LOGS = createBlock("redwood_logs");
    public static final TagKey<Block> WILLOW_LOGS = createBlock("willow_logs");
    //items
    public static final TagKey<Item> BAMBOO_LOGS_ITEM = createItem("bamboo_logs");
    public static final TagKey<Item> BAOBAB_LOGS_ITEM = createItem("baobab_logs");
    public static final TagKey<Item> BLACKWOOD_LOGS_ITEM = createItem("blackwood_logs");
    public static final TagKey<Item> BRIMWOOD_LOGS_ITEM = createItem("brimwood_logs");
    public static final TagKey<Item> SAKURA_LOGS_ITEM = createItem("sakura_logs");
    public static final TagKey<Item> CYPRESS_LOGS_ITEM = createItem("cypress_logs");
    public static final TagKey<Item> DEAD_LOGS_ITEM = createItem("dead_logs");
    public static final TagKey<Item> EUCALYPTUS_LOGS_ITEM = createItem("eucalyptus_logs");
    public static final TagKey<Item> JOSHUA_LOGS_ITEM = createItem("joshua_logs");
    public static final TagKey<Item> LARCH_LOGS_ITEM = createItem("larch_logs");
    public static final TagKey<Item> MAPLE_LOGS_ITEM = createItem("maple_logs");
    public static final TagKey<Item> MAUVE_LOGS_ITEM = createItem("mauve_logs");
    public static final TagKey<Item> PALM_LOGS_ITEM = createItem("palm_logs");
    public static final TagKey<Item> PINE_LOGS_ITEM = createItem("pine_logs");
    public static final TagKey<Item> REDWOOD_LOGS_ITEM = createItem("redwood_logs");
    public static final TagKey<Item> WILLOW_LOGS_ITEM = createItem("willow_logs");


    public static final TagKey<Biome> FOREST = createBiome("forest");
    public static final TagKey<Biome> TAIGA = createBiome("taiga");

    private RuTags() {
    }

    private static TagKey<Block> createBlock(String key) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(RegionsUnexploredMod.MOD_ID, key));
    }
    public static TagKey<Block> createBlock(ResourceLocation name) {
        return TagKey.create(Registries.BLOCK, name);
    }

    private static TagKey<Item> createItem(String key) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(RegionsUnexploredMod.MOD_ID, key));
    }
    public static TagKey<Item> createItem(ResourceLocation name) {
        return TagKey.create(Registries.ITEM, name);
    }

    private static TagKey<Biome> createBiome(String key) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(RegionsUnexploredMod.MOD_ID, key));
    }
    public static TagKey<Biome> createBiome(ResourceLocation name) {
        return TagKey.create(Registries.BIOME, name);
    }
}
