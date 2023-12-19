package io.runescape.content.commands.admin;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

/**
 * Change the spellbook.
 * 
 * @author Emiel
 *
 */
public class Spells extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		if (c.playerMagicBook == 2) {
			c.sendMessage("You switch to modern magic.");
			c.setSidebarInterface(6, 938);
			c.playerMagicBook = 0;
			c.getPA().resetAutocast();
		} else if (c.playerMagicBook == 0) {
			c.sendMessage("You switch to ancient magic.");
			c.setSidebarInterface(6, 838);
			c.playerMagicBook = 1;
			c.getPA().resetAutocast();
		} else if (c.playerMagicBook == 1) {
			c.sendMessage("You switch to lunar magic.");
			c.setSidebarInterface(6, 29999);
			c.playerMagicBook = 2;
			c.getPA().resetAutocast();
		}
	}
}
