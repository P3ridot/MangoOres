package com.peridot.mangoores.game.client.entities.renders.renders;

import com.peridot.mangoores.game.client.entities.models.GorofEntityModel;
import com.peridot.mangoores.game.common.entities.entities.GorofEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class GorofEntityRender extends MobRenderer<GorofEntity, GorofEntityModel> {

    public GorofEntityRender(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new GorofEntityModel(), 0.4F);
        this.addLayer(new HeldItemLayer<>(this));
    }

    @Override
    public ResourceLocation getEntityTexture(GorofEntity entity) {
        return entity.getTexture();
    }

    public static class RenderFactory implements IRenderFactory<GorofEntity> {

        @Override
        public EntityRenderer<? super GorofEntity> createRenderFor(EntityRendererManager manager) {
            return new GorofEntityRender(manager);
        }

    }

}
