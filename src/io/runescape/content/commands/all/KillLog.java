package io.runescape.content.commands.all;

import java.util.Optional;

import io.runescape.content.combat.stats.MonsterKillLog;
import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;

public class KillLog extends Command {
    @Override
    public void execute(Player player, String commandName, String input) {
        MonsterKillLog.openInterface(player);
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.of("Opens the kill log.");
    }

}
