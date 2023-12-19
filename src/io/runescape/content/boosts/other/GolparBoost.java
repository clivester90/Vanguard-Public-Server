package io.runescape.content.boosts.other;


import io.runescape.content.hespori.Hespori;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

public class GolparBoost extends GenericBoost {
    @Override
    public String getDescription() {
        return "x2 Bonus Loot (" + Misc.cyclesToDottedTime((int) Hespori.GOLPAR_TIMER) + ")";
    }

    @Override
    public boolean applied(Player player) {
        return Hespori.GOLPAR_TIMER > 0;
    }
}
