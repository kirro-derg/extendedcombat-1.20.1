package dev.kirro.extendedcombat.villager;

import com.google.common.collect.ImmutableSet;
import dev.kirro.extendedcombat.ExtendedCombat;
import dev.kirro.extendedcombat.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;

public class ModPOI {
    public static final PointOfInterestType WARDING_STONE_POI = PointOfInterestHelper.register(
            new Identifier(ExtendedCombat.MOD_ID, "warding_stone_poi"),
            1, // Ticket count (controls how many entities can use this POI)
            1, // Search distance
            ImmutableSet.copyOf(ModBlocks.WARDING_STONE.getStateManager().getStates()) // Block states
    );

    public static final PointOfInterestType LANTERN_POI = PointOfInterestHelper.register(
            new Identifier(ExtendedCombat.MOD_ID, "lantern_poi"),
            1,
            1,
            ImmutableSet.copyOf(Blocks.LANTERN.getStateManager().getStates())
    );
    public static final PointOfInterestType TORCH_POI = PointOfInterestHelper.register(
            new Identifier(ExtendedCombat.MOD_ID, "torch_poi"),
            1,
            1,
            ImmutableSet.copyOf(Blocks.TORCH.getStateManager().getStates())
    );



    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(ExtendedCombat.MOD_ID, name), 1, 55, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(ExtendedCombat.MOD_ID, name));
    }

    public static void registerPOIs() {
        ExtendedCombat.LOGGER.info("Registering POIs for " + ExtendedCombat.MOD_ID);
    }
}
