package io.runescape.content.keyboard_actions;

import io.runescape.model.entity.player.Player;

@FunctionalInterface
public interface KeyboardStrategy {
    void execute(Player player);
}
