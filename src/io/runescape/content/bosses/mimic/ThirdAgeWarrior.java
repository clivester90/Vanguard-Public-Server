package io.runescape.content.bosses.mimic;

import io.runescape.content.combat.npc.NPCAutoAttack;
import io.runescape.content.combat.npc.NPCAutoAttackBuilder;
import io.runescape.model.Animation;
import io.runescape.model.CombatType;

import java.util.function.Function;

public class ThirdAgeWarrior implements Function<MimicNpc, NPCAutoAttack> {

    @Override
    public NPCAutoAttack apply(MimicNpc nightmare) {
        return new NPCAutoAttackBuilder()
                .setAnimation(new Animation(390))
                .setCombatType(CombatType.MELEE)
                .setMaxHit(18)
                .setHitDelay(2)
                .setAttackDelay(4)
                .setDistanceRequiredForAttack(1)
                .setPrayerProtectionPercentage(npcCombatAttack -> 0.2d)
                .createNPCAutoAttack();
    }
}