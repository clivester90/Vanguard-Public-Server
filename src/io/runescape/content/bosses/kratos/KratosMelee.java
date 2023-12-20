package io.runescape.content.bosses.kratos;

import io.runescape.content.combat.Hitmark;
import io.runescape.content.combat.melee.CombatPrayer;
import io.runescape.content.combat.npc.NPCAutoAttack;
import io.runescape.content.combat.npc.NPCAutoAttackBuilder;
import io.runescape.content.combat.npc.NPCCombatAttack;
import io.runescape.content.combat.npc.NPCCombatAttackHit;
import io.runescape.model.Animation;
import io.runescape.model.CombatType;
import io.runescape.model.entity.player.Player;

import java.util.function.Consumer;
import java.util.function.Function;

public class KratosMelee implements Function<KratosNpc, NPCAutoAttack> {

    @Override
    public NPCAutoAttack apply(KratosNpc nightmare) {
        Consumer<NPCCombatAttackHit> onDamage = t -> {
            if (t.getCombatHit().missed())
                return;
            if (t.getVictim().isPlayer()) {
                Player player = (Player) t.getVictim();
                if (!CombatPrayer.isPrayerOn(player, CombatPrayer.PROTECT_FROM_MELEE)) {
                    t.getNpc().appendDamage(5, Hitmark.HEAL_PURPLE);
                    t.getNpc().getHealth().increase(10);
                }
            }
        };
        Consumer<NPCCombatAttack> onAttack = t -> nightmare.attackCounter++;
        return new NPCAutoAttackBuilder()
                .setAnimation(new Animation(7018))
                .setCombatType(CombatType.MELEE)
                .setSelectAutoAttack(attack -> attack.getNpc().distance(attack.getVictim().getPosition()) == 1)
                .setMaxHit(60)
                .setHitDelay(2)
                .setAttackDelay(4)
                .setDistanceRequiredForAttack(1)
                .setOnHit(onDamage)
                .setOnAttack(onAttack)
                .setSelectAutoAttack(npcCombatAttack -> npcCombatAttack.getNpc().distance(npcCombatAttack.getVictim().getPosition()) <= 1)
                .setPrayerProtectionPercentage(npcCombatAttack -> 0.2d)
                .createNPCAutoAttack();
    }
}