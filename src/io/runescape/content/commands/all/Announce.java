package io.runescape.content.commands.all;

import java.util.Optional;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

/**
 * Show the current position.
 * 
 * @author Noah
 *
 */
public class Announce extends Command {

	@Override
	public void execute(Player player, String commandName, String input) {
		if (player.announce == false) {
			player.announce = true;
			player.sendMessage("@blu@Global rare announcements are now @red@enabled.");
			return;
		} else {
			player.announce = false;
			player.sendMessage("@blu@Global rare announcements are now @gre@disabled.");
			return;
		}
	}
	@Override
	public Optional<String> getDescription() {
		return Optional.of("Toggle drop announcements.");
	}
}
