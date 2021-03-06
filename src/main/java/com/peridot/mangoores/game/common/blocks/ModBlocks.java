package com.peridot.mangoores.game.common.blocks;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.blocks.custom.MudBlockBase;
import com.peridot.mangoores.game.common.itemgroups.ModItemGroups;
import com.peridot.mangoores.game.common.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.OreBlock;
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

    public static final Block CHUNK_OBSERVER = register("chunk_observer", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(3.5F, 3.5F).sound(SoundType.ANVIL).notSolid()));

    //BLOCKS - BASIC
    public static final Block MUD_BLOCK = register("mud_block", new MudBlockBase(Block.Properties.create(Material.CLAY).speedFactor(0.4F).hardnessAndResistance(0.6F, 0.6F).harvestTool(ToolType.SHOVEL).harvestLevel(0).sound(SoundType.GROUND)));
    public static final Block METEORITE_BLOCK = register("meteorite_block", new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(50F, 1200F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));

    //BLOCKS - METALS - ORES
    public static final Block MANGONIUM_ORE = register("mangonium_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(6F, 9F).harvestTool(ToolType.PICKAXE).harvestLevel(3)));
    public static final Block URANITE_ORE = register("uranite_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(6F, 9F).harvestTool(ToolType.PICKAXE).harvestLevel(4)));
    public static final Block VIBRANIUM_ORE = register("vibranium_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(6F, 9F).harvestTool(ToolType.PICKAXE).harvestLevel(5)));

    //BLOCKS - METALS - BLOCKS
    public static final Block MAGMONITE_BLOCK = register("magmonite_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(50.0F, 1200.0F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));
    public static final Block MANGONIUM_BLOCK = register("mangonium_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.METAL)));
    public static final Block URANITE_BLOCK = register("uranite_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(4).sound(SoundType.METAL)));
    public static final Block VIBRANIUM_BLOCK = register("vibranium_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(50F, 1200F).harvestTool(ToolType.PICKAXE).harvestLevel(5).sound(SoundType.METAL)));

    //BLOCKS - GEMS - ORES
    public static final Block AMBER_ORE = register("amber_ore", new FallingBlock(Block.Properties.create(Material.SAND).hardnessAndResistance(3F, 3F).harvestTool(ToolType.SHOVEL).harvestLevel(2).sound(SoundType.SAND)));
    public static final Block AMETHYST_ORE = register("amethyst_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F, 3F).harvestTool(ToolType.PICKAXE).harvestLevel(3)));
    public static final Block AQUAMARINE_ORE = register("aquamarine_ore", new FallingBlock(Block.Properties.create(Material.SAND).hardnessAndResistance(3F, 3F).harvestTool(ToolType.SHOVEL).harvestLevel(2).sound(SoundType.SAND)));
    public static final Block GALAXITE_ORE = register("galaxite_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F, 3F).harvestTool(ToolType.PICKAXE).harvestLevel(4)));
    public static final Block KYANITE_ORE = register("kyanite_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F, 3F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final Block PERIDOT_ORE = register("peridot_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F, 3F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final Block RUBY_ORE = register("ruby_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F, 3F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final Block SAPPHIRE_ORE = register("sapphire_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F, 3F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final Block TANZANITE_ORE = register("tanzanite_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F, 3F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final Block TOPAZ_ORE = register("topaz_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F, 3F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final Block VULCANITE_ORE = register("vulcanite_ore", new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3F, 3F).harvestTool(ToolType.PICKAXE).harvestLevel(4)));

    //BLOCKS - GEMS - BLOCKS
    public static final Block AMBER_BLOCK = register("amber_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final Block AMETHYST_BLOCK = register("amethyst_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(3)));
    public static final Block AQUAMARINE_BLOCK = register("aquamarine_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final Block GALAXITE_BLOCK = register("galaxite_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(4)));
    public static final Block KYANITE_BLOCK = register("kyanite_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(3)));
    public static final Block PERIDOT_BLOCK = register("peridot_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final Block RUBY_BLOCK = register("ruby_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final Block SAPPHIRE_BLOCK = register("sapphire_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final Block TANZANITE_BLOCK = register("tanzanite_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final Block TOPAZ_BLOCK = register("topaz_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(2)));
    public static final Block VULCANITE_BLOCK = register("vulcanite_block", new Block(Block.Properties.create(Material.IRON).hardnessAndResistance(5F, 6F).harvestTool(ToolType.PICKAXE).harvestLevel(4)));

    //BLOCKS - FOOD
    public static final Block POLISH_CREAM_CAKE_BLOCK = register("polish_cream_cake_block", new Block(Block.Properties.create(Material.CAKE).hardnessAndResistance(0.6F, 0.6F).sound(SoundType.CLOTH)));

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
