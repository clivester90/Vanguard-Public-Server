package io.runescape.content.commands.moderator;

import java.util.Optional;

import io.runescape.content.combat.pvp.Killstreak;
import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.PlayerHandler;

/**
 * Shows the killstreaks of a given player.
 * 
 * @author Emiel
 */
public class Ks extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		Optional<Player> optionalPlayer = PlayerHandler.getOptionalPlayerByDisplayName(input);
		optionalPlayer.ifPresent(player -> {
			Player c2=player;
			c.sendMessage("Hunter killstreak of "+ c2.getDisplayName() +" : "+c2.getKillstreak().getAmount(Killstreak.Type.HUNTER));
			c.sendMessage("Rogue killstreak of "+ c2.getDisplayName() +" : "+c2.getKillstreak().getAmount(Killstreak.Type.ROGUE));
		});
	}
}
