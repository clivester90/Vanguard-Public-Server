package io.runescape.content.bosses;

import io.runescape.content.instances.InstanceConfiguration;
import io.runescape.content.instances.impl.LegacySoloPlayerInstance;
import io.runescape.model.entity.player.Boundary;
import io.runescape.model.entity.player.Player;

/**
 * 
 * @author Grant_ | www.rune-server.ee/members/grant_ | 12/5/19
 *
 */
public class KrakenInstance extends LegacySoloPlayerInstance {

	public KrakenInstance(Player player, Boundary boundary) {
		super(InstanceConfiguration.CLOSE_ON_EMPTY_RESPAWN, player, boundary);
	}

	@Override
	public void onDispose() { }
}
