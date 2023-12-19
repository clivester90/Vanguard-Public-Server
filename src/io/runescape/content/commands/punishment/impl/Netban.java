package io.runescape.content.commands.punishment.impl;

import io.runescape.Server;
import io.runescape.content.commands.punishment.PunishmentCommand;
import io.runescape.content.commands.punishment.PunishmentCommandArgs;
import io.runescape.content.commands.punishment.PunishmentCommandParser;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.PlayerHandler;
import io.runescape.model.entity.player.Right;
import io.runescape.model.entity.player.save.PlayerAddresses;
import io.runescape.model.entity.player.save.PlayerSaveOffline;
import io.runescape.util.dateandtime.TimeSpan;

import java.io.File;

import static io.runescape.punishments.PunishmentType.*;

public class Netban implements PunishmentCommandParser {
    @Override
    public String name() {
        return "netban";
    }

    @Override
    public void add(Player staff, PunishmentCommandArgs args) {
        Player player = args.getPlayerForDisplayName();
        TimeSpan duration = args.getDuration();
        PlayerAddresses addresses = player.getValidAddresses();

        if (addresses.getIp() != null)
            Server.getPunishments().add(NET_BAN, duration, addresses.getIp());
        if (addresses.getMac() != null)
            Server.getPunishments().add(MAC_BAN, duration, addresses.getMac());
        if (addresses.getUUID() != null)
            Server.getPunishments().add(MAC_BAN, duration, addresses.getUUID());

        PlayerHandler.nonNullStream().filter(it -> addresses.equals(it.getValidAddresses()) && it.getRights().isNot(Right.OWNER)).forEach(Player::forceLogout);
        staff.sendMessage("Banned all known addresses for {}.", player.getDisplayNameFormatted());
    }

    @Override
    public void remove(Player staff, PunishmentCommandArgs args) {
        String loginName = args.index(0).toLowerCase();

        Server.getIoExecutorService().submit(() -> {
            try {
                File file = PlayerSaveOffline.getCharacterFile(loginName);
                if (file == null) {
                    staff.addQueuedAction(plr -> plr.sendMessage("No character file with name {}.", loginName));
                    return;
                }

                PlayerAddresses addresses = PlayerSaveOffline.getAddresses(file);
                PlayerHandler.addQueuedAction(() -> {
                    Server.getPunishments().removeWithMessage(staff, NET_BAN, addresses.getIp());
                    Server.getPunishments().removeWithMessage(staff, MAC_BAN, addresses.getMac());
                    Server.getPunishments().removeWithMessage(staff, MAC_BAN, addresses.getUUID());
                });
            } catch (Exception e) {
                e.printStackTrace();
                staff.addQueuedAction(plr -> plr.sendMessage("Error occurred while removing netban, check console."));
            }
        });
    }

    @Override
    public String getFormat(String commandName) {
        return PunishmentCommand.getFormat(commandName, true);
    }
}
