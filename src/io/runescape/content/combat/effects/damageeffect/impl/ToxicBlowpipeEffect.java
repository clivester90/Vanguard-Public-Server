package io.runescape.content.combat.effects.damageeffect.impl;

import java.util.Optional;

import io.runescape.content.combat.Damage;
import io.runescape.content.combat.effects.damageeffect.DamageEffect;
import io.runescape.model.entity.HealthStatus;
import io.runescape.model.entity.npc.NPC;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

public class ToxicBlowpipeEffect implements DamageEffect {

	@Override
	public void execute(Player attacker, Player defender, Damage damage) {
		defender.getHealth().proposeStatus(HealthStatus.VENOM, 6, Optional.of(attacker));
	}

	@Override
	public void execute(Player attacker, NPC defender, Damage damage) {
		defender.getHealth().proposeStatus(HealthStatus.VENOM, 6, Optional.of(attacker));
	}

	@Override
	public boolean isExecutable(Player operator) {
		return operator.getItems().isWearingItem(12926)  || operator.getItems().isWearingItem(24106) && Misc.random(3) == 0;
	}

}
