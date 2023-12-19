package io.runescape.util.logging.player;

import io.runescape.model.SlottedItem;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.Position;
import io.runescape.util.Misc;
import io.runescape.util.logging.PlayerLog;

import java.util.List;
import java.util.Set;

public class DeathItemsHeld extends PlayerLog {

    private final List<SlottedItem> inventory;
    private final List<SlottedItem> equipment;
    private final Position position;

    public DeathItemsHeld(Player player, List<SlottedItem> inventory, List<SlottedItem> equipment) {
        super(player);
        this.inventory = inventory;
        this.equipment = equipment;
        this.position = player.getPosition();
    }

    @Override
    public Set<String> getLogFileNames() {
        return Set.of("unsafe_death");
    }

    @Override
    public String getLoggedMessage() {
        return Misc.replaceBracketsWithArguments("{} held on death inventory={}, equipment={}", position, inventory, equipment);
    }
}
