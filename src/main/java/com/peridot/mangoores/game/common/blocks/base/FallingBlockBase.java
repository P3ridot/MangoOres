package com.peridot.mangoores.game.common.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class FallingBlockBase extends FallingBlock {

    public FallingBlockBase(Block.Properties properties) {
        super(properties);
    }

    public FallingBlockBase(Material material, float hardness, float resistance) {
        super(Block.Properties.create(material)
                .hardnessAndResistance(hardness, resistance));
    }

    public FallingBlockBase(Material material, float hardness, float resistance, SoundType soundType) {
        super(Block.Properties.create(material)
                .hardnessAndResistance(hardness, resistance)
                .sound(soundType));
    }

    public FallingBlockBase(Material material, float hardness, float resistance, ToolType toolType, int harvestLevel) {
        super(Block.Properties.create(material)
                .hardnessAndResistance(hardness, resistance)
                .harvestTool(toolType)
                .harvestLevel(harvestLevel));
    }

    public FallingBlockBase(Material material, float hardness, float resistance, ToolType toolType, int harvestLevel, SoundType soundType) {
        super(Block.Properties.create(material)
                .hardnessAndResistance(hardness, resistance)
                .harvestTool(toolType)
                .harvestLevel(harvestLevel)
                .sound(soundType));
    }

}
