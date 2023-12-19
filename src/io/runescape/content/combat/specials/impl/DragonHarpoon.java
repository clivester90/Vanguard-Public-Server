package io.runescape.content.combat.specials.impl;

import io.runescape.content.combat.Damage;
import io.runescape.content.combat.specials.Special;
import io.runescape.content.skills.Skill;
import io.runescape.model.entity.Entity;
import io.runescape.model.entity.player.Player;

public class DragonHarpoon extends Special {
	public DragonHarpoon() {
		super(10.0, 1.0, 1.0, new int[] { 21028 });
	}

	@Override
	public void activate(Player player, Entity target, Damage damage) {
		player.forcedChat("Here fishy fishies!");
		player.gfx0(246);
		player.playerLevel[Skill.FISHING.getId()] = player.getLevelForXP(player.playerXP[Skill.FISHING.getId()]) + 3;
		player.getPA().refreshSkill(Skill.FISHING.getId());
	}


	@Override
	public void hit(Player player, Entity target, Damage damage) {

	}
}
