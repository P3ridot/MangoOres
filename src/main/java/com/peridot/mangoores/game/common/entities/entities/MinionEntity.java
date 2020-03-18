package com.peridot.mangoores.game.common.entities.entities;

import com.peridot.mangoores.game.common.entities.ModEntities;
import com.peridot.mangoores.game.common.utils.MinionsUtil;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtWithoutMovingGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.world.World;

import java.util.Optional;

public class MinionEntity extends CreatureEntity {

    private static final DataParameter<Optional<ITextComponent>> SKIN_OWNER = EntityDataManager.createKey(MinionEntity.class, DataSerializers.OPTIONAL_TEXT_COMPONENT);

    @SuppressWarnings("unchecked")
    public MinionEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super((EntityType<? extends CreatureEntity>) ModEntities.minion_entity, worldIn);

        setSkinOwner(new StringTextComponent(MinionsUtil.getRandomSkinOwner()));
    }

    @SuppressWarnings("unchecked")
    public MinionEntity(World world) {
        this((EntityType<? extends CreatureEntity>) ModEntities.minion_entity, world);
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

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(SKIN_OWNER, Optional.empty());
    }

    public ITextComponent setSkinOwner(ITextComponent name) {
        this.dataManager.set(SKIN_OWNER, Optional.ofNullable(name));
        return name;
    }

    public ITextComponent getSkinOwner() {
        try {
            ITextComponent resultName = this.dataManager.get(SKIN_OWNER).orElse((ITextComponent) null).deepCopy();
            removeClickEvents(resultName);
            return resultName;
        } catch (Exception ignored) {
            return null;
        }
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putString("SkinOwner", getOrCreateSkinOwner().getString());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        setSkinOwner(new StringTextComponent(compound.getString("SkinOwner")));
    }

    public ITextComponent getOrCreateSkinOwner() {
        ITextComponent name = getSkinOwner();
        if (name == null) {
            name = setSkinOwner(new StringTextComponent(MinionsUtil.getRandomSkinOwner()));
        }
        return name;
    }

    private static void removeClickEvents(ITextComponent textComponent) {
        textComponent.applyTextStyle((component) -> {
            component.setClickEvent((ClickEvent) null);
        }).getSiblings().forEach(MinionEntity::removeClickEvents);
    }

    public boolean isSlimSkin() {
        return MinionsUtil.isSlimSkin(getResultSkinOwner());
    }

    public String getResultSkinOwner() {
        String skinOwner = "Steve";
        if (getCustomName() == null) {
            ITextComponent skinOwnerComponent = getOrCreateSkinOwner();
            if (skinOwnerComponent != null) skinOwner = skinOwnerComponent.getString();
        } else {
            skinOwner = getCustomName().getString();
        }
        return skinOwner;
    }

    public ResourceLocation getTexture() {
        return MinionsUtil.getSkinResourceLocation(getResultSkinOwner());
    }
}
