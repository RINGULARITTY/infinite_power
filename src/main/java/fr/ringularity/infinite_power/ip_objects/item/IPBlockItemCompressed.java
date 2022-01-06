package fr.ringularity.infinite_power.ip_objects.item;

import fr.ringularity.infinite_power.utils.StringFormat;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.level.block.Block;

import java.util.List;

public class IPBlockItemCompressed extends IPBlockItem {

    public IPBlockItemCompressed(Block block, Properties properties, List<TextComponent> ambientToolTip, double pressureScale, int amount) {
        super(block, properties, ambientToolTip,
            List.of(
                    new TextComponent("Way to get : " + getPressType(pressureScale * (double) amount) + " (" + StringFormat.engineOn(pressureScale * (double) amount) + " bar)")
            ),
            List.of(
                    new TextComponent("Contains " + StringFormat.engineOn(Math.pow(9, amount)) + " blocks")
            )
        );
    }

    private static String getPressType(double pressure) {
        if (pressure <= 50000)
            return "Hydrolytic press";
        if (pressure <= 1000000)
            return "Quantum press";
        if (pressure <= 50000000)
            return "Chaotic press";
        return "Infinity press";
    }
}
