package io.runescape.content.combat.specials.impl;

import io.runescape.content.combat.Damage;
import io.runescape.content.combat.specials.Special;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.player.Player;

public class DragonMace extends Special {

	public DragonMace() {
		super(2.5, 1.25, 1.50, new int[] { 1434 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.startAnimation(1060);
		player.gfx100(251);
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}

}
