package io.runescape.model.entity.player.packets;

import io.runescape.model.entity.player.PacketType;
import io.runescape.model.entity.player.Player;

public class MouseMovement implements PacketType {

	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		if (c.isIdle)
			c.isIdle = false;
		//c.sendMessage("Tits1");
	}
}