package net.regions_unexplored.client.renderer;

import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.ChestBoatModel;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.regions_unexplored.RegionsUnexploredMod;
import net.regions_unexplored.entity.RuEntities;
import net.regions_unexplored.entity.custom.RuBoat;
import net.regions_unexplored.entity.custom.RuChestBoat;

@Mod.EventBusSubscriber(modid = RegionsUnexploredMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class RuEntityRenderer {
    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        LayerDefinition boatLayerDefinition = BoatModel.createBodyModel();
        LayerDefinition chestBoatLayerDefinition = ChestBoatModel.createBodyModel();
        for (RuBoat.ModelType type : RuBoat.ModelType.values()) {
            ForgeHooksClient.registerLayerDefinition(RuBoatRenderer.boatTextureLocation(type), () -> boatLayerDefinition);
            ForgeHooksClient.registerLayerDefinition(RuBoatRenderer.chestBoatTextureLocation(type), () -> chestBoatLayerDefinition);
        }
        event.registerEntityRenderer((EntityType<RuBoat>) RuEntities.BOAT.get(), context -> new RuBoatRenderer(context, false));
        event.registerEntityRenderer((EntityType<RuChestBoat>) RuEntities.CHEST_BOAT.get(), context -> new RuBoatRenderer(context, true));
    }
}
