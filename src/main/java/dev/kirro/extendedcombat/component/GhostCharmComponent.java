package dev.kirro.extendedcombat.component;

import dev.onyxstudios.cca.api.v3.component.Component;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

public class GhostCharmComponent implements Component, AutoSyncedComponent, PlayerComponent<GhostCharmComponent> {
    private final PlayerEntity player;
    private static boolean isInvisible = false;

    public GhostCharmComponent(PlayerEntity player) {
        this.player = player;
    }

    public boolean isInvisible() {
        return isInvisible;
    }

    public void setInvisible(boolean invisible) {
        this.isInvisible = invisible;

        ExtendedCombatComponents.GHOST_CHARM_COMPONENT.sync(player);
    }

    @Override
    public void readFromNbt(NbtCompound nbtCompound) {
        this.isInvisible = nbtCompound.getBoolean("isInvisible");
    }

    @Override
    public void writeToNbt(NbtCompound nbtCompound) {
        nbtCompound.putBoolean("isInvisible", this.isInvisible);
    }
}
