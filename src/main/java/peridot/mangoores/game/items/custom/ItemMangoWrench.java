package peridot.mangoores.game.items.custom;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import peridot.mangoores.MangoOres;
import peridot.mangoores.game.blocks.IHasModel;
import peridot.mangoores.game.init.ModCreativeTabs;
import peridot.mangoores.game.items.ModItems;
import peridot.mangoores.util.Reference;

import javax.annotation.Nullable;
import java.util.List;

public class ItemMangoWrench extends Item implements IHasModel {

    public ItemMangoWrench(String name){
        setUnlocalizedName(Reference.MOD_ID+"."+name);
        setRegistryName(name);
        setCreativeTab(ModCreativeTabs.CREATIVE_TOOLS);
        setMaxStackSize(1);

        ModItems.items.add(this);
    }

    @Override
    public void addInformation(ItemStack item, World world, List<String> description, ITooltipFlag tooltipFlag) {
        description.add("Debug tool for developers");
    }

    @Override
    public void registerModels() {
        MangoOres.proxy.registerItemRenderer(this, 0, "inventory");
    }
}
