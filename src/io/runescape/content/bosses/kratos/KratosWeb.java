package io.runescape.content.bosses.kratos;

import io.runescape.Server;
import io.runescape.content.combat.npc.NPCAutoAttack;
import io.runescape.content.combat.npc.NPCAutoAttackBuilder;
import io.runescape.content.combat.npc.NPCCombatAttack;
import io.runescape.content.combat.npc.NPCCombatAttackHit;
import io.runescape.model.Animation;
import io.runescape.model.CombatType;
import io.runescape.model.ProjectileBase;
import io.runescape.model.ProjectileBaseBuilder;
import io.runescape.model.entity.EntityReference;
import io.runescape.model.entity.player.Boundary;
import io.runescape.model.entity.player.ClientGameTimer;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.Position;
import io.runescape.model.world.objects.GlobalObject;
import io.runescape.util.Misc;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class KratosWeb implements Function<KratosNpc, NPCAutoAttack> {

    private static Position[] CORNER_AREAS = {
            new Position(3032,5224),//se corner
            new Position(3020,5232),//sw corner
            new Position(3022,5238),//nw corner
            new Position(3032,5236)//ne corner
    };

    private static ProjectileBase projectile() {
        return new ProjectileBaseBuilder()
                .setSendDelay(1)
                .setSpeed(75)
                .setCurve(0)
                .setStartHeight(75)
                .setEndHeight(50)
                .setProjectileId(1687)
                .createProjectileBase();
    }

    @Override
    public NPCAutoAttack apply(KratosNpc nightmare) {
        Consumer<NPCCombatAttackHit> freeze = t -> {
            if (t.getCombatHit().missed())
                return;
            if (!t.getVictim().isFreezable())
                return;
            t.getVictim().attackTimer += 6;
            t.getVictim().freezeTimer = 6;
            t.getVictim().resetWalkingQueue();
            t.getVictim().frozenBy = EntityReference.getReference(t.getNpc());
            if (t.getVictim().isPlayer()) {
                Player p = (Player) t.getVictim();
                ((Player) t.getVictim()).sendMessage("@blu@Kratos shoots a very sticky web at your feet!");
                ((Player) t.getVictim()).getPA().sendGameTimer(ClientGameTimer.FREEZE, TimeUnit.MILLISECONDS, 600 * 6);
                GlobalObject ground_web = new GlobalObject(34895, p.getX(), p.getY(), p.heightLevel, 2, 10, 5, -1);
                Server.getGlobalObjects().add(ground_web);
            }
            if (nightmare.nextWalk == null) {
                nightmare.nextWalk = CORNER_AREAS[Misc.random(CORNER_AREAS.length - 1)];
            }
            nightmare.resetAttack();
            nightmare.getBehaviour().setAggressive(false);
            nightmare.randomWalk = false;
        };
        Consumer<NPCCombatAttack> hiss = t -> {
            Player p = (Player) t.getVictim();
            t.getNpc().forceChat("Its timeee you dieee "+p.getLoginName()+"!!!!");
            nightmare.attackCounter = 0;
        };
        List<Player> players = NPCAutoAttack.getPlayers(nightmare);
        return new NPCAutoAttackBuilder()
                .setSelectPlayersForMultiAttack(new Function<>() {
                    @Override
                    public List<Player> apply(NPCCombatAttack npcCombatAttack) {
                        return players.stream().filter(plr -> Boundary.isIn(plr, Boundary.KRATOS_AREA))
                                .collect(Collectors.toList());
                    }
                })
                .setSelectAutoAttack(new Function<NPCCombatAttack, Boolean>() {
                    @Override
                    public Boolean apply(NPCCombatAttack npcCombatAttack) {
                        return nightmare.attackCounter >= 4;
                    }
                })
                .setAnimation(new Animation(7021))
                .setCombatType(CombatType.SPECIAL)
                .setAttackDelay(4)
                .setHitDelay(3)
                .setDistanceRequiredForAttack(34)
                .setMultiAttack(true)
                .setOnAttack(
                        hiss
                )
                .setOnHit(freeze
                )
                .setProjectile(projectile())
                .createNPCAutoAttack();
    }
}