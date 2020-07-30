package com.peridot.mangoores.game.client.entities.renders.renders;

import com.peridot.mangoores.game.client.entities.models.MinionEntityModel;
import com.peridot.mangoores.game.common.entities.entities.MinionEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.layers.BipedArmorLayer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class MinionEntityRender extends BipedRenderer<MinionEntity, BipedModel<MinionEntity>> {

    public MinionEntityRender(EntityRendererManager rendererManager) {
        super(rendererManager, new MinionEntityModel(false), 0.4F);
        this.addLayer(new BipedArmorLayer<>(this, new BipedModel(0.75F), new BipedModel(1.25F)));
    }

    @Override
    public ResourceLocation getEntityTexture(MinionEntity entity) {
        return entity.getTexture();
    }

}
