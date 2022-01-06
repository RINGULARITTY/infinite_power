package fr.ringularity.infinite_power.utils.jsonRegister.basics;

public class JsonBasicRegister extends JsonNameRegister {
    private final JsonLootRegister[] loots;

    public JsonBasicRegister(String nameId, String name) {
        super(nameId, name);
        loots = new JsonLootRegister[] { new JsonLootRegister(nameId, 1, 1, true, true) };
    }

    public JsonBasicRegister(String nameId, String name, JsonLootRegister[] registerLoots) {
        super(nameId, name);
        loots = registerLoots;
    }

    public String getAllLootContent() {
        final int lootSize = loots.length;
        StringBuilder lootContent = new StringBuilder("{\n" +
                "  \"type\": \"minecraft:block\",\n" +
                "  \"pools\": [\n" +
                "    {\n" +
                "      \"rolls\": " + lootSize + ",\n" +
                "      \"entries\": [\n");
        for (int i = 0; i < lootSize - 1; ++i) {
            lootContent.append(loots[i].getLootContent()).append(",\n");
        }
        lootContent.append(loots[lootSize - 1].getLootContent()).append("\n");
        lootContent.append("""
                      ]
                    }
                  ]
                }""");
        return lootContent.toString();
    }
}
