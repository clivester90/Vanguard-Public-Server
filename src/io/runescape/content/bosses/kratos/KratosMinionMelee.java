package io.runescape.content.bosses.kratos;

import io.runescape.content.combat.npc.NPCAutoAttack;
import io.runescape.content.combat.npc.NPCAutoAttackBuilder;
import io.runescape.model.Animation;
import io.runescape.model.CombatType;

import java.util.function.Function;

public class KratosMinionMelee implements Function<KratosNpc, NPCAutoAttack> {

    @Override
    public NPCAutoAttack apply(KratosNpc nightmare) {
        return new NPCAutoAttackBuilder()
                .setAnimation(new Animation(7018))
                .setCombatType(CombatType.MELEE)
                .setMaxHit(13)
                .setHitDelay(2)
                .setAttackDelay(4)
                .setDistanceRequiredForAttack(1)
                .setPrayerProtectionPercentage(npcCombatAttack -> 0.2d)
                .createNPCAutoAttack();
    }


}