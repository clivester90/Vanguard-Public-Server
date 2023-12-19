package io.runescape.content.combat.specials.impl;

import io.runescape.content.combat.Damage;
import io.runescape.content.combat.specials.Special;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.player.Player;

public class VestaLongsword extends Special {

	public VestaLongsword() {
		super(2.5, 1.0, 0.20, new int[] { 22613 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.startAnimation(7515);
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}

}
