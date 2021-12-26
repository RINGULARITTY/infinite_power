package fr.ringularity.infinite_power.core.event;

import fr.ringularity.infinite_power.InfinitePower;
import fr.ringularity.infinite_power.core.init.EntityInit;
import fr.ringularity.infinite_power.core.init.PacketHandler;
import fr.ringularity.infinite_power.core.world.OreGeneration;
import fr.ringularity.infinite_power.common.entity.ExampleEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = InfinitePower.MODID, bus = Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            OreGeneration.registerOres();
            PacketHandler.init();
            SpawnPlacements.register(EntityInit.EXAMPLE_ENTITY.get(), SpawnPlacements.Type.ON_GROUND,
                    Heightmap.Types.WORLD_SURFACE, ExampleEntity::canSpawn);
        });
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.EXAMPLE_ENTITY.get(), ExampleEntity.createAttributes().build());
    }
}
