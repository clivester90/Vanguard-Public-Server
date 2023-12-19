package io.runescape.content.commands.admin;

import io.runescape.content.commands.Command;
import io.runescape.content.polls.PollTab;
import io.runescape.model.entity.player.Player;

/**
 * @author Grant_ | www.rune-server.ee/members/grant_ | 2/10/20
 */
public class Endpoll extends Command {

    @Override
    public void execute(Player player, String commandName, String input) {
        PollTab.endPollManually();
        player.sendMessage("You have ended the current poll.");
        PollTab.updateInterface(player);
    }
}
