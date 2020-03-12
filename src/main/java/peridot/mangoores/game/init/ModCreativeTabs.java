package peridot.mangoores.game.init;


import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import peridot.mangoores.game.blocks.ModBlocks;
import peridot.mangoores.game.items.ModItems;

import java.util.Comparator;

public class ModCreativeTabs {

    public static Comparator<ItemStack> tabSorter;

    public static final CreativeTabs CREATIVE_BLOCKS = new CreativeTabs("mangoores.creative_blocks") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Item.getItemFromBlock(ModBlocks.MANGONIUM_BLOCK));
        }

        @Override
        public void displayAllRelevantItems(NonNullList<ItemStack> items) {
            super.displayAllRelevantItems(items);
            items.sort(tabSorter);
        }
    };

    public static final CreativeTabs CREATIVE_ITEMS = new CreativeTabs("mangoores.creative_items") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.MANGONIUM_INGOT);
        }

        @Override
        public void displayAllRelevantItems(NonNullList<ItemStack> items) {
            super.displayAllRelevantItems(items);
            items.sort(tabSorter);
        }
    };

    public static final CreativeTabs CREATIVE_FOOD = new CreativeTabs("mangoores.creative_food") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.FRUIT_MANGO);
        }

        @Override
        public void displayAllRelevantItems(NonNullList<ItemStack> items) {
            super.displayAllRelevantItems(items);
            items.sort(tabSorter);
        }
    };

    public static final CreativeTabs CREATIVE_TOOLS = new CreativeTabs("mangoores.creative_tools") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.MANGO_WRENCH);
        }

        @Override
        public void displayAllRelevantItems(NonNullList<ItemStack> items) {
            super.displayAllRelevantItems(items);
            items.sort(tabSorter);
        }
    };

    public static final CreativeTabs CREATIVE_ARMORS = new CreativeTabs("mangoores.creative_armors") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(ModItems.MANGONIUM_CHESTPLATE);
        }

        @Override
        public void displayAllRelevantItems(NonNullList<ItemStack> items) {
            super.displayAllRelevantItems(items);
            items.sort(tabSorter);
        }
    };

}
