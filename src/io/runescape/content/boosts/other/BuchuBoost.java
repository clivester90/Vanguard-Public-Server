package io.runescape.content.boosts.other;


import io.runescape.content.hespori.Hespori;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

public class BuchuBoost extends GenericBoost {
    @Override
    public String getDescription() {
        return "x2 Boss Points (" + Misc.cyclesToDottedTime((int) Hespori.BUCHU_TIMER) + ")";
    }

    @Override
    public boolean applied(Player player) {
        return Hespori.BUCHU_TIMER > 0;
    }
}
