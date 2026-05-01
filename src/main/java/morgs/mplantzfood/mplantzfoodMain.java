package morgs.mplantzfood;

import morgs.mplantzfood.setup.blockEntities;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import morgs.mplantzfood.setup.blocks;
import morgs.mplantzfood.setup.items;


public class mplantzfoodMain implements ModInitializer {
	public static final String MOD_ID = "mplantzfood";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		items.initialize();
		blocks.initialize();
		blockEntities.initialize();
	}
}