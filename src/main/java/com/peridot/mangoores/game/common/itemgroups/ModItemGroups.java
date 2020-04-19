package com.peridot.mangoores.game.common.itemgroups;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import java.util.Comparator;

public class ModItemGroups {

    public static Comparator<ItemStack> tabSorter;

    public static final ItemGroup BLOCKS = new ItemGroupBlocks();
    public static final ItemGroup ITEMS = new ItemGroupItems();
    public static final ItemGroup ARMORS = new ItemGroupArmors();
    public static final ItemGroup TOOLS = new ItemGroupTools();
    public static final ItemGroup FOOD = new ItemGroupFood();

}
