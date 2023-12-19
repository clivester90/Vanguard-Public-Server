package io.runescape.content.bosses.nightmare.party;

import io.runescape.content.bosses.nightmare.NightmareConstants;
import io.runescape.content.party.PartyFormAreaController;
import io.runescape.content.party.PlayerParty;
import io.runescape.model.entity.player.Boundary;

import java.util.Set;

public class NightmarePartyFormAreaController extends PartyFormAreaController {

    @Override
    public String getKey() {
        return NightmareParty.TYPE;
    }

    @Override
    public Set<Boundary> getBoundaries() {
        return Set.of(NightmareConstants.LOBBY_BOUNDARY);
    }

    @Override
    public PlayerParty createParty() {
        return new NightmareParty();
    }
}
