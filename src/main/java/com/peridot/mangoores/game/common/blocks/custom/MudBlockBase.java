package com.peridot.mangoores.game.common.blocks.custom;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.blocks.base.FallingBlockBase;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class MudBlockBase extends FallingBlockBase {

    public MudBlockBase(Properties properties) {
        super(properties);
    }

    public MudBlockBase(Material material, float hardness, float resistance) {
        super(material, hardness, resistance);
    }

    public MudBlockBase(Material material, float hardness, float resistance, SoundType soundType) {
        super(material, hardness, resistance, soundType);
    }

    public MudBlockBase(Material material, float hardness, float resistance, ToolType toolType, int harvestLevel) {
        super(material, hardness, resistance, toolType, harvestLevel);
    }

    public MudBlockBase(Material material, float hardness, float resistance, ToolType toolType, int harvestLevel, SoundType soundType) {
        super(material, hardness, resistance, toolType, harvestLevel, soundType);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext selection) {
        if(selection.getEntity() != null && selection.getEntity() instanceof FallingBlockEntity) {
            return Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 16D, 16.0D);
        }

        return Block.makeCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 12.5D, 16.0D);
    }

    @Override
    public void onEntityWalk(World world, BlockPos pos, Entity entity) {
        double d0 = Math.abs(entity.getMotion().y);
        if (d0 < 0.1D && !entity.func_226271_bk_()) {
            double d1 = 0.4D + d0 * 0.4D;
            entity.setMotion(entity.getMotion().mul(d1, 1.0D, d1));
        }
    }
}
