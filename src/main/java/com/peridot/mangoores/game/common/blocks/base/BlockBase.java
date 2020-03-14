package com.peridot.mangoores.game.common.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class BlockBase extends Block {

    public BlockBase(Properties properties) {
        super(properties);
    }

    public BlockBase(Material material, float hardness, float resistance) {
        super(Block.Properties.create(material)
                .hardnessAndResistance(hardness, resistance));
    }

    public BlockBase(Material material, float hardness, float resistance, SoundType soundType) {
        super(Block.Properties.create(material)
                .hardnessAndResistance(hardness, resistance)
                .sound(soundType));
    }

    public BlockBase(Material material, float hardness, float resistance, ToolType toolType, int harvestLevel) {
        super(Block.Properties.create(material)
                .hardnessAndResistance(hardness, resistance)
                .harvestTool(toolType)
                .harvestLevel(harvestLevel));
    }

    public BlockBase(Material material, float hardness, float resistance, ToolType toolType, int harvestLevel, SoundType soundType) {
        super(Block.Properties.create(material)
                .hardnessAndResistance(hardness, resistance)
                .harvestTool(toolType)
                .harvestLevel(harvestLevel)
                .sound(soundType));
    }
}
