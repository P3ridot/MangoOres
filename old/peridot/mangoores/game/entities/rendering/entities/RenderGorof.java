package peridot.mangoores.game.entities.rendering.entities;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import peridot.mangoores.game.entities.entity.EntityGorof;
import peridot.mangoores.game.entities.models.ModelGorof;
import peridot.mangoores.game.entities.rendering.entities.layers.LayerGorofHeldItem;
import peridot.mangoores.util.Reference;

public class RenderGorof extends RenderLiving<EntityGorof> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/gorof.png");

    public RenderGorof(RenderManager manager) {
        super(manager, new ModelGorof(), 0.0F);
        this.addLayer(new LayerGorofHeldItem(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGorof entity) {
        return TEXTURES;
    }

    @Override
    protected void applyRotations(EntityGorof entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
    }

}
