package peridot.mangoores.game.items.armor;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import peridot.mangoores.MangoOres;
import peridot.mangoores.game.blocks.IHasModel;
import peridot.mangoores.game.init.ModCreativeTabs;
import peridot.mangoores.game.items.ModItems;
import peridot.mangoores.util.Reference;

public class ArmorBase extends ItemArmor implements IHasModel {

    public ArmorBase(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot slot){
        super(material, renderIndex, slot);

        setUnlocalizedName(Reference.MOD_ID+"."+name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTabs.CREATIVE_ARMORS);

        ModItems.items.add(this);
    }

    @Override
    public void registerModels() {
        MangoOres.proxy.registerItemRenderer(this, 0, "inventory");
    }

}
