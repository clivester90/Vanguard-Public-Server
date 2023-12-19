package io.runescape.content.commands.owner;

import io.runescape.Configuration;
import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Doubledrops extends Command {
    @Override
    public void execute(Player player, String commandName, String input) {
        int minutes = Integer.parseInt(input);
        if (minutes == 0) {
            Configuration.DOUBLE_DROPS_TIMER = 0;
            player.sendMessage("Double drops have ended.");
            return;
        }

        Configuration.DOUBLE_DROPS_TIMER = Misc.toCycles(minutes, TimeUnit.MINUTES);
        //Wogw.sendActivateMessage("double drops");
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.of("Turn on double drops for x minutes, ::doubledrops 60 (60 minutes).");
    }
}
