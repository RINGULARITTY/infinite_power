package fr.ringularity.infinite_power.utils.jsonRegister.basics;

import static fr.ringularity.infinite_power.InfinitePower.MOD_ID;

public class JsonLootRegister {
    private final String itemId;
    private final int minAmount, maxAmount;
    private final boolean defaultLoot, isABlock;

    public JsonLootRegister(String itemId, int minAmount, int maxAmount, boolean defaultLoot, boolean isABlock) {
        this.itemId = itemId;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        this.defaultLoot = defaultLoot;
        this.isABlock = isABlock;
    }

    public String getLootContent() {
        if (defaultLoot)
            return "        {\n" +
                    "          \"type\": \"minecraft:" + (isABlock ? "block" : "item") + "\",\n" +
                    "          \"name\": \"" + MOD_ID + ":" + itemId + "\"\n" +
                    "        }";
        else
            return  "        {\n" +
                    "          \"type\": \"minecraft:alternatives\",\n" +
                    "          \"children\": [\n" +
                    "            {\n" +
                    "              \"type\": \"minecraft:" + (isABlock ? "block" : "item") + "\",\n" +
                    "              \"functions\": [\n" +
                    "                {\n" +
                    "                  \"function\": \"minecraft:set_count\",\n" +
                    "                  \"count\": {\n" +
                    "                    \"min\": " + minAmount + ",\n" +
                    "                    \"max\": " + maxAmount + ",\n" +
                    "                    \"type\": \"minecraft:uniform\"\n" +
                    "                  }\n" +
                    "                }\n" +
                    "              ],\n" +
                    "              \"name\": \"" + MOD_ID + ":" + itemId + "\"\n" +
                    "            }\n" +
                    "          ]\n" +
                    "        }";
    }
}
