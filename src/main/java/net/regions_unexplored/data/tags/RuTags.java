package net.regions_unexplored.data.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.regions_unexplored.RegionsUnexploredMod;

public class RuTags {
    public static final TagKey<Block> BRANCHES_CAN_SURVIVE_ON = create("branches_can_survive_on");
    public static final TagKey<Block> BRIM_PLANT_CAN_SURVIVE_ON = create("brim_plant_can_survive_on");
    public static final TagKey<Block> CATTAIL_CAN_SURVIVE_ON = create("cattail_can_survive_on");
    public static final TagKey<Block> SANDY_PLANT_CAN_SURVIVE_ON = create("sandy_plant_can_survive_on");
    public static final TagKey<Block> SHRUB_CAN_SURVIVE_ON = create("shrub_can_survive_on");
    public static final TagKey<Block> SNOW_PLANT_CAN_SURVIVE_ON = create("snow_plant_can_survive_on");
    public static final TagKey<Block> STONE_PLANT_CAN_SURVIVE_ON = create("stone_plant_can_survive_on");
    public static final TagKey<Block> BIOSHROOM_GROW_BLOCK = create("bioshroom_grow_block");
    public static final TagKey<Block> REPLACEABLE_BLOCKS = create("replaceable_blocks");
    public static final TagKey<Block> SHRUBS = create("shrubs");
    public static final TagKey<Block> TREE_GRASS_REPLACEABLES = create("tree_grass_replaceables");
    public static final TagKey<Block> SANDS = create("sands");
    public static final TagKey<Block> FLUIDS = create("fluids");
    public static final TagKey<Block> ASH = create("ash");
    public static final TagKey<Block> BRANCHES = create("branches");
    public static final TagKey<Block> BAMBOO_LOGS = create("bamboo_logs");
    public static final TagKey<Block> BAOBAB_LOGS = create("baobab_logs");
    public static final TagKey<Block> BLACKWOOD_LOGS = create("blackwood_logs");
    public static final TagKey<Block> BRIMWOOD_LOGS = create("brimwood_logs");
    public static final TagKey<Block> CHERRY_LOGS = create("cherry_logs");
    public static final TagKey<Block> CYPRESS_LOGS = create("cypress_logs");
    public static final TagKey<Block> DEAD_LOGS = create("dead_logs");
    public static final TagKey<Block> EUCALYPTUS_LOGS = create("eucalyptus_logs");
    public static final TagKey<Block> JOSHUA_LOGS = create("joshua_logs");
    public static final TagKey<Block> LARCH_LOGS = create("larch_logs");
    public static final TagKey<Block> MAPLE_LOGS = create("maple_logs");
    public static final TagKey<Block> MAUVE_LOGS = create("mauve_logs");
    public static final TagKey<Block> PALM_LOGS = create("palm_logs");
    public static final TagKey<Block> PINE_LOGS = create("pine_logs");
    public static final TagKey<Block> REDWOOD_LOGS = create("redwood_logs");
    public static final TagKey<Block> WILLOW_LOGS = create("willow_logs");

    private RuTags() {
    }

    private static TagKey<Block> create(String key) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(RegionsUnexploredMod.MOD_ID, key));
    }

    public static TagKey<Block> create(ResourceLocation name) {
        return TagKey.create(Registries.BLOCK, name);
    }
}
