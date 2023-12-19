package io.runescape.content.commands.test;

import java.util.Optional;

import io.runescape.content.ItemSpawner;
import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

public class Spawn extends Command {
    @Override
    public void execute(Player player, String commandName, String input) {
        ItemSpawner.open(player);
    }

    public Optional<String> getDescription() {
        return Optional.of("Opens an interface to spawn items.");
    }
}
