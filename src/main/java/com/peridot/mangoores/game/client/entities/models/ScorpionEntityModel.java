package com.peridot.mangoores.game.client.entities.models;


import com.google.common.collect.ImmutableList;
import com.peridot.mangoores.game.common.entities.entities.ScorpionEntity;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;

public class ScorpionEntityModel<T extends ScorpionEntity> extends SegmentedModel<T> {

    private final ModelRenderer head;
    private final ModelRenderer neck;
    private final ModelRenderer leg1;
    private final ModelRenderer leg2;
    private final ModelRenderer leg3;
    private final ModelRenderer leg4;
    private final ModelRenderer leg5;
    private final ModelRenderer leg6;
    private final ModelRenderer leg7;
    private final ModelRenderer leg8;
    private final ModelRenderer segments;
    private final ModelRenderer segment1;
    private final ModelRenderer segment2;
    private final ModelRenderer segment3;
    private final ModelRenderer segment4;
    private final ModelRenderer segment5;
    private final ModelRenderer stinger;
    private final ModelRenderer pincers;
    private final ModelRenderer pincers_right;
    private final ModelRenderer pincers_right1;
    private final ModelRenderer pincers_right2;
    private final ModelRenderer pincers_right3;
    private final ModelRenderer pincers_right4;
    private final ModelRenderer pincers_left;
    private final ModelRenderer pincers_left1;
    private final ModelRenderer pincers_left2;
    private final ModelRenderer pincers_left3;
    private final ModelRenderer pincers_left4;
    private final ImmutableList<ModelRenderer> parts;

