package com.peridot.mangoores.game.client.entities.renders;

import com.peridot.mangoores.game.client.entities.renders.renders.GorofEntityRender;
import com.peridot.mangoores.game.client.entities.renders.renders.MinionEntityRender;
import com.peridot.mangoores.game.client.entities.renders.renders.ScorpionEntityRender;
import com.peridot.mangoores.game.common.entities.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry {

    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.GOROF_ENTITY, GorofEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.MINION_ENTITY, MinionEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SCORPION_ENTITY, ScorpionEntityRender::new);
    }

}
