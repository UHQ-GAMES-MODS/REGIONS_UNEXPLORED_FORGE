package net.regions_unexplored;

import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.regions_unexplored.block.RuBlocks;
import net.regions_unexplored.block.compat.BlockToolCompat;
import net.regions_unexplored.block.compat.CompostableBlocks;
import net.regions_unexplored.block.compat.FlammableBlocks;
import net.regions_unexplored.block.compat.PottedPlants;
import net.regions_unexplored.block.entity.RuBlockEntities;
import net.regions_unexplored.client.particle.RuParticleTypes;
import net.regions_unexplored.config.RuCommonConfig;
import net.regions_unexplored.config.RuPrimaryRegionConfig;
import net.regions_unexplored.config.RuSecondaryRegionConfig;
import net.regions_unexplored.data.noise.RuNoises;
import net.regions_unexplored.entity.RuEntities;
import net.regions_unexplored.item.RuItems;
import net.regions_unexplored.item.tab.RuTabs;
import net.regions_unexplored.registry.BiomeRegistry;
import net.regions_unexplored.registry.FeatureRegistry;
import net.regions_unexplored.registry.WoodTypeRegistry;
import net.regions_unexplored.world.features.foliageplacers.SakuraFoliagePlacer;
import net.regions_unexplored.world.features.foliageplacers.WillowFoliagePlacer;
import net.regions_unexplored.world.features.treedecorators.BlackwoodBioshroom;
import net.regions_unexplored.world.features.treedecorators.ChanceWillowTrunkDecorator;
import net.regions_unexplored.world.features.treedecorators.WillowTrunkDecorator;
import org.slf4j.Logger;

@Mod(RegionsUnexploredMod.MOD_ID)
public class RegionsUnexploredMod {
    public static final String MOD_ID = "regions_unexplored";

    //biome registry
    public static final DeferredRegister<Biome> BIOME_REGISTRY = DeferredRegister.create(Registry.BIOME_REGISTRY, MOD_ID);
    //feature registries
    public static final DeferredRegister<Feature<?>> FEATURE_REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, MOD_ID);
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE_REGISTRY = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, MOD_ID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURE_REGISTRY = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, MOD_ID);
    public static final DeferredRegister<NormalNoise.NoiseParameters> NOISE_REGISTRY = DeferredRegister.create(Registry.NOISE_REGISTRY, MOD_ID);
    //block registries
    public static final DeferredRegister<Block> BLOCK_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MOD_ID);
    public static final DeferredRegister<Item> ITEM_REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, MOD_ID);
    //other registries
    public static final DeferredRegister<EntityType<?>> ENTITY_REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MOD_ID);
    public static final DeferredRegister<ParticleType<?>> PARTICLE_REGISTRY = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MOD_ID);

    public static final Logger LOGGER = LogUtils.getLogger();

    public RegionsUnexploredMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::clientSetup);
        bus.addListener(this::commonSetup);

        //add registries to IEventBus
        BIOME_REGISTRY.register(bus);
        FEATURE_REGISTRY.register(bus);
        CONFIGURED_FEATURE_REGISTRY.register(bus);
        PLACED_FEATURE_REGISTRY.register(bus);
        NOISE_REGISTRY.register(bus);
        BLOCK_REGISTRY.register(bus);
        BLOCK_ENTITY_REGISTRY.register(bus);
        ITEM_REGISTRY.register(bus);
        ENTITY_REGISTRY.register(bus);
        PARTICLE_REGISTRY.register(bus);

        registerConfig();
        registerTreeDecorators();
        registerFoliagePlacers();

        RuTabs.load();
        BiomeRegistry.addBiomes();
        FeatureRegistry.addFeatures();
        RuNoises.addNoises();
        RuBlocks.addBlocks();
        RuBlockEntities.addBlockEntities();
        RuItems.addItems();
        RuEntities.addEntities();
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

        //Fix for branch transparency
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.ACACIA_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.BAOBAB_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.BIRCH_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.BLACKWOOD_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.MAGNOLIA_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.CYPRESS_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.CHERRY_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.DARK_OAK_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.DEAD_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.EUCALYPTUS_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.JOSHUA_BEARD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.JUNGLE_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.KAPOK_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.LARCH_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.MANGROVE_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.MAPLE_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.MAUVE_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.OAK_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.PALM_BEARD.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.PINE_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.REDWOOD_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.SILVER_BIRCH_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.SOCOTRA_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.SPRUCE_BRANCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(RuBlocks.WILLOW_BRANCH.get(), RenderType.cutout());

        WoodTypeRegistry.addWoodTypes();
        WoodTypeRegistry.addSheets();
        BlockEntityRenderers.register(RuBlockEntities.SIGN_BLOCK_ENTITIES.get(), SignRenderer::new);
    }

    //set up non-client side features
    private void commonSetup(final FMLCommonSetupEvent event) {
        BiomeRegistry.setupTerrablender();
        PottedPlants.setup();
        CompostableBlocks.setup();
        FlammableBlocks.setup();
        BlockToolCompat.setup();
    }

    private static void registerFoliagePlacers(){
        ForgeRegistries.FOLIAGE_PLACER_TYPES.register("willow_foliage_placer", WillowFoliagePlacer.fpt);
        ForgeRegistries.FOLIAGE_PLACER_TYPES.register("sakura_foliage_placer", SakuraFoliagePlacer.fpt);
    }

    private static void registerTreeDecorators(){
        ForgeRegistries.TREE_DECORATOR_TYPES.register("blackwood_bioshrooms", BlackwoodBioshroom.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("chance_willow_trunk_decorator", ChanceWillowTrunkDecorator.tdt);
        ForgeRegistries.TREE_DECORATOR_TYPES.register("willow_trunk_decorator", WillowTrunkDecorator.tdt);


    }


}
