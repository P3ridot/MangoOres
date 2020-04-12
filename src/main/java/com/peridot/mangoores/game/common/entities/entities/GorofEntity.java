package com.peridot.mangoores.game.common.entities.entities;

import com.peridot.mangoores.MangoOres;
import com.peridot.mangoores.game.common.entities.ModEntities;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtWithoutMovingGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GorofEntity extends CreatureEntity {

    @SuppressWarnings("unchecked")
    public GorofEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super((EntityType<? extends CreatureEntity>) ModEntities.GOROF_ENTITY, worldIn);
    }

    @SuppressWarnings("unchecked")
    public GorofEntity(World world) {
        this((EntityType<? extends CreatureEntity>) ModEntities.GOROF_ENTITY, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1D));
        this.goalSelector.addGoal(2, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 10F, 10F));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
    }

    public ResourceLocation getTexture() {
        return MangoOres.getId("textures/entity/gorof.png");
    }
}
