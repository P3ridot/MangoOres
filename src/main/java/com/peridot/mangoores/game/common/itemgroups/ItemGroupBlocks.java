package com.peridot.mangoores.game.common.itemgroups;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.blocks.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemGroupBlocks extends ItemGroup {

    public ItemGroupBlocks() {
        super(MangoOres.MOD_ID + ".blocks");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModBlocks.MANGONIUM_BLOCK);
    }

    @Override
    public void fill(NonNullList<ItemStack> items) {
        super.fill(items);
        items.sort(ModItemGroups.tabSorterBlocks);
    }
}
