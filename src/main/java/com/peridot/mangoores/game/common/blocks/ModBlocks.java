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
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> blocks = new ArrayList<>();

    public static Block CHUNK_OBSERVER = register("chunk_observer", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.5F, 3.5F).sound(SoundType.ANVIL).lightValue(8).func_226896_b_()));

    //BLOCKS - BASIC
    public static Block MUD_BLOCK = register("mud_block", new MudBlockBase(Block.Properties.create(Material.CLAY).hardnessAndResistance(0.6F, 0.6F).harvestTool(ToolType.SHOVEL).harvestLevel(0).sound(SoundType.GROUND)));
    public static Block METEORITE_BLOCK = register("meteorite_block", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(50F, 1200F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));

    //BLOCKS - METALS - ORES
    public static Block MANGONIUM_ORE = register("mangonium_ore", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6F, 9F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));
    public static Block URANITE_ORE = register("uranite_ore", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6F, 9F).harvestTool(ToolType.PICKAXE).harvestLevel(4).sound(SoundType.METAL)));
    public static Block VIBRANIUM_ORE = register("vibranium_ore", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(6F, 9F).harvestTool(ToolType.PICKAXE).harvestLevel(5).sound(SoundType.METAL)));

    //BLOCKS - METALS - BLOCKS
    public static Block MANGONIUM_BLOCK = register("mangonium_block", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));
    public static Block URANITE_BLOCK = register("uranite_block", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));
    public static Block VIBRANIUM_BLOCK = register("vibranium_block", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(50F, 1200F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));

    //BLOCKS - FOOD
    public static Block POLISH_CREAM_CAKE_BLOCK = register("polish_cream_cake_block", new Block(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.6F, 0.6F).sound(SoundType.CLOTH)));

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        blocks.forEach(block -> event.getRegistry().register(block));
        blocks.clear();
    }

    private static <T extends Block> T register(String name, T block) {
        ResourceLocation id = MangoOres.getId(name);
        BlockItem item = new BlockItem(block, new Item.Properties().group(ModItemGroups.BLOCKS));
        item.setRegistryName(id);
        return register(name, block, item);
    }

    private static <T extends Block> T register(String name, T block, @Nullable BlockItem item) {
        ResourceLocation id = MangoOres.getId(name);
        block.setRegistryName(id);
        blocks.add(block);
        ModItems.blocks.add(item);
        return block;
    }

    private static <T extends Block> T registerWithoutItem(String name, T block) {
        ResourceLocation id = MangoOres.getId(name);
        block.setRegistryName(id);
        ForgeRegistries.BLOCKS.register(block);
        return block;
    }

}
