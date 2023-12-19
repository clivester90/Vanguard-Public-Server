package io.runescape.content.commands.owner;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

/**
 * Open a specific interface.
 * 
 * @author Emiel
 *
 */
public class Itemoninterface extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		try {
			int a = Integer.parseInt(input);
			//c.getPA().showInterface(a);
			c.getPA().itemOnInterface(a, 1, 64503, 0);
			c.getPA().showInterface(64500);
		} catch (Exception e) {
			c.sendMessage("::interface ####");
		}
	}
}
