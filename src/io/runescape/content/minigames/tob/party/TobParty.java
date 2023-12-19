package io.runescape.content.minigames.tob.party;

import io.runescape.content.party.PartyInterface;
import io.runescape.content.party.PlayerParty;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

public class TobParty extends PlayerParty {

    public static final String TYPE = "ToB Party";

    public TobParty() {
        super(TYPE, 5);
    }

    @Override
    public boolean canJoin(Player invitedBy, Player invited) {
        if (invited.getPA().calculateTotalLevel() < invited.getMode().getTotalLevelForTob()) {
            invited.sendStatement("You need " + Misc.insertCommas(invited.getMode().getTotalLevelForTob()) + " total level to compete.");
            invitedBy.sendMessage(invited.getDisplayNameFormatted() + " doesn't have the requirements to compete.");
            return false;
        }

        return true;
    }

    @Override
    public void onJoin(Player player) {
        PartyInterface.refreshOnJoinOrLeave(player, this);
    }

    @Override
    public void onLeave(Player player) {
        PartyInterface.refreshOnJoinOrLeave(player, this);
    }
}
