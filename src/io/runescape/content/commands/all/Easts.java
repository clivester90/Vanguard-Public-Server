package io.runescape.content.commands.all;

import java.util.Optional;

import io.runescape.Server;
import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

/**
 * Teleport the player to easts.
 * 
 * @author Emiel
 */
public class Easts extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		if (Server.getMultiplayerSessionListener().inAnySession(c)) {
			return;
		}
		if (c.getPosition().inClanWars() || c.getPosition().inClanWarsSafe()) {
			c.sendMessage("@cr10@You can not teleport from here, speak to the doomsayer to leave.");
			return;
		}
		if (c.getPosition().inWild()) {
			return;
		}
		c.getPA().spellTeleport(3353, 3684, 0, false);
	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Teleports you to this PK hotspot");
	}

}
