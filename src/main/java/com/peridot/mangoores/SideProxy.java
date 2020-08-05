package com.peridot.mangoores;

import com.peridot.mangoores.game.client.entities.renders.RenderRegistry;
import com.peridot.mangoores.game.common.blocks.ModBlocks;
import com.peridot.mangoores.game.common.entities.ModEntities;
import com.peridot.mangoores.game.common.entities.entities.GorofEntity;
import com.peridot.mangoores.game.common.entities.entities.MinionEntity;
import com.peridot.mangoores.game.common.entities.entities.ScorpionEntity;
import com.peridot.mangoores.game.common.items.ModItems;
import com.peridot.mangoores.game.common.utils.PlayerOrnamentUtil;
import com.peridot.mangoores.game.common.world.generation.ores.NetherOreGeneration;
import com.peridot.mangoores.game.common.world.generation.ores.NormalOreGeneration;
import com.peridot.mangoores.game.common.world.generation.ores.SandOreGeneration;
import com.peridot.mangoores.game.events.client.RenderPlayer;
import com.peridot.mangoores.game.events.server.LivingDeath;
import com.peridot.mangoores.game.events.server.WorldTick;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = MangoOres.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SideProxy {

    SideProxy() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::commonSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Block.class, ModBlocks::registerBlocks);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(Item.class, ModItems::registerItems);
        FMLJavaModLoadingContext.get().getModEventBus().addGenericListener(EntityType.class, ModEntities::registerEntities);

        MinecraftForge.EVENT_BUS.register(new RenderPlayer());

        MinecraftForge.EVENT_BUS.register(new WorldTick());
        MinecraftForge.EVENT_BUS.register(new LivingDeath());
    }

    private static void commonSetup(FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(ModEntities.GOROF_ENTITY, GorofEntity.setCustomAttributes().func_233813_a_());
            GlobalEntityTypeAttributes.put(ModEntities.MINION_ENTITY, MinionEntity.setCustomAttributes().func_233813_a_());
            GlobalEntityTypeAttributes.put(ModEntities.SCORPION_ENTITY, ScorpionEntity.setCustomAttributes().func_233813_a_());
        });
    }

    private static void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private static void processIMC(final InterModProcessEvent event) {

    }

    @SubscribeEvent
    public void serverStarting(FMLServerStartingEvent event) {
        PlayerOrnamentUtil playerOrnamentUtil = new PlayerOrnamentUtil();
        playerOrnamentUtil.registerCapes();
        playerOrnamentUtil.registerOverheadItems();
    }

    @SubscribeEvent
    public static void loadCompleteEvent(FMLLoadCompleteEvent event) {
        new SandOreGeneration(ModBlocks.AMBER_ORE, 25, 0, 0, 128, 2);
        new SandOreGeneration(ModBlocks.AQUAMARINE_ORE, 25, 0, 0, 128, 2);

        new NormalOreGeneration(ModBlocks.PERIDOT_ORE, 2, 0, 0, 36, 3);
        new NormalOreGeneration(ModBlocks.RUBY_ORE, 2, 0, 0, 36, 3);
        new NormalOreGeneration(ModBlocks.SAPPHIRE_ORE, 2, 0, 0, 36, 3);
        new NormalOreGeneration(ModBlocks.TOPAZ_ORE, 1, 0, 0, 24, 3);
        new NormalOreGeneration(ModBlocks.TANZANITE_ORE, 1, 0, 0, 24, 3);

        new NetherOreGeneration(ModBlocks.VULCANITE_ORE, 3, 10, 10, 128, 3);
        new NetherOreGeneration(ModBlocks.KYANITE_ORE, 3, 10, 10, 128, 3);
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
