package io.runescape.content.commands.test;

import java.util.Optional;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

public class TestDonationRewards extends Command {
    @Override
    public void execute(Player player, String commandName, String input) {
        int amount = 25;
        try {
            if (input.length() > 0)
                amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            player.sendMessage("Enter a valid number.");
            return;
        }
        player.getDonationRewards().increaseDonationAmount(amount);
    }

    public Optional<String> getDescription() {
        return Optional.of("Adds $$$ to your donated amount.");
    }
}
