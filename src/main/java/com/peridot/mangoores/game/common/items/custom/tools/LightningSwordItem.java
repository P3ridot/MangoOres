package com.peridot.mangoores.game.common.items.custom.tools;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class LightningSwordItem extends SwordItem {

    public LightningSwordItem(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties p_i48460_4_) {
        super(tier, attackDamageIn, attackSpeedIn, p_i48460_4_);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        if (!world.isRemote) {
            ItemStack item = player.getHeldItem(hand);

            if (!player.isCreative() && item.getMaxDamage() - item.getDamage() < 5) {
                return super.onItemRightClick(world, player, hand);
            }

            float f = player.rotationPitch;
            float f1 = player.rotationYaw;
            Vector3d vec3d = player.getEyePosition(1.0F);
            float f2 = MathHelper.cos(-f1 * ((float) Math.PI / 180F) - (float) Math.PI);
            float f3 = MathHelper.sin(-f1 * ((float) Math.PI / 180F) - (float) Math.PI);
            float f4 = -MathHelper.cos(-f * ((float) Math.PI / 180F));
            float f5 = MathHelper.sin(-f * ((float) Math.PI / 180F));
            float f6 = f3 * f4;
            float f7 = f2 * f4;
            double d0 = 15; //distance
            Vector3d vec3d1 = vec3d.add((double) f6 * d0, (double) f5 * d0, (double) f7 * d0);
            RayTraceResult rts = player.world.rayTraceBlocks(new RayTraceContext(vec3d, vec3d1, RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.ANY, player));

            if (rts != null && rts.getType() == RayTraceResult.Type.BLOCK || rts.getType() == RayTraceResult.Type.ENTITY) {
                LightningBoltEntity lightning = EntityType.LIGHTNING_BOLT.create(world);
                lightning.func_233576_c_(rts.getHitVec());
                lightning.func_233623_a_(false);
                world.addEntity(lightning);

                player.getCooldownTracker().setCooldown(this, 40);

                if (!player.isCreative()) {
                    item.damageItem(5, player, (p_220045_0_) -> {
                        p_220045_0_.sendBreakAnimation(EquipmentSlotType.MAINHAND);
                    });
                }
            }
        }
        return super.onItemRightClick(world, player, hand);
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(this.func_234801_g_().func_240699_a_(TextFormatting.GRAY));
    }

    @OnlyIn(Dist.CLIENT)
    public IFormattableTextComponent func_234801_g_() {
        return new TranslationTextComponent(this.getTranslationKey() + ".desc");
    }

}
