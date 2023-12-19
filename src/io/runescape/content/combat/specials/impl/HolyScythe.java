package io.runescape.content.combat.specials.impl;

import io.runescape.content.combat.Damage;
import io.runescape.content.combat.core.HitDispatcher;
import io.runescape.content.combat.specials.Special;
import io.runescape.model.CombatType;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.npc.NPC;
import io.runescape.model.entity.player.Player;

public class HolyScythe extends Special {

	public HolyScythe() {
		super(3.0, 3.00, 1.50, new int[] {25736 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		//lighting strike
		player.startAnimation(1203);
		if (target instanceof NPC) {
			((NPC) target).gfx0(281);
		} else if (target instanceof Player) {
			((Player) target).gfx0(281);
		}

	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {
		if (target instanceof NPC) {
			NPC other = (NPC) target;
			if (other != null && player.npcAttackingIndex > 0) {
				if (player.goodDistance(player.getX(), player.getY(), other.getX(), other.getY(), other.getSize() + 2) && other.getSize() > 1) {
					HitDispatcher.getHitEntity(player, target).playerHitEntity(CombatType.MELEE, null);

				}
			}
		}
	}

}
