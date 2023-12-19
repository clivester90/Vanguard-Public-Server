package io.runescape.content.commands.admin;

import io.runescape.content.commands.Command;
import io.runescape.content.commands.punishment.PunishmentCommand;
import io.runescape.model.entity.player.Player;

import java.util.Optional;

public class UnNetMute extends Command {

	@Override
	public void execute(Player c, String commandName, String input) {
		new PunishmentCommand(commandName, input).parse(c);
	}

	@Override
	public String getFormat() {
		return PunishmentCommand.getFormat(getCommand());
	}

	public Optional<String> getDescription() {
		return Optional.of("Remove net mute for online player");
	}

}
