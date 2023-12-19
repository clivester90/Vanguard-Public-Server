package io.runescape.content.boosts.other;

import io.runescape.content.boosts.BoostType;
import io.runescape.content.boosts.Booster;
import io.runescape.model.entity.player.Player;

public abstract class GenericBoost implements Booster<Player> {
    @Override
    public BoostType getType() {
        return BoostType.GENERIC;
    }
}
