package io.runescape.content.bosses.zulrah;

import io.runescape.model.cycleevent.CycleEvent;
import io.runescape.model.entity.player.Player;

public abstract class ZulrahStage extends CycleEvent {

	protected Zulrah zulrah;

	protected Player player;

	public ZulrahStage(Zulrah zulrah, Player player) {
		this.zulrah = zulrah;
		this.player = player;
	}

}
