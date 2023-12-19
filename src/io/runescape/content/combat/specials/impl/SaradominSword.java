package io.runescape.content.combat.specials.impl;

import io.runescape.content.combat.Damage;
import io.runescape.content.combat.Hitmark;
import io.runescape.content.combat.formula.MagicMaxHit;
import io.runescape.content.combat.specials.Special;
import io.runescape.content.skills.Skill;
import io.runescape.model.CombatType;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.PlayerAssistant;
import io.runescape.util.Misc;

public class SaradominSword extends Special {

	public SaradominSword() {
		super(10.0, 1.0, 1.1, new int[] { 11838 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.startAnimation(1132);
		if (damage.getAmount() > 0) {
			int damage2 = MagicMaxHit.magiMaxHit(player) + (1 + Misc.random(15));
			player.getDamageQueue().add(new Damage(target, damage2, 2, player.playerEquipment, Hitmark.HIT, CombatType.MAGE));
			player.getPA().addXpDrop(new PlayerAssistant.XpDrop(damage2, Skill.ATTACK.getId()));
		}
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}

}
