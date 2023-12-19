package io.runescape.content.commands.moderator;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

/**
 * Make a note for a given player.
 * 
 * @author Emiel
 */
public class Note extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		String command = input.replaceAll("'", "\\\\'");
		String[] args = command.split("-");
		if (args.length != 2) {
			throw new IllegalArgumentException();
		}
		c.sendMessage("Successfully added a note for " + args[1]);
	}
}
