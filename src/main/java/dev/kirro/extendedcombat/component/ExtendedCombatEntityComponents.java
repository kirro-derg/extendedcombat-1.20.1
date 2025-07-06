package dev.kirro.extendedcombat.component;

import dev.kirro.extendedcombat.ExtendedCombat;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import net.minecraft.util.Identifier;

public class ExtendedCombatEntityComponents implements EntityComponentInitializer {
    public static final ComponentKey<GhostCharmComponent> GHOST_CHARM_COMPONENT =
            ComponentRegistryV3.INSTANCE.getOrCreate(
                    new Identifier(ExtendedCombat.MOD_ID, "ghost_charm_component"),
                    GhostCharmComponent.class
            );

    public static void register() {
        ExtendedCombat.LOGGER.info("Registering entity components for " + ExtendedCombat.MOD_ID);
    }

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(
                GHOST_CHARM_COMPONENT,
                GhostCharmComponent::new, RespawnCopyStrategy.NEVER_COPY
        );
    }
}
