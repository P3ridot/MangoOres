package com.peridot.mangoores.game.events;

import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.client.entities.layers.OverheadItemLayer;
import com.peridot.mangoores.game.common.utils.PlayerOrnamentUtil;
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

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Mod.EventBusSubscriber(modid = MangoOres.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class RenderPlayer {

    private static final Set<PlayerEntity> capesDone = new HashSet<>();
    private static final Set<PlayerEntity> overheadItemsDone = new HashSet<>();

    @SubscribeEvent
    public static void renderPlayer(RenderPlayerEvent event) {
        PlayerEntity player = event.getPlayer();
        if (!capesDone.contains(player)) {
            ResourceLocation cape = PlayerOrnamentUtil.getCape(player.getUniqueID());
            if (cape != null) {
                if (player instanceof AbstractClientPlayerEntity) {
                    AbstractClientPlayerEntity clientPlayer = (AbstractClientPlayerEntity) player;
                    if (clientPlayer.hasPlayerInfo()) {
                        NetworkPlayerInfo info = ObfuscationReflectionHelper.getPrivateValue(AbstractClientPlayerEntity.class, clientPlayer, "playerInfo");
                        Map<MinecraftProfileTexture.Type, ResourceLocation> textures = ObfuscationReflectionHelper.getPrivateValue(NetworkPlayerInfo.class, info, "playerTextures");
                        textures.put(MinecraftProfileTexture.Type.CAPE, cape);
                        textures.put(MinecraftProfileTexture.Type.ELYTRA, cape);
                        capesDone.add(player);
                    }
                }
            }
        }

        if (!overheadItemsDone.contains(player)) {
            ItemStack item = PlayerOrnamentUtil.getOverheadItem(player.getUniqueID());
            if (item != null) {
                event.getRenderer().addLayer(new OverheadItemLayer<>(event.getRenderer(), PlayerOrnamentUtil.getOverheadItem(player.getUniqueID())));
                overheadItemsDone.add(player);
            }
        }
    }

}
