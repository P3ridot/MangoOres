package peridot.mangoores.game.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import peridot.mangoores.MangoOres;
import peridot.mangoores.game.blocks.ModBlocks;
import peridot.mangoores.game.items.ModItems;

public class ModItemGroups {

    public static final ItemGroup ITEM_GROUP_BLOCKS = new ItemGroup(MangoOres.MOD_ID + ".blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModBlocks.MANGONIUM_BLOCK);
        }
    };

    public static final ItemGroup ITEM_GROUP_ITEMS = new ItemGroup(MangoOres.MOD_ID + ".items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.MANGONIUM_INGOT);
        }
    };

}
