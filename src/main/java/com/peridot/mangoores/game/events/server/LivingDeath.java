package com.peridot.mangoores.game.events.server;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.items.ModItems;
import com.peridot.mangoores.game.common.items.custom.tools.InactiveLightningSwordItem;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MangoOres.MOD_ID, value = Dist.DEDICATED_SERVER)
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

        ItemStack newSword = new ItemStack(ModItems.LIGHTING_SWORD);

        EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(item), newSword);

        player.setHeldItem(Hand.MAIN_HAND, newSword);

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
