package fr.ringularity.infinite_power.core.init;

import fr.ringularity.infinite_power.InfinitePower;
import fr.ringularity.infinite_power.ip_objects.item.ClickerItem;
import fr.ringularity.infinite_power.ip_objects.item.IPItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public final class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            InfinitePower.MOD_ID);

    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new Item(new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB).fireResistant()));

    public static final RegistryObject<IPItem> TEST = new IPItem(
            "test",
            "",
            new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB),
            List.of(
                    (TextComponent) new TextComponent("oue c trop cool").withStyle(ChatFormatting.DARK_AQUA)
            ),
            null,
            null
        ).register();

    public static final RegistryObject<ClickerItem> CLICKER = ITEMS.register("clicker",
            () -> new ClickerItem(new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)));

    public static final RegistryObject<ForgeSpawnEggItem> EXAMPLE_ENTITY_SPAWN_EGG = ITEMS
            .register("example_entity_spawn_egg", () -> new ForgeSpawnEggItem(EntityInit.EXAMPLE_ENTITY,
                    0x1E51ED, 0x34BD27, new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)));

    public static final RegistryObject<Item> BEANS = ITEMS.register("beans",
            () -> new Item(new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)
                    .food(new FoodProperties.Builder().nutrition(5).saturationMod(4.5f)
                            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 360, 4), 0.7f)
                            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 500, 2), 0.2f)
                            .build())));

    // Tools
    public static final RegistryObject<SwordItem> BEAN_SWORD = ITEMS.register("bean_sword",
            () -> new SwordItem(ToolMaterialInit.BEANS, 20, 5f,
                    new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)));

    public static final RegistryObject<PickaxeItem> BEAN_PICKAXE = ITEMS.register("bean_pickaxe",
            () -> new PickaxeItem(ToolMaterialInit.BEANS, 20, 5f,
                    new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)));

    public static final RegistryObject<ShovelItem> BEAN_SHOVEL = ITEMS.register("bean_shovel",
            () -> new ShovelItem(ToolMaterialInit.BEANS, 20, 5f,
                    new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)));

    public static final RegistryObject<AxeItem> BEAN_AXE = ITEMS.register("bean_axe",
            () -> new AxeItem(ToolMaterialInit.BEANS, 20, 5f,
                    new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)));

    public static final RegistryObject<HoeItem> BEAN_HOE = ITEMS.register("bean_hoe",
            () -> new HoeItem(ToolMaterialInit.BEANS, 20, 5f,
                    new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)));

    // Armor
    public static final RegistryObject<ArmorItem> BEAN_HELMET = ITEMS.register("bean_helmet",
            () -> new ArmorItem(ArmorMaterialInit.BEANS, EquipmentSlot.HEAD,
                    new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)));

    public static final RegistryObject<ArmorItem> BEAN_CHESTPLATE = ITEMS.register("bean_chestplate",
            () -> new ArmorItem(ArmorMaterialInit.BEANS, EquipmentSlot.CHEST,
                    new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)));

    public static final RegistryObject<ArmorItem> BEAN_LEGGINGS = ITEMS.register("bean_leggings",
            () -> new ArmorItem(ArmorMaterialInit.BEANS, EquipmentSlot.LEGS,
                    new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)));

    public static final RegistryObject<ArmorItem> BEAN_BOOTS = ITEMS.register("bean_boots",
            () -> new ArmorItem(ArmorMaterialInit.BEANS, EquipmentSlot.FEET,
                    new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)));

    // Block Items
    public static final RegistryObject<BlockItem> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block",
            () -> new BlockItem(BlockInit.EXAMPLE_BLOCK.get(),
                    new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)));

    public static final RegistryObject<BlockItem> LIGHTNING_JUMPER_BLOCK_ITEM = ITEMS
            .register("lightning_jumper", () -> new BlockItem(BlockInit.LIGHTNING_JUMPER.get(),
                    new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)));

    public static final RegistryObject<BlockItem> TOILET_BLOCK_ITEM = ITEMS.register("toilet",
            () -> new BlockItem(BlockInit.TOILET.get(), new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB)));

    private ItemInit() {
    }
}
