package io.runescape.content.commands.admin;

import java.util.Optional;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.PlayerHandler;
import io.runescape.model.items.ItemAssistant;
import io.runescape.util.Misc;

/**
 * Take a certain amount of items from a player.
 * 
 * @author Emiel
 */
public class Takeitem extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		try {
			String[] args = input.split("-");
			if (args.length != 3) {
				throw new IllegalArgumentException();
			}
			String playerName = args[0];
			int itemID = Integer.parseInt(args[1]);
			int amount = Misc.stringToInt(args[2]);

			Optional<Player> optionalPlayer = PlayerHandler.getOptionalPlayerByDisplayName(playerName);
			if (optionalPlayer.isPresent()) {
				Player c2 = optionalPlayer.get();
				if (c2.getItems().playerHasItem(itemID, 1)) {
					c2.getItems().deleteItem(itemID, amount);
					c.sendMessage("You have just taken " + amount + " " + ItemAssistant.getItemName(itemID) + " from " + c2.getDisplayName() + ".");
					c2.sendMessage(c.getDisplayName() + " has taken " + amount + " " + ItemAssistant.getItemName(itemID) + " from you.");
				} else {
					c.sendMessage("This player doesn't have this item!");
				}

			} else {
				c.sendMessage(playerName + " is not online.");
			}
		} catch (Exception e) {
			c.sendMessage("Error. Correct syntax: ::takeitem-player-itemid-amount");
		}
	}
}
