package net.regions_unexplored.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;

import java.util.function.Supplier;

public class BlockRegistry {
    //Register default blocks and items
    public static <T extends Block> RegistryObject<T> registerDefaultBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = RegionsUnexploredMod.BLOCK_REGISTRY.register(name, block);
        ItemRegistry.registerDefaultBlockItem(name, toReturn);
        return toReturn;
    }

    //Register Duckweed block and item
    public static <T extends Block> RegistryObject<T> registerDuckweedBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = RegionsUnexploredMod.BLOCK_REGISTRY.register(name, block);
        ItemRegistry.registerDuckweedItem(name, toReturn);
        return toReturn;
    }

    //Configure log block
    public static RotatedPillarBlock log(MaterialColor colour, MaterialColor colour2, SoundType sound) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? colour : colour2;
        }).strength(2.0F).sound(sound));
    }
    //Configure wooden stairs
    public static StairBlock woodStairs(MaterialColor colour, SoundType sound) {
        return new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden slab
    public static SlabBlock woodSlab(MaterialColor colour, SoundType sound) {
        return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden fence
    public static FenceBlock woodFence(MaterialColor colour, SoundType sound) {
        return new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden gate
    public static FenceGateBlock woodFenceGate(MaterialColor colour, WoodType type, SoundType sound) {
        return new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound), type);
    }
    //Configure leaves blocks
    public static LeavesBlock leaves(MaterialColor colour) {
        return new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static MauveLeavesBlock mauveLeaves(MaterialColor colour) {
        return new MauveLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static CherryLeavesBlock cherryLeaves(MaterialColor colour) {
        return new CherryLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static JoshuaLeavesBlock joshuaLeaves(MaterialColor colour) {
        return new JoshuaLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().noCollission());
    }
    public static LeavesBlock appleLeaves(MaterialColor colour) {
        return new AppleLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static RuSculkLeavesBlock sculkLeaves(MaterialColor colour) {
        return new RuSculkLeavesBlock(colour);
    }


    //Boolean states
    public static Boolean always(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type) {
        return (boolean)true;
    }
    public static boolean always(BlockState state, BlockGetter getter, BlockPos pos) {
        return true;
    }
    public static Boolean never(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type) {
        return (boolean)false;
    }
    public static boolean never(BlockState state, BlockGetter getter, BlockPos pos) {
        return false;
    }
    public static Boolean ocelotOrParrot(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type) {
        return (boolean)(type == EntityType.OCELOT || type == EntityType.PARROT);
    }
}
