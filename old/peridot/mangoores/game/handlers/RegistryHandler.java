package peridot.mangoores.game.handlers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import peridot.mangoores.game.blocks.ModBlocks;
import peridot.mangoores.game.items.ModItems;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.items.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(ModBlocks.blocks.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {
        for (Item item : ModItems.items) {
            if (item instanceof IHasModel) {
                ((IHasModel) item).registerModels();
            }
        }

        for (Block block : ModBlocks.blocks) {
            if (block instanceof IHasModel) {
                ((IHasModel) block).registerModels();
            }
        }
    }

}
