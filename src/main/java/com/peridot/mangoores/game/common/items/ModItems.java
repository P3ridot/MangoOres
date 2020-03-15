package com.peridot.mangoores.game.common.items;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.itemgroups.ModItemGroups;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
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
    public static Item MARKER;

    public static Item IRON_ROD;
    public static Item GOLD_ROD;

    //ITEMS - METALS - INGOTS
    public static Item MANGONIUM_INGOT;
    public static Item VIBRANIUM_INGOT;
    public static Item URANITE_INGOT;

    //ITEMS - METALS - NUGGETS
    public static Item MANGONIUM_NUGGE;
    public static Item VIBRANIUM_NUGGET;
    public static Item URANITE_NUGGET;

    //ITEMS - GEMS
    public static Item AMBER_GEM;
    public static Item AMETHYST_GEM;
    public static Item AQUAMARINE_GEM;
    public static Item GALAXITE_GEM;
    public static Item KYANITE_GEM;
    public static Item PERIDOT_GEM;
    public static Item RUBY_GEM;
    public static Item SAPPHIRE_GEM;
    public static Item TANZANITE_GEM;
    public static Item TOPAZ_GEM;
    public static Item VULCANITE_GEM;

    //ITEMS - ARMORS
    public static Item MANGONIUM_HELMET;
    public static Item MANGONIUM_CHESTPLATE;
    public static Item MANGONIUM_LEGGINGS;
    public static Item MANGONIUM_BOOTS;

    //ITEMS - TOOLS
    public static Item MANGO_WRENCH;

    //ITEMS - FOOD
    public static Item FRUIT_MANGO;

    public static final Map<String, BlockItem> BLOCKS_TO_REGISTER = new LinkedHashMap<>();

    public static void registerAll(RegistryEvent.Register<Item> event) {
        BLOCKS_TO_REGISTER.forEach(ModItems::register);

        register("marker", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));

        register("iron_rod", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("gold_rod", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));

        register("mangonium_ingot", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("uranite_ingot", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("vibranium_ingot", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));

        register("mangonium_nugget", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("uranite_nugget", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("vibranium_nugget", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));

        register("amber_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("amethyst_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("aquamarine_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("galaxite_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("kyanite_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("peridot_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("ruby_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("sapphire_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("tanzanite_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("topaz_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
        register("vulcanite_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));

        register("mangonium_helmet", new ArmorItem(ArmourMaterialList.MANGONIUM, EquipmentSlotType.HEAD, new ArmorItem.Properties().group(ModItemGroups.ARMORS)));
        register("mangonium_chestplate", new ArmorItem(ArmourMaterialList.MANGONIUM, EquipmentSlotType.CHEST, new ArmorItem.Properties().group(ModItemGroups.ARMORS)));
        register("mangonium_leggings", new ArmorItem(ArmourMaterialList.MANGONIUM, EquipmentSlotType.LEGS, new ArmorItem.Properties().group(ModItemGroups.ARMORS)));
        register("mangonium_boots", new ArmorItem(ArmourMaterialList.MANGONIUM, EquipmentSlotType.FEET, new ArmorItem.Properties().group(ModItemGroups.ARMORS)));

        register("mango_wrench", new Item(new Item.Properties().group(ModItemGroups.TOOLS)));

        register("fruit_mango", new Item(new Item.Properties().group(ModItemGroups.FOOD).food(new Food.Builder().hunger(3).saturation(3).build())));
    }

    private static <T extends Item> T register(String name, T item) {
        ResourceLocation id = MangoOres.getId(name);
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }
}
