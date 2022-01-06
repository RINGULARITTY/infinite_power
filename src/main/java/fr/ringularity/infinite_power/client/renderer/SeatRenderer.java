package fr.ringularity.infinite_power.client.renderer;

import fr.ringularity.infinite_power.InfinitePower;
import fr.ringularity.infinite_power.ip_objects.entity.SittableEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;

public class SeatRenderer extends EntityRenderer<SittableEntity> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(InfinitePower.MOD_ID, "");

    public SeatRenderer(Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(SittableEntity entity) {
        return TEXTURE;
    }
}
