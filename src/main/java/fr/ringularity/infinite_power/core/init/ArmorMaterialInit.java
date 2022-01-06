package fr.ringularity.infinite_power.core.init;

import fr.ringularity.infinite_power.InfinitePower;
import fr.ringularity.infinite_power.core.BaseArmorMaterial;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

public final class ArmorMaterialInit {
    public static final ArmorMaterial BEANS = new BaseArmorMaterial(100, new int[] { 950, 1400, 1800, 1000 },
            new int[] { 20, 35, 50, 27 }, 3.2f, 1.85f, InfinitePower.MOD_ID + ":bean",
            SoundEvents.BOAT_PADDLE_WATER, () -> Ingredient.of(ItemInit.BEANS.get()));

    private ArmorMaterialInit() {
    }
}
