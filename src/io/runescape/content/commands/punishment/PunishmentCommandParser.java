package io.runescape.content.commands.punishment;

import io.runescape.model.entity.player.Player;

public interface PunishmentCommandParser {

    String name();

    void add(Player staff, PunishmentCommandArgs args);

    void remove(Player staff, PunishmentCommandArgs args);

    String getFormat(String commandName);
}
