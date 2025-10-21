package net.enderflame.luminara.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ManaFragmentItem extends Item {
    public ManaFragmentItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }


}
