package fr.ringularity.infinite_power.client;

import fr.ringularity.infinite_power.ip_objects.block.entity.ToiletBlockEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;

@SuppressWarnings("resource")
public class ClientAccess {
    public static boolean updateToilet(BlockPos pos) {
        final BlockEntity blockEntity = Minecraft.getInstance().level.getBlockEntity(pos);
        if (blockEntity instanceof final ToiletBlockEntity toilet) {
            toilet.isShitting = false;
            toilet.fartTicker = 0;
            return true;
        }

        return false;
    }
}
