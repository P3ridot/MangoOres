package com.peridot.mangoores.game.common.blocks.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FallingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class MudBlockBase extends FallingBlock {

    public MudBlockBase(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext selection) {
        if (selection.getEntity() != null && selection.getEntity() instanceof FallingBlockEntity) {
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
