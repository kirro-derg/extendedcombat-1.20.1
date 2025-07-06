package dev.kirro.extendedcombat;

import dev.kirro.extendedcombat.block.ModBlocks;
import dev.kirro.extendedcombat.block.entity.ModBlockEntityTypes;
import dev.kirro.extendedcombat.component.ExtendedCombatEntityComponents;
import dev.kirro.extendedcombat.item.ModItems;
import dev.kirro.extendedcombat.item.behaviour.XPRepairTracker;
import dev.kirro.extendedcombat.networking.ModMessages;
import dev.kirro.extendedcombat.villager.ModPOI;
//import dev.kirro.extendedcombat.sound.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dev.kirro.extendedcombat.item.custom.ModArmorScaleChanger.updatePlayerScale;

public class ExtendedCombat implements ModInitializer {
    public static final String MOD_ID = "extendedcombat";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();

        //ModSounds.registerSounds();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModPOI.registerPOIs();
        ModBlockEntityTypes.initializeBlockEntityTypes();
        ExtendedCombatEntityComponents.register();
        ModMessages.registerC2SPackets();


        ServerTickEvents.START_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                updatePlayerScale(player);
            }
        });

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
                XPRepairTracker.tick(player);
            }
        });
    }
}
