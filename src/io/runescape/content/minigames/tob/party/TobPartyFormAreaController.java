package io.runescape.content.minigames.tob.party;

import io.runescape.content.minigames.tob.TobConstants;
import io.runescape.content.party.PartyFormAreaController;
import io.runescape.content.party.PlayerParty;
import io.runescape.model.entity.player.Boundary;

import java.util.Set;

public class TobPartyFormAreaController extends PartyFormAreaController {

    @Override
    public String getKey() {
        return TobParty.TYPE;
    }

    @Override
    public Set<Boundary> getBoundaries() {
        return Set.of(TobConstants.TOB_LOBBY);
    }

    @Override
    public PlayerParty createParty() {
        return new TobParty();
    }
}
