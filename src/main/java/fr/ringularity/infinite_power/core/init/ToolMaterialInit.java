package fr.ringularity.infinite_power.core.init;

import fr.ringularity.infinite_power.core.BaseToolMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public final class ToolMaterialInit {
    protected static final Tier BEANS = new BaseToolMaterial(15.5f, 500, 5, 25f, 2500,
            () -> Ingredient.of(ItemInit.BEANS.get()));

    private ToolMaterialInit() {
    }
}
