package com.peridot.mangoores.game.common.entities.entities;

import com.peridot.mangoores.game.common.utils.MinionsUtil;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtWithoutMovingGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.Optional;

public class MinionEntity extends CreatureEntity {

    private static final DataParameter<Optional<ITextComponent>> SKIN_OWNER = EntityDataManager.createKey(MinionEntity.class, DataSerializers.OPTIONAL_TEXT_COMPONENT);

    public MinionEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);

        setSkinOwner(new StringTextComponent(MinionsUtil.getRandomSkinOwner()));
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes() {
        return MobEntity.func_233666_p_()
                .func_233815_a_(Attributes.field_233818_a_, 15D)
                .func_233815_a_(Attributes.field_233821_d_, 0.3D)
                .func_233815_a_(Attributes.field_233823_f_, 2D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 1D));
        this.goalSelector.addGoal(2, new LookAtWithoutMovingGoal(this, PlayerEntity.class, 10F, 10F));
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

    private static void removeClickEvents(ITextComponent textComponent) {
        /*textComponent.applyTextStyle((component) -> {
            component.setClickEvent((ClickEvent) null);
        }).getSiblings().forEach(MinionEntity::removeClickEvents);*/
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

    public ITextComponent getSkinOwner() {
        try {
            ITextComponent resultName = this.dataManager.get(SKIN_OWNER).orElse(null).func_230532_e_();
            removeClickEvents(resultName);
            return resultName;
        } catch (Exception ignored) {
            return null;
        }
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
