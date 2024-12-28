package dev.kirro.extendedcombat.item.custom;

import dev.kirro.extendedcombat.item.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import virtuoel.pehkui.api.ScaleData;
import virtuoel.pehkui.api.ScaleRegistries;
import virtuoel.pehkui.api.ScaleType;

public class ModArmorScaleChanger implements ModInitializer {
    public static final Item MODDED_HELMET = ModItems.NETHER_STEEL_HELMET;
    public static final Item MODDED_CHESTPLATE = ModItems.NETHER_STEEL_CHESTPLATE;
    public static final Item MODDED_LEGGINGS = ModItems.NETHER_STEEL_LEGGINGS;
    public static final Item MODDED_BOOTS = ModItems.NETHER_STEEL_BOOTS;
    @Override
    public void onInitialize() {
        ServerTickEvents.START_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                updatePlayerScale(player);
            }
        });
    }
    public static void updatePlayerScale(ServerPlayerEntity player) {
        boolean wearingModdedArmor = isWearingModdedArmor(player);

        ScaleType scaleType = ScaleRegistries.getEntry(ScaleRegistries.SCALE_TYPES, new Identifier("pehkui:base"));
        if (scaleType != null) {
            ScaleData scaleData = scaleType.getScaleData(player);

            if (wearingModdedArmor) {
                scaleData.setScale(1.5F); // 1.5 times the normal size
            } else {
                scaleData.setScale(1.0F); // Reset to normal scale
            }
        }
    }
    private static boolean isWearingModdedArmor(ServerPlayerEntity player) {
        ItemStack helmet = player.getInventory().getArmorStack(3); // Slot 3: Helmet
        ItemStack chestplate = player.getInventory().getArmorStack(2); // Slot 2: Chestplate
        ItemStack leggings = player.getInventory().getArmorStack(1); // Slot 1: Leggings
        ItemStack boots = player.getInventory().getArmorStack(0); // Slot 0: Boots

        return helmet.getItem() == MODDED_HELMET &&
                chestplate.getItem() == MODDED_CHESTPLATE &&
                leggings.getItem() == MODDED_LEGGINGS &&
                boots.getItem() == MODDED_BOOTS;
    }
}