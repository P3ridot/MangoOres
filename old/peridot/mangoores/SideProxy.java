package peridot.mangoores;

import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import peridot.mangoores.game.blocks.ModBlocks;
import peridot.mangoores.game.items.ModItems;

public class SideProxy {

    SideProxy() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::imcEnqueue);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::imcProcess);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModBlocks::registerAll);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModItems::registerAll);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    private void imcEnqueue(InterModEnqueueEvent event) {

    }

    private void imcProcess(InterModProcessEvent event) {

    }

    static class Client extends SideProxy {
        Client() {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        }

        private void clientSetup(FMLClientSetupEvent event) {

        }
    }

    static class Server extends SideProxy {
        Server() {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        }

        private void serverSetup(FMLDedicatedServerSetupEvent event) {

        }
    }

}
