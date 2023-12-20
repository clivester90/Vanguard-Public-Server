package io.runescape.content.bosses.grotesqueguardians;

import io.runescape.content.combat.npc.NPCAutoAttack;
import io.runescape.content.combat.npc.NPCAutoAttackBuilder;
import io.runescape.model.Animation;
import io.runescape.model.CombatType;

import java.util.function.Function;

public class DawnMelee implements Function<GrotesqueGuardianNpc, NPCAutoAttack> {

    @Override
    public NPCAutoAttack apply(GrotesqueGuardianNpc nightmare) {
        return new NPCAutoAttackBuilder()
                .setAnimation(new Animation(7769))
                .setCombatType(CombatType.MELEE)
                .setMaxHit(15)
                .setHitDelay(2)
                .setAttackDelay(6)
                .setDistanceRequiredForAttack(1)
                .setSelectAutoAttack(npcCombatAttack -> npcCombatAttack.getNpc().distance(npcCombatAttack.getVictim().getPosition()) <= 1)
                .setPrayerProtectionPercentage(npcCombatAttack -> 0.2d)
                .createNPCAutoAttack();
    }
}
