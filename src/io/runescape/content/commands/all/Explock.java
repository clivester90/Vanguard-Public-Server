package io.runescape.content.commands.all;

import java.util.Optional;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

/**
 * Opens the experience lock interface
 * 
 * @author Tyler
 */
public class Explock extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		c.getExplock().OpenExpLock();
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Interface to manage Exp Locks");
	}

}
