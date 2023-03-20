package net.kaupenjoe.tutorialmod.entity.client;

import net.kaupenjoe.tutorialmod.entity.custom.MoleEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

import static net.kaupenjoe.tutorialmod.TutorialMod.MODID;

public class MoleModel extends AnimatedGeoModel<MoleEntity> {
    @Override
    public Identifier getModelResource(MoleEntity object) {
        return new Identifier(MODID, "geo/mole.geo.json");
    }

    @Override
    public Identifier getTextureResource(MoleEntity object) {
        return new Identifier(MODID, "textures/entity/mole_texture.png");
    }

    @Override
    public Identifier getAnimationResource(MoleEntity animatable) {
        return new Identifier(MODID, "animations/mole.animation.json");
    }
}


