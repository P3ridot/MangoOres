package peridot.mangoores.game.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import peridot.mangoores.game.blocks.base.BlockBase;
import peridot.mangoores.game.blocks.custom.MudBlock;
import peridot.mangoores.game.blocks.custom.PolishCreamCakeBlock;
import peridot.mangoores.game.blocks.furnitures.ChairWithBenis;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> blocks = new ArrayList<>();

    //BLOCKS - BASIC
    public static final Block MUD_BLOCK = new MudBlock("mud_block", Material.CLAY);
    public static final Block METEORITE_BLOCK = new BlockBase("meteorite_block", Material.ROCK, 50F, 6000F, "pickaxe", 3);

    //BLOCKS - METALS - ORES
    public static final Block MANGONIUM_ORE = new BlockBase("mangonium_ore", Material.ROCK, 4F, 40F, "pickaxe", 3);
    public static final Block VIBRANIUM_ORE = new BlockBase("vibranium_ore", Material.ROCK, 5F, 6000F, "pickaxe", 3);
    public static final Block URANITE_ORE = new BlockBase("uranite_ore", Material.ROCK, 5F, 6000F, "pickaxe", 3);

    //BLOCKS - METALS - BLOCKS
    public static final Block MANGONIUM_BLOCK = new BlockBase("mangonium_block", Material.ROCK, 4F, 40F, "pickaxe", 4);
    public static final Block VIBRANIUM_BLOCK = new BlockBase("vibranium_block", Material.ROCK, 5F, 6000F, "pickaxe", 4);
    public static final Block URANITE_BLOCK = new BlockBase("uranite_block", Material.ROCK, 5F, 6000F, "pickaxe", 4);

    //BLOCKS - FOOD
    public static final Block POLISH_CREAM_CAKE_BLOCK = new PolishCreamCakeBlock("polish_cream_cake_block");

    //BLOCKS - FURNITURES
    public static final Block CHAIR_WITH_BENIS = new ChairWithBenis("chair_with_benis", Material.WOOD);

}
