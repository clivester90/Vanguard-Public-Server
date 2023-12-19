package io.runescape.util.logging.player;

import java.util.Set;

import io.runescape.model.entity.player.Player;
import io.runescape.util.logging.PlayerLog;

public class ClanChatLog extends PlayerLog {

    private final String message;
    private final String channel;

    public ClanChatLog(Player player, String message, String channel) {
        super(player);
        this.message = message;
        this.channel = channel;
    }

    @Override
    public Set<String> getLogFileNames() {
        return Set.of("chat_clan", "chat_all");
    }

    @Override
    public String getLoggedMessage() {
        return "Channel=" + channel + ", message=" + message;
    }
}
