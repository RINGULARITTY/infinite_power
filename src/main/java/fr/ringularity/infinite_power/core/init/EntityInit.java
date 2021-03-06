package fr.ringularity.infinite_power.core.init;

import fr.ringularity.infinite_power.InfinitePower;
import fr.ringularity.infinite_power.ip_objects.entity.SittableEntity;
import fr.ringularity.infinite_power.ip_objects.entity.ExampleEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister
            .create(ForgeRegistries.ENTITIES, InfinitePower.MOD_ID);

    public static final RegistryObject<EntityType<ExampleEntity>> EXAMPLE_ENTITY = ENTITIES.register(
            "example_entity",
            () -> EntityType.Builder.of(ExampleEntity::new, MobCategory.CREATURE).sized(0.8f, 0.6f)
                    .build(new ResourceLocation(InfinitePower.MOD_ID, "example_entity").toString()));

    public static final RegistryObject<EntityType<SittableEntity>> SEAT = ENTITIES.register("seat",
            () -> EntityType.Builder.<SittableEntity>of(SittableEntity::new, MobCategory.MISC).sized(1f, 1f)
                    .build(new ResourceLocation(InfinitePower.MOD_ID, "seat").toString()));

    private EntityInit() {
    }
}
