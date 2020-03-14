package com.peridot.mangoores.game.common.entities;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.entities.entities.GorofEntity;
import com.peridot.mangoores.game.common.items.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {

    public static EntityType<GorofEntity> gorof_entity = register("gorof", EntityType.Builder.<GorofEntity>create(GorofEntity::new, EntityClassification.CREATURE).size(0.5F, 1.2F));

    public static void registerAll(final RegistryEvent.Register<Item> event) {
        ModItems.GOROF_ENTITY_EGG = registerEntitySpawnEgg(gorof_entity, 0xe34444, 0xa52b2b, "gorof_spawn_egg");
    }

    public static Item registerEntitySpawnEgg(EntityType<?> type, int color1, int color2, String name) {
        ResourceLocation id = MangoOres.getId(name);
        SpawnEggItem item = new SpawnEggItem(type, color1, color2, new Item.Properties().group(ItemGroup.MISC));
        item.setRegistryName(id);
        ForgeRegistries.ITEMS.register(item);
        return item;
    }

    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> entity) {
        ResourceLocation id = MangoOres.getId(name);
        EntityType<T> entityType = entity.build(MangoOres.MOD_ID + ":" + name);
        entityType.setRegistryName(MangoOres.getId(name));
        ForgeRegistries.ENTITIES.register(entityType);
        return entityType;
    }

}
