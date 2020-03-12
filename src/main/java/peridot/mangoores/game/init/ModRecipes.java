package peridot.mangoores.game.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import peridot.mangoores.game.blocks.ModBlocks;
import peridot.mangoores.game.items.ModItems;

public class ModRecipes {

    public static void init() {
        GameRegistry.addSmelting(ModBlocks.MANGONIUM_ORE, new ItemStack(ModItems.MANGONIUM_INGOT), 1.0F);
        GameRegistry.addSmelting(ModBlocks.VIBRANIUM_ORE, new ItemStack(ModItems.VIBRANIUM_INGOT), 1.0F);
        GameRegistry.addSmelting(ModBlocks.VIBRANIUM_ORE, new ItemStack(ModItems.URANITE_INGOT), 1.0F);
    }

}
