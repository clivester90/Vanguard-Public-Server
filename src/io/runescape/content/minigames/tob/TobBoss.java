package io.runescape.content.minigames.tob;

import io.runescape.content.instances.InstancedArea;
import io.runescape.content.minigames.tob.instance.TobInstance;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.npc.NPC;
import io.runescape.model.entity.player.Position;

public class TobBoss extends NPC {

    public TobBoss(int npcId, Position position, InstancedArea instancedArea) {
        super(npcId, position);
        instancedArea.add(this);
        getBehaviour().setRespawn(false);
        getBehaviour().setAggressive(true);
    }

    public void onDeath() {
        Entity killer = calculateKiller();
        if (getInstance() != null) {
            getInstance().getPlayers().forEach(plr -> {
                int points = 4;
                if (killer != null && killer.equals(plr)) {
                    points += 2;
                }
                ((TobInstance) plr.getInstance()).getMvpPoints().award(plr, points);
                ((TobInstance) plr.getInstance()).getFoodRewards().award(plr, points);
            });
        }
    }

}
