package io.runescape.content.commands.owner;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

/**
 * Change back to the original player model.
 * 
 * @author Emiel
 *
 */
public class Unpc extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		c.isNpc = false;
		c.setUpdateRequired(true);
		c.appearanceUpdateRequired = true;
		c.playerStandIndex = 808;
		c.playerWalkIndex = 819;
		c.playerRunIndex = 824;
		c.getPA().requestUpdates();
	}
}
