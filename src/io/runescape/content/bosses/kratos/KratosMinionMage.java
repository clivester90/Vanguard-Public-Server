package io.runescape.content.bosses.kratos;

import io.runescape.content.combat.npc.NPCAutoAttack;
import io.runescape.content.combat.npc.NPCAutoAttackBuilder;
import io.runescape.content.combat.npc.NPCCombatAttack;
import io.runescape.model.Animation;
import io.runescape.model.CombatType;
import io.runescape.model.ProjectileBase;
import io.runescape.model.ProjectileBaseBuilder;

import java.util.function.Function;

public class KratosMinionMage implements Function<KratosNpc, NPCAutoAttack> {

    private static ProjectileBase projectile() {
        return new ProjectileBaseBuilder()
                .setSendDelay(2)
                .setSpeed(25)
                .setStartHeight(40)
                .setProjectileId(1682)
                .createProjectileBase();
    }

    @Override
    public NPCAutoAttack apply(KratosNpc nightmare) {
        return new NPCAutoAttackBuilder()
                .setSelectPlayersForMultiAttack(NPCAutoAttack.getDefaultSelectPlayersForAttack())
                .setAnimation(new Animation(7021))
                .setCombatType(CombatType.MAGE)
                .setMaxHit(15)
                .setHitDelay(3)
                .setAttackDelay(4)
                .setDistanceRequiredForAttack(44)
                .setMultiAttack(false)
                .setPrayerProtectionPercentage(new Function<NPCCombatAttack, Double>() {
                    @Override
                    public Double apply(NPCCombatAttack npcCombatAttack) {
                        return 0.3;
                    }
                })
                .setProjectile(projectile())
                .createNPCAutoAttack();
    }
}
