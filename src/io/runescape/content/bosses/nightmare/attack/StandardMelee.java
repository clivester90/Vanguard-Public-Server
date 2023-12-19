package io.runescape.content.bosses.nightmare.attack;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import io.runescape.content.bosses.nightmare.Nightmare;
import io.runescape.content.combat.npc.NPCAutoAttack;
import io.runescape.content.combat.npc.NPCAutoAttackBuilder;
import io.runescape.content.combat.npc.NPCCombatAttack;
import io.runescape.model.Animation;
import io.runescape.model.CombatType;
import io.runescape.model.entity.player.Player;

public class StandardMelee implements Function<Nightmare, NPCAutoAttack> {

    @Override
    public NPCAutoAttack apply(Nightmare nightmare) {
        return new NPCAutoAttackBuilder()
                .setAnimation(new Animation(8594))
                .setCombatType(CombatType.MELEE)
                .setMaxHit(35)
                .setHitDelay(2)
                .setAttackDelay(6)
                .setDistanceRequiredForAttack(1)
                .setSelectAutoAttack(new Function<NPCCombatAttack, Boolean>() {
                    @Override
                    public Boolean apply(NPCCombatAttack npcCombatAttack) {
                        return npcCombatAttack.getNpc().distance(npcCombatAttack.getVictim().getPosition()) <= 1;
                    }
                })
                .setMultiAttack(true)
                .setSelectPlayersForMultiAttack(new Function<>() {
                    @Override
                    public List<Player> apply(NPCCombatAttack npcCombatAttack) {
                        return npcCombatAttack.getNpc().getInstance().getPlayers().stream().filter(plr -> plr.distance(npcCombatAttack.getVictim().getPosition()) <= 3)
                                .collect(Collectors.toList());
                    }
                })
                .setPrayerProtectionPercentage(new Function<NPCCombatAttack, Double>() {
                    @Override
                    public Double apply(NPCCombatAttack npcCombatAttack) {
                        return 0.2d;
                    }
                })
                .setMaxHitBonus(new Function<NPCCombatAttack, Double>() {
                    @Override
                    public Double apply(NPCCombatAttack npcCombatAttack) {
                        if (npcCombatAttack.getVictim().isPlayer()) {
                            Player player = npcCombatAttack.getVictim().asPlayer();
                            if (!player.protectingMelee()) {
                                return 0.2d;
                            }
                        }
                        return 0d;
                    }
                })
                .createNPCAutoAttack();
    }
}
