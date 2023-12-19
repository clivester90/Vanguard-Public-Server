package io.runescape.content.commands.owner;

import io.runescape.content.commands.Command;
import io.runescape.model.cycleevent.CycleEvent;
import io.runescape.model.cycleevent.CycleEventContainer;
import io.runescape.model.cycleevent.CycleEventHandler;
import io.runescape.model.entity.player.Player;

public class Loopgfx extends Command {

	@Override
	public void execute(Player player, String commandName, String input) {
		CycleEventHandler.getSingleton().addEvent(player, new CycleEvent() {
			int gfxid = 0;
			@Override
			public void execute(CycleEventContainer container) {
				if (player.isDisconnected()) {
					container.stop();
					return;
				}
				player.gfx0(gfxid);
				player.sendMessage("GfxID: " + gfxid);
				gfxid ++;
				if(gfxid > 2096) {
					container.stop();
				}
			}
			@Override
			public void onStopped() {

			}
		}, 3);
	}
}