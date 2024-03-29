package io.runescape.content.commands.test;

import java.util.Optional;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

public class PrintMillis extends Command {
    @Override
    public void execute(Player player, String commandName, String input) {
        player.sendMessage(String.valueOf(System.currentTimeMillis()));
        System.out.println(System.currentTimeMillis());
    }

    public Optional<String> getDescription() {
        return Optional.of("Prints milliseconds to chat and console.");
    }
}
