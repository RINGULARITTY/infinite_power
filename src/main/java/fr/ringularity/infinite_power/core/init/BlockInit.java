package fr.ringularity.infinite_power.core.init;

import fr.ringularity.infinite_power.InfinitePower;
import fr.ringularity.infinite_power.ip_objects.block.LightningJumperBlock;
import fr.ringularity.infinite_power.ip_objects.block.ToiletBlock;
import fr.ringularity.infinite_power.ip_objects.group.IPMetal;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            InfinitePower.MOD_ID);

    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE)
                    .strength(2.0f, 15f).requiresCorrectToolForDrops().friction(0.5f)));

    public static final RegistryObject<LightningJumperBlock> LIGHTNING_JUMPER = BLOCKS
            .register("lightning_jumper",
                    () -> new LightningJumperBlock(BlockBehaviour.Properties
                            .of(Material.METAL, MaterialColor.TERRACOTTA_ORANGE).strength(8.0f, 30f)
                            .requiresCorrectToolForDrops().noOcclusion().dynamicShape()));

    public static final RegistryObject<ToiletBlock> TOILET = BLOCKS.register("toilet",
            () -> new ToiletBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK)
                    .requiresCorrectToolForDrops().noOcclusion().dynamicShape()));

    private BlockInit() {
    }
}
