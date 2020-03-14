package com.peridot.mangoores.game.common.items.base;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {

    public ItemBase(ItemGroup itemGroup) {
        super(new Properties().group(itemGroup));
    }

    public ItemBase(ItemGroup itemGroup, Food food) {
        super(new Properties().group(itemGroup).food(food));
    }

}
