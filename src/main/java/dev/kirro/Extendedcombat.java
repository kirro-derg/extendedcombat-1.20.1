package dev.kirro;

import dev.kirro.extendedcombat.ModItemGroups;
import dev.kirro.extendedcombat.block.ModBlocks;
import dev.kirro.extendedcombat.item.ModItems;
//import dev.kirro.extendedcombat.sound.ModSounds;
import dev.kirro.extendedcombat.villager.ModPOI;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.minecraft.resource.ResourceType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static dev.kirro.extendedcombat.item.custom.ModArmorScaleChanger.updatePlayerScale;

public class Extendedcombat implements ModInitializer {
	public static final String MOD_ID = "extendedcombat";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		//ModSounds.registerSounds();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModPOI.registerPOIs();

		ServerTickEvents.START_SERVER_TICK.register(server -> {
			for (ServerPlayerEntity player : server.getPlayerManager().getPlayerList()) {
				updatePlayerScale(player);
			}
		});


	}







}