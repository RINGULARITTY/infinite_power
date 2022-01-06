package fr.ringularity.infinite_power.utils.jsonRegister.basics;

public class JsonNameRegister {
    private final String nameId, name;

    public JsonNameRegister(String nameId, String name) {
        this.nameId = nameId;
        this.name = name;
    }

    public String getNameId() { return nameId; }
    public String getName() { return name; }
}
