package peridot.mangoores.game.blocks.events;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import peridot.mangoores.game.items.ModItems;

public class RightClickBlock {

    @SubscribeEvent
    public static void rightClickInteract(PlayerInteractEvent.RightClickBlock event) {
        EntityPlayer entityPlayer = event.getEntityPlayer();
        if (entityPlayer == null) return;
        if (event.getHand().equals(EnumHand.OFF_HAND)) return;
        if (event.getSide().isClient()) return;
        if (entityPlayer.getHeldItemMainhand().getItem() == ModItems.MANGO_WRENCH) {
            IBlockState state = event.getWorld().getBlockState(event.getPos());
            Block block = state.getBlock();

            entityPlayer.sendMessage(new TextComponentString(" "));
            entityPlayer.sendMessage(new TextComponentString("Localized name:" + block.getLocalizedName()));
            entityPlayer.sendMessage(new TextComponentString("Unlocalized name:" + block.getUnlocalizedName()));
            entityPlayer.sendMessage(new TextComponentString("Registry name:" + block.getRegistryName()));
            entityPlayer.sendMessage(new TextComponentString(" "));
            entityPlayer.sendMessage(new TextComponentString("State (Properties):"));
            for (IProperty property : block.getBlockState().getProperties()) {
                entityPlayer.sendMessage(new TextComponentString("  * " + property.toString()));
            }
            entityPlayer.sendMessage(new TextComponentString(" "));
            entityPlayer.sendMessage(new TextComponentString("Defualt State (Properties):"));
            for (IProperty property : block.getDefaultState().getPropertyKeys()) {
                entityPlayer.sendMessage(new TextComponentString("  * " + property.toString()));
            }
            entityPlayer.sendMessage(new TextComponentString(" "));
        }
    }

}
