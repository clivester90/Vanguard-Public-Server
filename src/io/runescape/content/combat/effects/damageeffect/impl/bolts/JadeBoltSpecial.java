package io.runescape.content.combat.effects.damageeffect.impl.bolts;

import io.runescape.content.combat.Damage;
import io.runescape.content.combat.effects.damageeffect.DamageBoostingEffect;
import io.runescape.content.combat.range.RangeData;
import io.runescape.model.Items;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.npc.NPC;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

public class JadeBoltSpecial implements DamageBoostingEffect {

	@Override
	public void execute(Player attacker, Player defender, Damage damage) {
		int change = Misc.random(damage.getAmount());
		damage.setAmount(change);
		RangeData.createCombatGraphic(defender, 755, false);
		defender.freezeTimer = 33;
		// Find knocking down emote
	}

	@Override
	public void execute(Player attacker, NPC defender, Damage damage) {
		if (defender.getDefinition().getName() == null) {
			return;
		}
		RangeData.createCombatGraphic(defender, 755, false);
		defender.freezeTimer = 33;
	}

	@Override
	public boolean isExecutable(Player operator) {
		return RangeData.boltSpecialAvailable(operator, Items.JADE_BOLTS_E, Items.JADE_DRAGON_BOLTS_E);
	}

	@Override
	public double getMaxHitBoost(Player attacker, Entity defender) {
		return 0;
	}

}