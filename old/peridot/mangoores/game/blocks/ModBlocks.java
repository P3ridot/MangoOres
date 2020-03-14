package peridot.mangoores.game.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;
import peridot.mangoores.MangoOres;
import peridot.mangoores.game.blocks.base.BlockBase;
import peridot.mangoores.game.init.ModItemGroups;
import peridot.mangoores.game.items.ModItems;

import javax.annotation.Nullable;

public class ModBlocks {
    //BLOCKS - BASIC
    public static Block MUD_BLOCK;
    public static Block METEORITE_BLOCK;

    //BLOCKS - METALS - ORES
    public static Block MANGONIUM_ORE;
    public static Block VIBRANIUM_ORE;
    public static Block URANITE_ORE;

    //BLOCKS - METALS - BLOCKS
    public static Block MANGONIUM_BLOCK;
    public static Block VIBRANIUM_BLOCK;
    public static Block URANITE_BLOCK;

    //BLOCKS - FOOD
    public static Block POLISH_CREAM_CAKE_BLOCK;

    //BLOCKS - FURNITURES
    //public static final Block CHAIR_WITH_BENIS = new ChairWithBenis("chair_with_benis", Material.WOOD);


    public static void registerAll(RegistryEvent.Register<Block> event) {
        MUD_BLOCK = register("mud_block", new BlockBase(Material.CLAY, 0.6F, 0.6F, ToolType.SHOVEL, 0, SoundType.GROUND));
        METEORITE_BLOCK = register("meteorite_block", new BlockBase(Material.ROCK, 50F, 6000F, ToolType.PICKAXE, 3, SoundType.STONE));

        MANGONIUM_ORE = register("mangonium_ore", new BlockBase(Material.ROCK, 4F, 40F, ToolType.PICKAXE, 3, SoundType.STONE));
        VIBRANIUM_ORE = register("vibranium_ore", new BlockBase(Material.ROCK, 45, 600F, ToolType.PICKAXE, 3, SoundType.STONE));
        URANITE_ORE = register("uranite_ore", new BlockBase(Material.ROCK, 5F, 6000F, ToolType.PICKAXE, 3, SoundType.STONE));

        MANGONIUM_BLOCK = register("mangonium_block", new BlockBase(Material.ROCK, 4F, 40F, ToolType.PICKAXE, 3, SoundType.STONE));
        VIBRANIUM_BLOCK = register("vibranium_block", new BlockBase(Material.ROCK, 45, 600F, ToolType.PICKAXE, 3, SoundType.STONE));
        URANITE_BLOCK = register("uranite_block", new BlockBase(Material.ROCK, 5F, 6000F, ToolType.PICKAXE, 3, SoundType.STONE));

        POLISH_CREAM_CAKE_BLOCK = register("polish_cream_cake_block", new BlockBase(Material.CAKE, 0.5F, 0.5F, SoundType.CLOTH));
    }

    private static <T extends Block> T register(String name, T block) {
        BlockItem item = new BlockItem(block, new Item.Properties().group(ModItemGroups.ITEM_GROUP_BLOCKS));
        return register(name, block, item);
    }

    private static <T extends Block> T register(String name, T block, @Nullable BlockItem item) {
        ResourceLocation id = MangoOres.getId(name);
        block.setRegistryName(id);
        ForgeRegistries.BLOCKS.register(block);
        if (item != null) {
            ModItems.BLOCKS_TO_REGISTER.put(name, item);
        }
        return block;
    }
}
