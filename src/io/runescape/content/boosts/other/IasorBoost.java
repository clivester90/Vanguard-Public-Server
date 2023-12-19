package io.runescape.content.boosts.other;

import io.runescape.content.hespori.Hespori;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

public class IasorBoost extends GenericBoost {
    @Override
    public String getDescription() {
        return "+10% Drop Rate (" + Misc.cyclesToDottedTime((int) Hespori.IASOR_TIMER) + ")";
    }

    @Override
    public boolean applied(Player player) {
        return Hespori.IASOR_TIMER > 0;
    }
}
