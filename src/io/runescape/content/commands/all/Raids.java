package io.runescape.content.commands.all;

import java.util.Optional;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

public class Raids extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		if (c.wildLevel > 20) {
			c.sendMessage("@red@You cannot teleport above 20 wilderness.");
			return;
		}
		c.getPA().startTeleport(1245, 3562, 0, "modern", false);
		c.sendMessage("@red@You have been teleported to the chambers of xeric.");
	}
	@Override
	public Optional<String> getDescription() {
		return Optional.of("Teleports you to chambers of xeric.");
	}

}
