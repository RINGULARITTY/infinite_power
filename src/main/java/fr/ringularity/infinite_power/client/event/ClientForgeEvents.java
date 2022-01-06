package fr.ringularity.infinite_power.client.event;

import fr.ringularity.infinite_power.InfinitePower;
import fr.ringularity.infinite_power.ip_objects.block.entity.ToiletBlockEntity;
import fr.ringularity.infinite_power.ip_objects.entity.SittableEntity;
import fr.ringularity.infinite_power.client.KeyInit;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.ClientTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = InfinitePower.MOD_ID, bus = Bus.FORGE, value = Dist.CLIENT)
public final class ClientForgeEvents {
    private ClientForgeEvents() {
    }

    @SuppressWarnings("resource")
    @SubscribeEvent
    public static void clientTick(ClientTickEvent event) {
        final var player = Minecraft.getInstance().player;
        if ((KeyInit.exampleKeyMapping.isDown() && player.isPassenger()
                && player.getVehicle() instanceof SittableEntity)
                && (player.level.getBlockEntity(
                        player.getVehicle().blockPosition())instanceof final ToiletBlockEntity toilet)) {
            toilet.setShitting();
        }
    }
}
