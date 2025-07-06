package dev.kirro.extendedcombat.mixin.client;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.kirro.extendedcombat.ExtendedCombatClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class SkyRenderMixin {
    @Inject(method = "renderSky", at = @At("HEAD"), cancellable = true)
    private void renderCustomSky(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();

        if (ExtendedCombatClient.skyboxShader != null) {
            RenderSystem.setShader(() -> ExtendedCombatClient.skyboxShader);
            ci.cancel();
        }
    }
}
