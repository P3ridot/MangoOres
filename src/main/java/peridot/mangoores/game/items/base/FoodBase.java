package peridot.mangoores.game.items.base;

import net.minecraft.item.ItemFood;
import peridot.mangoores.MangoOres;
import peridot.mangoores.game.blocks.IHasModel;
import peridot.mangoores.game.init.ModCreativeTabs;
import peridot.mangoores.game.items.ModItems;
import peridot.mangoores.util.Reference;

public class FoodBase extends ItemFood implements IHasModel {

    public FoodBase(String name, int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);

        setUnlocalizedName(Reference.MOD_ID + "." + name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTabs.CREATIVE_FOOD);

        ModItems.items.add(this);
    }

    @Override
    public void registerModels() {
        MangoOres.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
