package io.runescape.content.bosses.grotesqueguardians;

import io.runescape.content.combat.npc.NPCAutoAttack;
import io.runescape.content.combat.npc.NPCAutoAttackBuilder;
import io.runescape.content.combat.npc.NPCCombatAttack;
import io.runescape.model.Animation;
import io.runescape.model.CombatType;
import io.runescape.model.ProjectileBase;
import io.runescape.model.ProjectileBaseBuilder;

import java.util.function.Function;

public class DawnRanged implements Function<GrotesqueGuardianNpc, NPCAutoAttack> {

    private static ProjectileBase projectile() {
        return new ProjectileBaseBuilder()
                .setSendDelay(2)
                .setSpeed(30)
                .setStartHeight(90)
                .setProjectileId(1444)
                .createProjectileBase();
    }

    @Override
    public NPCAutoAttack apply(GrotesqueGuardianNpc dawn) {
        return new NPCAutoAttackBuilder()
                .setAnimation(new Animation(7770))
                .setCombatType(CombatType.RANGE)
                .setMaxHit(15)
                .setHitDelay(2)
                .setAttackDelay(6)
                .setDistanceRequiredForAttack(24)
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