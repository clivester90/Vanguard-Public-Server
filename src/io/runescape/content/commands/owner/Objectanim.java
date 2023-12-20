package io.runescape.content.commands.owner;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;
import io.runescape.model.world.objects.GlobalObject;

/**
 * Spawn a specific Object.
 * 
 * @author Emiel
 *
 */
public class Objectanim extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		String[] args = input.split(" ");
		if (args.length == 2) {
			c.getPA().object(new GlobalObject(Integer.parseInt(args[0]), c.absX, c.absY, c.getHeight(), 0, 10));
			c.getPA().sendPlayerObjectAnimation(c.absX, c.absY, Integer.parseInt(args[1]), 10, 0);
			c.sendMessage(Integer.parseInt(args[0]) + " " + Integer.parseInt(args[1]));
		} else if (args.length == 1) {
			c.getPA().sendPlayerObjectAnimation(c.absX, c.absY, Integer.parseInt(args[0]), 10, 0);
			c.sendMessage(String.valueOf(Integer.parseInt(args[0])));
		}
	}
}
