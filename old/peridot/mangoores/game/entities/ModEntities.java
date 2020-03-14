package peridot.mangoores.game.entities;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import peridot.mangoores.MangoOres;
import peridot.mangoores.game.entities.entity.EntityGorof;
import peridot.mangoores.game.items.ModItems;

public class ModEntities {

    public static EntityType<T> gorof_entity = EntityType.Builder.create(EntityGorof::new, EntityClassification.CREATURE).build(MangoOres.MOD_ID + ":gorof_entity").setRegistryName(MangoOres.getId("gorof_entity"));

    public static void registerAll(final RegistryEvent.Register<EntityType<?>> event) {
        event.getRegistry().registerAll
                (
                        gorof_entity
                );
    }


    public static void registerAllEntitiesSpawnEggs(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll
                (
                        ModItems.GOROF_ENTITY_EGG = registerEntitySpawnEgg(gorof_entity, 0x2f5882, 0x6f1499, "gorf_entity_egg")
                );

    }

    private static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name) {
        ResourceLocation id = MangoOres.getId(name);
        SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(ItemGroup.MISC));
        item.setRegistryName(id);
        return item;
    }


}
