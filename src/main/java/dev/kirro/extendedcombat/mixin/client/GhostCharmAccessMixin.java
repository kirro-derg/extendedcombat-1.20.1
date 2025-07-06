package dev.kirro.extendedcombat.mixin.client;

import dev.kirro.extendedcombat.component.ExtendedCombatComponents;
import dev.kirro.extendedcombat.component.GhostCharmComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

@Mixin(LivingEntity.class)
public class GhostCharmAccessMixin {

    @ModifyArgs(method = "updatePotionVisibility", at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/LivingEntity;setInvisible(Z)V"))
    protected void updatePotionVisibility(Args args) {

        if ((LivingEntity)(Object)this instanceof PlayerEntity player) {
            GhostCharmComponent component = ExtendedCombatComponents.GHOST_CHARM_COMPONENT.get(player);


            if (component.isInvisible()) {
                args.set(0, true);
            }
        }
    }
}
