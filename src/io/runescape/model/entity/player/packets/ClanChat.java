package io.runescape.model.entity.player.packets;

import io.runescape.model.entity.player.PacketType;
import io.runescape.model.entity.player.Player;
import io.runescape.util.Misc;

/**
 * Chat
 **/
public class ClanChat implements PacketType {

	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		String textSent = Misc.longToPlayerName2(c.getInStream().readLong());
		textSent = textSent.replaceAll("_", " ");
	}
}