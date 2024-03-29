package io.runescape.content.bosses.nightmare.attack;

import java.util.function.Consumer;
import java.util.function.Function;

import io.runescape.content.bosses.nightmare.Nightmare;
import io.runescape.content.combat.npc.NPCAutoAttack;
import io.runescape.content.combat.npc.NPCAutoAttackBuilder;
import io.runescape.content.combat.npc.NPCCombatAttack;
import io.runescape.model.Animation;
import io.runescape.model.CombatType;
import io.runescape.model.Graphic;
import io.runescape.model.ProjectileBase;
import io.runescape.model.ProjectileBaseBuilder;
import io.runescape.model.entity.player.Position;
import io.runescape.util.Misc;

public class StandardMage implements Function<Nightmare, NPCAutoAttack> {

    // In the video I saw random projectiles
    // he had other players hidden
    public static Consumer<NPCCombatAttack> getProjectileThrow(ProjectileBase projectileBase) {
        return npcCombatAttack -> {
            int it = 0;
            for (Position border : npcCombatAttack.getNpc().getBorder()) {
                if (++it % 2 == 0) {
                    Position delta = border.delta(npcCombatAttack.getNpc().getCenterPosition());
                    projectileBase.createTargetedProjectile(npcCombatAttack.getNpc(),
                            border.translate(-delta.getX() + Misc.trueRand(3), -delta.getY() + Misc.trueRand(3)))
                            .send(npcCombatAttack.getNpc().getInstance());
                }
            }
        };
    }

    private static ProjectileBase projectile() {
        return new ProjectileBaseBuilder()
                .setSendDelay(4)
                .setSpeed(15)
                .setStartHeight(90)
                .setProjectileId(1764)
                .createProjectileBase();
    }

    @Override
    public NPCAutoAttack apply(Nightmare nightmare) {
        return new NPCAutoAttackBuilder()
                .setSelectPlayersForMultiAttack(NPCAutoAttack.getDefaultSelectPlayersForAttack())
                .setProjectile(projectile())
                .setPrayerProtectionPercentage(npcCombatAttack -> 0.3)
                //.setOnAttack(getProjectileThrow(projectile()))
                .setEndGraphic(new Graphic(1765, Graphic.GraphicHeight.HIGH))
                .setAnimation(new Animation(8595))
                .setCombatType(CombatType.MAGE)
                .setMaxHit(30)
                .setHitDelay(4)
                .setAttackDelay(6)
                .setDistanceRequiredForAttack(16)
                .setMultiAttack(true)
                .createNPCAutoAttack();
    }
}
