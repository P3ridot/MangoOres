package peridot.mangoores.game.entities.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumHandSide;
import net.minecraft.util.math.MathHelper;

public class ModelGorof extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer rightleg;
    public ModelRenderer leftleg;
    public ModelRenderer righthand;
    public ModelRenderer lefthand;
    public ModelRenderer head;
    public ModelRenderer stick;

    public ModelGorof() {
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.stick = new ModelRenderer(this, 29, 18);
        this.stick.setRotationPoint(1.0F, -5.0F, 1.0F);
        this.stick.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);

        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.head.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.head.addChild(this.stick);

        this.body = new ModelRenderer(this, 0, 17);
        this.body.setRotationPoint(-0.5F, 11.0F, -3.0F);
        this.body.addBox(-3.0F, 0.0F, 0.0F, 7, 9, 6, 0.0F);

        this.righthand = new ModelRenderer(this, 39, 1);
        this.righthand.setRotationPoint(-4F, 14.0F, 0.0F);
        this.righthand.addBox(-1.5F, -1.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(righthand, 0.0F, 0.0F, 0.08726646259971647F);

        this.lefthand = new ModelRenderer(this, 39, 12);
        this.lefthand.setRotationPoint(4F, 14.0F, 0.0F);
        this.lefthand.addBox(-0.5F, -1.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(lefthand, 0.0F, 0.0F,-0.08726646259971647F);

        this.rightleg = new ModelRenderer(this, 28, 8);
        this.rightleg.setRotationPoint(-3.0F, 20.0F, -1.0F);
        this.rightleg.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);

        this.leftleg = new ModelRenderer(this, 28, 1);
        this.leftleg.setRotationPoint(1.0F, 20.0F, -1.0F);
        this.leftleg.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        this.head.render(f5);
        this.body.render(f5);
        this.righthand.render(f5);
        this.lefthand.render(f5);
        this.rightleg.render(f5);
        this.leftleg.render(f5);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;

        this.head.rotateAngleY = netHeadYaw * 0.017453292F;
        this.head.rotateAngleX = headPitch * 0.017453292F;
    }

    public void postRenderArm(float scale, EnumHandSide side) {
        this.getArmForSide(side).postRender(scale);
    }

    protected ModelRenderer getArmForSide(EnumHandSide side) {
        return side == EnumHandSide.LEFT ? this.lefthand : this.righthand;
    }
}
