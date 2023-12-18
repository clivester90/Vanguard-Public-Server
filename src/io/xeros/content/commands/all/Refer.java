package io.xeros.content.commands.all;

import io.xeros.content.commands.Command;
import io.xeros.content.referral.EnterReferralDialogue;
import io.xeros.model.entity.player.Player;

public class Refer extends Command {

    @Override
    public void execute(Player c, String commandName, String input) {
        c.start(new EnterReferralDialogue(c));
    }
}
