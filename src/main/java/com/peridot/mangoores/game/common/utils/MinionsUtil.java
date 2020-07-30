package com.peridot.mangoores.game.common.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.util.ResourceLocation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class MinionsUtil {

    private static final Map<String, ResourceLocation> skinLocationsMap = new ConcurrentHashMap<>();

    private static final List<String> skinOwners = Collections.unmodifiableList(Arrays.asList("Perid0t_", "Kruliczek", "Libter", "BrixNW", "Etoo_", "xAxee", "Hekutoki", "JanekJaran", "Kurotsuwa", "Kamilkime", "HaskellV", "C2H6Cd", "viummi", "zrdzn9", "m__k", "Xevis_", "IgniteDEV"));

    public static ResourceLocation getSkinResourceLocation(String nickName) {
        ResourceLocation resourceLocation = skinLocationsMap.get(nickName);
        if (resourceLocation == null) {
            new Thread(() -> {
                GameProfile gameProfile = null;
                try {
                    gameProfile = Minecraft.getInstance().getIntegratedServer().getPlayerProfileCache().getGameProfileForUsername(nickName);
                } catch (Exception ignored) {
                }
                if (gameProfile != null) {
                    Minecraft.getInstance().getSessionService().fillProfileProperties(gameProfile, false);
                    Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> map = Minecraft.getInstance().getSkinManager().loadSkinFromCache(gameProfile);
                    if (map.containsKey(MinecraftProfileTexture.Type.SKIN)) {
                        skinLocationsMap.put(nickName, Minecraft.getInstance().getSkinManager().loadSkin(map.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN));
                    }
                }
            }).start();
            resourceLocation = skinLocationsMap.get(nickName);
            if (resourceLocation == null) {
                resourceLocation = DefaultPlayerSkin.getDefaultSkinLegacy();
            }
        }
        return resourceLocation;
    }

    public static List<String> getSkinOwners() {
        return skinOwners;
    }

    public static String getRandomSkinOwner() {
        return skinOwners.get(ThreadLocalRandom.current().nextInt(skinOwners.size()));
    }

}
