package com.peridot.mangoores.game.common.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier {

    MANGONIUM(5F, 12F, 3000, 4, 15, ModItems.MANGONIUM_INGOT),

    ULTIMATE_MULTITOOL(10F, 12F, 3000, 4, 10, Items.DIAMOND),
    INACTIVE_LIGHTING_SWORD(2F, 1F, 100, 0, 0, null),
    LIGHTING_SWORD(7F, 1F, 2500, 0, 7, ModItems.KYANITE_GEM);

    private final float attackDamage;
    private final float efficiency;
    private final int durability;
    private final int harvestLevel;
    private final int enchantability;
    private final Item repairMaterial;

    ToolMaterialList(float attackDamage, float efficiency, int durability, int harvestLevel, int enchantability, Item repairMaterial) {
        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.durability = durability;
        this.harvestLevel = harvestLevel;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public int getMaxUses() {
        return this.durability;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairMaterial);
    }
}
