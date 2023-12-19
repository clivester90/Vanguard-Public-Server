package io.runescape.content.boosts.other;


import io.runescape.content.hespori.Hespori;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

public class CelastrusBoost extends GenericBoost {
    @Override
    public String getDescription() {
        return "x2 Brimstone Keys (" + Misc.cyclesToDottedTime((int) Hespori.CELASTRUS_TIMER) + ")";
    }

    @Override
    public boolean applied(Player player) {
        return Hespori.CELASTRUS_TIMER > 0;
    }
}
