package peridot.mangoores.game.items.tools;

import net.minecraft.item.ItemHoe;
import peridot.mangoores.MangoOres;
import peridot.mangoores.game.blocks.IHasModel;
import peridot.mangoores.game.init.ModCreativeTabs;
import peridot.mangoores.game.items.ModItems;
import peridot.mangoores.util.Reference;

public class AxeBase extends ItemHoe implements IHasModel {

    public AxeBase(String name, ToolMaterial material){
        super(material);

        setUnlocalizedName(Reference.MOD_ID+"."+name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTabs.CREATIVE_TOOLS);

        ModItems.items.add(this);
    }

    @Override
    public void registerModels() {
        MangoOres.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
