package io.runescape.model;

import io.runescape.model.entity.player.Player;

public interface StringInput {
    void handle(Player player, String string);
}
