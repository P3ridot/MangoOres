package peridot.mangoores.game.entities.rendering.entities.layers;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.CapeLayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHandSide;
import peridot.mangoores.game.entities.models.ModelGorof;
import peridot.mangoores.game.entities.rendering.entities.RenderGorof;

public class LayerGorofHeldItem implements LayerRenderer {

    private final RenderGorof renderGorof;

    public LayerGorofHeldItem(RenderGorof renderGorof) {
        this.renderGorof = renderGorof;
    }

    @Override
    public void doRenderLayer(EntityLivingBase entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        GlStateManager.translate(0, 0.875F, 0.0F);
        GlStateManager.scale(0.5f, 0.5F, 0.5F);

        this.renderHeldItem(entity, entity.getHeldItemOffhand(), ItemCameraTransforms.TransformType.THIRD_PERSON_LEFT_HAND, EnumHandSide.LEFT);
        this.renderHeldItem(entity, entity.getHeldItemMainhand(), ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, EnumHandSide.RIGHT);

        GlStateManager.popMatrix();
    }

    private void renderHeldItem(EntityLivingBase entity, ItemStack item, ItemCameraTransforms.TransformType transformType, EnumHandSide handSide) {
        if (item != null) {
            GlStateManager.pushMatrix();

            boolean flag = handSide == EnumHandSide.LEFT;

            GlStateManager.translate((float) (flag ? 1 : -1) * 0.5625F, 0.0F, 0.0F);

            this.translateToHand(handSide);

            GlStateManager.translate((float) (flag ? 1 : -1) * 0.0625F, 0.65F, -0.0625F);

            GlStateManager.rotate(-100F, 1.0F, 0.0F, 0.0F);
            GlStateManager.rotate(-180F, 0.0F, 1.0F, 0.0F);

            Minecraft.getMinecraft().getItemRenderer().renderItemSide(entity, item, transformType, flag);
            GlStateManager.popMatrix();
        }
    }

    protected void translateToHand(EnumHandSide side) {
        ((ModelGorof) this.renderGorof.getMainModel()).postRenderArm(0.0F, side);
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }
}
