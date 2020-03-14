package com.peridot.mangoores.game.common.items.base;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemGroup;

public class ItemArmorBase extends ArmorItem {
    public ItemArmorBase(ItemGroup itemGroup, IArmorMaterial material, EquipmentSlotType slot) {
        super(material, slot, new Properties().group(itemGroup));
    }
}
