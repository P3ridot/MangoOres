package com.peridot.mangoores.game.common.itemgroups;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.items.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroupItems extends ItemGroup {

    public ItemGroupItems() {
        super(MangoOres.MOD_ID + ".items");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.MANGONIUM_INGOT);
    }
}
