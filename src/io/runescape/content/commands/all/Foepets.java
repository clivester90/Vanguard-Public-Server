package io.runescape.content.commands.all;

import java.util.Optional;

import io.runescape.Configuration;
import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

/**
 * Open the forums in the default web browser.
 * 
 * @author Emiel
 */
public class Foepets extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		  c.getPA()
          .sendFrame126(
                  Configuration.DISCORD_INVITE, 12000);
}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Opens the discord where you can view Shattered Shard pet benefits.");
	}

}
