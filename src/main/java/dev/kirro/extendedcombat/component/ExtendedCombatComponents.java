package dev.kirro.extendedcombat.component;

import dev.kirro.extendedcombat.ExtendedCombat;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import net.minecraft.util.Identifier;

public class ExtendedCombatComponents {
    public static final ComponentKey<GhostCharmComponent> GHOST_CHARM_COMPONENT =
            ComponentRegistryV3.INSTANCE.getOrCreate(
                    new Identifier(ExtendedCombat.MOD_ID, "ghost_charm_component"),
                    GhostCharmComponent.class
            );
}
