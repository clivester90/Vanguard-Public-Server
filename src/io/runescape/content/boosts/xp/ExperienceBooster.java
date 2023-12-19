package io.runescape.content.boosts.xp;

import io.runescape.content.boosts.BoostType;
import io.runescape.content.boosts.Booster;
import io.runescape.content.boosts.PlayerSkillWrapper;

public abstract class ExperienceBooster implements Booster<PlayerSkillWrapper> {

    @Override
    public BoostType getType() {
        return BoostType.EXPERIENCE;
    }

}
