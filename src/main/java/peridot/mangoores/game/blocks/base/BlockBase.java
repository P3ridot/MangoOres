package peridot.mangoores.game.blocks.base;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import peridot.mangoores.MangoOres;
import peridot.mangoores.game.blocks.IHasModel;
import peridot.mangoores.game.blocks.ModBlocks;
import peridot.mangoores.game.init.ModCreativeTabs;
import peridot.mangoores.game.items.ModItems;
import peridot.mangoores.util.Reference;

public class BlockBase extends Block implements IHasModel {

    public BlockBase(String name, Material material) {
        super(material);

        setUnlocalizedName(Reference.MOD_ID + "." + name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTabs.CREATIVE_BLOCKS);

        ModBlocks.blocks.add(this);
        ModItems.items.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public BlockBase(String name, Material material, float hardness) {
        this(name, material);

        setHardness(hardness);
    }

    public BlockBase(String name, Material material, float hardness, float resistance) {
        this(name, material, hardness);

        setResistance(resistance);
    }

    public BlockBase(String name, Material material, float hardness, float resistance, String tool, int harvestLevel) {
        this(name, material, hardness, resistance);

        setResistance(resistance);
        setHarvestLevel(tool, harvestLevel);
    }

    @Override
    public void registerModels() {
        MangoOres.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
