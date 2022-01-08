package fr.ringularity.infinite_power.ip_objects.group;

import fr.ringularity.infinite_power.InfinitePower;
import fr.ringularity.infinite_power.ip_objects.block.IPBlock;
import fr.ringularity.infinite_power.ip_objects.item.IPBlockItem;
import fr.ringularity.infinite_power.ip_objects.item.IPBlockItemCompressed;
import fr.ringularity.infinite_power.ip_objects.item.IPItem;
import fr.ringularity.infinite_power.utils.StringFormat;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.ArrayList;
import java.util.List;

public class IPMetal {
    public final IPItemBar bar;
    public final IPItemDust dust;
    public final IPItemIngot ingot;
    public final IPItemNugget nugget;
    public final IPItemPlate plate;
    public final IPItemWire wire;

    public final double fusionTemperature;
    public final double pressureScale;

    public final List<IPCompressed<IPBlock, IPBlockItem>> compressed;

    public IPMetal(String nameId, int compressAmount, double fusionTemperature, double pressureScale) {
        this.fusionTemperature = fusionTemperature;
        this.pressureScale = pressureScale;

        bar = new IPItemBar(
                nameId + "_bar",
                "metals/bars",
                new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB),
                List.of(
                        new TextComponent("Category : Metal/Bar")
                ),
                List.of(
                        new TextComponent("Way to get : Rolling mill")
                ),
                null
        );

        dust = new IPItemDust(
                nameId + "_dust",
                "metals/dusts",
                new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB),
                List.of(
                        new TextComponent("Category : Metal/Dust")
                ),
                List.of(
                        new TextComponent("Way to get : Crusher")
                ),
                null
        );

        ingot = new IPItemIngot(
                nameId + "_ingot",
                "metals/ingots",
                new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB),
                List.of(
                        new TextComponent("Category : Metal/Ingot")
                ),
                List.of(
                        new TextComponent("Way to get : " + getFurnaceType())
                ),
                null
        );

        nugget = new IPItemNugget(
                nameId + "_nugget",
                "metals/nuggets",
                new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB),
                List.of(
                        new TextComponent("Category : Metal/Nugget")
                ),
                List.of(
                        new TextComponent("Way to get : " + getFurnaceType() + " (" + StringFormat.engineOn(fusionTemperature) + "K)")
                ),
                null
        );

        plate = new IPItemPlate(
                nameId + "_plate",
                "metals/plates",
                new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB),
                List.of(
                        new TextComponent("Category : Metal/Plate")
                ),
                List.of(
                        new TextComponent("Way to get : Rolling mill")
                ),
                null
        );

        wire = new IPItemWire(
                nameId + "_wire",
                "metals/wires",
                new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB),
                List.of(
                        new TextComponent("Category : Metal/Wire")
                ),
                List.of(
                        new TextComponent("Way to get : Rolling mill")
                ),
                null
        );

        compressed = new ArrayList<>();
        for (int i = 1; i <= compressAmount; ++i) {
            IPBlock block = new IPBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.ICE)
                    .strength(2.0f, 15f).requiresCorrectToolForDrops().friction(0.5f));
            compressed.add(
                new IPCompressed<>(
                    nameId,
                    block,
                    new IPBlockItemCompressed(
                        block,
                        new Item.Properties().tab(InfinitePower.INFINITE_POWER_TAB),
                        List.of(
                                new TextComponent("Category : Metal/Compressed")
                        ),
                        pressureScale,
                        i
                    ),
                    i
                )
            );
        }
    }

    public void register() {
        bar.register();
        dust.register();
        ingot.register();
        nugget.register();
        plate.register();
        wire.register();

        for (IPCompressed<IPBlock, IPBlockItem> c : compressed)
            c.register();
    }

    private String getFurnaceType() {
        if (fusionTemperature <= 1600)
            return "Induction pyrolysis furnace";
        if (fusionTemperature <= 2000)
            return "Induction tube furnace";
        if (fusionTemperature <= 3000)
            return "Induction graphite furnace";
        if (fusionTemperature <= 5000)
            return "Induction dark matter furnace";
        if (fusionTemperature <= 10000)
            return "Chaos furnace";
        return "Infinity furnace";
    }

    private static class IPItemBar extends IPItem {
        public IPItemBar(String nameId, String customTextureFolder, Properties properties, List<TextComponent> ambientToolTip, List<TextComponent> shiftToolTip, List<TextComponent> ctrlToolTip) {
            super(nameId, customTextureFolder, properties, ambientToolTip, shiftToolTip, ctrlToolTip);
        }
    }

    private static class IPItemDust extends IPItem {
        public IPItemDust(String nameId, String customTextureFolder, Properties properties, List<TextComponent> ambientToolTip, List<TextComponent> shiftToolTip, List<TextComponent> ctrlToolTip) {
            super(nameId, customTextureFolder, properties, ambientToolTip, shiftToolTip, ctrlToolTip);
        }
    }

    private static class IPItemIngot extends IPItem {
        public IPItemIngot(String nameId, String customTextureFolder, Properties properties, List<TextComponent> ambientToolTip, List<TextComponent> shiftToolTip, List<TextComponent> ctrlToolTip) {
            super(nameId, customTextureFolder, properties, ambientToolTip, shiftToolTip, ctrlToolTip);
        }
    }

    private static class IPItemNugget extends IPItem {
        public IPItemNugget(String nameId, String customTextureFolder, Properties properties, List<TextComponent> ambientToolTip, List<TextComponent> shiftToolTip, List<TextComponent> ctrlToolTip) {
            super(nameId, customTextureFolder, properties, ambientToolTip, shiftToolTip, ctrlToolTip);
        }
    }

    private static class IPItemPlate extends IPItem {
        public IPItemPlate(String nameId, String customTextureFolder, Properties properties, List<TextComponent> ambientToolTip, List<TextComponent> shiftToolTip, List<TextComponent> ctrlToolTip) {
            super(nameId, customTextureFolder, properties, ambientToolTip, shiftToolTip, ctrlToolTip);
        }
    }

    private static class IPItemWire extends IPItem {
        public IPItemWire(String nameId, String customTextureFolder, Properties properties, List<TextComponent> ambientToolTip, List<TextComponent> shiftToolTip, List<TextComponent> ctrlToolTip) {
            super(nameId, customTextureFolder, properties, ambientToolTip, shiftToolTip, ctrlToolTip);
        }
    }
}
