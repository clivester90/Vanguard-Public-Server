package io.runescape.content.combat.npc;

import io.runescape.model.entity.Entity;
import io.runescape.model.entity.npc.NPC;

public class NPCCombatAttack {

    private final NPC npc;
    private final Entity victim;

    public NPCCombatAttack(NPC npc, Entity victim) {
        this.npc = npc;
        this.victim = victim;
    }

    public NPC getNpc() {
        return npc;
    }

    public Entity getVictim() {
        return victim;
    }

}
