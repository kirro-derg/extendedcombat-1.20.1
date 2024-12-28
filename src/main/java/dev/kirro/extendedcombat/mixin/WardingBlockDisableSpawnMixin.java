package dev.kirro.extendedcombat.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import dev.kirro.extendedcombat.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(HostileEntity.class)
public class WardingBlockDisableSpawnMixin {
    @ModifyReturnValue(method = "isSpawnDark", at = @At("RETURN"))
    private static boolean isSpawnDarkMixin(boolean original, @Local LocalRef<ServerWorldAccess> world, @Local BlockPos pos) {
        int radius = 55;
        BlockPos.Mutable mutablePos = new BlockPos.Mutable();

        // Iterate through a cubic region centered on `pos` with the given radius
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {
                    mutablePos.set(pos.getX() + x, pos.getY() + y, pos.getZ() + z);

                    // Check if the block at the current position is the desired type
                    if (world.get().getBlockState(mutablePos).getBlock() == ModBlocks.WARDING_BLOCK) {
                        return original && false; // Early exit if a Warding Block is found
                    }
                }
            }
        }

        return original; // No Warding Block found within the radius
    }
}