package dev.kirro.extendedcombat.mixin.client;

import dev.kirro.extendedcombat.item.ModItems;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntityRenderer.class)
public abstract class PlayerEntityMixin <T extends LivingEntity, M extends EntityModel<T>> extends EntityRenderer<T> {

    protected PlayerEntityMixin(EntityRendererFactory.Context ctx) {
        super(ctx);
    }

    @Inject(method = "hasLabel", at = @At("HEAD"), cancellable = true)
    public void modifyNametagVisibility(T entity, CallbackInfoReturnable<Boolean> cir) {
        if (entity instanceof PlayerEntity player) {
            if (player.getInventory().getArmorStack(3).isOf(ModItems.NETHER_STEEL_HELMET)) {
               cir.setReturnValue(false);// Hide the player's nametag if they are wearing a nether steel helmet.
            }
        }
    }
}
