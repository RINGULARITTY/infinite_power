package fr.ringularity.infinite_power.ip_objects.block;

import fr.ringularity.infinite_power.core.init.BlockInit;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class IPBlock extends Block {

    public IPBlock(Properties properties) {
        super(properties);
    }

    public RegistryObject<IPBlock> register(String nameId) {
        return BlockInit.BLOCKS.register(nameId, () -> this);
    }
}