package dev.kirro.extendedcombat.mixin.client;

import dev.kirro.extendedcombat.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorFeatureRenderer.class)
public abstract class ArmorFeatureRendererMixin<T extends LivingEntity> {

    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void modifyArmorVisibility(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, T entity,
                                       float f, float g, float h, float j, float k, float l, CallbackInfo ci) {
        if (entity instanceof PlayerEntity player) {
                ItemStack stack = player.getInventory().getArmorStack(2);
                if (stack.isOf(ModItems.NETHER_STEEL_CHESTPLATE) && player.isInvisible()) {
                    ci.cancel();
                }
        }
    }
}
