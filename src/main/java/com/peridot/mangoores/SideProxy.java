package com.peridot.mangoores;

import com.peridot.mangoores.game.client.entities.renders.RenderRegistry;
import com.peridot.mangoores.game.common.blocks.ModBlocks;
import com.peridot.mangoores.game.common.entities.ModEntities;
import com.peridot.mangoores.game.common.items.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class SideProxy {

    SideProxy() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, ModBlocks::registerAll);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, ModItems::registerAll);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, ModEntities::registerAll);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private static void commonSetup(FMLCommonSetupEvent event) {

    }

    private static void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private static void processIMC(final InterModProcessEvent event) {
    }

    @SubscribeEvent
    public void serverStarting(FMLServerStartingEvent event) {

    }

    static class Client extends SideProxy {
        Client() {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(Client::clientSetup);
        }

        private static void clientSetup(FMLClientSetupEvent event) {
            RenderRegistry.registerEntityRenders();
        }
    }

    static class Server extends SideProxy {
        Server() {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(Server::serverSetup);
        }

        private static void serverSetup(FMLDedicatedServerSetupEvent event) {
        }
    }

}
