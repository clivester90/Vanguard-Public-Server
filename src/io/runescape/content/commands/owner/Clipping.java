package io.runescape.content.commands.owner;

import io.runescape.content.commands.Command;
import io.runescape.model.collisionmap.RegionProvider;
import io.runescape.model.entity.player.Player;

/**
 * @author Arthur Behesnilian 7:14 PM
 */
public class Clipping extends Command {

    @Override
    public void execute(Player player, String commandName, String input) {
        int clipping = player.getRegionProvider().getClipping(player.getX(), player.getY(), player.getHeight()) - RegionProvider.NPC_TILE_FLAG;
        player.sendMessage("Clipping for tile: " + player.getPosition() + "="+ clipping);
    }
}