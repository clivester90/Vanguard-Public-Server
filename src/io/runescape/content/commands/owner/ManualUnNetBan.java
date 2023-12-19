package io.runescape.content.commands.owner;

import io.runescape.Server;
import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;
import io.runescape.punishments.PunishmentType;

public class ManualUnNetBan extends Command {
    @Override
    public void execute(Player player, String commandName, String input) {
        Server.getPunishments().removeWithMessage(player, PunishmentType.NET_BAN, input);
        Server.getPunishments().removeWithMessage(player, PunishmentType.MAC_BAN, input);
    }
}
