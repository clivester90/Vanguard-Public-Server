package io.runescape.content.boosts.other;

import io.runescape.content.wogw.Wogw;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

public class WogwDropBoost extends GenericBoost {
    @Override
    public String getDescription() {
        return "+20% Drop Rate (" + Misc.cyclesToDottedTime((int) Wogw.DOUBLE_DROPS_TIMER) + ")";
    }

    @Override
    public boolean applied(Player player) {
        return Wogw.DOUBLE_DROPS_TIMER > 0;
    }
}