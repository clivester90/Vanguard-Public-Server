package io.runescape.content.commands.donator;

import java.util.Optional;

import io.runescape.Configuration;
import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.Right;

public class Oz extends Command {

    @Override
    public void execute(Player c, String commandName, String input) {
        if (c.inTrade || c.inDuel || c.getPosition().inWild()) {
            return;
        }
        if (c.getPosition().inClanWars() || c.getPosition().inClanWarsSafe()) {
            c.sendMessage("@cr10@This player is currently at the pk district.");
            return;
        }
        if (c.amDonated <= 999 && !c.getRights().isOrInherits(Right.ADMINISTRATOR)) {
            c.sendMessage("@red@You need legendary donator to do this command");
            return;
        }
        c.getPA().startTeleport(Configuration.ONYX_ZONE_TELEPORT, "modern", false);
    }

    @Override
    public Optional<String> getDescription() {
        return Optional.of("Teleports you to legendary zone.");
    }

}


