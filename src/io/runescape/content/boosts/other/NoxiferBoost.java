package io.runescape.content.boosts.other;

import io.runescape.content.hespori.Hespori;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

public class NoxiferBoost extends GenericBoost {
    @Override
    public String getDescription() {
        return "x2 Slayer Points (" + Misc.cyclesToDottedTime((int) Hespori.NOXIFER_TIMER) + ")";
    }

    @Override
    public boolean applied(Player player) {
        return Hespori.NOXIFER_TIMER > 0;
    }
}
