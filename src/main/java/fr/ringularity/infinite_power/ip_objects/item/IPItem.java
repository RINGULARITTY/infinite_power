package fr.ringularity.infinite_power.ip_objects.item;

import fr.ringularity.infinite_power.core.init.ItemInit;
import fr.ringularity.infinite_power.utils.Converter;
import fr.ringularity.infinite_power.utils.StringFormat;
import fr.ringularity.infinite_power.utils.jsonRegister.JsonRegister;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IPItem extends Item {
    private static final TextComponent EMPTY = new TextComponent("");

    public List<TextComponent> ambientToolTip = null, shiftToolTip = null, ctrlToolTip = null;
    private final String nameId;

    public IPItem(String nameId, Properties properties) {
        super(properties);
        this.nameId = nameId;
        JsonRegister.addItem(nameId, StringFormat.getDisplayName(nameId), "", false);
    }

    public IPItem(String nameId, String customTextureFolder, Properties properties) {
        super(properties);
        this.nameId = nameId;
        JsonRegister.addItem(nameId, StringFormat.getDisplayName(nameId), customTextureFolder, false);
    }

    public IPItem(String nameId, String customTextureFolder, Properties properties, List<TextComponent> ambientToolTip, List<TextComponent> shiftToolTip, List<TextComponent> ctrlToolTip) {
        super(properties);
        this.nameId = nameId;
        this.ambientToolTip = ambientToolTip;
        this.shiftToolTip = shiftToolTip;
        this.ctrlToolTip = ctrlToolTip;
        JsonRegister.addItem(nameId, StringFormat.getDisplayName(nameId), customTextureFolder, false);
    }

    public RegistryObject<IPItem> register() {
        return ItemInit.ITEMS.register(nameId, () -> this);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @Nullable Level level, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        if (ambientToolTip != null)
            tooltip.addAll(ambientToolTip);
        if (shiftToolTip != null) {
            tooltip.add(EMPTY);
            tooltip.add(new TextComponent("[SHIFT] - Additional info").withStyle(ChatFormatting.YELLOW));
            if (Screen.hasShiftDown())
                tooltip.addAll(shiftToolTip);
        }
        if (ctrlToolTip != null) {
            tooltip.add(EMPTY);
            tooltip.add(new TextComponent("[CTRL] - Upgrades").withStyle(ChatFormatting.DARK_GREEN));
            if (Screen.hasControlDown())
                tooltip.addAll(ctrlToolTip);
        }
    }
}
