package peridot.mangoores.game.items;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;
import peridot.mangoores.MangoOres;
import peridot.mangoores.game.init.ModItemGroups;
import peridot.mangoores.game.items.base.ItemBase;

import java.util.LinkedHashMap;
import java.util.Map;

public class ModItems {

    //
    public static Item GOROF_ENTITY_EGG;

    //ITEMS
    public static Item MARKER = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);

    public static Item IRON_ROD = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item GOLD_ROD = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);

    //ITEMS - METALS - INGOTS
    public static Item MANGONIUM_INGOT = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item VIBRANIUM_INGOT = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item URANITE_INGOT = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);

    //ITEMS - METALS - NUGGETS
    public static Item MANGONIUM_NUGGET = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item VIBRANIUM_NUGGET = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item URANITE_NUGGET = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);

    //ITEMS - GEMS
    public static Item AMBER_GEM = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item AMETHYST_GEM = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item AQUAMARINE_GEM = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item GALAXITE_GEM = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item KYANITE_GEM = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item PERIDOT_GEM = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item RUBY_GEM = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item SAPPHIRE_GEM = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item TANZANITE_GEM = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item TOPAZ_GEM = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);
    public static Item VULCANITE_GEM = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);

    //ITEMS - TOOLS
    public static final Item MANGO_WRENCH = new ItemBase(ModItemGroups.ITEM_GROUP_ITEMS);


    public static final Map<String, BlockItem> BLOCKS_TO_REGISTER = new LinkedHashMap<>();

    public static void registerAll(RegistryEvent.Register<Item> event) {
        BLOCKS_TO_REGISTER.forEach(ModItems::register);

        register("marker", MARKER);

        register("iron_rod", GOLD_ROD);
        register("gold_rod", IRON_ROD);

        register("magnonium_ingot", MANGONIUM_INGOT);
        register("vibranium_ingot", VIBRANIUM_INGOT);
        register("uranite_ingot", URANITE_INGOT);

        register("magnonium_nugget", URANITE_NUGGET);
        register("vibranium_nugget", URANITE_NUGGET);
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

        register("mango_wrench", MANGO_WRENCH);
    }

    private static <T extends Item> T register(String name, T item) {
        ResourceLocation id = MangoOres.getId(name);
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);

        return item;
    }
}
