package io.runescape.content.commands.helper;

import io.runescape.content.commands.Command;
import io.runescape.content.commands.punishment.PunishmentCommand;
import io.runescape.model.entity.player.Player;

public class Mute extends Command {
	@Override
	public void execute(Player c, String commandName, String input) {
		new PunishmentCommand(commandName, input).parse(c);
	}

	@Override
	public String getFormat() {
		return PunishmentCommand.getFormat(getCommand());
	}
}
