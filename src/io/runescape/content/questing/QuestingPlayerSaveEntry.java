package io.runescape.content.questing;

import java.util.List;
import java.util.stream.Collectors;

import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.save.PlayerSaveEntry;

public class QuestingPlayerSaveEntry implements PlayerSaveEntry {
    @Override
    public List<String> getKeys(Player player) {
        return player.getQuesting().getQuestList().stream().map(Quest::getName).collect(Collectors.toList());
    }

    @Override
    public boolean decode(Player player, String key, String value) {
        player.getQuesting().updateQuestProgressOnLoad(key, Integer.parseInt(value));
        return true;
    }

    @Override
    public String encode(Player player, String key) {
        for (Quest quest : player.getQuesting().getQuestList()) {
            if (quest.getName().equalsIgnoreCase(key)) {
                return String.valueOf(quest.getStage());
            }
        }
        System.err.println("Can't determine encoding for quest: " + key);
        return "0";
    }

    @Override
    public void login(Player player) {

    }
}
