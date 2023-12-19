package io.runescape.model.entity.player.packets;

import io.runescape.model.entity.player.PacketType;
import io.runescape.model.entity.player.Player;

/**
 * Clicking in game
 **/
public class ClickingInGame implements PacketType {

	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		c.getInStream().readInteger(); // Packed integer containng mouse coordinates and click type
	}

}
