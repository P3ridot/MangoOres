package com.peridot.mangoores.game.common.itemgroups;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.items.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItemGroupArmors extends ItemGroup {

    public ItemGroupArmors() {
        super(MangoOres.MOD_ID + ".armors");
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModItems.MANGONIUM_CHESTPLATE);
    }
}
