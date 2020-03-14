package peridot.mangoores.proxy;

import com.google.common.collect.Ordering;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import peridot.mangoores.game.blocks.events.RightClickBlock;
import peridot.mangoores.game.entities.ModEntities;
import peridot.mangoores.game.entities.events.EntityInteract;
import peridot.mangoores.game.entities.rendering.RenderHandler;
import peridot.mangoores.game.init.compat.ModOreDictionaryCompat;
import peridot.mangoores.game.items.ModItems;

public class CommonProxy {

    public void registerItemRenderer(Item item, int meta, String id) {
    }

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        ModEntities.init();
        RenderHandler.registerEntityRenders();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModOreDictionaryCompat.registerOreDicionaries();
        ModRecipes.init();
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        ModCreativeTabs.tabSorter = Ordering.explicit(ModItems.items).onResultOf(ItemStack::getItem);

        //EVENTS
        MinecraftForge.EVENT_BUS.register(RightClickBlock.class);
        MinecraftForge.EVENT_BUS.register(EntityInteract.class);
    }

}
