package com.peridot.mangoores.game.client.entities.renders.renders;

import com.peridot.mangoores.game.client.entities.models.ScorpionEntityModel;
import com.peridot.mangoores.game.common.entities.entities.ScorpionEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.IRenderFactory;

@OnlyIn(Dist.CLIENT)
public class ScorpionEntityRender extends MobRenderer<ScorpionEntity, ScorpionEntityModel<ScorpionEntity>> {

    public ScorpionEntityRender(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new ScorpionEntityModel<>(), 0.8F);
    }

    @Override
    public ResourceLocation getEntityTexture(ScorpionEntity entity) {
        return entity.getTexture();
    }

    public static class RenderFactory implements IRenderFactory<ScorpionEntity> {

        @Override
        public EntityRenderer<? super ScorpionEntity> createRenderFor(EntityRendererManager manager) {
            return new ScorpionEntityRender(manager);
        }

    }

}
