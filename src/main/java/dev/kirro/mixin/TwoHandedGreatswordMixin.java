package dev.kirro.mixin;

import dev.kirro.extendedcombat.item.custom.PickSwordItem;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerEntityRenderer.class)
public class TwoHandedGreatswordMixin {
	@Inject(method = "getArmPose", at = @At("HEAD"), cancellable = true)
	private static void extendedcombat$getArmPoseDR(AbstractClientPlayerEntity player, Hand hand,
													CallbackInfoReturnable<BipedEntityModel.ArmPose> cir) {
		ItemStack itemStack = player.getMainHandStack();
		if (itemStack.getItem() instanceof PickSwordItem) {
			cir.setReturnValue(BipedEntityModel.ArmPose.CROSSBOW_CHARGE); }
	}
}

