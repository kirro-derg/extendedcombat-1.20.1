package dev.kirro.extendedcombat.block.entity;

import dev.kirro.extendedcombat.ExtendedCombat;
import dev.kirro.extendedcombat.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntityTypes {
    public static <T extends BlockEntityType<?>> T register(String path,  T type) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(ExtendedCombat.MOD_ID, path), type);
    }

    public static final BlockEntityType<SkyBoxBlockEntity> SKYBOX_BLOCK = register("skybox_block",
            BlockEntityType.Builder.create(SkyBoxBlockEntity::new, ModBlocks.FLAT_BLOCK).build(null)
    );

    public static void initializeBlockEntityTypes() {
        ExtendedCombat.LOGGER.info("registering Block Entities for " + ExtendedCombat.MOD_ID);
    }
}
