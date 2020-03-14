package com.peridot.mangoores.game.common.items;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.entities.ModEntities;
import com.peridot.mangoores.game.common.itemgroups.ModItemGroups;
import com.peridot.mangoores.game.common.items.base.ItemArmorBase;
import com.peridot.mangoores.game.common.items.base.ItemBase;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {

    //
    public static Item GOROF_ENTITY_EGG;

    //ITEMS
    public static Item MARKER = new ItemBase(ModItemGroups.ITEMS);

    public static Item IRON_ROD = new ItemBase(ModItemGroups.ITEMS);
    public static Item GOLD_ROD = new ItemBase(ModItemGroups.ITEMS);

    //ITEMS - METALS - INGOTS
    public static Item MANGONIUM_INGOT = new ItemBase(ModItemGroups.ITEMS);
    public static Item VIBRANIUM_INGOT = new ItemBase(ModItemGroups.ITEMS);
    public static Item URANITE_INGOT = new ItemBase(ModItemGroups.ITEMS);

    //ITEMS - METALS - NUGGETS
    public static Item MANGONIUM_NUGGET = new ItemBase(ModItemGroups.ITEMS);
    public static Item VIBRANIUM_NUGGET = new ItemBase(ModItemGroups.ITEMS);
    public static Item URANITE_NUGGET = new ItemBase(ModItemGroups.ITEMS);

    //ITEMS - GEMS
    public static Item AMBER_GEM = new ItemBase(ModItemGroups.ITEMS);
    public static Item AMETHYST_GEM = new ItemBase(ModItemGroups.ITEMS);
    public static Item AQUAMARINE_GEM = new ItemBase(ModItemGroups.ITEMS);
    public static Item GALAXITE_GEM = new ItemBase(ModItemGroups.ITEMS);
    public static Item KYANITE_GEM = new ItemBase(ModItemGroups.ITEMS);
    public static Item PERIDOT_GEM =new ItemBase(ModItemGroups.ITEMS);
    public static Item RUBY_GEM = new ItemBase(ModItemGroups.ITEMS);
    public static Item SAPPHIRE_GEM = new ItemBase(ModItemGroups.ITEMS);
    public static Item TANZANITE_GEM = new ItemBase(ModItemGroups.ITEMS);
    public static Item TOPAZ_GEM = new ItemBase(ModItemGroups.ITEMS);
    public static Item VULCANITE_GEM = new ItemBase(ModItemGroups.ITEMS);

    //ITEMS - ARMORS
    public static Item MANGONIUM_HELMET = new ItemArmorBase(ModItemGroups.ARMORS, ArmourMaterialList.MANGONIUM, EquipmentSlotType.HEAD);
    public static Item MANGONIUM_CHESTPLATE = new ItemArmorBase(ModItemGroups.ARMORS, ArmourMaterialList.MANGONIUM, EquipmentSlotType.CHEST);
    public static Item MANGONIUM_LEGGINGS = new ItemArmorBase(ModItemGroups.ARMORS, ArmourMaterialList.MANGONIUM, EquipmentSlotType.LEGS);
    public static Item MANGONIUM_BOOTS = new ItemArmorBase(ModItemGroups.ARMORS, ArmourMaterialList.MANGONIUM, EquipmentSlotType.FEET);

    //ITEMS - TOOLS
    public static final Item MANGO_WRENCH = new ItemBase(ModItemGroups.TOOLS);

    //ITEMS - FOOD
    public static final Item FRUIT_MANGO = new ItemBase(ModItemGroups.FOOD, new Food.Builder().hunger(3).saturation(3).build());

    public static final Map<String, BlockItem> BLOCKS_TO_REGISTER = new LinkedHashMap<>();

    public static void registerAll(RegistryEvent.Register<Item> event) {
        BLOCKS_TO_REGISTER.forEach(ModItems::register);

        register("marker", MARKER);

        register("iron_rod", GOLD_ROD);
        register("gold_rod", IRON_ROD);

        register("mangonium_ingot", MANGONIUM_INGOT);
        register("vibranium_ingot", VIBRANIUM_INGOT);
        register("uranite_ingot", URANITE_INGOT);

        register("mangonium_nugget", MANGONIUM_NUGGET);
        register("vibranium_nugget", VIBRANIUM_NUGGET);
        register("uranite_nugget", URANITE_NUGGET);

        register("amber_gem", AMBER_GEM);
        register("amethyst_gem", AMETHYST_GEM);
        register("aquamarine_gem", AQUAMARINE_GEM);
        register("galaxite_gem", GALAXITE_GEM);
        register("kyanite_gem", KYANITE_GEM);
        register("peridot_gem", PERIDOT_GEM);
        register("ruby_gem", RUBY_GEM);
        register("sapphire_gem", SAPPHIRE_GEM);
        register("tanzanite_gem", TANZANITE_GEM);
        register("topaz_gem", TOPAZ_GEM);
        register("vulcanite_gem", VULCANITE_GEM);

        register("mangonium_helmet", MANGONIUM_HELMET);
        register("mangonium_chestplate", MANGONIUM_CHESTPLATE);
        register("mangonium_leggings", MANGONIUM_LEGGINGS);
        register("mangonium_boots", MANGONIUM_BOOTS);

        register("mango_wrench", MANGO_WRENCH);

        register("fruit_mango", FRUIT_MANGO);
    }

    private static <T extends Item> T register(String name, T item) {
        ResourceLocation id = MangoOres.getId(name);
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }
}
