package com.peridot.mangoores.game.common.entities;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.entities.entities.GorofEntity;
import com.peridot.mangoores.game.common.entities.entities.MinionEntity;
import com.peridot.mangoores.game.common.entities.entities.ScorpionEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class ModEntities {

    public static final List<EntityType<?>> entities = new ArrayList<>();

    public static EntityType<GorofEntity> GOROF_ENTITY = register("gorof", EntityType.Builder.create(GorofEntity::new, EntityClassification.CREATURE).size(0.5F, 1.2F));
    public static EntityType<MinionEntity> MINION_ENTITY = register("minion", EntityType.Builder.create(MinionEntity::new, EntityClassification.CREATURE).size(0.5F, 1.2F));
    public static EntityType<ScorpionEntity> SCORPION_ENTITY = register("scorpion", EntityType.Builder.create(ScorpionEntity::new, EntityClassification.CREATURE).size(1.4F, 1.2F));

    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        entities.forEach(entity -> event.getRegistry().register(entity));
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
        entityType.setRegistryName(id);
        entities.add(entityType);
        return entityType;
    }

}
