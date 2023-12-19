package io.runescape.content.boosts.other;


import io.runescape.content.hespori.Hespori;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

public class KronosBoost extends GenericBoost {
    @Override
    public String getDescription() {
        return "x2 Raids Keys (" + Misc.cyclesToDottedTime((int) Hespori.KRONOS_TIMER) + ")";
    }

    @Override
    public boolean applied(Player player) {
        return Hespori.KRONOS_TIMER > 0;
    }
}
