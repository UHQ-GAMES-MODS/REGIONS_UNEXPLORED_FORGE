package net.regions_unexplored.registry;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.world.level.block.leaves.*;
import net.regions_unexplored.world.level.block.sign.RuStandingSignBlock;
import net.regions_unexplored.world.level.block.sign.RuWallSignBlock;
import net.regions_unexplored.world.level.block.wood.AspenLogBlock;
import net.regions_unexplored.world.level.block.wood.MagmaLogBlock;
import net.regions_unexplored.world.level.block.wood.PineLogBlock;

import java.util.function.Supplier;

public class BlockRegistry {
    //Register default blocks and items
    public static <T extends Block> RegistryObject<T> registerDefaultBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = RegionsUnexploredMod.BLOCK_REGISTRY.register(name, block);
        ItemRegistry.registerDefaultBlockItem(name, toReturn, tab);
        return toReturn;
    }

    //Register Duckweed block and item
    public static <T extends Block> RegistryObject<T> registerDuckweedBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = RegionsUnexploredMod.BLOCK_REGISTRY.register(name, block);
        ItemRegistry.registerDuckweedItem(name, toReturn, tab);
        return toReturn;
    }
    
    //Register Lily block and item
    public static <T extends Block> RegistryObject<T> registerLilyBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = RegionsUnexploredMod.BLOCK_REGISTRY.register(name, block);
        ItemRegistry.registerLilyItem(name, toReturn, tab);
        return toReturn;
    }

    public static PineLogBlock pineLog(MaterialColor colour, MaterialColor colour2, SoundType sound) {
        return new PineLogBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? colour : colour2;
        }).strength(2.0F).sound(sound));
    }
    public static AspenLogBlock aspenLogBlock(MaterialColor colour, MaterialColor colour2, SoundType sound) {
        return new AspenLogBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? colour : colour2;
        }).strength(2.0F).sound(sound));
    }
    //Configure log block
    public static RotatedPillarBlock log(MaterialColor colour, MaterialColor colour2, SoundType sound) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? colour : colour2;
        }).strength(2.0F).sound(sound));
    }
    //Configure wood block
    public static RotatedPillarBlock woodBlock(MaterialColor colour, SoundType sound) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden planks
    public static Block woodPlanks(MaterialColor colour, SoundType sound) {
        return new Block(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden stairs
    public static StairBlock woodStairs(MaterialColor colour, SoundType sound) {
        return new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden slab
    public static SlabBlock woodSlab(MaterialColor colour, SoundType sound) {
        return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden door
    public static DoorBlock woodDoor(MaterialColor colour, SoundType sound) {
        return new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(3.0F).sound(sound).noOcclusion());
    }
    //Configure wooden trap door
    public static TrapDoorBlock woodTrapDoor(MaterialColor colour, SoundType sound) {
        return new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(3.0F).sound(sound).noOcclusion());
    }
    //Configure wooden fence
    public static FenceBlock woodFence(MaterialColor colour, SoundType sound) {
        return new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden gate
    public static FenceGateBlock woodFenceGate(MaterialColor colour, SoundType sound) {
        return new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden pressure plate
    public static PressurePlateBlock woodPressurePlate(MaterialColor colour, SoundType sound) {
        return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, colour).noCollission().strength(0.5F).sound(sound));
    }
    //Configure wooden button
    public static WoodButtonBlock woodButton(SoundType sound) {
        return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(0.5F).sound(sound));
    }
    //Configure sign
    public static RuStandingSignBlock sign(SoundType sound, WoodType woodType) {
        return new RuStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(sound), woodType);
    }
    //Configure wall sign
    public static RuWallSignBlock wallSign(SoundType sound, Block block, WoodType woodType) {
        return new RuWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(sound).dropsLike(block), woodType);
    }
    //Configure log block
    public static RotatedPillarBlock fireproofLog(MaterialColor colour, MaterialColor colour2, SoundType sound) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, (p_152624_) -> {
            return p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? colour : colour2;
        }).strength(2.0F).sound(sound));
    }
    //Configure log block
    public static MagmaLogBlock fireproofMagmaLog(MaterialColor colour, SoundType sound) {
        return new MagmaLogBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F).sound(sound));
    }
    //Configure wood block
    public static RotatedPillarBlock fireproofWoodBlock(MaterialColor colour, SoundType sound) {
        return new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden planks
    public static Block fireproofWoodPlanks(MaterialColor colour, SoundType sound) {
        return new Block(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden stairs
    public static StairBlock fireproofWoodStairs(MaterialColor colour, SoundType sound) {
        return new StairBlock(Blocks.OAK_PLANKS.defaultBlockState(), BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden slab
    public static SlabBlock fireproofWoodSlab(MaterialColor colour, SoundType sound) {
        return new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden door
    public static DoorBlock fireproofWoodDoor(MaterialColor colour, SoundType sound) {
        return new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(3.0F).sound(sound).noOcclusion());
    }
    //Configure wooden trap door
    public static TrapDoorBlock fireproofWoodTrapDoor(MaterialColor colour, SoundType sound) {
        return new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(3.0F).sound(sound).noOcclusion());
    }
    //Configure wooden fence
    public static FenceBlock fireproofWoodFence(MaterialColor colour, SoundType sound) {
        return new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden gate
    public static FenceGateBlock fireproofWoodFenceGate(MaterialColor colour, SoundType sound) {
        return new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD, colour).strength(2.0F, 3.0F).sound(sound));
    }
    //Configure wooden pressure plate
    public static PressurePlateBlock fireproofWoodPressurePlate(MaterialColor colour, SoundType sound) {
        return new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD, colour).noCollission().strength(0.5F).sound(sound));
    }
    //Configure wooden button
    public static WoodButtonBlock fireproofWoodButton(SoundType sound) {
        return new WoodButtonBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(0.5F).sound(sound));
    }
    //Configure sign
    public static RuStandingSignBlock fireproofSign(SoundType sound, WoodType woodType) {
        return new RuStandingSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(sound), woodType);
    }
    //Configure wall sign
    public static RuWallSignBlock fireproofWallSign(SoundType sound, Block block, WoodType woodType) {
        return new RuWallSignBlock(BlockBehaviour.Properties.of(Material.WOOD).noCollission().strength(1.0F).sound(sound).dropsLike(block), woodType);
    }

    //Configure leaves blocks
    public static LeavesBlock leaves(MaterialColor colour) {
        return new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static LeavesBlock fireproofLeaves(MaterialColor colour) {
        return new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static MauveLeavesBlock mauveLeaves(MaterialColor colour) {
        return new MauveLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static BlueMagnoliaLeavesBlock blueMagnoliaLeaves(MaterialColor colour) {
        return new BlueMagnoliaLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static PinkMagnoliaLeavesBlock pinkMagnoliaLeaves(MaterialColor colour) {
        return new PinkMagnoliaLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static WhiteMagnoliaLeavesBlock whiteMagnoliaLeaves(MaterialColor colour) {
        return new WhiteMagnoliaLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static SilverBirchLeavesBlock silverBirchLeaves(MaterialColor colour) {
        return new SilverBirchLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static EnchantedBirchLeavesBlock enchantedBirchLeaves(MaterialColor colour) {
        return new EnchantedBirchLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static RedMapleLeavesBlock redMapleLeaves(MaterialColor colour) {
        return new RedMapleLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static OrangeMapleLeavesBlock orangeMapleLeaves(MaterialColor colour) {
        return new OrangeMapleLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static JoshuaLeavesBlock joshuaLeaves(MaterialColor colour) {
        return new JoshuaLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().noCollission());
    }
    public static LeavesBlock appleLeaves(MaterialColor colour) {
        return new AppleLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, colour).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isValidSpawn(BlockRegistry::ocelotOrParrot).isSuffocating(BlockRegistry::never).isViewBlocking(BlockRegistry::never));
    }
    public static BrimwoodLeavesBlock brimLeaves(MaterialColor colour) {
        return new BrimwoodLeavesBlock(colour);
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
