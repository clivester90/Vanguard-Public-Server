package io.runescape.content.bosses;

import io.runescape.content.instances.InstanceConfiguration;
import io.runescape.content.instances.impl.LegacySoloPlayerInstance;
import io.runescape.model.entity.player.Boundary;
import io.runescape.model.entity.player.Player;

/**
 * 
 * @author C.T for koranes
 *
 */
public class VoteBossInstance extends LegacySoloPlayerInstance {

	public VoteBossInstance(Player player, Boundary boundary) {
		super(InstanceConfiguration.CLOSE_ON_EMPTY_RESPAWN, player, boundary);
	}

	@Override
	public void onDispose() { }
}
