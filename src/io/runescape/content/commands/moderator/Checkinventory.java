package io.runescape.content.commands.moderator;

import java.util.Optional;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.PlayerHandler;

/**
 * Shows the inventory of a given player.
 * 
 * @author Emiel
 */
public class Checkinventory extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		Optional<Player> optionalPlayer = PlayerHandler.getOptionalPlayerByDisplayName(input);
		if (optionalPlayer.isPresent()) {
			Player c2 = optionalPlayer.get();
			c.getPA().otherInv(c, c2);
			c.getDH().sendDialogues(206, 0);
		} else {
			c.sendMessage(input + " is not online. You can only check the inventory of online players.");
		}
	}
}
