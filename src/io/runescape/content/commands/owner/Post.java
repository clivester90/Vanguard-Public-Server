package io.runescape.content.commands.owner;

import io.runescape.content.commands.Command;
import io.runescape.content.tradingpost.Listing;
import io.runescape.model.entity.player.Player;

public class Post extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		Listing.openPost(c, false);
	}
}
