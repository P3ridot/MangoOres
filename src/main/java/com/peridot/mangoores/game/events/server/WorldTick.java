package com.peridot.mangoores.game.events.server;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.items.custom.tools.LightningSwordItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MangoOres.MOD_ID, value = Dist.DEDICATED_SERVER)
public class WorldTick {

    @SubscribeEvent
    public void tickEvent(TickEvent.WorldTickEvent event) {
        World world = event.world;
        if (world.isRemote) {
            return;
        }
        if (!world.isRaining()) {
            return;
        }
        if (world.getGameTime() % 60 != 0) {
            return;
        }
        for (PlayerEntity player : world.getPlayers()) {
            ItemStack item = player.getHeldItemMainhand();
            if (!(item.getItem() instanceof LightningSwordItem)) {
                return;
            }
            if (item.getDamage() <= 0) {
                return;
            }
            item.setDamage(item.getDamage() - 1);
        }
    }

}
