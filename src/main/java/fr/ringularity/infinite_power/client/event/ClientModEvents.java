package fr.ringularity.infinite_power.client.event;

import fr.ringularity.infinite_power.InfinitePower;
import fr.ringularity.infinite_power.client.renderer.model.ExampleEntityModel;
import fr.ringularity.infinite_power.client.KeyInit;
import fr.ringularity.infinite_power.client.renderer.ExampleEntityRenderer;
import fr.ringularity.infinite_power.client.renderer.SeatRenderer;
import fr.ringularity.infinite_power.core.init.BlockInit;
import fr.ringularity.infinite_power.core.init.EntityInit;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = InfinitePower.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {

    private ClientModEvents() {
    }

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlockInit.LIGHTNING_JUMPER.get(), RenderType.cutout());
        KeyInit.init();
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(ExampleEntityModel.LAYER_LOCATION, ExampleEntityModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.EXAMPLE_ENTITY.get(), ExampleEntityRenderer::new);
        event.registerEntityRenderer(EntityInit.SEAT.get(), SeatRenderer::new);
    }
}
