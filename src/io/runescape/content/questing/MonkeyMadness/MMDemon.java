package io.runescape.content.questing.MonkeyMadness;

import io.runescape.model.entity.npc.NPC;
import io.runescape.model.entity.player.Position;

public class MMDemon extends NPC {

    public MMDemon(Position position) {
        super(1443, position);
        getBehaviour().setAggressive(true);
    }
}
