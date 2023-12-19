package io.runescape.model.multiplayersession.flowerpoker;

import io.runescape.model.Items;
import io.runescape.model.entity.player.Player;
import io.runescape.model.entity.player.lock.CompleteLock;

public class FlowerPokerLock extends CompleteLock {
    @Override
    public boolean cannotClickItem(Player player, int itemId) {
        if (itemId == Items.MITHRIL_SEEDS)
            return false;
        return true;
    }
}
