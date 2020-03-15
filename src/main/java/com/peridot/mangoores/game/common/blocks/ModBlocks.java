package com.peridot.mangoores.game.common.blocks;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.blocks.custom.MudBlockBase;
import com.peridot.mangoores.game.common.itemgroups.ModItemGroups;
import com.peridot.mangoores.game.common.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class ModBlocks {

    //BLOCKS - BASIC
    public static Block MUD_BLOCK;
    public static Block METEORITE_BLOCK;

    //BLOCKS - METALS - ORES
    public static Block MANGONIUM_ORE;
    public static Block URANITE_ORE;
    public static Block VIBRANIUM_ORE;

    //BLOCKS - METALS - BLOCKS
    public static Block MANGONIUM_BLOCK;
    public static Block URANITE_BLOCK;
    public static Block VIBRANIUM_BLOCK;

    //BLOCKS - FOOD
    public static Block POLISH_CREAM_CAKE_BLOCK;

    public static void registerAll(RegistryEvent.Register<Block> event) {
        MUD_BLOCK = register("mud_block", new MudBlockBase(Material.CLAY, 0.6F, 0.6F, ToolType.SHOVEL, 0, SoundType.GROUND));
        METEORITE_BLOCK = register("meteorite_block", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(50F, 1200F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));

        MANGONIUM_ORE = register("mangonium_ore", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6F, 9F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));
        URANITE_ORE = register("uranite_ore", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6F, 9F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));
        VIBRANIUM_ORE = register("vibranium_ore", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6F, 9F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));

        MANGONIUM_BLOCK = register("mangonium_block", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));
        URANITE_BLOCK = register("uranite_block", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));
        VIBRANIUM_BLOCK = register("vibranium_block", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(50F, 1200F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));

        POLISH_CREAM_CAKE_BLOCK = register("polish_cream_cake_block", new Block(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.6F, 0.6F).sound(SoundType.CLOTH)));
    }

    private static <T extends Block> T register(String name, T block) {
        BlockItem item = new BlockItem(block, new Item.Properties().group(ModItemGroups.BLOCKS));
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
