package peridot.mangoores.game.entities.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EntityInteract {

    @SubscribeEvent
    public static void entityInteract(PlayerInteractEvent.EntityInteractSpecific event){
        if(event.getSide().isClient()) return;
        if(event.getHand().equals(EnumHand.OFF_HAND)) return;

        Entity target = event.getTarget();

        target.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, event.getEntityPlayer().getItemStackFromSlot(EntityEquipmentSlot.MAINHAND));
        target.setItemStackToSlot(EntityEquipmentSlot.OFFHAND, event.getEntityPlayer().getItemStackFromSlot(EntityEquipmentSlot.OFFHAND));
    }

}
