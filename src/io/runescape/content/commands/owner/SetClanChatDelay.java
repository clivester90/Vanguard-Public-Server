package io.runescape.content.commands.owner;

import io.runescape.content.commands.Command;
import io.runescape.model.entity.player.Player;
import io.runescape.model.world.Clan;

/**
 * @author Arthur Behesnilian 1:11 PM
 */
public class SetClanChatDelay extends Command {

    @Override
    public void execute(Player player, String commandName, String input) {
        long newDelay = Integer.parseInt(input);
        Clan.CLAN_CHAT_DELAY = newDelay;
        player.sendMessage("You set the clan chat delay to " + newDelay + " ms.");
    }

}
