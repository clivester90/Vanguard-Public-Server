package io.runescape.content.combat.specials.impl;

import io.runescape.content.combat.Damage;
import io.runescape.content.combat.specials.Special;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.player.Player;

public class DragonLongsword extends Special {

	public DragonLongsword() {
		super(2.5, 1.0, 1.25, new int[] { 1305 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.gfx100(248);
		player.startAnimation(1058);
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}
}