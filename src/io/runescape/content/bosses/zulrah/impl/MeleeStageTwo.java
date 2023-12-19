package io.runescape.content.bosses.zulrah.impl;

import io.runescape.content.bosses.zulrah.Zulrah;
import io.runescape.content.bosses.zulrah.ZulrahLocation;
import io.runescape.content.bosses.zulrah.ZulrahStage;
import io.runescape.model.CombatType;
import io.runescape.model.cycleevent.CycleEventContainer;
import io.runescape.model.entity.player.Player;

public class MeleeStageTwo extends ZulrahStage {

	public MeleeStageTwo(Zulrah zulrah, Player player) {
		super(zulrah, player);
	}

	@Override
	public void execute(CycleEventContainer container) {
		if (container.getOwner() == null || zulrah == null || zulrah.getNpc() == null || zulrah.getNpc().isDead() || player == null || player.isDead
				|| zulrah.getInstancedZulrah() == null) {
			container.stop();
			return;
		}
		if (zulrah.getNpc().totalAttacks > 1 && zulrah.getNpc().attackTimer == 9 && zulrah.getStage() == 2) {
			player.getZulrahEvent().changeStage(3, CombatType.MAGE, ZulrahLocation.NORTH);
			zulrah.getNpc().totalAttacks = 0;
			zulrah.getNpc().setFacePlayer(true);
			container.stop();
			return;
		}
	}

}
