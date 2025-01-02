package dev.kirro.extendedcombat.mixin;

import dev.kirro.extendedcombat.ExtendedCombat;
import dev.kirro.extendedcombat.item.ModItems;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
    @ModifyVariable(method = "renderItem", at = @At(value = "HEAD"), argsOnly = true)
    public BakedModel useItemModel(BakedModel value, ItemStack stack, ModelTransformationMode renderMode, boolean leftHanded, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (stack.isOf(ModItems.NETHER_STEEL_GREATSWORD) && renderMode != ModelTransformationMode.GUI) {
            return ((ItemRendererAccessorMixin) this).extendedcombat$getModels().getModelManager().getModel(new ModelIdentifier(ExtendedCombat.MOD_ID, "nether_steel_greatsword_handheld", "inventory"));
        }
        return value;
    }
}
