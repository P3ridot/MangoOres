package com.peridot.mangoores.game.client.entities.renders;

import com.peridot.mangoores.game.common.entities.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

@OnlyIn(Dist.CLIENT)
public class RenderRegistry {

    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.gorof_entity, GorofEntityRender::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.minion_entity, MinionEntityRender::new);
    }

}
