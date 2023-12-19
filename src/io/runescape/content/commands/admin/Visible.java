package io.runescape.content.commands.admin;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

/**
 * Toggles whether the player will be visible or not.
 * 
 * @author Emiel
 */
public class Visible extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		if (c.isInvisible()) {
			c.setInvisible(false);
			c.sendMessage("You are no longer invisible.");
		} else {
			c.setInvisible(true);
			c.sendMessage("You are now invisible.");
		}
		c.getPA().requestUpdates();
	}
}
