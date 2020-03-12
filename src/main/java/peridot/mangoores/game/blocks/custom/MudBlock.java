package peridot.mangoores.game.blocks.custom;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import peridot.mangoores.MangoOres;
import peridot.mangoores.game.blocks.IHasModel;
import peridot.mangoores.game.blocks.base.BlockBase;

import javax.annotation.Nullable;

public class MudBlock extends BlockBase implements IHasModel {

    public MudBlock(String name, Material material) {
        super(name, material, 0.6F, 3, "shovel", 0);
        setSoundType(SoundType.GROUND);
    }

    @Nullable
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState state, IBlockAccess access, BlockPos pos) {
        return new AxisAlignedBB(0, 0, 0, 1, 0.0625*12.5, 1);
    }

    @Override
    public void onEntityCollidedWithBlock(World world, BlockPos pos, IBlockState state, Entity entity) {
        entity.motionX *= 0.6D;
        entity.motionZ *= 0.6D;
    }

    @Override
    public void registerModels(){
        MangoOres.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
