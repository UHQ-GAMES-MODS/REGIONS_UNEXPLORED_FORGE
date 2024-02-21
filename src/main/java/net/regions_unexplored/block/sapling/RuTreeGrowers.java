package net.regions_unexplored.block.sapling;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.regions_unexplored.data.worldgen.features.RuTreeFeatures;

import java.util.Optional;

public class RuTreeGrowers {
    public static final TreeGrower ASHEN = new TreeGrower("ashen", Optional.empty(), Optional.of(RuTreeFeatures.ASHEN_TREE), Optional.empty());
    public static final TreeGrower ALPHA_OAK = new TreeGrower("alpha_oak", Optional.empty(), Optional.of(RuTreeFeatures.ALPHA_OAK_TREE), Optional.empty());
    public static final TreeGrower APPLE_OAK = new TreeGrower("apple_oak", 0.2F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.APPLE_OAK_TREE), Optional.of(RuTreeFeatures.BIG_APPLE_OAK_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower MAGNOLIA = new TreeGrower("magnolia", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.MAGNOLIA_TREE), Optional.of(RuTreeFeatures.BIG_MAGNOLIA_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower WHITE_MAGNOLIA = new TreeGrower("white_magnolia", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.WHITE_MAGNOLIA_TREE), Optional.of(RuTreeFeatures.BIG_WHITE_MAGNOLIA_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower PINK_MAGNOLIA = new TreeGrower("pink_magnolia", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.PINK_MAGNOLIA_TREE), Optional.of(RuTreeFeatures.BIG_PINK_MAGNOLIA_TREE), Optional.empty(), Optional.empty());
    public static final TreeGrower BLUE_MAGNOLIA = new TreeGrower("blue_magnolia", 0.1F, Optional.empty(), Optional.empty(), Optional.of(RuTreeFeatures.BLUE_MAGNOLIA_TREE), Optional.of(RuTreeFeatures.BIG_BLUE_MAGNOLIA_TREE), Optional.empty(), Optional.empty());
    public static final RuUltraFromSuperTreeGrower KAPOK = new RuUltraFromSuperTreeGrower("kapok", Optional.empty(), Optional.of(RuTreeFeatures.KAPOK_TREE), Optional.empty(), Optional.empty());
    public static final RuUltraFromSuperTreeGrower REDWOOD = new RuUltraFromSuperTreeGrower("redwood", Optional.of(RuTreeFeatures.ULTRA_REDWOOD_TREE), Optional.of(RuTreeFeatures.GIANT_REDWOOD_TREE), Optional.of(RuTreeFeatures.REDWOOD_TREE), Optional.empty());

}
