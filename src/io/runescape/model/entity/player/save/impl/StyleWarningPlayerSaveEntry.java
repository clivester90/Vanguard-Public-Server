package io.runescape.model.entity.player.save.impl;

import java.util.List;

import com.google.common.collect.Lists;
import io.runescape.content.combat.core.StyleWarning;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.save.PlayerSaveEntry;

public class StyleWarningPlayerSaveEntry implements PlayerSaveEntry {
    @Override
    public List<String> getKeys(Player player) {
        return Lists.newArrayList("style_warning_toggle");
    }

    @Override
    public boolean decode(Player player, String key, String value) {
        player.getAttributes().setBoolean(StyleWarning.STYLE_WARNING_TOGGLE_KEY, Boolean.parseBoolean(value));
        return true;
    }

    @Override
    public String encode(Player player, String key) {
        return String.valueOf(player.getAttributes().getBoolean(StyleWarning.STYLE_WARNING_TOGGLE_KEY));
    }

    @Override
    public void login(Player player) {}
}
