package com.peridot.mangoores.game.common.items;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.entities.ModEntities;
import com.peridot.mangoores.game.common.itemgroups.ModItemGroups;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final List<Item> items = new ArrayList<>();
    public static final List<BlockItem> blocks = new ArrayList<>();

    //ITEMS
    public static Item MARKER = register("marker", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    ;

    public static Item IRON_ROD = register("iron_rod", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    ;
    public static Item GOLD_ROD = register("gold_rod", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    ;

    //ITEMS - METALS - INGOTS
    public static Item MANGONIUM_INGOT = register("mangonium_ingot", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static Item URANITE_INGOT = register("uranite_ingot", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static Item VIBRANIUM_INGOT = register("vibranium_ingot", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));

    //ITEMS - METALS - NUGGETS
    public static Item MANGONIUM_NUGGE = register("mangonium_nugget", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static Item URANITE_NUGGET = register("vibranium_nugget", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static Item VIBRANIUM_NUGGET = register("uranite_nugget", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));

    //ITEMS - GEMS
    public static Item AMBER_GEM = register("amber_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static Item AMETHYST_GEM = register("amethyst_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static Item AQUAMARINE_GEM = register("aquamarine_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static Item GALAXITE_GEM = register("galaxite_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static Item KYANITE_GEM = register("kyanite_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static Item PERIDOT_GEM = register("peridot_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static Item RUBY_GEM = register("ruby_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static Item SAPPHIRE_GEM = register("sapphire_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static Item TANZANITE_GEM = register("tanzanite_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static Item TOPAZ_GEM = register("topaz_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static Item VULCANITE_GEM = register("vulcanite_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));

    //ITEMS - ARMORS
    public static Item MANGONIUM_HELMET = register("mangonium_helmet", new ArmorItem(ArmourMaterialList.MANGONIUM, EquipmentSlotType.HEAD, new ArmorItem.Properties().group(ModItemGroups.ARMORS)));
    public static Item MANGONIUM_CHESTPLATE = register("mangonium_chestplate", new ArmorItem(ArmourMaterialList.MANGONIUM, EquipmentSlotType.CHEST, new ArmorItem.Properties().group(ModItemGroups.ARMORS)));
    public static Item MANGONIUM_LEGGINGS = register("mangonium_leggings", new ArmorItem(ArmourMaterialList.MANGONIUM, EquipmentSlotType.LEGS, new ArmorItem.Properties().group(ModItemGroups.ARMORS)));
    public static Item MANGONIUM_BOOTS = register("mangonium_boots", new ArmorItem(ArmourMaterialList.MANGONIUM, EquipmentSlotType.FEET, new ArmorItem.Properties().group(ModItemGroups.ARMORS)));

    //ITEMS - TOOLS
    public static Item MANGO_WRENCH = register("mango_wrench", new Item(new Item.Properties().group(ModItemGroups.TOOLS)));

    //ITEMS - FOOD
    public static Item FRUIT_MANGO = register("fruit_mango", new Item(new Item.Properties().group(ModItemGroups.FOOD).food(new Food.Builder().hunger(3).saturation(3).build())));

    //ITEMS - SPAWN EGGS
    public static Item GOROF_ENTITY_EGG = ModEntities.registerEntitySpawnEgg(ModEntities.gorof_entity, 0xe34444, 0xa52b2b, "gorof_spawn_egg");
    public static Item MINION_ENTITY_EGG = ModEntities.registerEntitySpawnEgg(ModEntities.minion_entity, 0x463aa5, 0x00afaf, "minion_spawn_egg");

    public static void registerItems(RegistryEvent.Register<Item> event) {
        blocks.forEach(block -> event.getRegistry().register(block));
        items.forEach(item -> event.getRegistry().register(item));

        ModItemGroups.tabSorterItems = Ordering.explicit(items).onResultOf(ItemStack::getItem);
        ModItemGroups.tabSorterBlocks = Ordering.explicit(Lists.transform(blocks, BlockItem::getItem)).onResultOf(ItemStack::getItem);

        blocks.clear();
        items.clear();
    }

    private static <T extends Item> T register(String name, T item) {
        ResourceLocation id = MangoOres.getId(name);
        item.setRegistryName(id);
        items.add(item);
        return item;
    }

}
