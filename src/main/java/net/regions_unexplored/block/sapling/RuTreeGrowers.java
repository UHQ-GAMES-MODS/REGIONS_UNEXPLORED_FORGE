package net.regions_unexplored.block.sapling;

import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

import java.util.Optional;

public class RuTreeGrowers {
    public static final TreeGrower BLUE_BIOSHROOM = new TreeGrower("blue_bioshroom", Optional.empty(), Optional.of(RuTreeFeatures.GIANT_BLUE_BIOSHROOM), Optional.empty());
    public static final TreeGrower GREEN_BIOSHROOM = new TreeGrower("green_bioshroom", Optional.empty(), Optional.of(RuTreeFeatures.GIANT_GREEN_BIOSHROOM), Optional.empty());
    public static final TreeGrower PINK_BIOSHROOM = new TreeGrower("pink_bioshroom", Optional.empty(), Optional.of(RuTreeFeatures.GIANT_PINK_BIOSHROOM), Optional.empty());
    public static final TreeGrower YELLOW_BIOSHROOM = new TreeGrower("yellow_bioshroom", Optional.empty(), Optional.of(RuTreeFeatures.GIANT_YELLOW_BIOSHROOM), Optional.empty());

    public static final TreeGrower ASHEN = new TreeGrower("ashen", Optional.empty(), Optional.of(RuTreeFeatures.ASHEN_TREE), Optional.empty());
    public static final TreeGrower ALPHA_OAK = new TreeGrower("alpha_oak", Optional.empty(), Optional.of(RuTreeFeatures.ALPHA_OAK_TREE), Optional.empty());
    public static final TreeGrower APPLE_OAK = new TreeGrower("apple_oak", 0.2F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.APPLE_OAK_TREE), Optional.of(RuTreeFeatures.BIG_APPLE_OAK_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower BAMBOO = new TreeGrower("bamboo", Optional.empty(), Optional.of(RuTreeFeatures.BAMBOO_TREE), Optional.empty());
    public static final RuUltraFromMegaTreeGrower BAOBAB = new RuUltraFromMegaTreeGrower("baobab", Optional.of(RuTreeFeatures.ULTRA_BAOBAB_TREE), Optional.of(RuTreeFeatures.MEGA_BAOBAB_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower BLACKWOOD = new TreeGrower("blackwood", 0.1F, Optional.of(RuTreeFeatures.GIANT_BLACKWOOD_TREE), Optional.empty(), Optional.of(RuTreeFeatures.BIG_BLACKWOOD_TREE), Optional.of(RuTreeFeatures.BLACKWOOD_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower SAGUARO_CACTUS = new TreeGrower("saguaro_cactus", Optional.empty(), Optional.of(RuTreeFeatures.SAGUARO_CACTUS), Optional.empty());
    public static final TreeGrower CYPRESS = new TreeGrower("cypress", 0.25F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.CYPRESS_TREE), Optional.of(RuTreeFeatures.GIANT_CYPRESS_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower DEAD_PINE = new TreeGrower("dead_pine", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.DEAD_PINE_TREE), Optional.of(RuTreeFeatures.DEAD_STRIPPED_PINE_TREE), Optional.of(RuTreeFeatures.DEAD_PINE_TREE_TALL), Optional.of(RuTreeFeatures.DEAD_STRIPPED_PINE_TREE_MOUNTAIN));
    public static final TreeGrower DEAD = new TreeGrower("dead", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.DEAD_TREE), Optional.of(RuTreeFeatures.BIG_DEAD_TREE), Optional.of(RuTreeFeatures.DEAD_BOG_TREE), Optional.empty());
    public static final TreeGrower EUCALYPTUS = new TreeGrower("eucalyptus", 0.33F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.EUCALYPTUS_TREE), Optional.of(RuTreeFeatures.SMALL_EUCALYPTUS_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower FLOWERING_OAK = new TreeGrower("flowering_oak", 0.2F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.FLOWERING_OAK_TREE), Optional.of(RuTreeFeatures.BIG_FLOWERING_OAK_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower GOLDEN_LARCH = new TreeGrower("golden_larch", 0.25F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.GOLDEN_LARCH_TREE), Optional.of(RuTreeFeatures.BIG_GOLDEN_LARCH_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower LARCH = new TreeGrower("larch", 0.25F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.LARCH_TREE), Optional.of(RuTreeFeatures.BIG_LARCH_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower JOSHUA = new TreeGrower("joshua", 0.33F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.MEDIUM_JOSHUA_TREE), Optional.of(RuTreeFeatures.LARGE_JOSHUA_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower MAPLE = new TreeGrower("maple", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.MAPLE_TREE), Optional.of(RuTreeFeatures.BIG_MAPLE_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower RED_MAPLE = new TreeGrower("red_maple", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.RED_MAPLE_TREE), Optional.of(RuTreeFeatures.BIG_RED_MAPLE_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower ORANGE_MAPLE = new TreeGrower("orange_maple", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.ORANGE_MAPLE_TREE), Optional.of(RuTreeFeatures.BIG_ORANGE_MAPLE_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower MAUVE = new TreeGrower("mauve", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.MAUVE_OAK), Optional.of(RuTreeFeatures.BIG_MAUVE_OAK), Optional.of(RuTreeFeatures.MAUVE_OAK_BEE), Optional.empty());
    public static final TreeGrower BRIMWOOD = new TreeGrower("brimwood", 0.25F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.BRIM_WILLOW_TREE), Optional.of(RuTreeFeatures.TALL_BRIM_WILLOW_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower COBALT = new TreeGrower("cobalt", Optional.empty(), Optional.of(RuTreeFeatures.COBALT_TREE), Optional.empty());
    public static final TreeGrower SILVER_BIRCH = new TreeGrower("silver_birch", 0.25F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.SILVER_BIRCH_TREE), Optional.of(RuTreeFeatures.SILVER_BIRCH_TREE_TALL), Optional.empty(), Optional.empty());
    public static final TreeGrower ENCHANTED_BIRCH = new TreeGrower("enchanted_birch", 0.25F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.ENCHANTED_BIRCH_TREE), Optional.of(RuTreeFeatures.ENCHANTED_BIRCH_TREE_TALL), Optional.empty(), Optional.empty());
    public static final TreeGrower SMALL_OAK = new TreeGrower("small_oak", Optional.empty(), Optional.of(RuTreeFeatures.SMALL_OAK_TREE), Optional.empty());
    public static final TreeGrower SOCOTRA = new TreeGrower("socotra", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.LARGE_SOCOTRA_TREE), Optional.of(RuTreeFeatures.SMALL_SOCOTRA_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower WILLOW = new TreeGrower("willow", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.WILLOW_TREE), Optional.of(RuTreeFeatures.BIG_WILLOW_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower MAGNOLIA = new TreeGrower("magnolia", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.MAGNOLIA_TREE), Optional.of(RuTreeFeatures.BIG_MAGNOLIA_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower WHITE_MAGNOLIA = new TreeGrower("white_magnolia", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.WHITE_MAGNOLIA_TREE), Optional.of(RuTreeFeatures.BIG_WHITE_MAGNOLIA_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower PINK_MAGNOLIA = new TreeGrower("pink_magnolia", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.PINK_MAGNOLIA_TREE), Optional.of(RuTreeFeatures.BIG_PINK_MAGNOLIA_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower BLUE_MAGNOLIA = new TreeGrower("blue_magnolia", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.BLUE_MAGNOLIA_TREE), Optional.of(RuTreeFeatures.BIG_BLUE_MAGNOLIA_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower PALM = new TreeGrower("palm", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.PALM_TREE), Optional.of(RuTreeFeatures.TALL_PALM_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower PINE = new TreeGrower("pine", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.PINE_TREE), Optional.of(RuTreeFeatures.STRIPPED_PINE_TREE), Optional.of(RuTreeFeatures.PINE_TREE_TALL), Optional.of(RuTreeFeatures.STRIPPED_PINE_TREE_MOUNTAIN));
    public static final RuUltraFromSuperTreeGrower KAPOK = new RuUltraFromSuperTreeGrower("kapok", Optional.empty(), Optional.of(RuTreeFeatures.KAPOK_TREE), Optional.empty(), Optional.empty());
    public static final RuUltraFromSuperTreeGrower REDWOOD = new RuUltraFromSuperTreeGrower("redwood", Optional.of(RuTreeFeatures.ULTRA_REDWOOD_TREE), Optional.of(RuTreeFeatures.GIANT_REDWOOD_TREE), Optional.of(RuTreeFeatures.REDWOOD_TREE), Optional.empty());

}
