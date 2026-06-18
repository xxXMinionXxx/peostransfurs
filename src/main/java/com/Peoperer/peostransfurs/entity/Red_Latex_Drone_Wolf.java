package com.Peoperer.peostransfurs.entity;

import com.Peoperer.peostransfurs.changed.RedSpreadingLatexType;
import com.Peoperer.peostransfurs.init.ModLatexTypes;
import net.ltxprogrammer.changed.ability.IAbstractChangedEntity;
import net.ltxprogrammer.changed.entity.*;
import net.ltxprogrammer.changed.entity.latex.LatexType;
import net.ltxprogrammer.changed.entity.robot.Exoskeleton;
import net.ltxprogrammer.changed.init.ChangedAttributes;
import net.ltxprogrammer.changed.util.Color3;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeMod;

public class Red_Latex_Drone_Wolf extends ChangedEntity {
    private boolean hasExoLast = false;

    public Red_Latex_Drone_Wolf(EntityType<? extends ChangedEntity> type, Level level) {
        super(type, level);
    }

    public static AttributeSupplier.Builder createAttribures() {
        return ChangedEntity.createLatexAttributes()
                .add(Attributes.FOLLOW_RANGE, 4.0d)
                .add(Attributes.MOVEMENT_SPEED, 0.15d)
                .add(ForgeMod.SWIM_SPEED.get(), 0.2d)
                .add(ChangedAttributes.JUMP_STRENGTH.get(), 0.5d);
    }

    @Override
    protected void setAttributes(AttributeMap attributes) {
        super.setAttributes(attributes);
        attributes.getInstance(Attributes.FOLLOW_RANGE).setBaseValue(4.0);
        attributes.getInstance(Attributes.MOVEMENT_SPEED).setBaseValue(0.15);
        attributes.getInstance(ForgeMod.SWIM_SPEED.get()).setBaseValue(0.2);
        attributes.getInstance(ChangedAttributes.JUMP_STRENGTH.get()).setBaseValue(0.5);
    }

    @Override
    public void variantTick(Level level) {
        super.variantTick(level);

        boolean hasExo = Exoskeleton.getEntityExoskeleton(this.maybeGetUnderlying()).isPresent();
        if (hasExoLast != hasExo) {
            var attributes = this.getAttributes();

            if (hasExo) {
                attributes.getInstance(Attributes.MOVEMENT_SPEED).setBaseValue(1.075);
                attributes.getInstance(ForgeMod.SWIM_SPEED.get()).setBaseValue(0.95);
                attributes.getInstance(ChangedAttributes.JUMP_STRENGTH.get()).setBaseValue(1.0);
            }

            else {
                attributes.getInstance(Attributes.MOVEMENT_SPEED).setBaseValue(0.15);
                attributes.getInstance(ForgeMod.SWIM_SPEED.get()).setBaseValue(0.2);
                attributes.getInstance(ChangedAttributes.JUMP_STRENGTH.get()).setBaseValue(0.5);
            }

            hasExoLast = hasExo;

            var instance = IAbstractChangedEntity.forEitherSafe(this.maybeGetUnderlying()).map(IAbstractChangedEntity::getTransfurVariantInstance).orElse(null);
            if (instance != null) {
                instance.visionType = hasExo ? VisionType.NORMAL : VisionType.BLIND;
                instance.itemUseMode = hasExo ? UseItemMode.NORMAL : UseItemMode.NONE;
                instance.miningStrength = hasExo ? MiningStrength.NORMAL : MiningStrength.WEAK;

                instance.refreshAttributes();
            }
        }
    }

    @Override
    public LatexType getLatexType() {
        return ModLatexTypes.RED_LATEX.get();
    }

    @Override
    public TransfurMode getTransfurMode() {
        return TransfurMode.ABSORPTION;
    }

    @Override
    public Color3 getTransfurColor(TransfurCause cause) {
        return Color3.BLACK;
    }
}
