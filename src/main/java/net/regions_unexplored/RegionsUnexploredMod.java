package net.regions_unexplored;

import com.mojang.logging.LogUtils;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.entity.RuBlockEntities;
import net.regions_unexplored.client.particle.RuParticleTypes;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.config.RuPrimaryRegionConfig;
import net.regions_unexplored.config.RuSecondaryRegionConfig;
import net.regions_unexplored.data.worldgen.biome.RuBiomes;
import net.regions_unexplored.item.RuItems;
import net.regions_unexplored.registry.BiomeRegistry;
import net.regions_unexplored.registry.FeatureRegistry;
import net.regions_unexplored.world.features.foliageplacers.SakuraFoliagePlacer;
import net.regions_unexplored.world.features.foliageplacers.WillowFoliagePlacer;
import net.regions_unexplored.world.features.treedecorators.BlackwoodBioshroom;
import net.regions_unexplored.world.features.treedecorators.WillowTrunkDecorator;
import org.slf4j.Logger;

@Mod(RegionsUnexploredMod.MOD_ID)
public class RegionsUnexploredMod {
    public static final String MOD_ID = "regions_unexplored";

    //biome registry
    public static final DeferredRegister<Biome> BIOME_REGISTRY = DeferredRegister.create(Registries.BIOME, MOD_ID);
    //feature registries
    public static final DeferredRegister<Feature<?>> FEATURE_REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, RegionsUnexploredMod.MOD_ID);
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE_REGISTRY = DeferredRegister.create(Registries.CONFIGURED_FEATURE, MOD_ID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURE_REGISTRY = DeferredRegister.create(Registries.PLACED_FEATURE, MOD_ID);
    //block registries
    public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, RegionsUnexploredMod.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RegionsUnexploredMod.MOD_ID);
    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, RegionsUnexploredMod.MOD_ID);
    //other registries
    public static final DeferredRegister<EntityType<?>> ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, RegionsUnexploredMod.MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLE_REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, RegionsUnexploredMod.MOD_ID);

    public static final Logger LOGGER = LogUtils.getLogger();

    public RegionsUnexploredMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::clientSetup);
        bus.addListener(this::commonSetup);
        bus.addListener(this::registerTab);

        //add registries to IEventBus
        BIOME_REGISTRY.register(bus);
        FEATURE_REGISTRY.register(bus);
        CONFIGURED_FEATURE_REGISTRY.register(bus);
        PLACED_FEATURE_REGISTRY.register(bus);
        BLOCK_REGISTRY.register(bus);
        BLOCK_ENTITY_REGISTRY.register(bus);
        ITEM_REGISTRY.register(bus);
        ENTITY_REGISTRY.register(bus);
        PARTICLE_REGISTRY.register(bus);

        registerConfig();
        registerTreeDecorators();
        registerFoliagePlacers();

        BiomeRegistry.addBiomes();
        FeatureRegistry.addFeatures();
        RuBlocks.addBlocks();
        RuBlockEntities.addBlockEntities();
        RuItems.addItems();
        RuParticleTypes.addParticles();
    }

    //config method
    private void registerConfig(){
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, RuCommonConfig.SPEC, "regions_unexplored/ru-common.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, RuPrimaryRegionConfig.SPEC, "regions_unexplored/ru-primary-region.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, RuSecondaryRegionConfig.SPEC, "regions_unexplored/ru-secondary-region.toml");
    }

    //set up client side features
    public void clientSetup(final FMLClientSetupEvent event) {
    }

    //set up non-client side features
    private void commonSetup(final FMLCommonSetupEvent event) {
        BiomeRegistry.setupTerrablender();
    }

    private static void registerFoliagePlacers(){
        ForgeRegistries.FOLIAGE_PLACER_TYPES.register("willow_foliage_placer", WillowFoliagePlacer.fpt);
        ForgeRegistries.FOLIAGE_PLACER_TYPES.register("sakura_foliage_placer", SakuraFoliagePlacer.fpt);
    }

    private static void registerTreeDecorators(){
        ForgeRegistries.TREE_DECORATOR_TYPES.register("blackwood_bioshrooms", BlackwoodBioshroom.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("willow_trunk_decorator", WillowTrunkDecorator.tdt);
    }

    private void registerTab(CreativeModeTabEvent.Register event){
        event.registerCreativeModeTab(new ResourceLocation(MOD_ID, "main"), builder -> {
            builder.icon(() -> new ItemStack(RuBlocks.PRISMARITE_CLUSTER.get())).title(Component.translatable("itemGroup.regions_unexplored_main")).withSearchBar(50).displayItems((featureFlags, output) -> {
                output.accept(new ItemStack(RuBlocks.PRISMOSS.get()));
                output.accept(new ItemStack(RuBlocks.DEEPSLATE_PRISMOSS.get()));
                output.accept(new ItemStack(RuBlocks.HANGING_PRISMARITE.get()));
                output.accept(new ItemStack(RuBlocks.LARGE_PRISMARITE_CLUSTER.get()));
                output.accept(new ItemStack(RuBlocks.PRISMAGLASS.get()));
                output.accept(new ItemStack(RuBlocks.PRISMARITE_CLUSTER.get()));
                output.accept(new ItemStack(RuBlocks.PRISMOSS_SPROUT.get()));
                //REDSTONE_BLOCKS
                output.accept(new ItemStack(RuBlocks.POINTED_REDSTONE.get()));
                output.accept(new ItemStack(RuBlocks.RAW_REDSTONE_BLOCK.get()));
                output.accept(new ItemStack(RuBlocks.REDSTONE_BUD.get()));
                output.accept(new ItemStack(RuBlocks.REDSTONE_BULB.get()));
                //OTHER_CAVE_BLOCKS
                output.accept(new ItemStack(RuBlocks.STONE_GRASS_BLOCK.get()));
                output.accept(new ItemStack(RuBlocks.DEEPSLATE_GRASS_BLOCK.get()));
                output.accept(new ItemStack(RuBlocks.VIRIDESCENT_NYLIUM.get()));
                output.accept(new ItemStack(RuBlocks.DEEPSLATE_VIRIDESCENT_NYLIUM.get()));

                /*-----------------PLANTS-----------------*/
                //GRASS_BLOCKS
                output.accept(new ItemStack(RuBlocks.DEAD_STEPPE_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.FROZEN_GRASS.get()));
                output.accept(new ItemStack(RuBlocks.MEDIUM_GRASS.get()));
                output.accept(new ItemStack(RuBlocks.SANDY_GRASS.get()));
                output.accept(new ItemStack(RuBlocks.SEEDED_GRASS.get()));
                output.accept(new ItemStack(RuBlocks.SMALL_DESERT_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.STEPPE_GRASS.get()));
                output.accept(new ItemStack(RuBlocks.STEPPE_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.STONE_BUD.get()));
                //TALL_GRASS_BLOCKS
                output.accept(new ItemStack(RuBlocks.ELEPHANT_EAR.get()));
                output.accept(new ItemStack(RuBlocks.SANDY_TALL_GRASS.get()));
                output.accept(new ItemStack(RuBlocks.SEEDED_TALL_GRASS.get()));
                output.accept(new ItemStack(RuBlocks.STEPPE_TALL_GRASS.get()));
                output.accept(new ItemStack(RuBlocks.WINDSWEPT_GRASS.get()));
                //FLOWERS
                output.accept(new ItemStack(RuBlocks.ALPHA_DANDELION.get()));
                output.accept(new ItemStack(RuBlocks.ALPHA_ROSE.get()));
                output.accept(new ItemStack(RuBlocks.BLUE_LUPINE.get()));
                output.accept(new ItemStack(RuBlocks.DAISY.get()));
                output.accept(new ItemStack(RuBlocks.DORCEL.get()));
                output.accept(new ItemStack(RuBlocks.FELICIA_DAISY.get()));
                output.accept(new ItemStack(RuBlocks.FIREWEED.get()));
                output.accept(new ItemStack(RuBlocks.HYSSOP.get()));
                output.accept(new ItemStack(RuBlocks.PINK_LUPINE.get()));
                output.accept(new ItemStack(RuBlocks.POPPY_BUSH.get()));
                output.accept(new ItemStack(RuBlocks.PURPLE_LUPINE.get()));
                output.accept(new ItemStack(RuBlocks.RED_LUPINE.get()));
                output.accept(new ItemStack(RuBlocks.WARATAH.get()));
                output.accept(new ItemStack(RuBlocks.WHITE_TRILLIUM.get()));
                output.accept(new ItemStack(RuBlocks.WILTING_TRILLIUM.get()));
                output.accept(new ItemStack(RuBlocks.YELLOW_LUPINE.get()));

                output.accept(new ItemStack(RuBlocks.ORANGE_CONEFLOWER.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_PETALS.get()));

                output.accept(new ItemStack(RuBlocks.RED_SAKURA_FLOWERS.get()));
                output.accept(new ItemStack(RuBlocks.PINK_SAKURA_FLOWERS.get()));
                output.accept(new ItemStack(RuBlocks.WHITE_SAKURA_FLOWERS.get()));
                //TALL_PLANTS
                output.accept(new ItemStack(RuBlocks.MEADOW_SAGE.get()));
                output.accept(new ItemStack(RuBlocks.BARLEY.get()));
                output.accept(new ItemStack(RuBlocks.CATTAIL.get()));
                output.accept(new ItemStack(RuBlocks.TASSEL.get()));
                output.accept(new ItemStack(RuBlocks.TSUBAKI.get()));
                //SAPLINGS
                output.accept(new ItemStack(RuBlocks.ALPHA_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.APPLE_OAK_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.BAMBOO_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.CACTUS_FLOWER.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_PINE_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.FLOWERING_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.GOLDEN_LARCH_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.ORANGE_MAPLE_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.PALM_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.PINE_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.PINK_SAKURA_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.RED_SAKURA_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.RED_MAPLE_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.SILVER_BIRCH_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.WHITE_SAKURA_SAPLING.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_SAPLING.get()));
                //SHRUBS
                output.accept(new ItemStack(RuBlocks.ACACIA_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.BIRCH_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.DARK_OAK_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_PINE_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.FLOWERING_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.GOLDEN_LARCH_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.JUNGLE_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.MANGROVE_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.OAK_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.ORANGE_MAPLE_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.PALM_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.PINE_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.PINK_SAKURA_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.RED_SAKURA_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.RED_MAPLE_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.SILVER_BIRCH_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.SPRUCE_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.WHITE_SAKURA_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_SHRUB.get()));
                //MUSHROOMS
                output.accept(new ItemStack(RuBlocks.BLUE_BIOSHROOM.get()));
                output.accept(new ItemStack(RuBlocks.GREEN_BIOSHROOM.get()));
                output.accept(new ItemStack(RuBlocks.PINK_BIOSHROOM.get()));
                output.accept(new ItemStack(RuBlocks.YELLOW_BIOSHROOM.get()));
                output.accept(new ItemStack(RuBlocks.TALL_BLUE_BIOSHROOM.get()));
                output.accept(new ItemStack(RuBlocks.TALL_GREEN_BIOSHROOM.get()));
                output.accept(new ItemStack(RuBlocks.TALL_PINK_BIOSHROOM.get()));
                output.accept(new ItemStack(RuBlocks.TALL_YELLOW_BIOSHROOM.get()));
                //OTHER_PLANT_BLOCKS
                output.accept(new ItemStack(RuBlocks.BARREL_CACTUS.get()));
                output.accept(new ItemStack(RuBlocks.CAVE_HYSSOP.get()));
                output.accept(new ItemStack(RuBlocks.DUCKWEED.get()));
                output.accept(new ItemStack(RuBlocks.SPANISH_MOSS.get()));
                output.accept(new ItemStack(RuBlocks.FLOWERING_LILY_PAD.get()));
                //FOOD_PLANT_BLOCKS
                output.accept(new ItemStack(RuItems.SALMONBERRY.get()));

                /*-----------------PLANT_BLOCKS-----------------*/
                //MUSHROOMS
                output.accept(new ItemStack(RuBlocks.BLUE_BIOSHROOM_BLOCK.get()));
                output.accept(new ItemStack(RuBlocks.GLOWING_BLUE_BIOSHROOM_BLOCK.get()));
                output.accept(new ItemStack(RuBlocks.GREEN_BIOSHROOM_BLOCK.get()));
                output.accept(new ItemStack(RuBlocks.GLOWING_GREEN_BIOSHROOM_BLOCK.get()));
                output.accept(new ItemStack(RuBlocks.PINK_BIOSHROOM_BLOCK.get()));
                output.accept(new ItemStack(RuBlocks.GLOWING_PINK_BIOSHROOM_BLOCK.get()));
                output.accept(new ItemStack(RuBlocks.YELLOW_BIOSHROOM_BLOCK.get()));
                output.accept(new ItemStack(RuBlocks.GLOWING_YELLOW_BIOSHROOM_BLOCK.get()));
                //BAMBOO
                output.accept(new ItemStack(RuBlocks.BAMBOO_LOG.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_BAMBOO_LOG.get()));
                //CACTUS
                output.accept(new ItemStack(RuBlocks.SAGUARO_CACTUS.get()));

                /*-----------------LEAVES-----------------*/
                output.accept(new ItemStack(RuBlocks.ALPHA_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.APPLE_OAK_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.BAMBOO_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_PINE_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.FLOWERING_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.GOLDEN_LARCH_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.ORANGE_MAPLE_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.PALM_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.PINE_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.PINK_SAKURA_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.RED_SAKURA_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.RED_MAPLE_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.SILVER_BIRCH_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.WHITE_SAKURA_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_LEAVES.get()));

                /*-----------------BRANCHES-----------------*/
                output.accept(new ItemStack(RuBlocks.ACACIA_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.BIRCH_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.DARK_OAK_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_BEARD.get()));
                output.accept(new ItemStack(RuBlocks.JUNGLE_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.MANGROVE_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.OAK_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.PALM_BEARD.get()));
                output.accept(new ItemStack(RuBlocks.PINE_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.SILVER_BIRCH_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.SPRUCE_BRANCH.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_BRANCH.get()));

                /*-----------------DIRT_BLOCKS-----------------*/
                //FOREST_DIRT_BLOCKS
                output.accept(new ItemStack(RuBlocks.FOREST_GRASS_BLOCK.get()));
                output.accept(new ItemStack(RuBlocks.FOREST_DIRT.get()));
                output.accept(new ItemStack(RuBlocks.FOREST_DIRT_PATH.get()));
                output.accept(new ItemStack(RuBlocks.FOREST_COARSE_DIRT.get()));
                output.accept(new ItemStack(RuBlocks.FOREST_MUD.get()));
                output.accept(new ItemStack(RuBlocks.FOREST_FARMLAND.get()));
                //PLAINS_DIRT_BLOCKS
                output.accept(new ItemStack(RuBlocks.PLAINS_GRASS_BLOCK.get()));
                output.accept(new ItemStack(RuBlocks.PLAINS_DIRT.get()));
                output.accept(new ItemStack(RuBlocks.PLAINS_DIRT_PATH.get()));
                output.accept(new ItemStack(RuBlocks.PLAINS_COARSE_DIRT.get()));
                output.accept(new ItemStack(RuBlocks.PLAINS_MUD.get()));
                output.accept(new ItemStack(RuBlocks.PLAINS_FARMLAND.get()));
                //OTHER_DIRT_BLOCKS
                output.accept(new ItemStack(RuBlocks.ALPHA_GRASS_BLOCK.get()));

                /*-----------------STONE_BLOCKS-----------------*/
                //CHALKS
                output.accept(new ItemStack(RuBlocks.CHALK.get()));
                output.accept(new ItemStack(RuBlocks.CHALK_GRASS_BLOCK.get()));
                output.accept(new ItemStack(RuBlocks.CHALK_BRICKS.get()));
                output.accept(new ItemStack(RuBlocks.CHALK_BRICK_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.CHALK_BRICK_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.CHALK_PILLAR.get()));
                output.accept(new ItemStack(RuBlocks.CHALK_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.CHALK_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.POLISHED_CHALK.get()));
                output.accept(new ItemStack(RuBlocks.POLISHED_CHALK_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.POLISHED_CHALK_STAIRS.get()));
                //MOSSY_STONES
                output.accept(new ItemStack(RuBlocks.MOSSY_STONE.get()));

                /*-----------------OCEAN_BLOCKS-----------------*/
                //HYACINTH_BLOCKS
                output.accept(new ItemStack(RuBlocks.HYACINTH_BLOOM.get()));
                output.accept(new ItemStack(RuBlocks.HYACINTH_FLOWERS.get()));
                output.accept(new ItemStack(RuBlocks.HYACINTH_SEAGRASS.get()));
                output.accept(new ItemStack(RuBlocks.HYACINTH_STONE.get()));
                output.accept(new ItemStack(RuBlocks.TALL_HYACINTH_STOCK.get()));
                //ASHEN_BLOCKS
                output.accept(new ItemStack(RuBlocks.ASHEN_DIRT.get()));
                output.accept(new ItemStack(RuBlocks.ASHEN_SHRUB.get()));
                output.accept(new ItemStack(RuBlocks.ASHEN_LEAVES.get()));
                output.accept(new ItemStack(RuBlocks.ASHEN_GRASS.get()));

                /*-----------------OTHER_BLOCKS-----------------*/
                output.accept(new ItemStack(RuBlocks.ASH.get()));
                output.accept(new ItemStack(RuBlocks.VOLCANIC_ASH.get()));
                output.accept(new ItemStack(RuBlocks.ASH_VENT.get()));
                output.accept(new ItemStack(RuBlocks.QUICKSAND.get()));

                /*-----------------WOOD_TYPES-----------------*/
                //ASHEN_BLOCKS
                output.accept(new ItemStack(RuBlocks.ASHEN_LOG.get()));
                output.accept(new ItemStack(RuBlocks.ASHEN_WOOD.get()));
                //SILVER_BIRCH_BLOCKS
                output.accept(new ItemStack(RuBlocks.SILVER_BIRCH_LOG.get()));
                output.accept(new ItemStack(RuBlocks.SILVER_BIRCH_WOOD.get()));
                //ALPHA_BLOCKS
                output.accept(new ItemStack(RuBlocks.ALPHA_LOG.get()));
                output.accept(new ItemStack(RuBlocks.ALPHA_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.ALPHA_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.ALPHA_SLAB.get()));
                //BAOBAB_BLOCKS
                output.accept(new ItemStack(RuBlocks.BAOBAB_LOG.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_BAOBAB_LOG.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_BAOBAB_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.BAOBAB_SIGN.get()));
                //BLACKWOOD_BLOCKS
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_LOG.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_BLACKWOOD_LOG.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_BLACKWOOD_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.BLACKWOOD_SIGN.get()));
                //BRIMWOOD_BLOCKS
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_LOG.get()));
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_LOG_MAGMA.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_BRIMWOOD_LOG.get()));
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_BRIMWOOD_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.BRIMWOOD_SIGN.get()));
                //SAKURA_BLOCKS
                output.accept(new ItemStack(RuBlocks.SAKURA_LOG.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_SAKURA_LOG.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_SAKURA_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.SAKURA_SIGN.get()));
                //CYPRESS_BLOCKS
                output.accept(new ItemStack(RuBlocks.CYPRESS_LOG.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_CYPRESS_LOG.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_CYPRESS_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.CYPRESS_SIGN.get()));
                //DEAD_BLOCKS
                output.accept(new ItemStack(RuBlocks.DEAD_LOG.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_DEAD_LOG.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_DEAD_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.DEAD_SIGN.get()));
                //EUCALYPTUS_BLOCKS
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_LOG.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_EUCALYPTUS_LOG.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_EUCALYPTUS_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.EUCALYPTUS_SIGN.get()));
                //JOSHUA_BLOCKS
                output.accept(new ItemStack(RuBlocks.JOSHUA_LOG.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_JOSHUA_LOG.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_JOSHUA_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.JOSHUA_SIGN.get()));
                //LARCH_BLOCKS
                output.accept(new ItemStack(RuBlocks.LARCH_LOG.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_LARCH_LOG.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_LARCH_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.LARCH_SIGN.get()));
                //MAPLE_BLOCKS
                output.accept(new ItemStack(RuBlocks.MAPLE_LOG.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_MAPLE_LOG.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_MAPLE_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.MAPLE_SIGN.get()));
                //MAUVE_BLOCKS
                output.accept(new ItemStack(RuBlocks.MAUVE_LOG.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_MAUVE_LOG.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_MAUVE_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.MAUVE_SIGN.get()));
                //PALM_BLOCKS
                output.accept(new ItemStack(RuBlocks.PALM_LOG.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_PALM_LOG.get()));
                output.accept(new ItemStack(RuBlocks.PALM_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_PALM_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.PALM_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.PALM_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.PALM_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.PALM_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.PALM_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.PALM_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.PALM_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.PALM_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.PALM_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.PALM_SIGN.get()));
                //PINE_BLOCKS
                output.accept(new ItemStack(RuBlocks.PINE_LOG.get()));
                output.accept(new ItemStack(RuBlocks.PINE_LOG_TRANSITION.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_PINE_LOG.get()));
                output.accept(new ItemStack(RuBlocks.PINE_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_PINE_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.PINE_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.PINE_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.PINE_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.PINE_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.PINE_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.PINE_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.PINE_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.PINE_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.PINE_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.PINE_SIGN.get()));
                //REDWOOD_BLOCKS
                output.accept(new ItemStack(RuBlocks.REDWOOD_LOG.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_REDWOOD_LOG.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_REDWOOD_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.REDWOOD_SIGN.get()));
                //WILLOW_BLOCKS
                output.accept(new ItemStack(RuBlocks.WILLOW_LOG.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_WILLOW_LOG.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.STRIPPED_WILLOW_WOOD.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_FENCE.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_DOOR.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_FENCE_GATE.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_TRAPDOOR.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_PRESSURE_PLATE.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_BUTTON.get()));
                output.accept(new ItemStack(RuBlocks.WILLOW_SIGN.get()));

                /*-----------------PAINTED PLANKS-----------------*/
                //PLANKS
                output.accept(new ItemStack(RuBlocks.RED_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.ORANGE_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.YELLOW_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.LIME_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.GREEN_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.CYAN_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.LIGHT_BLUE_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.BLUE_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.PURPLE_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.MAGENTA_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.PINK_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.BROWN_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.WHITE_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.LIGHT_GRAY_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.GRAY_PAINTED_PLANKS.get()));
                output.accept(new ItemStack(RuBlocks.BLACK_PAINTED_PLANKS.get()));
                //STAIRS
                output.accept(new ItemStack(RuBlocks.RED_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.ORANGE_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.YELLOW_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.LIME_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.GREEN_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.CYAN_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.LIGHT_BLUE_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.BLUE_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.PURPLE_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.MAGENTA_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.PINK_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.BROWN_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.WHITE_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.LIGHT_GRAY_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.GRAY_PAINTED_STAIRS.get()));
                output.accept(new ItemStack(RuBlocks.BLACK_PAINTED_STAIRS.get()));
                //SLABS
                output.accept(new ItemStack(RuBlocks.RED_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.ORANGE_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.YELLOW_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.LIME_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.GREEN_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.CYAN_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.LIGHT_BLUE_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.BLUE_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.PURPLE_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.MAGENTA_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.PINK_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.BROWN_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.WHITE_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.LIGHT_GRAY_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.GRAY_PAINTED_SLAB.get()));
                output.accept(new ItemStack(RuBlocks.BLACK_PAINTED_SLAB.get()));

                /*-----------------NETHER_BLOCKS-----------------*/
                //NETHER_STONES
                output.accept(new ItemStack(RuBlocks.BLACKSTONE_CLUSTER.get()));
                output.accept(new ItemStack(RuBlocks.MARROWSTONE.get()));
                //BRIMSPROUT_BLOCKS
                output.accept(new ItemStack(RuBlocks.BRIMSPROUT_NYLIUM.get()));
                output.accept(new ItemStack(RuBlocks.BRIMSPROUT.get()));
                //COBALT_BLOCKS
                output.accept(new ItemStack(RuBlocks.COBALT_EARLIGHT.get()));
                output.accept(new ItemStack(RuBlocks.COBALT_NYLIUM.get()));
                output.accept(new ItemStack(RuBlocks.COBALT_OBSIDIAN.get()));
                output.accept(new ItemStack(RuBlocks.COBALT_ROOTS.get()));
                output.accept(new ItemStack(RuBlocks.HANGING_EARLIGHT.get()));
                //GLISTERING_BLOCKS
                output.accept(new ItemStack(RuBlocks.GLISTERING_IVY.get()));
                output.accept(new ItemStack(RuBlocks.GLISTERING_NYLIUM.get()));
                output.accept(new ItemStack(RuBlocks.GLISTERING_SPROUT.get()));
                output.accept(new ItemStack(RuBlocks.GLISTERING_WART.get()));
                output.accept(new ItemStack(RuBlocks.GLISTER_BULB.get()));
                output.accept(new ItemStack(RuBlocks.GLISTER_SPIRE.get()));
                //MYCOTOXIC_BLOCKS
                output.accept(new ItemStack(RuBlocks.MYCOTOXIC_DAISY.get()));
                output.accept(new ItemStack(RuBlocks.MYCOTOXIC_GRASS.get()));
                output.accept(new ItemStack(RuBlocks.MYCOTOXIC_NYLIUM.get()));
            });
        });
    }
}
