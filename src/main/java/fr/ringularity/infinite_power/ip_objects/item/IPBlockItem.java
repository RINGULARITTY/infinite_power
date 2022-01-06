package fr.ringularity.infinite_power.ip_objects.item;

import fr.ringularity.infinite_power.core.init.ItemInit;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class IPBlockItem extends BlockItem {

    private static final TextComponent EMPTY = new TextComponent("");

    private List<TextComponent> ambientToolTip = null, shiftToolTip = null, ctrlToolTip = null;

    public IPBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    public IPBlockItem(Block block, Properties properties, List<TextComponent> ambientToolTip, List<TextComponent> shiftToolTip, List<TextComponent> ctrlToolTip) {
        super(block, properties);
        this.ambientToolTip = ambientToolTip;
        this.shiftToolTip = shiftToolTip;
        this.ctrlToolTip = ctrlToolTip;
    }

    public RegistryObject<IPBlockItem> register(String nameId) {
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