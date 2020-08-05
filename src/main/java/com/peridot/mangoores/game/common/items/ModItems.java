package com.peridot.mangoores.game.common.items;

import com.google.common.collect.Ordering;
import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.entities.ModEntities;
import com.peridot.mangoores.game.common.itemgroups.ModItemGroups;
import com.peridot.mangoores.game.common.items.custom.tools.InactiveLightningSwordItem;
import com.peridot.mangoores.game.common.items.custom.tools.LightningSwordItem;
import com.peridot.mangoores.game.common.items.custom.tools.MultitoolItem;
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
    public static final Item IRON_ROD = register("iron_rod", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item GOLD_ROD = register("gold_rod", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item RAINBOW_ELEMENT = register("rainbow_element", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));

    //ITEMS - METALS - INGOTS
    public static final Item MAGMONITE_INGOT = register("magmonite_ingot", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item MANGONIUM_INGOT = register("mangonium_ingot", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item URANITE_INGOT = register("uranite_ingot", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item VIBRANIUM_INGOT = register("vibranium_ingot", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));

    //ITEMS - METALS - NUGGETS
    public static final Item MAGMONITE_NUGGET = register("magmonite_nugget", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item MANGONIUM_NUGGET = register("mangonium_nugget", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item URANITE_NUGGET = register("uranite_nugget", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item VIBRANIUM_NUGGET = register("vibranium_nugget", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));

    //ITEMS - GEMS
    public static final Item AMBER_GEM = register("amber_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item AMETHYST_GEM = register("amethyst_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item AQUAMARINE_GEM = register("aquamarine_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item GALAXITE_GEM = register("galaxite_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item KYANITE_GEM = register("kyanite_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item PERIDOT_GEM = register("peridot_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item RUBY_GEM = register("ruby_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item SAPPHIRE_GEM = register("sapphire_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item TANZANITE_GEM = register("tanzanite_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item TOPAZ_GEM = register("topaz_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));
    public static final Item VULCANITE_GEM = register("vulcanite_gem", new Item(new Item.Properties().group(ModItemGroups.ITEMS)));

    //ITEMS - ARMORS
    public static final Item MANGONIUM_HELMET = register("mangonium_helmet", new ArmorItem(ArmourMaterialList.MANGONIUM, EquipmentSlotType.HEAD, new ArmorItem.Properties().group(ModItemGroups.ARMORS)));
    public static final Item MANGONIUM_CHESTPLATE = register("mangonium_chestplate", new ArmorItem(ArmourMaterialList.MANGONIUM, EquipmentSlotType.CHEST, new ArmorItem.Properties().group(ModItemGroups.ARMORS)));
    public static final Item MANGONIUM_LEGGINGS = register("mangonium_leggings", new ArmorItem(ArmourMaterialList.MANGONIUM, EquipmentSlotType.LEGS, new ArmorItem.Properties().group(ModItemGroups.ARMORS)));
    public static final Item MANGONIUM_BOOTS = register("mangonium_boots", new ArmorItem(ArmourMaterialList.MANGONIUM, EquipmentSlotType.FEET, new ArmorItem.Properties().group(ModItemGroups.ARMORS)));

    //ITEMS - TOOLS
    public static final Item MANGO_WRENCH = register("mango_wrench", new Item(new Item.Properties().group(ModItemGroups.TOOLS)));
    public static final Item MANGONIUM_SWORD = register("mangonium_sword", new SwordItem(ToolMaterialList.MANGONIUM, 4, -2.4F, new Item.Properties().group(ModItemGroups.TOOLS)));
    public static final Item MANGONIUM_SHOVEL = register("mangonium_shovel", new ShovelItem(ToolMaterialList.MANGONIUM, 1.5F, -3.0F, new Item.Properties().group(ModItemGroups.TOOLS)));
    public static final Item MANGONIUM_PICKAXE = register("mangonium_pickaxe", new PickaxeItem(ToolMaterialList.MANGONIUM, 2, -2.8F, new Item.Properties().group(ModItemGroups.TOOLS)));
    public static final Item MANGONIUM_AXE = register("mangonium_axe", new AxeItem(ToolMaterialList.MANGONIUM, 5.5F, -3.0F, new Item.Properties().group(ModItemGroups.TOOLS)));
    public static final Item MANGONIUM_HOE = register("mangonium_hoe", new HoeItem(ToolMaterialList.MANGONIUM, 2, 0.0F, new Item.Properties().group(ModItemGroups.TOOLS)));
    public static final Item ULTIMATE_MULTITOOL = register("ultimate_multitool", new MultitoolItem(ToolMaterialList.ULTIMATE_MULTITOOL, 2, -2.8F, new Item.Properties().group(ModItemGroups.TOOLS)));

    public static final Item INACTIVE_LIGHTING_SWORD = register("inactive_lightning_sword", new InactiveLightningSwordItem(ToolMaterialList.INACTIVE_LIGHTING_SWORD, 3, -2.4F, new Item.Properties().group(ModItemGroups.TOOLS)));
    public static final Item LIGHTING_SWORD = register("lightning_sword", new LightningSwordItem(ToolMaterialList.LIGHTING_SWORD, 4, -2.4F, new Item.Properties().group(ModItemGroups.TOOLS)));

    //ITEMS - FOOD
    public static final Item FRUIT_MANGO = register("fruit_mango", new Item(new Item.Properties().group(ModItemGroups.FOOD).food(new Food.Builder().hunger(3).saturation(3).build())));

    //ITEMS - SPAWN EGGS
    public static final Item GOROF_ENTITY_EGG = ModEntities.registerEntitySpawnEgg(ModEntities.GOROF_ENTITY, 0xe34444, 0xa52b2b, "gorof_spawn_egg");
    public static final Item MINION_ENTITY_EGG = ModEntities.registerEntitySpawnEgg(ModEntities.MINION_ENTITY, 0x463aa5, 0x00afaf, "minion_spawn_egg");
    public static final Item SCORPION_ENTITY_EGG = ModEntities.registerEntitySpawnEgg(ModEntities.SCORPION_ENTITY, 0x000000, 0xc800fa, "scorpion_spawn_egg");

    public static void registerItems(RegistryEvent.Register<Item> event) {
        blocks.forEach(block -> event.getRegistry().register(block));
        items.forEach(item -> event.getRegistry().register(item));

        items.addAll(blocks);
        ModItemGroups.tabSorter = Ordering.explicit(items).onResultOf(ItemStack::getItem);

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
