package io.runescape.content.commands.helper;

import io.runescape.content.commands.Command;
import io.runescape.content.shatteredshards.help.HelpDatabase;
import io.runescape.model.entity.player.Player;

/**
 * Opens an interface containing all help tickets.
 * 
 * @author Emiel
 */
public class Helpdb extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		HelpDatabase.getDatabase().openDatabase(c);
	}
}
