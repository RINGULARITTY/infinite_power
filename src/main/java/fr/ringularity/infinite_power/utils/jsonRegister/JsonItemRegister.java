package fr.ringularity.infinite_power.utils.jsonRegister;

import fr.ringularity.infinite_power.utils.jsonRegister.basics.JsonNameRegister;

import java.util.Objects;

import static fr.ringularity.infinite_power.InfinitePower.MOD_ID;


public class JsonItemRegister extends JsonNameRegister {
    private final String customTextureFolder;
    private final boolean customItemModel;

    public JsonItemRegister(String nameId, String name, String customTextureFolder, boolean customItemModel) {
        super(nameId, name);
        this.customTextureFolder = customTextureFolder;
        this.customItemModel = customItemModel;
    }

    public String getItemModelContent() {
        if (customItemModel)
            return "";
        return "{\n" +
                "  \"parent\": \"item/generated\",\n" +
                "  \"textures\": {\n" +
                "    \"layer0\": \"" + MOD_ID + ":" + (!Objects.equals(customTextureFolder, "") ? customTextureFolder + "/" : "items/") + getNameId() + "\"\n" +
                "  }\n" +
                "}";
    }

    public String getLangContent() {
        return "\"item." + MOD_ID + "." + getNameId() + "\": \"" + getName() + "\"";
    }
}
