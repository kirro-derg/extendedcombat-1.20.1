package dev.kirro.extendedcombat.item.behaviour;

import net.minecraft.entity.player.PlayerEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class XPRepairTracker {
    private static final Map<UUID, Integer> lastXPMap = new HashMap<>();

    public static void tick(PlayerEntity player) {
        UUID uuid = player.getUuid();
        int currentXP = player.totalExperience;
        int lastXP = lastXPMap.getOrDefault(uuid, currentXP);

        if (currentXP > lastXP) {
            int gainedXP = currentXP - lastXP;
            ModRepairManager.repairItemsWithXP(player, gainedXP);
        }

        lastXPMap.put(uuid, currentXP);
    }
}