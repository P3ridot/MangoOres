package com.peridot.mangoores.game.common.utils;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.blocks.ModBlocks;
import com.peridot.mangoores.game.common.items.ModItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.UUID;

public class PlayerOrnamentUtil {

    private static final HashMap<UUID, ResourceLocation> capesMap = new HashMap<>();
    private static final HashMap<UUID, ItemStack> overheadItemsMap = new HashMap<>();

    public static ResourceLocation getCape(UUID uuid) {
        return capesMap.get(uuid);
    }

    public static ItemStack getOverheadItem(UUID uuid) {
        return overheadItemsMap.get(uuid);
    }

    public void registerCapes() {
        capesMap.put(UUID.fromString("322345c7-86e6-4ee7-9ced-075032b9341e"), MangoOres.getId("textures/capes/creator_cape.png"));
        capesMap.put(UUID.fromString("380df991-f603-344c-a090-369bad2a924a"), MangoOres.getId("textures/capes/creator_cape.png"));
    }

    public void registerOverheadItems() {
        overheadItemsMap.put(UUID.fromString("322345c7-86e6-4ee7-9ced-075032b9341e"), new ItemStack(ModItems.MANGO_WRENCH));
        overheadItemsMap.put(UUID.fromString("380df991-f603-344c-a090-369bad2a924a"), new ItemStack(ModBlocks.CHUNK_OBSERVER));
    }

}
