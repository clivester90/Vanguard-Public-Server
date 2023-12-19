package io.runescape.content.combat.effects.damageeffect;

import io.runescape.model.entity.Entity;
import io.runescape.model.entity.player.Player;

public interface DamageBoostingEffect extends DamageEffect {

    double getMaxHitBoost(Player attacker, Entity defender);

}
