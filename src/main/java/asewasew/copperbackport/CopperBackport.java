package asewasew.copperbackport;

import asewasew.copperbackport.item.ModItems;
import asewasew.copperbackport.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CopperBackport implements ModInitializer {

	public static final String MOD_ID = "copperbackport";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModLootTableModifiers.modifyLootTables();
	}
}
