package io.runescape.content.commands.admin;

import io.runescape.Server;
import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;
import io.runescape.util.logging.player.EmptyInventoryLog;

/**
 * Empty the inventory of the player.
 * 
 * @author Emiel
 */
public class Empty extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		Server.getLogging().write(new EmptyInventoryLog(c, c.getItems().getInventoryItems()));
		c.getPA().removeAllItems();
		c.sendMessage("You empty your inventory.");
	}
}
