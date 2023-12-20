package io.runescape.content.commands.owner;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;
import io.runescape.net.ChannelHandler;

public class Connections extends Command {
    @Override
    public void execute(Player player, String commandName, String input) {
       player.sendMessage("There are currently {} active connections.", String.valueOf(ChannelHandler.getActiveConnections()));
    }
}
