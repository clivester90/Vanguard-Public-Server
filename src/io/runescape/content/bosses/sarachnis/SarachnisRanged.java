package io.runescape.content.bosses.sarachnis;

import io.runescape.content.combat.Hitmark;
import io.runescape.content.combat.melee.CombatPrayer;
import io.runescape.content.combat.npc.NPCAutoAttack;
import io.runescape.content.combat.npc.NPCAutoAttackBuilder;
import io.runescape.content.combat.npc.NPCCombatAttack;
import io.runescape.content.combat.npc.NPCCombatAttackHit;
import io.runescape.model.*;
import io.runescape.model.entity.player.Boundary;
import io.runescape.model.entity.player.Player;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SarachnisRanged implements Function<SarachnisNpc, NPCAutoAttack> {

    private static ProjectileBase projectile() {
        return new ProjectileBaseBuilder()
                .setSendDelay(2)
                .setSpeed(30)
                .setStartHeight(90)
                .setProjectileId(1686)
                .createProjectileBase();
    }

    @Override
    public NPCAutoAttack apply(SarachnisNpc nightmare) {
        Consumer<NPCCombatAttackHit> onHit = t -> {
            if (t.getCombatHit().missed())
                return;
            if (t.getVictim().isPlayer()) {
                Player player = (Player) t.getVictim();
                if (!CombatPrayer.isPrayerOn(player, CombatPrayer.PROTECT_FROM_RANGED)) {
                    t.getNpc().appendDamage(10, Hitmark.HEAL_PURPLE);
                    t.getNpc().getHealth().increase(20);
                }
            }
        };
        Consumer<NPCCombatAttack> onAttack = t -> nightmare.attackCounter++;
        List<Player> players = NPCAutoAttack.getPlayers(nightmare);
        return new NPCAutoAttackBuilder()
                .setSelectPlayersForMultiAttack(npcCombatAttack -> players.stream().filter(plr -> Boundary.isIn(plr, Boundary.SARACHNIS_LAIR))
                        .collect(Collectors.toList()))
                .setIgnoreProjectileClipping(false)
                .setSelectAutoAttack(attack -> attack.getNpc().distance(attack.getVictim().getPosition()) > 1)
                .setAnimation(new Animation(4410))
                .setCombatType(CombatType.RANGE)
                .setMaxHit(31)
                .setHitDelay(3)
                .setAttackDelay(4)
                .setDistanceRequiredForAttack(24)
                .setMultiAttack(false)
                .setOnHit(onHit)
                .setOnAttack(onAttack)
                .setPrayerProtectionPercentage(npcCombatAttack -> 0.3)
                .setProjectile(projectile())
                .createNPCAutoAttack();
    }
}