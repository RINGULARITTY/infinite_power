package fr.ringularity.infinite_power.utils.jsonRegister;

import fr.ringularity.infinite_power.utils.jsonRegister.basics.JsonNameRegister;

import static fr.ringularity.infinite_power.InfinitePower.MOD_ID;

public class JsonItemGroupRegister extends JsonNameRegister {

    public JsonItemGroupRegister(String nameId, String name) {
        super(nameId, name);
    }

    public String getLangContent() {
        return "\"item_group." + MOD_ID + "." + getNameId() + "\": \"" + getName() + "\"";
    }
}
