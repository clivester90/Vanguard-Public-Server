package io.runescape.content.commands.all;

import java.util.Optional;

import io.runescape.Configuration;
import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

/**
 * Opens the game rule page in the default web browser.
 * 
 * @author Emiel
 */
public class Rules extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		c.getPA().sendFrame126(Configuration.RULES_LINK, 12000);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Opens a web page with in-game rules");
	}

}
