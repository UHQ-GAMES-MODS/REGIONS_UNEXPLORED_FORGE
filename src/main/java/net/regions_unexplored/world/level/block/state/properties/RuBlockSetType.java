package net.regions_unexplored.world.level.block.state.properties;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.regions_unexplored.RegionsUnexploredMod;

import java.util.Set;
import java.util.stream.Stream;

public record RuBlockSetType(String name, SoundType soundType, SoundEvent doorClose, SoundEvent doorOpen, SoundEvent trapdoorClose, SoundEvent trapdoorOpen, SoundEvent pressurePlateClickOff, SoundEvent pressurePlateClickOn, SoundEvent buttonClickOff, SoundEvent buttonClickOn) {
    private static final Set<BlockSetType> VALUES = new ObjectArraySet<>();
    public static final BlockSetType BAOBAB = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":baobab"));
    public static final BlockSetType BLACKWOOD = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":blackwood"));
    public static final BlockSetType CHERRY = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":cherry"));
    public static final BlockSetType CYPRESS = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":cypress"));
    public static final BlockSetType DEAD = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":dead"));
    public static final BlockSetType EUCALYPTUS = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":eucalyptus"));
    public static final BlockSetType JOSHUA = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":joshua"));
    public static final BlockSetType LARCH = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":larch"));
    public static final BlockSetType MAPLE = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":maple"));
    public static final BlockSetType MAUVE = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":mauve"));
    public static final BlockSetType PALM = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":palm"));
    public static final BlockSetType PINE = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":pine"));
    public static final BlockSetType REDWOOD = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":redwood"));
    public static final BlockSetType BRIMWOOD = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":brimwood"));
    public static final BlockSetType WILLOW = register(new BlockSetType(RegionsUnexploredMod.MOD_ID + ":willow"));
    
    private static BlockSetType register(BlockSetType p_273033_) {
        VALUES.add(p_273033_);
        return p_273033_;
    }

    public static Stream<BlockSetType> values() {
        return VALUES.stream();
    }
}
