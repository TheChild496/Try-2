package net.kaupenjoe.tutorialmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.kaupenjoe.tutorialmod.entity.custom.MoleEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static net.kaupenjoe.tutorialmod.TutorialMod.MODID;

public class ModEntities {
    public static final EntityType<MoleEntity> MOLE = Registry.register(
            Registry.ENTITY_TYPE, new Identifier(MODID, "mole"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, MoleEntity::new)
                    .dimensions(EntityDimensions.fixed(0.4f, 0.75f)).build());

}
