package com.peridot.mangoores.game.events;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.client.entities.layers.OverheadItemLayer;
import com.peridot.mangoores.game.common.items.ModItems;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.network.play.NetworkPlayerInfo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.util.*;

@Mod.EventBusSubscriber(modid = MangoOres.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class RenderPlayer {

    private static final HashMap<UUID, ResourceLocation> capesMap = new HashMap<>();
    private static final HashMap<UUID, ItemStack> overheadItemsMap = new HashMap<>();
    private static final Set<PlayerEntity> capesDone = new HashSet<>();
    private static final Set<PlayerEntity> overheadItemsDone = new HashSet<>();

    static {
        capesMap.put(UUID.fromString("322345c7-86e6-4ee7-9ced-075032b9341e"), MangoOres.getId("textures/capes/creator_cape.png"));
        capesMap.put(UUID.fromString("380df991-f603-344c-a090-369bad2a924a"), MangoOres.getId("textures/capes/creator_cape.png"));

        overheadItemsMap.put(UUID.fromString("322345c7-86e6-4ee7-9ced-075032b9341e"), new ItemStack(ModItems.MANGO_WRENCH));
        overheadItemsMap.put(UUID.fromString("380df991-f603-344c-a090-369bad2a924a"), new ItemStack(ModItems.MANGO_WRENCH));
    }

    @SubscribeEvent
    public static void renderPlayer(RenderPlayerEvent event) {
        PlayerEntity player = event.getPlayer();

        if (!capesDone.contains(player)) {
            if (capesMap.get(player.getUniqueID()) != null) {
                if (player instanceof AbstractClientPlayerEntity) {
                    AbstractClientPlayerEntity clientPlayer = (AbstractClientPlayerEntity) player;
                    if (clientPlayer.hasPlayerInfo()) {
                        NetworkPlayerInfo info = ObfuscationReflectionHelper.getPrivateValue(AbstractClientPlayerEntity.class, clientPlayer, "playerInfo");
                        Map<MinecraftProfileTexture.Type, ResourceLocation> textures = ObfuscationReflectionHelper.getPrivateValue(NetworkPlayerInfo.class, info, "playerTextures");
                        textures.put(MinecraftProfileTexture.Type.CAPE, capesMap.get(player.getUniqueID()));
                        textures.put(MinecraftProfileTexture.Type.ELYTRA, capesMap.get(player.getUniqueID()));
                        capesDone.add(player);
                    }
                }
            }
        }

        if (!overheadItemsDone.contains(player)) {
            if (overheadItemsMap.get(player.getUniqueID()) != null) {
                event.getRenderer().addLayer(new OverheadItemLayer<>(event.getRenderer(), overheadItemsMap.get(player.getUniqueID())));
                overheadItemsDone.add(player);
            }
        }
    }
}
