package dev.kirro.extendedcombat.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import com.llamalad7.mixinextras.sugar.ref.LocalRef;
import dev.kirro.extendedcombat.block.ModBlocks;
import dev.kirro.extendedcombat.villager.ModPOI;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.poi.PointOfInterestStorage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;


@Mixin(HostileEntity.class)
public class WardingBlockDisableSpawnMixin {
    @ModifyReturnValue(method = "isSpawnDark", at = @At("RETURN"))
    private static boolean isSpawnDarkMixin(boolean original, @Local LocalRef<ServerWorldAccess> world, @Local BlockPos pos) {
        int radius = 55;

        if (!(world.get() instanceof ServerWorld serverWorld)) {
            return original; // If not, default to original behavior
        }

        // Get the PointOfInterestStorage from the world
        PointOfInterestStorage poiStorage = serverWorld.getPointOfInterestStorage();

        // Check for points of interest within the radius
        boolean poiNearby = poiStorage.getInCircle(
                registryEntry -> registryEntry.value() == ModPOI.WARDING_BLOCK_POI, // Filter for specific POI type
                pos,
                radius,
                PointOfInterestStorage.OccupationStatus.ANY // Adjust status if needed
        ).findAny().isPresent(); // Use `findAny` for efficiency

        return original && !poiNearby; // Return false if a POI is nearby

    }
}