package io.runescape.content.commands.all;

import io.runescape.Server;
import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Boundary;
import io.runescape.model.entity.player.Player;

import java.util.Optional;

/**
 * Teleport the player to the mage bank.
 * 
 * @author Emiel
 */
public class Level2 extends Command {

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
		if (!Boundary.isIn(c, Boundary.CATACOMBS)) {
			return;
		}
		if(c.heightLevel == 4) {
			c.sendMessage("You are already at level 2, use the catacombs teleport to go back to 1.");
			return;
		}
		c.getPA().spellTeleport(c.absX, c.absY, 4, false);
		c.sendMessage("@red@You are now on level 2 of catacombs.");

	}

	@Override
	public Optional<String> getDescription() {
		return Optional.of("Teles you to gambling area");
	}

}
