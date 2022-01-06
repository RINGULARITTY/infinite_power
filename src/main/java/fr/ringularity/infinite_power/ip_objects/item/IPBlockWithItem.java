package fr.ringularity.infinite_power.ip_objects.item;

import fr.ringularity.infinite_power.ip_objects.block.IPBlock;

public class IPBlockWithItem<BLOCK extends IPBlock, BLOCK_ITEM extends IPBlockItem> {

    public final String nameId;
    public final BLOCK block;
    public final BLOCK_ITEM blockItem;

    public IPBlockWithItem(String nameId, BLOCK block, BLOCK_ITEM blockItem) {
        this.nameId = nameId;
        this.block = block;
        this.blockItem = blockItem;
    }

    public void register() {
        block.register(nameId);
        blockItem.register(nameId);
    }
}
