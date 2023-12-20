package io.runescape.content;

import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

public class LootValue {
	
	public static void configureValue(Player player, String config, int value) {
		player.getPA().closeAllWindows();
		player.settingLootValue = false;
		
		switch (config) {
		case "setvalue":
			player.lootValue = value;
			if (player.lootValue > 0)
			player.sendMessage("You will now be notified of drops with the value of at least: @blu@"+ Misc.getValueWithoutRepresentation(player.lootValue));
			else
			player.sendMessage("You have not set a minimum loot value to be notified for.");
			break;

		case "checkvalue":
			if (player.lootValue > 0)
				player.sendMessage("You will be notified of drops with the value of at least: @blu@"+ Misc.getValueWithoutRepresentation(player.lootValue));
			else
			player.sendMessage("You have not set a minimum loot value to be notified for.");
			break;

		case "resetvalue":
			player.lootValue = 0;
			player.sendMessage("You have reset your loot value and will be notified of any drops.");
			break;
		}
	}

}
