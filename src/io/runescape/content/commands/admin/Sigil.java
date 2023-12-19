package io.runescape.content.commands.admin;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

/**
 * LOOK MOM! I'M A SIGIL!
 * 
 * @author Emiel
 */
public class Sigil extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		if (c.isNpc && c.npcId2 == 335) {
			c.isNpc = false;
		} else {
			c.npcId2 = 335;
			c.isNpc = true;
		}
		c.setUpdateRequired(true);
		c.appearanceUpdateRequired = true;
	}
}