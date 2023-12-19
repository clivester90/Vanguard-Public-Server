package io.runescape.content.commands.all;

import io.runescape.FoxVote;
import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

import java.util.Optional;

public class Claim extends Command {

    @Override
    public void execute(Player c, String commandName, String input) {
        if (System.currentTimeMillis() - c.lastVoteNew < 6000) {
            c.sendMessage("Please wait a few seconds between claiming votes.");
            return;
        }
        new java.lang.Thread(new FoxVote(c)).run();
        c.lastVoteNew = System.currentTimeMillis();
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.of("Checks if you have unclaimed votes.");
    }

}
