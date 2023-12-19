package io.runescape.content.commands.owner;

import io.runescape.content.commands.Command;
import io.runescape.model.Items;
import io.runescape.model.entity.player.Player;
import io.runescape.model.items.ImmutableItem;

/**
 * @author Arthur Behesnilian 1:26 PM
 */
public class Cash extends Command {

    @Override
    public void execute(Player player, String commandName, String input) {
        player.getInventory().addToInventory(new ImmutableItem(Items.COINS, Integer.MAX_VALUE));
        player.sendMessage("You spawn a stack of cash.");
    }

}
