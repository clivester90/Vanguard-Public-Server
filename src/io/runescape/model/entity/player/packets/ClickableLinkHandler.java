package io.runescape.model.entity.player.packets;

import io.runescape.Server;
import io.runescape.model.entity.npc.NPC;
import io.runescape.model.entity.npc.NPCHandler;
import io.runescape.model.entity.player.PacketType;
import io.runescape.model.entity.player.Player;

public class ClickableLinkHandler implements PacketType {

    @Override
    public void processPacket(Player player, int type, int size) {
        int npcIndex = player.getInStream().readUnsignedWord();
        if (npcIndex < 0 || npcIndex > NPCHandler.npcs.length)
            return;
        NPC npc = NPCHandler.npcs[npcIndex];
        if (npc  == null)
            return;

        if (npc.getDefinition().getCombatLevel() > 0) {
            player.sendMessage("Opening drops for: "+npc.getName()+"...");
            Server.getDropManager().openForPacket(player, npc.getNpcId());
        }
    }
}
