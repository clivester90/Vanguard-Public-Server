package io.runescape.model;

import io.runescape.model.entity.player.Player;

public interface AmountInput {
    void handle(Player player, int amount);
}
