package io.runescape.content.commands.all;

import io.runescape.content.commands.Command;
import io.runescape.content.referral.EnterReferralDialogue;
import io.runescape.model.entity.player.Player;

public class Refer extends Command {

    @Override
    public void execute(Player c, String commandName, String input) {
        c.start(new EnterReferralDialogue(c));
    }
}
