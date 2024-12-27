package dev.kirro.mixin;

import dev.kirro.extendedcombat.item.custom.PickSwordItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(LivingEntity.class)
public abstract class ShieldBreakMixin{
    @Shadow public abstract ItemStack getMainHandStack();

    @Inject(method = "disablesShield", at = @At("HEAD"), cancellable = true)
    protected void disablesShield(CallbackInfoReturnable<Boolean> cir) {
        if (this.getMainHandStack().getItem() instanceof PickSwordItem) {
            cir.setReturnValue(true);
        }
    }
}
