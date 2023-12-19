package io.runescape.content.combat.specials.impl;

import io.runescape.content.combat.Damage;
import io.runescape.content.combat.specials.Special;
import io.runescape.model.Items;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.player.Player;

public class GraniteMaulSpecialAttack extends Special {

	public GraniteMaulSpecialAttack() {
		super(5.0, 1, 1, new int[] {Items.GRANITE_MAUL, Items.GRANITE_MAUL_OR });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {

	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}

}
