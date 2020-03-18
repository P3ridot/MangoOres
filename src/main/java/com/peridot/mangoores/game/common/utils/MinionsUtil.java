package com.peridot.mangoores.game.common.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.peridot.mangoores.MangoOres;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.DefaultPlayerSkin;
import net.minecraft.util.ResourceLocation;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class MinionsUtil {

    private static final Map<String, ResourceLocation> skinLocationsMap = new HashMap<>();
    private static final Map<String, Boolean> slimSkinMap = new HashMap<>();

    private static final List<String> skinOwners = Collections.unmodifiableList(Arrays.asList("Perid0t_", "Kruliczek", "Hekutoki", "Libter", "BrixNW", "Etoo_", "xAxee", "darlingvylence", "HaskellV", "JanekJaran", "C2H6Cd", "Kurotsuwa", "Kamilkime", "zrdzn9", "viummi", "m__k", "Xevis_", "IgniteDEV"));

    public static ResourceLocation getSkinResourceLocation(String nickName) {
        GameProfile gameProfile = null;
        try {
            gameProfile = Minecraft.getInstance().getIntegratedServer().getPlayerProfileCache().getGameProfileForUsername(nickName);
        } catch (Exception ignored) {
        }
        ResourceLocation resourceLocation = skinLocationsMap.get(nickName);
        if (gameProfile == null && resourceLocation == null) {
            return DefaultPlayerSkin.getDefaultSkinLegacy();
        } else if (resourceLocation == null) {
            Minecraft.getInstance().getSessionService().fillProfileProperties(gameProfile, false);
            Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> map = Minecraft.getInstance().getSkinManager().loadSkinFromCache(gameProfile);

            resourceLocation = map != null && map.containsKey(MinecraftProfileTexture.Type.SKIN) ? Minecraft.getInstance().getSkinManager().loadSkin(map.get(MinecraftProfileTexture.Type.SKIN), MinecraftProfileTexture.Type.SKIN) : DefaultPlayerSkin.getDefaultSkinLegacy();
            slimSkinMap.put(nickName, map.get(MinecraftProfileTexture.Type.SKIN).getMetadata("model") == "slim");
            skinLocationsMap.put(nickName, resourceLocation);
        }
        return resourceLocation;
    }

    public static List<String> getSkinOwners() {
        return skinOwners;
    }

    public static String getRandomSkinOwner() {
        return skinOwners.get(ThreadLocalRandom.current().nextInt(skinOwners.size()));
    }

    public static boolean isSlimSkin(String nickName) {
        return slimSkinMap.get(nickName);
    }
}
