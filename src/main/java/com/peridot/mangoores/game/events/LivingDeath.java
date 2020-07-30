package com.peridot.mangoores.game.events;

import com.peridot.mangoores.game.common.items.ModItems;
import com.peridot.mangoores.game.common.items.custom.tools.InactiveLightningSwordItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LivingDeath {

    @SubscribeEvent
    public void livingDeath(LivingDeathEvent event) {
        Entity entity = event.getSource().getTrueSource();

        if (event.getSource().getTrueSource() == null || !(event.getSource().getTrueSource() instanceof PlayerEntity)) {
            return;
        }
        PlayerEntity player = (PlayerEntity) entity;

        if (!(event.getEntity() instanceof CreeperEntity)) {
            return;
        }
        CreeperEntity creeperEntity = (CreeperEntity) event.getEntity();

        if (!creeperEntity.isCharged()) {
            return;
        }
        ItemStack item = player.getHeldItemMainhand();

        if (!(item.getItem() instanceof InactiveLightningSwordItem)) {
            return;
        }

        player.setHeldItem(Hand.MAIN_HAND, new ItemStack(ModItems.LIGHTING_SWORD));

        World world = entity.getEntityWorld();
        if (world.isRemote) {
            return;
        }

        if (!(world instanceof ServerWorld)) {
            return;
        }
        ServerWorld serverWorld = (ServerWorld) world;

        LightningBoltEntity lightning = EntityType.LIGHTNING_BOLT.create(world);
        lightning.func_233576_c_(player.getPositionVec());
        lightning.func_233623_a_(false);
        serverWorld.addEntity(lightning);
        serverWorld.func_241113_a_(0, 6000, true, true);
    }

}
