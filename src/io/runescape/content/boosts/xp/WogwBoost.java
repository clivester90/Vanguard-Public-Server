package io.runescape.content.boosts.xp;

import io.runescape.content.boosts.PlayerSkillWrapper;
import io.runescape.content.wogw.Wogw;
import io.runescape.util.Misc;

public class WogwBoost extends ExperienceBooster {
    @Override
    public String getDescription() {
        return "+50% XP Rate (" + Misc.cyclesToDottedTime((int) Wogw.EXPERIENCE_TIMER) + ")";
    }

    @Override
    public boolean applied(PlayerSkillWrapper playerSkillWrapper) {
        return Wogw.EXPERIENCE_TIMER > 0;
    }
}
