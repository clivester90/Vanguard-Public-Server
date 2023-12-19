package io.runescape.model.entity.player.packets;

import io.runescape.model.entity.player.PacketType;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

public class Report implements PacketType {

	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		String player = Misc.longToReportPlayerName(c.inStream.readQWord2()).replaceAll("_", " ");
		byte rule = (byte) c.inStream.readUnsignedByte();
	}

}