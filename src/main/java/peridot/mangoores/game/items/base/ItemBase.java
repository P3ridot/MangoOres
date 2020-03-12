package peridot.mangoores.game.items.base;

import net.minecraft.item.Item;
import peridot.mangoores.MangoOres;
import peridot.mangoores.game.blocks.IHasModel;
import peridot.mangoores.game.init.ModCreativeTabs;
import peridot.mangoores.game.items.ModItems;
import peridot.mangoores.util.Reference;

public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name){
        setUnlocalizedName(Reference.MOD_ID+"."+name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTabs.CREATIVE_ITEMS);

        ModItems.items.add(this);
    }

    @Override
    public void registerModels() {
        MangoOres.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
