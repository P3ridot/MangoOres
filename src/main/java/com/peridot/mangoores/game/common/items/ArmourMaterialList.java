package com.peridot.mangoores.game.common.items;

import com.peridot.mangoores.MangoOres;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public enum ArmourMaterialList implements IArmorMaterial {

    MANGONIUM("mangonium", 50, new int[]{4, 7, 9, 4}, 15, ModItems.MANGONIUM_INGOT, "item.armor.equip_iron", 3.0F);

    private static final int[] max_damage_array = new int[]{13, 15, 16, 11};
    private final String name;
    private final String equipSound;
    private final int durability;
    private final int enchantability;
    private final Item repairMaterial;
    private final int[] damageReductionAmounts;
    private final float toughness;

    ArmourMaterialList(String name, int durability, int[] damageReductionAmounts, int enchantability, Item repairMaterial, String equipSound, float toughness) {
        this.name = name;
        this.durability = durability;
        this.damageReductionAmounts = damageReductionAmounts;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
        this.equipSound = equipSound;
        this.toughness = toughness;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slot) {
        return this.damageReductionAmounts[slot.getIndex()];
    }

    public int getDurability(EquipmentSlotType slot) {
        return max_damage_array[slot.getIndex()] * this.durability;
    }

    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public String getName() {
        return MangoOres.MOD_ID + ":" + name;
    }

    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairMaterial);
    }

    @Override
    public SoundEvent getSoundEvent() {
        return new SoundEvent(new ResourceLocation(equipSound));
    }

    @Override
    public float getToughness() {
        return toughness;
    }

    @Override
    public float func_230304_f_() {
        return 0;
    }
}
