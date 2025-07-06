/*package dev.kirro.extendedcombat.trinkets;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.kirro.extendedcombat.item.ModItems;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class SleeveItemLeft extends TrinketItem implements TrinketRenderer {


    public SleeveItemLeft(Settings settings) {
        super(settings);
    }



    @Override
    public void render(ItemStack itemStack, SlotReference slotReference, EntityModel<? extends LivingEntity> model, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack = new ItemStack(ModItems.WOOL_SLEEVES_LEFT);
        TrinketRenderer.translateToLeftArm(matrices, (PlayerEntityModel<AbstractClientPlayerEntity>) model, (AbstractClientPlayerEntity) entity);
        matrices.scale(1.1f, 1.1f, 1.1f);
        matrices.translate(0.0f, 0.2f, 0.0f);
        boolean leftHanded = true;


        renderer.renderItem(entity, stack,
                ModelTransformationMode.FIRST_PERSON_LEFT_HAND, leftHanded, matrices, vertexConsumers, entity.getWorld(), light,
                OverlayTexture.DEFAULT_UV, 0);

    }


}*/
