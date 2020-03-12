package peridot.mangoores.game.blocks.base;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import peridot.mangoores.MangoOres;
import peridot.mangoores.game.blocks.IHasModel;
import peridot.mangoores.game.blocks.ModBlocks;
import peridot.mangoores.game.init.ModCreativeTabs;
import peridot.mangoores.game.items.ModItems;
import peridot.mangoores.util.Reference;

public class BlockHorizontalBase extends BlockHorizontal implements IHasModel {

    public BlockHorizontalBase(String name, Material material){
        super(material);

        setUnlocalizedName(Reference.MOD_ID+"."+name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTabs.CREATIVE_BLOCKS);

        ModBlocks.blocks.add(this);
        ModItems.items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockHorizontalBase(String name, Material material, float hardness){
        super(material);

        setUnlocalizedName(Reference.MOD_ID+"."+name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTabs.CREATIVE_BLOCKS);
        setHardness(hardness);

        ModBlocks.blocks.add(this);
        ModItems.items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockHorizontalBase(String name, Material material, float hardness, float resistance){
        super(material);

        setUnlocalizedName(Reference.MOD_ID+"."+name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTabs.CREATIVE_BLOCKS);
        setHardness(hardness);
        setResistance(resistance);

        ModBlocks.blocks.add(this);
        ModItems.items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockHorizontalBase(String name, Material material, float hardness, float resistance, String tool, int harvestLevel) {
        super(material);

        setUnlocalizedName(Reference.MOD_ID+"."+name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTabs.CREATIVE_BLOCKS);
        setHardness(hardness);
        setResistance(resistance);
        setHarvestLevel(tool, harvestLevel);

        ModBlocks.blocks.add(this);
        ModItems.items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return super.getStateForPlacement(world, pos, facing, hitX, hitY, hitZ, meta, placer, hand).withProperty(FACING, placer.getHorizontalFacing());
    }

    @Override
    public int getMetaFromState(IBlockState state){
        return state.getValue(FACING).getHorizontalIndex();
    }

    @Override
    public IBlockState getStateFromMeta(int meta){
        return getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
    }

    @Override
    protected BlockStateContainer createBlockState(){
        return new BlockStateContainer(this, FACING);
    }

    @Override
    public void registerModels(){
        MangoOres.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
