package io.runescape.content.combat.effects.damageeffect.impl.bolts;

import io.runescape.content.combat.Damage;
import io.runescape.content.combat.effects.damageeffect.DamageBoostingEffect;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.npc.NPC;
import io.runescape.model.entity.player.Player;

public class RubyBoltSpecial implements DamageBoostingEffect {

    @Override
    public void execute(Player attacker, Player defender, Damage damage) {

    }

    @Override
    public void execute(Player attacker, NPC defender, Damage damage) {
        if (defender.getDefinition().getName() == null) {
            return;
        }
    }

    @Override
    public boolean isExecutable(Player p) {
        if (p.playerEquipment[Player.playerArrows] != 9242) {
            return false;
        }
        double chance = Math.random();
        if (p.npcAttackingIndex > 0) {
            if (chance <= 0.066)
                p.rubyBoltSpecial = true;
        }
        if (p.playerAttackingIndex > 0) {
            if (chance <= 0.121)
                p.rubyBoltSpecial = true;
        }


        return p.rubyBoltSpecial;
    }

    @Override
    public double getMaxHitBoost(Player attacker, Entity defender) {
        return 0;
    }

}
