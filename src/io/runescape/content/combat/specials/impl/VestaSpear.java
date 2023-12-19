package io.runescape.content.combat.specials.impl;

import io.runescape.content.combat.Damage;
import io.runescape.content.combat.specials.Special;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.player.Player;

public class VestaSpear extends Special {

	public VestaSpear() {
		super(3.5, 1.0, 1.0, new int[] { 22610 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.gfx0(1240);
		player.startAnimation(8184);
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}

}
