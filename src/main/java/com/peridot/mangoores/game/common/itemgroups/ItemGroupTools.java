package com.peridot.mangoores.game.common.itemgroups;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.items.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemGroupTools extends ItemGroup {

    public ItemGroupTools() {
        super(MangoOres.MOD_ID + ".tools");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.MANGO_WRENCH);
    }

    @Override
    public void fill(NonNullList<ItemStack> items) {
        super.fill(items);
        items.sort(ModItemGroups.tabSorter);
    }

}
