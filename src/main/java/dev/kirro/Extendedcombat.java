package dev.kirro;

import dev.kirro.extendedcombat.ModItemGroups;
import dev.kirro.extendedcombat.block.ModBlocks;
import dev.kirro.extendedcombat.item.ModItems;
import dev.kirro.extendedcombat.sound.ModSounds;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Extendedcombat implements ModInitializer {
	public static final String MOD_ID = "extendedcombat";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModSounds.registerSounds();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}