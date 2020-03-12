package peridot.mangoores.game.entities;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import peridot.mangoores.MangoOres;
import peridot.mangoores.game.entities.entity.EntityGorof;
import peridot.mangoores.util.Reference;

public class ModEntities {

    public static void init() {
        registerEntity("gorof", EntityGorof.class, Reference.ENTITY_GOROF, 30, 14894148, 10824491);
    }

    private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2) {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, MangoOres.instance, range, 1, true, color1, color2);
    }

}
