package fr.ringularity.infinite_power.ip_objects.group;

import fr.ringularity.infinite_power.ip_objects.block.IPBlock;
import fr.ringularity.infinite_power.ip_objects.item.IPBlockItem;
import fr.ringularity.infinite_power.ip_objects.item.IPBlockWithItem;

public class IPCompressed<BLOCK extends IPBlock, BLOCK_ITEM extends IPBlockItem> extends IPBlockWithItem<BLOCK, BLOCK_ITEM> {

    public final int amount;

    public IPCompressed(String nameId, BLOCK block, BLOCK_ITEM blockItem, int amount) {
        super("compressed_" + nameId + "_" + amount, block, blockItem);
        this.amount = amount;
    }
}
