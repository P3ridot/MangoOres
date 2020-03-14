package com.peridot.mangoores.game.common.items.base;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

    public ItemBase(ItemGroup itemGroup) {
        super(new Properties().group(itemGroup));
    }

}
