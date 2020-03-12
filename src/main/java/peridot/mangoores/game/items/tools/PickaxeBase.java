package peridot.mangoores.game.items.tools;

import net.minecraft.item.ItemPickaxe;
import peridot.mangoores.MangoOres;
import peridot.mangoores.game.blocks.IHasModel;
import peridot.mangoores.game.init.ModCreativeTabs;
import peridot.mangoores.game.items.ModItems;
import peridot.mangoores.util.Reference;

public class PickaxeBase extends ItemPickaxe implements IHasModel {

    public PickaxeBase(String name, ToolMaterial material) {
        super(material);

        setUnlocalizedName(Reference.MOD_ID + "." + name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTabs.CREATIVE_TOOLS);

        ModItems.items.add(this);
    }

    @Override
    public void registerModels() {
        MangoOres.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
