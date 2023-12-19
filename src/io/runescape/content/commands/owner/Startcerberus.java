package io.runescape.content.commands.owner;

import io.runescape.content.bosses.Cerberus;
import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

/**
 * Update the shops.
 * 
 * @author Emiel
 *
 */
public class Startcerberus extends Command {

	@Override
	public void execute(Player player, String commandName, String input) {
		Cerberus.init(player);
	}
}
