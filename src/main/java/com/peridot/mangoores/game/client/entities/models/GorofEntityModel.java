package com.peridot.mangoores.game.client.entities.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.peridot.mangoores.game.common.entities.entities.GorofEntity;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.entity.model.IHasHead;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.HandSide;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GorofEntityModel extends SegmentedModel<GorofEntity> implements IHasArm, IHasHead {

    private final ModelRenderer body;
    private final ModelRenderer leftarm;
    private final ModelRenderer rightarm;
    private final ModelRenderer leftleg;
    private final ModelRenderer rightleg;
    private final ModelRenderer head;
    private final ModelRenderer stick;
    private final ImmutableList<ModelRenderer> parts;

    public GorofEntityModel() {
        this.textureWidth = 48;
        this.textureHeight = 32;

        this.stick = new ModelRenderer(this, 29, 18);
        this.stick.setRotationPoint(1.0F, -5.0F, 1.0F);
        this.stick.addBox(-0.5F, 0.0F, -0.5F, 1F, 2F, 1F, 0.0F);

        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.head.addBox(-3.0F, -3.0F, -3.0F, 6F, 6F, 6F, 0.0F);
        this.head.addChild(this.stick);

        this.body = new ModelRenderer(this, 0, 17);
        this.body.setRotationPoint(-0.5F, 11.0F, -3.0F);
        this.body.addBox(-3.0F, 0.0F, 0.0F, 7F, 9F, 6F, 0.0F);

        this.rightarm = new ModelRenderer(this, 39, 1);
        this.rightarm.setRotationPoint(-4F, 14.0F, 0.0F);
        this.rightarm.addBox(-1.5F, -1.0F, -1.0F, 2F, 7F, 2F, 0.0F);
        this.setRotateAngle(rightarm, 0.0F, 0.0F, 0.08726646259971647F);

        this.leftarm = new ModelRenderer(this, 39, 12);
        this.leftarm.setRotationPoint(4F, 14.0F, 0.0F);
        this.leftarm.addBox(-0.5F, -1.0F, -1.0F, 2F, 7F, 2F, 0.0F);
        this.setRotateAngle(leftarm, 0.0F, 0.0F, -0.08726646259971647F);

        this.rightleg = new ModelRenderer(this, 28, 8);
        this.rightleg.setRotationPoint(-3.0F, 20.0F, -1.0F);
        this.rightleg.addBox(0.0F, 0.0F, 0.0F, 2F, 4F, 2F, 0.0F);

        this.leftleg = new ModelRenderer(this, 28, 1);
        this.leftleg.setRotationPoint(1.0F, 20.0F, -1.0F);
        this.leftleg.addBox(0.0F, 0.0F, 0.0F, 2F, 4F, 2F, 0.0F);

        this.parts = ImmutableList.of(this.head, this.body, this.leftarm, this.rightarm, this.leftleg, this.rightleg);
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return this.parts;
    }

    @Override
    public ModelRenderer getModelHead() {
        return this.head;
    }

    private void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(GorofEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.head.rotateAngleX = headPitch * 0.017453292F;

        this.leftarm.rotateAngleZ = -(MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F);
        this.rightarm.rotateAngleZ = MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
    }

    @Override
    public void translateHand(HandSide handSide, MatrixStack matrixStack) {
        switch (handSide) {
            case LEFT:
                this.leftarm.translateRotate(matrixStack);
                matrixStack.translate(0.0, -0.1, 0.0);
                matrixStack.scale(0.75F, 0.75F, 0.75F);
                break;
            case RIGHT:
                this.rightarm.translateRotate(matrixStack);
                matrixStack.translate(0.0, -0.1, 0.0);
                matrixStack.scale(0.75F, 0.75F, 0.75F);
                break;
        }
    }

}
