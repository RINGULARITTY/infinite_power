package fr.ringularity.infinite_power.utils.jsonRegister;

import fr.ringularity.infinite_power.utils.jsonRegister.basics.JsonBasicRegister;
import fr.ringularity.infinite_power.utils.jsonRegister.basics.JsonLootRegister;

import java.util.Objects;

import static fr.ringularity.infinite_power.InfinitePower.MOD_ID;

public class JsonBlockRegister extends JsonBasicRegister {
    private final String customTextureFolder;
    private final boolean customBlockModel, customItemModel;

    public JsonBlockRegister(String nameId, String name, String customTextureFolder, boolean customBlockModel, boolean customItemModel) {
        super(nameId, name);
        this.customTextureFolder = customTextureFolder;
        this.customBlockModel = customBlockModel;
        this.customItemModel = customItemModel;
    }

    public JsonBlockRegister(String nameId, String name, String customTextureFolder ,boolean customBlockModel, boolean customItemModel, JsonLootRegister[] registerLoots) {
        super(nameId, name, registerLoots);
        this.customTextureFolder = customTextureFolder;
        this.customBlockModel = customBlockModel;
        this.customItemModel = customItemModel;
    }

    public String getBlockStateContent() {
        if (customBlockModel)
            return "";
        return "{\n" +
                "    \"variants\": {\n" +
                "        \"\": { \"model\": \"" + MOD_ID + ":block/" + getNameId() + "\" }\n" +
                "    }\n" +
                "}";
    }

    public String getBlockModelContent() {
        if (customBlockModel)
            return "";
        return "{\n" +
                "    \"parent\": \"block/cube_all\",\n" +
                "    \"textures\": {\n" +
                "        \"all\":\"" + MOD_ID + ":blocks/" + (!Objects.equals(customTextureFolder, "") ? customTextureFolder + "/" : "") + getNameId() + "\"\n" +
                "    }\n" +
                "}";
    }

    public String getItemModelContent() {
        if (customItemModel)
            return "";
        return "{\n" +
                "    \"parent\": \"" + MOD_ID + ":block/" + getNameId() + "\"\n" +
                "}";
    }

    public String getLangContent() {
        return "\"block." + MOD_ID + "." + getNameId() + "\": \"" + getName() + "\"";
    }
}
