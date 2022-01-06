package fr.ringularity.infinite_power.core.init;

import fr.ringularity.infinite_power.InfinitePower;
import fr.ringularity.infinite_power.ip_objects.block.entity.ToiletBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockEntityInit {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister
            .create(ForgeRegistries.BLOCK_ENTITIES, InfinitePower.MOD_ID);

    public static final RegistryObject<BlockEntityType<ToiletBlockEntity>> TOILET = BLOCK_ENTITIES.register(
            "toilet",
            () -> BlockEntityType.Builder.of(ToiletBlockEntity::new, BlockInit.TOILET.get()).build(null));

    private BlockEntityInit() {
    }
}
