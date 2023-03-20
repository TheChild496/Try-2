package net.kaupenjoe.tutorialmod.entity.client;

import net.kaupenjoe.tutorialmod.entity.custom.MoleEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import static net.kaupenjoe.tutorialmod.TutorialMod.MODID;

public class MoleRenderer extends GeoEntityRenderer<MoleEntity> {
    public MoleRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new MoleModel());
        this.shadowRadius = 0.4f;
    }

    @Override
    public Identifier getTextureResource(MoleEntity instance) {
        return new Identifier(MODID, "textures/entity/mole.png");
    }

    @Override
    public RenderLayer getRenderType(MoleEntity animatable, float partialTicks, MatrixStack stack,
                                     VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        stack.scale(0.8f, 0.8f, 0.8f);

        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
