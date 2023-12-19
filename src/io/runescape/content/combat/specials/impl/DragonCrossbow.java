package io.runescape.content.combat.specials.impl;

import io.runescape.content.combat.Damage;
import io.runescape.content.combat.range.RangeData;
import io.runescape.content.combat.specials.Special;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.npc.NPC;
import io.runescape.model.entity.player.Player;

/**
 * 
 * @author Jason MacKeigan
 * @date Apr 4, 2015, 2015, 11:44:39 PM
 */
public class DragonCrossbow extends Special {

	public DragonCrossbow() {
		super(6.0, 1.0, 1.25, new int[] { 21902 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.usingBow = true;
		player.startAnimation(4230);
		if (player.playerAttackingIndex > 0 && target instanceof Player) {
			RangeData.fireProjectilePlayer(player, (Player) target, 50, 70, 27, 43, 31, 37, 10);
		} else if (player.npcAttackingIndex > 0 && target instanceof NPC) {
			RangeData.fireProjectileNpc(player, (NPC) target, 50, 70, 27, 43, 31, 37, 10);
		}
	}

	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}

}