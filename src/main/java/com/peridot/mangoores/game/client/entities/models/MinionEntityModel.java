package com.peridot.mangoores.game.client.entities.models;

import com.peridot.mangoores.game.common.entities.entities.MinionEntity;
import net.minecraft.client.renderer.entity.model.HorseModel;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MinionEntityModel extends PlayerModel<MinionEntity> {

    public MinionEntityModel(boolean slim) {
        super(0.5F, slim);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.func_228301_a_(-4.0F, -10.25F, -4.0F, 8.0F, 8.0F, 8.0F, 3.15F);
        this.bipedHeadwear.setRotationPoint(0.0F, 0.0F + 5.0F, 0.0F);
    }

    @Override
    public void func_225597_a_(MinionEntity minionEntity, float limbSwing, float limbSwingAmount, float ageInTicks, float headYaw, float headPitch) {
        this.isChild = true;
        super.func_225597_a_(minionEntity, limbSwing, limbSwingAmount, ageInTicks, headYaw, headPitch);
    }
}
