package fr.ringularity.infinite_power.client.renderer;

import fr.ringularity.infinite_power.InfinitePower;
import fr.ringularity.infinite_power.client.renderer.model.ExampleEntityModel;
import fr.ringularity.infinite_power.common.entity.ExampleEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ExampleEntityRenderer<Type extends ExampleEntity> extends MobRenderer<Type, ExampleEntityModel<Type>> {

	private static final ResourceLocation TEXTURE = new ResourceLocation(InfinitePower.MODID,
			"textures/entities/example_entity.png");

	public ExampleEntityRenderer(Context context) {
		super(context, new ExampleEntityModel<>(context.bakeLayer(ExampleEntityModel.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(Type entity) {
		return TEXTURE;
	}
}
