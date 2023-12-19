package io.runescape.content.commands.all;

import java.util.Optional;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.npc.drops.DropManager;
import io.runescape.model.entity.player.Player;

public class Droprate extends Command {

    @Override
    public void execute(Player player, String commandName, String input) {
        player.forcedChat("My drop rate bonus is : " + DropManager.getModifier1(player) + "%.");
    }
	@Override
	public Optional<String> getDescription() {
		return Optional.of("Shows drop rate bonus");
	}
}


