package io.runescape.content.commands.all;


import io.runescape.content.commands.Command;
import io.runescape.content.dailytasks.DailyTasks;
import io.runescape.model.entity.player.Player;

import java.util.Optional;


/**
 *
 * @author C.T for runerogue
 * Handles the daily tasks system
 *
 */

public class Daily extends Command {

    @Override
    public void execute(Player c, String commandName, String input) {
        DailyTasks.checkTask(c);
    }

    public Optional<String> getDescription() {
        return Optional.of("Checks the daily task.");
    }

}
