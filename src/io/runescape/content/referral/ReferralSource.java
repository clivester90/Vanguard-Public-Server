package io.runescape.content.referral;

import io.runescape.util.Misc;

public enum ReferralSource {
    RSPS_LIST,
    RUNE_LOCUS,
    TOP_G,
    DISCORD,
    YOUTUBE,
    RUNE_SERVER,
    ;

    @Override
    public String toString() {
        return Misc.formatPlayerName(name().toLowerCase().replaceAll("_", "-"));
    }
}