    public ScorpionEntityModel() {
        textureWidth = 64;
        textureHeight = 64;

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 15.0F, -3.0F);
        head.setTextureOffset(32, 4).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F);

        neck = new ModelRenderer(this);
        neck.setRotationPoint(0.0F, 15.0F, 0.0F);
        neck.setTextureOffset(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 9.0F, 0.0F);


        pincers = new ModelRenderer(this);
        pincers.setRotationPoint(0.0F, 0.0F, -4.75F);
        neck.addChild(pincers);


        pincers_right = new ModelRenderer(this);
        pincers_right.setRotationPoint(-2.75F, 0.0F, 2.0F);
        pincers.addChild(pincers_right);
        setRotationAngle(pincers_right, 0.0F, -0.8727F, 0.0F);


        pincers_right1 = new ModelRenderer(this);
        pincers_right1.setRotationPoint(0.0F, 0.0F, 0.0F);
        pincers_right.addChild(pincers_right1);
        pincers_right1.setTextureOffset(34, 22).addBox(-12.0F, -1.0F, -1.0F, 13.0F, 2.0F, 2.0F, 0.0F, false);

        pincers_right2 = new ModelRenderer(this);
        pincers_right2.setRotationPoint(-11.25F, 0.0F, 0.0F);
        pincers_right.addChild(pincers_right2);
        setRotationAngle(pincers_right2, 0.0F, -0.6981F, 0.0F);
        pincers_right2.setTextureOffset(34, 27).addBox(-2.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.1F, false);

        pincers_right3 = new ModelRenderer(this);
        pincers_right3.setRotationPoint(-3.0F, -0.5F, -1.0F);
        pincers_right2.addChild(pincers_right3);
        pincers_right3.setTextureOffset(47, 27).addBox(-2.5F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        pincers_right4 = new ModelRenderer(this);
        pincers_right4.setRotationPoint(-3.0F, -0.5F, 1.0F);
        pincers_right2.addChild(pincers_right4);
        pincers_right4.setTextureOffset(47, 30).addBox(-2.5F, 0.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        pincers_left = new ModelRenderer(this);
        pincers_left.setRotationPoint(2.75F, 0.0F, 2.0F);
        pincers.addChild(pincers_left);
        setRotationAngle(pincers_left, 0.0F, 0.8727F, 0.0F);


        pincers_left1 = new ModelRenderer(this);
        pincers_left1.setRotationPoint(0.0F, 0.0F, 0.0F);
        pincers_left.addChild(pincers_left1);
        pincers_left1.setTextureOffset(34, 36).addBox(-1.0F, -1.0F, -1.0F, 13.0F, 2.0F, 2.0F, 0.0F, false);

        pincers_left2 = new ModelRenderer(this);
        pincers_left2.setRotationPoint(11.25F, 0.0F, 0.0F);
        pincers_left.addChild(pincers_left2);
        setRotationAngle(pincers_left2, 0.0F, 0.6981F, 0.0F);
        pincers_left2.setTextureOffset(34, 41).addBox(-0.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.1F, false);

        pincers_left3 = new ModelRenderer(this);
        pincers_left3.setRotationPoint(3.0F, 0.0F, -1.0F);
        pincers_left2.addChild(pincers_left3);
        pincers_left3.setTextureOffset(47, 41).addBox(-0.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        pincers_left4 = new ModelRenderer(this);
        pincers_left4.setRotationPoint(3.0F, 0.0F, 1.0F);
        pincers_left2.addChild(pincers_left4);
        pincers_left4.setTextureOffset(47, 44).addBox(-0.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, false);

        leg1 = new ModelRenderer(this);
        leg1.setRotationPoint(-4.0F, 15.0F, 2.0F);
        leg1.setTextureOffset(21, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F);

        leg2 = new ModelRenderer(this);
        leg2.setRotationPoint(4.0F, 15.0F, 2.0F);
        leg2.setTextureOffset(21, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F);

        leg3 = new ModelRenderer(this);
        leg3.setRotationPoint(-4.0F, 15.0F, 1.0F);
        leg3.setTextureOffset(21, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F);

        leg4 = new ModelRenderer(this);
        leg4.setRotationPoint(4.0F, 15.0F, 1.0F);
        leg4.setTextureOffset(21, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F);

        leg5 = new ModelRenderer(this);
        leg5.setRotationPoint(-4.0F, 15.0F, 0.0F);
        leg5.setTextureOffset(21, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F);

        leg6 = new ModelRenderer(this);
        leg6.setRotationPoint(4.0F, 15.0F, 0.0F);
        leg6.setTextureOffset(21, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F);

        leg7 = new ModelRenderer(this);
        leg7.setRotationPoint(-4.0F, 15.0F, -1.0F);
        leg7.setTextureOffset(21, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F);

        leg8 = new ModelRenderer(this);
        leg8.setRotationPoint(4.0F, 15.0F, -1.0F);
        leg8.setTextureOffset(21, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, 0.0F);

        segments = new ModelRenderer(this);
        segments.setRotationPoint(0.0F, 14.0F, 7.0F);


        segment1 = new ModelRenderer(this);
        segment1.setRotationPoint(0.0F, 0.0F, -1.25F);
        segments.addChild(segment1);
        setRotationAngle(segment1, -0.8727F, 0.0F, 0.0F);
        segment1.setTextureOffset(0, 22).addBox(-2.5F, -7.0F, -1.5F, 5.0F, 8.0F, 3.0F, 0.0F, false);

        segment2 = new ModelRenderer(this);
        segment2.setRotationPoint(0.0F, -4.0F, 3.25F);
        segments.addChild(segment2);
        setRotationAngle(segment2, -0.2618F, 0.0F, 0.0F);
        segment2.setTextureOffset(17, 22).addBox(-2.5F, -6.75F, -1.0F, 5.0F, 7.0F, 3.0F, -0.2F, false);

        segment3 = new ModelRenderer(this);
        segment3.setRotationPoint(0.0F, -9.0F, 4.75F);
        segments.addChild(segment3);
        setRotationAngle(segment3, 0.6109F, 0.0F, 0.0F);
        segment3.setTextureOffset(17, 34).addBox(-2.5F, -6.75F, -1.0F, 5.0F, 7.0F, 3.0F, -0.4F, false);

        segment4 = new ModelRenderer(this);
        segment4.setRotationPoint(0.0F, -13.5F, 2.25F);
        segments.addChild(segment4);
        setRotationAngle(segment4, 1.309F, 0.0F, 0.0F);
        segment4.setTextureOffset(0, 34).addBox(-2.5F, -7.75F, -1.0F, 5.0F, 8.0F, 3.0F, -0.6F, false);

        segment5 = new ModelRenderer(this);
        segment5.setRotationPoint(-0.25F, -14.75F, -5.5F);
        segments.addChild(segment5);
        setRotationAngle(segment5, 1.8326F, 0.0F, 0.0F);
        segment5.setTextureOffset(0, 46).addBox(-2.25F, -2.75F, -1.0F, 5.0F, 5.0F, 3.0F, -0.2F, false);

        stinger = new ModelRenderer(this);
        stinger.setRotationPoint(0.0F, 0.0F, 0.0F);
        segment5.addChild(stinger);
        stinger.setTextureOffset(17, 44).addBox(0.25F, -5.75F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F, false);

        this.parts = ImmutableList.of(this.head, this.neck, this.leg1, this.leg2, this.leg3, this.leg4, this.leg5, this.leg6, this.leg7, this.leg8, this.segments);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.rotateAngleY = netHeadYaw * ((float) Math.PI / 180F);
        this.head.rotateAngleX = headPitch * ((float) Math.PI / 180F);
        float f = ((float) Math.PI / 4F);
        this.leg1.rotateAngleZ = (-(float) Math.PI / 4F);
        this.leg2.rotateAngleZ = ((float) Math.PI / 4F);
        this.leg3.rotateAngleZ = -0.58119464F;
        this.leg4.rotateAngleZ = 0.58119464F;
        this.leg5.rotateAngleZ = -0.58119464F;
        this.leg6.rotateAngleZ = 0.58119464F;
        this.leg7.rotateAngleZ = (-(float) Math.PI / 4F);
        this.leg8.rotateAngleZ = ((float) Math.PI / 4F);
        float f1 = -0.0F;
        float f2 = ((float) Math.PI / 8F);
        this.leg1.rotateAngleY = ((float) Math.PI / 4F);
        this.leg2.rotateAngleY = (-(float) Math.PI / 4F);
        this.leg3.rotateAngleY = ((float) Math.PI / 8F);
        this.leg4.rotateAngleY = (-(float) Math.PI / 8F);
        this.leg5.rotateAngleY = (-(float) Math.PI / 8F);
        this.leg6.rotateAngleY = ((float) Math.PI / 8F);
        this.leg7.rotateAngleY = (-(float) Math.PI / 4F);
        this.leg8.rotateAngleY = ((float) Math.PI / 4F);
        float f3 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + 0.0F) * 0.4F) * limbSwingAmount;
        float f4 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * limbSwingAmount;
        float f5 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f6 = -(MathHelper.cos(limbSwing * 0.6662F * 2.0F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        float f7 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + 0.0F) * 0.4F) * limbSwingAmount;
        float f8 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + (float) Math.PI) * 0.4F) * limbSwingAmount;
        float f9 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * limbSwingAmount;
        float f10 = Math.abs(MathHelper.sin(limbSwing * 0.6662F + ((float) Math.PI * 1.5F)) * 0.4F) * limbSwingAmount;
        this.leg1.rotateAngleY += f3;
        this.leg2.rotateAngleY += -f3;
        this.leg3.rotateAngleY += f4;
        this.leg4.rotateAngleY += -f4;
        this.leg5.rotateAngleY += f5;
        this.leg6.rotateAngleY += -f5;
        this.leg7.rotateAngleY += f6;
        this.leg8.rotateAngleY += -f6;
        this.leg1.rotateAngleZ += f7;
        this.leg2.rotateAngleZ += -f7;
        this.leg3.rotateAngleZ += f8;
        this.leg4.rotateAngleZ += -f8;
        this.leg5.rotateAngleZ += f9;
        this.leg6.rotateAngleZ += -f9;
        this.leg7.rotateAngleZ += f10;
        this.leg8.rotateAngleZ += -f10;
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return this.parts;
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        int i = entityIn.getAttackTimer();
        if (i > 0) {
            this.segments.rotateAngleX = 0.38F + -0.4F * MathHelper.func_233021_e_((float) i - partialTick, 10F);
            System.out.println("this.segments.rotateAngleX = " + this.segments.rotateAngleX);
        }
    }

}