package fr.ringularity.infinite_power.client;

import com.mojang.blaze3d.platform.InputConstants;

import fr.ringularity.infinite_power.InfinitePower;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.ClientRegistry;

public final class KeyInit {
    public static KeyMapping exampleKeyMapping;

    private KeyInit() {
    }

    public static void init() {
        exampleKeyMapping = registerKey("example_key", KeyMapping.CATEGORY_GAMEPLAY, InputConstants.KEY_S);
    }

    private static KeyMapping registerKey(String name, String category, int keycode) {
        final var key = new KeyMapping("key." + InfinitePower.MOD_ID + "." + name, keycode, category);
        ClientRegistry.registerKeyBinding(key);
        return key;
    }
}
