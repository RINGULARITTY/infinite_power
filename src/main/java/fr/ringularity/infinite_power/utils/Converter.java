package fr.ringularity.infinite_power.utils;

import net.minecraft.network.chat.TextComponent;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List<TextComponent> convertListString(List<String> strings) {
        ArrayList<TextComponent> texts = new ArrayList<>();
        for (String s : strings)
            texts.add(new TextComponent(s));
        return texts;
    }
}
