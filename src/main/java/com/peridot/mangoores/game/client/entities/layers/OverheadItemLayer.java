package com.peridot.mangoores.game.client.entities.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class OverheadItemLayer<T extends PlayerEntity, M extends BipedModel<T>> extends LayerRenderer<T, M> {

    private final ItemStack item;

    public OverheadItemLayer(IEntityRenderer<T, M> entityRendererIn, ItemStack item) {
        super(entityRendererIn);
        this.item = item;
    }

    @Override
    public void render(MatrixStack matrixStack, IRenderTypeBuffer iRenderTypeBuffer, int i, PlayerEntity entity, float v, float v1, float v2, float v3, float v4, float v5) {
        if (!entity.isInvisible()) {
            matrixStack.push();
            matrixStack.translate(0F, entity.getHeight() - 2.8F, 0F);
            matrixStack.scale(0.45F, 0.45F, 0.45F);
            matrixStack.rotate(Vector3f.XP.rotationDegrees(180.0F));
            matrixStack.rotate(Vector3f.YP.rotationDegrees((v3) / 20.0F * (180F / (float) Math.PI)));
            Minecraft.getInstance().getFirstPersonRenderer().renderItemSide(entity, item, ItemCameraTransforms.TransformType.FIXED, false, matrixStack, iRenderTypeBuffer, i);
            matrixStack.pop();
        }
    }
}
