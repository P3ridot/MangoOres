package peridot.mangoores.game.items;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import peridot.mangoores.game.items.armor.ArmorBase;
import peridot.mangoores.game.items.base.FoodBase;
import peridot.mangoores.game.items.base.ItemBase;
import peridot.mangoores.game.items.custom.ItemMangoWrench;
import peridot.mangoores.util.Reference;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final List<Item> items = new ArrayList<>();

    //MATERIALS - ARMORS
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_MANGONIUM = EnumHelper.addArmorMaterial("mangonium", Reference.MOD_ID + ":mangonium", 50, new int[]{4,7, 9, 4}, 11, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3.0F);

    //ITEMS
    public static final Item MARKER = new ItemBase("marker");

    public static final Item IRON_ROD = new ItemBase("iron_rod");
    public static final Item GOLD_ROD = new ItemBase("gold_rod");

    //ITEMS - METALS - INGOTS
    public static final Item MANGONIUM_INGOT = new ItemBase("mangonium_ingot");
    public static final Item VIBRANIUM_INGOT = new ItemBase("vibranium_ingot");
    public static final Item URANITE_INGOT = new ItemBase("uranite_ingot");

    //ITEMS - METALS - NUGGETS
    public static final Item MANGONIUM_NUGGET = new ItemBase("mangonium_nugget");
    public static final Item VIBRANIUM_NUGGET = new ItemBase("vibranium_nugget");
    public static final Item URANITE_NUGGET = new ItemBase("uranite_nugget");

    //ITEMS - GEMS
    public static final Item AMBER_GEM = new ItemBase("amber_gem");
    public static final Item AMETHYST_GEM = new ItemBase("amethyst_gem");
    public static final Item AQUAMARINE_GEM = new ItemBase("aquamarine_gem");
    public static final Item GALAXITE_GEM = new ItemBase("galaxite_gem");
    public static final Item KYANITE_GEM = new ItemBase("kyanite_gem");
    public static final Item PERIDOT_GEM = new ItemBase("peridot_gem");
    public static final Item RUBY_GEM = new ItemBase("ruby_gem");
    public static final Item SAPPHIRE_GEM = new ItemBase("sapphire_gem");
    public static final Item TANZANITE_GEM = new ItemBase("tanzanite_gem");
    public static final Item TOPAZ_GEM = new ItemBase("topaz_gem");
    public static final Item VULCANITE_GEM = new ItemBase("vulcanite_gem");

    //ITEMS - ARMORS
    public static final Item MANGONIUM_HELMET = new ArmorBase("mangonium_helmet", ARMOR_MATERIAL_MANGONIUM, 0, EntityEquipmentSlot.HEAD);
    public static final Item MANGONIUM_CHESTPLATE = new ArmorBase("mangonium_chestplate", ARMOR_MATERIAL_MANGONIUM, 1, EntityEquipmentSlot.CHEST);
    public static final Item MANGONIUM_LEGGINGS = new ArmorBase("mangonium_leggings", ARMOR_MATERIAL_MANGONIUM, 2, EntityEquipmentSlot.LEGS);
    public static final Item MANGONIUM_BOOTS = new ArmorBase("mangonium_boots", ARMOR_MATERIAL_MANGONIUM, 3, EntityEquipmentSlot.FEET);

    //ITEMS - TOOLS
    public static final Item MANGO_WRENCH = new ItemMangoWrench("mangowrench");

    //ITEMS - FOODS
    public static final Item FRUIT_MANGO = new FoodBase("fruit_mango", 3, 3, false);
    public static final Item VEGETABLE_CUCURBIT = new FoodBase("vegetable_cucurbit", 4, 4, false);

}
