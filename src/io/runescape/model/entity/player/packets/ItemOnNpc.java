package io.runescape.model.entity.player.packets;

import java.util.Objects;

import io.runescape.Server;
import io.runescape.content.items.UseItem;
import io.runescape.model.cycleevent.CycleEvent;
import io.runescape.model.cycleevent.CycleEventContainer;
import io.runescape.model.cycleevent.CycleEventHandler;
import io.runescape.model.entity.npc.NPC;
import io.runescape.model.entity.npc.NPCHandler;
import io.runescape.model.entity.player.PacketType;
import io.runescape.model.entity.player.Player;
import io.runescape.model.multiplayersession.MultiplayerSessionFinalizeType;
import io.runescape.model.multiplayersession.MultiplayerSessionStage;
import io.runescape.model.multiplayersession.MultiplayerSessionType;
import io.runescape.model.multiplayersession.duel.DuelSession;

public class ItemOnNpc implements PacketType {

	@Override
	public void processPacket(Player c, int packetType, int packetSize) {
		if (c.getMovementState().isLocked() || c.getLock().cannotInteract(c))
			return;

		if (c.isFping()) {
			/**
			 * Cannot do action while fping
			 */
			return;
		}
		c.interruptActions();
		int itemId = c.getInStream().readSignedWordA();
		int npcIndex = c.getInStream().readSignedWordA();
		int slot = c.getInStream().readSignedWordBigEndian();

		if (npcIndex >= NPCHandler.npcs.length || npcIndex < 0)
			return;

		NPC npc = NPCHandler.npcs[npcIndex];

		if (npc == null)
			return;

		if (c.getInterfaceEvent().isActive()) {
			c.sendMessage("Please finish what you're doing.");
			return;
		}

		if (c.getBankPin().requiresUnlock()) {
			c.getBankPin().open(2);
			return;
		}

		DuelSession duelSession = (DuelSession) Server.getMultiplayerSessionListener().getMultiplayerSession(c, MultiplayerSessionType.DUEL);
		if (Objects.nonNull(duelSession) && duelSession.getStage().getStage() > MultiplayerSessionStage.REQUEST
				&& duelSession.getStage().getStage() < MultiplayerSessionStage.FURTHER_INTERATION) {
			c.sendMessage("Your actions have declined the duel.");
			duelSession.getOther(c).sendMessage("The challenger has declined the duel.");
			duelSession.finish(MultiplayerSessionFinalizeType.WITHDRAW_ITEMS);
			return;
		}

		if (npc.distance(c.getPosition()) <= 1) {
			completeItemOnNpc(c, npc, itemId, slot);
		} else {
			c.getPA().followNPC(npc, false);
			CycleEventHandler.getSingleton().addEvent(c, new CycleEvent() {
				@Override
				public void execute(CycleEventContainer container) {
					if (npc.distance(c.getPosition()) <= 1) {
						completeItemOnNpc(c, npc, itemId, slot);
						container.stop();
					}
				}

				@Override
				public void onStopped() {
					c.getPA().resetFollow();
				}
			}, 1);
		}
	}

	private void completeItemOnNpc(Player c, NPC npc, int itemId, int itemSlot) {
		c.facePosition(npc.getX(), npc.getY());
		npc.facePlayer(c.getIndex());
		c.faceUpdate(0);
		c.getPA().resetFollow();
		if (!c.getItems().playerHasItem(itemId, 1))
			return;
		UseItem.handleItemOnNPC(c, npc, itemId, itemSlot);
	}
}